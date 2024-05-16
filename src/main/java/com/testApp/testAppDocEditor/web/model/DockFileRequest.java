package com.testApp.testAppDocEditor.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DockFileRequest {

    private Long id;

    private String name;

    private String body;

    private String typeDockFile;
}
