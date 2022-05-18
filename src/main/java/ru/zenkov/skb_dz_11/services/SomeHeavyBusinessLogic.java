package ru.zenkov.skb_dz_11.services;

import org.springframework.stereotype.Service;

@Service
public class SomeHeavyBusinessLogic {
    public void doBusiness() {
        int min = 991;
        int max = 4467;
        int millisToSleep = (int) (min + (Math.random() * (max - min)));
        try {
            Thread.sleep(millisToSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
