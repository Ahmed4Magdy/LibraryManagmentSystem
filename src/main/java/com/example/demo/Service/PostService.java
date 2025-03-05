package com.example.demo.Service;

import com.example.demo.Entity.PostDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.transform.Templates;
import java.util.List;

@Service
public class PostService {

    private static String Post_URl = "https://jsonplaceholder.typicode.com/posts";


    public PostDto getPostById(Long id) {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<PostDto> result = restTemplate.getForEntity(Post_URl + "/" + id, PostDto.class);

        return result.getBody();
    }


    public List<PostDto> getAllPost() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> result = restTemplate.getForEntity(Post_URl, List.class);
        return result.getBody();
    }


    public PostDto addPost(PostDto post) {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<PostDto> request = new HttpEntity<>(post);
        ResponseEntity<PostDto> result = restTemplate.postForEntity(Post_URl, request, PostDto.class);
        return result.getBody();
    }


    public void Delete(Long id) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(Post_URl + "/" + id);

    }


}
