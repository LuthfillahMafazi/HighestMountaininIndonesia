package co.example.lutfillahmafazi.highestmountaininindonesia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleActivity extends AppCompatActivity {

    @BindView(R.id.myRecycle)
    RecyclerView myRecycle;

    String[] namaGunung, detailGunung;
    int[] gambarGunung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);

        namaGunung = getResources().getStringArray(R.array.nama_gunung);
        detailGunung = getResources().getStringArray(R.array.detail_gunung);
        gambarGunung = new int[]{R.drawable.puncakjaya,R.drawable.gunung_rinjani,R.drawable.gunung_semeru,R.drawable.gunung_slamet,R.drawable.leuser,R.drawable.gunung_agung,
        R.drawable.bukit_raya};

        AdapterGunung adapterGunung = new AdapterGunung(this,namaGunung,detailGunung,gambarGunung);
        myRecycle.setHasFixedSize(true);
        myRecycle.setLayoutManager(new LinearLayoutManager(this));
        myRecycle.setAdapter(adapterGunung);
    }
}
