public class EnemigoNormal extends Enemigo {
    public EnemigoNormal(String nombre) {
        super(nombre, 80, 15);
    }

    @Override
    public void mensajeInicio() {
        Vista.mostrar(nombre + " aparece como enemigo normal.");
    }

    @Override
    public void mensajeFinal() {
        Vista.mostrar(nombre + " ha sido derrotado.");
    }

    @Override
    public void tomarTurno(Combatiente objetivo) {
        Vista.mostrar(nombre + " ataca a " + objetivo.getNombre());
        objetivo.recibirDanio(ataque);
    }

    @Override
    public void habilidadEspecial(Combatiente objetivo) {
        Vista.mostrar(nombre + " usa veneno en " + objetivo.getNombre());
        objetivo.recibirDanio(10);
    }
}

