import java.util.*;

public class Batalla {
    private Jugador jugador;
    private List<Enemigo> enemigos;
    private Queue<String> registro = new LinkedList<>();

    public Batalla(Jugador jugador, List<Enemigo> enemigos) {
        this.jugador = jugador;
        this.enemigos = enemigos;
    }

    public void iniciar() {
        jugador.mensajeInicio();
        enemigos.forEach(Enemigo::mensajeInicio);

        while (jugador.estaVivo() && enemigos.stream().anyMatch(Combatiente::estaVivo)) {
            Vista.mostrarEstado(jugador, enemigos);
            jugador.tomarTurno(elegirEnemigo());

            enemigos.stream().filter(Combatiente::estaVivo).forEach(e -> e.tomarTurno(jugador));

            actualizarRegistro("Turno completado.");
        }

        Vista.mostrarResultado(jugador, enemigos);
    }

    private Enemigo elegirEnemigo() {
        return enemigos.stream().filter(Combatiente::estaVivo).findFirst().orElse(null);
    }

    private void actualizarRegistro(String accion) {
        if (registro.size() == 3) registro.poll();
        registro.add(accion);
        Vista.mostrarRegistro(registro);
    }
}


