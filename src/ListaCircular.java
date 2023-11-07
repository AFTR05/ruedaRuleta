import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;

class ListaCircular{

    Nodo cab;
    Nodo movil;
    Nodo fin;
    int cn;

    public ListaCircular(){}
    public void iniciar_lista_circular( )
    {
        cab = null;
        fin = null;
        cn = 0;
    }

    public void jugar_ruleta() throws IOException {
        int puntos = 0;
        for (int i = 0; i < 10; i++) {
            int numeroAdivinado = Integer.parseInt(JOptionPane.showInputDialog("Intento " + (i + 1) +
                    ":\nAdivina un número entre el 1 a 30: "));
            int numeroGanador = obtenerNumeroAleatorio();
            String message="";
            message+="Número ganador: " + numeroGanador;

            if (numeroAdivinado == numeroGanador) {
                puntos++;
                message+="\nAdivinaste. ¡Ganas 1 punto!";
            } else {
                message+="\nFallaste. Sigue intentando.";
            }
            JOptionPane.showMessageDialog(null,message);
        }
        JOptionPane.showMessageDialog(null,"Tu puntaje final es: " + puntos);
    }

    public int obtenerNumeroAleatorio(){
        Random rand = new Random();
        int posicion = rand.nextInt(cn) + 1;
        Nodo current = cab;
        for (int i = 1; i < posicion; i++) {
            current = current.sig;
        }
        return current.dato;
    }

    public void imprimir_lista_circular( )
    {
        int nodos = 0;
        movil = cab;
        StringBuilder message = new StringBuilder();
        while(nodos != cn){
            if (nodos == 10){
                message.append("\n");
            }
            message.append(movil.dato).append(" - ");
            movil = movil.sig;
            nodos++;
        }
        JOptionPane.showMessageDialog(null, message.toString());
    }
    public void insertar_nodo_inicio(int numero) {
        Nodo nuevo = new Nodo();
        nuevo.dato = numero;
        if (cab == null) {
            cab = nuevo;
            nuevo.sig = nuevo;
            fin = nuevo;
        } else {
            nuevo.sig = cab;
            cab = nuevo;
            fin.sig = cab;
        }
        cn++;
    }

    public void crear_ruleta() {
        HashSet<Integer> numerosUsados = new HashSet<>();
        Random rand = new Random();
        while (numerosUsados.size() < 20) {
            int numeroAleatorio = rand.nextInt(30) + 1;
            if (!numerosUsados.contains(numeroAleatorio)) {
                insertar_nodo_inicio(numeroAleatorio);
                numerosUsados.add(numeroAleatorio);
            }
        }
    }
    public  void destruir_lista_circular( ){
        Nodo borra;
        borra = cab;
        movil = cab;
        while(cn > 0){
            movil = movil.sig;
            borra = null;
            borra = movil;
            cn--;
        }
    }
}