package soapquadraticequation.rest.soapClients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import soap_quadratice_quation.GetSolutionQuadraticEquationRequest;
import soap_quadratice_quation.GetSolutionQuadraticEquationResponse;


public class SoapClient extends WebServiceGatewaySupport {

    @Autowired
    private Jaxb2Marshaller marshaller;

    public GetSolutionQuadraticEquationResponse getQuadraticEquationSolution(Double a, Double b, Double c){

        GetSolutionQuadraticEquationRequest request = new GetSolutionQuadraticEquationRequest();
        request.setA(a);
        request.setB(b);
        request.setC(c);

        GetSolutionQuadraticEquationResponse response = (GetSolutionQuadraticEquationResponse) getWebServiceTemplate()
            .marshalSendAndReceive("http://localhost:8080/ws/quadraticEquation.wsdl", request,
                    new SoapActionCallback(
                            "http://soap-quadratice-quation"));

        return response;

    }

}
