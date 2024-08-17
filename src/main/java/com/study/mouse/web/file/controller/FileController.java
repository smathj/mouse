package com.study.mouse.web.file.controller;

import com.study.mouse.web.file.service.FileService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @GetMapping("/file/{fileId}")
    public void getFile(@PathVariable(name = "fileId") String fileId, HttpServletResponse response) {
        fileService.findFile(fileId, response);
    }

}
