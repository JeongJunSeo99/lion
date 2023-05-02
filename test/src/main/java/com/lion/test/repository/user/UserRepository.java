package com.lion.test.repository.user;

import com.lion.test.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
    //Optional<User> findByUserId(String userId); 회원 중복 체크 하는 기능을 위한 userId로 사용자 찾기
}
