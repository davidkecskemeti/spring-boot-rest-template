package com.dk.spring.resttemplate.init;

import com.dk.spring.resttemplate.model.Post;
import com.dk.spring.resttemplate.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
public class PostCommandLineRunner implements CommandLineRunner {

    @Autowired
    private RestService restService;

    @Override
    public void run(String... args) throws Exception {
        // fetch posts as plain JSON
        System.out.println(restService.getPostsPlainJSON());

        // fetch posts as object
        for (Post post : restService.getPostsAsObject()) {
            System.out.println(post);
        }

        // fetch post with url parameter
		System.out.println(restService.getPostWithUrlParameters());

        // fetch post with response handling
		System.out.println(restService.getPostWithResponseHandling());

        // fetch post with response handling
		System.out.println(restService.getPostWithCustomHeaders());

        // create a new post
		System.out.println(restService.createPost());

        // create a new post with object
		System.out.println(restService.createPostWithObject());

        // update post
		restService.updatePost();

        // update post with response handling
		System.out.println(restService.updatePostWithResponse());

        // delete post
		restService.deletePost();

        // retrieve headers
        System.out.println(restService.retrieveHeaders().getCacheControl());

        // list allowed operations
        for (HttpMethod method : restService.allowedOperations()) {
            System.out.println(method.name());
        }

        // get request with error handling
        System.out.println(restService.unknownRequest());
    }
}
