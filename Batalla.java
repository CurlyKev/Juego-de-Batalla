import java.util.*;

public class Batalla {
    private Jugador jugador;
    private List<Enemigo> enemigos;
    private Queue<String> registroAcciones = new LinkedList<>();
    private List<Combatiente> listaCombatientes = new ArrayList<>();
    private List<String> accionesJugador = new ArrayList<>();

    public Batalla(Jugador jugador, List<Enemigo> enemigos) {
        this.jugador = jugador;
        this.enemigos = enemigos;
        this.listaCombatientes.add(jugador);
        this.listaCombatientes.addAll(enemigos);
    }

    public void iniciar() {
        jugador.mensajeInicio();
        enemigos.forEach(Enemigo::mensajeInicio);

        while (jugador.estaVivo() && enemigos.stream().anyMatch(Combatiente::estaVivo)) {
            Vista.mostrarEstado(jugador, enemigos);
            Combatiente objetivo = elegirEnemigo();
            Vista.mostrarTurnoJugador(jugador, jugador.getInventario(), objetivo);

            String accion = jugador.getNombre() + " tomó su turno contra " + objetivo.getNombre();
            if (accionesJugador.size() == 3) accionesJugador.remove(0);
            accionesJugador.add(accion);
            Vista.mostrarAccionesJugador(accionesJugador);

            List<Enemigo> vivos = enemigos.stream().filter(Combatiente::estaVivo).toList();
            if (!vivos.isEmpty()) {
                Enemigo atacante = vivos.get(new Random().nextInt(vivos.size()));
                atacante.tomarTurno(jugador);
}

            actualizarRegistro("Turno completado.");
        }

        Vista.mostrarResultado(jugador, enemigos);
    }

    private Enemigo elegirEnemigo() {
        List<Enemigo> vivos = enemigos.stream().filter(Combatiente::estaVivo).toList();
        if (vivos.size() == 1) return vivos.get(0);
        

        Vista.mostrar("Elige enemigo:");
        for (int i = 0; i < vivos.size(); i++) {
            Vista.mostrar((i + 1) + ". " + vivos.get(i).getNombre() + " - Vida: " + vivos.get(i).getVida());
        }
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        return vivos.get(opcion - 1);
    }

    private void actualizarRegistro(String accion) {
        if (registroAcciones.size() == 3) registroAcciones.poll();
        registroAcciones.add(accion);
        Vista.mostrarRegistro(registroAcciones);
    }
}