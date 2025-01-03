// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.identity.extensions.implementation.credential.provider;

import com.azure.core.credential.TokenCredential;
import com.azure.identity.extensions.implementation.credential.TokenCredentialProviderOptions;

/**
 * Default tokenCredentialProvider implementation that provides tokenCredential instance.
 */
public class DefaultTokenCredentialProvider implements TokenCredentialProvider {

    private final TokenCredential tokenCredential;

    DefaultTokenCredentialProvider() {
        this(new TokenCredentialProviderOptions());
    }

    DefaultTokenCredentialProvider(TokenCredentialProviderOptions options) {
        this.tokenCredential = get(options);
    }

    @Override
    public TokenCredential get() {
        return tokenCredential;
    }

    @Override
    public TokenCredential get(TokenCredentialProviderOptions options) {
        return resolveTokenCredential(options);
    }
}
