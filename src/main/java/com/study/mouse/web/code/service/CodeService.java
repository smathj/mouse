package com.study.mouse.web.code.service;

import com.study.mouse.common.exception.NoFindCodeException;
import com.study.mouse.entity.Code;
import com.study.mouse.web.code.dto.CodeDto;
import com.study.mouse.web.code.dto.CreateCodeDto;
import com.study.mouse.web.code.repository.CodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CodeService {

    private final CodeRepository codeRepository;

    public CodeDto findCode(String codeId) {
        Code findCode = codeRepository.findById(codeId).orElseThrow(() -> new NoFindCodeException("존재하지 않는 코드입니다"));

        CodeDto codeDto = CodeDto.builder()
                .codeId(findCode.getCodeId())
                .codeName(findCode.getCodeName())
                .childCodeList(findCode.childToDtoList()) // 하위
                .parentCodeId(findCode.getParentCode() != null ? findCode.getParentCode().getCodeId() : null) // 상위
                .build();

        return codeDto;
    }

    public Code createCode(CreateCodeDto createCodeDto) {

        Code parentCode = null;
        if(createCodeDto.getParentCodeId() != null) {
            parentCode = codeRepository.findById(createCodeDto.getParentCodeId()).orElse(null);
        }

        Code code = Code.builder()
                .codeId(createCodeDto.getCodeId())
                .codeName(createCodeDto.getCodeName())
                .parentCode(parentCode)
                .build();


        code.setRegId("mouse");
//        code.setRegDate(new Date());

        Code saveCode = codeRepository.save(code);

        return saveCode;

    }
}
