package com.study.mouse.web.board.controller;

import ch.qos.logback.core.model.Model;
import com.study.mouse.common.ApiResponse;
import com.study.mouse.web.board.dto.CreateBoardDto;
import com.study.mouse.web.board.service.BoardService;
import com.study.mouse.web.code.dto.CodeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public String board() {
        return "board/board";
    }


    @ResponseBody
    @PostMapping("/board/save")
    public ApiResponse<CreateBoardDto> save(CreateBoardDto createBoardDto) {
        log.info("createBoardDto = {}", createBoardDto);

        boardService.save(createBoardDto);

        return new ApiResponse<>(true);
    }
}
