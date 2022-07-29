package kr.hs.emirim.s2127.mirim_project_0728_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView tvTitle = findViewById(R.id.text_title);
        ImageView imgv=findViewById(R.id.imgv);
        Intent intent=getIntent();
        String[] imgName=intent.getStringArrayExtra("imgName");
        int[] voteCount = intent.getIntArrayExtra("voteCount");
        int[] imgRes= {R.drawable.imgv01,R.drawable.imgv02,R.drawable.imgv03,R.drawable.imgv04,R.drawable.imgv05,R.drawable.imgv06,
                R.drawable.imgv07,R.drawable.imgv08,R.drawable.imgv09};

        int max=voteCount[0];
        int maxIndex=0;
        for(int i=0; i<imgName.length; i++){
            if(voteCount[i]>max){
                max=voteCount[i];
                maxIndex=i;
            }
        }


        tvTitle.setText(imgName[maxIndex]);
        imgv.setImageResource(imgRes[maxIndex]);

        TextView[] tv=new TextView[imgName.length];
        int[] textId={R.id.text01, R.id.text02, R.id.text03,R.id.text04, R.id.text05, R.id.text06,
                R.id.text07, R.id.text08, R.id.text09};
        RatingBar[] rb = new RatingBar[voteCount.length];
        int[] rbId={R.id.rb1, R.id.rb2, R.id.rb3,R.id.rb4, R.id.rb5, R.id.rb6,
                R.id.rb7, R.id.rb8, R.id.rb9};
        for(int i=0; i<imgName.length; i++)
        {
            tv[i]=findViewById(textId[i]);
            rb[i]=findViewById(rbId[i]);
            tv[i].setText(imgName[i]);
            rb[i].setRating(voteCount[i]);
        }
        Button btnHome=findViewById(R.id.btn_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}