package top.vota.springcloud.consumer.controller;

import com.netflix.discovery.DiscoveryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by mengzg<mengzg@xiaoshouyi.com> on 2017/11/2 16:10
 */
@RestController
public class ConsumerController {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    private RestTemplate creteRestTemplate() {
        return new RestTemplate();
    }

    @GetMapping(value = "/invoke")
    public String consume(@RequestParam("name") String username) {
        String result = restTemplate.getForObject("http://user-service/userinfo?name=" + username, String.class);
        logger.info(result);
        return result;
    }

}
