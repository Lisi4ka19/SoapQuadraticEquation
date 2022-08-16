package soapquadraticequation.rest.restConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import soapquadraticequation.rest.soapClients.SoapClient;

@Configuration
public class soapClientConfig {



    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("soap_quadratice_quation");
        return marshaller;
    }

    @Bean
    public SoapClient soapClient(Jaxb2Marshaller marshaller) {

        SoapClient client = new SoapClient();

        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
