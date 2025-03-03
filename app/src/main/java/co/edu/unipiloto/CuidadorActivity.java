package co.edu.unipiloto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CuidadorActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;
    private EditText etMessage;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuidador);

        recyclerView = findViewById(R.id.recyclerView);
        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btnSend);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        chatAdapter = new ChatAdapter(ChatRepository.getInstance().getMessages());
        recyclerView.setAdapter(chatAdapter);

        btnSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String msg = etMessage.getText().toString().trim();
                if(!msg.isEmpty()){
                    // Estableciendo como remitente "Cuidador"
                    ChatMessage chatMessage = new ChatMessage("Cuidador", msg, System.currentTimeMillis());
                    ChatRepository.getInstance().addMessage(chatMessage);
                    etMessage.setText("");

                    chatAdapter.notifyDataSetChanged();
                    recyclerView.scrollToPosition(ChatRepository.getInstance().getMessages().size() - 1);
                }
            }
        });
    }
}
