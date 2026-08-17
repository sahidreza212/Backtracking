package org.example;

import java.util.ArrayList;

public class Rat_In_Maze {

    static String dir = "DLRU";
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, -1, 1, 0};

    // check if the cell is valid or not

    public static boolean isValid(int r, int c, int n, int[][] maze){
         return  r >= 0  && c >= 0 && r < n && c < n && maze[r][c] == 1;
    }

    // find the all possible paths
    public static void findPath(int r , int c , int n , int[][]maze , StringBuilder path , ArrayList<String>res){


    }
    public static void main(String[] args) {

        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
    }
}
