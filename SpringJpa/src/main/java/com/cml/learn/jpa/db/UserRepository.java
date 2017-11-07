package com.cml.learn.jpa.db;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.cml.learn.jpa.db.bean.User;

/**
 * 用户信息相关
 * 
 * @author cml
 *
 */
public interface UserRepository extends CrudRepository<User, Integer> {
	/**
	 * 根据email获取数据
	 * 
	 * @param email
	 * @return
	 */
	User findByUserEmail(String email);

	/**
	 * 获取根据昵称升序的第一条数据
	 * 
	 * @return
	 */
	User findFirstByOrderByNickNameAsc();

	Page<User> findAll(Pageable page);
}
