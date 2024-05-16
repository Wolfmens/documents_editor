package com.testApp.testAppDocEditor.mapper;

import com.testApp.testAppDocEditor.entity.DockFile;
import com.testApp.testAppDocEditor.entity.TypeDockFile;
import com.testApp.testAppDocEditor.web.model.DockFileRequest;
import com.testApp.testAppDocEditor.web.model.DockFileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DockFileMapper {


    public DockFileResponse fromDockFileToDockFileResponse(DockFile file) {
        return DockFileResponse
                .builder()
                .id(file.getId())
                .name(file.getName())
                .typeDockFile(file.getTypeDockFile().name())
                .createAt(file.getCreateAt().toString())
                .updateAt(file.getUpdateAt().toString())
                .body(file.getBody())
                .build();
    }

    public DockFile fromDockFileRequestToDockFile(DockFileRequest request) {
        return DockFile
                .builder()
                .id(request.getId())
                .name(request.getName())
                .body(request.getBody())
                .typeDockFile(TypeDockFile.valueOf(request.getTypeDockFile().toUpperCase()))
                .build();
    }

    public DockFileRequest fromDockFileToDockFileRequest(DockFile dockFile) {
        return DockFileRequest
                .builder()
                .id(dockFile.getId())
                .name(dockFile.getName())
                .body(dockFile.getBody())
                .typeDockFile(dockFile.getTypeDockFile().name())
                .build();
    }


    public List<DockFileResponse> fromListDockFileToDockListResponse(List<DockFile> dockFileList) {

        return new ArrayList<>(dockFileList.stream()
                .map(this::fromDockFileToDockFileResponse)
                .toList());
    }
}
