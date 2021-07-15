// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.resourcemanager.security.fluent.models.IoTSecurityAggregatedRecommendationInner;
import java.util.Map;

/** An immutable client-side representation of IoTSecurityAggregatedRecommendation. */
public interface IoTSecurityAggregatedRecommendation {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     *
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     *
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     *
     * @return the type value.
     */
    String type();

    /**
     * Gets the recommendationName property: Name of the recommendation.
     *
     * @return the recommendationName value.
     */
    String recommendationName();

    /**
     * Gets the recommendationDisplayName property: Display name of the recommendation type.
     *
     * @return the recommendationDisplayName value.
     */
    String recommendationDisplayName();

    /**
     * Gets the description property: Description of the suspected vulnerability and meaning.
     *
     * @return the description value.
     */
    String description();

    /**
     * Gets the recommendationTypeId property: Recommendation-type GUID.
     *
     * @return the recommendationTypeId value.
     */
    String recommendationTypeId();

    /**
     * Gets the detectedBy property: Name of the organization that made the recommendation.
     *
     * @return the detectedBy value.
     */
    String detectedBy();

    /**
     * Gets the remediationSteps property: Recommended steps for remediation.
     *
     * @return the remediationSteps value.
     */
    String remediationSteps();

    /**
     * Gets the reportedSeverity property: Assessed recommendation severity.
     *
     * @return the reportedSeverity value.
     */
    ReportedSeverity reportedSeverity();

    /**
     * Gets the healthyDevices property: Number of healthy devices within the IoT Security solution.
     *
     * @return the healthyDevices value.
     */
    Long healthyDevices();

    /**
     * Gets the unhealthyDeviceCount property: Number of unhealthy devices within the IoT Security solution.
     *
     * @return the unhealthyDeviceCount value.
     */
    Long unhealthyDeviceCount();

    /**
     * Gets the logAnalyticsQuery property: Log analytics query for getting the list of affected devices/alerts.
     *
     * @return the logAnalyticsQuery value.
     */
    String logAnalyticsQuery();

    /**
     * Gets the tags property: Resource tags.
     *
     * @return the tags value.
     */
    Map<String, String> tags();

    /**
     * Gets the inner com.azure.resourcemanager.security.fluent.models.IoTSecurityAggregatedRecommendationInner object.
     *
     * @return the inner object.
     */
    IoTSecurityAggregatedRecommendationInner innerModel();
}
