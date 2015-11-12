/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 * 
 * Code generated by Microsoft (R) AutoRest Code Generator 0.13.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.management.resources.models;

import com.microsoft.rest.BaseResource;

/**
 * Previewed feature information.
 */
public class FeatureProperties {
    /**
     * Gets or sets the state of the previewed feature.
     */
    private String state;

    /**
     * Get the state value.
     *
     * @return the state value
     */ 
    public String getState() {
        return this.state;
    }

    /**
     * Set the state value.
     *
     * @param state the state value to set
     */
    public void setState(String state) {
        this.state = state;
    }

}
