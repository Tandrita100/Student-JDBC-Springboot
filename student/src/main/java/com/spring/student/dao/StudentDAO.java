package com.spring.student.dao;

import com.spring.student.entity.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAO {

    private JdbcTemplate jdbcTemplate;

    public StudentDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> getAllStudents() {
        return jdbcTemplate.query(
                "SELECT * FROM student",
                new BeanPropertyRowMapper<>(Student.class)
        );
    }

    public Student getStudentByName(String name){
        return jdbcTemplate.queryForObject(
                "SELECT * FROM student WHERE name=?",
                new BeanPropertyRowMapper<>(Student.class),
                name
        );
    }

    public int addStudent(Student student){
        return jdbcTemplate.update(
                "INSERT INTO student VALUES (?,?,?,?,?)",
                student.getRollno(),
                student.getName(),
                student.getMarks(),
                student.getGrade(),
                student.getCity()
        );
    }

}
