/*
 * Copyright 2012-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.azure.spring.cloud.autoconfigure.aad.implementation.oauth2;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.boot.web.client.RestTemplateRequestCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

import static com.azure.spring.cloud.autoconfigure.context.AzureContextUtils.REST_TEMPLATE_BUILDER_BEAN_NAME;
import static com.azure.spring.cloud.autoconfigure.context.AzureContextUtils.REST_TEMPLATE_CONFIGURER_BEAN_NAME;

@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(RestTemplate.class)
@AutoConfigureAfter(HttpMessageConvertersAutoConfiguration.class)
public class RestTemplateAutoConfiguration {

	@Bean
    @ConditionalOnMissingBean(name = REST_TEMPLATE_CONFIGURER_BEAN_NAME)
	public AzureRestTemplateBuilderConfigurer springCloudAzureRestTemplateConfigurer(
			ObjectProvider<RestTemplateCustomizer> restTemplateCustomizers,
			ObjectProvider<RestTemplateRequestCustomizer<?>> restTemplateRequestCustomizers) {
        AzureRestTemplateBuilderConfigurer configurer = new AzureRestTemplateBuilderConfigurer();

        configurer.setHttpMessageConverters(new HttpMessageConverters());
		configurer.setRestTemplateCustomizers(restTemplateCustomizers.orderedStream().collect(Collectors.toList()));
		configurer.setRestTemplateRequestCustomizers(
				restTemplateRequestCustomizers.orderedStream().collect(Collectors.toList()));
		return configurer;
	}

	@Bean(name = REST_TEMPLATE_BUILDER_BEAN_NAME)
    @ConditionalOnMissingBean(name = REST_TEMPLATE_BUILDER_BEAN_NAME)
	public RestTemplateBuilder springCloudAzureRestTemplateBuilder(
        @Qualifier(REST_TEMPLATE_CONFIGURER_BEAN_NAME) AzureRestTemplateBuilderConfigurer springCloudAzureRestTemplateConfigurer) {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        return springCloudAzureRestTemplateConfigurer.configure(restTemplateBuilder);
	}
}
