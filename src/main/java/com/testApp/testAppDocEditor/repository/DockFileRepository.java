package com.testApp.testAppDocEditor.repository;

import com.testApp.testAppDocEditor.entity.DockFile;
import com.testApp.testAppDocEditor.entity.TypeDockFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.Optional;

public interface DockFileRepository extends JpaRepository<DockFile, Long> {

    Optional<DockFile> findByName(String name);

    Optional<DockFile> findByCreateAt(Instant date);

    Optional<DockFile> findByTypeDockFile(TypeDockFile type);

}
