package com.example.zero.code.datasum.recursion;


import org.springframework.data.redis.core.PartialUpdate;

public class FindMax {


    public static <AnyType extends Comparable<? super AnyType>> AnyType findMax(AnyType [] arr) {
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i].compareTo(arr[maxIndex]) > 0)
                maxIndex = i;
        return arr[maxIndex];
    }

    public static <AnyType extends Comparable<? super AnyType>> int binarySearch(AnyType [] a, AnyType x) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid].compareTo(x) < 0)
                low = mid + 1;
            else if (a[mid].compareTo(x) > 0)
                low = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public static long gcd(long m, long n) {
        while (n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    public static long pow(long x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n % 2 == 0)
            return pow(x * x, n / 2);
        else
            return pow(x * x, n / 2) * x;
    }

    public static int maxSubSum1(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int thisSum = 0;
                for (int k = i; k < j; k++)
                    thisSum += a[k];
                if (thisSum > maxSum)
                    maxSum = thisSum;
            }
        }
        return maxSum;
    }


    public static void main(String[] args) {
        int [] a = {1, 4, 5, 2, 5, 3, 5, 3};
        int i = maxSubSum1(a);
        System.out.println(i);
    }

}
