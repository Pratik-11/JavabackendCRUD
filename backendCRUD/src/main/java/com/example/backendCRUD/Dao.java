package com.example.backendCRUD;

import org.springframework.stereotype.Repository;

@Repository
public class Dao {
    public void createTable(){
        var query = "CREATE TABLE student(id SERIAL PRIMARY KEY,name VARCHAR(255) NOT NULL,city VARCHAR(255) NOTNULL)";
        int update= this.jdbcTemplate.update(query);
        sys
    }

}



