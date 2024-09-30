package com.azure.spring.cloud.autoconfigure.jdbc;

import com.azure.core.credential.TokenCredential;
import com.azure.identity.extensions.implementation.enums.AuthProperty;
import java.util.Map;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.util.StringUtils;
import static com.azure.spring.cloud.service.implementation.identity.credential.provider.SpringTokenCredentialProvider.PASSWORDLESS_TOKEN_CREDENTIAL_BEAN_NAME;

public abstract class DataSourcePropertiesTokenCredentialConfigurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourcePropertiesTokenCredentialConfigurer.class);
    private final GenericApplicationContext applicationContext;
    private DataSourceProperties dataSourceProperties;
    private String tokenCredentialBeanName;

    public DataSourcePropertiesTokenCredentialConfigurer(GenericApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public boolean isCurrentDatasource() {
        return true;
    }

    public abstract TokenCredential tokenCredential();

    public DataSourceProperties getDataSourceProperties() {
        return dataSourceProperties;
    }

    public GenericApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void generateUniqueTokenCredentialBeanName() {
        if (!StringUtils.hasText(tokenCredentialBeanName)) {
            tokenCredentialBeanName = PASSWORDLESS_TOKEN_CREDENTIAL_BEAN_NAME + "_" + UUID.randomUUID();
            if (StringUtils.hasText(dataSourceProperties.getUsername())) {
                tokenCredentialBeanName += "_" + dataSourceProperties.getUsername();
            }
        }
    }

    public void configure(DataSourceProperties dataSourceProperties, Map<String, String> enhancedProperties) {
        this.dataSourceProperties = dataSourceProperties;
        if (isCurrentDatasource()) {
            generateUniqueTokenCredentialBeanName();
            TokenCredential tokenCredential = this.tokenCredential();
            applicationContext.registerBean(tokenCredentialBeanName, TokenCredential.class, () -> tokenCredential);
            LOGGER.debug("Register an independent {} bean '{}'.",
                TokenCredential.class.getSimpleName(), tokenCredentialBeanName);
            AuthProperty.TOKEN_CREDENTIAL_BEAN_NAME.setProperty(enhancedProperties, tokenCredentialBeanName);
        }
    }
}
