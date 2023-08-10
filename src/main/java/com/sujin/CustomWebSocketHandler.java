package com.sujin;

import java.util.LinkedHashSet;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomWebSocketHandle extends TextWebSocketHandler {
	
	private static LinkHashSet<WebSocketSession> numSet = new LinkedHashSet<>();
	
}
