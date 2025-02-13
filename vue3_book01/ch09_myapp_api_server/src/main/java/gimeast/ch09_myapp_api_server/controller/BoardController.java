package gimeast.ch09_myapp_api_server.controller;

import gimeast.ch09_myapp_api_server.dto.BoardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BoardController {
    List<BoardDto> dummyListData = new ArrayList<>();

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/boards/list")
    public ResponseEntity<List<BoardDto>> getBoardList() {
        return ResponseEntity.ok().body(dummyListData);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/boards/detail/{no}")
    public ResponseEntity<BoardDto> getBoard(@PathVariable Long no) {
        BoardDto detail = dummyListData.stream().filter(data -> data.getNo().equals(no))
                .findFirst()
                .orElseThrow();
        return ResponseEntity.ok().body(detail);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/boards/delete/{no}")
    public ResponseEntity<List<BoardDto>> deleteBoard(@PathVariable Long no) {
        dummyListData.removeIf(data -> data.getNo().equals(no));
        return ResponseEntity.ok().body(dummyListData);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/boards/insert")
    public ResponseEntity<List<BoardDto>> insertBoard(@RequestBody BoardDto board) {
        Long currentMaxNo = dummyListData.stream().map(BoardDto::getNo).max(Long::compareTo).orElse(0L);
        board.setNo(currentMaxNo+1);
        board.setResdate(LocalDate.now());

        dummyListData.add(board);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/boards/edit/{no}")
    public ResponseEntity<List<BoardDto>> editBoard(@PathVariable Long no, @RequestBody BoardDto board) {
        dummyListData.stream()
                .filter(dto -> dto.getNo().equals(no))
                .findFirst()
                .ifPresent(dto -> {
                    dto.setTitle(board.getTitle());
                    dto.setContent(board.getContent());
                    dto.setAuthor(board.getAuthor());
                });
        return ResponseEntity.ok().build();
    }

}
