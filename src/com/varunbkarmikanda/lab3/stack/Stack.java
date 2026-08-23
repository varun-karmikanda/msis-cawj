package com.varunbkarmikanda.lab3.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private List<Integer> stack;
    private int top;
    private int maxSize;

    Stack(){
        this(5);
    }

    Stack(int maxSize){
        this.stack = new ArrayList<>(maxSize);
        this.top = -1;
        this.maxSize = maxSize;
    }

    public void push(int data){
        if(!isFull()){
            stack.add(++top, data);
        }
    }

    public int pop(){
        int popped = -1;
        if(!isEmpty()){
            popped = stack.remove(top--);
        }
        return popped;
    }

    public boolean isEmpty(){
        if(top < 0) {
            System.out.println("Stack is empty!");
            return true;
        }

        return false;
    }

    public boolean isFull(){
        if(top >= maxSize - 1) {
            System.out.println("Stack overflow!");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "\n\tstack=" + stack +
                ",\n\ttop=" + top +
                "\n}";
    }
}
