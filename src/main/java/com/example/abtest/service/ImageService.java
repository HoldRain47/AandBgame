package com.example.abtest.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageService {

    private final String uploadDir = "uploads";

    public String saveImage(MultipartFile image) throws IOException {
        if (image == null || image.isEmpty()) return null;

        File uploadDir = new File("uploads");
        if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // 존재하지 않으면 생성
        }

        Path uploadPath = getUploadPath();
        String fileName = UUID.randomUUID() + "_" + image.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);

        image.transferTo(filePath.toFile());

        return "/uploads/" + fileName;
    }

    private Path getUploadPath() throws IOException {
        ClassPathResource resource = new ClassPathResource("static/uploads");
        Path uploadPath = resource.getFile().toPath();

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        return uploadPath;
    }
}
