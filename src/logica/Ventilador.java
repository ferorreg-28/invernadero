package logica;


public class Ventilador extends DispositivoInvernadero {
    private float temperaturaUmbral;

    public Ventilador(int id, String nombre, double consumoEnergetico) {
        super(id, nombre, consumoEnergetico);
    }

    public float getTemperaturaUmbral() {
        return temperaturaUmbral;
    }
    
    
}
