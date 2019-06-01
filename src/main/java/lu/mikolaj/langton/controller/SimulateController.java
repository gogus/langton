package lu.mikolaj.langton.controller;

import lu.mikolaj.langton.domain.World;
import lu.mikolaj.langton.service.LangtonService;
import lu.mikolaj.langton.view.WorldView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class SimulateController {
    private final LangtonService langtonService;

    @Autowired
    public SimulateController(LangtonService langtonService) {
        this.langtonService = langtonService;
    }

    @RequestMapping("/simulate")
    public ResponseEntity simulate(@RequestParam(value="steps", defaultValue = "1") String steps) throws IOException {
        World world = this.langtonService.simulate(Integer.parseInt(steps));

        WorldView view = new WorldView(world);
        File file = view.render();

        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok()
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"simulation.png\"")
                .body(resource);
    }
}
