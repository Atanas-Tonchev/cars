package com.haemimont.cars.api;
import java.util.ArrayList;
import java.util.List;

public class ApiRole {
    private String user;
    private String admin;
    private String mod;

    public String getUser() {
        return user;
    }

    public String setUser(String user) {
        this.user = user;
        return user;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getModerator() {
        return mod;
    }

    public void setModerator(String moderator) {
        this.mod = moderator;
    }
    public List<String> getRole(){
        List<String> list = new ArrayList<>();
        if(getAdmin()!=null){
            list.add(getAdmin());
        }
        if(getUser()!=null){
            list.add(getUser());
        }
        if(getModerator()!=null){
            list.add(getModerator());
        }
        return list;
    }
}
