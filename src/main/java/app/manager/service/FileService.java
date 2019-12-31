package app.manager.service;

import app.manager.model.File;
import app.manager.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FileService {

    private FileRepository repository;

    @Autowired
    public FileService(FileRepository repository) {
        this.repository = repository;
    }

    public boolean save(File file) {
        return repository.saveFile(file);
    }

    public List<File> getFiles() {
        return repository.getFiles();
    }
}
