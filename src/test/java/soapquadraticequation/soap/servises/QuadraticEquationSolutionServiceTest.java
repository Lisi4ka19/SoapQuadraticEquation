package soapquadraticequation.soap.servises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuadraticEquationSolutionServiceTest {

    @Test
    void getWithoutSolution() {

        QuadraticEquationSolution solution = QuadraticEquationSolutionService.getSolution(1, 2, 3);
        Assertions.assertEquals(solution.getD(), -8);
        Assertions.assertEquals(solution.getX1(), null);
        Assertions.assertEquals(solution.getX2(), null);
    }

    @Test
    void getOneSolution() {
        QuadraticEquationSolution solution = QuadraticEquationSolutionService.getSolution(1, -6, 9);
        Assertions.assertEquals(solution.getD(), 0);
        Assertions.assertEquals(solution.getX1(),  3);
        Assertions.assertEquals(solution.getX2(), null);



    }


    @Test
    void getTwoSolution() {
        QuadraticEquationSolution solution = QuadraticEquationSolutionService.getSolution(1, -4, -5);
        Assertions.assertEquals(solution.getD(), 36);
        Assertions.assertEquals(solution.getX1(),  5);
        Assertions.assertEquals(solution.getX2(), -1);

    }
}