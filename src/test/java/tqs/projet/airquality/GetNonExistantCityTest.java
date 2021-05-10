package tqs.projet.airquality;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.seljup.SeleniumJupiter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

@ExtendWith(SeleniumJupiter.class)
public class GetNonExistantCityTest {
  private WebDriver driver;

  JavascriptExecutor js;
  
  public GetNonExistantCityTest(PhantomJSDriver driver) {
	  this.driver = driver;
	  js = driver;
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
