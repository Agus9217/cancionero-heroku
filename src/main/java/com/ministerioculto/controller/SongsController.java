package com.ministerioculto.controller;

import com.ministerioculto.entity.Songs;
import com.ministerioculto.repository.SongsRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class SongsController {

    private SongsRepository songsRepository;

    public SongsController(SongsRepository songsRepository) {
        this.songsRepository = songsRepository;
    }

    @GetMapping("/cancionero")
    public List<Songs>findAll(){
        return songsRepository.findAll();
    }


    @GetMapping("/cancionero/{title}")
    public ResponseEntity<List<Songs>> findByTitleContaining(@PathVariable String title){
        List<Songs>songsList = songsRepository.findByTitleContaining(title.toLowerCase(Locale.ROOT));
        if (songsList.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<List<Songs>>(songsRepository.findByTitleContaining(title.toLowerCase(Locale.ROOT)),HttpStatus.OK);
        }
    }


    @PostMapping("/cancionero")
    public ResponseEntity<Songs>create(@RequestBody Songs songs, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        if (songs.getId() != null){
            return ResponseEntity.badRequest().build();
        } else {
            Songs result = songsRepository.save(songs);
            return ResponseEntity.ok(result);
        }
    }

    @PutMapping("/cancionero")
    public ResponseEntity<Songs>update(@RequestBody Songs songs){
        if (songs.getId() == null){
            return ResponseEntity.notFound().build();
        } if (!songsRepository.existsById(songs.getId())){
            return ResponseEntity.badRequest().build();
        } else {
            Songs result = songsRepository.save(songs);
            return ResponseEntity.ok(result);
        }
    }

    @DeleteMapping("/cancionero/{id}")
    public ResponseEntity<Songs>deleteById(@PathVariable Long id){
        if (!songsRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        } else {
            songsRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/cancionero")
    public ResponseEntity<Songs>deleteAll(){
        songsRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
