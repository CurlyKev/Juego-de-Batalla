public class Jefe extends EnemigoNormal {
    public Jefe(String nombre) {
        super(nombre);
        this.vida += 50;
        this.ataque += 10;
    }

    @Override
    public void habilidadEspecial(Combatiente objetivo) {
        super.habilidadEspecial(objetivo);
        Vista.mostrar(nombre + " usa habilidad de jefe: escudo mágico.");
        this.vida += 20;
    }

    @Override
    public void mensajeInicio() {
        Vista.mostrar(nombre + " aparece como JEFE.");
    }
}


