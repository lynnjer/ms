import java.util.*;

import java.util.Stack;

public class A {

    public static void test (){

    }

    public static void testpullrequest (){

    }
    public static void testpullrequestV2 (){

    }
    public static void testpullrequestV3 (){

    }

    public static void main(String[] args){
        List<List<Integer>> res=new LinkedList<>();
        List<Integer> temp=new ArrayList<>();
        int[] in={1,2,3};
        fun(0,in,new Stack<Integer>(),temp,res);
        System.out.print(res);
        Set<Integer> set=new TreeSet<>();
        set.add(8);
        set.add(2);
        set.add(3);
        System.out.print(set);
    }

    static void fun(int n,int[] in, Stack <Integer> stk, List<Integer> temp,List<List<Integer>> res)
    {
        //System.out.println("当前进度"+n+"    "+"当前已出"+sout);

        if(n == in.length && stk.isEmpty()){//如果入栈完毕了，且也栈空了，就输出此出栈顺序          这个是递归的结束条件
            res.add(temp);
        }
        else//以上其中一项未完成
        {
            Stack<Integer> s1=(Stack<Integer>) stk.clone();
            Stack<Integer> s2=(Stack<Integer>) stk.clone();
            //选择入栈
            if (n <  in.length)//如果是未全部入栈
            {
                s1.push(in[n]);//      继续入栈
                fun(n+1,in, s1,temp,res);//执行下一个操作
            }
            //选择出栈
            if (!s2.isEmpty())//如果栈不空，并且，入栈元素不是最后一个
            {                                   //当到最后一个字符入栈之后，上面已经执行先出栈了
                temp.add(s2.peek());//记录出栈元素
                s2.pop();//出栈
                fun(n, in,s2, temp,res);
            }
        }
    }
}
