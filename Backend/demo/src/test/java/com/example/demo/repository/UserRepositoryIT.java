package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryIT {

  @Container static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16");

  @Autowired private UserRepository userRepository;

  private static final String TEST_EMAIL = "find@example.com";

  @DynamicPropertySource
  static void registerPgProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", postgres::getJdbcUrl);
    registry.add("spring.datasource.username", postgres::getUsername);
    registry.add("spring.datasource.password", postgres::getPassword);
  }

  @Test
  void shouldSaveUser() {
    User user =
        User.builder()
            .email("test@example.com")
            .password("password")
            .firstname("John")
            .lastname("Doe")
            .role(Role.USER)
            .build();

    User savedUser = userRepository.save(user);

    assertThat(savedUser).isNotNull();
    assertThat(savedUser.getId()).isPositive();
    assertThat(savedUser.getEmail()).isEqualTo("test@example.com");
  }

  @Test
  void shouldFindUserByEmail() {
    User user =
        User.builder()
            .email(TEST_EMAIL)
            .password("password")
            .firstname("Jane")
            .lastname("Doe")
            .role(Role.USER)
            .build();

    userRepository.save(user);

    User foundUser = userRepository.findByEmail(TEST_EMAIL).orElse(null);

    assertThat(foundUser).isNotNull();
    assertThat(foundUser.getEmail()).isEqualTo(TEST_EMAIL);
  }
}
