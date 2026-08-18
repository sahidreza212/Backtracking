package org.example;

public class Longest_Possible_Route_In_Matrix {
    public static int dfs(int [][]mat, int i, int j, int x,int y){
        int m = mat.length;
        int n = mat[0].length;

        // base case or destination is reached
        if(i == x || j == y){
            return 0;
        }
        // invalid case or blocked case
        if(i < 0 || i >= m || j < 0 || j >= n || mat[i][j] == 0){
            return -1;
        }
        // make the current cell as visited
        mat[i][j] = 0;
        int maxPath = -1;

        // UDLR
        int row[] = {-1,1,0,0};
        int col[] = {0,0,-1,1};

        for(int k = 0; k < 4; k++){
            int ni = i+row[k];
            int nj = j+col[k];
            int pathLength = dfs(mat,ni,nj,x,y);

            // if valid path is found then destination
            if(pathLength != -1){
                maxPath = Math.max(maxPath, pathLength+1);
            }
         }

        return maxPath;
    }

    public static int longestPath(int mat[][] , int xs, int ys ,int xd, int  yd){
        int m = mat.length;
        int n = mat[0].length;

       if(mat[xs][ys] == 0 ||  mat[xd][yd] == 0){
           return -1;
       }

       return dfs(mat,xs,ys,xd,yd);
    }
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 0, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        int xs = 0, ys = 0;
        int xd = 1, yd = 7;

        int result = longestPath(mat,xs,ys,xd,yd);
        if(result != -1){
            System.out.print(result);
        }else {
            System.out.print(-1);
        }
    }
}
