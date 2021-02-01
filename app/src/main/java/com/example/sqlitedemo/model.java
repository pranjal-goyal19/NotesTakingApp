package com.example.sqlitedemo;

public class model  {

    String note;
    int id;


    public model(int id,String note) {
        this.note = note;
          this.id=id;
    }
    public model(String note) {
        this.note = note;

    }

   public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
}
