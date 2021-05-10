package tqs.projet.airquality;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.JavascriptExecutor;

@ExtendWith(SeleniumJupiter.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class GetNonExistantCityTest {
  private WebDriver driver;

  
  @BeforeEach
  public void setUp()
  {
      WebDriverManager.chromedriver().setup();
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--no-sandbox");
      options.addArguments("--disable-dev-shm-usage");
      options.addArguments("--headless");
      driver = new ChromeDriver(options);
      driver.navigate().to("https://the-internet.herokuapp.com/login");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);
  }
  
  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  
  @Test
  public void getNonExistantCity() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.id("input_city")).click();
    driver.findElement(By.id("input_city")).sendKeys("NonExistantCity");
    driver.findElement(By.id("redirect")).click();
    assertThat(driver.getTitle(), is("404 HTML Template by Colorlib"));
  }
}
