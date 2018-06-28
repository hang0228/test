package org.sang.controller;

import java.util.List;

import org.sang.bean.RespBean;
import org.sang.bean.User;
import org.sang.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
    @Autowired
    private TestService testService;
    
    @GetMapping("/userAll")
    public List<User> getAllUser() {
    	List<User> list = testService.getAllUser();
        return list;
    }
    
    @PostMapping("/setUserByID")
    public RespBean setUserByID(Long id, String username, String nickname, String email){
    	int i = testService.setUserByID(id, username, nickname, email);
    	if(i == -1){
    		return new RespBean("error","修改失败");
    	}
    	return new RespBean("success","修改成功");
    }
    
    @PostMapping("/addUser")
    public RespBean addUser(User user){
    	int i = testService.addUser(user);
    	if(i == -1){
    		return new RespBean("error","新增失败");
    	}
    	return new RespBean("success","新增成功");
    }
    
    @DeleteMapping("/deleteUser/{ids}")
    public RespBean deleteUserByID(@PathVariable String ids){
    	String[] idArr = ids.split(",");
    	int i = testService.deleteUser(idArr);
    	if(i == -1){
    		return new RespBean("error","删除失败");
    	}
    	
    	return  new RespBean("success","删除成功");
    }
   
}
