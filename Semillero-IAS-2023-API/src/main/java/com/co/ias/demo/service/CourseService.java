package com.co.ias.demo.service;

import com.co.ias.demo.dto.Course;
import com.co.ias.demo.dto.Teacher;
import com.co.ias.demo.repository.CourseRepository;
import com.co.ias.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(int id) {
        return courseRepository.findById(id).get();
    }

    public void saveOrUpdate(Course course) {
        courseRepository.save(course);
    }

    public void delete(int id) {
        courseRepository.deleteById(id);
    }
}
