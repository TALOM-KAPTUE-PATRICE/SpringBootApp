package com.PremierPSpring.PremierPSpring.restimpl;


import com.PremierPSpring.PremierPSpring.constents.CafeContans;
import com.PremierPSpring.PremierPSpring.rest.UserRest;
import com.PremierPSpring.PremierPSpring.service.UserService;
import com.PremierPSpring.PremierPSpring.utils.CafeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class UserRestImpl implements UserRest {

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<String> SignUp(Map<String, String> requestMap) {
      try {
         return userService.signUp(requestMap);
      }catch(Exception ex){
          ex.printStackTrace();
      }

      return CafeUtils.getResponseEntity(CafeContans.SOMERHINGS_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);


    }
}
