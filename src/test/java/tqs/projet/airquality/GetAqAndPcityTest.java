package tqs.projet.airquality;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

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
public class GetAqAndPcityTest {
	
  private WebDriver driver;
  private JavascriptExecutor js;
  
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
  public void getAqAndPcity() {
    driver.get("http://localhost:8080/");
    driver.findElement(By.id("input_city")).click();
    driver.findElement(By.id("input_city")).sendKeys("Aveiro");
    driver.findElement(By.id("redirect")).click();
    assertThat(driver.findElement(By.cssSelector(".container > .table tr:nth-child(1) > td")).getText(), is("Aveiro"));
    assertThat(driver.findElement(By.cssSelector(".container > .table tr:nth-child(2) > td")).getText(), is("PT"));
    assertThat(driver.getTitle(), is("Air quality for Aveiro"));
  }
}
