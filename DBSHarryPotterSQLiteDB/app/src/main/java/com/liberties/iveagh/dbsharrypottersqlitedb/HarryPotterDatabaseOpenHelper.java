package com.liberties.iveagh.dbsharrypottersqlitedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HarryPotterDatabaseOpenHelper extends SQLiteOpenHelper {

    final static String TABLE_NAME = "authors";
    final static String CHARACTER_NAME = "name";
    final static String _ID = "_id";
    final static String AGE = "age";
    final static String WAND = "wand";
    final static String BIRTHPLACE = "birthplace";
    final static String DESCRIPTION = "description";
    final static String[] columns = { _ID, CHARACTER_NAME, AGE, WAND, BIRTHPLACE, DESCRIPTION };

    final private static String CREATE_CMD =

            "CREATE TABLE authors (" + _ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + CHARACTER_NAME + " TEXT NOT NULL,"
                    + AGE + " TEXT NOT NULL,"
                    + WAND + " TEXT NOT NULL,"
                    + BIRTHPLACE + " TEXT NOT NULL,"
                    + DESCRIPTION + " TEXT NOT NULL)";;

    final private static String NAME = "authors_db_sqlite";
    final private static Integer VERSION = 1;
    final private Context mContext;

    public HarryPotterDatabaseOpenHelper(Context context) {
        super(context, NAME, null, VERSION);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CMD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // N/A
    }

    void deleteDatabase() {
        mContext.deleteDatabase(NAME);
    }
}







//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//public class HarryPotterDatabaseOpenHelper extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_harry_potter_database_open_helper);
//    }
//}
