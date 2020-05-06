package com.nfsq.infix;

public class InfixToPrefix {
    private MyCharStack s1;//定义运算符栈
    private MyCharStack s2;//定义操作数栈
    private String input;

    //默认构造方法，参数为输入的中缀表达式
    public InfixToPrefix(String input) {
        this.input = input;
        s1 = new MyCharStack(input.length());
        s2 = new MyCharStack(input.length());
    }


    //中缀表达式转换为前缀表达式，将结果存储在栈中返回，逆序显示即前缀表达式
    public MyCharStack doTrans() {
        for (int i = input.length()-1; i >= 0; i--) {
            System.out.print("s1栈元素为：");
            s1.displayStack();
            System.out.print("s2栈元素为：");
            s2.displayStack();
            char ch = input.charAt(i);
            System.out.println("当前解析的字符:" + ch);
            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);
                    break;
                case '(':
                    gotParen();
                    break;
                case ')':
                    //如果当前字符是')',则将其入栈
                    s1.push(ch);
                    break;
                default:
                    //1、如果当前解析的字符是操作数，则直接压入s2
                    s2.push(ch);
                    break;
            }
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2;
    }

    public void gotOper(char opThis, int prec1) {
        while (!s1.isEmpty()) {
            char opTop = s1.pop();
            if (opTop == ')') {
                //如果栈顶是')',直接将操作符压入s1
                s1.push(opTop);
                break;
            } else {
                int prec2;
                if (opTop == '+' || opTop == '-') {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }

                //如果当前运算符比s1栈顶运算符优先级高，则将运算符压入s1
                if (prec2 <= prec1) {
                    s1.push(opTop);
                    break;
                } else {
                    //如果当前运算符与栈顶运算符相同或者小于优先级别，那么将S1栈顶的运算符弹出并压入到S2中
                    //并且要再次再次转到while循环中与 s1 中新的栈顶运算符相比较；
                    s2.push(opTop);
                }

            }
        }

        //如果s1为空，则直接将当前解析的运算符压入s1
        s1.push(opThis);

    }

    public void gotParen() {
        while (!s1.isEmpty()) {
            char chx = s1.pop();
            if (chx == '(') {
                break;
            } else {
                s2.push(chx);
            }
        }
    }
}
