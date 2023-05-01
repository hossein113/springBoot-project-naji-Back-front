package com.naji.signup.project.resource;

import com.naji.signup.project.Enuneration.Role;
import com.naji.signup.project.Enuneration.Status;
import com.naji.signup.project.dto.major.MajorDto;
import com.naji.signup.project.dto.user.UserResponseDto;
import com.naji.signup.project.dto.user.UserSearchDto;
import com.naji.signup.project.service.MajorService;
import com.naji.signup.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminResources {

    private final UserService userService;
    private final MajorService majorService;

    @GetMapping("/count-user")
    public ResponseEntity<Long> getCountUser() {
        return ResponseEntity.ok(userService.count());
    }

    @GetMapping("/count-student")
    public ResponseEntity<Long> getCountStudent() {
        return ResponseEntity.ok(userService.countUserByRole(Role.STUDENT));
    }

    @GetMapping("/count-teacher")

    public ResponseEntity<Long> getCountTeacher() {
        return ResponseEntity.ok(userService.countUserByRole(Role.TEACHER));

    }

    @GetMapping("/count-admin")

    public ResponseEntity<Long> getCountAdmin() {
        return ResponseEntity.ok(userService.countUserByRole(Role.ADMIN));

    }

    @GetMapping("/count-active-account")

    public ResponseEntity<Long> getCountActiveAcount() {
        return ResponseEntity.ok(userService.countUserByStatus(Status.ACTIVE));

    }

    @GetMapping("/count-pending-account")

    public ResponseEntity<Long> getCountPendingAcount() {
        return ResponseEntity.ok(userService.countUserByStatus(Status.PENDING));

    }

    @GetMapping("/count-reject-account")

    public ResponseEntity<Long> getCountRejectAcount() {
        return ResponseEntity.ok(userService.countUserByStatus(Status.REJECTION));

    }

    @GetMapping("/show-users")

    public ResponseEntity<List<UserResponseDto>> getListusers() {
        return ResponseEntity.ok(userService.findAllResponse());
    }


    @GetMapping("/show-teacher")

    public ResponseEntity<List<UserResponseDto>> getListTeacher() {
        return ResponseEntity.ok(userService.findAllByRole(Role.TEACHER));

    }

    @GetMapping("/show-student")

    public ResponseEntity<List<UserResponseDto>> getListStudent() {
        return ResponseEntity.ok(userService.findAllByRole(Role.STUDENT));

    }

    @GetMapping("/show-active-account")

    public ResponseEntity<List<UserResponseDto>> getListActiveAcount() {
        return ResponseEntity.ok(userService.findAllByStatus(Status.ACTIVE));

    }

    @GetMapping("/show-pending-account")

    public ResponseEntity<List<UserResponseDto>> getListPendingAcount() {
        return ResponseEntity.ok(userService.findAllByStatus(Status.PENDING));

    }

    @GetMapping("/show-reject-account")

    public ResponseEntity<List<UserResponseDto>> getListRejectAcount() {
        return ResponseEntity.ok(userService.findAllByStatus(Status.REJECTION));

    }


    @GetMapping("/show-admin")

    public ResponseEntity<List<UserResponseDto>> getListAdmin() {
        return ResponseEntity.ok(userService.findAllByRole(Role.ADMIN));

    }


    @GetMapping("/count-majors")

    public ResponseEntity<Long> getCountmajors() {
        return ResponseEntity.ok(majorService.count());

    }

    @GetMapping("/show-majors")

    public ResponseEntity<List<MajorDto>> getListMajors() {
        return ResponseEntity.ok(majorService.findAll());

    }

    @RequestMapping("/active-status")
    public ResponseEntity getActiveStatuse(@RequestParam Long id) {

        return ResponseEntity.ok(userService.activeStatus(id));
    }

    @RequestMapping("/change-status")
    public ResponseEntity getChangeStatuse(@RequestParam Long id, @RequestParam Role role) {

        return ResponseEntity.ok(userService.changeStatusUser(id, role));
    }

    @RequestMapping("/reject-status")
    public ResponseEntity getRejectStatuse(@RequestParam Long id) {

        return ResponseEntity.ok(userService.rejectStatus(id));
    }

    @RequestMapping("/advance-search")

    public ResponseEntity<List<UserResponseDto>> getadvanceSearchUser(@RequestBody UserSearchDto userSearchDto) {
        userSearchDto.setPageNumber(0);
        userSearchDto.setPageSize(100);
        userSearchDto.setSortBy("id");
        return ResponseEntity.ok(userService.AllByAdvanceSearch(userSearchDto));
    }
}
