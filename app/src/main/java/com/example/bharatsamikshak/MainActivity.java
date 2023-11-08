package com.example.bharatsamikshak;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Query> messageList;
    QueryAdapter queryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageList = new ArrayList<>();

        recyclerView = findViewById(R.id.recycler_view);
        EditText questionInput = findViewById(R.id.message_edit_text);
        Button sendButton = findViewById(R.id.send_btn);

        queryAdapter = new QueryAdapter(messageList);
        recyclerView.setAdapter(queryAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setStackFromEnd(true);
        recyclerView.setLayoutManager(llm);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String question = questionInput.getText().toString();
                addToChat(question,Query.SENT_BY_ME);
                if (!question.isEmpty()) {

                    Toast.makeText(MainActivity.this, "You asked: " + question, Toast.LENGTH_SHORT).show();
                    questionInput.getText().clear();
                }
            }
        });
    }

    void addToChat(String query,String queryans){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messageList.add(new Query(query,queryans));
                queryAdapter.notifyDataSetChanged();
                recyclerView.smoothScrollToPosition(queryAdapter.getItemCount());
            }
        });
    }

}
