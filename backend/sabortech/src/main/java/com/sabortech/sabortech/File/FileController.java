package com.sabortech.sabortech.File;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sabortech.sabortech.ApiResponse.ApiResponse;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/save")
    public ApiResponse<FileDTO> saveImage(@RequestParam("file") MultipartFile file, @RequestParam("type") String type) {
        try {
            FileDTO fileDTO = fileService.save(file, type);
            return new ApiResponse<>("success", "images corret", fileDTO);
        } catch (IOException e) {
            return new ApiResponse<>("error", "error al guardar la imagen", null);
        }
    }

    @PutMapping("/update/{id}")
    public ApiResponse<FileDTO> updateImage(@PathVariable("id") UUID id, @RequestParam("file") MultipartFile file,
            @RequestParam("type") String type) {
        try {
            FileDTO fileDTO = fileService.update(id, file, type);
            return new ApiResponse<>("success", "imagen actualizada correctamente", fileDTO);
        } catch (IOException e) {
            return new ApiResponse<>("error", "error al actualizar la imagen", null);
        }
    }

}
