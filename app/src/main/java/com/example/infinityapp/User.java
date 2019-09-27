package com.example.infinityapp;

public class User {

    public String firstName,lastName,email,phone;

    public  User()
    {

    }

    public User(String firstName,String lastName,String email,String phone)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.phone=phone;
    }

   /* public User(String firstName,String lastName,String phone)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.phone=phone;
    }*/





    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


   /* @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("fname", firstName);
        result.put("lname", lastName);
        result.put("email", email);
        result.put("phone", phone);

        return result;
    }
*/
}
