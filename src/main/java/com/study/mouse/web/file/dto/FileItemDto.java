package com.study.mouse.web.file.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileItemDto {

    private Long fileId;
    private String fileSaveName;
    private String fileOriginalName;
    private String filePath;
    private String fileExt;
    private Long fileSize;

}
