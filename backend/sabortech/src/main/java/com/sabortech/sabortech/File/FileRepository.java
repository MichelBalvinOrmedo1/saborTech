package com.sabortech.sabortech.File;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileModel, UUID> {

    FileModel findFileById(UUID id);

}
