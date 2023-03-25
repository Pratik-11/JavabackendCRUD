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



}
