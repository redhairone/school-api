package com.ciesielski.schoolapi.presentation.dto;

import com.ciesielski.schoolapi.infrastructure.entities.ParentEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ParentBill {
    private ParentEntity parent;
    private Double full_cost;
    private List<ChildBill> children_bills;
}
