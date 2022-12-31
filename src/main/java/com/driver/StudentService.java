package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
   public static void addstudentservice(Student student){
       StudentRepository.addstudentdb(student);

   }
   public static void addteacherservice(Teacher teacher){

       StudentRepository.addteacherdb(teacher);
   }
   public static void teacherstudentpair(String studentname,String teachername){
       StudentRepository.teacherstudentdb(studentname,teachername);

   }
   public static Student getStudent(String name){
       Student student=StudentRepository.getstudentdb(name);
       return student;
   }
   public static Teacher getteacher(String name){
       Teacher teacher=StudentRepository.getteacherdb(name);
       return teacher;
   }
   public static List<String> getallstudent(String name){
       List<String > students=StudentRepository.getallStudentdb(name);
       return students;
   }
   public static List<String > getall(){
       List<String> student=StudentRepository.getalldb();
       return student;
   }
   public static void removeteacher(String teachername){
       StudentRepository.removeteacherdb(teachername);
   }
   public static void removeallteacher(){
       StudentRepository.removeallteacherdb();
   }
}
