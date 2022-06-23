package com.example.test;

import com.example.model.google_cloud.ComputeEngineForm;
import com.example.model.google_cloud.ComputeEngineResults;
import com.example.test.data_providers.StaticDataProvider;
import com.example.steps.GoogleCloudSteps;
import com.example.util.StringUtils;
import org.testng.Assert;
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

    @Test(dataProvider = "HurtMePlentyTestData", dataProviderClass = StaticDataProvider.class)
    public void verifyVMClass(String searchRequest, String linkText,
                              ComputeEngineForm computeEngineForm, ComputeEngineResults expectedResults) {
        GoogleCloudSteps steps = new GoogleCloudSteps(driver);
        String actualResult = StringUtils.getValueAfterColon(steps
                .createComputeEngineCalculation(searchRequest, linkText, computeEngineForm)
                .getProvisioningModel());
        Assert.assertEquals(actualResult, expectedResults.getProvisioningModel());
    }

    @Test(dataProvider = "HurtMePlentyTestData", dataProviderClass = StaticDataProvider.class)
    public void verifyInstanceType(String searchRequest, String linkText,
                                   ComputeEngineForm computeEngineForm, ComputeEngineResults expectedResults) {
        GoogleCloudSteps steps = new GoogleCloudSteps(driver);
        String actualResult = StringUtils.getValueAfterColon(steps
                .createComputeEngineCalculation(searchRequest, linkText, computeEngineForm)
                .getInstanceType());
        Assert.assertEquals(actualResult, expectedResults.getInstanceType());
    }

    @Test(dataProvider = "HurtMePlentyTestData", dataProviderClass = StaticDataProvider.class)
    public void verifyRegion(String searchRequest, String linkText,
                             ComputeEngineForm computeEngineForm, ComputeEngineResults expectedResults) {
        GoogleCloudSteps steps = new GoogleCloudSteps(driver);
        String actualResult = StringUtils.getValueAfterColon(steps
                .createComputeEngineCalculation(searchRequest, linkText, computeEngineForm)
                .getRegion());
        Assert.assertEquals(actualResult, expectedResults.getRegion());
    }

    @Test(dataProvider = "HurtMePlentyTestData", dataProviderClass = StaticDataProvider.class)
    public void verifyLocalSSD(String searchRequest, String linkText,
                               ComputeEngineForm computeEngineForm, ComputeEngineResults expectedResults) {
        GoogleCloudSteps steps = new GoogleCloudSteps(driver);
        String actualResult = StringUtils.getValueAfterColon(steps
                .createComputeEngineCalculation(searchRequest, linkText, computeEngineForm)
                .getLocalSSD());
        Assert.assertEquals(actualResult, expectedResults.getLocalSSD());
    }

    @Test(dataProvider = "HurtMePlentyTestData", dataProviderClass = StaticDataProvider.class)
    public void verifyCommitmentTerm(String searchRequest, String linkText,
                                     ComputeEngineForm computeEngineForm, ComputeEngineResults expectedResults) {
        GoogleCloudSteps steps = new GoogleCloudSteps(driver);
        String actualResult = StringUtils.getValueAfterColon(steps
                .createComputeEngineCalculation(searchRequest, linkText, computeEngineForm)
                .getCommitmentTerm());
        Assert.assertEquals(actualResult, expectedResults.getCommitmentTerm());
    }

    @Test(dataProvider = "HurtMePlentyTestData", dataProviderClass = StaticDataProvider.class)
    public void verifyTotalEstimatedCost(String searchRequest, String linkText,
                                         ComputeEngineForm computeEngineForm, ComputeEngineResults expectedResults) {
        GoogleCloudSteps steps = new GoogleCloudSteps(driver);
        String actualResult = StringUtils.getValueAfterColon(steps
                .createComputeEngineCalculation(searchRequest, linkText, computeEngineForm)
                .getTotalEstimatedCost());
        Assert.assertEquals(actualResult, expectedResults.getTotalEstimatedCost());
    }
}
