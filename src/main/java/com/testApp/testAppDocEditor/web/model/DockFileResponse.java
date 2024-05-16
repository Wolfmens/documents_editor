package com.testApp.testAppDocEditor.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DockFileResponse {

    private Long id;

    private String name;

    private String body;

    private String typeDockFile;

    private String createAt;

    private String updateAt;

}
