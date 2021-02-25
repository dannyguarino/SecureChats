package com.example.securechats.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.securechats.Model.Chat;
import com.example.securechats.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    public static final int CHAT_BUBBLE_LEFT = 0;
    public static final int CHAT_BUBBLE_RIGHT = 1;

    private Context mContext;
    private List<Chat> mChat;
    private String imgURL;

    FirebaseUser firebaseUser;

    public MessageAdapter(Context mContext, List<Chat> mChat, String imgURL) {
        this.mChat = mChat;
        this.mContext = mContext;
        this.imgURL = imgURL;
    }

    @NonNull
    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == CHAT_BUBBLE_RIGHT) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.sample_sender, parent, false);
            return new MessageAdapter.ViewHolder(view);
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.sample_receiver, parent, false);
            return new MessageAdapter.ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.ViewHolder holder, int position) {
        Chat chat = mChat.get(position);
        holder.chat_bubble.setText(chat.getMessage());

        if (position == mChat.size()-1) {
            if (chat.isSeen()) {
                holder.isSeen.setText("Seen");
            } else {
                holder.isSeen.setText("Delivered");
            }
        } else {
            holder.isSeen.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return mChat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView chat_bubble;

        public TextView isSeen;

        public ViewHolder(View itemView) {
            super(itemView);
            chat_bubble = itemView.findViewById(R.id.chat_bubble);
            isSeen = itemView.findViewById(R.id.seen);
        }
    }

    @Override
    public int getItemViewType(int position) {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (mChat.get(position).getSender().equals(firebaseUser.getUid())) {
            return CHAT_BUBBLE_RIGHT;
        } else {
            return CHAT_BUBBLE_LEFT;
        }
    }
}