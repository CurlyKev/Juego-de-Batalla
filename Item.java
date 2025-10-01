public class Item {
    private String nombre;
    private int efectoVida;
    private int efectoAtaque;
    private int cantidad;

    public Item(String nombre, int efectoVida, int efectoAtaque, int cantidad) {
        this.nombre = nombre;
        this.efectoVida = efectoVida;
        this.efectoAtaque = efectoAtaque;
        this.cantidad = cantidad;
    }

    public void usar(Combatiente objetivo) {
        if (cantidad <= 0) {
            Vista.mostrar("No queda cantidad de " + nombre + " para usar.");
            return;
        }

        objetivo.recibirDanio(-efectoVida);
        objetivo.ataque += efectoAtaque;
        cantidad--;
        Vista.mostrar(nombre + " usado en " + objetivo.getNombre() + ". Quedan: " + cantidad);
    }

    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
}

