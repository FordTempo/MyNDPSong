package sg.edu.rp.c346.songsaver;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    // Start version with 1
    // increment by 1 whenever db schema changes.
    private static final int DATABASE_VER = 1;
    // Filename of the database
    private static final String DATABASE_NAME = "song.db";
    private static final String TABLE_TASK = "song";
    private static final String COLUMN_ID = "_id";

    private static final String COLUMN_Title = "title";
    private static final String COLUMN_Singer = "singers";

    private static final String COLUMN_Year = "year";
    private static final String COLUMN_Stars = "stars";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE " + TABLE_TASK + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_Title + " TEXT,"
                + COLUMN_Singer + " TEXT,"
                + COLUMN_Year + " INTEGER,"
                + COLUMN_Stars + " INTEGER )";
        db.execSQL(createTableSql);
        Log.i("info", "created tables");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASK);
        // Create table(s) again
        onCreate(db);


    }
    public void insertTask(String title, String singer, int year, int star ){

        // Get an instance of the database for writing
        SQLiteDatabase db = this.getWritableDatabase();
        // We use ContentValues object to store the values for
        //  the db operation
        ContentValues values = new ContentValues();
        // Store the column name as key and the description as value
        values.put(COLUMN_Title,title);
        // Store the column name as key and the date as value
        values.put(COLUMN_Singer, singer);
        values.put(COLUMN_Year, year);
        values.put(COLUMN_Stars, star);
        // Insert the row into the TABLE_TASK
        db.insert(TABLE_TASK, null, values);
        // Close the database connection
        db.close();
    }

    public ArrayList<String> getTaskContent() {
        // Create an ArrayList that holds String objects
        ArrayList<String> tasks = new ArrayList<String>();
        // Get the instance of database to read
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID, COLUMN_Title, COLUMN_Singer,COLUMN_Year,COLUMN_Stars};
        // Run the query and get back the Cursor object
        Cursor cursor = db.query(TABLE_TASK, columns, null, null, null, null, null, null);

        // moveToFirst() moves to first row, null if no records
        if (cursor.moveToFirst()) {
            // Loop while moveToNext() points to next row
            //  and returns true; moveToNext() returns false
            //  when no more next row to move to
            do {
                // Add the task content to the ArrayList object
                //  getString(0) retrieves first column data
                //  getString(1) return second column data
                //  getInt(0) if data is an integer value
                tasks.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        // Close connection
        cursor.close();
        db.close();

        return tasks;
    }

    public ArrayList<Song> getTasks() {
        ArrayList<Song> tasks = new ArrayList<Song>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_ID, COLUMN_Title, COLUMN_Singer,COLUMN_Year,COLUMN_Stars};
        Cursor cursor = db.query(TABLE_TASK, columns, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String singer = cursor.getString(2);
                int year = cursor.getInt(3);
                int star = cursor.getInt(4);
                Song obj = new Song(id, title, singer,year,star);
                tasks.add(obj);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return tasks;
    }

}