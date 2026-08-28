package com.varunbkarmikanda.lab4.stack;

public class TestStack {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.pop();
        assert stack.isEmpty() : "Stack is empty";

        stack.push(67);
        assert stack.getTop() == 67 : "Stack top element is 67";

        stack.push(51);
        assert stack.getTop() == 51 : "Stack top element is 51";

        stack.push(63);
        assert stack.getTop() == 63 : "Stack top element is 63";

        stack.push(95);
        assert stack.getTop() == 95 : "Stack top element is 95";

        stack.push(44);
        assert stack.getTop() == 44 : "Stack top element is 44";

        stack.push(78);
        assert stack.getTop() == 44 : "Stack top element is 44";

        stack.pop();
        assert stack.getTop() == 95 : "Stack top element is 95";

        stack.pop();
        assert stack.getTop() == 63 : "Stack top element is 63";

        stack.pop();
        assert stack.getTop() == 51 : "Stack top element is 51";

        stack.pop();
        assert stack.getTop() == 67 : "Stack top element is 67";

        stack.pop();
        assert stack.getTop() == -1 : "Stack top element is -1";


    }
}
