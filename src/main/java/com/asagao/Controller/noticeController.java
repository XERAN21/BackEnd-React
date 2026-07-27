package com.asagao.Controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.asagao.Domain.Notice;
import com.asagao.Domain.NoticeRead;
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
	      
	      return notices;
	}
	
	@GetMapping("{id}")
	public Notice getDetail(@PathVariable int id,HttpSession session) {
		User user = (User)session.getAttribute("user");
	      if (user == null) {
	          throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication required");
	      }
	      return noticeService.getNoticeDetails(id);
	}
	
	@GetMapping("/read/{userId}")
	public NoticeRead[] getUnreadNotices(@PathVariable int userId, HttpSession session) {
		User user = (User)session.getAttribute("user");
		if (user == null) {
	          throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication required");
	      }
		
		NoticeRead[] reads = noticeService.getUnreadNotices(userId);
		
		for (NoticeRead noticeRead : reads) {
			System.out.println("Read Message");
			System.out.println(noticeRead);
		}
		
		return noticeService.getUnreadNotices(userId);
	}
	
	@PostMapping("/read/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void MarkAsRead(@PathVariable int id, HttpSession session) {
		User user = (User)session.getAttribute("user");
		if (user == null) {
	          throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication required");
	      }
		
		noticeService.MarkasRead(id, user.getId());
	}
	
}
