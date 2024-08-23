package com.study.mouse;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.study.mouse.common.dto.Book;
import com.study.mouse.common.dto.TestDto;
import com.study.mouse.web.board.dto.CreateBoardDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class Test1 {

    ObjectMapper mapper = null;

    @BeforeEach
    public void before() {
                // 다향성 처리
        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator
                .builder()
                // .allowIfSubType("com.yourcompany.models")
                .allowIfSubType(Object.class)   // Object 클래스 이하로 설정
                .build();

        mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
//                .activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL)
        ;
    }



    @Test
    @DisplayName("")
    public void asd() throws Exception {

        CreateBoardDto createBoardDto = CreateBoardDto.builder()
                .boardId(1L)
                .build();

        Map<String,Object> map = mapper.convertValue(createBoardDto, HashMap.class);
        System.out.println("map = " + map);

        String isJson = mapper.writeValueAsString(map);
        System.out.println("isJson = " + isJson);

        String jsonText = mapper.writeValueAsString(createBoardDto);
        System.out.println("jsonText = " + jsonText);

        CreateBoardDto newObj = mapper.readValue(jsonText, CreateBoardDto.class);
        System.out.println("newObj = " + newObj);


    }

    @Test
    @DisplayName("")
    public void test2() throws Exception {
        TestDto testDto = TestDto.builder()
                .name("새로운책")
                .age(10)
                .strList(Arrays.asList("1", "2"))
//                .bookList(Arrays.asList(new Book("책", "저자")))
                .createDate(new Date())
                .build();

        Map map = mapper.convertValue(testDto, Map.class);
        System.out.println("map = " + map);

        String jsonText = mapper.writeValueAsString(testDto);
        System.out.println("jsonText = " + jsonText);

        TestDto makeDto = mapper.readValue(jsonText, new TypeReference<TestDto>() {});
        System.out.println("makeDto = " + makeDto);

        TestDto makeDto2 = mapper.readValue(jsonText, TestDto.class);
        System.out.println("makeDto2 = " + makeDto2);

        List<TestDto> testDtoList = mapper.readValue(jsonText, new TypeReference<List<TestDto>>() {});
        System.out.println("testDtoList = " + testDtoList);


    }
    @Test
    @DisplayName("")
    public void test3() throws Exception {
        TestDto testDto = TestDto.builder()
                .name("새로운책")
                .age(10)
                .strList(Arrays.asList("1", "2"))
//                .bookList(Arrays.asList(new Book("책", "저자")))
                .createDate(new Date())
                .build();

        TestDto testDto2 = TestDto.builder()
                .name("새로운책2")
                .age(20)
//                .strList(Arrays.asList("1", "2"))
//                .bookList(Arrays.asList(new Book("책", "저자")))
                .createDate(new Date())
                .build();


        List<TestDto> list = Arrays.asList(testDto, testDto2);

//        for (TestDto dto : list) {
//            System.out.println("before = " + dto);
//        }


        String jsonText = mapper.writeValueAsString(list);
        System.out.println("jsonText = " + jsonText);



        TestDto[] testArray = mapper.readValue(jsonText, TestDto[].class);
        System.out.println("testArray = " + Arrays.toString(testArray));

        List<TestDto> arrayToList = Arrays.asList(testArray);
        System.out.println("arrayToList = " + arrayToList);


        // ----------------------------------------------------------------------------------------------------------
        List<TestDto> testDtoList = mapper.readValue(jsonText, new TypeReference<List<TestDto>>() {});
        System.out.println("testDtoList = " + testDtoList);




        List<TestDto> jsonToReadValue = mapper.readValue(jsonText, List.class);
        System.out.println("jsonToReadValue = " + jsonToReadValue);
        // ----------------------------------------------------------------------------------------------------------

        List<TestDto> listToConvert = mapper.convertValue(testDtoList, List.class);
        System.out.println("listToConvert = " + listToConvert);




//        for (TestDto dto : testDtoList) {
//            System.out.println("after = " + dto);
//        }


    }
}
