package com.reactiveProgramming.sec05;

import com.reactiveProgramming.sec05.assignment.InventoryService;
import com.reactiveProgramming.sec05.assignment.OrderService;
import com.reactiveProgramming.sec05.assignment.RevenueService;
import com.reactiveProgramming.utility.Util;

public class Lec06Assignment {

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        InventoryService inventoryService = new InventoryService();
        RevenueService revenueService = new RevenueService();

        //observe the order stream
        orderService.orderStream().subscribe(revenueService.subscribeOrderService());
        orderService.orderStream().subscribe(inventoryService.subscribeOrderService());

        inventoryService.inventoryStream().subscribe(Util.subscriber("inventory"));
        revenueService.revenueStream().subscribe(Util.subscriber("revenue"));

        Util.sleepThred(15);
    }
}
