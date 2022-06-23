package com.example.test.data_providers;

import com.example.model.google_cloud.ComputeEngineForm;
import com.example.model.google_cloud.ComputeEngineResults;
import org.testng.annotations.DataProvider;

public class StaticDataProvider {

    private static final String SEARCH_REQUEST = "Google Cloud Platform Pricing Calculator";
    private static final ComputeEngineForm COMPUTE_ENGINE_FORM = ComputeEngineForm.builder()
            .numberOfInstances("4")
            .operatingSystem("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)")
            .provisioningModel("Regular")
            .series("N1")
            .instanceType("n1-standard-8 (vCPUs: 8, RAM: 30GB)")
            .gpuType("NVIDIA Tesla V100")
            .gpuCount("1")
            .localSSD("2x375 GB")
            .region("Frankfurt (europe-west3)")
            .commitmentTerm("1 Year")
            .build();

    @DataProvider(name = "HurtMePlentyTestData")
    public static Object[][] hurtMePlentyDataProviderMethod() {
        return new Object[][]{{SEARCH_REQUEST, SEARCH_REQUEST, COMPUTE_ENGINE_FORM,
                ComputeEngineResults.builder()
                        .provisioningModel("Regular")
                        .instanceType("n1-standard-8")
                        .region("Frankfurt")
                        .localSSD("2x375 GB")
                        .commitmentTerm("1 Year")
                        .totalEstimatedCost("USD 1,081.20 per 1 month")
                        .build()}
        };
    }

    @DataProvider(name = "HardcoreTestData")
    public static Object[][] hardcoreDataProviderMethod() {
        return new Object[][]{{SEARCH_REQUEST, SEARCH_REQUEST, COMPUTE_ENGINE_FORM,
                "Estimated Monthly Cost: USD 1,081.20"}
        };
    }
}
