package com.abidkiller.basic.keepnotes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.abidkiller.basic.keepnotes.NoteClickListener;
import com.abidkiller.basic.keepnotes.R;
import com.abidkiller.basic.keepnotes.model.Note;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.Getter;
import lombok.Setter;

public class NotesAdapter extends RecyclerView.Adapter<NotesViewHolder> {
    Context context;
    List<Note> noteList;
    NoteClickListener noteClickListener;

    public NotesAdapter(Context context, List<Note> noteList, NoteClickListener noteClickListener) {
        this.context = context;
        this.noteList = noteList;
        this.noteClickListener = noteClickListener;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.note_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.note_title.setText(noteList.get(position).getTitle());
        holder.note_title.setSelected(true);
        holder.note_description.setText(noteList.get(position).getDescription());
        holder.note_date.setText(noteList.get(position).getDate());
        holder.note_date.setSelected(true);

        if(noteList.get(position).getPin()){
            holder.pin_image.setImageResource(R.drawable.pin_image);
        }else{
            holder.pin_image.setImageResource(0);
        }

        int color_code= getRandomColor();
        holder.note_container.setBackgroundColor(holder.itemView.getResources().getColor(color_code,null));

        holder.note_container.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                noteClickListener.onClick(noteList.get(holder.getAdapterPosition()));
            }
        });

        holder.note_container.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                noteClickListener.onLongClick(noteList.get(holder.getAdapterPosition()),holder.note_container);
                return true;
            }
        });
    }

    private int getRandomColor(){
        List<Integer> colorCode= new ArrayList<>();

        colorCode.add(R.color.color1);
        colorCode.add(R.color.color2);
        colorCode.add(R.color.color3);
        colorCode.add(R.color.color4);
        colorCode.add(R.color.color5);
        colorCode.add(R.color.color6);
        colorCode.add(R.color.color7);
        colorCode.add(R.color.color8);
        colorCode.add(R.color.color9);

        Random random= new Random();
        int index = random.nextInt(colorCode.size());

        return colorCode.get(index);

    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }
}

@Getter
@Setter
class NotesViewHolder extends RecyclerView.ViewHolder{

    CardView note_container ;
    TextView note_title,note_description,note_date;
    ImageView pin_image;

    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);
        this.note_container=itemView.findViewById(R.id.note_container);
        this.note_title=itemView.findViewById(R.id.note_title);
        this.note_description=itemView.findViewById(R.id.note_description);
        this.note_date=itemView.findViewById(R.id.note_date);
        this.pin_image=itemView.findViewById(R.id.pin_image);
    }
}