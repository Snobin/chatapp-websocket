package com.example.demo.User;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserDto {
	@NotEmpty
	private String nickName;
	private Status status;
	@NotEmpty
	private String fullName;
}
