import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import java.util.concurrent.TimeUnit;

public class Habr {

    @Test
    public void testhabr() throws InterruptedException{

        //Установка пути к драйверу Chrome
        System.setProperty("webdriver.chorme.driver", "C:\\Users\\kopyt\\IdeaProjects\\untitled\\drivers\\chromedriver.exe");
        // Создание драйвера, открытие драйвера
        WebDriver driver = new ChromeDriver();

        // Переход на веб-страницу habr
        driver.get("https://habr.com/ru/all/");
        // Установка размеров окна
        driver.manage().window().setSize(new Dimension(1280, 1000));
        // Таймаут
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Нажатие на кнопку перехода в поиск
        driver.findElement(By.xpath("//a[@href='/ru/search/']")).click();
        //Таймаут
        Thread.sleep(Duration.ofSeconds(1).toMillis());

        // Проверка акивности элемента
        Assert.assertEquals(driver.findElement((By.xpath("//input[@name='q']"))), driver.switchTo().activeElement());
        // Таймаут
        Thread.sleep(Duration.ofSeconds(1).toMillis());

        // Ввод значения для поиска
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium WebDriver");
        //Таймаут
        Thread.sleep(Duration.ofSeconds(1).toMillis());

        // Выполнение поиска
        driver.findElement(By.xpath("//*[@class='tm-svg-img tm-svg-icon']")).click();
        //Таймаут
        Thread.sleep(Duration.ofSeconds(1).toMillis());

        // Переход в статью
        driver.findElement(By.linkText("Что такое Selenium WebDriver?")).click();
        //Таймаут
        Thread.sleep(Duration.ofSeconds(1).toMillis());

        // Сравнение даты
        Assert.assertEquals("1 окт 2012 в 16:40", driver.findElement(By.xpath("//*[@datetime='2012-10-01T09:40:36.000Z']")).getText());

        // Скролл страницы
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Переход в публикации
        driver.findElement(By.xpath("//a[@href='/ru/articles/' and @class='footer-menu__item-link router-link-active']")).click();
        //Таймаут
        Thread.sleep(Duration.ofSeconds(1).toMillis());

        // Закрытие драйвера
        driver.quit();
    }
}