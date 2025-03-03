package co.edu.unipiloto;

public class ChatMessage {
    private String sender;    // "Propietario" o "Cuidador"
    private String message;
    private long timestamp;

    public ChatMessage(String sender, String message, long timestamp) {
        this.sender = sender;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getSender() { return sender; }
    public String getMessage() { return message; }
    public long getTimestamp() { return timestamp; }
}

