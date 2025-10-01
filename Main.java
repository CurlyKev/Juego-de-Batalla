import java.util.*;

public class Main {
    public static void main(String[] args) {
List<Item> inventario = new ArrayList<>();
inventario.add(new Item("Poción", 30, 0, 2));
inventario.add(new Item("Furia", 0, 10, 1));

        Scanner sc = new Scanner(System.in);
        Vista.mostrar("Elige tu rol: 1. Guerrero  2. Explorador");
        int opcion = sc.nextInt();
        Rol rol = (opcion == 1) ? Rol.GUERRERO : Rol.EXPLORADOR;

        Jugador jugador = new Jugador("Jugador 1", rol, inventario);

        List<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(new EnemigoNormal("Goblin"));
        enemigos.add(new EnemigoNormal("Orco"));
        enemigos.add(new Jefe("Malenia"));

        Batalla batalla = new Batalla(jugador, enemigos);
        batalla.iniciar();
    }
}


