// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.digitaltwins.core.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The DigitalTwinsGetByIdHeaders model. */
@Fluent
public final class DigitalTwinsGetByIdHeaders {
    /*
     * The ETag property.
     */
    @JsonProperty(value = "ETag")
    private String eTag;

    /**
     * Get the eTag property: The ETag property.
     *
     * @return the eTag value.
     */
    public String getETag() {
        return this.eTag;
    }

    /**
     * Set the eTag property: The ETag property.
     *
     * @param eTag the eTag value to set.
     * @return the DigitalTwinsGetByIdHeaders object itself.
     */
    public DigitalTwinsGetByIdHeaders setETag(String eTag) {
        this.eTag = eTag;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() { }
}
