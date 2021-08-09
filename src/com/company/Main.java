package com.company;

public class Main {

    public static void main(String[] args) {
	final CarShop carShop = new CarShop();
	new Thread (null, carShop::buyCar, "Покупатель 1").start ();
	new Thread (null, carShop::buyCar, "Покупатель 2").start ();
	new Thread (null, carShop::buyCar, "Покупатель 3").start ();
	new Thread (null, carShop::buyCar, "Покупатель 4").start ();
	new Thread (null, carShop::traderCar, "Продавец 1").start ();
    }
}
