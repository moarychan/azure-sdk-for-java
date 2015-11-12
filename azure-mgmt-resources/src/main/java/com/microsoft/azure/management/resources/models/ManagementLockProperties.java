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
 * The management lock properties.
 */
public class ManagementLockProperties {
    /**
     * Gets or sets the lock level of the management lock. Possible values for
     * this property include: 'NotSpecified', 'CanNotDelete', 'ReadOnly'.
     */
    private String level;

    /**
     * Gets or sets the notes of the management lock.
     */
    private String notes;

    /**
     * Get the level value.
     *
     * @return the level value
     */ 
    public String getLevel() {
        return this.level;
    }

    /**
     * Set the level value.
     *
     * @param level the level value to set
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * Get the notes value.
     *
     * @return the notes value
     */ 
    public String getNotes() {
        return this.notes;
    }

    /**
     * Set the notes value.
     *
     * @param notes the notes value to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

}
