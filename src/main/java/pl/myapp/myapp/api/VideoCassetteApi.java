package pl.myapp.myapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.myapp.myapp.dao.entity.VideoCassette;
import pl.myapp.myapp.manager.VideoCassetteManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassetts")
public class VideoCassetteApi {


    private VideoCassetteManager VideoCassettes;

    @Autowired
    public VideoCassetteApi(VideoCassetteManager videoCassettes) {
        this.VideoCassettes = videoCassettes;
    }

    @GetMapping("/all")
    public Iterable<VideoCassette> getAll() {
        return VideoCassettes.findAll();
    }

    @GetMapping
    public Optional<VideoCassette> getById(@RequestParam Long index) {
        return VideoCassettes.findById(index);
    }

    @PostMapping
    public VideoCassette addVideo(@RequestBody VideoCassette videoCassette) {
        return VideoCassettes.save(videoCassette);
    }

    @PutMapping
    public VideoCassette updateVideo(@RequestBody VideoCassette videoCassette) {
        return VideoCassettes.save(videoCassette);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index) {
        VideoCassettes.deleteById(index);
    }

}