package com.study.springboot202210younggyu.web.controller;

import com.study.springboot202210younggyu.web.dto.CMRespDto;
import com.study.springboot202210younggyu.web.dto.UserDto;
import com.study.springboot202210younggyu.web.exception.CustomTestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RestController1 {

    @GetMapping("/api/test/user-dto/str")
    public String getUserDtoStr(){
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        return userDto.toString();
    }
    @GetMapping("/api/test/user-dto/obj")
//    public UserDto getUserDtoObj(HttpServletResponse response){             // return타입이 UserDto 그래서 return userDto인 것
                                                                            // return 타입에 Object 사용가능
                                //HttpServletResponse response 이걸 ResponseEntity<>로 바꾸는 것
      public ResponseEntity<?> getUserDtoObj(){
            UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.set("UserDto", userDto.toString());
                    // ↑ body
//        return new ResponseEntity<>(headers, HttpStatus.OK); ↓밑이랑 같음
        return ResponseEntity.ok()
                .headers(headers)
                .body(userDto);
                            // ok()는 status 코드  ok()대신 badRequest 가 들어갈 수도 있다
        //        return new ResponseEntity<>(userDto, HttpStatus.INTERNAL_SERVER_ERROR);
        //        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(userDto); ↑랑 같음



        // HttpStatus.BAD_REQUEST 400번 오류
        // HttpStatus.INTERNAL_SERVER_ERROR 500번 오류
        // GENERIC 와일드카드가 있다 => <?> OBJECT랑 같은 것
        // <?>가 오면 return 값에 <>("" <-여기자리엘 문자열이든 뭐든 다 됨, );
    }

        @GetMapping("/api/test/user-dto/cm")
        public ResponseEntity<?> getUserDto(){
            UserDto userDto = UserDto.builder()
                    .username("test")
                    .password("1234")
                    .build();
            return ResponseEntity.ok().body(new CMRespDto<>("test유저 정보 응답", userDto));
                                                // ↑얘는 공통응답객체                       userDto자리에 null 들어가면 postman에 data부분 null 표시반영
        }

        @PostMapping("/api/test/user")
        public ResponseEntity<?> addUser(@RequestBody UserDto userDto){

            if(userDto.getUsername().isBlank()){
                Map<String, String> errorMap = new HashMap<>();
                errorMap.put("username", "아이디를 입력하세요");
                errorMap.put("password", "비밀번호를 입력하세요");
                errorMap.put("qqq", "아이디를 입력하세요");


                throw new CustomTestException("유효성 검사 실패", errorMap);
            }

            userDto.setUserId(100);

            return ResponseEntity.created(null)
                    .body(new CMRespDto<>(userDto.getUserId() + "사용자 추가 성공!", userDto));

        }
}
