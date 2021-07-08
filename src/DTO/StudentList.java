/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Utility.Utility;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class StudentList extends ArrayList<Student> {    
    Utility ul = new Utility();
    Scanner sc = new Scanner(System.in);
    
    public StudentList() {
        super();
    }
    
    public Student search(String code) {
        code = code.trim().toUpperCase();
        for (int i = 0; i < this.size(); ++i) if (this.get(i).getCode().equals(code)) return this.get(i);
        return null;
    }
    
    public boolean isCodeDuplicated(String code) {
        code = code.trim().toUpperCase();
        return search(code) != null;
    }
    
    public void searchStudent() {
        if (this.size() == 0) {
            System.out.println("List is empty");
            return;
        }
        String code = ul.getString(sc, "Enter code: ", false, "[sS][\\d]{3}");
        code = code.trim().toUpperCase();
        Student s = this.search(code);
        if (s != null) System.out.println("Found: " + s);
        else System.out.println("Student " + code + " not found!");
    }
    
    public void addStudent() {
        String newCode, newName; int newMark;
        boolean codeDuplicated = false;
        do {
            newCode = ul.getString(sc, "Enter code: ", false, "[sS][\\d]{3}");
            newCode = newCode.trim().toUpperCase();
            codeDuplicated = isCodeDuplicated(newCode);
            if (codeDuplicated) System.out.println("This student existed");
        } while (codeDuplicated == true);
        
        newName = ul.getString(sc, "Enter name: ", false, "");
        newMark = ul.getInt(sc, "Enter mark: ", 0, 10);

        Student s = new Student(newCode, newName, newMark);
        System.out.println("A student was added");
        this.add(s);
    }
    
    public void removeStudent() {
        if (this.size() == 0) {
            System.out.println("List is empty");
            return;
        }
        String code = ul.getString(sc, "Enter code: ", false, "[sS][\\d]{3}");
        code = code.trim().toUpperCase();
        Student st = this.search(code);
        if (st == null) System.out.println("Student " + code +" does not exist!");
        else {
            this.remove(st);
            System.out.println("Student " + code + " was removed");
        }
    }
    
    public void updateStudent() {
        if (this.size() == 0) {
            System.out.println("List is empty");
            return;
        }
        String code = ul.getString(sc, "Enter code: ", false, "[sS][\\d]{3}");
        code = code.trim().toUpperCase();
        Student st = this.search(code);
        if (st != null) {
            st.setName(ul.getString(sc, "Enter name: ", false, ""));
            st.setMark(ul.getInt(sc, "Enter mark: ", 0, 10));

            System.out.println("Studetn " + code + " was updated");
        }
        else System.out.println("Student " + code + " does not exist");
    }
    
    public void printAll() {
        if (this.size() == 0) {
            System.out.println("List is empty");
            return;
        }
        for (Student s : this) System.out.println(s);
        System.out.println("Total: " + this.size() + " student(s)");
    }
}
