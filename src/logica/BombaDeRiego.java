package logica;

public class BombaDeRiego extends DispositivoInvernadero {
    private float humedadUmbral;

    public BombaDeRiego(int id, String nombre, double consumoEnergetico) {
        super(id, nombre, consumoEnergetico);
    }

    

    public float getHumedadUmbral() {
        return humedadUmbral;
    }
            
}
