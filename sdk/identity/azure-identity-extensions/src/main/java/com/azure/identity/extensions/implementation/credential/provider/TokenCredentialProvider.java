// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.identity.extensions.implementation.credential.provider;

import com.azure.core.credential.TokenCredential;
import com.azure.identity.ClientCertificateCredentialBuilder;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.identity.ManagedIdentityCredentialBuilder;
import com.azure.identity.UsernamePasswordCredentialBuilder;
import com.azure.identity.extensions.implementation.credential.TokenCredentialProviderOptions;

import java.util.function.Supplier;

import static com.azure.identity.extensions.implementation.utils.StringUtils.hasText;

/**
 * Interface to be implemented by classes that wish to provide the {@link TokenCredential}.
 */
@FunctionalInterface
public interface TokenCredentialProvider extends Supplier<TokenCredential> {

    default TokenCredential get(TokenCredentialProviderOptions options) {
        return get();
    }

    /**
     * Create TokenCredentialProvider instance
     * @param options Used by {@link TokenCredentialProvider} to create {@link TokenCredentialProvider} instance.
     * @return TokenCredentialProvider instance.
     */
    static TokenCredentialProvider createDefault(TokenCredentialProviderOptions options) {
        return TokenCredentialProviders.createInstance(options);
    }

    /**
     * Resolve a {@link TokenCredential} instance via {@link TokenCredentialProviderOptions}.
     * @param options Used by {@link TokenCredentialProvider} to create {@link TokenCredentialProvider} instance.
     * @return TokenCredential instance.
     */
    default TokenCredential resolveTokenCredential(TokenCredentialProviderOptions options) {
        if (options == null) {
            return new DefaultAzureCredentialBuilder().build();
        }

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
                ClientCertificateCredentialBuilder builder
                    = new ClientCertificateCredentialBuilder().authorityHost(authorityHost)
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

        if (isClientIdSet && hasText(options.getUsername()) && hasText(options.getPassword())) {
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

        return new DefaultAzureCredentialBuilder().authorityHost(authorityHost)
                                                  .tenantId(tenantId)
                                                  .managedIdentityClientId(clientId)
                                                  .build();
    }
}
