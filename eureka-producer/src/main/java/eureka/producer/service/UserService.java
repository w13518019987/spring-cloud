package eureka.producer.service;


//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import eureka.producer.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static Map<Integer, User> userMap = null;
    static{
        userMap = new HashMap<Integer,User>();
        userMap.put(1,new User(1,"张三","海口","13518019987"));
        userMap.put(2,new User(2,"李四","澄迈","13518019988"));
        userMap.put(3,new User(2,"王五","三亚","13518019989"));
    }
    //@HystrixCommand(fallbackMethod = "error")
    public User getUserById(Integer id){
        User user = userMap.get(id);
        if (null == user) {
            throw new RuntimeException("异常了");
             //int i = 1/0;
        }
        logger.info("用户根据id查询方法----》getUserById"+id);
        return user;
    }
    public User addUser(Integer id){
        userMap.put(id,new User(id,"赵六","未知","13518019999"));
        logger.info("用户新增方法----》addUser"+userMap);
        return userMap.get(id);
    }
    public Map<Integer,User> getUserAll(){
        logger.info("用户查询方法----》getUserAll"+userMap);
        return userMap;
    }

    public User error(Integer id){
        User user = new User();
        user.setName("降级");
        user.setAddress("好地址");
        logger.info("降级回调方法--------》");
        return user;
    }
}
