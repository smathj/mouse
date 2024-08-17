package com.study.mouse.web.code.dto;

import com.study.mouse.entity.Code;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateCodeDto {

    private String codeId;  // apple
    private String codeName; // 사과
    private String parentCodeId; // fruit


}
