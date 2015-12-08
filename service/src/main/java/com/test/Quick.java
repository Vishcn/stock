package com.test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Vishcn
 * @since 2015年11月19日
 */
public class Quick {

    private static void quick(int[] sort, int i, int j) throws Exception{
        int newint;
        if (i < j) {
            newint = quickSort1(sort, i, j);
            quick(sort, i, newint-1);
            quick(sort, newint +1 , j);
        }
    }

    private static int quickSort1(int[] sort, int i, int j ) throws
            Exception{
        while(i <j) {
            while(i <j && sort[i] <= sort[j]) {
                j--;
            }
            if ( sort[i] > sort[j]) {
                int t = sort[i];
                sort[i] = sort[j];
                sort[j] = t;
            }
            while(i < j && sort[i] <= sort[j]) {
                i++;
            }
            if ( sort[i] > sort[j]) {
                int t = sort[i];
                sort[i] = sort[j];
                sort[j] = t;
            }
        }
        return i;
    }

    private static int quickSort(int[] sort, int i, int j ) throws
    Exception{
//        quick(sort, 0, sort.length);
        int a = sort[i];
        int k = i;
        while (i < j) {
            if (k<j && a > sort[j]) {
                int t = sort[k];
                sort[k] = sort[j];
                sort[j] = t;
                k = j;
            }
            if (k>j && a < sort[j]) {
                int t = sort[k];
                sort[k] = sort[j];
                sort[j] = t;
                k = j;
            }
            j--;
        }
        return k;
    }

    public static void main(String[] args) {
        int[] sort = new int[]{30,23,4,53,6,46,7,8,7};
        prin(sort);
        System.out.println("??");
        try {
            quick(sort, 0, sort.length - 1);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("??");
        prin(sort);
    }

    public static void prin(int[] a) {
        for (int i: a) {
            System.out.print("," + i);
        }
        System.out.println();
    }
}
