package net.redlinesoft.app.singingbowl;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.startapp.android.publish.StartAppSDK;

import java.io.IOException;

public class SingingbowlActivity extends Activity {
	
	private Boolean status;
	public static MediaPlayer myplayer=new MediaPlayer();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

        // load main layout        
		super.onCreate(savedInstanceState);

        // load startapp
        StartAppSDK.init(this, "108267756", "208107776", true);

        setContentView(R.layout.main);
		
		// show toast text
		Toast.makeText(this,R.string.app_instruction, Toast.LENGTH_LONG).show();
		
		// check onclick
		status = false;
		View imageButton = (View) findViewById(R.id.imageButton);
		imageButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				status = !(status);
				if (status) {
					myplayer=MediaPlayer.create(getApplicationContext(), R.raw.sound);
					myplayer.setLooping(true);
		            try {
						myplayer.prepare();
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}	
		            myplayer.start();
		            ImageView button=(ImageView) findViewById(R.id.imageButton);
		            button.setImageResource(R.drawable.play);
				} else {
					myplayer.stop();
					ImageView button=(ImageView) findViewById(R.id.imageButton);
		            button.setImageResource(R.drawable.stop);
				}
			}			
		});
	}
	

}