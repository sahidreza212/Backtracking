package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Rat_In_Maze {

    static String dir = "DLRU";
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, -1, 1, 0};

    // check if the cell is valid or not

    public static boolean isValid(int r, int c, int n, int[][] maze){
         return  r >= 0  && c >= 0 && r < n && c < n && maze[r][c] == 1;
    }

    // find the all possible paths
    public static void findPath(int r , int c , int[][]maze , StringBuilder path , ArrayList<String>res){

        int n = maze.length;
         // base case
        if(r == n-1 && c == n-1){
           res.add(path.toString());
           return;
        }

        maze[r][c] = 0;
        for(int i = 0; i<4; i++){
            int nr = r+dr[i], nc = c+dc[i];
            if(isValid(nr,nc,n,maze)){
                path.append(dir.charAt(i));

                // move to the next cell
                findPath(nr,nc,maze,path,res);

                // backtrack
                path.deleteCharAt(path.length()-1);
            }
        }
        maze[r][c] =1;
    }

    public static ArrayList<String > ratInMaze(int [][] maze){
        ArrayList<String>result = new ArrayList<>();
        int n = maze.length;
        StringBuilder path = new StringBuilder();
        if(maze[0][0] == 1 && maze[n-1][n-1] == 1){
            findPath(0,0,maze,path,result);
        }
        Collections.sort(result);
        return result;
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
