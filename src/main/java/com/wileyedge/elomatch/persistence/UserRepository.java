package com.wileyedge.elomatch.persistence;

import com.wileyedge.elomatch.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// The @Repository annotation indicates that this interface is a repository,
// allowing it to be automatically detected and used by the framework.

//The JpaRepository<UserModel, Long> represents a generic interface that provides the functionality
// for accessing and managing data in the context of a Spring Data JPA project.

// By extending JpaRepository<UserModel, Long>, the repository gains pre-defined methods
// for common database operations, such as creating, reading, updating, and deleting.

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
}
