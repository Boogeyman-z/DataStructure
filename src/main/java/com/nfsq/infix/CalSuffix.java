package com.nfsq.infix;

import com.nfsq.dataStructrueTest.MyStack;

public class CalSuffix {
    private MyStack stack;
    private String input;

    public CalSuffix(String input){
        this.input = input;
        stack = new MyStack(input.length());
    }

    public int doCalc(){
        int num1,num2,result;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c>'0' && c <= '9'){
                stack.push((int)(c-'0'));
            }else{
                num2 = stack.pop();//第二个数
                num1 = stack.pop();//第一个数
                switch (c){
                    case '+':
                        result = num1+num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    default:
                        result = 0;
                        break;
                }
                stack.push(result);
            }
        }
        result = stack.pop();
        return result;
    }

    public static void main(String[] args) {
        //中缀表达式：1*(2+3)-5/(2+3) = 4
        //后缀表达式：123+*123+/-
        CalSuffix cs = new CalSuffix("123+*523+/-");
        System.out.println(cs.doCalc()); //4
    }

}
