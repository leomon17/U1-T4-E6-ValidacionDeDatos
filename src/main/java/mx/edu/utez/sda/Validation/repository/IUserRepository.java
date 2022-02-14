package mx.edu.utez.sda.Validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.edu.utez.sda.Validation.entity.User;

public interface IUserRepository extends JpaRepository<User, Long> {
    
    @Query(value = "SELECT * FROM user WHERE username = :username AND password = :password", nativeQuery = true)
    User verificarUsuario(@Param("username") String username, @Param("password") String password);
}
