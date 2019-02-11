package com.example.demo.websocket;

import com.example.demo.config.MyEndpointConfigure;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/websocket", configurator = MyEndpointConfigure.class)
@Component
public class WebSocketChat {
    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session){
        System.out.println("有新连接加入！当前在线人数为");
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
        System.out.println("有一连接关闭！当前在线人数为");
    }

    @OnMessage
    public void onMessage(String message, Session session) throws Exception {
        System.out.println(message);
        session.getBasicRemote().sendText("后台说您刚刚发送了：" + message);
    }

    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }
}
