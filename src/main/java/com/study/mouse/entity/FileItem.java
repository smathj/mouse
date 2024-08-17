package com.study.mouse.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "FILE")
public class FileItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;

    private String fileSaveName;
    private String fileOriginalName;
    private String filePath;
    private String fileExt;
    private Long fileSize;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;


}
