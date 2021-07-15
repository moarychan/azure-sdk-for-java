// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.implementation;

import com.azure.resourcemanager.security.fluent.models.AdaptiveApplicationControlGroupInner;
import com.azure.resourcemanager.security.fluent.models.AdaptiveApplicationControlGroupsInner;
import com.azure.resourcemanager.security.models.AdaptiveApplicationControlGroup;
import com.azure.resourcemanager.security.models.AdaptiveApplicationControlGroups;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class AdaptiveApplicationControlGroupsImpl implements AdaptiveApplicationControlGroups {
    private AdaptiveApplicationControlGroupsInner innerObject;

    private final com.azure.resourcemanager.security.SecurityManager serviceManager;

    AdaptiveApplicationControlGroupsImpl(
        AdaptiveApplicationControlGroupsInner innerObject,
        com.azure.resourcemanager.security.SecurityManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public List<AdaptiveApplicationControlGroup> value() {
        List<AdaptiveApplicationControlGroupInner> inner = this.innerModel().value();
        if (inner != null) {
            return Collections
                .unmodifiableList(
                    inner
                        .stream()
                        .map(inner1 -> new AdaptiveApplicationControlGroupImpl(inner1, this.manager()))
                        .collect(Collectors.toList()));
        } else {
            return Collections.emptyList();
        }
    }

    public AdaptiveApplicationControlGroupsInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.security.SecurityManager manager() {
        return this.serviceManager;
    }
}
