package com.bywang.bootrestful.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Reader1 {
    private String name;
    private Integer age;
}
