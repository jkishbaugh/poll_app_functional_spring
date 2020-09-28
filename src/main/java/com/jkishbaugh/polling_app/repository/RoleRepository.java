package com.jkishbaugh.polling_app.repository;

import com.jkishbaugh.polling_app.model.Role;
import com.jkishbaugh.polling_app.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
