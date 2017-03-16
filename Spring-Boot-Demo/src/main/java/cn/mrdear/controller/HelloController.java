package cn.mrdear.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.mrdear.entity.User;
import cn.mrdear.mapper.UserMapper;

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
        User user = userMapper.findById(1);
        logger.info("findUserById---id:"+id+",result:"+JSONObject.toJSONString(user));
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
        logger.info("addUser---user:"+JSONObject.toJSONString(user)+",result:"+JSONArray.toJSONString(rows));
        return rows;
    }
    
    @RequestMapping(value = "/deleteUser/{id}",method = RequestMethod.GET)
    public @ResponseBody int testUserDao4(@PathVariable("id") int id){
        int rows = userMapper.deleteUserById(id);
        logger.info("deleteUser---id:"+id+",result:"+JSONArray.toJSONString(rows));
        return rows;
    }

}
