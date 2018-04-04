package com.jzheadley.kotlin.presentation;

public class Max {
    public static void main(String[] args) {
        System.out.println(max(2, 3));
        System.out.println(max(2.1, 3.2));
        System.out.println(max(1, 3, 4));
        System.out.println(max(2.1, 3));
    }

    static int max(int x, int y) {
        return x > y ? x : y;
    }

    static double max(double x, double y) {
        return x > y ? x : y;
    }

    static int max(int x, int y, int z) {
        return x > y ? (x > z ? x : z) : (y > z ? y : z);
    }
}
