package app.manager.web;

import app.manager.model.File;
import app.manager.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FileController {
    private FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/api/files")
    @ResponseBody
    public ResponseEntity<List<File>> getFiles() {
        List<File> files = fileService.getFiles();
        return ResponseEntity.ok(files);
    }

    @PostMapping("/api/files")
    @ResponseBody
    public String saveFile(@RequestBody FileData data) {
        boolean ok = fileService.save(new File(data));
        if (ok) {
            return "ok";
        } else {
            return "no";
        }
    }

}
