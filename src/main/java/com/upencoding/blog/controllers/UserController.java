package com.upencoding.blog.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upencoding.blog.payloads.ApiResponse;
import com.upencoding.blog.payloads.UserDto;
import com.upencoding.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	//POST-create-user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto  userDto){
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	
	//PUT-Update-user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto>updateUser(@RequestBody UserDto userDto,@PathVariable Integer userId){
		UserDto updateUser = this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updateUser);
	}
	
	//DELETE-delete-user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse>deleteUser(@PathVariable Integer userId){
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
	}
	//GET- user-get
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUsers(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
}
