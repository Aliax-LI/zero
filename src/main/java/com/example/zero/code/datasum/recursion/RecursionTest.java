package com.example.zero.code.datasum.recursion;


/**
 * 递归基本法则
 * <p/>
 * 基准情形：必须需要某些基准情形，不用递归那直接求解
 * <p/>
 * 不断推进：递归调用必须总能朝着一个基准情形推进
 * <p/>
 * 设计法则：所有的递归调用都能运行
 * <p/>
 * 合成效益法则：切勿在不同的递归调用中做重复的工作
 * @Author: Mr.Li
 * @Date: 2020/11/9 10:41
 */
public final class RecursionTest {


    /**
     * 定义一个函数满足f(0) = 0 并且满足 f(x) = 2f(x - 1) + x²
     * @Author: Mr.Li
     * @Date: 2020/11/9 10:24
     * @param x: 参数
     * @return: int
     */
    public static int f(int x) {
        // 设置函数基准情况（不用递归能直接得到结果）
        if (x == 0)
            return 0;
        else
            return 2 * f(x - 1) + x * x;
    }


    /**
     * 无终止递归方法
     * <p/>
     * 这程序对 n > 0 的任何值都无法满足 f(0) 的结束条件
     * bat(4) -> bat(2) -> bat(1) -> ... -> bat(1)
     * @Author: Mr.Li
     * @Date: 2020/11/9 10:35
     * @param n: 参数
     * @return: int
     */
    public static int bat(int n) {
        if (n == 0)
            return 0;
        else
            return bat(n / 3 + 1) + n - 1;
    }


    /**
     * 打印整数的递归实例
     * @Author: Mr.Li
     * @Date: 2020/11/9 11:10
     * @param n:
     * @return: void
     */
    public static void printOut(int n) {
        if (n >= 10)
            printOut(n / 10);
        System.out.print(n % 10);
    }

}
