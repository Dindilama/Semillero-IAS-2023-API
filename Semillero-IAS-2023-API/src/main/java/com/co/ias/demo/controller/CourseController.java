package com.co.ias.demo.controller;

import com.co.ias.demo.dto.Course;
import com.co.ias.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/getAllCourse")
    public List<Course> getAllCourse() {
        return courseService.getAllCourses();
    }

    @PostMapping("/saveCourse")
    private int saveCourse(@RequestBody Course course) {
        courseService.saveOrUpdate(course);
        return course.getId();
    }

    @GetMapping("/findBy/{id}")
    private Course getCourse(@PathVariable("id") int id) {
        return courseService.getCourseById(id);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteCourse(@PathVariable("id") int id) {
        courseService.delete(id);
    }
}
