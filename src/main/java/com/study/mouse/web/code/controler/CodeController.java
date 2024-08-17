package com.study.mouse.web.code.controler;

import com.study.mouse.common.ApiResponse;
import com.study.mouse.entity.Code;
import com.study.mouse.web.code.dto.CodeDto;
import com.study.mouse.web.code.dto.CreateCodeDto;
import com.study.mouse.web.code.repository.CodeRepository;
import com.study.mouse.web.code.service.CodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class CodeController {

    private final CodeService codeService;
    private final CodeRepository codeRepository;


    @ResponseBody
    @GetMapping("/code/{codeId}")
    public ApiResponse<CodeDto> getCode(@PathVariable(name = "codeId") String codeId) {
        CodeDto codeDto = codeService.findCode(codeId);
        return new ApiResponse<>(true, codeDto);
    }

    @ResponseBody
    @PostMapping("/code/save")
    public ApiResponse<Code> createCode(@RequestBody CreateCodeDto createCodeDto) {
        Code code = codeService.createCode(createCodeDto);
        return new ApiResponse<>(true, code);
    }


}
