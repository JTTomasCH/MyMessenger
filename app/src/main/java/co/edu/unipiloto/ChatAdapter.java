package co.edu.unipiloto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
    private List<ChatMessage> chatMessages;

    public ChatAdapter(List<ChatMessage> messages) {
        this.chatMessages = messages;
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chat, parent, false);
        return new ChatViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {
        ChatMessage message = chatMessages.get(position);
        holder.tvSender.setText(message.getSender());
        holder.tvMessage.setText(message.getMessage());
        String date = new SimpleDateFormat("HH:mm", Locale.getDefault())
                .format(new Date(message.getTimestamp()));
        holder.tvTimestamp.setText(date);
    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    public static class ChatViewHolder extends RecyclerView.ViewHolder {
        public TextView tvSender, tvMessage, tvTimestamp;
        public ChatViewHolder(View view) {
            super(view);
            tvSender = view.findViewById(R.id.tvSender);
            tvMessage = view.findViewById(R.id.tvMessage);
            tvTimestamp = view.findViewById(R.id.tvTimestamp);
        }
    }
}

