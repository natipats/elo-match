package com.wileyedge.elomatch.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    // This communicated with index.HTML
    // http://localhost:8080/
    // everything else is done in intellij in the background.
    @RequestMapping("/")
    public String index() { // the method always has a string type of return value.
        return "index"; // must always give match the exact html file name before the .
    }
}
