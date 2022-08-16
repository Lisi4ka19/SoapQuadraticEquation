package soapquadraticequation.soap.repositories;

import soap_quadratice_quation.SoapResponse;
import org.springframework.stereotype.Component;
import soapquadraticequation.soap.servises.QuadraticEquationSolution;
import soapquadraticequation.soap.servises.QuadraticEquationSolutionService;

@Component
public class QuadraticEquationRepository {

    public SoapResponse getSolution(double a, double b, double c){
        SoapResponse response = new SoapResponse();

        QuadraticEquationSolution solution = QuadraticEquationSolutionService.getSolution(a, b, c);
        response.setFormula(solution.getFormula());
        response.setD(String.valueOf(solution.getD()));
        response.setError(solution.getError());

        if(solution.getX1()!=null)response.setX1(String.valueOf(solution.getX1()));
        if(solution.getX2()!=null)response.setX2(String.valueOf(solution.getX2()));


        return response;
    }


}
