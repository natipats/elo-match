package com.wileyedge.elomatch.persistence;

import com.wileyedge.elomatch.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

// The @Repository annotation indicates that this interface is a repository,
// allowing it to be automatically detected and used by the framework.

// The JpaRepository<UserModel, UUID> specifies that UserModel is the entity class managed
// by this repository, and UUID is the type of the entity's identifier (primary key).

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
