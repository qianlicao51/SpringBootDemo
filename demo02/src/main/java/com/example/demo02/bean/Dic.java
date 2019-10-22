package com.example.demo02.bean;

import javax.persistence.*;

@Entity(name = "ym_dic")
public class Dic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String diccode;
    @Column
    private String dicname;
    @Column
    private String dicitemcode;
    @Column
    private String dicitemname;

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
