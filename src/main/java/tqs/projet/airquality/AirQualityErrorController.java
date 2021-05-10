package tqs.projet.airquality;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AirQualityErrorController implements ErrorController  {
	
	private Logger logger = LoggerFactory.getLogger(AirQualityController.class);

    @RequestMapping("/error")
    public String handleError() {
        logger.error("Accessed unavailable page or invalid city");
        return "error";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
