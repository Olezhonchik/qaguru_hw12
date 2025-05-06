package ru.vkusvillTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTests extends TestBase {

@Test
    public void selenideStepsTest(){
    SelenideLogger.addListener("allure", new AllureSelenide());
    open("/Olezhonchik");
    $x("//a[@href = '/Olezhonchik?tab=repositories']").click();
    sleep(3000);
    $x("//a[@href = '/Olezhonchik/xpath']").click();
    $x("//a[@id = 'issues-tab']").click();
    $x("//li[contains(@aria-label, '#12')]").should(Condition.exist);

}
}
