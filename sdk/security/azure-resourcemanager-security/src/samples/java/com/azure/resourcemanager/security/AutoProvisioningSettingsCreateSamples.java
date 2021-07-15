// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security;

import com.azure.resourcemanager.security.models.AutoProvision;

/** Samples for AutoProvisioningSettings Create. */
public final class AutoProvisioningSettingsCreateSamples {
    /**
     * Sample code: Create auto provisioning settings for subscription.
     *
     * @param securityManager Entry point to SecurityManager. API spec for Microsoft.Security (Azure Security Center)
     *     resource provider.
     */
    public static void createAutoProvisioningSettingsForSubscription(
        com.azure.resourcemanager.security.SecurityManager securityManager) {
        securityManager.autoProvisioningSettings().define("default").withAutoProvision(AutoProvision.ON).create();
    }
}
