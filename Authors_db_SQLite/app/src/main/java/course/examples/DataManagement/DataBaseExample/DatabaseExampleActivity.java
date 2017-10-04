package course.examples.DataManagement.DataBaseExample;

import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;

public class DatabaseExampleActivity extends ListActivity {

	private DatabaseOpenHelper mDbHelper;
	private SimpleCursorAdapter mAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		// Create a new DatabaseHelper
		mDbHelper = new DatabaseOpenHelper(this);

		// start with an empty database
		clearAll();

		// Insert records
		insertAuthors();

		// Create a cursor
		Cursor c = readAuthors();
		mAdapter = new SimpleCursorAdapter(this, R.layout.list_layout, c,
				DatabaseOpenHelper.columns, new int[] { R.id._id, R.id.name, R.id.dob, R.id.publications },
				0);

		setListAdapter(mAdapter);

		Button fixButton = (Button) findViewById(R.id.fix_button);
		fixButton.setOnClickListener(new OnClickListener() {

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

		values.put(DatabaseOpenHelper.AUTHOR_NAME, "Arthur C. Clark");
		values.put(DatabaseOpenHelper.DOB, "01/01/2017");
		values.put(DatabaseOpenHelper.PUBLICATIONS, "10");

		mDbHelper.getWritableDatabase().insert(DatabaseOpenHelper.TABLE_NAME, null, values);

		values.clear();

		values.put(DatabaseOpenHelper.AUTHOR_NAME, "William Shakespears");
		values.put(DatabaseOpenHelper.DOB, "01/01/2017");
		values.put(DatabaseOpenHelper.PUBLICATIONS, "10");
		mDbHelper.getWritableDatabase().insert(DatabaseOpenHelper.TABLE_NAME, null, values);

		values.clear();

		values.put(DatabaseOpenHelper.AUTHOR_NAME, "Terry Pratchette");
		values.put(DatabaseOpenHelper.DOB, "01/01/2017");
		values.put(DatabaseOpenHelper.PUBLICATIONS, "10");
		mDbHelper.getWritableDatabase().insert(DatabaseOpenHelper.TABLE_NAME, null, values);

		values.clear();

		values.put(DatabaseOpenHelper.AUTHOR_NAME, "Dean Swift");
		values.put(DatabaseOpenHelper.DOB, "01/01/2017");
		values.put(DatabaseOpenHelper.PUBLICATIONS, "10");
		mDbHelper.getWritableDatabase().insert(DatabaseOpenHelper.TABLE_NAME, null, values);
	}

	// Returns all author records in the database
	private Cursor readAuthors() {
		return mDbHelper.getWritableDatabase().query(DatabaseOpenHelper.TABLE_NAME,
				DatabaseOpenHelper.columns, null, new String[] {}, null, null,
				null);
	}

	// Modify the contents of the database
	private void fix() {

		// Sorry Lady Gaga :-(
		mDbHelper.getWritableDatabase().delete(DatabaseOpenHelper.TABLE_NAME,
				DatabaseOpenHelper.AUTHOR_NAME + "=?",
				new String[] { "Dean Swift" });

		// fix the Man in Black
		ContentValues values = new ContentValues();
		values.put(DatabaseOpenHelper.AUTHOR_NAME, "William Shakespear");

		mDbHelper.getWritableDatabase().update(DatabaseOpenHelper.TABLE_NAME, values,
				DatabaseOpenHelper.AUTHOR_NAME + "=?",
				new String[] { "William Shakespears" });

	}

	// Delete all records
	private void clearAll() {

		mDbHelper.getWritableDatabase().delete(DatabaseOpenHelper.TABLE_NAME, null, null);

	}

	// Close database and destroy after every close.
	@Override
	protected void onDestroy() {

		mDbHelper.getWritableDatabase().close();
		mDbHelper.deleteDatabase();

		super.onDestroy();

	}
}