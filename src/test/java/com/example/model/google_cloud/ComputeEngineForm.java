package com.example.model.google_cloud;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ComputeEngineForm {
    private String numberOfInstances;
    private String operatingSystem;
    private String provisioningModel;
    private String series;
    private String instanceType;
    private String gpuType;
    private String gpuCount;
    private String localSSD;
    private String region;
    private String commitmentTerm;
}
