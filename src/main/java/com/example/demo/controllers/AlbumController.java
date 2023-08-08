package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repositories.AlbumRepository;
import com.example.demo.entities.Album;

@RestController
public class AlbumController {

    // Property to hold Album Repository
    public AlbumRepository Albums;

    // Receive Album Repository via Dependency Injection
    public AlbumController(AlbumRepository Albums){
        this.Albums = Albums;
    }

    // get request to /Albums
    @CrossOrigin // Enable CORS <-    
    @GetMapping("/albums")
    public List<Album> index(){
        return Albums.findAll();
    }

    // get request to /Albums/:id
    @CrossOrigin // Enable CORS <-    
    @GetMapping("/albums/{id}")
    public Optional<Album> show(@PathVariable Integer id){
        return Albums.findById(id);
    }

    @CrossOrigin // Enable CORS <-
    @PostMapping("/albums/new")
    public List<Album> create(@RequestBody Album newAlbum){
        Albums.save(newAlbum); // Create the New Album
        return Albums.findAll();
    }

    @CrossOrigin // Enable CORS <-
    @PutMapping("/albums/{id}/update")
    public List<Album> update(@RequestBody Album fixAlbum, @PathVariable Integer id){
        // Find Album by it's then use map to update it
        Albums.findById(id).map(Album -> {

        Album.setTitle(fixAlbum.getTitle());
        Album.setReviewDate(fixAlbum.getReviewDate());
        Album.setReview(fixAlbum.getReview());
        Albums.save(Album);
        return Album;

        });
        
        // return all Albums
        return Albums.findAll();
    }

    @CrossOrigin // Enable CORS <-
    @DeleteMapping("/albums/{id}")
    public List<Album> destroy(@PathVariable Integer id){
        Albums.deleteById(id);
        return Albums.findAll();
    }

}
