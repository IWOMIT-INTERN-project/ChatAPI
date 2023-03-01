package com.russ.chatAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.russ.chatAPI.service.ChatService;
import com.russ.chatAPI.service.UserService;
import com.russ.chatAPI.users.Message;
import com.russ.chatAPI.users.User;

@RestController
public class Controller {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ChatService chatService;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
	
	   @PostMapping("/createUser")
	    public User createUser(@RequestBody User user) {
	        return userService.saveUser(user);
	    }
	   
	   @PostMapping("/sendMessage")
	   public void sendMessage(@RequestParam String senderName,@RequestParam String recipientName,@RequestBody String content) {
		   chatService.sendMessage(senderName, recipientName, content);   
	   }
	   
	   @GetMapping("/getMessage")
	   public List<String> getMessage(@RequestParam String userName) {
		   return chatService.getMessagesByReceiver(userName);
	   }
	   
	   @GetMapping("/ getMessageById")
	   public Message getMessageById(@RequestParam String userName, @RequestParam Long id) {
		   return chatService.getMessageById(userName, id);
	   }
}
