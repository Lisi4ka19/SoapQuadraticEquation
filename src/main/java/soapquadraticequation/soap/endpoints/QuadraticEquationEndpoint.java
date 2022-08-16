package soapquadraticequation.soap.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import soap_quadratice_quation.*;
import soapquadraticequation.soap.repositories.QuadraticEquationRepository;

@Endpoint
public class QuadraticEquationEndpoint {

    private static final String NAMESPACE_URI = "http://soap-quadratice-quation";

    private QuadraticEquationRepository quadraticEquationRepository;

    @Autowired
    public QuadraticEquationEndpoint(QuadraticEquationRepository quadraticEquationRepository) {
        this.quadraticEquationRepository = quadraticEquationRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSolutionQuadraticEquationRequest")
    @ResponsePayload
    public GetSolutionQuadraticEquationResponse getSolution(@RequestPayload GetSolutionQuadraticEquationRequest request) {
        GetSolutionQuadraticEquationResponse response = new GetSolutionQuadraticEquationResponse();

        response.setResponse(quadraticEquationRepository.getSolution(request.getA(), request.getB(), request.getC()));

        return response;
    }


}
