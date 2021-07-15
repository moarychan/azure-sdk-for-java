// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.postgresql;

/** Samples for Configurations CreateOrUpdate. */
public final class ConfigurationsCreateOrUpdateSamples {
    /**
     * Sample code: ConfigurationCreateOrUpdate.
     *
     * @param postgreSqlManager Entry point to PostgreSqlManager. The Microsoft Azure management API provides create,
     *     read, update, and delete functionality for Azure PostgreSQL resources including servers, databases, firewall
     *     rules, VNET rules, security alert policies, log files and configurations with new business model.
     */
    public static void configurationCreateOrUpdate(
        com.azure.resourcemanager.postgresql.PostgreSqlManager postgreSqlManager) {
        postgreSqlManager
            .configurations()
            .define("array_nulls")
            .withExistingServer("TestGroup", "testserver")
            .withValue("off")
            .withSource("user-override")
            .create();
    }
}
