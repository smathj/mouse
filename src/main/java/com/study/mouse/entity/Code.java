package com.study.mouse.entity;

import com.study.mouse.web.code.dto.CodeDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Code extends BaseEntity {

    @Id
    private String codeId;  // apple

    @Column(nullable = false, unique = true)
    private String codeName; // 사과


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentCode")
    private Code parentCode;

    @BatchSize(size = 1000)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentCode")
    private List<Code> childCodeList = new ArrayList<>();




    public List<CodeDto> childToDtoList() {

        List<Code> childCodeList = this.getChildCodeList();

        List<CodeDto> dtoList = childCodeList
                .stream()
                .map(code -> {
                    return CodeDto.builder()
                            .codeId(code.getCodeId())
                            .codeName(code.getCodeName())
                            .childCodeList(code.childToDtoList())
                            .parentCodeId(code.getParentCode().getCodeId())
                            .build();
                })
                .toList();

        return dtoList;
    }






}
