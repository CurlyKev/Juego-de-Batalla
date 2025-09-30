public class Item {
    private String nombre;
    private int efectoVida;
    private int efectoAtaque;

    public Item(String nombre, int efectoVida, int efectoAtaque) {
        this.nombre = nombre;
        this.efectoVida = efectoVida;
        this.efectoAtaque = efectoAtaque;
    }

    public void usar(Combatiente objetivo) {
        objetivo.recibirDanio(-efectoVida); // Curar
        objetivo.ataque += efectoAtaque;
        Vista.mostrar(nombre + " usado en " + objetivo.getNombre());
    }

    public String getNombre() { return nombre; }
}

