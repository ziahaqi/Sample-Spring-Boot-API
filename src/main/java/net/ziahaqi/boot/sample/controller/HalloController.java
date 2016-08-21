package net.ziahaqi.boot.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ziahaqi on 8/19/16.
 */
@RestController
public class HalloController {

    @RequestMapping("/date")
    public Map<String, Object> date(@RequestParam(value = "place", required = false) String place){
        Map<String, Object> result = new HashMap<>();
        result.put("time", new Date());
        result.put("place", place);
        return result;
    }

}
