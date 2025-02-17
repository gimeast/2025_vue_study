package gimeast.ch10_myapp2_api_server.controller;

import gimeast.ch10_myapp2_api_server.dto.DataroomResDto;
import gimeast.ch10_myapp2_api_server.dto.DataroomReqDto;
import gimeast.ch10_myapp2_api_server.service.DataroomService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Log4j2
@CrossOrigin("http://localhost:8080")
public class DataroomController {

    private final DataroomService dataroomService;

    @GetMapping("/dataroom/list")
    public ResponseEntity<List<DataroomResDto>> getDataroomList() {
        List<DataroomResDto> dtoList = dataroomService.getDataroomList();
        return ResponseEntity.ok(dtoList);
    }
    
    @PostMapping("/dataroom/insert")
    public ResponseEntity<DataroomResDto> saveDataroom(DataroomReqDto dataroomReqDto) {
        DataroomResDto dto = dataroomService.saveDataroom(dataroomReqDto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/dataroom/detail/{dno}")
    public ResponseEntity<DataroomResDto> getDataroom(@PathVariable Long dno) {
        DataroomResDto dto = dataroomService.getDataroom(dno);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/dataroom/update/{dno}")
    public ResponseEntity<DataroomResDto> updateDataroom(DataroomReqDto dataroomReqDto) {
        DataroomResDto dto = dataroomService.updateDataroom(dataroomReqDto);
        return ResponseEntity.ok(dto);
    }
}
