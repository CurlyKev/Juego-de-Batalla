import java.util.List;

public class Jugador extends Combatiente {
    private List<Item> items;
    private Rol rol;

    public Jugador(String nombre, Rol rol, List<Item> items) {
        super(nombre, rol.getVida(), rol.getAtaque());
        this.rol = rol;
        this.items = items;
    }

    @Override
    public void mensajeInicio() {
        Vista.mostrar("¡" + nombre + " entra en batalla como " + rol.getNombre() + "!");
    }

    @Override
    public void mensajeFinal() {
        Vista.mostrar(nombre + " ha caído en batalla.");
    }

    @Override
    public void tomarTurno(Combatiente objetivo) {
        Vista.mostrarTurnoJugador(this, items, objetivo);
    }

    public List<Item> getItems() { return items; }
}


