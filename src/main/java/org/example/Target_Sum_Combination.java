package org.example;

import java.util.ArrayList;

public class Target_Sum_Combination {

    public static void makeCombination(int []arr, int remSum, ArrayList<Integer>cur,ArrayList<ArrayList<Integer>>res,int index){
       // base case
        if(remSum == 0){
            res.add(new ArrayList<>(cur));
            return;
        }
        // invalid case if remSum < 0  or index >= arr.length
        if(remSum < 0 || index >= arr.length){
            return;
        }
        // add first element to the combination
        cur.add(arr[index]);

        // recursion with the same element
        makeCombination(arr,remSum-arr[index],cur,res,index);

        // backtrack(remove the current element and make the backtrack)
        cur.remove(cur.size()-1);
        makeCombination(arr,remSum,cur,res,index+1);
    }
    // function to find the all combinations of the  element

    public static ArrayList<ArrayList<Integer>> targetSumCombo(int arr[] , int target){

        ArrayList<Integer>cur = new ArrayList<>();
        ArrayList<ArrayList<Integer>>res = new ArrayList<>();
        makeCombination(arr,target,cur,res,0);
        return res;
    }
    public static void main(String[] args) {

        int arr[] = {1,2,3};
        int target = 5;

        ArrayList<ArrayList<Integer>>res = targetSumCombo(arr,target);
    }
}
