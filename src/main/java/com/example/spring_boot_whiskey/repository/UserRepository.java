package com.example.spring_boot_whiskey.repository;

import com.example.spring_boot_whiskey.entity.UserEntity;
import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findUserEntitiesOrderByAgeGreaterThanOrderByAge(Integer age);

}
