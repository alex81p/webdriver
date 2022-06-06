package com.example.test;

import com.example.entities.AbstractTest;
import com.example.page.google_cloud.GoogleCloudHomePage;
import com.example.page.google_cloud.calculator.tools.ComputeEngineResults;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

    /*
    1. Открыть https://cloud.google.com/
    2. Нажав кнопку поиска по порталу вверху страницы, ввести в поле поиска "Google Cloud Platform Pricing Calculator"
    3. Запустить поиск, нажав кнопку поиска.
    4. В результатах поиска кликнуть "Google Cloud Platform Pricing Calculator" и перейти на страницу калькулятора.
    5. Активировать раздел COMPUTE ENGINE вверху страницы
    6. Заполнить форму следующими данными:
        - Number of instances: 4
        - What are these instances for?: оставить пустым
        - Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS
        - VM Class: Regular
        - Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)
        - Выбрать Add GPUs
            - Number of GPUs: 1
            - GPU type: NVIDIA Tesla V100
        - Local SSD: 2x375 Gb
        - Datacenter location: Frankfurt (europe-west3)
        - Committed usage: 1 Year
    7. Нажать Add to Estimate
    8. Проверить соответствие данных следующих полей: VM Class, Instance type, Region, local SSD, commitment term
    9. Проверить что сумма аренды в месяц совпадает с суммой получаемой при ручном прохождении теста.
     */

public class HurtMePlenty extends AbstractTest {

    private ComputeEngineResults results;

    private static final String SEARCH_REQUEST = "Google Cloud Platform Pricing Calculator";
    private static final String NUMBER_OF_INSTANCES = "4";
    private static final String OPERATING_SYSTEM_LONG = "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)";
    private static final String PROVISIONING_MODEL = "Regular";
    private static final String SERIES = "N1";
    private static final String INSTANCE_TYPE_LONG = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
    private static final String INSTANCE_TYPE_SHORT = "n1-standard-8";
    private static final String GPU_TYPE = "NVIDIA Tesla V100";
    private static final String GPU_COUNT = "1";
    private static final String LOCAL_SSD = "2x375 GB";
    private static final String REGION_LONG = "Frankfurt (europe-west3)";
    private static final String REGION_SHORT = "Frankfurt";
    private static final String COMMITMENT_TERM = "1 Year";
    private static final String TOTAL_ESTIMATED_COST = "USD 1,081.20 per 1 month";

    @BeforeClass()
    public ComputeEngineResults createComputeEngineCalculation(){
        results = new GoogleCloudHomePage(driver)
                .openPage()
                .search(SEARCH_REQUEST)
                .openPricingCalculatorPage(SEARCH_REQUEST)
                .selectComputeEngine()
                .setNumberOfInstances(NUMBER_OF_INSTANCES)
                .setOperatingSystem(OPERATING_SYSTEM_LONG)
                .setProvisioningModel(PROVISIONING_MODEL)
                .setSeries(SERIES)
                .setMachineType(INSTANCE_TYPE_LONG)
                .addGPUs(GPU_TYPE, GPU_COUNT)
                .setLocalSSD(LOCAL_SSD)
                .setLocation(REGION_LONG)
                .setCommittedUsage(COMMITMENT_TERM)
                .clickAddInstancesToEstimateButton()
                .switchToComputeEngineResults();
        return results;
    }

    @Test
    public void verifyVMClass() {
        Assert.assertEquals(results.getProvisioningModel(), PROVISIONING_MODEL);
    }

    @Test
    public void verifyInstanceType() {
        Assert.assertEquals(results.getInstanceType(), INSTANCE_TYPE_SHORT);
    }

    @Test
    public void verifyRegion() {
        Assert.assertEquals(results.getRegion(), REGION_SHORT);
    }

    @Test
    public void verifyLocalSSD() {
        Assert.assertEquals(results.getLocalSSD(), LOCAL_SSD);
    }

    @Test
    public void verifyCommitmentTerm() {
        Assert.assertEquals(results.getCommitmentTerm(), COMMITMENT_TERM);
    }

    @Test
    public void verifyTotalEstimatedCost() {
        Assert.assertEquals(results.getTotalEstimatedCost(), TOTAL_ESTIMATED_COST);
    }
}
