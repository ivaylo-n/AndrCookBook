package com.example.koki.loader;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class DictionaryAdapter extends CursorAdapter {
    public DictionaryAdapter(Context context, Cursor cursor,
                             int flags){
        super(context, cursor, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(
                android.R.layout.simple_list_item_1,viewGroup,
                false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textView = (TextView)view.findViewById(
                android.R.id.text1);
        textView.setText(cursor.getString(
                getCursor().getColumnIndex("word")));
    }
}
