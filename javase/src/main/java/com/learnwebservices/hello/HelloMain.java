package com.learnwebservices.hello;

import com.dataaccess.webservicesserver.NumberConversion;
import com.dataaccess.webservicesserver.NumberConversionSoapType;
import com.learnwebservices.services.hello.HelloEndpoint;
import com.learnwebservices.services.hello.HelloEndpointService;
import com.learnwebservices.services.hello.HelloRequest;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;

public class HelloMain {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL");
        NumberConversionSoapType port1 = new NumberConversion(url).getNumberConversionSoap();
        System.out.println(port1.numberToWords(BigInteger.valueOf(12301L)));

        url = new URL("http://www.learnwebservices.com/services/hello?wsdl");
        HelloEndpoint port2 = new HelloEndpointService(url).getHelloEndpointPort();
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setName("max johnson");
        System.out.println(port2.sayHello(helloRequest).getMessage());
    }
}
