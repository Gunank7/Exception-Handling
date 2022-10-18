package com.exceptionhandling.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

	@NotNull(message = "username shouldn't be null")
	private String name;
	@Email(message ="Invalid email address")
	private String email;
	@NotNull
	@Pattern(regexp = "^\\d{10}$", message = "Invalid Mobile number entered")
	private String mobile;
	private String gender;
	@Min(18)
	@Max(60)
	private int age;
	@NotBlank(message = "nationatily in not empty")
	@NotNull(message = "not null")
	private String nationality;
}
