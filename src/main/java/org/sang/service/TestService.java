package org.sang.service;

import java.util.List;

import org.sang.bean.User;
import org.sang.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TestService {
	
    @Autowired
    TestMapper testMapper;
    
    public List<User> getAllUser(){
    	return testMapper.getAllUser();
    }
    
    public int setUserByID(Long id, String username, String nickname, String email){
    	int i = testMapper.setUserByID(id, username, nickname, email);
		return i;
    }
    
    public int addUser(User user){
    	int i=testMapper.addUser(user);
    	
    	int j=testMapper.addRolesUser(2, user.getId());
    	int resp = 1;
    	if(i == -1 ||j == -1){
    		
    		resp = -1;
    	}
    	return resp;
    }
    
    
    public int deleteUser(String[] idArr){
    	if(idArr.length != 1){
    		for(int i = 0; i < idArr.length; i++){
    			int id =Integer.valueOf(idArr[i]);
    			int j = testMapper.deleteUser(id);
    			if(j == -1){
    				return -1;
    			}
    		}
    		
    	}else{
    		int id =Integer.valueOf(idArr[0]);
			int i = testMapper.deleteUser(id);
			if(i ==-1 ){
				return -1;
			}
    	}
    	
    	return 1;
    }
}
