package kr.hs.emirim.s2127.mirim_project_0728_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] imgName={"뿌링클","갈비천왕","허니콤보","레드콤보","xo치킨","포테킹치킨","황금올리브","고추윙봉","슈프림양념"};

    ImageView[] imgv=new ImageView[imgName.length];
    int[] voteCount =new int[imgName.length];
    int[] imgId={R.id.imgv01,R.id.imgv02,R.id.imgv03,R.id.imgv04,R.id.imgv05,
            R.id.imgv06,R.id.imgv07,R.id.imgv08,R.id.imgv09};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("좋아하는 치킨 투표");
        Button btnFinish=findViewById(R.id.btn_vote_finish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                intent.putExtra("imgName",imgName);
                intent.putExtra("voteCount",voteCount);
                startActivity(intent);
            }
        });
        for(int i=0; i< voteCount.length; i++)
            voteCount[i]=0;
        for(int i=0; i< imgv.length; i++){
            final int index;
            index=i;
            imgv[index]=findViewById(imgId[index]);
            imgv[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),imgName[index]+": 총"+voteCount[index]+"표"
                            ,Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}