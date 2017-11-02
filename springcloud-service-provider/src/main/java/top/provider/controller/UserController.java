package top.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mengzhg on 2017/11/1 21:32.
 */
@RestController
public class UserController {

    @GetMapping(value = "/info/{id}")
    public String getUserInfo(@RequestParam(value = "name") String username) {
        return "I am " + username;
    }

}
