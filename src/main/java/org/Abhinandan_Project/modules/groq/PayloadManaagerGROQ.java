package org.Abhinandan_Project.modules.groq;

import com.google.gson.Gson;
import org.Abhinandan_Project.pojos.groq.Request.ChatRequest;
import org.Abhinandan_Project.pojos.groq.Request.Message;
import org.Abhinandan_Project.pojos.groq.Response.ChatCompletionResponse;

import java.util.Collections;

public class PayloadManaagerGROQ {
    static Gson gson;

    public void buildRequest() {
        ChatRequest chatRequest = new ChatRequest();
        chatRequest.setModel("openai/gpt-oss-120b");
        Message message = new Message("user", "Explain the POJO");
        chatRequest.setMessages(Collections.singletonList(message));
    }

    public String setBuildRequest() {
        gson = new Gson();
        ChatRequest chatRequest = new ChatRequest();
        chatRequest.setModel("openai/gpt-oss-120b");
        Message message = new Message("user", "Explain the POJO");
        chatRequest.setMessages(Collections.singletonList(message));
        return gson.toJson(chatRequest);
    }

    public static ChatCompletionResponse parseResponse(String jsonResponse) {
        gson = new Gson();
        return gson.fromJson(jsonResponse, ChatCompletionResponse.class);
    }
}
