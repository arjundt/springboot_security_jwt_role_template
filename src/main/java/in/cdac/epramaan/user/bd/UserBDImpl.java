package in.cdac.epramaan.user.bd;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.cdac.epramaan.common.model.Response;
import in.cdac.epramaan.master.model.UserAccountStatusMaster;
import in.cdac.epramaan.user.model.User;
import in.cdac.epramaan.user.model.UserResponse;
import in.cdac.epramaan.user.model.UserStatusCode;
import in.cdac.epramaan.user.repository.UserRepository;
import in.cdac.epramaan.util.EpFieldError;
import in.cdac.epramaan.util.EpSystemError;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserBDImpl implements UserBD {
    
    private final PasswordEncoder passwordEncoder;     
    private final UserRepository userRepository;
//    private final ConfigParaBD masterConfigBD;
    
    private User setUserDefaultFields(User user) {
    	user.setUpdateBy(user.getUsername());
    	
    	UserAccountStatusMaster userAccountStatusMaster = new UserAccountStatusMaster();
		userAccountStatusMaster.setStatusCode(UserStatusCode.ACTIVATED
				.getStatusCode());
		user.setUserAccountStatusMaster(userAccountStatusMaster);
		
		LocalDateTime localDateTime = LocalDateTime.now();
    	Timestamp timestamp = Timestamp.valueOf(localDateTime);
    	user.setRegistrationTimestamp(timestamp);
    	user.setUpdateTimestamp(timestamp);

    	return user;
    }
 
    @Override
    public UserResponse addUser(User user) {
    	UserResponse userResponse = new UserResponse();
    	User tempUser;
    	
    	user = setUserDefaultFields(user);
    	
    	log.debug("User to insert: "+ user);
    	
    	try {
    		tempUser = userRepository.save(user);
    		userResponse.setUser(tempUser);
    		userResponse.setResponse(new Response(true, null));
        } catch (DataIntegrityViolationException e) {
            log.info("Handle data integrity violation exception");
            userResponse.setResponse(new Response(false,EpSystemError.DB_EXCEPTION));
        } catch (ConstraintViolationException e) {
        	log.info("handle constraint violation exception");
        	userResponse.setResponse(new Response(false,EpSystemError.DB_EXCEPTION));
        } catch (OptimisticLockingFailureException e) {
        	log.info("handle optimistic locking failure exception");
        	userResponse.setResponse(new Response(false,EpSystemError.DB_EXCEPTION));
        } catch (Exception e) {
        	log.info("handle other exceptions");
        	userResponse.setResponse(new Response(false,EpSystemError.DB_EXCEPTION));
        }
//       return userDAO.addUser(user);
    	return userResponse;
    }
 
    @Override
    public User getUser(Integer userId) {
    	User user = null;
    	try {
    		user = userRepository.findById(userId).orElse(null);
		} catch (DataIntegrityViolationException e) {
            log.info("Handle data integrity violation exception");
        } catch (ConstraintViolationException e) {
        	log.info("handle constraint violation exception");
        } catch (OptimisticLockingFailureException e) {
        	log.info("handle optimistic locking failure exception");
        } catch (Exception e) {
        	log.info("handle other exceptions");
        }
        //return userDAO.getUser(userId);
    	return user;
    }
 
    @Override
    public User getUserByUserName(String username)  {
    	User user = null;
    	try {
    		user = userRepository.findByUsername(username)
    				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		} catch (DataIntegrityViolationException e) {
            log.info("Handle data integrity violation exception");
        } catch (ConstraintViolationException e) {
        	log.info("handle constraint violation exception");
        } catch (OptimisticLockingFailureException e) {
        	log.info("handle optimistic locking failure exception");
        } catch (Exception e) {
        	log.info("handle other exceptions");
        }
    	
//        return userDAO.getUserByUserName(username);
    	return user;
    }
 
    @Override
    public UserResponse updateUser(User user)  {
    	UserResponse userResponse = new UserResponse();
    	User tempUser;
    	try {
    		tempUser = userRepository.save(user);
    		userResponse.setUser(tempUser);
    		userResponse.setResponse(new Response(true, null));
        } catch (DataIntegrityViolationException e) {
            log.info("Handle data integrity violation exception");
            userResponse.setResponse(new Response(false,EpSystemError.DB_EXCEPTION));
        } catch (ConstraintViolationException e) {
        	log.info("handle constraint violation exception");
        	userResponse.setResponse(new Response(false,EpSystemError.DB_EXCEPTION));
        } catch (OptimisticLockingFailureException e) {
        	log.info("handle optimistic locking failure exception");
        	userResponse.setResponse(new Response(false,EpSystemError.DB_EXCEPTION));
        } catch (Exception e) {
        	log.info("handle other exceptions");
        	userResponse.setResponse(new Response(false,EpSystemError.DB_EXCEPTION));
        }
    	//return userDAO.updateUser(user);
    	return userResponse;
    }
 
    @Override
    public void deleteUser(Integer userId)  {
    	userRepository.deleteById(userId);
//        userDAO.deleteUser(userId);
    }
 
    @Override
    public List<User> getUsers() {
    	return userRepository.findAll();
//        return userDAO.getUsers();
    }

    @Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		try {
			log.debug("Fetching user details.");
            return getUserByUserName(username);
        } catch (EmptyResultDataAccessException e) {
        	log.debug(e.getMessage());
        	return null;
        }
	}
    
	@Override
	public UserResponse authenticateUser(User user) {
		Response response;
		UserResponse userResponse = new UserResponse();
        User checkUser = null;
        String rawPassword = user.getPassword();
        try {
            if (user.getUsername() != null) {
            	System.out.println("Getting user by user name");
                checkUser = userRepository.findByUsername(user.getUsername()).orElse(null);
            } else {
            	System.out.println("Returning error to use any one either user name or adhaar number");
                userResponse.setResponse(new Response(false,
                        EpFieldError.USERNAME_NOT_AVAILABLE));
                return userResponse;
            }
            log.debug("Fetched user by user name, getting user from user response.");
        } catch (Exception e) {
            log.error(e.getMessage());
            response = new Response(false, EpSystemError.SYSTEM_INTERNAL_ERROR);
            userResponse = new UserResponse(checkUser, response);
            return userResponse;
        }

       if (checkUser!=null) {
            log.debug("Check user's account status");
           
                log.debug("User's account status is active");
                if (passwordEncoder.matches(rawPassword, checkUser.getPassword())) {
                	System.out.println("Password Matched");
                //	adminResponse = processAuthenticateSuccess(checkUser);
                 //   response = userResponse.getResponse();
                	userResponse = new UserResponse(checkUser, new Response(true, null));

                } else {
                	System.out.println("Password not matching");
                	//adminResponse = processAuthenticateFailure(checkUser);
                    //response = adminResponse.getResponse();
                	userResponse = new UserResponse(checkUser, new Response(false, EpSystemError.INVALID_USER));
                }
           
                //adminResponse.setResponse(response);
        }
        return userResponse;
	}
	
}