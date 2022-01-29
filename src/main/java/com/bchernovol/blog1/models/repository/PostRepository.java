package com.bchernovol.blog1.models.repository;

import com.bchernovol.blog1.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
}
