package ru.zenkov.skb_dz_11.controllers;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zenkov.skb_dz_11.services.SomeHeavyBusinessLogic;

@RestController
@Timed("test")
public class SomeController {

    private SomeHeavyBusinessLogic heavyBusinessLogic;

    @GetMapping("/some-get-req")
    @Counted("my.count.get.req")
    @Timed("my.time.get.req")
    public String doSomethingImportant() {
        return "VERY IMPORTANT THING IS DONE";
    }

    @PostMapping("/some-post-req")
    @Counted("my.count.post.req")
    @Timed("my.time.post.req")
    public String doSomethingImportant2() {
        return "MORE IMPORTANT THING IS DONE";
    }

    @GetMapping("/heavy-business-logic")
    @Counted("my.count.heavy.req")
    @Timed("my.time.heavy.req")
    public String doBusinessLogic() {
        heavyBusinessLogic.doBusiness();
        return "I have done business";
    }


    @Autowired
    public void setHeavyBusinessLogic(SomeHeavyBusinessLogic heavyBusinessLogic) {
        this.heavyBusinessLogic = heavyBusinessLogic;
    }
}
