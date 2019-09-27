package com.example.infinityapp.Model;

public class TicketList {
    int id;
    String code;
    String type;

    public TicketList(int id, String code, String type) {

        this.id = id;
        this.code = code;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }
}
