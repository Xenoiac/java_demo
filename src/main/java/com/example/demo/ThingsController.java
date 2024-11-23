package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ThingsController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)  
    public String displayThings() {
        
        String[] things = {
            "Android", "Maple", "Motorcycle", "Tower", "Gym", 
            "Donuts", "Coffee", "Castle", "Elephant", "Apple", "Clean", "Test", "Cat"
        };

        
        List<String> sortedThings = Arrays.asList(things);
        sortedThings.sort(String::compareToIgnoreCase);

        
        StringBuilder html = new StringBuilder("<h1>Things List</h1><ul>");
        for (String thing : sortedThings) {
            html.append("<li>").append(thing).append("</li>");
        }
        html.append("</ul>");

        
        html.append("<p>Total count = ").append(sortedThings.size()).append("</p>");

        return html.toString(); 
    }
}
