package com.workmotion.employee.enums;

public enum EmployeeState {

    ADDED(1),
    IN_CHECK(2),
    APPROVED(3),
    ACTIVE(4);


    private int value;

    private EmployeeState(int value) {
        this.value= value;
    }

    // getter method
    public int getAction()
    {
        return this.value;
    }
}
