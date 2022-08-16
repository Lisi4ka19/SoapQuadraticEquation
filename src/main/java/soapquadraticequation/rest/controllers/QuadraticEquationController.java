package soapquadraticequation.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import soap_quadratice_quation.GetSolutionQuadraticEquationResponse;
import soapquadraticequation.rest.dto.RestResponse;
import soapquadraticequation.rest.soapClients.SoapClient;

@RestController
@RequestMapping("/api/")
public class QuadraticEquationController {

    @Autowired
    SoapClient soapClient;

    @GetMapping("/calc")
    public RestResponse getResultEquation(@RequestParam("a") String value1,
                                          @RequestParam("b") String value2,
                                          @RequestParam("c")  String value3){

        RestResponse response = new RestResponse();
        response.setFormula("A*X^2+B*X+C=0");
        StringBuilder error = new StringBuilder();

        Double a = checkParameter(value1, "a", error);
        Double b = checkParameter(value2, "b", error);
        Double c = checkParameter(value3, "c", error);

        if (error.length()!=0){
            response.setError(error.toString());
            return response;
        }

        GetSolutionQuadraticEquationResponse WSDLResponse = soapClient.getQuadraticEquationSolution(a, b, c);

        response.fillFromWSDL(WSDLResponse.getResponse());


        return response;

    }

    private Double checkParameter(String value, String nameParameter, StringBuilder error){
       Double result = null;
       
        if(value.length()==0) error.append("Parameter ").append(nameParameter)
                            .append(" is empty. ");
        try {
            result = Double.parseDouble(value);

        } catch (NumberFormatException e) {
            error.append("Convert error parameter ").append(nameParameter)
                            .append(" to Double. ");
        }
        
        return result;
    }
    
    
    
}
