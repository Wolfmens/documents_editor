package com.testApp.testAppDocEditor.web.interceptor;

import com.testApp.testAppDocEditor.entity.DockFile;
import com.testApp.testAppDocEditor.service.DockFileService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class NameInterceptor implements HandlerInterceptor {

    @Autowired
    private DockFileService dockFileService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String paramNameDocFromRequest = request.getParameter("name").toString();

        DockFile fileFromBD = dockFileService.findByName(paramNameDocFromRequest);

        if (fileFromBD != null) {
            response.setHeader("Docfile", "NotFound");
            response.sendError(HttpStatus.NOT_FOUND.value(), "DockFile with name " + paramNameDocFromRequest + "exist");
            log.info("DockFile with name {} exist", paramNameDocFromRequest);
            return false;
        }

        return true;
    }
}
