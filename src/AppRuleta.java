import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppRuleta {

    public static void main(String[ ] args)throws IOException {
        int opc;
        ListaCircular listaC = new ListaCircular();
        listaC.iniciar_lista_circular();
        listaC.crear_ruleta();

        do{
            opc=Integer.parseInt(JOptionPane.showInputDialog("1.Jugar a la ruleta en mejor de 10 veces\n2.Imprimir Lista Circular\n3.Salir" +
                    "\nDigite la opción"));
            switch (opc) {
                case 1 -> listaC.jugar_ruleta();
                case 2 -> listaC.imprimir_lista_circular();
            }
        }
        while (opc!=3);
        listaC.destruir_lista_circular( );
    }
}
