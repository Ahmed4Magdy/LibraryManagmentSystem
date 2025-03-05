package com.example.demo.Controller;


import com.example.demo.Entity.PostDto;
import com.example.demo.Service.AuthorService;
import com.example.demo.Service.PostService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//import static com.example.demo.Service.PostService.Post_URl;

@RestController
@RequestMapping("/post")
public class PostController {



    @Autowired
    private PostService postService;

    private static final String Post_URl = "https://jsonplaceholder.typicode.com/posts";

    @GetMapping("/{id}")
    public ResponseEntity<?> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }


    @GetMapping("/")
    public List<PostDto> getAllPost() {

        return postService.getAllPost();
    }



    @PostMapping("/")
    public PostDto addPost (@RequestBody PostDto post){

        return postService.addPost(post);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Long id) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(Post_URl + "/" + id);

    }

}
