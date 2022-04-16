package cursoMassa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class InicioSelenium {

  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    ChromeDriver driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    driver.get("http://seubarriga.wcaquino.me/");
    driver.findElementById("email").sendKeys("tcosta1996@hotmail.com");
    driver.findElementById("senha").sendKeys("SeuBarriga");
    driver.findElementByTagName("button").click();

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    driver.quit();
  }
}
