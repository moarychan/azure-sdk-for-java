// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

<<<<<<<< HEAD:sdk/spring/spring-messaging-azure/src/main/java/com/azure/spring/messaging/checkpoint/CheckpointMode.java
package com.azure.spring.messaging.checkpoint;
========
package com.azure.spring.messaging.eventhubs.core.checkpoint;
>>>>>>>> 8bfecc214455d60acc81bbca1ae64aa01694e58e:sdk/spring/spring-messaging-azure-eventhubs/src/main/java/com/azure/spring/messaging/eventhubs/core/checkpoint/CheckpointMode.java

import com.azure.spring.messaging.ListenerMode;

/**
 * The offset commit behavior enumeration.
 */
public enum CheckpointMode {

    /**
     * Checkpoint after each processed record.
     * Makes sense only if {@link ListenerMode#RECORD} is used.
     */
    RECORD,

    /**
     * Checkpoint after each processed batch of records.
     */
    BATCH,

    /**
     * User decide when to checkpoint manually
     */
    MANUAL,

    /**
     * Checkpoint once for number of message specified by {@link CheckpointConfig#getCount()} ()}
     * in each partition
     */
    PARTITION_COUNT,

    /**
     * Checkpoint once for each time interval specified by {@link CheckpointConfig#getInterval()} ()}
     */
    TIME,
}
