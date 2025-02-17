package gimeast.ch10_myapp2_api_server.service;

import gimeast.ch10_myapp2_api_server.common.utils.FileUtils;
import gimeast.ch10_myapp2_api_server.dto.DataroomResDto;
import gimeast.ch10_myapp2_api_server.dto.DataroomReqDto;
import gimeast.ch10_myapp2_api_server.entity.Dataroom;
import gimeast.ch10_myapp2_api_server.repository.DataroomRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class DataroomServiceImpl implements DataroomService{

    private final DataroomRepository dataroomRepository;
    private final FileUtils fileUtils;

    @Override
    public List<DataroomResDto> getDataroomList() {
        List<Dataroom> findAllDatarooms = dataroomRepository.findAll();
        return entityListToDtoList(findAllDatarooms);
    }

    @Override
    public DataroomResDto saveDataroom(DataroomReqDto dataroomReqDto) {
        String datafile = fileUtils.uploadFile(dataroomReqDto.getDatafile());
        Dataroom dataroom = dtoToEntity(dataroomReqDto, datafile);
        dataroomRepository.save(dataroom);
        return entityToDto(dataroom);
    }

    @Override
    public DataroomResDto getDataroom(Long dno) {
        Optional<Dataroom> findDataroom = dataroomRepository.findById(dno);
        Dataroom dataroom = findDataroom.orElseThrow();
        return entityToDto(dataroom);
    }

    @Transactional
    @Override
    public DataroomResDto updateDataroom(DataroomReqDto dataroomReqDto) {
        Optional<Dataroom> findDataroom = dataroomRepository.findById(dataroomReqDto.getDno());

        if(findDataroom.isPresent()) {
            Dataroom dataroom = findDataroom.get();
            if(!ObjectUtils.isEmpty(dataroom.getDatafile())) {
                fileUtils.deleteFiles(dataroom.getDatafile());
            }
            String datafile = fileUtils.uploadFile(dataroomReqDto.getDatafile());
            dataroom.updateDataroom(dataroomReqDto.getTitle(), dataroomReqDto.getContent(), dataroomReqDto.getAuthor(), datafile);
            return entityToDto(dataroom);
        }

        return null;
    }
}
