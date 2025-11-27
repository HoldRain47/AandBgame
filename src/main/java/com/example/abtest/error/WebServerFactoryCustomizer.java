package com.example.abtest.error;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class WebServerFactoryCustomizer implements org.springframework.boot.web.server.WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
 @Override
  public void customize(ConfigurableWebServerFactory factory) {
   ErrorPage error500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");
   ErrorPage error400 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
   factory.addErrorPages(error500,error400);
 }
}
