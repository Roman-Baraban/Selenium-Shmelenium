package Homeworks.AmazonTents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class tenTentsForLoop {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        driver.findElement(By.cssSelector("[id=\"twotabsearchtextbox\"]")).sendKeys("tents");
        driver.findElement(By.id("nav-search-submit-button")).click();

        List<WebElement> tents = null;
        for (int i = 1 ; i <= 10; i++) {
            Thread.sleep(5000);
            tents = driver.findElements(By.cssSelector("h2.a-size-mini.a-spacing-none.a-color-base.s-line-clamp-2>a>span"));
            System.out.println("Page " + i);
            tents.forEach(tent -> System.out.println(tent.getText()));
            driver.findElement(By.cssSelector(".s-pagination-item.s-pagination-next.s-pagination-button.s-pagination-separator")).click();

        }
        driver.close();



    }
}
//