package com.example.infinityapp;

public class BookingDetails {

    public String date;
    public String movieName;
    public String price;
    public String seatNumber1;
    public String seatNumber2;
    public String seatNumber3;
    public String time;

    public BookingDetails(String date, String movieName, String price, String seatNumber1, String seatNumber2, String seatNumber3, String time) {
        this.date = date;
        this.movieName = movieName;
        this.price = price;
        this.seatNumber1 = seatNumber1;
        this.seatNumber2 = seatNumber2;
        this.seatNumber3 = seatNumber3;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSeatNumber1() {
        return seatNumber1;
    }

    public void setSeatNumber1(String seatNumber1) {
        this.seatNumber1 = seatNumber1;
    }

    public String getSeatNumber2() {
        return seatNumber2;
    }

    public void setSeatNumber2(String seatNumber2) {
        this.seatNumber2 = seatNumber2;
    }

    public String getSeatNumber3() {
        return seatNumber3;
    }

    public void setSeatNumber3(String seatNumber3) {
        this.seatNumber3 = seatNumber3;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
