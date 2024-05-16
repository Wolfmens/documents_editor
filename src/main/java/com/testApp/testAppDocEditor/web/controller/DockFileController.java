package com.testApp.testAppDocEditor.web.controller;

import com.testApp.testAppDocEditor.mapper.DockFileMapper;
import com.testApp.testAppDocEditor.service.DockFileService;
import com.testApp.testAppDocEditor.web.model.DockFileRequest;
import com.testApp.testAppDocEditor.web.model.DockFileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/app/v1/docks")
@RequiredArgsConstructor
public class DockFileController {

    private final DockFileService dockFileService;

    private final DockFileMapper dockFileMapper;

    @GetMapping
    public String index(Model model) {
        List<DockFileResponse> dockFileResponseList = dockFileMapper.fromListDockFileToDockListResponse(dockFileService.findAll());
        model.addAttribute("request", new DockFileRequest());
        model.addAttribute("documents", dockFileResponseList);
        System.out.println();
        return "index";
    }

    @GetMapping("/find-name")
    public String findDock(@RequestParam(value = "name") String name, Model model) {
        DockFileResponse response = dockFileMapper.fromDockFileToDockFileResponse(dockFileService.findByName(name));
        model.addAttribute("request", new DockFileRequest());
        model.addAttribute("documents", Collections.singletonList(response));

        return "index";
    }

    @GetMapping("/find-date")
    public String findDockFileByCreateDate(@RequestParam(value = "date") String date, Model model) {
        DockFileResponse response = dockFileMapper.fromDockFileToDockFileResponse(dockFileService.findByCreateAt(date));
        model.addAttribute("request", new DockFileRequest());
        model.addAttribute("documents", Collections.singletonList(response));

        return "index";
    }

    @GetMapping("/find-type")
    public String findDockFileByType (@RequestParam(value = "type") String type, Model model) {
        DockFileResponse response = dockFileMapper.fromDockFileToDockFileResponse(dockFileService.findByTypeDockFile(type));
        model.addAttribute("request", new DockFileRequest());
        model.addAttribute("documents", Collections.singletonList(response));

        return "index";
    }

    @PostMapping("/create")
    public String createDockFile(@ModelAttribute DockFileRequest request) {
        dockFileService.create(dockFileMapper.fromDockFileRequestToDockFile(request));

        return "redirect:/app/v1/docks";
    }

    @GetMapping("/update/{id}")
    public String getUpdateWeb(@PathVariable Long id, Model model) {
        DockFileRequest request = dockFileMapper.fromDockFileToDockFileRequest(dockFileService.findById(id));
        if (request != null) {
            model.addAttribute("request", request);

            return "update";
        }

        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateDockFile(@ModelAttribute DockFileRequest request) {
        dockFileService.update(dockFileMapper.fromDockFileRequestToDockFile(request));

        return "redirect:/app/v1/docks";
    }

    @GetMapping("/delete/{id}")
    public String deleteDock(@PathVariable Long id) {
        dockFileService.delete(id);

        return "redirect:/app/v1/docks";
    }





}
