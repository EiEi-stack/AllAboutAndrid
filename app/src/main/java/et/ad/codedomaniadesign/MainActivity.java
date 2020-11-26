package et.ad.codedomaniadesign;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    private Button btnOne, btnTwo;
    private View line;
    private Animation btnAnim;
    private Animation lineAnimation;
    private Boolean isPlay=false;
    private SoundPool sp;
    private int clippy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        line = findViewById(R.id.line);

        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        lineAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.line_rotate);
        btnAnim.setAnimationListener(this);
        lineAnimation.setAnimationListener(this);

        sp= new SoundPool(6, AudioManager.STREAM_MUSIC,0);
        clippy=sp.load(getApplicationContext(),R.raw.ss,1);
       btnTwo.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               isPlay=!isPlay;
               if(isPlay){
                   sp.play(clippy,1,1,0,0,1);
                   btnOne.startAnimation(btnAnim);
                   line.startAnimation(lineAnimation);
               }else{
                   btnOne.clearAnimation();
                   line.clearAnimation();
               }
           }
       });
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}