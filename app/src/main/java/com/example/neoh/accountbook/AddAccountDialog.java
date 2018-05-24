package com.example.neoh.accountbook;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddAccountDialog extends AlertDialog implements View.OnClickListener {

    public Callback callback = null;

    private Context TAG;
    private int id;
    private EditText etMoney, etClassify, etTime;  //编辑框
    private Button btnConfrm, btnCancel;  //确定取消按钮


    public AddAccountDialog(Context context,int id) {
        super(context);
        TAG = context;
        this.id = id;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);

        //控件
        etMoney = (EditText) findViewById(R.id.edMoney);
        etClassify = (EditText) findViewById(R.id.edClassify);
        etTime = (EditText) findViewById(R.id.edTime);
        btnConfrm = (Button) findViewById(R.id.btnConfrm);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        btnConfrm.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnConfrm) {
            //确定
            if (etMoney.getText().toString() != null) {
                callback.onClick(etMoney.getText().toString(), etClassify.getText().toString(), etTime.getText().toString(),id);
                dismiss();
            } else
                Toast.makeText(TAG, "至少输入金额", Toast.LENGTH_SHORT).show();
        } else {
            //取消
            dismiss();
        }
    }


}