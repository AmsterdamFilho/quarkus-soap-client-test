package com.learnwebservices.hello;

import com.dataaccess.webservicesserver.NumberConversion;
import com.dataaccess.webservicesserver.NumberConversionSoapType;
import com.learnwebservices.services.hello.HelloEndpoint;
import com.learnwebservices.services.hello.HelloEndpointService;
import com.learnwebservices.services.hello.HelloRequest;
import de.mathertel.ortelookup.OrteLookup;
import de.mathertel.ortelookup.OrteLookupSoap;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;

public class HelloMain {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL");
        NumberConversionSoapType numberConversion = new NumberConversion(url).getNumberConversionSoap();
        System.out.println(numberConversion.numberToWords(BigInteger.valueOf(12301L)));

        url = new URL("http://www.learnwebservices.com/services/hello?wsdl");
        HelloEndpoint hello = new HelloEndpointService(url).getHelloEndpointPort();
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setName("max johnson");
        System.out.println(hello.sayHello(helloRequest).getMessage());

        url = new URL("http://mathertel.de/AJAXEngine/S02_AJAXCoreSamples/OrteLookup.asmx?wsdl");
        OrteLookupSoap orteLookup = new OrteLookup(url).getOrteLookupSoap12();
        System.out.println(orteLookup.orteStartWith("ber"));
    }
}
