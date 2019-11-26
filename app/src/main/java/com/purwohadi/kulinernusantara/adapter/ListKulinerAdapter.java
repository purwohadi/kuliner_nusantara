package com.purwohadi.kulinernusantara.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.purwohadi.kulinernusantara.AboutActivity;
import com.purwohadi.kulinernusantara.DetailActivity;
import com.purwohadi.kulinernusantara.GlideApp;
import com.purwohadi.kulinernusantara.MainActivity;
import com.purwohadi.kulinernusantara.R;
import com.purwohadi.kulinernusantara.model.Kuliner;

import java.util.ArrayList;

public class ListKulinerAdapter extends RecyclerView.Adapter<ListKulinerAdapter.ListViewHolder> {
    private Context mContext;
    private ArrayList<Kuliner> listKuliner;

    public ListKulinerAdapter(Context mContext, ArrayList<Kuliner> list) {
        this.mContext = mContext;
        this.listKuliner = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_kuliner, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, final int position) {
        final Kuliner current = listKuliner.get(position);
        GlideApp.with(holder.itemView.getContext())
                .load(current.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);

        /*Menampilkan nama*/
        holder.tvName.setText(current.getName());

        /*Menampilkan deskripsi*/
        holder.tvDeskripsi.setText(current.getDeskripsi());

        /*Jika di klik maka akan masuk ke halaman detail*/
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intt = new Intent(mContext, DetailActivity.class);
                intt.putExtra("objKuliner", current);
                mContext.startActivity(intt);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listKuliner.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;
        TextView tvDeskripsi;
        CardView cardView;

        ListViewHolder(final View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            cardView = itemView.findViewById(R.id.card_view);
            tvDeskripsi = itemView.findViewById(R.id.tv_item_deskripsi);
        }
    }
}

