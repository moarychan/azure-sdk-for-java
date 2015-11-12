/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 * 
 * Code generated by Microsoft (R) AutoRest Code Generator 0.13.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.management.storage;

import com.microsoft.azure.management.storage.models.UsageListResult;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceException;
import com.microsoft.rest.ServiceResponse;
import com.squareup.okhttp.ResponseBody;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.Url;

/**
 * An instance of this class provides access to all the operations defined
 * in UsageOperations.
 */
public interface UsageOperations {
    /**
     * The interface defining all the services for UsageOperations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface UsageService {
        @GET("/subscriptions/{subscriptionId}/providers/Microsoft.Storage/usages")
        Call<ResponseBody> list(@Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @GET
        Call<ResponseBody> listNext(@Url String nextPageLink, @Header("accept-language") String acceptLanguage);

    }
    /**
     * Gets the current usage count and the limit for the resources under the subscription.
     *
     * @param apiVersion the String value
     * @throws ServiceException exception thrown from REST call
     * @return the UsageListResult object wrapped in ServiceResponse if successful.
     */
    ServiceResponse<UsageListResult> list(String apiVersion) throws ServiceException;

    /**
     * Gets the current usage count and the limit for the resources under the subscription.
     *
     * @param apiVersion the String value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> listAsync(String apiVersion, final ServiceCallback<UsageListResult> serviceCallback);

    /**
     * Gets the current usage count and the limit for the resources under the subscription.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws ServiceException exception thrown from REST call
     * @return the UsageListResult object wrapped in ServiceResponse if successful.
     */
    ServiceResponse<UsageListResult> listNext(String nextPageLink) throws ServiceException;

    /**
     * Gets the current usage count and the limit for the resources under the subscription.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> listNextAsync(String nextPageLink, final ServiceCallback<UsageListResult> serviceCallback);

}
