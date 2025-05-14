package com.kunfeng2002.springsecurity.control;

import com.kunfeng2002.springsecurity.data.InforUser;
import com.kunfeng2002.springsecurity.model.Infor;
import com.kunfeng2002.springsecurity.model.User;
import com.kunfeng2002.springsecurity.repo.UserRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControl {

    private final InforUser inforUser = new InforUser();
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/information")
    public List<Infor> getAllInfor() {
        return inforUser.getInfors();
    }

    @GetMapping("/csrftoken")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
