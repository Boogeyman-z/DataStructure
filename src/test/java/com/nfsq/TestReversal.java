package com.nfsq;

import com.nfsq.dataStructrueTest.ArrayStack;
import org.junit.Test;

import java.util.Stack;

public class TestReversal {
    @Test
    public void testStringReversal(){
        Stack<Character> strings = new Stack<Character>();
        String str = "how are you";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            strings.push(chars[i]);
        }
        while (!strings.empty()){
            System.out.print(strings.pop());
        }
    }

    @Test
    public void testMatch(){
        ArrayStack arrayStack = new ArrayStack();
        String str = "{[)(]}";
        char[] chars = str.toCharArray();
        for (char cha : chars) {
            switch (cha){
                case '{':
                case '[':
                case '(':
                    arrayStack.push(cha);
                    break;
                case '}':
                case ']':
                case ')':
                    if(!arrayStack.isEmpty()){
                        char c = arrayStack.pop().toString().toCharArray()[0];
                        if(cha == '}' && c != '{'
                        || cha == ']' && c != '['
                        || cha == ')' && c != '('){
                            System.out.println("Error:"+cha+"-"+c);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

}
