package aword;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@EnableAutoConfiguration//放在arctifactId目录下，spring boot会自动扫描该类同级包以及下级包里面的bean
public class BackendApp {

//    @GetMapping("/")
//    String home() {
//        return "Hello World!";
//    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BackendApp.class, args);
    }
}
