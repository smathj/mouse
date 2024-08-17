package com.study.mouse.web.code.dto;

import com.study.mouse.entity.Code;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class CodeDto {

    private String codeId;  // apple
    private String codeName; // 사과
    private String parentCodeId;
    private List<CodeDto> childCodeList = new ArrayList<>();

}
