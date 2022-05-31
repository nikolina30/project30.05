import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("http://www.strela.co.rs/");

        List<WebElement> store = driver.findElements(By.xpath("//*[@id=\"ctl00_RadMenu1\"]/ul/li[2]/a"));
        for(WebElement storeField : store){
            storeField.click();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement arrowDown = driver.findElement(By.className("rtIn"));
        arrowDown.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement imageDiv = driver.findElement(By.id("ctl00_MainContent_ListView1_ctrl35_Panel1"));
        WebElement imageLink = imageDiv.findElement(By.tagName("img"));
        imageLink.click();

        String bowName = "Samick";
        WebElement bowLabel = driver.findElement(By.id("ctl00_MainContent_ItemListView_ctrl0_ItemNazivLabel"));
        if(bowLabel.getText().contains(bowName)) {
            System.out.println("This is the correct bow. It contains the word " + bowName + ".");
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
    }
}
