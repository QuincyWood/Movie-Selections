package com.example.qwooda2_project2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mymovie.R;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private  String[] movies = {"joker", "glass", "sonic", "spiderman", "cats", "ww"};
    private String[] years = {"October 4, 2019", "January 7, 2019", "February 14, 2020", "December 14, 2018 ", "December 20, 2019", "June 2, 2017 "};
    int [] image= {R.drawable.joker, R.drawable.glass, R.drawable.sonic, R.drawable.spiderman, R.drawable.cats, R.drawable.ww};

    public MainActivity(ListView listView) {
        this.listView = listView;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView.findViewById(R.id.list_view);

        myAdapter adapter = new myAdapter(this, movies, years, image);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(MainActivity.this, "Joker", Toast.LENGTH_SHORT).show();
                }
                if(position == 0){
                    Toast.makeText(MainActivity.this, "Glass", Toast.LENGTH_SHORT).show();
                }
                if(position == 0){
                    Toast.makeText(MainActivity.this, "sonic", Toast.LENGTH_SHORT).show();
                }
                if(position == 0){
                    Toast.makeText(MainActivity.this, "spiderman", Toast.LENGTH_SHORT).show();
                }
                if(position == 0){
                    Toast.makeText(MainActivity.this, "cats", Toast.LENGTH_SHORT).show();
                }
                if(position == 0){
                    Toast.makeText(MainActivity.this, "ww", Toast.LENGTH_SHORT).show();
                }
            }
        });
       // Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
       // mToolbar.setTitle(getResources().getString(R.string.app_name));
        //ListView mListView = (ListView) findViewById(R.id.list_view);
//        MyAdapter myAdapter = new MyAdapter(MainActivity.this, movies, image);
//        mListView.setAdapter(myAdapter);
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent mIntent = new Intent(MainActivity.this, MyAdapter.class);
//                mIntent.putExtra("Movies", movies[i]);
//                mIntent.putExtra("year", years[i]);
//                mIntent.putExtra("image", image[i]);
//                startActivity(mIntent);
//            }
//        });
   }

   class myAdapter extends ArrayAdapter<String> {

        Context context;
        String[] rTitle;
        String[] rYear;
        int[] rImage;

       myAdapter(Context c, String[] title, String[] year, int[] images) {
           super(c, R.layout.row, R.id.textView, title);
           this.context = c;
           this.rTitle = title;
           this.rYear = year;
           this.rImage = images;
       }

       @NonNull
       @Override
       public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
           LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           View row = layoutInflater.inflate(R.layout.row, parent,false);
           ImageView myimage = row.findViewById(R.id.image);
           TextView mytitle = row.findViewById(R.id.textView);
           TextView myyear = row.findViewById(R.id.textView2);

           myimage.setImageResource(rImage[position]);
           mytitle.setText(rTitle[position]);
           myyear.setText(rYear[position]);

           return row;
       }
   }

    }


