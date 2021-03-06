package salinesingularity.singularitytimingapplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class StartActivity extends AppCompatActivity {

    Button startButton;
    Button instructionButton;
    //long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);

        String versionName = "0.0";

        try {
            versionName = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            //versionname = getString(R.string.app_version) //OLD WAY OF DOING THIS
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        tvTitle.setText(getString(R.string.app_name) + " v" + versionName);

        startButton = (Button) findViewById(R.id.btnStart);
        startButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //startTime = System.currentTimeMillis();
                Intent intent = new Intent(StartActivity.this,GameActivity.class);
                //intent.putExtra("startTime", startTime);
                startActivity(intent);
            }
        });

        instructionButton = (Button) findViewById(R.id.btnInst);
        instructionButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(StartActivity.this,InstructionActivity.class);
                startActivity(intent);
            }
        });
    }

}
