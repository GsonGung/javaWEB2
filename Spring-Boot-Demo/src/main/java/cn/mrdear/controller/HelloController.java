package cn.mrdear.controller;

import cn.mrdear.entity.User;
import cn.mrdear.mapper.UserMapper;
import com.alibaba.fastjson.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Niu Li
 * @date 2016/8/9
 */
@Controller
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Resource
    private UserMapper userMapper;
    /**
     * 测试hello
     * @return
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("name", "Dear");
        return "hello";
    }

    @RequestMapping(value = "/findUserById/{id}",method = RequestMethod.GET)
    public @ResponseBody User testUserDao1(@PathVariable("id") int id){
        User user = userMapper.findById(id);
        logger.info("findUserById---id:"+id+",result:"+JSONArray.toJSONString(user));
        return user;
    }
    
    @RequestMapping(value = "/findAllUsers",method = RequestMethod.GET)
    public @ResponseBody List<User> testUserDao2(){
        List<User> users = userMapper.findAllUsers();
        logger.info("findAllUsers---result:"+JSONArray.toJSONString(users));
        return users;
    }
    
    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public @ResponseBody int testUserDao3(User user){
        int rows = userMapper.addUser(user);
        logger.info("addUser---user:"+JSONArray.toJSONString(user)+",result:"+rows);
        return rows;
    }
    
    @RequestMapping(value = "/deleteUser/{id}",method = RequestMethod.GET)
    public @ResponseBody int testUserDao4(@PathVariable("id") int id){
        int rows = userMapper.deleteUserById(id);
        logger.info("deleteUser---id:"+id+",result:"+rows);
        return rows;
    }

}
