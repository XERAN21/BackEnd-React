package com.asagao.Controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.asagao.Domain.Notice;
import com.asagao.Domain.User;
import com.asagao.Service.Interface.NoticeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notices")
@RequiredArgsConstructor
public class noticeController {
	private final NoticeService noticeService;
	
	@GetMapping
	public Notice[] getNotices(HttpSession session) {
		User user = (User)session.getAttribute("user");
	      if (user == null) {
	          throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication required");
	      }
	      
	      Notice[] notices = noticeService.getNotices();
	      
	      
	      for (Notice notice : notices) {
			System.out.println(notice);
		}
	      
	      return notices;
	}
}
