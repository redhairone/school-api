package com.ciesielski.schoolapi.domain.model;

import lombok.Data;

@Data
public class ChildBill {
    final private Child child;
    private Double cost;
    private Long numberOfHours;

    public ChildBill(final Child child) {
        this.child = child;


    }
}
