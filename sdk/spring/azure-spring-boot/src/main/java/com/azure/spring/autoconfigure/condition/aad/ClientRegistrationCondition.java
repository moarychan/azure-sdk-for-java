// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.autoconfigure.condition.aad;

import com.azure.spring.aad.AADApplicationType;
import com.azure.spring.autoconfigure.aad.AADAuthenticationProperties;
import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * Web application, web resource server or all in scenario condition.
 */
public final class ClientRegistrationCondition extends SpringBootCondition {

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConditionMessage.Builder message = ConditionMessage.forCondition(
            "AAD Application Client Condition");
        AADAuthenticationProperties properties = Binder.get(context.getEnvironment())
                                                       .bind("azure.activedirectory",
                                                           AADAuthenticationProperties.class)
                                                       .orElse(null);
        if (properties == null) {
            return ConditionOutcome.noMatch(message.notAvailable("aad authorization properties"));
        }

        if (!StringUtils.hasText(properties.getClientId())) {
            return ConditionOutcome.noMatch(message.didNotFind("client-id").atAll());
        }

        // Bind properties will not execute AADAuthenticationProperties#afterPropertiesSet()
        AADApplicationType applicationType = Optional.ofNullable(properties.getApplicationType())
                                                     .orElseGet(AADApplicationType::inferApplicationTypeByDependencies);
        if (applicationType == null) {
            return ConditionOutcome.noMatch(message.because("Not found the AAD application type."));
        }

        StringBuilder details = new StringBuilder();
        switch (applicationType) {
            case WEB_APPLICATION:
                details.append("classes EnableWebSecurity and ClientRegistration, "
                    + "or property 'azure.activedirectory.application-type=web_application'");
                break;
            case RESOURCE_SERVER_WITH_OBO:
                details.append("classes EnableWebSecurity, ClientRegistration and BearerTokenAuthenticationToken, "
                    + "or property 'azure.activedirectory.application-type=resource_server_with_obo'");
                break;
            case WEB_APPLICATION_AND_RESOURCE_SERVER:
                details.append("classes EnableWebSecurity, ClientRegistration and BearerTokenAuthenticationToken "
                    + "and property 'azure.activedirectory.application-type=web_application_and_resource_server'");
                break;
            default:
                return ConditionOutcome.noMatch(
                    message.didNotFind("necessary dependencies")
                           .items("classes EnableWebSecurity, ClientRegistration and BearerTokenAuthenticationToken",
                               "property 'azure.activedirectory.application-type'"));
        }
        return ConditionOutcome.match(message.foundExactly(details.toString()));
    }
}
