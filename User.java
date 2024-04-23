/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author tasdi
 */
class User {

    private String id, name, hsc, dept;

    public User(String id, String name, String hsc, String dept) {
        this.id = id;
        this.name = name;
        this.hsc = hsc;
        this.dept = dept;
        
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHsc() {
        return hsc;
    }

    public String getDept() {
        return dept;
    }
   
}
