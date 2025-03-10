package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.dto.DefaultDto;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/user")
@RestController
public class UserRestController {
    private final UserService userService;
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<DefaultDto.CreateResDto> login(@RequestBody UserDto.LoginReqDto param) {
        return ResponseEntity.ok(userService.login(param));
    }

    @PostMapping("/signup")
    public ResponseEntity<DefaultDto.CreateResDto> signup(@RequestBody UserDto.CreateReqDto param) {
        return ResponseEntity.ok(userService.signup(param));
    }

    @GetMapping("/check")
    public boolean check(@RequestParam String username) {
        return userService.check(username);
    }

    /**/

    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody UserDto.CreateReqDto param) {
        return ResponseEntity.ok(userService.create(param));
    }

    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody UserDto.UpdateReqDto param) {
        userService.update(param);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody UserDto.UpdateReqDto param){
        userService.delete(param.getId());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/list")
    public ResponseEntity<Void> deletes(@RequestBody DefaultDto.DeletesReqDto param){
        userService.deletes(param);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<UserDto.DetailResDto> detail(@RequestParam Long id) {
        return ResponseEntity.ok(userService.detail(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDto.DetailResDto>> list(UserDto.ListReqDto param) {
        return ResponseEntity.ok(userService.list(param));
    }

    @GetMapping("/plist")
    public ResponseEntity<DefaultDto.PagedListResDto> plist(UserDto.PagedListReqDto param) {
        return ResponseEntity.ok(userService.pagedList(param));
    }

    @GetMapping("/mlist")
    public ResponseEntity<List<UserDto.DetailResDto>> mlist(UserDto.ScrollListReqDto param) {
        return ResponseEntity.ok(userService.scrollList(param));
    }
}
