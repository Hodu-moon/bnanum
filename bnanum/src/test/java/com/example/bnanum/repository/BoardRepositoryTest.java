package com.example.bnanum.repository;

import com.example.bnanum.domain.Board;
import com.example.bnanum.domain.Member;
import com.example.bnanum.entity.Department;
import com.example.bnanum.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardRepositoryTest {
    @Autowired
    private  BoardRepository boardRepository;

    @Test
    public void insertBoards(){

        for (int i = 0; i < 300; i++) {
            Board board = Board.builder().
                    title("board" + i).
                    category("computer11").
                    text("text..." + i).
                    build();


            boardRepository.save(board);
        }

    }
}
