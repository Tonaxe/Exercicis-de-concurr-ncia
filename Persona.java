public class Persona extends Thread {
    private String nombre;
    private String tipo;
    private BañoMixto baño;

    public Persona(String nombre, String tipo, BañoMixto baño) {
        this.tipo = tipo;
        this.baño = baño;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        do {
            esperando();
            irAlBaño();
        } while (true);
    }

    public String getNombrePersona() {
        return nombre;
    }

    private void irAlBaño() {
        try {
            baño.entrarBaño(tipo);
            System.out.println(nombre + " está en el BAÑO!");
            Thread.sleep((long) ((Math.random() * 1000) + 500));
            baño.salirBaño();
            Thread.sleep((long) (Math.random() * 50));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void esperando() {
        try {
            System.out.println(nombre + " está ESPERANDO!");
            Thread.sleep((long) ((Math.random() * 1000) + 500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
