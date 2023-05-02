package com.lion.test.controller.user;

import com.lion.test.dto.request.SignUpReq;
import com.lion.test.dto.request.UserCreateRequest;
import com.lion.test.dto.request.UserUpdateRequest;
import com.lion.test.dto.response.UserResponse;
import com.lion.test.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService; //서비스랑 연결 컨트롤러 -> 서비스 -> 레포지토리
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request){
        userService.saveUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){
        userService.deleteUser(name);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){
        userService.updateUsers(request);
    }
    
/*  회원가입 서비스임 userId, password, nickname 등 받고 userId 중복 체크 후 DB에 저장
    @PostMapping("/sign_up")
    public void saveUser(@RequestBody SignUpReq request){
        userService.signUp(request);
    }
 */
    
}
