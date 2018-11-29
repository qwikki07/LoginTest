package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * @author hgq
 * 在接口里定义一个方法
 *
 */
@Repository //将dao类声明为bean
public interface UserDao extends CrudRepository<UserEntity, Long>{
	public UserEntity findByUsernameAndPassword(String username,String password);
}
