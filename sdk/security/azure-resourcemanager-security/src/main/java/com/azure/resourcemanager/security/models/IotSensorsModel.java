// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.StreamResponse;
import com.azure.core.util.Context;
import com.azure.resourcemanager.security.fluent.models.IotSensorsModelInner;
import java.io.InputStream;

/** An immutable client-side representation of IotSensorsModel. */
public interface IotSensorsModel {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     *
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     *
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     *
     * @return the type value.
     */
    String type();

    /**
     * Gets the connectivityTime property: Last connectivity time of the IoT sensor.
     *
     * @return the connectivityTime value.
     */
    String connectivityTime();

    /**
     * Gets the creationTime property: Creation time of the IoT sensor.
     *
     * @return the creationTime value.
     */
    String creationTime();

    /**
     * Gets the dynamicLearning property: Dynamic mode status of the IoT sensor.
     *
     * @return the dynamicLearning value.
     */
    Boolean dynamicLearning();

    /**
     * Gets the learningMode property: Learning mode status of the IoT sensor.
     *
     * @return the learningMode value.
     */
    Boolean learningMode();

    /**
     * Gets the sensorStatus property: Status of the IoT sensor.
     *
     * @return the sensorStatus value.
     */
    SensorStatus sensorStatus();

    /**
     * Gets the sensorVersion property: Version of the IoT sensor.
     *
     * @return the sensorVersion value.
     */
    String sensorVersion();

    /**
     * Gets the tiAutomaticUpdates property: TI Automatic mode status of the IoT sensor.
     *
     * @return the tiAutomaticUpdates value.
     */
    Boolean tiAutomaticUpdates();

    /**
     * Gets the tiStatus property: TI Status of the IoT sensor.
     *
     * @return the tiStatus value.
     */
    TiStatus tiStatus();

    /**
     * Gets the tiVersion property: TI Version of the IoT sensor.
     *
     * @return the tiVersion value.
     */
    String tiVersion();

    /**
     * Gets the zone property: Zone of the IoT sensor.
     *
     * @return the zone value.
     */
    String zone();

    /**
     * Gets the sensorType property: Type of sensor.
     *
     * @return the sensorType value.
     */
    SensorType sensorType();

    /**
     * Gets the inner com.azure.resourcemanager.security.fluent.models.IotSensorsModelInner object.
     *
     * @return the inner object.
     */
    IotSensorsModelInner innerModel();

    /** The entirety of the IotSensorsModel definition. */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithScope, DefinitionStages.WithCreate {
    }
    /** The IotSensorsModel definition stages. */
    interface DefinitionStages {
        /** The first stage of the IotSensorsModel definition. */
        interface Blank extends WithScope {
        }
        /** The stage of the IotSensorsModel definition allowing to specify parent resource. */
        interface WithScope {
            /**
             * Specifies scope.
             *
             * @param scope Scope of the query (IoT Hub, /providers/Microsoft.Devices/iotHubs/myHub).
             * @return the next definition stage.
             */
            WithCreate withExistingScope(String scope);
        }
        /**
         * The stage of the IotSensorsModel definition which contains all the minimum required properties for the
         * resource to be created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate
            extends DefinitionStages.WithTiAutomaticUpdates,
                DefinitionStages.WithZone,
                DefinitionStages.WithSensorType {
            /**
             * Executes the create request.
             *
             * @return the created resource.
             */
            IotSensorsModel create();

            /**
             * Executes the create request.
             *
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            IotSensorsModel create(Context context);
        }
        /** The stage of the IotSensorsModel definition allowing to specify tiAutomaticUpdates. */
        interface WithTiAutomaticUpdates {
            /**
             * Specifies the tiAutomaticUpdates property: TI Automatic mode status of the IoT sensor.
             *
             * @param tiAutomaticUpdates TI Automatic mode status of the IoT sensor.
             * @return the next definition stage.
             */
            WithCreate withTiAutomaticUpdates(Boolean tiAutomaticUpdates);
        }
        /** The stage of the IotSensorsModel definition allowing to specify zone. */
        interface WithZone {
            /**
             * Specifies the zone property: Zone of the IoT sensor.
             *
             * @param zone Zone of the IoT sensor.
             * @return the next definition stage.
             */
            WithCreate withZone(String zone);
        }
        /** The stage of the IotSensorsModel definition allowing to specify sensorType. */
        interface WithSensorType {
            /**
             * Specifies the sensorType property: Type of sensor.
             *
             * @param sensorType Type of sensor.
             * @return the next definition stage.
             */
            WithCreate withSensorType(SensorType sensorType);
        }
    }
    /**
     * Begins update for the IotSensorsModel resource.
     *
     * @return the stage of resource update.
     */
    IotSensorsModel.Update update();

    /** The template for IotSensorsModel update. */
    interface Update extends UpdateStages.WithTiAutomaticUpdates, UpdateStages.WithZone, UpdateStages.WithSensorType {
        /**
         * Executes the update request.
         *
         * @return the updated resource.
         */
        IotSensorsModel apply();

        /**
         * Executes the update request.
         *
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        IotSensorsModel apply(Context context);
    }
    /** The IotSensorsModel update stages. */
    interface UpdateStages {
        /** The stage of the IotSensorsModel update allowing to specify tiAutomaticUpdates. */
        interface WithTiAutomaticUpdates {
            /**
             * Specifies the tiAutomaticUpdates property: TI Automatic mode status of the IoT sensor.
             *
             * @param tiAutomaticUpdates TI Automatic mode status of the IoT sensor.
             * @return the next definition stage.
             */
            Update withTiAutomaticUpdates(Boolean tiAutomaticUpdates);
        }
        /** The stage of the IotSensorsModel update allowing to specify zone. */
        interface WithZone {
            /**
             * Specifies the zone property: Zone of the IoT sensor.
             *
             * @param zone Zone of the IoT sensor.
             * @return the next definition stage.
             */
            Update withZone(String zone);
        }
        /** The stage of the IotSensorsModel update allowing to specify sensorType. */
        interface WithSensorType {
            /**
             * Specifies the sensorType property: Type of sensor.
             *
             * @param sensorType Type of sensor.
             * @return the next definition stage.
             */
            Update withSensorType(SensorType sensorType);
        }
    }
    /**
     * Refreshes the resource to sync with Azure.
     *
     * @return the refreshed resource.
     */
    IotSensorsModel refresh();

    /**
     * Refreshes the resource to sync with Azure.
     *
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    IotSensorsModel refresh(Context context);

    /**
     * Download sensor activation file.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    InputStream downloadActivation();

    /**
     * Download sensor activation file.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    StreamResponse downloadActivationWithResponse(Context context);

    /**
     * Download file for reset password of the sensor.
     *
     * @param body The reset password input.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    InputStream downloadResetPassword(ResetPasswordInput body);

    /**
     * Download file for reset password of the sensor.
     *
     * @param body The reset password input.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    StreamResponse downloadResetPasswordWithResponse(ResetPasswordInput body, Context context);

    /**
     * Trigger threat intelligence package update.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void triggerTiPackageUpdate();

    /**
     * Trigger threat intelligence package update.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    Response<Void> triggerTiPackageUpdateWithResponse(Context context);
}
