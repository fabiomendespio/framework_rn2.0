package network;

public class FunctionActivation {

    public static double sigmoid(double n) {
        System.out.println("Ativando a função Sigmoid");
        return 1 / (1 + Math.exp(-n));
    }

    public static double degrau(double n) {
        System.out.println("Ativando a função degrau");
        if (n > 0) {
            System.out.println("retorno da função degrau = 1");
            return 1;
        } else {
            System.out.println("retorno da função degrau = 0");
            return 0;
        }
    }

}
