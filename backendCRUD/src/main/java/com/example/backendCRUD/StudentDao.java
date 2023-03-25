package com.example.backendCRUD;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;


@Repository
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //creating the table
    public void createTable(){
        String query = "CREATE TABLE student(id SERIAL PRIMARY KEY,name VARCHAR(255) NOT NULL,city VARCHAR(255) NOT NULL)";
        int update= this.jdbcTemplate.update(query);
        System.out.println(update);
    }

    public void insertData(String name, String city){
        String query = "insert into student(name,city) values(?,?)";
        int update= this.jdbcTemplate.update(query,name,city);
        System.out.println(update +"rows added");
    }

    public void retrieveAllData(){
        String query = "select * from student";
        int update= this.jdbcTemplate.update(query);
        System.out.println(update);
    }

    public void updateData(String name, String city ,String newName, String newCity){
        String query = "update student where name=? and city=? set name=? and city=?";
        int update= this.jdbcTemplate.update(query,name,city,newName,newCity);
        System.out.println(update);
    }


}
