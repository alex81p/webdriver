package com.example.model.google_cloud;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ComputeEngineResults {
    private String provisioningModel;
    private String instanceType;
    private String localSSD;
    private String region;
    private String commitmentTerm;
    private String totalEstimatedCost;
}
