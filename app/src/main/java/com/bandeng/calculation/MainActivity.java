package com.bandeng.calculation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_dis;
    private EditText et_high;
    private EditText et_tan;
    private Button btn;
    private TextView tv_text_show;
    private TextView tv_fooler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_dis = (EditText) findViewById(R.id.et_dis);
        et_high = (EditText) findViewById(R.id.et_high);
        et_tan = (EditText) findViewById(R.id.et_tan);

        btn = (Button) findViewById(R.id.btn);
        tv_text_show = (TextView) findViewById(R.id.tv_text_show);
        tv_fooler = (TextView) findViewById(R.id.tv_fooler);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String dis = et_dis.getText().toString();
        String high = et_high.getText().toString();
        String tan = et_tan.getText().toString();

        if (TextUtils.isEmpty(high)) {
            Toast.makeText(this, "前方楼高度不能为空", Toast.LENGTH_LONG).show();
            return;
        } else if (TextUtils.isEmpty(dis)) {
            Toast.makeText(this, "楼间距不能为空", Toast.LENGTH_LONG).show();
            return;
        } else if (TextUtils.isEmpty(tan)) {
            Toast.makeText(this, "太阳夹角不能为空", Toast.LENGTH_LONG).show();
            return;
        }

        float dis2 = Float.valueOf(dis);
        float high2 = Float.valueOf(high);
        float tan2 = Float.valueOf(tan);

        float result = (float) (high2 - dis2 * Math.tan(tan2 * Math.PI / 180));

        tv_text_show.setText(result + " 米 ");
        int fooler = (int) (result / 3.0 + 0.5);
        tv_fooler.setText(fooler + " 层");
    }
}
