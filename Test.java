public class Test {
    public static void main(String[] args) {
        System.out.println("ODEtest Result: " + ODEtest());
    }

    public static boolean ODEtest(){

        class GenericODE implements FirstOrderODE{
            public double charEqu(double x, double y){
                return Math.exp(x);
            }
        }

        GenericODE naturalExpontial = new GenericODE();
        double[][] solutionMatrix = new double[11][4];
        double[] initialValues = {0,1,1,1};
        solutionMatrix[0] = initialValues;
        double step = 0.5;

        for(int i = 0; i < 10; i++){
            double x = solutionMatrix[i][0];
            double[] nextRow = {x+step, naturalExpontial.charEqu(x+step, 0), ODESolver.Euler(x, solutionMatrix[i][2], step, naturalExpontial), ODESolver.RK4(solutionMatrix[i][0], solutionMatrix[i][3], step, naturalExpontial)};
            solutionMatrix[i+1] = nextRow;
        }

        boolean testResult = true;
        for(int i = 0; i < 11; i++){
            testResult &= (((solutionMatrix[i][1] - solutionMatrix[i][3])/solutionMatrix[i][1]) < 0.01);
        }

        return testResult;

    }
}
