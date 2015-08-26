package com.lst.lc.dao;

import java.util.List;
import java.util.Map;

import com.lst.lc.entities.BlogTag;
import com.lst.lc.entities.User;

public interface UserDao {

	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * 更新用户信息
	 * @param user 用户信息
	 */
	public void updateUser(User user);
	
	/**
	 * 根据主键检索用户
	 * @param userId 用户id
	 * @return
	 */
	public User getById(int userId);
	
	/**
	 * 删除用户
	 * @param user 用户信息
	 */
	public void deleteUser(User user);
	
	/**
	 * 验证用户登录信息
	 * @param email
	 * @param password
	 * @return
	 */
	public User validateUser(String email, String password);
	
	/**
	 * 用户增加积分
	 * @param userId
	 * @param integral
	 */
	public void addIntegral(int userId, int integral);
	
	/**
	 * 判断注册邮箱是否存在
	 * @param email
	 * @return
	 */
	public boolean ifEmailExisted(String email);
	
	/**
	 * 更新用户信息
	 */
	public void update(int userId, String gender, String avatar, String motto, String city);
	
	/**
	 * 用户学习某课程
	 * @param userId
	 * @param courseId
	 */
	public void learn(int userId, int courseId);
	
	public List<User> getTopFive();
	
	public void addRel(int uid1, int uid2);
	
	public List<User> getFriends(int uid);
	
	public List<User> getValidateFriends(int uid);
	
	public void validateFriend(int uid1, int uid2, int state);
	
	public boolean ifFriend(int uid1, int uid2);
	
	public long count();
	
	public List<Map.Entry<String, Integer>> getTags(int uid);
	
}
