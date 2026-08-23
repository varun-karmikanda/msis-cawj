package com.varunbkarmikanda.lab3.stack;

public class TestStack {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.pop();

        stack.push(67);
        stack.push(51);
        stack.push(63);
        stack.push(95);
        stack.push(44);

        System.out.println(stack);

        stack.push(78);
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack);

    }
}
