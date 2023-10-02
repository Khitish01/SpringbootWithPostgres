package com.postgress.springwithpostgres.dao;

import com.postgress.springwithpostgres.entities.StudentData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentData,Long> {

    public StudentData findById(long id);
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//    public void createTable(){
//        var query="CREATE TABLE student1(id SERIAL PRIMARY KEY, name VARCHAR(255) NOT NULL, city VARCHAR(255) NOT NULL)";
//        this.jdbcTemplate.update(query);
//    }
//    public void updateData(){
//        var query="INSERT INTO student(name, city) VALUES ('Tanmay', 'Odisha') RETURNING id;";
//        this.jdbcTemplate.update(query);
//    }
//    public void getData(){
//        var query="SELECT * FROM student;";
//        this.jdbcTemplate.update(query);
//    }
}
