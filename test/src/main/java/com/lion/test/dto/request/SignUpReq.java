package com.lion.test.dto.request;

import lombok.Getter;

@Getter
public class SignUpReq {
    private String nickname;
    private String userId;
    private String password;
    //회원가입 시 필요한 데이터 추가하셈
}
