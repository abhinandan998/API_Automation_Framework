package org.Abhinandan_Project.pojos.groq.Response;

public class Choice {
    private int index;
    private AssistantMessage message;
    private String finish_reason;

    public int getIndex() {
        return index;
    }

    public AssistantMessage getMessage() {
        return message;
    }

    public String getFinish_reason() {
        return finish_reason;

    }
}
