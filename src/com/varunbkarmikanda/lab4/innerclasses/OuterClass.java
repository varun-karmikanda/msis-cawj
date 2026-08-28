package com.varunbkarmikanda.lab4.innerclasses;

abstract class AnonymousInner {
    public  abstract int getNum();

    public int getN(){
        return 1;
    }
}

//class X extends AnonymousInner{
//    @Override
//    public int getNum(){
//        return 100;
//    }
//}


public class OuterClass {
    public static void main(String[] args) {

//        class X extends AnonymousInner{
//            @Override
//            public int getNum(){
//                return 100;
//            }
//        }
//
//        AnonymousInner inner = new X();

        AnonymousInner inner = new AnonymousInner() {
            @Override
            public int getNum(){
                return 100;
            }
        };

        System.out.println("N = " + inner.getN());
        System.out.println("Num = " + inner.getNum());
    }
}
