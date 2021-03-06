package com.face.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.apache.tomcat.jdbc.pool.DataSource;
import com.face.model.Login;
import com.face.model.User;

public class UserDaoImpl implements UserDao {
	
	
	DataSource datasource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void register (User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getFirstname());
		System.out.println(user.getLastname());
		System.out.println(user.getEmail());
		System.out.println(user.getAddress());
		System.out.println(user.getPhone());
		String sql="insert into users values(?,?,?,?,?,?,?)";
		
		jdbcTemplate.update(sql, new Object[] {user.getUsername(),user.getPassword(),user.getFirstname(),user.getLastname(),user.getAddress(),user.getEmail(),user.getPhone()});
		
	}
	
	public User validateUser(Login login) {
		
		String sql="select*from users where username='"+login.getUsername()+"'and password='"+login.getPassword()+"'";
		System.out.println(login.getUsername());
		List<User> users=jdbcTemplate.query(sql, new UserMapper());
		return users.size()>0? users.get(0):null;
	}

}
class UserMapper implements RowMapper<User>{
	public User mapRow(ResultSet rs,int arg1)throws SQLException{
		User user=new User();
		
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setFirstname(rs.getString("firstname"));
		user.setLastname(rs.getString("lastname"));
		user.setEmail(rs.getString("email"));
		user.setAddress(rs.getString("address"));
		user.setPhone(rs.getString("phone"));
		return user;
		
	}
}
