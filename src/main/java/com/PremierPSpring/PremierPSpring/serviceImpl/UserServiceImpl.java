package com.PremierPSpring.PremierPSpring.serviceImpl;

import com.PremierPSpring.PremierPSpring.POjO.User;
import com.PremierPSpring.PremierPSpring.constents.CafeContans;
import com.PremierPSpring.PremierPSpring.dao.UserDao;
import com.PremierPSpring.PremierPSpring.service.UserService;
import com.PremierPSpring.PremierPSpring.utils.CafeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Inside signup{}",requestMap);

    try {

        if(validateSignUpMap(requestMap)){
              User user=  userDao.findByEmailId(requestMap.get("email"));
              if(Objects.isNull(user)){
                  userDao.save(getUserFormMap(requestMap));
                  return CafeUtils.getResponseEntity("SuccesFully Registered",HttpStatus.OK);
              }else{
                  return CafeUtils.getResponseEntity("Email already exists.",HttpStatus.BAD_REQUEST);
              }
        }else{
            return CafeUtils.getResponseEntity(CafeContans.INVALID_DATA, HttpStatus.BAD_REQUEST);
        }
    }catch (Exception ex){
        ex.printStackTrace();
    }

       return CafeUtils.getResponseEntity(CafeContans.SOMERHINGS_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    private boolean validateSignUpMap(Map<String, String> requestMap) {
       if(requestMap.containsKey("name") && requestMap.containsKey("contactNumber")
                && requestMap.containsKey("email") && requestMap.containsKey("password"))
       {
           return  true;
       }

       return false;
    }

    private User getUserFormMap(Map<String, String> requestMap) {
        User user = new User();
        user.setName(requestMap.get("name"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setStatus(requestMap.get("status"));
        user.setRole(requestMap.get("role"));
        return user;
    }
}
