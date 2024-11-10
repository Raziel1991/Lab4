package com.example.demo;

import java.util.List;

public class UserData {
    private String fullName;
    private String address;
    private String province;
    //not today //private String province; // lets make it Fun and not just a String
    //private Province province; not today
    private String city;
    private String postalCode;
    private String phoneNumber;
    private String email;
    private List<String> coursesList;
    //private Major major;

    public UserData(String fullName, String address, String province, String city, String postalCode, String phoneNumber, String email, List<String> coursesList) {
        this.fullName = fullName;
        this.address = address;
        this.province = province;
        this.city = city;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        // default to the list will be python.
        this.coursesList = coursesList;
        //this.major = major;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Full Name: " + fullName + "\n");
        sb.append("Address: " + address + "\n");
        sb.append("Province: " + province + "\n");
        sb.append("City: " + city + "\n");
        sb.append("Postal Code: " + postalCode + "\n");
        sb.append("Phone Number: " + phoneNumber + "\n");
        sb.append("Email: " + email + "\n");

        if (coursesList != null) {
            sb.append("Courses: " + "\n");
            for (String course : coursesList) {
                sb.append(course + "\n");
            }
        }
        return sb.toString();
    }


    public enum Province  {
        ALBERTA,
        BRITISH_COLUMBIA,
        MANITOBA,
        NEW_BRUNSWICK,
        NEWFOUNDLAND_AND_LABRADOR,
        NOVA_SCOTIA,
        ONTARIO,
        PRINCE_EDWARD_ISLAND,
        QUEBEC,
        SASKATCHEWAN
    }

    public enum Major{
        COMPUTER_SCIENCE,
        BUSINESS
    }

}
