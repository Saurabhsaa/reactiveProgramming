package com.reactiveProgramming.sec12Context;

import com.reactiveProgramming.sec12Context.helper.BookService;
import com.reactiveProgramming.sec12Context.helper.UserService;
import com.reactiveProgramming.utility.Util;
import reactor.util.context.Context;

public class Lec02ContextRateLimiter {
    public static void main(String[] args) {
        BookService
                .getBooks()
                .repeat(3)
                .contextWrite(UserService.userCateogryContext())
                .contextWrite(Context.of("user","saurabh"))
                .subscribe(Util.subscriber());
        Util.sleepThred(2);
    }
}
