/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author PC
 */
public class Account {
    private String name;
    private String password;
    private String displayname;

    public Account() {
    }
    
    public Account(String name, String password) {
        this.name = name;
        this.password = password;
        
    }
    
    public Account(String name, String password, String displayname) {
        this.name = name;
        this.password = password;
        this.displayname = displayname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }
}
