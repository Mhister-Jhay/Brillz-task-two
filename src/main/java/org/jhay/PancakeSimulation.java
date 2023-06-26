package org.jhay;

import java.util.Random;

public class PancakeSimulation {
    public static void main(String[] args) {
        /*
        Start By Instantiating the main class
         */
        PancakeSimulation simulation = new PancakeSimulation();

        for(int i = 0; i < 10; i++) {
            int slot = i + 1;
            System.out.println("Slot: "+ slot);
            System.out.println("Starting Time: " + getStartTime(slot) + " seconds");
            System.out.println("Ending Time: " + getEndTime(slot) + " seconds");

            /*
            Creating an object of the pancake store having several default parameters
            */
            PancakeStore store = new PancakeStore();
             /*
            Creating an object of the service class to perform all basic operations
             */
            PancakeServiceImpl service = new PancakeServiceImpl();


        /*
        1. Make Pancakes
         */
            int pancakes_made = service.makePancake(store.getMax_pancakes());
        /*
        2. Create an array of the users orders
         */
            int[] user_orders = new int[store.getMax_customers()];
        /*
        3. Users make orders
         */
            user_orders = service.orderMade(user_orders, store.getMax_pancake_per_customer());
        /*
        4. Check if all orders were made
         */
            boolean ordersMade = service.metAllOrders(user_orders, pancakes_made);
         /*
        5. Calculated Wasted Pancakes
         */
            int wastedPancakes = service.wastedPancakes(user_orders, pancakes_made);
         /*
        6. Calculate orders not met
         */
            int ordersNotMet = service.ordersNotMet(user_orders, pancakes_made);
            System.out.println("Shopkeeper met the needs of all users: " + ordersMade);
            System.out.println("Pancakes wasted: " + wastedPancakes);
            System.out.println("Unmet orders: " + ordersNotMet);
            System.out.println("-------------------------------------");
            System.out.println();
        }
    }
    private static int getStartTime(int slot) {
        return (slot - 1) * 30;
    }

    private static int getEndTime(int slot) {
        return slot * 30;
    }

}
