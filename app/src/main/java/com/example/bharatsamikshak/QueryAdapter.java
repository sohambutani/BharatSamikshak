package com.example.bharatsamikshak;

import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class QueryAdapter extends RecyclerView.Adapter<QueryAdapter.MyViewHolder> {

    List<Query> messageList;
    public QueryAdapter(List<Query> messageList) {
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View chatView = LayoutInflater.from(parent.getContext()).inflate(R.layout.myquestion,null);
        MyViewHolder myViewHolder = new MyViewHolder(chatView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Query query = messageList.get(position);
        if(query.getQueryans().equals(Query.SENT_BY_ME)){
            holder.myquestionquery.setVisibility(View.GONE);
            holder.responced.setVisibility(View.VISIBLE);
            holder.responcedtextview.setText(query.getQuery());
        }else{
            holder.responced.setVisibility(View.GONE);
            holder.myquestionquery.setVisibility(View.VISIBLE);
            holder.myquestionquerytextview.setText(query.getQuery());
        }
    }

    @Override
    public   int getItemCount() {
        return messageList.size();

    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
                LinearLayout myquestionquery,responced;
                TextView myquestionquerytextview , responcedtextview;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            myquestionquery = itemView.findViewById(R.id.myquestionquery);
            responced = itemView.findViewById(R.id.myquestionquerytextview);

            myquestionquerytextview = itemView.findViewById(R.id.responced);
            responcedtextview = itemView.findViewById(R.id.responcedtextview);
        }
    }
}
