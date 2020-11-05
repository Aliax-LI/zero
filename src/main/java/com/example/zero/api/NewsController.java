package com.example.zero.api;

import cn.hutool.json.JSONObject;
import com.example.zero.service.SseEmitterServer;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/sse")
public class NewsController {

    /**
     * 用于创建连接
     */
    @GetMapping("/connect/{userId}")
    public SseEmitter connect(@PathVariable String userId) {
        return SseEmitterServer.connect(userId);
    }

    /**
     * 推送给所有人
     *
     * @param message
     * @return
     */
    @GetMapping("/push/{message}")
    public ResponseEntity<String> push(@PathVariable(name = "message") String message) {
        SseEmitterServer.batchSendMessage(message);
        return ResponseEntity.ok("WebSocket 推送消息给所有人");
    }

    /**
     * 发送给单个人
     *
     * @param message
     * @param userid
     * @return
     */
    @GetMapping("/push_one/{messsage}/{userid}")
    public ResponseEntity<String> pushOne(@PathVariable(name = "message") String message, @PathVariable(name = "userid") String userid) {
        SseEmitterServer.sendMessage(userid, message);
        return ResponseEntity.ok("WebSocket 推送消息给" + userid);
    }

    /**
     * 关闭连接
     */
    @GetMapping("/close/{userid}")
    public ResponseEntity<String> close(@PathVariable("userid") String userid) {
        SseEmitterServer.removeUser(userid);
        return ResponseEntity.ok("连接关闭");
    }

}
