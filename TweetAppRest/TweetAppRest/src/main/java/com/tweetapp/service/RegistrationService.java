package com.tweetapp.service;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tweetapp.entity.ExceptionResponse;
import com.tweetapp.entity.ResponseForSuccess;
import com.tweetapp.entity.UserRegistration;
import com.tweetapp.exception.UserExistException;
import com.tweetapp.exception.UserListEmptyException;
import com.tweetapp.exception.UserNotFoundException;
import com.tweetapp.repository.UserRegistrationRepository;


@Service
public class RegistrationService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserRegistrationRepository userRegistrationRepository;
		public ResponseEntity<?> saveUserRegistration(UserRegistration registration) throws UserExistException {
			logger.info("Entered into save user method");
			UserRegistration user=userRegistrationRepository.findByLoginIdAndEmail(registration.loginId, registration.email);
			boolean existingUser=user==null?true:false;
			logger.info("Checking UserAlready Exist"+existingUser);
			if(!existingUser) {
				throw new UserExistException("LoginId and EmailId already Exist");
				}
			else {
				userRegistrationRepository.save(registration);
				return new ResponseEntity<>(new ResponseForSuccess("Registered Successfully"),
						HttpStatus.OK);
				
			}
			
		
		 
		
	}
		public UserRegistration getUser(String username) throws UserNotFoundException {
			logger.info("Enter into get user method");
			return userRegistrationRepository.findByLoginId(username);
		}
			public List<UserRegistration> getAllUser() throws UserListEmptyException{
				logger.info("Enter into get user method");
				return userRegistrationRepository.findAll();
			}
			
			public String updatePassword(String loginId,String oldPassword,String newPassword) throws Exception {
				logger.info("Enter into update password method");
				boolean valid=userRegistrationRepository.existsByLoginIdAndPassword(loginId,oldPassword);
				if(valid) {
					UserRegistration user=userRegistrationRepository.findByLoginId(loginId);
					user.setPassword(newPassword);
					userRegistrationRepository.save(user);
				}
				else {
					throw new Exception("Old password incorrect");
				}
				return "updated";
			}
			public String forgetPassword(String loginId,String newPassword) throws Exception {
				logger.info("Enter into forget password method");
				boolean valid=userRegistrationRepository.existsByLoginId(loginId);
				if(valid) {
					UserRegistration user=userRegistrationRepository.findByLoginId(loginId);
					user.setPassword(newPassword);
					userRegistrationRepository.save(user);
				}
				else {
					throw new Exception("incorrect loginId");
				}
				return "updated";
			}

}
