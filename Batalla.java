import java.util.*;

public class Batalla {
    private Jugador jugador;
    private List<Enemigo> enemigos;
    private Queue<String> registro = new LinkedList<>();
    private List<Combatiente> combatientes = new ArrayList<>();
    private List<String> accionesJugador = new ArrayList<>();

    public Batalla(Jugador jugador, List<Enemigo> enemigos) {
        this.jugador = jugador;
        this.enemigos = enemigos;
        this.combatientes.add(jugador);
        this.combatientes.addAll(enemigos);
    }

    public void iniciar() {
        jugador.mensajeInicio();
        enemigos.forEach(Enemigo::mensajeInicio);

        while (jugador.estaVivo() && enemigos.stream().anyMatch(Combatiente::estaVivo)) {
            Vista.mostrarEstado(jugador, enemigos);
            Combatiente objetivo = elegirEnemigo();
            Vista.mostrarTurnoJugador(jugador, jugador.getItems(), objetivo);

            // Registrar acción del jugador
            String accionJugador = jugador.getNombre() + " tomó su turno contra " + objetivo.getNombre();
            if (accionesJugador.size() == 3) accionesJugador.remove(0);
            accionesJugador.add(accionJugador);
            Vista.mostrarAccionesJugador(accionesJugador);

            enemigos.stream().filter(Combatiente::estaVivo).forEach(e -> e.tomarTurno(jugador));

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
        if (registro.size() == 3) registro.poll();
        registro.add(accion);
        Vista.mostrarRegistro(registro);
    }
}


