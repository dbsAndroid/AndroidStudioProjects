package com.liberties.iveagh.dbsharrypottersqlitedb;

import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {

    private HarryPotterDatabaseOpenHelper mDbHelper;
    private SimpleCursorAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Create a new DatabaseHelper
        mDbHelper = new HarryPotterDatabaseOpenHelper(this);

        // start with an empty database
        clearAll();

        // Insert records
        insertAuthors();

        // Create a cursor
        Cursor c = readAuthors();
        mAdapter = new SimpleCursorAdapter(this, R.layout.list_layout, c,
                HarryPotterDatabaseOpenHelper.columns, new int[] { R.id._id, R.id.name, R.id.age, R.id.wand, R.id.birthplace, R.id.description },
                0);

        setListAdapter(mAdapter);

        Button fixButton = (Button) findViewById(R.id.fix_button);
        fixButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // execute database operations
                fix();

                // Redisplay data
                mAdapter.getCursor().requery();
                mAdapter.notifyDataSetChanged();
            }
        });

    }

    // Insert several author records
    private void insertAuthors() {

        ContentValues values = new ContentValues();

        values.put(HarryPotterDatabaseOpenHelper.CHARACTER_NAME, "Voldemort");
        values.put(HarryPotterDatabaseOpenHelper.AGE, "92");
        values.put(HarryPotterDatabaseOpenHelper.WAND, "wanda");
        values.put(HarryPotterDatabaseOpenHelper.BIRTHPLACE, "cesarean");
        values.put(HarryPotterDatabaseOpenHelper.DESCRIPTION, "general villain");
        mDbHelper.getWritableDatabase().insert(HarryPotterDatabaseOpenHelper.TABLE_NAME, null, values);

        values.clear();

        values.put(HarryPotterDatabaseOpenHelper.CHARACTER_NAME, "Dumbeldorez");
        values.put(HarryPotterDatabaseOpenHelper.AGE, "92");
        values.put(HarryPotterDatabaseOpenHelper.WAND, "wanda");
        values.put(HarryPotterDatabaseOpenHelper.BIRTHPLACE, "cesarean");
        values.put(HarryPotterDatabaseOpenHelper.DESCRIPTION, "general villain");
        mDbHelper.getWritableDatabase().insert(HarryPotterDatabaseOpenHelper.TABLE_NAME, null, values);

        values.clear();

        values.put(HarryPotterDatabaseOpenHelper.CHARACTER_NAME, "Hermimone");
        values.put(HarryPotterDatabaseOpenHelper.AGE, "92");
        values.put(HarryPotterDatabaseOpenHelper.WAND, "wanda");
        values.put(HarryPotterDatabaseOpenHelper.BIRTHPLACE, "cesarean");
        values.put(HarryPotterDatabaseOpenHelper.DESCRIPTION, "general villain");
        mDbHelper.getWritableDatabase().insert(HarryPotterDatabaseOpenHelper.TABLE_NAME, null, values);

        values.clear();

        values.put(HarryPotterDatabaseOpenHelper.CHARACTER_NAME, "Noddy");
        values.put(HarryPotterDatabaseOpenHelper.AGE, "92");
        values.put(HarryPotterDatabaseOpenHelper.WAND, "wanda");
        values.put(HarryPotterDatabaseOpenHelper.BIRTHPLACE, "cesarean");
        values.put(HarryPotterDatabaseOpenHelper.DESCRIPTION, "general villain");
        mDbHelper.getWritableDatabase().insert(HarryPotterDatabaseOpenHelper.TABLE_NAME, null, values);

        values.clear();

        values.put(HarryPotterDatabaseOpenHelper.CHARACTER_NAME, "40 Coats");
        values.put(HarryPotterDatabaseOpenHelper.AGE, "92");
        values.put(HarryPotterDatabaseOpenHelper.WAND, "wanda");
        values.put(HarryPotterDatabaseOpenHelper.BIRTHPLACE, "cesarean");
        values.put(HarryPotterDatabaseOpenHelper.DESCRIPTION, "general villain");
        mDbHelper.getWritableDatabase().insert(HarryPotterDatabaseOpenHelper.TABLE_NAME, null, values);
    }

    // Returns all author records in the database
    private Cursor readAuthors() {
        return mDbHelper.getWritableDatabase().query(HarryPotterDatabaseOpenHelper.TABLE_NAME,
                HarryPotterDatabaseOpenHelper.columns, null, new String[] {}, null, null,
                null);
    }

    // Modify the contents of the database
    private void fix() {

        // Sorry Lady Gaga :-(
        mDbHelper.getWritableDatabase().delete(HarryPotterDatabaseOpenHelper.TABLE_NAME,
                HarryPotterDatabaseOpenHelper.CHARACTER_NAME + "=?",
                new String[] { "40 Coats" });

        // fix the Man in Black
        ContentValues values = new ContentValues();
        values.put(HarryPotterDatabaseOpenHelper.CHARACTER_NAME, "Dumbledore");

        mDbHelper.getWritableDatabase().update(HarryPotterDatabaseOpenHelper.TABLE_NAME, values,
                HarryPotterDatabaseOpenHelper.CHARACTER_NAME + "=?",
                new String[] { "Dumbeldorez" });

    }

    // Delete all records
    private void clearAll() {

        mDbHelper.getWritableDatabase().delete(HarryPotterDatabaseOpenHelper.TABLE_NAME, null, null);

    }

    // Close database and destroy after every close.
    @Override
    protected void onDestroy() {

        mDbHelper.getWritableDatabase().close();
        mDbHelper.deleteDatabase();

        super.onDestroy();

    }
}

//public class HarryPotterDatabaseOpenHelper extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}
