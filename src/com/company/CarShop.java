package com.company;

import java.util.*;

public class CarShop {
    private List<Car> carList = new ArrayList<> ();
    final long CARRECEPTIOM = 3000;
    final long WAITCARTIME = 2000;
    final long CARQUANTITY = 5;

    public List<Car> getCarList() {
        return carList;
    }

    public void traderCar() {
        try {
            for (int i = 0; i < CARQUANTITY; i++) {
                System.out.printf ("%s Принимает новые машины\n", Thread.currentThread ().getName ());
                Thread.sleep (CARRECEPTIOM);
                System.out.println ("Приемка завершена");
                synchronized (this) {
                    getCarList ().add (new Car ());
                    notify ();
                }
            }
        } catch (InterruptedException e){
            e.printStackTrace ();
        }
    }
    public void buyCar(){
        try {
            System.out.printf ("%s Заходит в магазин\n", Thread.currentThread ().getName ());
            synchronized (this){
                while (carList.size() == 0){
                    System.out.println ("Машин нет в наличии");
                    wait ();
                }
            }
            Thread.sleep (WAITCARTIME);
            System.out.println (Thread.currentThread ().getName () + " yexal na Новой Tesla");
            getCarList ().remove (0);
        } catch (InterruptedException e){
            e.printStackTrace ();
        }
    }
}
