package gimeast.ch10_myapp2_api_server.service;

import gimeast.ch10_myapp2_api_server.dto.DataroomResDto;
import gimeast.ch10_myapp2_api_server.dto.DataroomReqDto;
import gimeast.ch10_myapp2_api_server.entity.Dataroom;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public interface DataroomService {

    List<DataroomResDto> getDataroomList();

    default List<DataroomResDto> entityListToDtoList(List<Dataroom> dataroomList) {
        List<DataroomResDto> dtoList = new ArrayList<>();

        if(!dataroomList.isEmpty()) {
            for (Dataroom dataroom : dataroomList) {
                DataroomResDto dataroomResDto = new DataroomResDto();
                dataroomResDto.setDno(dataroom.getDno());
                dataroomResDto.setTitle(dataroom.getTitle());
                dataroomResDto.setAuthor(dataroom.getAuthor());
                dataroomResDto.setHits(dataroom.getHits());
                dataroomResDto.setRegdate(dataroom.getRegDate());

                dtoList.add(dataroomResDto);
            }
        }

        return dtoList;
    }

    DataroomResDto saveDataroom(DataroomReqDto dataroomReqDto);

    default Dataroom dtoToEntity(DataroomReqDto dataroomReqDto, String datafile) {
        return Dataroom.builder()
                .title(dataroomReqDto.getTitle())
                .content(dataroomReqDto.getContent())
                .author(dataroomReqDto.getAuthor())
                .datafile(datafile)
                .build();
    }

    default DataroomResDto entityToDto(Dataroom dataroom) {
        DataroomResDto dataroomResDto = new DataroomResDto();
        dataroomResDto.setDno(dataroom.getDno());
        dataroomResDto.setTitle(dataroom.getTitle());
        dataroomResDto.setContent(dataroom.getContent());
        dataroomResDto.setAuthor(dataroom.getAuthor());
        dataroomResDto.setHits(dataroom.getHits());
        dataroomResDto.setRegdate(dataroom.getRegDate());
        return dataroomResDto;
    }

    DataroomResDto getDataroom(Long dno);

    DataroomResDto updateDataroom(DataroomReqDto dataroomReqDto);
}
