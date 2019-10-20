package com.example.demo02.bean;

import java.io.Serializable;

public class Dic  implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String diccode, dicname, dicitemcode, dicitemname;

    @Override
    public String toString() {
        return "Dic{" +
                "id=" + id +
                ", diccode='" + diccode + '\'' +
                ", dicname='" + dicname + '\'' +
                ", dicitemcode='" + dicitemcode + '\'' +
                ", dicitemname='" + dicitemname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiccode() {
        return diccode;
    }

    public void setDiccode(String diccode) {
        this.diccode = diccode;
    }

    public String getDicname() {
        return dicname;
    }

    public void setDicname(String dicname) {
        this.dicname = dicname;
    }

    public String getDicitemcode() {
        return dicitemcode;
    }

    public void setDicitemcode(String dicitemcode) {
        this.dicitemcode = dicitemcode;
    }

    public String getDicitemname() {
        return dicitemname;
    }

    public void setDicitemname(String dicitemname) {
        this.dicitemname = dicitemname;
    }
}
