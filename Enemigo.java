public abstract class Enemigo extends Combatiente {
    public Enemigo(String nombre, int vida, int ataque) {
        super(nombre, vida, ataque);
    }

    public abstract void habilidadEspecial(Combatiente objetivo);
}


