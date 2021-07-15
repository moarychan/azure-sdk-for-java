// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.avs;

import com.azure.core.credential.TokenCredential;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.policy.AddDatePolicy;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.http.policy.HttpLoggingPolicy;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.http.policy.HttpPolicyProviders;
import com.azure.core.http.policy.RequestIdPolicy;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.core.http.policy.UserAgentPolicy;
import com.azure.core.management.http.policy.ArmChallengeAuthenticationPolicy;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.util.Configuration;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.avs.fluent.AvsClient;
import com.azure.resourcemanager.avs.implementation.AddonsImpl;
import com.azure.resourcemanager.avs.implementation.AuthorizationsImpl;
import com.azure.resourcemanager.avs.implementation.AvsClientBuilder;
import com.azure.resourcemanager.avs.implementation.CloudLinksImpl;
import com.azure.resourcemanager.avs.implementation.ClustersImpl;
import com.azure.resourcemanager.avs.implementation.DatastoresImpl;
import com.azure.resourcemanager.avs.implementation.GlobalReachConnectionsImpl;
import com.azure.resourcemanager.avs.implementation.HcxEnterpriseSitesImpl;
import com.azure.resourcemanager.avs.implementation.LocationsImpl;
import com.azure.resourcemanager.avs.implementation.OperationsImpl;
import com.azure.resourcemanager.avs.implementation.PrivateCloudsImpl;
import com.azure.resourcemanager.avs.implementation.ScriptCmdletsImpl;
import com.azure.resourcemanager.avs.implementation.ScriptExecutionsImpl;
import com.azure.resourcemanager.avs.implementation.ScriptPackagesImpl;
import com.azure.resourcemanager.avs.implementation.WorkloadNetworksImpl;
import com.azure.resourcemanager.avs.models.Addons;
import com.azure.resourcemanager.avs.models.Authorizations;
import com.azure.resourcemanager.avs.models.CloudLinks;
import com.azure.resourcemanager.avs.models.Clusters;
import com.azure.resourcemanager.avs.models.Datastores;
import com.azure.resourcemanager.avs.models.GlobalReachConnections;
import com.azure.resourcemanager.avs.models.HcxEnterpriseSites;
import com.azure.resourcemanager.avs.models.Locations;
import com.azure.resourcemanager.avs.models.Operations;
import com.azure.resourcemanager.avs.models.PrivateClouds;
import com.azure.resourcemanager.avs.models.ScriptCmdlets;
import com.azure.resourcemanager.avs.models.ScriptExecutions;
import com.azure.resourcemanager.avs.models.ScriptPackages;
import com.azure.resourcemanager.avs.models.WorkloadNetworks;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Entry point to AvsManager. Azure VMware Solution API. */
public final class AvsManager {
    private Operations operations;

    private Locations locations;

    private PrivateClouds privateClouds;

    private Clusters clusters;

    private Datastores datastores;

    private HcxEnterpriseSites hcxEnterpriseSites;

    private Authorizations authorizations;

    private GlobalReachConnections globalReachConnections;

    private WorkloadNetworks workloadNetworks;

    private CloudLinks cloudLinks;

    private Addons addons;

    private ScriptPackages scriptPackages;

    private ScriptCmdlets scriptCmdlets;

    private ScriptExecutions scriptExecutions;

    private final AvsClient clientObject;

    private AvsManager(HttpPipeline httpPipeline, AzureProfile profile, Duration defaultPollInterval) {
        Objects.requireNonNull(httpPipeline, "'httpPipeline' cannot be null.");
        Objects.requireNonNull(profile, "'profile' cannot be null.");
        this.clientObject =
            new AvsClientBuilder()
                .pipeline(httpPipeline)
                .endpoint(profile.getEnvironment().getResourceManagerEndpoint())
                .subscriptionId(profile.getSubscriptionId())
                .defaultPollInterval(defaultPollInterval)
                .buildClient();
    }

    /**
     * Creates an instance of Avs service API entry point.
     *
     * @param credential the credential to use.
     * @param profile the Azure profile for client.
     * @return the Avs service API instance.
     */
    public static AvsManager authenticate(TokenCredential credential, AzureProfile profile) {
        Objects.requireNonNull(credential, "'credential' cannot be null.");
        Objects.requireNonNull(profile, "'profile' cannot be null.");
        return configure().authenticate(credential, profile);
    }

    /**
     * Gets a Configurable instance that can be used to create AvsManager with optional configuration.
     *
     * @return the Configurable instance allowing configurations.
     */
    public static Configurable configure() {
        return new AvsManager.Configurable();
    }

