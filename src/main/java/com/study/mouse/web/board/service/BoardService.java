package com.study.mouse.web.board.service;

import com.study.mouse.entity.Board;
import com.study.mouse.entity.FileItem;
import com.study.mouse.web.board.dto.CreateBoardDto;
import com.study.mouse.web.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void save(CreateBoardDto createBoardDto) {

        Board board = Board.builder()
                .boardTitle(createBoardDto.getBoardTitle())
                .boardContents(createBoardDto.getBoardContents())
                .build();

        List<MultipartFile> fileList = createBoardDto.getFileList();

        List<FileItem> fileListItem = new ArrayList<>();
        try {

            for (MultipartFile multipartFile : fileList) {
                String originalFilename = multipartFile.getOriginalFilename();
                System.out.println("originalFilename = " + originalFilename);

                String contentType = multipartFile.getContentType();
                System.out.println("contentType = " + contentType);

                String ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
                System.out.println("ext = " + ext);


                String name = multipartFile.getName();
                System.out.println("name = " + name);

                String uuid = UUID.randomUUID().toString();
                System.out.println("uuid = " + uuid);

                String saveName = uuid+ "." + ext;
                String uploadPath = "C:\\upload\\" + saveName;
                multipartFile.transferTo(new File(uploadPath));


                FileItem fileItem = FileItem.builder()
                        .fileOriginalName(originalFilename)
                        .fileSaveName(saveName)
                        .fileExt(ext)
                        .filePath(uploadPath)
                        .fileSize(multipartFile.getSize())
                        .board(board)
                        .build();
                fileItem.setRegId("mouse");
                fileListItem.add(fileItem);


            }

            board.setFileItemList(fileListItem);
            board.setRegId("mouse");

            boardRepository.save(board);

        } catch (Exception e) {

            e.printStackTrace();
        }


    }

}
