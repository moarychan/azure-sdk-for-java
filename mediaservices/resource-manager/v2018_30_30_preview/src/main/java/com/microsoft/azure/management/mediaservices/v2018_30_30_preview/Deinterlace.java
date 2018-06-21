/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.mediaservices.v2018_30_30_preview;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes the de-interlacing settings.
 */
public class Deinterlace {
    /**
     * The field parity for de-interlacing, defaults to Auto. Possible values
     * include: 'Auto', 'TopFieldFirst', 'BottomFieldFirst'.
     */
    @JsonProperty(value = "parity")
    private DeinterlaceParity parity;

    /**
     * The deinterlacing mode. Defaults to AutoPixelAdaptive. Possible values
     * include: 'Off', 'AutoPixelAdaptive'.
     */
    @JsonProperty(value = "mode")
    private DeinterlaceMode mode;

    /**
     * Get the field parity for de-interlacing, defaults to Auto. Possible values include: 'Auto', 'TopFieldFirst', 'BottomFieldFirst'.
     *
     * @return the parity value
     */
    public DeinterlaceParity parity() {
        return this.parity;
    }

    /**
     * Set the field parity for de-interlacing, defaults to Auto. Possible values include: 'Auto', 'TopFieldFirst', 'BottomFieldFirst'.
     *
     * @param parity the parity value to set
     * @return the Deinterlace object itself.
     */
    public Deinterlace withParity(DeinterlaceParity parity) {
        this.parity = parity;
        return this;
    }

    /**
     * Get the deinterlacing mode. Defaults to AutoPixelAdaptive. Possible values include: 'Off', 'AutoPixelAdaptive'.
     *
     * @return the mode value
     */
    public DeinterlaceMode mode() {
        return this.mode;
    }

    /**
     * Set the deinterlacing mode. Defaults to AutoPixelAdaptive. Possible values include: 'Off', 'AutoPixelAdaptive'.
     *
     * @param mode the mode value to set
     * @return the Deinterlace object itself.
     */
    public Deinterlace withMode(DeinterlaceMode mode) {
        this.mode = mode;
        return this;
    }

}
