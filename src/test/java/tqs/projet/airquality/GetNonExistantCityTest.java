package tqs.projet.airquality;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import io.github.bonigarcia.seljup.SeleniumJupiter;

import org.openqa.selenium.JavascriptExecutor;

@ExtendWith(SeleniumJupiter.class)
public class GetNonExistantCityTest {
  private WebDriver driver;

  
  public GetNonExistantCityTest(PhantomJSDriver driver) {
	  this.driver = driver;
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
