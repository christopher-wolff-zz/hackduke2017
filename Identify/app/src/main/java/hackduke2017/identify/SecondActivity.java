package hackduke2017.identify;

import android.app.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.graphics.Bitmap;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SecondActivity extends Activity {
    private Map<String, Boolean> emotionOptions;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    String correct;

    private Set<Bitmap> getBitMaps(){
        File sd = Environment.getExternalStorageDirectory();
        File[] files = new File(sd+"/drawable/emotions").listFiles();
        Set<Bitmap> imageSet=new HashSet<>();
        for(File image:files){
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(),bmOptions);
            //imageView.setImageBitmap(bitmap);
            imageSet.add(bitmap);
        }
        return imageSet;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //set emotionOptions from the image;



        correct = "";
        for (String key: emotionOptions.keySet()){
            if (emotionOptions.get(key) == true){
                correct = key;
            }
        }

        b1 = (Button) findViewById(R.id.b1);
        b1.setText(emotionOptions.keySet().toArray(new String[emotionOptions.size()])[0]);
        b2 = (Button) findViewById(R.id.b2);
        b2.setText(emotionOptions.keySet().toArray(new String[emotionOptions.size()])[1]);
        b3 = (Button) findViewById(R.id.b3);
        b3.setText(emotionOptions.keySet().toArray(new String[emotionOptions.size()])[2]);
        b4 = (Button) findViewById(R.id.b4);
        b4.setText(emotionOptions.keySet().toArray(new String[emotionOptions.size()])[3]);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b1.getText().equals(correct)) goToThirdActivity();
                else{getNotification(view);
                };
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b2.getText().equals(correct)) goToThirdActivity();
                else{getNotification(view);
                };
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b3.getText().equals(correct)) goToThirdActivity();
                else{getNotification(view);
                };
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b4.getText().equals(correct)) goToThirdActivity();
                else{getNotification(view);
                };
            }
        });
    }


    public void getNotification(View view){
        Toast.makeText(getApplicationContext(), "Try again!",Toast.LENGTH_LONG);
    }

    public Map<String, Boolean> getEmotionOptions(Map<String,Double> allEmotions){
        return null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
    public void goToThirdActivity(){
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

}