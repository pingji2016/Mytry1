package com.example.root.mytry1;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class FeedbackActivity  extends Activity {
    private static final int MAX_COUNT = 200;
    private EditText mEtContent = null;
    private TextView mTextCount = null;
    private Button mBoutton=null;
    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);
        mEtContent = (EditText) findViewById(R.id.et_content);
        mTextCount = (TextView) findViewById(R.id.text_count);
        mEtContent.addTextChangedListener(new TextWatcher() {
            //对EditText进行监听
            // @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            //@Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            //@Override
            public void afterTextChanged(Editable editable) {
                mTextCount.setText("剩余字数：" + (MAX_COUNT - editable.length()));
            }
        });

        mBoutton=(Button) findViewById(R.id.btn_submit);//提交

        mBoutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(FeedbackActivity.this,"感谢您的反馈",Toast.LENGTH_LONG);
                mEtContent.setText("");
                toast.show();
            }
        });
    }


}
