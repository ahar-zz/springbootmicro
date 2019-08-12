package com.eureka.image.controllers;

import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
@RequestMapping("/uploads")
public class UploadController {

    @PostMapping
    public ResponseEntity insertFile(HttpServletRequest request) throws Exception {
        ServletFileUpload upload = new ServletFileUpload();
        FileItemIterator uploadItemIterator = upload.getItemIterator(request);
        upload.getItemIterator(request);
        if (!uploadItemIterator.hasNext()) {
            throw new FileUploadException("FileItemIterator was empty");
        }
        while (uploadItemIterator.hasNext()) {
            FileItemStream fileItemStream = uploadItemIterator.next();
            if (fileItemStream.isFormField()) {
                continue;
            }
            //do stuff
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
