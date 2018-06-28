package org.sang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.User;

@Mapper
public interface TestMapper {
	
	List<User> getAllUser();
	
	int setUserByID(@Param("id")Long id, @Param("username")String username, @Param("nickname")String nickname, @Param("email")String email);

	int addUser (User user);
	
	int addRolesUser(@Param("rid")int rid, @Param("uid")Long uid);
	
	int deleteUser(@Param("id")int id);
}
