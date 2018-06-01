package kz.akezhan.poc;

import groovy.lang.GroovySystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dauren Mussa
 * @since 6/1/18
 */

@SpringBootApplication
@Controller
public class Application {

    @Autowired
    BuildProperties buildProperties;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView index() {
        Map<String, Object> model = new HashMap<>();
        model.put("groovyVersion", GroovySystem.getVersion());
        model.put("bootVersion", buildProperties.getVersion());
        return new ModelAndView("index", model);
    }

}
