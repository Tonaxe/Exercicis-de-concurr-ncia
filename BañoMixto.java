public class BañoMixto {
    public String ocupadoPor;
    private int contador;
    private final int capacidadMaxima;
    boolean esperando;

    public BañoMixto(int capacidadMaxima) {
        this.ocupadoPor = "ninguno";
        this.contador = 0;
        this.capacidadMaxima = capacidadMaxima;
        esperando = false;
    }

    public synchronized void entrarBaño(String quien) {
        do {
            esperando = true;
            if (this.ocupadoPor.equals(quien) && contador < capacidadMaxima) {
                contador++;
                esperando = false;
            } else if (this.ocupadoPor.equals("ninguno")) {
                ocupadoPor = quien;
                contador++;
                System.out.println("CAMBIO a " + ocupadoPor);
                notifyAll();
                esperando = false;
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } while (esperando);
    }

    public synchronized void salirBaño() {
        if (contador == 1) {
            contador--;
            ocupadoPor = "ninguno";
        } else {
            contador--;
        }
        notifyAll();
    }
}
