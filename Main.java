import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Veneno", 35, 0));
        items.add(new Item("Furia", 0, 10));
        items.add(new Item("Sanacion", 40, 0));

        Scanner sc = new Scanner(System.in);
        Vista.mostrar("Elige tu rol: 1. Guerrero  2. Explorador");
        int opcion = sc.nextInt();
        Rol rol = (opcion == 1) ? Rol.GUERRERO : Rol.EXPLORADOR;

        Jugador jugador = new Jugador("Jugador 1", rol, items);

        List<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(new EnemigoNormal("Goblin"));
        enemigos.add(new Jefe("Dragón"));

        Batalla batalla = new Batalla(jugador, enemigos);
        batalla.iniciar();
    }
}


