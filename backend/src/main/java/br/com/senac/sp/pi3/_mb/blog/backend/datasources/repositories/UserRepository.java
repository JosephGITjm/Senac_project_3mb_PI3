package br.com.senac.sp.pi3._mb.blog.backend.datasources.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.senac.sp.pi3._mb.blog.backend.domainmodel.entities.User;

public interface  UserRepository extends JpaRepository<User, UUID> {

    public List<User> findByName (String name);

    //JPQL: Java Persistence Query Language
    @Query("SELECT DISTINCT u from User u JOIN u.roles r WHERE r.name = :roleName")
    public List<User> findByRole(String roleName);

    @Query("SELECT DISTINCT(u.id) from SYSTEM_USERS u, ROLES r WHERE r.id = u.ID AND r.NAME = :roleName", nativeQuery = true)
    public List<User> findByRoles(String roleName);
    
}
