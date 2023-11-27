import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BañoMixto bañoMixto = new BañoMixto(5);
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Nobara", "mujer", bañoMixto));
        personas.add(new Persona("Maki", "mujer", bañoMixto));
        personas.add(new Persona("Gojo", "hombre", bañoMixto));
        personas.add(new Persona("Sukuna", "hombre", bañoMixto));
        personas.add(new Persona("Isagi", "niño", bañoMixto));
        personas.add(new Persona("Shin", "niño", bañoMixto));

        personas.forEach(persona -> {
            System.out.println(persona.getNombrePersona());
            persona.start();
        });
    }
}
