package controller;

import model.Iteraciones;
import model.Matriz;
import model.Resultados;

public class Operaciones {

    Iteraciones iteraciones = new Iteraciones(0);
    public final Matriz matriz;
    public final Resultados resultadoMatriz;
    private int iteracionesEjecutadas = 0;


    public Operaciones(Matriz matriz, Resultados resultadoMatriz) {
        this.matriz = matriz;
        this.resultadoMatriz = resultadoMatriz;
    }

    public void Ejecucion(String entrada){

        int opcion;
        int resultadoTemp;
        String textoTemp;

        int[] parametros = this.procesarEntrada(entrada);
        this.iteracionesEjecutadas++;

        if(iteraciones.getIteraciones()==0){
            return;
        }
        else if(this.iteracionesEjecutadas>iteraciones.getIteraciones()) {
            this.resultadoMatriz.setContinua(false);
        }

        opcion = parametros.length;

        switch(opcion){
            case 2:
                this.matriz.crearMatriz(parametros[0],parametros[1]);
                break;

            case 4:
                this.UpdateMatriz(this.matriz, parametros[0],parametros[1],parametros[2],parametros[3]);
                break;

            case 6:
                resultadoTemp = this.QueryMatriz(this.matriz, parametros[0],parametros[1],parametros[2],parametros[3],parametros[4],parametros[5]);
                textoTemp = this.resultadoMatriz.getResultado() + "\n" + resultadoTemp;
                this.resultadoMatriz.setResultado(textoTemp);
                break;
        }
    }

    private void UpdateMatriz(Matriz matriz, int m, int n, int o, int valor){
        m--;
        n--;
        o--;

        matriz.setMatriz(m, n, o, valor);
    }

    private int QueryMatriz(Matriz matriz, int posInim, int posInin, int posInio, int posFinm, int posFinn, int posFino){

        int resultado = 0;
        posInim--;
        posInin--;
        posInio--;

        for(int i=posInim;i<posFinm;i++){
            for(int j=posInin;j<posFinn;j++){
                for(int k=posInio;k<posFino;k++){
                    resultado+= matriz.getValorMatriz(i,j,k);
                }
            }
        }

        return resultado;
    }


    private int[] procesarEntrada(String entrada){

        int[] resultado = null;
        String arr[]=entrada.split("\t");

        if(arr.length==1 && iteraciones.getIteraciones()==0){
            iteraciones.setIteraciones(Integer.parseInt(arr[0]));
            resultado = new int[1];
            resultado[0] = 0;
        }
        else if(arr.length==2 && iteraciones.getIteraciones()!=0){
            resultado = new int[2];
            resultado[0] = Integer.parseInt(arr[0]);
            resultado[1] = Integer.parseInt(arr[1]);
        }
        else if(arr[0].equals("UPDATE")){
            resultado = new int[4];
            resultado[0] = Integer.parseInt(arr[1]);
            resultado[1] = Integer.parseInt(arr[2]);
            resultado[2] = Integer.parseInt(arr[3]);
            resultado[3] = Integer.parseInt(arr[4]);
        }
        else if(arr[0].equals("QUERY")){
            resultado = new int[6];
            resultado[0] = Integer.parseInt(arr[1]);
            resultado[1] = Integer.parseInt(arr[2]);
            resultado[2] = Integer.parseInt(arr[3]);
            resultado[3] = Integer.parseInt(arr[4]);
            resultado[4] = Integer.parseInt(arr[5]);
            resultado[5] = Integer.parseInt(arr[6]);
        }

        return resultado;
    }

}

