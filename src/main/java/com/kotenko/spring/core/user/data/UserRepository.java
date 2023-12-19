package com.kotenko.spring.core.user.data;

import com.kotenko.spring.core.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
