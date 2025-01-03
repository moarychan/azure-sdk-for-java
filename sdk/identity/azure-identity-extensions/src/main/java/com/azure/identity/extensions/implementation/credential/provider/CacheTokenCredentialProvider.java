// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.identity.extensions.implementation.credential.provider;

import com.azure.core.credential.TokenCredential;
import com.azure.core.util.logging.ClientLogger;
import com.azure.identity.extensions.implementation.credential.TokenCredentialProviderOptions;

import java.util.concurrent.ConcurrentHashMap;

import static com.azure.identity.extensions.implementation.utils.StringUtils.getTokenCredentialCacheKey;

/**
 * Cache token credential provider implementation that provides a tokenCredential instance and cache it.
 */
public class CacheTokenCredentialProvider implements TokenCredentialProvider {

    private static final ClientLogger LOGGER = new ClientLogger(CacheTokenCredentialProvider.class);

    private static final ConcurrentHashMap<String, TokenCredential> CACHE = new ConcurrentHashMap<>();

    private final TokenCredential tokenCredential;

    CacheTokenCredentialProvider() {
        this(new TokenCredentialProviderOptions());
    }

    CacheTokenCredentialProvider(TokenCredentialProviderOptions options) {
        this.tokenCredential = get(options);
    }

    @Override
    public TokenCredential get() {
        return tokenCredential;
    }

    @Override
    public TokenCredential get(TokenCredentialProviderOptions options) {
        String tokenCredentialCacheKey = getTokenCredentialCacheKey(options);
        TokenCredential credential = CACHE.get(tokenCredentialCacheKey);
        if (credential != null) {
            LOGGER.verbose("Returning token credential from cache.");
            return credential;
        }

        credential = resolveTokenCredential(options);
        CACHE.put(tokenCredentialCacheKey, credential);
        LOGGER.verbose("The token credential cached.");
        return credential;
    }
}
