package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository

public class StudentRepository {
    private static   HashMap<String,Student> studentDB;
    private static HashMap<String,Teacher> TeacherDB;

    private static HashMap<String, List<String>> stdb;

    public StudentRepository() {
        this.studentDB = new HashMap<String, Student>() ;
        this.TeacherDB = new HashMap<String, Teacher> ();
        this.stdb = new HashMap<String, List<String>>() ;
    }

    public static void addstudentdb(Student student){
        String sname=student.getName();
        studentDB.put(sname,student);
    }
    public static void addteacherdb(Teacher teacher){
        String tname=teacher.getName();
        TeacherDB.put(tname,teacher);
    }
    public static void teacherstudentdb(String studentname,String teachername){
        List<String> t=new ArrayList<>();
        if(studentDB.containsKey(studentname) && TeacherDB.containsKey(teachername) ){
            if(stdb.containsKey(teachername)){
                stdb.get(teachername).add(studentname);
            }
            else{
                t.add(studentname);
                stdb.put(teachername,t);
            }
        }
    }
    public static Student getstudentdb(String studentname){
        if(studentDB.containsKey(studentname)){
            return studentDB.get(studentname);
        }
        return null;
    }
    public static Teacher getteacherdb(String Teachername){
        if(TeacherDB.containsKey(Teachername)){
            return TeacherDB.get(Teachername);
        }
        return null;
    }
    public static List<String> getallStudentdb(String Teachername){
        if(stdb.containsKey(Teachername)){
            return stdb.get(Teachername);
        }
        return null;
    }
    public static List<String> getalldb(){
        List<String> student=new ArrayList<>();
        for(String x: studentDB.keySet()){
            student.add(x);
        }
        return student;
    }
    public static void removeteacherdb(String teachername){
        List<String> list=new ArrayList<>();
        if(stdb.containsKey(teachername)){
            list=stdb.get(teachername);
        }
        for(String x:list){
            if(studentDB.containsKey(x)){
                studentDB.remove(x);
            }
        }
        stdb.remove(teachername);
        TeacherDB.remove(teachername);
    }
    public static void removeallteacherdb(){
      for(String s: TeacherDB.keySet()){
          if(stdb.containsKey(s)){
              List<String> x=stdb.get(s);
              for(String student: x){
                  if(studentDB.containsKey(student)){
                      studentDB.remove(student);
                  }
              }
          }

      }
      stdb.clear();
      TeacherDB.clear();
    }


}
