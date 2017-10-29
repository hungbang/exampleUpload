package com.aptech.service;

import com.aptech.entity.Image;
import com.aptech.repository.ImageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by KAI on 10/28/17.
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false, rollbackFor = Exception.class)
    public void saveImagePath(String pathImage) {
        Image image = new Image(pathImage);
        imageRepository.save(image);
    }

    @Override
    public List<Image> getImages() {
        return imageRepository.findAll();
    }
}
