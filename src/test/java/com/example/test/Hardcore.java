package com.example.test;

import com.example.model.google_cloud.ComputeEngineForm;
import com.example.page.yopmail.EMailGeneratorPage;
import com.example.page.yopmail.YOPMailHomePage;
import com.example.test.data_providers.StaticDataProvider;
import com.example.steps.GoogleCloudSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

    /*
    1. Открыть https://cloud.google.com/
    2. Нажав кнопку поиска по порталу вверху страницы, ввести в поле поиска"Google Cloud Platform Pricing Calculator"
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
    8. Выбрать пункт EMAIL ESTIMATE
    9. В новой вкладке открыть https://yopmail.com/ или аналогичный сервис для генерации временных email'ов
    10. Скопировать почтовый адрес сгенерированный в yopmail.com
    11. Вернуться в калькулятор, в поле Email ввести адрес из предыдущего пункта
    12. Нажать SEND EMAIL
    13. Дождаться письма с рассчетом стоимости и проверить что Total Estimated Monthly Cost в письме совпадает с тем, что отображается в калькуляторе
     */

public class Hardcore extends AbstractTest {

    @Test(dataProvider = "HardcoreTestData", dataProviderClass = StaticDataProvider.class)
    public void verifyTotalEstimatedCost(String searchRequest, String linkText, ComputeEngineForm computeEngineForm, String expectedResult) {
        GoogleCloudSteps googleCloudSteps = new GoogleCloudSteps(driver);
        googleCloudSteps.createComputeEngineCalculation(searchRequest, linkText, computeEngineForm);
        String calculatorTab = getCurrentTabHandle();
        openNewTab();
        new YOPMailHomePage(driver)
                .openPage()
                .clickEMailGeneratorLink()
                .clickCopyToClipboardButton();
        String yopMailTab = getCurrentTabHandle();
        switchToTab(calculatorTab);
        googleCloudSteps.sendComputeEngineResultsToEMail(PASTE_FROM_CLIPBOARD);
        switchToTab(yopMailTab);
        String actualResult = new EMailGeneratorPage(driver)
                .clickCheckInboxButton()
                .openEstimatedMonthlyCostLetter()
                .getEstimatedMonthlyCost();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
