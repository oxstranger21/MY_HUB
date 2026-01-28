package com.example.myhub;



import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnInstagram, btnSnapchat, btnLinkedIn, btnGitHub, btnYouTube, btnTwitter;
    TextView myHub;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInstagram = findViewById(R.id.btnInstagram);
        btnSnapchat  = findViewById(R.id.btnSnapchat);
        btnLinkedIn  = findViewById(R.id.btnLinkedIn);
        btnGitHub    = findViewById(R.id.btnGitHub);
        btnYouTube   = findViewById(R.id.btnYouTube);
        btnTwitter   = findViewById(R.id.btnTwitter);
        myHub = findViewById(R.id.myHubText);

        myHub.post(() -> {
            Shader textShader = new LinearGradient(
                    0, 0,
                    myHub.getWidth(), myHub.getTextSize(),
                    new int[]{
                            0xFF00F2FE,   // Cyan
                            0xFF4FACFE,   // Blue
                            0xFF43E97B,   // Green
                            0xFFFA709A    // Pink
                    },
                    null,
                    Shader.TileMode.CLAMP
            );

            myHub.getPaint().setShader(textShader);
            myHub.invalidate();
        });


        btnInstagram.setOnClickListener(v -> openLink("https://insta.openinapp.co/i6q63"));
        btnSnapchat.setOnClickListener(v -> openLink("https://snap.openinapp.co/g7id3"));
        btnLinkedIn.setOnClickListener(v -> openLink("https://linkedin.openinapp.co/y1mp6"));
        btnGitHub.setOnClickListener(v -> openLink("https://github.com/oxstranger21"));
        btnYouTube.setOnClickListener(v -> openLink("https://yt.openinapp.co/bwg1e"));
        btnTwitter.setOnClickListener(v -> openLink("https://twtr.openinapp.co/ciiqz"));
    }
    Shader textShader;



    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
