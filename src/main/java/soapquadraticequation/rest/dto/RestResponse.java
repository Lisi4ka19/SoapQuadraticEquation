package soapquadraticequation.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import soap_quadratice_quation.SoapResponse;

public class RestResponse {

    private String formula;
    private Double D;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double x1;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double x2;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;

    public String getFormula() {
        return formula;
    }

    public void fillFromWSDL(SoapResponse WSDLResponse){

        StringBuilder error = new StringBuilder();

        if(this.getError() != null) error.append(this.error);

        this.formula = WSDLResponse.getFormula();

        try {
            if (WSDLResponse.getD() != null) this.D = Double.parseDouble(WSDLResponse.getD());
        } catch (NumberFormatException e) {
            error.append("conversion error D from WSDl response. ");
        }

        try {
            if (WSDLResponse.getX1() != null) this.x1 = Double.parseDouble(WSDLResponse.getX1());
        } catch (NumberFormatException e) {
            error.append("conversion error X1 from WSDl response. ");
        }

        try {
            if (WSDLResponse.getX2() != null) this.x2 = Double.parseDouble(WSDLResponse.getX2());
        } catch (NumberFormatException e) {
            error.append("conversion error X2 from WSDl response. ");
        }

        if (WSDLResponse.getError() != null)error.append(WSDLResponse.getError());

        this.error = error.toString();

    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Double getD() {
        return D;
    }

    public void setD(Double d) {
        D = d;
    }

    public Double getX1() {
        return x1;
    }

    public void setX1(Double x1) {
        this.x1 = x1;
    }

    public Double getX2() {
        return x2;
    }

    public void setX2(Double x2) {
        this.x2 = x2;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
