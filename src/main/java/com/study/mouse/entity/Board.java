package com.study.mouse.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private String boardTitle;

    private String boardContents;

    @OneToMany(fetch = FetchType.LAZY
            , mappedBy = "board"
            , cascade = CascadeType.ALL
            , orphanRemoval = true
    )
    private List<FileItem> fileItemList = new ArrayList<>();

    public void setFileItemList(List<FileItem> fileItemList) {
        this.fileItemList = fileItemList;
    }

    public void addFile(FileItem fileItem) {
        fileItemList.add(fileItem);
    }


}
