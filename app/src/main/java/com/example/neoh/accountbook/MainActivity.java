package com.example.neoh.accountbook;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static int maxSizeOfAccounts = 1024;
    private int numberOfAcc;
    Context TAG =this;
    private SQLiteDatabase db;
    Account_item[] list =new Account_item[maxSizeOfAccounts];

    private Button button;
    private TextView
            tvMonthIn, tvMonthOut,
            tvWeekIn, tvWeekOut,
            tvDayIn, tvDayOut;
    private ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitDataFromDB();


    }


    /*data opt*/
    private void InitDataFromDB() {

        db = openOrCreateDatabase(DBinfo._DBNAME, Context.MODE_PRIVATE, null);
        int version = db.getVersion();
        if (version < 1) {
            db.execSQL("CREATE TABLE " + DBinfo._TABLENAME + " ( " +
                    DBinfo._NO + " text PRIMARY KEY ," +
                    DBinfo._MONEY + " text ," +
                    DBinfo._CLASSIFY + " text ," +
                    DBinfo._TIME + " text )"
            );
            db.setVersion(1);
        }
        getAllData();
    }

    private void getAllData() {
        Cursor cursor = db.query(DBinfo._TABLENAME, null, null, null, null, null, null);
        if (cursor.getCount() > 0) {
            numberOfAcc=cursor.getCount();
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndex(DBinfo._NO));
                list[id].setmoney(cursor.getString(cursor.getColumnIndex(DBinfo._MONEY)));
                list[id].setclassify(cursor.getString(cursor.getColumnIndex(DBinfo._CLASSIFY)));
                list[id].settime(cursor.getString(cursor.getColumnIndex(DBinfo._TIME)));
            }
        }
    }

    private void updateData(String id, String course, String classroom, String teacher) {
        Cursor cursor = db.rawQuery(
                "select * from " + DBinfo._TABLENAME + "    where   id=? ",
                new String[]{id});

        if (cursor.getCount() != 0) {
            //int iId= Integer.valueOf(id);
            db.execSQL("update " + DBinfo._TABLENAME + " set " + DBinfo._MONEY + "=?, " + DBinfo._CLASSIFY + "=?," + DBinfo._TIME + "=? where " + DBinfo._NO + "=?",
                    new Object[]{course, classroom, teacher, id});
            Toast.makeText(MainActivity.this, "修改成功", Toast.LENGTH_SHORT).show();

        } else {
            db.execSQL("insert into " + DBinfo._TABLENAME + " ( " +
                            DBinfo._NO + " ," +
                            DBinfo._MONEY + "  ," +
                            DBinfo._CLASSIFY + "  ," +
                            DBinfo._TIME + " ) values (?,?,?,?)", new Object[]{
                            id, course, classroom, teacher
                    }
            );
            Toast.makeText(MainActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
        }


    }
    private void InitListItem() {
        for (int i = 0; i < numberOfAcc; i++) {
            list[i] = new Account_item("", "", "", i);
        }

    }


}
