package soapquadraticequation.soap.servises;

public  class QuadraticEquationSolutionService {

    public static QuadraticEquationSolution getSolution(double a, double b, double c){

        QuadraticEquationSolution solution = new QuadraticEquationSolution();
        solution.setA(a);
        solution.setB(b);
        solution.setC(c);

        solution.setFormula("A*X^2+B*X+C=0");

        double D = getDiscriminant(a, b, c);
        solution.setD(D);

        try {
            getValueX(a, b, D, solution);
        } catch (Exception e) {
            solution.setError(e.getMessage());
        }

        return solution;
    }

    private static double getDiscriminant(double a, double b, double c) {
        double D = Math.pow(b, 2)- 4 * a * c;

        return D;
    }

    private static void getValueX(double a, double b, double D, QuadraticEquationSolution solution) throws Exception {

        if(D < 0 ){
            throw new Exception("D less than 0");
        }
        else if(D == 0){
            double x = - b / (2 * a);
            solution.setX1(x);
        }
        else {
            double x1 = (-b + Math.sqrt(D) )/ (2 * a);
            double x2 = (-b - Math.sqrt(D) )/ (2 * a);
            solution.setX1(x1);
            solution.setX2(x2);
        }

    }
}
