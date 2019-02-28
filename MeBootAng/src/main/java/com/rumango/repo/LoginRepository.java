package com.rumango.repo;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rumango.entity.User;


/**
*
* 
* @author Pavan
*/

@Repository
public interface LoginRepository extends JpaRepository<User, Integer>
{
	//	@Query("from User where userId=:userId and userPwd=:userPwd")
	//	public User UserLoginRepository(@Param("userId")String userId,@Param("userPwd") String userPwd);

	@Query("from User where user_id=:userId and authStatus='A' and recordStatus='O'")
	public User fetchUserDetails(@Param("userId")String userId);
	
//	@Transactional
//	@Modifying(clearAutomatically = true)
//	@Query("update User set lastLgnTime=:lastLgnTime,failLgnCounter=:failLgnCounter where user_id=:userId")
//	public void lastLogin(@Param("userId") String userId,@Param("lastLgnTime") String lastLgnTime,@Param("failLgnCounter") int failLgnCounter);
//	
//	@Transactional
//	@Modifying(clearAutomatically = true)
//	@Query("update User set lastFailLgnTime=:lastFailLgnTime,failLgnCounter=failLgnCounter+1 where user_id=:userId")
//	public void lastLoginFail(@Param("userId") String userId,@Param("lastFailLgnTime") String lastFailLgnTime);

}
