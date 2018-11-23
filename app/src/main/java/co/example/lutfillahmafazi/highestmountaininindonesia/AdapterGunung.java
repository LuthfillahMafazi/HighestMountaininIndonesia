package co.example.lutfillahmafazi.highestmountaininindonesia;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterGunung extends RecyclerView.Adapter<AdapterGunung.ViewHolder> {
    Context context;
    String[] namaGunung, detailGunung;
    int[] gambarGunung;

    public AdapterGunung(Context context, String[] namaGunung, String[] detailGunung, int[] gambarGunung) {
        this.context = context;
        this.namaGunung = namaGunung;
        this.detailGunung = detailGunung;
        this.gambarGunung = gambarGunung;
    }

    @NonNull
    @Override
    public AdapterGunung.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_gunung,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterGunung.ViewHolder viewHolder, final int i) {

        viewHolder.txtGunung.setText(namaGunung[i]);
        Glide.with(context).load(gambarGunung[i]).into(viewHolder.imgGunung);

        viewHolder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailGunung.class);

                pindah.putExtra("ng",namaGunung[i]);
                pindah.putExtra("dg",detailGunung[i]);
                pindah.putExtra("gg",gambarGunung[i]);

                context.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gambarGunung.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgGunung;
        TextView txtGunung;
        Button btnDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgGunung = itemView.findViewById(R.id.imgGunung1);
            txtGunung = itemView.findViewById(R.id.txtGunung1);
            btnDetail = itemView.findViewById(R.id.btnDetail);
        }
    }
}
