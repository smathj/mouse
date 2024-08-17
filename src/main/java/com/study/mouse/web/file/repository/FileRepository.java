package com.study.mouse.web.file.repository;

import com.study.mouse.entity.FileItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileItem, Long> {

}
