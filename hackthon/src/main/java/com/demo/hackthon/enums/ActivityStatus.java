package com.demo.hackthon.enums;


public enum ActivityStatus {
    NEW("1", "New"),
    STARTED("2","Started"),
    ONGOING("3", "Ongoing"),
    CLOSED("4","Closed");



    private final String objectCode;
    private final String objectName;
    ActivityStatus(String objectCode, String objectName) {
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
