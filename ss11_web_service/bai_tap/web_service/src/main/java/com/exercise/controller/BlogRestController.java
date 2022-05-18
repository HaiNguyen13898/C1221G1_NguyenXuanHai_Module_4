package com.exercise.controller;

import com.exercise.model.Blog;
import com.exercise.model.Category;
import com.exercise.service.IBlogService;
import com.exercise.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogRest")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "/listBlog")
    public ResponseEntity<Page<Blog>> getPageBlog(@PageableDefault(value = 3) Pageable pageable) {
        Page<Blog> blogPage = this.blogService.findAll(pageable);
        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping(value = "/listCategory")
    public ResponseEntity<List<Category>> getCategory() {
        List<Category> categoryList = this.categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }


    @GetMapping(value = "/detailBlog")
    public ResponseEntity<Blog> findById(@RequestParam int id) {
        Blog blog = this.blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(blog, HttpStatus.OK);
    }


    @GetMapping(value = "/allBlogCategory")
    public ResponseEntity<Blog> findByCategory (@RequestParam String name) {
        List <Blog> blogList = this.blogService.findAllByCategory_NameCategory(name);
        if (blogList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(blogList, HttpStatus.FOUND);
    }





}
