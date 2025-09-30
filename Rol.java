public class Rol {
    private String nombre;
    private int vida;
    private int ataque;

    public Rol(String nombre, int vida, int ataque) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
    }

    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getAtaque() { return ataque; }

    public static Rol GUERRERO = new Rol("Guerrero", 150, 30);
    public static Rol EXPLORADOR = new Rol("Explorador", 100, 20);
}


