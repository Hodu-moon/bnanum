package com.example.bnanum.service;

import com.example.bnanum.domain.Board;
import com.example.bnanum.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private static final int GET_BOARD_NUMBER = 5;
    private final BoardRepository boardRepository;

    public Page<Board> getBoards(String category, int pageNumber){
        Pageable pageable = null;

        if(pageNumber == 0)
            pageable = PageRequest.of(0, GET_BOARD_NUMBER);

        pageable = PageRequest.of(pageNumber, GET_BOARD_NUMBER);

        Page<Board> byCategory = boardRepository.findByCategory(category, pageable);

        return byCategory;

    }





}
