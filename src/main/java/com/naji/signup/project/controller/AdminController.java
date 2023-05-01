package com.naji.signup.project.controller;

import com.naji.signup.project.dto.major.MajorDto;
import com.naji.signup.project.dto.user.UserResponseDto;
import com.naji.signup.project.dto.user.UserSearchDto;
import com.naji.signup.project.resource.AdminResources;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminResources adminResources;

    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping("/dashboard")
    public ModelAndView getDashboardPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dashboard");

        modelAndView.addObject("countActive", adminResources.getCountActiveAcount().getBody());
        modelAndView.addObject("countActive", adminResources.getCountActiveAcount().getBody());

        modelAndView.addObject("countActive", adminResources.getCountActiveAcount().getBody());
        modelAndView.addObject("countPending", adminResources.getCountPendingAcount().getBody());
        modelAndView.addObject("countReject", adminResources.getCountRejectAcount().getBody());
        modelAndView.addObject("countStudent", adminResources.getCountStudent().getBody());
        modelAndView.addObject("countTeacher", adminResources.getCountTeacher().getBody());
        modelAndView.addObject("countAdmin", adminResources.getCountAdmin().getBody());
        modelAndView.addObject("countMajor", adminResources.getCountmajors().getBody());
        modelAndView.addObject("countUser", adminResources.getCountUser().getBody());
        modelAndView.addObject("pendingList", adminResources.getListPendingAcount().getBody());
        return modelAndView;
    }


    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping("/show-student")
    public ModelAndView getStudentList() {
        ModelAndView modelAndView = new ModelAndView("studentList");
        List<UserResponseDto> body = adminResources.getListStudent().getBody();
        modelAndView.addObject("studentList", body);
        return modelAndView;

    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping("/show-teacher")
    public ModelAndView getTeacherList() {
        ModelAndView modelAndView = new ModelAndView("teacherList");
        List<UserResponseDto> body = adminResources.getListTeacher().getBody();
        modelAndView.addObject("teacherList", body);
        return modelAndView;
    }

    @GetMapping("/show-admin")
    public ModelAndView getAdminList() {
        ModelAndView modelAndView = new ModelAndView("adminList");
        List<UserResponseDto> body = adminResources.getListAdmin().getBody();
        modelAndView.addObject("adminList", body);
        return modelAndView;
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping("/show-users")
    public ModelAndView getUsersList() {
        ModelAndView modelAndView = new ModelAndView("usersList");
        List<UserResponseDto> body = adminResources.getListusers().getBody();
        modelAndView.addObject("usersList", body);
        return modelAndView;
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping("/show-active")
    public ModelAndView getactiveList() {
        ModelAndView modelAndView = new ModelAndView("activeList");
        List<UserResponseDto> body = adminResources.getListActiveAcount().getBody();
        modelAndView.addObject("activeList", body);
        return modelAndView;
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping("/show-pending")
    public ModelAndView getpendingList() {
        ModelAndView modelAndView = new ModelAndView("pendingList");
        List<UserResponseDto> body = adminResources.getListPendingAcount().getBody();
        modelAndView.addObject("pendingList", body);
        return modelAndView;
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping("/show-reject")
    public ModelAndView getRejectList() {
        ModelAndView modelAndView = new ModelAndView("rejectList");
        List<UserResponseDto> body = adminResources.getListRejectAcount().getBody();
        modelAndView.addObject("rejectList", body);
        return modelAndView;
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping("/show-majors")
    public ModelAndView getmajorsList() {
        ModelAndView modelAndView = new ModelAndView("majorList");
        List<MajorDto> body = adminResources.getListMajors().getBody();
        modelAndView.addObject("majorsList", body);
        return modelAndView;
    }


    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping("/search-users")
    public ModelAndView getSearchItemList(@RequestBody(required = false) UserSearchDto userSearchDto) {
        ModelAndView modelAndView = new ModelAndView("searchItemList");
        if (userSearchDto != null) {
            List<UserResponseDto> body = adminResources.getadvanceSearchUser(userSearchDto).getBody();

            modelAndView.addObject("seaerchList", body);
        }
        return modelAndView;
    }


}