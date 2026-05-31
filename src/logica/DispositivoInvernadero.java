package logica;

public class DispositivoInvernadero {
    private int id;
    private String nombre;
    private boolean estado;
    private double consumoEnergetico;

    public DispositivoInvernadero(int id, String nombre, double consumoEnergetico) {
        this.id = id;
        this.nombre = nombre;
        this.consumoEnergetico = consumoEnergetico;
        this.estado = false;
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

    public double getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void encender(){
        if(!estado){
            estado = true;
            System.out.println("Dispositivo ["+nombre+"] ENCENDIDO");
        }
    }
    
    public void apagar(){
        if(estado){
            estado=false;
            System.out.println("Dispositivo ["+nombre+"] APAGADO");
        }
    }
    
    public boolean obtenerEstado(){
        return estado;
    }
}
