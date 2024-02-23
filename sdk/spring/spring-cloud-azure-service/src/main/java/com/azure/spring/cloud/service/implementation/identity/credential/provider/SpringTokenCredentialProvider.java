// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.cloud.service.implementation.identity.credential.provider;

import com.azure.core.credential.TokenCredential;
import com.azure.identity.extensions.implementation.credential.TokenCredentialProviderOptions;
import com.azure.identity.extensions.implementation.credential.provider.TokenCredentialProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Objects;

/**
 * TokenCredentialProvider contains spring context.
 */
public class SpringTokenCredentialProvider implements TokenCredentialProvider, ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringTokenCredentialProvider.class);

    public static final String DEFAULT_TOKEN_CREDENTIAL_BEAN_NAME = "springCloudAzureDefaultCredential";
    public static final String PASSWORDLESS_TOKEN_CREDENTIAL_BEAN_NAME = "passwordlessTokenCredential";
    private static ApplicationContext globalApplicationContext;
    private ApplicationContext applicationContext;
    private String tokenCredentialBeanName = DEFAULT_TOKEN_CREDENTIAL_BEAN_NAME;

    public SpringTokenCredentialProvider(TokenCredentialProviderOptions options) {
        String beanName = options == null ? null : options.getTokenCredentialBeanName();
        if (beanName != null && !beanName.isEmpty()) {
            LOGGER.debug("Token credential bean name: {}", beanName);
            this.tokenCredentialBeanName = beanName;
        }
        LOGGER.debug("SpringTokenCredentialProvider initialized. - {}", this.tokenCredentialBeanName);
    }

    public TokenCredential get() {
        ApplicationContext context = getApplicationContext();
        Objects.requireNonNull(context);
        LOGGER.debug("Get bean credential bean: {}", tokenCredentialBeanName);
        TokenCredential tokenCredential = context.getBean(this.tokenCredentialBeanName, TokenCredential.class);
        LOGGER.debug("SpringTokenCredentialProvider get token credential. - {}, {}", tokenCredential, tokenCredential.getClass());
        return tokenCredential;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static void setGlobalApplicationContext(ApplicationContext applicationContext) {
        globalApplicationContext = applicationContext;
        LOGGER.debug("Set global application context.");
    }

    private ApplicationContext getApplicationContext() {
        return this.applicationContext == null ? globalApplicationContext : this.applicationContext;
    }
}
