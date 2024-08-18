package com.study.mouse.web.file.controller;

import com.study.mouse.common.ApiResponse;
import com.study.mouse.entity.FileItem;
import com.study.mouse.web.file.dto.FileItemDto;
import com.study.mouse.web.file.service.FileService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @GetMapping("/file/{fileId}")
    public void getFile(@PathVariable(name = "fileId") String fileId, HttpServletResponse response) {
        fileService.findFile(fileId, response);
    }

    @ResponseBody
    @GetMapping("/file/{fileId}/name")
    public ApiResponse<?> getFileName(@PathVariable(name = "fileId") String fileId) {
        FileItemDto fileItemDto = fileService.findFileName(fileId);
        return new ApiResponse(true, fileItemDto);
    }

}
