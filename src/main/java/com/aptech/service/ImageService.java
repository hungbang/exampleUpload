package com.aptech.service;

import com.aptech.entity.Image;
import java.util.List;

/**
 * Created by KAI on 10/28/17.
 */
public interface ImageService {

    void saveImagePath(String pathImage);

    List<Image> getImages();
}
