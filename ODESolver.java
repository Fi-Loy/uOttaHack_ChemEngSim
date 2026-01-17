public class ODESolver {
    public static double Euler(double x, double yn, double h, FirstOrderODE ode){
        return yn + h * ode.charEqu(x, yn);
    }

    public static double RK4(double x, double yn, double h, FirstOrderODE ode){
        double k1 = ode.charEqu(x, yn);
        double k2 = ode.charEqu(x + h/2, yn + h*k1/2);
        double k3 = ode.charEqu(x + h/2, yn + h*k2/2);
        double k4 = ode.charEqu(x + h, yn + h*k3);

        return yn + h/6*(k1 + 2*k2 + 2*k3 + k4);
    }
}


