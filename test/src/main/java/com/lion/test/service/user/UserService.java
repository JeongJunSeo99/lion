package com.lion.test.service.user;

import com.lion.test.domain.user.User;
import com.lion.test.dto.request.SignUpReq;
import com.lion.test.dto.request.UserCreateRequest;
import com.lion.test.dto.request.UserUpdateRequest;
import com.lion.test.dto.response.UserResponse;
import com.lion.test.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.nio.channels.IllegalChannelGroupException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository; //레포지토리 연결 컨트롤러 -> 서비스 -> 레포지토리
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void saveUser(UserCreateRequest request){
        userRepository.save(new User(request.getName(), request.getAge()));
    }

    public void deleteUser(String name){
        User user = userRepository.findByName(name)
                .orElseThrow(IllegalChannelGroupException::new);
        userRepository.delete(user);
    }

    public List<UserResponse> getUsers(){
        /*
        return userRepository.findAll().stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getAge()))
                .collect(Collectors.toList());
         */
        return userRepository.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    public void updateUsers(UserUpdateRequest request){
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalChannelGroupException::new);
        user.setName(request.getName());
        if(request.getAge() != null)
            user.setAge(request.getAge());
        userRepository.save(user);
    }

/*  회원 중복 체크 후 저장
    public void signUp(SignUpReq request){
        User user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(IllegalChannelGroupException::new);
        if(user != null){
        }
        else{
            userRepository.save(user);
        }
    }
    
 */

}
