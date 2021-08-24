package org.hoss.mn.controller;

import com.google.api.client.auth.oauth2.Credential;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.hoss.mn.config.ApplicationConfig;
import org.hoss.mn.services.GoogleSheetsAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@Controller("/hello")
public class HelloController {
    private static Logger logger = LoggerFactory.getLogger(HelloController.class);


    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() throws IOException {

        return "Hello World";
    }
}
