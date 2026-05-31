package logica;

import igu.Pantalla;

public class MainGUI {
   
    public static void main(String[] args) {

        // 1. Instanciamos el gestor de la lógica
        GestorInvernadero miGestor = new GestorInvernadero();

        // 2. Registramos los dispositivos usando agregarDispositivos (En PLURAL, con 's')
        // De esta manera invocamos tu método polimórfico que acepta DispositivoInvernadero
        miGestor.agregarDispositivos(new Ventilador(101, "Ventilador Extractor", 150.0));
        miGestor.agregarDispositivos(new BombaDeRiego(102, "Bomba de Agua Principal", 80.0));
        miGestor.agregarDispositivos(new LamparaUV(103, "Lampara Termica UV", 210.0));

        // 3. Abrimos la interfaz gráfica pasándole el gestor
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla(miGestor).setVisible(true);
            }
        });
        
    }
}