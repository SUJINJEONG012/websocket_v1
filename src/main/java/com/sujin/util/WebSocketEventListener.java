package com.sujin.util;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.sujin.model.ChatMessage;
import com.sujin.model.MessageType;

public class WebSocketEventListener {
	
	private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);
	
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
	@EventListener
	public void handleWebSocketConnectListener(SessionConnectedEvent event) {
		logger.info("Received a new web Socket Connection");
	}
	
	@EventListener
	public void handleWebSocketDisconnectionListener(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		String username= (String) headerAccessor.getSessionAttributes().get("username");
		if(username != null) {
			logger.info("User Disconnected : " + username);
			
			ChatMessage chatMessage = new ChatMessage();
			
			chatMessage.setType(MessageType.LEAVE);
			chatMessage.setSender(username);
			messagingTemplate.convertAndSend("/topic/public",chatMessage);
			
			
		}
	}
	
	
}
 