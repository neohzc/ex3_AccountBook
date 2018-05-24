package com.example.neoh.accountbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class lAdapter extends ArrayAdapter<Account_item> {

        private LayoutInflater layoutInflater;

        private class ViewHolder {
            TextView Smoney;
            TextView Sclassify;
            TextView Stime;
            //TextView Stime;

        }

    public lAdapter(Context context, int textViewResourceId, Account_item[] list) {
        super(context, textViewResourceId, list);
        this.layoutInflater = LayoutInflater.from(context);
    }

        public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            //create new view
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }
        ViewHolder holder = null;

        if(holder == null){
            holder = new ViewHolder();
            holder.Smoney = (TextView)convertView.findViewById(R.id.it_money);
            holder.Sclassify = (TextView)convertView.findViewById(R.id.it_classify);
            holder.Stime = (TextView)convertView.findViewById(R.id.it_time);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }

        Account_item course = getItem(position);
        holder.Smoney.setText(course.getmoney());
        holder.Sclassify.setText(course.getclassify());
        holder.Stime.setText(course.gettime());

        return convertView;
    }



    }
