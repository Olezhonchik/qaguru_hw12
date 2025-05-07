package ru.vkusvillTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class StepsTests extends TestBase {
    public static final int issueNumber = 12;
    public static final String repositoryName = "xpath";

    @Test
    @Owner("Oleg Borzunov")
    @Feature("Issue в репозитории")
    @Story("Создание issue в репозитории")
    @DisplayName("Проверка issue в репозитории")
    @Severity(SeverityLevel.NORMAL)
    public void lambdaStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("/Olezhonchik");
        });

        step("Открываем список репозиториев", () -> {
            $x("//a[@href = '/Olezhonchik?tab=repositories']").click();
            sleep(3000);
        });

        step("Переходим в репозиторий" + repositoryName, () -> {
            $x("//a[@href = '/Olezhonchik/" + repositoryName + "']").click();
        });

        step("Переходим в раздел 'issue'", () -> {
            $x("//a[@id = 'issues-tab']").click();
        });

        step("Проверяем наличие issue с номером #" + issueNumber, () -> {
            $x("//li[contains(@aria-label, '#" + issueNumber + "')]").should(Condition.exist);
        });
    }

    @Test
    @Owner("Oleg Borzunov")
    @Feature("Issue в репозитории")
    @Story("Создание issue в репозитории")
    @DisplayName("Проверка issue в репозитории")
    @Severity(SeverityLevel.NORMAL)
    public void annotationStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        atSteps atSteps = new atSteps();

        atSteps.openMainPage();
        atSteps.openRepositoryList();
        atSteps.openRepository(repositoryName);
        atSteps.openIssuesList();
        atSteps.checkIssues(issueNumber);

    }
}
