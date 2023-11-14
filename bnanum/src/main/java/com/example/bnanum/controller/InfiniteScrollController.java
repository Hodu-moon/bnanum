package com.example.bnanum.controller;

import com.example.bnanum.domain.Board;
import com.example.bnanum.dto.BoardScrollDTO;
import com.example.bnanum.service.BoardService;
import jakarta.persistence.PreUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class InfiniteScrollController {

    private static final int DEFAULT_BOARD_PAGINATION_SIZE = 5;
    private  final BoardService boardService;


    // 0  번부터 시작하는 걸로 하자
    @GetMapping("/boards")
    public ResponseEntity<Page<Board>> getItemsPage(@RequestBody BoardScrollDTO boardScrollDTO) {

        String category = boardScrollDTO.getCategory();

        int pageNumber = boardScrollDTO.getPageNumber();


        Page<Board> boards = boardService.getBoards(category, pageNumber);

        return new ResponseEntity<>(boards, HttpStatus.OK);

    }


}
