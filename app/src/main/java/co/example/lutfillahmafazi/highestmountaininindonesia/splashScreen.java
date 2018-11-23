package co.example.lutfillahmafazi.highestmountaininindonesia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class splashScreen extends AppCompatActivity {
    private long ms = 0;
    private long splashTime = 3000;
    private Boolean splashActivity = true;
    private Boolean paused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final ProgressBar progressBar = findViewById(R.id.progres_bar);

        Thread mythread = new Thread(){
            public void run(){
                try {
                    while (splashActivity && ms < splashTime){
                        if (!paused){
                            ms = ms +100;
                            sleep(100);
                            progressBar.setProgress((int) ms);
                        }
                    }
                }catch (Exception e){
                }finally {
                    Intent intent = new Intent(splashScreen.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        mythread.start();
    }
}
