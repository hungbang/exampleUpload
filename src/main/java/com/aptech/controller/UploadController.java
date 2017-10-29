package com.aptech.controller;

import com.aptech.entity.Image;
import com.aptech.service.ImageService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by KAI on 10/28/17.
 */
@Controller
public class UploadController {

    public final static Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    private ImageService imageService;

    private static String UPLOADED_FOLDER  = "/Users/KAI/HungBang/upload-file-with-spring-boot/src/main/resources/image/";

    @GetMapping("/uploadPage")
    public String uploadPage(){
        LOGGER.info("go to upload page");
        return "upload";
    }


    @GetMapping("/showList")
    public ModelAndView showList(ModelAndView model){
        List<Image> images = imageService.getImages();
        model.addObject("images", images);
        model.setViewName("showlist");
        LOGGER.info("go to upload page");
        return model;
    }

    @PostMapping("/handleUpload")
    public String handleUpload(@RequestParam("file") MultipartFile file) throws IOException {
        LOGGER.info("handle upload");
        if(file.isEmpty()){
            throw new RuntimeException("File not found");
        }
        LOGGER.info(file.getOriginalFilename());
        byte[] imageData = file.getBytes();
        String pathFile = UPLOADED_FOLDER + file.getOriginalFilename();
        Path path = Paths.get(pathFile);
        Files.write(path, imageData);
        //save upload
        String pathSave = "upload/"+file.getOriginalFilename();
        imageService.saveImagePath(pathSave);
        return "upload";
    }


    @ExceptionHandler(IOException.class)
    public ResponseEntity<?> handleIOException(HttpServletRequest request, HttpServletResponse response, IOException e){
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().build();
    }

}