    /** The Configurable allowing configurations to be set. */
    public static final class Configurable {
        private final ClientLogger logger = new ClientLogger(Configurable.class);

        private HttpClient httpClient;
        private HttpLogOptions httpLogOptions;
        private final List<HttpPipelinePolicy> policies = new ArrayList<>();
        private final List<String> scopes = new ArrayList<>();
        private RetryPolicy retryPolicy;
        private Duration defaultPollInterval;

        private Configurable() {
        }

        /**
         * Sets the http client.
         *
         * @param httpClient the HTTP client.
         * @return the configurable object itself.
         */
        public Configurable withHttpClient(HttpClient httpClient) {
            this.httpClient = Objects.requireNonNull(httpClient, "'httpClient' cannot be null.");
            return this;
        }

        /**
         * Sets the logging options to the HTTP pipeline.
         *
         * @param httpLogOptions the HTTP log options.
         * @return the configurable object itself.
         */
        public Configurable withLogOptions(HttpLogOptions httpLogOptions) {
            this.httpLogOptions = Objects.requireNonNull(httpLogOptions, "'httpLogOptions' cannot be null.");
            return this;
        }

        /**
         * Adds the pipeline policy to the HTTP pipeline.
         *
         * @param policy the HTTP pipeline policy.
         * @return the configurable object itself.
         */
        public Configurable withPolicy(HttpPipelinePolicy policy) {
            this.policies.add(Objects.requireNonNull(policy, "'policy' cannot be null."));
            return this;
        }

        /**
         * Adds the scope to permission sets.
         *
         * @param scope the scope.
         * @return the configurable object itself.
         */
        public Configurable withScope(String scope) {
            this.scopes.add(Objects.requireNonNull(scope, "'scope' cannot be null."));
            return this;
        }

        /**
         * Sets the retry policy to the HTTP pipeline.
         *
         * @param retryPolicy the HTTP pipeline retry policy.
         * @return the configurable object itself.
         */
        public Configurable withRetryPolicy(RetryPolicy retryPolicy) {
            this.retryPolicy = Objects.requireNonNull(retryPolicy, "'retryPolicy' cannot be null.");
            return this;
        }

        /**
         * Sets the default poll interval, used when service does not provide "Retry-After" header.
         *
         * @param defaultPollInterval the default poll interval.
         * @return the configurable object itself.
         */
        public Configurable withDefaultPollInterval(Duration defaultPollInterval) {
            this.defaultPollInterval = Objects.requireNonNull(defaultPollInterval, "'retryPolicy' cannot be null.");
            if (this.defaultPollInterval.isNegative()) {
                throw logger.logExceptionAsError(new IllegalArgumentException("'httpPipeline' cannot be negative"));
            }
            return this;
        }

        /**
         * Creates an instance of Avs service API entry point.
         *
         * @param credential the credential to use.
         * @param profile the Azure profile for client.
         * @return the Avs service API instance.
         */
        public AvsManager authenticate(TokenCredential credential, AzureProfile profile) {
            Objects.requireNonNull(credential, "'credential' cannot be null.");
            Objects.requireNonNull(profile, "'profile' cannot be null.");

            StringBuilder userAgentBuilder = new StringBuilder();
            userAgentBuilder
                .append("azsdk-java")
                .append("-")
                .append("com.azure.resourcemanager.avs")
                .append("/")
                .append("1.0.0-beta.2");
            if (!Configuration.getGlobalConfiguration().get("AZURE_TELEMETRY_DISABLED", false)) {
                userAgentBuilder
                    .append(" (")
                    .append(Configuration.getGlobalConfiguration().get("java.version"))
                    .append("; ")
                    .append(Configuration.getGlobalConfiguration().get("os.name"))
                    .append("; ")
                    .append(Configuration.getGlobalConfiguration().get("os.version"))
                    .append("; auto-generated)");
            } else {
                userAgentBuilder.append(" (auto-generated)");
            }

            if (scopes.isEmpty()) {
                scopes.add(profile.getEnvironment().getManagementEndpoint() + "/.default");
            }
            if (retryPolicy == null) {
                retryPolicy = new RetryPolicy("Retry-After", ChronoUnit.SECONDS);
            }
            List<HttpPipelinePolicy> policies = new ArrayList<>();
            policies.add(new UserAgentPolicy(userAgentBuilder.toString()));
            policies.add(new RequestIdPolicy());
            HttpPolicyProviders.addBeforeRetryPolicies(policies);
            policies.add(retryPolicy);
            policies.add(new AddDatePolicy());
            policies.add(new ArmChallengeAuthenticationPolicy(credential, scopes.toArray(new String[0])));
            policies.addAll(this.policies);
            HttpPolicyProviders.addAfterRetryPolicies(policies);
            policies.add(new HttpLoggingPolicy(httpLogOptions));
            HttpPipeline httpPipeline =
                new HttpPipelineBuilder()
                    .httpClient(httpClient)
                    .policies(policies.toArray(new HttpPipelinePolicy[0]))
                    .build();
            return new AvsManager(httpPipeline, profile, defaultPollInterval);
        }
    }

