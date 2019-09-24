
import controller.Operaciones;
import model.Matriz;
import model.Resultados;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjecucionMatriz {


    private static Resultados resultados = new Resultados();
    private static Matriz matriz;
    private static Operaciones operacionesMatriz ;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String valorEntrada;
        resultados.setContinua(true);

        while (resultados.isContinua()){
            valorEntrada = reader.readLine();
            operacionesMatriz = new Operaciones(matriz, resultados);
            operacionesMatriz.Ejecucion(valorEntrada);
        }

        System.out.println(resultados.getResultado());

    }




}
