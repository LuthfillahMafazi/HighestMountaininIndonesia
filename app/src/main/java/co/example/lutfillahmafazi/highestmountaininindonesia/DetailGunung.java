package co.example.lutfillahmafazi.highestmountaininindonesia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailGunung extends AppCompatActivity {

    @BindView(R.id.imgGunung)
    ImageView imgGunung;
    @BindView(R.id.txtGunung)
    TextView txtGunung;
    @BindView(R.id.txtDetailGunung)
    TextView txtDetailGunung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_gunung);
        ButterKnife.bind(this);

        txtDetailGunung.setText(getIntent().getStringExtra("ng"));
        txtGunung.setText(getIntent().getStringExtra("dg"));
        Glide.with(this).load(getIntent().getIntExtra("gg",0));
    }
}
