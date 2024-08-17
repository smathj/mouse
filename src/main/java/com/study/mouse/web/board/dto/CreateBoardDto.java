package com.study.mouse.web.board.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBoardDto {

    private Long boardId;
    private String boardTitle;
    private String boardContents;
    private String codeId;
    private List<MultipartFile> fileList = new ArrayList<MultipartFile>();
//    private List<MultipartFile> fileList;
//    private MultipartFile[] fileList;


}
