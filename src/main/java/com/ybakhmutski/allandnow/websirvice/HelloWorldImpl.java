package com.epam.allandnow.websirvice;


import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "com.epam.allandnow.websirvice.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

  @Override
  public String getHelloWorldAsString(String name) {
    return "Hello World JAX-WS " + name;
  }

}
