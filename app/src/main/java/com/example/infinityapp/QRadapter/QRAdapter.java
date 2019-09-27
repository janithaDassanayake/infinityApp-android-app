package com.example.infinityapp.QRadapter;

import android.content.Context;
import android.content.Intent;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infinityapp.Model.TicketList;
import com.example.infinityapp.Model.TicketList;
import com.example.infinityapp.R;

import java.util.List;

public class QRAdapter extends RecyclerView.Adapter<QRAdapter.QRAdapterViewHolder> {

    List<TicketList>listItemsArray;
    Context context;
    public QRAdapter(List<TicketList>listItemsArray, Context context){

        this.listItemsArray=listItemsArray;
        this.context=context;

    }


    @NonNull
    @Override
    public QRAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.ticket_list_layout,parent,false);
        return new QRAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull QRAdapterViewHolder holder, int position) {

        TicketList ticketList=listItemsArray.get(position);
        holder.textViewType.setText(ticketList.getType());
        holder.textViewcode.setText(ticketList.getCode());

        Linkify.addLinks(holder.textViewcode,Linkify.ALL);


    }

    @Override
    public int getItemCount() {

        return listItemsArray.size();
    }

    public class QRAdapterViewHolder extends RecyclerView.ViewHolder{

        TextView textViewcode,textViewType;
        CardView cardView;

        public QRAdapterViewHolder(@NonNull final View itemView) {
            super(itemView);
            textViewcode=(TextView)itemView.findViewById(R.id.textViewCode);
            textViewType=(TextView)itemView.findViewById(R.id.textViewType);
            cardView=(CardView)itemView.findViewById(R.id.cardView);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String type = listItemsArray.get(getAdapterPosition()).getType();

                    Intent intent= new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_TEXT,type);
                    intent.setType("text/plain");
                    itemView.getContext().startActivity(intent);


                }
            });
        }




    }

}
