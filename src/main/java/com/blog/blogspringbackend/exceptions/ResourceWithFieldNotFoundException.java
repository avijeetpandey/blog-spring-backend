package com.blog.blogspringbackend.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceWithFieldNotFoundException extends RuntimeException {
    private String resourceName;
    private String resourceFieldName;

    private String field;

    public ResourceWithFieldNotFoundException(String resourceName, String resourceFieldName, String field) {
        super(String.format("%s not found with %s : %s", resourceName, resourceFieldName, field));
        this.resourceName = resourceName;
        this.resourceFieldName = resourceFieldName;
        this.field = field;
    }
}
