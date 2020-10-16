package br.com.luvva;

import com.dataaccess.webservicesserver.NumberConversion;
import com.dataaccess.webservicesserver.NumberConversionSoapType;
import com.learnwebservices.services.hello.HelloEndpoint;
import com.learnwebservices.services.hello.HelloEndpointService;
import com.learnwebservices.services.hello.HelloRequest;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;

@Path("/")
@Tag(name = "default")
public class SoapResource {

    @POST
    @Path("hello/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(@PathParam("name") String name) throws MalformedURLException {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        URL url = new URL("http://www.learnwebservices.com/services/hello?wsdl");
        HelloEndpointService service = new HelloEndpointService(url);
        HelloEndpoint port = service.getHelloEndpointPort();
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setName(name);
        return port.sayHello(helloRequest).getMessage();
    }

    @POST
    @Path("number-conversion/{number}")
    @Produces(MediaType.TEXT_PLAIN)
    public String numberConversion(@PathParam("number") BigInteger number) throws MalformedURLException {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        URL url = new URL("http://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL");
        NumberConversion service = new NumberConversion(url);
        NumberConversionSoapType port = service.getNumberConversionSoap();
        return port.numberToWords(number);
    }
}
