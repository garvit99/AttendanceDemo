package com.example.attendancedemo;

public class ReceivedDataModel {
    String loginDate,loginTime, loginLatitude, loginLongitude, logoutDate,logoutTime,logoutLatitude,logoutLongitude;

    public ReceivedDataModel(String loginDate, String loginTime, String loginLatitude, String loginLongitude, String logoutDate, String logoutTime, String logoutLatitude, String logoutLongitude) {
        this.loginDate = loginDate;
        this.loginTime = loginTime;
        this.loginLatitude = loginLatitude;
        this.loginLongitude = loginLongitude;
        this.logoutDate = logoutDate;
        this.logoutTime = logoutTime;
        this.logoutLatitude = logoutLatitude;
        this.logoutLongitude = logoutLongitude;
    }



    public String getLoginDate() {
        return loginDate;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public String getLoginLatitude() {
        return loginLatitude;
    }

    public String getLoginLongitude() {
        return loginLongitude;
    }

    public String getLogoutDate() {
        return logoutDate;
    }

    public String getLogoutTime() {
        return logoutTime;
    }

    public String getLogoutLatitude() {
        return logoutLatitude;
    }

    public String getLogoutLongitude() {
        return logoutLongitude;
    }


}
