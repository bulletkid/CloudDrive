package com.manuanand.clouddrive;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import com.manuanand.clouddrive.File;

// This will be AUTO IMPLEMENTED by Spring into a Bean called nodeRepository
// CRUD refers Create, Read, Update, Delete
//@RepositoryDefinition(domainClass = File.class, idClass = Integer.class)
public interface FileRepository extends CrudRepository<File, Integer>{
    //Optional<File> findById(Integer var1);

    boolean existsById(Integer var1);
    
    Iterable<File> findByUserId(Integer userId);
    
    
    @Query(value = "SELECT f FROM File f where f.userId = :userId AND f.remotePath = :remotePath order by f.version desc")
    Iterable<File> findByUserIdAndRemotePath(@Param("userId") Integer userId, 
            										@Param("remotePath") String remotePath);
    
    
    //Iterable<File> findByVersion(Integer version);
}
