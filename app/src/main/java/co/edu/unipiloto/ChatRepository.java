package co.edu.unipiloto;

import java.util.ArrayList;
import java.util.List;

public class ChatRepository {
    private static ChatRepository instance;
    private List<ChatMessage> messages;

    private ChatRepository() {
        messages = new ArrayList<>();
    }

    public static ChatRepository getInstance() {
        if (instance == null) {
            instance = new ChatRepository();
        }
        return instance;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void addMessage(ChatMessage message) {
        messages.add(message);
    }
}

