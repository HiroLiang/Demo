package com.example.demo.repository;

import com.example.demo.model.entity.UserData;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserDataRepository extends JpaRepository<UserData, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select u from UserData u where u.name = :name")
    Optional<UserData> findByNameWithLock(@Param("name") String name);

}
