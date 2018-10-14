package com.example.amirahmadadibi.myapplication.ui;

import android.content.Context;
import android.service.autofill.TextValueSanitizer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amirahmadadibi.myapplication.R;
import com.example.amirahmadadibi.myapplication.model.NoteEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    private final List<NoteEntity> mNotes;
    private final Context mContext;

    public NotesAdapter(List<NoteEntity> mNotes, Context mContext) {
        this.mNotes = mNotes;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.note_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final NoteEntity note = mNotes.get(i);
        viewHolder.mTextView.setText(note.getText());
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.note_text)
        TextView mTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(mContext, "test", Toast.LENGTH_SHORT).show();
        }
    }
}
