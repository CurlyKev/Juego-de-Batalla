import java.util.*;

public class Vista {
    public static void mostrar(String mensaje) {
        System.out.println(mensaje);
    }

    public static void mostrarEstado(Jugador jugador, List<Enemigo> enemigos) {
        mostrar("Estado actual:");
        mostrar(jugador.getNombre() + " - Vida: " + jugador.getVida());
        for (Enemigo e : enemigos) {
            mostrar(e.getNombre() + " - Vida: " + e.getVida());
        }
    }

    public static void mostrarTurnoJugador(Jugador jugador, List<Item> items, Combatiente objetivo) {
        mostrar("Turno de " + jugador.getNombre());
        mostrar("1. Atacar\n2. Usar ítem\n3. Pasar turno");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1 -> {
                mostrar(jugador.getNombre() + " ataca a " + objetivo.getNombre());
                objetivo.recibirDanio(jugador.ataque);
            }
            case 2 -> {
                mostrar("Elige ítem:");
                for (int i = 0; i < items.size(); i++) {
                    mostrar((i + 1) + ". " + items.get(i).getNombre());
                }
                int idx = sc.nextInt() - 1;
                items.get(idx).usar(jugador);
                items.remove(idx);
            }
            default -> mostrar(jugador.getNombre() + " pasa su turno.");
        }
    }

    public static void mostrarRegistro(Queue<String> registro) {
        mostrar("Últimas acciones:");
        for (String r : registro) mostrar("- " + r);
    }

    public static void mostrarResultado(Jugador jugador, List<Enemigo> enemigos) {
        if (jugador.estaVivo()) mostrar("¡Victoria!");
        else mostrar("Derrota...");
    }
}

