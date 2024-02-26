// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.identity.extensions.implementation.credential.provider;

import com.azure.core.credential.TokenCredential;
import com.azure.core.util.logging.ClientLogger;
import com.azure.identity.ClientCertificateCredentialBuilder;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.identity.ManagedIdentityCredentialBuilder;
import com.azure.identity.UsernamePasswordCredentialBuilder;
import com.azure.identity.extensions.implementation.credential.TokenCredentialProviderOptions;
import reactor.util.annotation.Nullable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Default tokenCredentialProvider implementation that provides tokenCredential instance.
 */
public class DefaultTokenCredentialProvider implements TokenCredentialProvider {

    private static final ClientLogger LOGGER = new ClientLogger(DefaultTokenCredentialProvider.class);

    private final TokenCredentialProviderOptions options;

    private final TokenCredential tokenCredential;

    DefaultTokenCredentialProvider() {
        this.options = new TokenCredentialProviderOptions();
        this.tokenCredential = get(this.options);
        LOGGER.verbose("DefaultTokenCredentialProvider 1 create token credential. - {}, {}", this.tokenCredential, this.tokenCredential.getClass());
    }

    DefaultTokenCredentialProvider(TokenCredentialProviderOptions options) {
        this.options = options;
        this.tokenCredential = get(this.options);
        LOGGER.verbose("DefaultTokenCredentialProvider 2 create token credential. - {}, {}", this.tokenCredential, this.tokenCredential.getClass());
    }

    @Override
    public TokenCredential get() {
        LOGGER.verbose("tokenCredential class name - {}", tokenCredential.getClass());
        return tokenCredential;
    }

    @Override
    public TokenCredential get(TokenCredentialProviderOptions options) {
        if (options == null) {
            LOGGER.verbose("options is null, create dac builder to build token credential.");
            return new DefaultAzureCredentialBuilder().build();
        }
        return resolveTokenCredential(options);
    }

    private TokenCredential resolveTokenCredential(TokenCredentialProviderOptions options) {
        final String tenantId = options.getTenantId();
        final String clientId = options.getClientId();
        final boolean isClientIdSet = hasText(clientId);
        final String authorityHost = options.getAuthorityHost();
        if (hasText(tenantId)) {
            String clientSecret = options.getClientSecret();
            if (isClientIdSet && hasText(clientSecret)) {
                return new ClientSecretCredentialBuilder().clientId(clientId)
                        .authorityHost(authorityHost)
                        .clientSecret(clientSecret)
                        .tenantId(tenantId)
                        .build();
            }

            String clientCertificatePath = options.getClientCertificatePath();
            if (isClientIdSet && hasText(clientCertificatePath)) {
                ClientCertificateCredentialBuilder builder = new ClientCertificateCredentialBuilder()
                        .authorityHost(authorityHost)
                        .tenantId(tenantId)
                        .clientId(clientId);

                if (hasText(options.getClientCertificatePassword())) {
                    builder.pfxCertificate(clientCertificatePath, options.getClientCertificatePassword());
                } else {
                    builder.pemCertificate(clientCertificatePath);
                }

                return builder.build();
            }
        }

        if (isClientIdSet && hasText(options.getUsername())
                && hasText(options.getPassword())) {
            return new UsernamePasswordCredentialBuilder().username(options.getUsername())
                    .authorityHost(authorityHost)
                    .password(options.getPassword())
                    .clientId(clientId)
                    .tenantId(tenantId)
                    .build();
        }

        if (options.isManagedIdentityEnabled()) {
            ManagedIdentityCredentialBuilder builder = new ManagedIdentityCredentialBuilder();
            if (isClientIdSet) {
                builder.clientId(clientId);
            }
            return builder.build();
        }

        LOGGER.verbose("Use the dac builder.");
        ExecutorService executorService = Executors.newFixedThreadPool(1, new ThreadFactory() {

            private int count = 0;

            @Override
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "az-id-test-" + count++);
            }
        });

        return new DefaultAzureCredentialBuilder()
                .authorityHost(authorityHost)
                .tenantId(tenantId)
                .managedIdentityClientId(clientId)
                .executorService(executorService)
                .build();
    }

    private boolean hasText(@Nullable String str) {
        return (str != null && !str.isEmpty() && containsText(str));
    }

    private boolean containsText(CharSequence str) {
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
