package com.example.koki.contextualbatchmode;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    AbsListView.MultiChoiceModeListener mMultiChoiceModeListener = new AbsListView.MultiChoiceModeListener() {
        @Override
        public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {
        }

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            // Inflate the menu for the CAB
            MenuInflater inflater = actionMode.getMenuInflater();
            inflater.inflate(R.menu.contexual_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            //Handle menu selection
            switch (menuItem.getItemId()) {
                case R.id.menu_move:
                    Toast.makeText(MainActivity.this, "Move", Toast.LENGTH_SHORT).show();
                    actionMode.finish();
                    return true;
                case R.id.menu_delete:
                    Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                    actionMode.finish();
                    return true;
                default:
                    return false;
            }

        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] countries = new String[]{"China", "France", "Germany", "India", "Singapore ", "UK", "US"};
        ListAdapter countryAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, countries);
        setListAdapter(countryAdapter);
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        getListView().setMultiChoiceModeListener(mMultiChoiceModeListener);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((ListView) parent).setItemChecked(position, true);
            }
        });
    }
}
