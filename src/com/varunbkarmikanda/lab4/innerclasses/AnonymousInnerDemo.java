package com.varunbkarmikanda.lab4.innerclasses;

abstract class Base{
    abstract int getNum();
}

interface Calculator {
    float addition(float a, float b);
    float subtract(float a, float b);
    float multiply(float a, float b);
    float divide(float a, float b);
}

public class AnonymousInnerDemo {
    public static void main(String[] args) {
        Base b = new Base() {
            @Override
            int getNum() {
                return 0;
            }
        };

        Calculator calculator = new Calculator() {
            @Override
            public float addition(float a, float b) {
                return a + b;
            }

            @Override
            public float subtract(float a, float b) {
                return a - b;
            }

            @Override
            public float multiply(float a, float b) {
                return a * b;
            }

            @Override
            public float divide(float a, float b) {
                if(b > 0) return a / b;
                return -1;
            }
        };
    }
}