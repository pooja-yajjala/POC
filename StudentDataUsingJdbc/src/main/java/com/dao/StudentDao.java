package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.model.Student;

public class StudentDao {
	
	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}
	
	public int save(Student p){  
	    String sql="insert into Student(sname,percentage,grade) values('"+p.getSname()+"',"+p.getPercentage()+",'"+p.getGrade()+"')";  
	    return template.update(sql);  
	}  
	
	public List<Student> getStudents(){    
	    return template.query("select * from Student",new RowMapper<Student>(){    
	        public Student mapRow(ResultSet rs, int row) throws SQLException {    
	        	Student e=new Student();    
	            e.setId(rs.getInt(1));    
	            e.setSname(rs.getString(2));    
	            e.setPercentage(rs.getFloat(3));    
	            e.setGrade(rs.getString(4));    
	            return e;    
	        }    
	    });    
	}  

}
