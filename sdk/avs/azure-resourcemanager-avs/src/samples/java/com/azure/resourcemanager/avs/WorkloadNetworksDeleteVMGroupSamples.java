// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.avs;

import com.azure.core.util.Context;

/** Samples for WorkloadNetworks DeleteVMGroup. */
public final class WorkloadNetworksDeleteVMGroupSamples {
    /**
     * Sample code: WorkloadNetworks_DeleteVMGroup.
     *
     * @param avsManager Entry point to AvsManager. Azure VMware Solution API.
     */
    public static void workloadNetworksDeleteVMGroup(com.azure.resourcemanager.avs.AvsManager avsManager) {
        avsManager.workloadNetworks().deleteVMGroup("group1", "vmGroup1", "cloud1", Context.NONE);
    }
}
