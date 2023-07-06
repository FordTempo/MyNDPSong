package sg.edu.rp.c346.songsaver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnShowList;

    EditText EditTitle, EditSinger, EditYear;

    ListView lvResult;

    TextView tvResults;

    RadioGroup Rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnlist);
        EditTitle = findViewById(R.id.EditTitle);
        EditSinger = findViewById(R.id.EditSinger);
        EditYear = findViewById(R.id.EditYear);
        lvResult = findViewById(R.id.lv);
        tvResults = findViewById(R.id.tvResults);
        Rating = findViewById(R.id.RadioGroupRating);

        ArrayList<String> songList = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, songList);
        lvResult.setAdapter(adapter);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);


            }
        });


                btnShowList.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Create the DBHelper object, passing in the
                        // activity's Context
                        DBHelper db = new DBHelper(MainActivity.this);
                        int checkedRadioId = Rating.getCheckedRadioButtonId();
                        if (checkedRadioId == R.id.radioButton1) {
                            ArrayList<String> data = db.getTaskContent();
                            db.insertTask(EditTitle.getText().toString(), EditSinger.getText().toString(), Integer.parseInt(EditYear.getText().toString()), 1);
                            db.close();

                            String txt = "";
                            for (int i = 0; i < data.size(); i++) {
                                Log.d("Database Content", i + ". " + data.get(i));
                                txt += i + ". " + data.get(i) + "\n";
                            }
                            tvResults.setText(txt);


                            ArrayList<Song> dataList = db.getTasks();
                            db.close();
                            songList.clear();
                            for (int i = 0; i < data.size(); i++) {
                                String song = String.valueOf(dataList.get(i));
                                songList.add(song);
                            }
                            adapter.notifyDataSetChanged();


                        } else if (checkedRadioId == R.id.radioButton2) {
                            ArrayList<String> data = db.getTaskContent();
                            db.insertTask(EditTitle.getText().toString(), EditSinger.getText().toString(), Integer.parseInt(EditYear.getText().toString()), 2);
                            db.close();

                            String txt = "";
                            for (int i = 0; i < data.size(); i++) {
                                Log.d("Database Content", i + ". " + data.get(i));
                                txt += i + ". " + data.get(i) + "\n";
                            }
                            tvResults.setText(txt);


                            ArrayList<Song> dataList = db.getTasks();
                            db.close();
                            songList.clear();
                            for (int i = 0; i < data.size(); i++) {
                                String task = String.valueOf(dataList.get(i));
                                songList.add(task);
                            }
                            adapter.notifyDataSetChanged();

                        } else if (checkedRadioId == R.id.radioButton3) {
                            ArrayList<String> data = db.getTaskContent();
                            db.insertTask(EditTitle.getText().toString(), EditSinger.getText().toString(), Integer.parseInt(EditYear.getText().toString()), 3);
                            db.close();

                            String txt = "";
                            for (int i = 0; i < data.size(); i++) {
                                Log.d("Database Content", i + ". " + data.get(i));
                                txt += i + ". " + data.get(i) + "\n";
                            }
                            tvResults.setText(txt);


                            ArrayList<Song> dataList = db.getTasks();
                            db.close();
                            songList.clear();
                            for (int i = 0; i < data.size(); i++) {
                                String task = String.valueOf(dataList.get(i));
                                songList.add(task);
                            }
                            adapter.notifyDataSetChanged();

                        } else if (checkedRadioId == R.id.radioButton4) {
                            ArrayList<String> data = db.getTaskContent();
                            db.insertTask(EditTitle.getText().toString(), EditSinger.getText().toString(), Integer.parseInt(EditYear.getText().toString()), 4);
                            db.close();

                            String txt = "";
                            for (int i = 0; i < data.size(); i++) {
                                Log.d("Database Content", i + ". " + data.get(i));
                                txt += i + ". " + data.get(i) + "\n";
                            }
                            tvResults.setText(txt);


                            ArrayList<Song> dataList = db.getTasks();
                            db.close();
                            songList.clear();
                            for (int i = 0; i < data.size(); i++) {
                                String task = String.valueOf(dataList.get(i));
                                songList.add(task);
                            }
                            adapter.notifyDataSetChanged();

                        } else if (checkedRadioId == R.id.radioButton5) {
                            ArrayList<String> data = db.getTaskContent();
                            db.insertTask(EditTitle.getText().toString(), EditSinger.getText().toString(), Integer.parseInt(EditYear.getText().toString()), 5);
                            db.close();

                            String txt = "";
                            for (int i = 0; i < data.size(); i++) {
                                Log.d("Database Content", i + ". " + data.get(i));
                                txt += i + ". " + data.get(i) + "\n";
                            }
                            tvResults.setText(txt);


                            ArrayList<Song> dataList = db.getTasks();
                            db.close();
                            songList.clear();
                            for (int i = 0; i < data.size(); i++) {
                                String task = String.valueOf(dataList.get(i));
                                songList.add(task);
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
    }
}




