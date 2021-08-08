package com.example.absensiapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.absensiapp.ViewHistory;
import com.example.absensiapp.entity.Absensi;
import com.example.absensiapp.service.AbsensiInterface;
import com.example.absensiapp.R;

import java.util.ArrayList;

public class AbsensiAdapter extends RecyclerView.Adapter<AbsensiAdapter.AbsensiViewHolder> {

    ArrayList<Absensi> listAbsensi;
    private Context context;
    AbsensiInterface absensiInterface;

    public AbsensiAdapter(ArrayList<Absensi> listAbsensi, Context context) {
        this.listAbsensi = listAbsensi;
        this.context = context;
    }

    @NonNull
    @Override
    public AbsensiAdapter.AbsensiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View v =inflater.inflate(R.layout.history_card_layout,parent,false);

        return new AbsensiViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AbsensiAdapter.AbsensiViewHolder holder, int position) {
        holder.textDate.setText(listAbsensi.get(position).getDate());
        holder.textCheckin.setText(listAbsensi.get(position).getCheckIn());
        holder.textCheckout.setText(listAbsensi.get(position).getCheckOut());
//        holder.textLembur.setText();

    }

    @Override
    public int getItemCount() {
        return listAbsensi.size();
    }

    public class AbsensiViewHolder extends RecyclerView.ViewHolder{
        TextView textDate, textCheckin, textCheckout, textLembur;
        public AbsensiViewHolder(@NonNull View itemView) {
            super(itemView);

            textDate = itemView.findViewById(R.id.text_date_card);
            textCheckin = itemView.findViewById(R.id.text_checkin_card);
            textCheckout = itemView.findViewById(R.id.text_checkout_card);
            textLembur = itemView.findViewById(R.id.text_lembur_card);

        }
    }
}
