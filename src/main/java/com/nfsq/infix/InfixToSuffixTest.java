package com.nfsq.infix;

import java.util.Scanner;

public class InfixToSuffixTest {
    public static void main(String[] args) {
        String input;
        System.out.println("Enter infix:");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
//        InfixToSuffix infixToSuffix = new InfixToSuffix(input);
        InfixToPrefix infixToPrefix = new InfixToPrefix(input);
        MyCharStack myCharStack = infixToPrefix.doTrans();
        myCharStack.displayStack();
    }
}
