package com.study.mouse.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {

    private int age;
    private String name;

    private Date createDate;

    private List<String> strList = new ArrayList<>();

    private List<Book> bookList = new ArrayList<>();



}
