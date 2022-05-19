package com.exercise.dto;

import com.exercise.model.Category;

import javax.validation.constraints.NotBlank;
public class BlogDto {
    private int id;
    @NotBlank
    private String nameBlog;
    @NotBlank
    private String contentBlog;
    private Category category;

    public BlogDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getContentBlog() {
        return contentBlog;
    }

    public void setContentBlog(String contentBlog) {
        this.contentBlog = contentBlog;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
