// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.postgresqlflexibleserver.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for ConfigurationDataType. */
public final class ConfigurationDataType extends ExpandableStringEnum<ConfigurationDataType> {
    /** Static value Boolean for ConfigurationDataType. */
    public static final ConfigurationDataType BOOLEAN = fromString("Boolean");

    /** Static value Numeric for ConfigurationDataType. */
    public static final ConfigurationDataType NUMERIC = fromString("Numeric");

    /** Static value Integer for ConfigurationDataType. */
    public static final ConfigurationDataType INTEGER = fromString("Integer");

    /** Static value Enumeration for ConfigurationDataType. */
    public static final ConfigurationDataType ENUMERATION = fromString("Enumeration");

    /**
     * Creates or finds a ConfigurationDataType from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding ConfigurationDataType.
     */
    @JsonCreator
    public static ConfigurationDataType fromString(String name) {
        return fromString(name, ConfigurationDataType.class);
    }

    /** @return known ConfigurationDataType values. */
    public static Collection<ConfigurationDataType> values() {
        return values(ConfigurationDataType.class);
    }
}
