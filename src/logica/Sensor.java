package logica;

public abstract class Sensor {
    private int id;
    private String nombre;
    protected float ultimaLectura;

    public Sensor(int id, String nombre, float ultimaLectura) {
        this.id = id;
        this.nombre = nombre;
        this.ultimaLectura = 0.0f;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getUltimaLectura() {
        return ultimaLectura;
    }

    public void setUltimaLectura(float ultimaLectura) {
        this.ultimaLectura = ultimaLectura;
    }
    
    public abstract float leerValor();
}
