package com.sabortech.sabortech.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    @Autowired
    FileRepository fileRepository;
    private final Path rootLocation = Paths.get("src//main//resources//static/image");

    public FileDTO profileDefaul() {
        FileModel fileModel = FileModel.builder()
                .name("perfilPreDeter.jpg")
                .type("profile")
                .build();
        FileModel model = fileRepository.save(fileModel);

        return FileDTO.builder()
                .id(model.getId())
                .name(model.getName())
                .type(model.getType())
                .build();
    }

    public FileDTO save(MultipartFile file, String type) throws IOException {
        if (!file.isEmpty()) {
            // Utiliza el valor de 'type' directamente para crear la carpeta
            Path directory = rootLocation.resolve(type);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            byte[] bytesImage = file.getBytes();
            Path rutaCompleta = directory.resolve(file.getOriginalFilename());
            Files.write(rutaCompleta, bytesImage);

            FileModel fileModel = FileModel.builder()
                    .name(file.getOriginalFilename())
                    .type(type) // Guarda el tipo proporcionado
                    .build();
            FileModel model = fileRepository.save(fileModel);

            return FileDTO.builder()
                    .id(model.getId())
                    .name(model.getName())
                    .type(model.getType())
                    .build();
        }
        return null;
    }

    public String getFilePath(UUID id) {
        FileModel fileModel = fileRepository.findById(id).orElseThrow(() -> new RuntimeException("File not found"));
        String relativePath = "image/" + fileModel.getType() + "/" + fileModel.getName();
        return relativePath;
    }

    public FileDTO update(UUID id, MultipartFile file, String type) throws IOException {
        FileModel fileModel = fileRepository.findFileById(id);
        if (fileModel != null) {
            // Si el tipo es "profile" y el nombre es "perfilPreDeter.jpg", no reemplazar la
            // imagen
            if ("profile".equals(type) && "perfilPreDeter.jpg".equals(fileModel.getName())) {
                // Guardar el nuevo archivo en el sistema de archivos
                Path directory = rootLocation.resolve(type);
                if (!Files.exists(directory)) {
                    Files.createDirectories(directory);
                }

                byte[] bytesImage = file.getBytes();
                Path newFilePath = directory.resolve(file.getOriginalFilename());
                Files.write(newFilePath, bytesImage);

                // Actualizar la información del archivo
                fileModel.setName(file.getOriginalFilename());
                fileModel.setType(type);
                fileRepository.save(fileModel);

                return FileDTO.builder()
                        .id(fileModel.getId())
                        .name(fileModel.getName())
                        .type(fileModel.getType())
                        .build();
            }
            // Guardar la ruta del archivo antiguo
            Path oldFilePath = rootLocation.resolve(fileModel.getType()).resolve(fileModel.getName());

            // Actualizar la información del archivo
            fileModel.setName(file.getOriginalFilename());
            fileModel.setType(type);
            fileRepository.save(fileModel);

            // Guardar el nuevo archivo en el sistema de archivos
            Path directory = rootLocation.resolve(type);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            byte[] bytesImage = file.getBytes();
            Path newFilePath = directory.resolve(file.getOriginalFilename());
            Files.write(newFilePath, bytesImage);

            // Eliminar el archivo antiguo si el nombre o el tipo han cambiado
            if (!oldFilePath.equals(newFilePath)) {
                Files.deleteIfExists(oldFilePath);
            }

            return FileDTO.builder()
                    .id(fileModel.getId())
                    .name(fileModel.getName())
                    .type(fileModel.getType())
                    .build();
        } else {
            throw new IOException("Archivo no encontrado");
        }
    }

}
