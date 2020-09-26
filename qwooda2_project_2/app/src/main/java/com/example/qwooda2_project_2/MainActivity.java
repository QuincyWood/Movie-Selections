package com.example.qwooda2_project_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String [] movies = {"Joker", "Glass", "Sonic", "Spider-man", "Cats", "WonderWoman"};
    String [] years = {"October 4, 2019", "January 7, 2019", "February 14, 2020", "December 14, 2018 ", "December 20, 2019", "June 2, 2017 "};
    int [] image= {R.drawable.joker, R.drawable.glass, R.drawable.sonic, R.drawable.spiderman, R.drawable.cats, R.drawable.ww};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.list_view);

        MyAdapter adapter = new MyAdapter(this, movies, years, image);
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

    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String[] rTitle;
        String[] rYear;
        int[] rImage;

        MyAdapter(Context c, String[] title, String[] year, int[] images) {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_a1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.Joker:
                Intent browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.imdb.com/title/tt7286456/"));
                startActivity(browserintent);
            case R.id.Glass:

                Intent browserintent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.imdb.com/title/tt6823368/?ref_=nv_sr_srsg_0"));
                startActivity(browserintent2);

            case R.id.Sonic:
                Intent browserintent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.imdb.com/title/tt3794354/"));
                startActivity(browserintent3);
            case R.id.Spiderman:

                Intent browserintent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.imdb.com/title/tt4633694/?ref_=nv_sr_srsg_0"));
                startActivity(browserintent4);
            case R.id.Cats:
                Intent browserintent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.imdb.com/title/tt5697572/?ref_=nv_sr_srsg_0"));
                startActivity(browserintent5);
            case R.id.WonderWoman:

                Intent browserintent6 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.imdb.com/title/tt0451279/?ref_=nv_sr_srsg_3"));
                startActivity(browserintent6);

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}


