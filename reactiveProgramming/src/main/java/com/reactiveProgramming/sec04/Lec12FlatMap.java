package com.reactiveProgramming.sec04;

import com.reactiveProgramming.sec04.helper.OrderService;
import com.reactiveProgramming.sec04.helper.PurchageOrder;
import com.reactiveProgramming.sec04.helper.UserService;
import com.reactiveProgramming.utility.Util;

public class Lec12FlatMap {

    public static void main(String[] args) {
        UserService.getUser()
                .map(user -> {
                    return OrderService.getOrders(user.getUserId());
                }).subscribe(Util.subscriber());

        UserService.getUser()
                .flatMap(user -> OrderService.getOrders(user.getUserId())).subscribe(Util.subscriber());


        Util.sleepThred(10);
    }

}
