package ru.vkusvillTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class stepsTests extends TestBase {

@Test
    public void lambdaStepTest(){
    SelenideLogger.addListener("allure", new AllureSelenide());

    step("Открываем главную страницу", () -> {
        open("/Olezhonchik");
    });

    step("Открываем список репозиториев", () -> {
        $x("//a[@href = '/Olezhonchik?tab=repositories']").click();
        sleep(3000);
    });

    step("Переходим в репозиторий 'xpath'", () -> {
        $x("//a[@href = '/Olezhonchik/xpath']").click();
    });

    step("Переходим в раздел 'issue'", () -> {
        $x("//a[@id = 'issues-tab']").click();
    });

    step("Проверяем наличие issue с номером '#12'", () -> {
        $x("//li[contains(@aria-label, '#12')]").should(Condition.exist);
    });
}
}