    /** @return Resource collection API of Operations. */
    public Operations operations() {
        if (this.operations == null) {
            this.operations = new OperationsImpl(clientObject.getOperations(), this);
        }
        return operations;
    }

    /** @return Resource collection API of Locations. */
    public Locations locations() {
        if (this.locations == null) {
            this.locations = new LocationsImpl(clientObject.getLocations(), this);
        }
        return locations;
    }

    /** @return Resource collection API of PrivateClouds. */
    public PrivateClouds privateClouds() {
        if (this.privateClouds == null) {
            this.privateClouds = new PrivateCloudsImpl(clientObject.getPrivateClouds(), this);
        }
        return privateClouds;
    }

    /** @return Resource collection API of Clusters. */
    public Clusters clusters() {
        if (this.clusters == null) {
            this.clusters = new ClustersImpl(clientObject.getClusters(), this);
        }
        return clusters;
    }

    /** @return Resource collection API of Datastores. */
    public Datastores datastores() {
        if (this.datastores == null) {
            this.datastores = new DatastoresImpl(clientObject.getDatastores(), this);
        }
        return datastores;
    }

    /** @return Resource collection API of HcxEnterpriseSites. */
    public HcxEnterpriseSites hcxEnterpriseSites() {
        if (this.hcxEnterpriseSites == null) {
            this.hcxEnterpriseSites = new HcxEnterpriseSitesImpl(clientObject.getHcxEnterpriseSites(), this);
        }
        return hcxEnterpriseSites;
    }

    /** @return Resource collection API of Authorizations. */
    public Authorizations authorizations() {
        if (this.authorizations == null) {
            this.authorizations = new AuthorizationsImpl(clientObject.getAuthorizations(), this);
        }
        return authorizations;
    }

    /** @return Resource collection API of GlobalReachConnections. */
    public GlobalReachConnections globalReachConnections() {
        if (this.globalReachConnections == null) {
            this.globalReachConnections =
                new GlobalReachConnectionsImpl(clientObject.getGlobalReachConnections(), this);
        }
        return globalReachConnections;
    }

    /** @return Resource collection API of WorkloadNetworks. */
    public WorkloadNetworks workloadNetworks() {
        if (this.workloadNetworks == null) {
            this.workloadNetworks = new WorkloadNetworksImpl(clientObject.getWorkloadNetworks(), this);
        }
        return workloadNetworks;
    }

    /** @return Resource collection API of CloudLinks. */
    public CloudLinks cloudLinks() {
        if (this.cloudLinks == null) {
            this.cloudLinks = new CloudLinksImpl(clientObject.getCloudLinks(), this);
        }
        return cloudLinks;
    }

    /** @return Resource collection API of Addons. */
    public Addons addons() {
        if (this.addons == null) {
            this.addons = new AddonsImpl(clientObject.getAddons(), this);
        }
        return addons;
    }

    /** @return Resource collection API of ScriptPackages. */
    public ScriptPackages scriptPackages() {
        if (this.scriptPackages == null) {
            this.scriptPackages = new ScriptPackagesImpl(clientObject.getScriptPackages(), this);
        }
        return scriptPackages;
    }

    /** @return Resource collection API of ScriptCmdlets. */
    public ScriptCmdlets scriptCmdlets() {
        if (this.scriptCmdlets == null) {
            this.scriptCmdlets = new ScriptCmdletsImpl(clientObject.getScriptCmdlets(), this);
        }
        return scriptCmdlets;
    }

    /** @return Resource collection API of ScriptExecutions. */
    public ScriptExecutions scriptExecutions() {
        if (this.scriptExecutions == null) {
            this.scriptExecutions = new ScriptExecutionsImpl(clientObject.getScriptExecutions(), this);
        }
        return scriptExecutions;
    }

    /**
     * @return Wrapped service client AvsClient providing direct access to the underlying auto-generated API
     *     implementation, based on Azure REST API.
     */
    public AvsClient serviceClient() {
        return this.clientObject;
    }
}
