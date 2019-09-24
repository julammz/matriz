package model;

public class Matriz {

    private int m;
    private int n;
    private int o;
    private final int[][][] valoresMatriz;


    public Matriz(int dimension) {
        this.m = dimension;
        this.n = dimension;
        this.o = dimension;
        valoresMatriz = new int[m][n][o];
    }



    public int[][][] getValoresMatriz() {
        return valoresMatriz;
    }


}
