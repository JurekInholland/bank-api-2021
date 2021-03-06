package io.swagger.util;

import io.swagger.model.Role;
import io.swagger.security.services.UserDetailsImpl;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;

// Helper class to quickly access current user info
public class CurrentUserInfo {


    public static Boolean isEmployee() {
        if (CurrentUserInfo.getCurrentUserRoles().contains(Role.EMPLOYEE)) {
            return true;
        }
        return false;
    }

    public static ArrayList<Role> getCurrentUserRoles() {
        UserDetailsImpl userDetails = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        ArrayList<Role> roles = new ArrayList<>();


        userDetails.getAuthorities().forEach(auth -> {
            roles.add(Role.valueOf(auth.getAuthority().replace("ROLE_","")));
        });
        return roles;
    }

    public static String getCurrentUserName() {
        UserDetailsImpl userDetails = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUsername();
    }

    public static String getCurrentUserEmail() {
        UserDetailsImpl userDetails = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getEmail();
    }

    public static Long getCurrentUserId() {
        UserDetailsImpl userDetails = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getId();
    }

    public static UserDetailsImpl getCurrentUserDetails() {
        UserDetailsImpl userDetails = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails;
    }
}
