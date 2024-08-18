package com.study.mouse.web.file.service;

import com.study.mouse.entity.FileItem;
import com.study.mouse.web.file.dto.FileItemDto;
import com.study.mouse.web.file.repository.FileRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

    public void findFile(String paramFileId, HttpServletResponse response) {
        try {
            Long fileId = Long.valueOf(paramFileId);
            FileItem file = fileRepository.findById(fileId).orElse(null);

            String filePath = file.getFilePath();

//            String fileName = UriUtils.encodePath(file.getFileOriginalName(), StandardCharsets.UTF_8);
            String fileName = URLEncoder.encode(file.getFileOriginalName(), StandardCharsets.UTF_8);

            File targetFile = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(targetFile);
            response.setHeader("cache-control", "no-cache");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Length", String.valueOf(targetFile.length()));

            byte[] buffer = new byte[1024 * 8];
            while (true) {
                final int read = fileInputStream.read(buffer);
                if (read == -1) {
                    break;
                }
                response.getOutputStream().write(buffer, 0, read);
            }
            fileInputStream.close();

        } catch(Exception e) {
            e.printStackTrace();
        }




    }

    public FileItemDto findFileName(String fileId) {
        FileItem fileItem = fileRepository.findById(Long.valueOf(fileId)).orElse(null);
        FileItemDto fileItemDto = FileItemDto.builder()
                .fileOriginalName(fileItem.getFileOriginalName())
                .fileSaveName(fileItem.getFileSaveName())
                .fileSize(fileItem.getFileSize())
                .fileExt(fileItem.getFileExt())
                .fileId(fileItem.getFileId())
                .filePath(fileItem.getFilePath())
                .build();
        return fileItemDto;
    }
}
