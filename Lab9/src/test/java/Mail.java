import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import java.util.concurrent.TimeUnit;

public class Mail {

    @Test
    public void testmailru() throws InterruptedException{

        //Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kopyt\\IdeaProjects\\untitled\\drivers\\chromedriver.exe");
        // Создание драйвера, открытие драйвера
        WebDriver driver = new ChromeDriver();

        //Переход на веб-страницу mail
        driver.get("https://mail.ru/");
        //Установка таймаута для прогрузки страницы
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Поиск и нажатие "Войти"
        driver.findElement(By.xpath("//*[@class='resplash-btn resplash-btn_primary resplash-btn_mailbox-big cea-fefe-ehxscg']")).click();

        // Переход к диалоговому окну, поверх основного
        WebElement iframeElement = driver.findElement(By.cssSelector("iframe.ag-popup__frame__layout__iframe"));
        driver.switchTo().frame(iframeElement);
        //Таймаут
        Thread.sleep(Duration.ofSeconds(1).toMillis());

        // Ввод логина
        driver.findElement(By.xpath("//*[@class='input-0-2-71']")).sendKeys("tester9lab");
        // Нажатие "Ввести пароль"
        driver.findElement(By.xpath("//*[@class='base-0-2-79 primary-0-2-93']")).click();
        //Таймаут
        Thread.sleep(Duration.ofSeconds(1).toMillis());

        // Ввод пароля и нажимаем на кнопку войти
        driver.findElement(By.xpath("//*[@class='input-0-2-71 withIcon-0-2-72']")).sendKeys("labForTest");
        // Нажатие "Войти"
        driver.findElement(By.xpath("//*[@class='inner-0-2-81 innerTextWrapper-0-2-82']")).click();
        // Таймаут
        Thread.sleep(Duration.ofSeconds(1).toMillis());

        // Нажатие на почту для открытия окна профиля
        driver.findElement(By.xpath("//*[@class='ph-avatar-img svelte-dfhuqc']")).click();

        // Проверяем имя почты, выход из акаунта и проверка элемента "Создать Почту"
        Assert.assertEquals("Prof Tester",driver.findElement(By.xpath("//*[@class='ph-name svelte-1popff4']")).getText());
        // Выход из аккаунта
        driver.findElement(By.xpath("//*[@data-testid='whiteline-account-exit']")).click();
        // Таймаут
        Thread.sleep(Duration.ofSeconds(1).toMillis());
        // Проверка наличия на экране элемента "Создать Почту"
        driver.findElement(By.xpath("//*[@class='resplash-btn resplash-btn_outlined-themed resplash-btn_mailbox-big cea-fefe-ehxscg']")).isDisplayed();

        // Закрытие драйвера
        driver.quit();
    }
}