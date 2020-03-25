package com.example.attendancedemo;

public class UserInfo {
    String loginLatitude,loginLongitude,loginDate,loginTime/*,logoutLatitude,logoutLongitude,logoutDate,logoutTime*/;

    public UserInfo(String loginLatitude, String loginLongitude, String loginDate, String loginTime, String logoutLatitude, String logoutLongitude, String logoutDate, String logoutTime) {
        this.loginLatitude = loginLatitude;
        this.loginLongitude = loginLongitude;
        this.loginDate = loginDate;
        this.loginTime = loginTime;
       /* this.logoutLatitude = logoutLatitude;
        this.logoutLongitude = logoutLongitude;
        this.logoutDate = logoutDate;
        this.logoutTime = logoutTime;*/
    }

    public UserInfo() {

    }

    public String getLoginLatitude() {
        return loginLatitude;
    }

    public void setLoginLatitude(String loginLatitude) {
        this.loginLatitude = loginLatitude;
    }

    public String getLoginLongitude() {
        return loginLongitude;
    }

    public void setLoginLongitude(String loginLongitude) {
        this.loginLongitude = loginLongitude;
    }

    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

  /*  public String getLogoutLatitude() {
        return logoutLatitude;
    }

    public void setLogoutLatitude(String logoutLatitude) {
        this.logoutLatitude = logoutLatitude;
    }

    public String getLogoutLongitude() {
        return logoutLongitude;
    }

    public void setLogoutLongitude(String logoutLongitude) {
        this.logoutLongitude = logoutLongitude;
    }

    public String getLogoutDate() {
        return logoutDate;
    }
    public void setLogoutDate(String logoutDate) {
        this.logoutDate = logoutDate;
    }

    public String getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(String logoutTime) {
        this.logoutTime = logoutTime;
    }*/
}
