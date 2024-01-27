package com.reactiveProgramming.sec12Context.helper;


import reactor.util.context.Context;

import java.util.Map;
import java.util.function.Function;

public class UserService {

    private static Map<String,String> map = Map.of(
            "sam","std",
            "saurabh","prime"
    );

    public static Function<Context, Context> userCateogryContext(){
        return ctx -> {
            String user = ctx.get("user").toString();
            String category = map.get(user);
            return ctx.put("category",category);
        };
    }
}
