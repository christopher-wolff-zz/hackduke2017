package hackduke2017.identify;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private static int IMG_RESULT = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tx = (TextView)findViewById(R.id.textView);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/beyond_the_mountains.ttf");
        tx.setTypeface(custom_font);
        Button startImport = (Button) findViewById(R.id.importButton);
        startImport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goToSecondActivity();
            }
        });
        Button startCamera = (Button) findViewById(R.id.cameraButton);
        startCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToThirdActivity();
            }
        });
    }
    private void goToSecondActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
    private void goToThirdActivity(){
        /*
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
        */
    }
}