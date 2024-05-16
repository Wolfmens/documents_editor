package com.testApp.testAppDocEditor.service;

import com.testApp.testAppDocEditor.entity.DockFile;

import java.util.List;

public interface DockFileService {

    List<DockFile> findAll();

    DockFile findById(Long id);

    DockFile findByName(String name);

    DockFile findByCreateAt(String date);

    DockFile findByTypeDockFile(String type);

    DockFile create(DockFile file);

    DockFile update(DockFile file);

    void delete(Long id);

}
