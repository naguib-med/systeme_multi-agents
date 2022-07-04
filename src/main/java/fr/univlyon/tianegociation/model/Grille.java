package fr.univlyon.tianegociation.model;

import java.util.Arrays;
import java.util.Objects;

public class Grille {
    int[][] grid;
    private final int i =5;
    private final int j = 5;

    public Grille() {
        this.grid = new int[i][j];

        for(int y = 0; y<j; y++){
            for (int x= 0; x<i; x++){
                grid[x][y] = 0;
            }
        }
    }

    public boolean isOccupied(int i, int j){
        return grid[i - 1][j - 1] != 0;
    }

    public boolean move(int iSrc, int jSrc, int iDest, int jDest){
        if (grid[iDest-1][jDest-1] == 0){
            grid[iDest-1][jDest-1] = grid[iSrc-1][jSrc-1];
            grid[iSrc-1][jSrc-1] = 0;
            return true;
        }
        return false;
    }

    public void setAgent(int i, int j, int agentId){
        if (grid[i-1][j-1] == 0){
            grid[i-1][j-1] = agentId;
        }
    }

    public int getMaxI() {
        return i;
    }

    public int getMaxJ() {
        return j;
    }

    public int getAgentId(int i, int j){
        return grid[i-1][j-1];
    }
    @Override
    public String toString() {
        return "Grille{" +
                "grid=" + Arrays.toString(grid) +
                ", i=" + i +
                ", j=" + j +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grille)) return false;
        Grille grille = (Grille) o;
        return i == grille.i && j == grille.j && Arrays.equals(grid, grille.grid);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(i, j);
        result = 31 * result + Arrays.hashCode(grid);
        return result;
    }
}
