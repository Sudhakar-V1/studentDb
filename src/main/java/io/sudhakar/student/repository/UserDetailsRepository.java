package io.sudhakar.student.repository;

import io.sudhakar.student.entity.TaskEntity;
import io.sudhakar.student.entity.UserDetailsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserDetailsRepository extends CrudRepository<UserDetailsEntity, String> {

    Optional<UserDetailsEntity> findByUsername(String username);

//    TaskEntity findByUserId(long userId);


}




