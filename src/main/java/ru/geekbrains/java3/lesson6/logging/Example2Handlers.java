package ru.geekbrains.java3.lesson6.logging;

import java.io.IOException;
import java.util.logging.*;

public class Example2Handlers {
    private static final Logger logger = Logger.getLogger(Example2Handlers.class.getName());

    public static void main(String[] args) {
        try {
            Handler h = new FileHandler("mylogsimple.log");
            h.setFormatter(new SimpleFormatter());
            logger.addHandler(h);
            h = new FileHandler("mylogxml.log");
            h.setFormatter(new XMLFormatter());
            logger.addHandler(h);
            // h = new SocketHandler();
            // h = new ConsoleHandler();
//             h = new StreamHandler();
            // h = new MemoryHandler();
            System.out.println("Handlers");
            for (Handler o : logger.getHandlers()) {
                System.out.println(o);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Example2Handlers ex2 = new Example2Handlers();
        ex2.tryToDivBy0();
    }

    public void tryToDivBy0() {
        try{
            int a = 5 / 0;
        } catch (ArithmeticException e) {
            logger.log(Level.SEVERE, "Ошибка деления на ноль", e);
        }
    }
}
