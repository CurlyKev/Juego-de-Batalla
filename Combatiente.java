public abstract class Combatiente {
    protected String nombre;
    protected int vida;
    protected int ataque;

    public Combatiente(String nombre, int vida, int ataque) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
    }

    public abstract void mensajeInicio();
    public abstract void mensajeFinal();
    public abstract void tomarTurno(Combatiente objetivo);

    public boolean estaVivo() {
        return vida > 0;
    }

    public void recibirDanio(int cantidad) {
        vida -= cantidad;
        if (vida < 0) vida = 0;
    }

    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
}

