import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
    public CalculatorServer() {
        try {
            CalculatorInterface calculator = new CalculatorImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost/CalculatorService", calculator);
            System.out.println("Calculator service is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CalculatorServer();
    }
}
