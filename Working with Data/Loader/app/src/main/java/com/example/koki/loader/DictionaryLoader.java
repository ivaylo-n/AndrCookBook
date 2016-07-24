package com.example.koki.loader;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.CursorLoader;

public class DictionaryLoader extends CursorLoader {
    Context mContext;
    public DictionaryLoader(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public Cursor loadInBackground() {
        DictionaryDatabase dictionaryDatabase = new
                DictionaryDatabase(mContext);
        return dictionaryDatabase.getWordList();
    }
}
