package com.co.ias.demo.controller;


import com.co.ias.demo.dto.Teacher;
import com.co.ias.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/getAllTeachers")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @PostMapping("/saveTeacher")
    private int saveTeacher(@RequestBody Teacher teacher) {
        teacherService.saveOrUpdate(teacher);
        return teacher.getId();
    }

    @GetMapping("/findBy/{id}")
    private Teacher getTeacher(@PathVariable("id") int id) {
        return teacherService.getTeacherById(id);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteStudent(@PathVariable("id") int id) {
        teacherService.delete(id);
    }

}
