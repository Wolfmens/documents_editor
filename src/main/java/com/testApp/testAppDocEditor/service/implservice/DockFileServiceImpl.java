package com.testApp.testAppDocEditor.service.implservice;

import com.testApp.testAppDocEditor.entity.DockFile;
import com.testApp.testAppDocEditor.entity.TypeDockFile;
import com.testApp.testAppDocEditor.exception.NotFoundException;
import com.testApp.testAppDocEditor.repository.DockFileRepository;
import com.testApp.testAppDocEditor.service.DockFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DockFileServiceImpl implements DockFileService {

    private final DockFileRepository repository;

    @Override
    public List<DockFile> findAll() {
        return repository.findAll();
    }

    @Override
    public DockFile findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException
                (MessageFormat.format("Document with id {0} not found", id)));
    }

    @Override
    public DockFile findByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    //можно cделать список по дате
    @Override
    public DockFile findByCreateAt(String date) {
        Instant findDate = Instant.parse(date.trim());
        return repository.findByCreateAt(findDate).orElseThrow(() -> new NotFoundException
                (MessageFormat.format("Document with date {0} not found", date)));
    }

    @Override
    public DockFile findByTypeDockFile(String type) {
        return repository.findByTypeDockFile(TypeDockFile.valueOf(type)).orElseThrow(() -> new NotFoundException
                (MessageFormat.format("Document by type {0} not found", type)));
    }

    @Override
    public DockFile create(DockFile file) {

        return repository.save(file);
    }

    @Override
    public DockFile update(DockFile file) {
        DockFile fileFromBD = findById(file.getId());
        fileFromBD.setName(file.getName());
        fileFromBD.setBody(file.getBody());
        fileFromBD.setTypeDockFile(file.getTypeDockFile());

        return repository.save(fileFromBD);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
