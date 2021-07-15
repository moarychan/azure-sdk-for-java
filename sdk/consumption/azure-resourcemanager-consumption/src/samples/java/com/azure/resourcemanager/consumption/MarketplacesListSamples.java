// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.consumption;

import com.azure.core.util.Context;

/** Samples for Marketplaces List. */
public final class MarketplacesListSamples {
    /**
     * Sample code: BillingAccountMarketplacesListForBillingPeriod.
     *
     * @param consumptionManager Entry point to ConsumptionManager. Consumption management client provides access to
     *     consumption resources for Azure Enterprise Subscriptions.
     */
    public static void billingAccountMarketplacesListForBillingPeriod(
        com.azure.resourcemanager.consumption.ConsumptionManager consumptionManager) {
        consumptionManager
            .marketplaces()
            .list("providers/Microsoft.Billing/billingAccounts/123456", null, null, null, Context.NONE);
    }

    /**
     * Sample code: EnrollmentAccountMarketplacesListForBillingPeriod.
     *
     * @param consumptionManager Entry point to ConsumptionManager. Consumption management client provides access to
     *     consumption resources for Azure Enterprise Subscriptions.
     */
    public static void enrollmentAccountMarketplacesListForBillingPeriod(
        com.azure.resourcemanager.consumption.ConsumptionManager consumptionManager) {
        consumptionManager
            .marketplaces()
            .list("providers/Microsoft.Billing/enrollmentAccounts/123456", null, null, null, Context.NONE);
    }

    /**
     * Sample code: SubscriptionMarketplacesList.
     *
     * @param consumptionManager Entry point to ConsumptionManager. Consumption management client provides access to
     *     consumption resources for Azure Enterprise Subscriptions.
     */
    public static void subscriptionMarketplacesList(
        com.azure.resourcemanager.consumption.ConsumptionManager consumptionManager) {
        consumptionManager
            .marketplaces()
            .list("subscriptions/00000000-0000-0000-0000-000000000000", null, null, null, Context.NONE);
    }

    /**
     * Sample code: EnrollmentAccountMarketplacesList.
     *
     * @param consumptionManager Entry point to ConsumptionManager. Consumption management client provides access to
     *     consumption resources for Azure Enterprise Subscriptions.
     */
    public static void enrollmentAccountMarketplacesList(
        com.azure.resourcemanager.consumption.ConsumptionManager consumptionManager) {
        consumptionManager
            .marketplaces()
            .list("providers/Microsoft.Billing/enrollmentAccounts/123456", null, null, null, Context.NONE);
    }

    /**
     * Sample code: DepartmentMarketplacesListForBillingPeriod.
     *
     * @param consumptionManager Entry point to ConsumptionManager. Consumption management client provides access to
     *     consumption resources for Azure Enterprise Subscriptions.
     */
    public static void departmentMarketplacesListForBillingPeriod(
        com.azure.resourcemanager.consumption.ConsumptionManager consumptionManager) {
        consumptionManager
            .marketplaces()
            .list("providers/Microsoft.Billing/departments/123456", null, null, null, Context.NONE);
    }

    /**
     * Sample code: ManagementGroupMarketplacesList.
     *
     * @param consumptionManager Entry point to ConsumptionManager. Consumption management client provides access to
     *     consumption resources for Azure Enterprise Subscriptions.
     */
    public static void managementGroupMarketplacesList(
        com.azure.resourcemanager.consumption.ConsumptionManager consumptionManager) {
        consumptionManager
            .marketplaces()
            .list("subscriptions/00000000-0000-0000-0000-000000000000", null, null, null, Context.NONE);
    }

    /**
     * Sample code: SubscriptionMarketplacesListForBillingPeriod.
     *
     * @param consumptionManager Entry point to ConsumptionManager. Consumption management client provides access to
     *     consumption resources for Azure Enterprise Subscriptions.
     */
    public static void subscriptionMarketplacesListForBillingPeriod(
        com.azure.resourcemanager.consumption.ConsumptionManager consumptionManager) {
        consumptionManager
            .marketplaces()
            .list("subscriptions/00000000-0000-0000-0000-000000000000", null, null, null, Context.NONE);
    }

    /**
     * Sample code: DepartmentMarketplacesList.
     *
     * @param consumptionManager Entry point to ConsumptionManager. Consumption management client provides access to
     *     consumption resources for Azure Enterprise Subscriptions.
     */
    public static void departmentMarketplacesList(
        com.azure.resourcemanager.consumption.ConsumptionManager consumptionManager) {
        consumptionManager
            .marketplaces()
            .list("providers/Microsoft.Billing/departments/123456", null, null, null, Context.NONE);
    }

    /**
     * Sample code: ManagementGroupMarketplacesListForBillingPeriod.
     *
     * @param consumptionManager Entry point to ConsumptionManager. Consumption management client provides access to
     *     consumption resources for Azure Enterprise Subscriptions.
     */
    public static void managementGroupMarketplacesListForBillingPeriod(
        com.azure.resourcemanager.consumption.ConsumptionManager consumptionManager) {
        consumptionManager
            .marketplaces()
            .list("subscriptions/00000000-0000-0000-0000-000000000000", null, null, null, Context.NONE);
    }

    /**
     * Sample code: BillingAccountMarketplacesList.
     *
     * @param consumptionManager Entry point to ConsumptionManager. Consumption management client provides access to
     *     consumption resources for Azure Enterprise Subscriptions.
     */
    public static void billingAccountMarketplacesList(
        com.azure.resourcemanager.consumption.ConsumptionManager consumptionManager) {
        consumptionManager
            .marketplaces()
            .list("providers/Microsoft.Billing/billingAccounts/123456", null, null, null, Context.NONE);
    }
}
