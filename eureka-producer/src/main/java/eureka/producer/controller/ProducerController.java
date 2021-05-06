package eureka.producer.controller;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import eureka.producer.bean.User;
import eureka.producer.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/")
public class ProducerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @GetMapping("/addUser/{id}")
    //@HystrixCommand
    public String addUser(@PathVariable Integer id){
        User user = userService.addUser(id);
        logger.info(user.toString());
        return user.toString();
    }
    @GetMapping("/getUser/{id}")
    //@HystrixCommand
    public String getUser(@PathVariable Integer id){
        User user = userService.getUserById(id);
        logger.info(user.toString());
        return user.toString();
    }
    @GetMapping("/getUserAll")
    public String getUserAll(){
        Map<Integer, User> userAll = userService.getUserAll();
        logger.info(userAll.toString());
        return userAll.toString();
    }
    //@HystrixCommand(fallbackMethod = "error")
    @GetMapping("/hystrixCommand")
    public String hystrixCommand(@RequestParam(required=false) String id){
        if(StringUtils.isNotBlank(id)){
            throw new RuntimeException("异常");
        }
        return "hystrixCommand";
    }

    public String error(String id){
        return "异常了";
    }

}
