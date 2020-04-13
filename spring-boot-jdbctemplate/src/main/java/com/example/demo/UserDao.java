package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate template;

	void addStudent(Student user) {

		template.update("insert into Std1 values(?, ?, ?)",
				new Object[] { user.getId(), user.getName(), user.getAddress() });
	}

	abstract class UserMapper implements RowMapper {

		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student user = new Student();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setAddress(rs.getString("address"));

			return user;
		}

	}

	String getStudentName(int id, String address) {
		return template.queryForObject("select name from Std1 where id = ? and address = ?",
				new Object[] { id, address }, String.class);
	}

	void updateStudent(Student user) {
		template.update("update Std1 set name=?,address=? where id=?",
				new Object[] { user.getId(), user.getName(), user.getAddress() });
	}

	void deleteStudent(int id) {
		template.update("delete from Std1 where id=?", new Object[] { id });
	}

	Integer getCountOfStudent() {
		return template.queryForObject("select count(*) from Std1", Integer.class);
	}

}
