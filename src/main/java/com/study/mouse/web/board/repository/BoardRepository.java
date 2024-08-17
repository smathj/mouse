package com.study.mouse.web.board.repository;

import com.study.mouse.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {


}
