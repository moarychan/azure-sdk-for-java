package com.azure.identity.extensions.implementation.utils;

import com.azure.identity.extensions.implementation.credential.TokenCredentialProviderOptions;
import com.azure.identity.extensions.implementation.credential.provider.CacheTokenCredentialProvider;
import com.azure.identity.extensions.implementation.token.AccessTokenResolverCacheImpl;
import com.azure.identity.extensions.implementation.token.AccessTokenResolverOptions;
import reactor.util.annotation.Nullable;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * String utility methods.
 */
public final class StringUtils {

    private StringUtils() {

    }

    /**
     * Check whether the given CharSequence contains actual text.
     * @param str the CharSequence to check
     * @return true if the String not null and the length is more than 1.
     */
    public static boolean hasText(@Nullable String str) {
        return (str != null && !str.isEmpty() && containsText(str));
    }

    /**
     * Get the cache key of a TokenCredential instance from the TokenCredentialProviderOptions.
     * @param options the token credential provider option.
     * @return the union cache key.
     */
    public static String getTokenCredentialCacheKey(TokenCredentialProviderOptions options) {
        if (options == null) {
            return CacheTokenCredentialProvider.class.getSimpleName();
        }

        return joinOptions(options.getTenantId(), options.getClientId(), options.getClientCertificatePath(),
            options.getUsername(), String.valueOf(options.isManagedIdentityEnabled()),
            options.getTokenCredentialProviderClassName(), options.getTokenCredentialBeanName());
    }

    /**
     * Get the cache key of a AccessToken instance from the AccessTokenResolverOptions.
     * @param options the access token resolver option.
     * @return the union cache key.
     */
    public static String getAccessTokenCacheKey(AccessTokenResolverOptions options) {
        if (options == null) {
            return AccessTokenResolverCacheImpl.class.getSimpleName();
        }

        return joinOptions(options.getTenantId(), options.getClaims(), String.join("-", options.getScopes()));
    }

    private static boolean containsText(CharSequence str) {
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static String joinOptions(String... options) {
        return Arrays.stream(options).map(StringUtils::nonNullOption).collect(Collectors.joining(","));
    }

    private static String nonNullOption(String option) {
        return option == null ? "" : option;
    }
}
