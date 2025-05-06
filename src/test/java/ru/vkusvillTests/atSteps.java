package ru.vkusvillTests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selenide.*;


public class atSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("/Olezhonchik");
    }

    @Step("Открываем список репозиториев")
    public void openRepositoryList() {
        $x("//a[@href = '/Olezhonchik?tab=repositories']").click();
        sleep(3000);
    }

    @Step("Переходим в репозиторий {repositoryName}")
    public void openRepository(String repositoryName) {
        $x("//a[@href = '/Olezhonchik/" + repositoryName + "']").click();
    }

    @Step("Переходим в раздел 'issue'")
    public void openIssuesList() {
        $x("//a[@id = 'issues-tab']").click();
    }

    @Step("Проверяем наличие issue с номером {issueNumber}")
    public void checkIssues(int issueNumber) {
        $x("//li[contains(@aria-label, '#" + issueNumber + "')]").should(Condition.exist);
    }
}

