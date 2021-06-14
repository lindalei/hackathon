package com.demo.hackthon.enums;


public enum  ActivityCategory {
    TECH_SHARE("1", "Technology"),
    LEARN("2","Learn"),
    ENTERTAINMENT("3", "Entertainment"),
    MENTAL("4","Mental");



    private final String objectCode;
    private final String objectName;
    ActivityCategory(String objectCode, String objectName) {
        this.objectCode = objectCode;
        this.objectName = objectName;
    }

    public String getObjectCode() {
        return objectCode;
    }

    public String getObjectName() {
        return objectName;
    }
}
