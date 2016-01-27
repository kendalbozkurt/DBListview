package com.example.el_tayr.listviewlistactivity;

import android.app.Activity;
import android.app.ListActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class MainActivity extends Activity {
 /*  private int[] textureArrayWin = {
            R.mipmap.albania,R.mipmap.andorra,R.mipmap.armenia,R.mipmap.austria,R.mipmap.belarus,R.mipmap.belgium,
            R.mipmap.bosniaherzegovina,R.mipmap.bulgaria,R.mipmap.croatia,R.mipmap.cyprus,R.mipmap.czechrepublic,
            R.mipmap.denmark,R.mipmap.estonia,R.mipmap.finland,R.mipmap.france,
            R.mipmap.georgia,R.mipmap.germany,R.mipmap.greece,R.mipmap.hungary,R.mipmap.iceland,R.mipmap.ireland,
            R.mipmap.italy,R.mipmap.kazakhstan,R.mipmap.kosovo,R.mipmap.latvia,R.mipmap.liechtenshein,R.mipmap.lithuania,
            R.mipmap.luxembourg,R.mipmap.macedonia,R.mipmap.malta,R.mipmap.moldova,R.mipmap.monaco,R.mipmap.montenegro,
            R.mipmap.netherlands,R.mipmap.norway,R.mipmap.poland,R.mipmap.portugal,R.mipmap.romania,
            R.mipmap.russia,R.mipmap.sanmarino,R.mipmap.serbia,R.mipmap.slovakia,R.mipmap.slovenia,R.mipmap.spain,
            R.mipmap.sweden,R.mipmap.switzerland,R.mipmap.turkey,R.mipmap.ukraine,R.mipmap.unitedkingdom,
            R.mipmap.vaticancity
    };
    private String[] countrynames={"Albania","Andorra","Armenia",
           "Austria","Belarus", "Belgium", "Bosnia and Herzegovina", "Bulgaria","Croatia","Cyprus",
            "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Georgia", "Germany", "Greece", "Hungary", "Iceland", "Ireland",
            "Italy", "Kazakhstan","Kosovo", "Latvia", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Malta", "Moldova",
            "Monaco", "Montenegro", "Netherlands", "Norway", "Poland", "Portugal", "Romania", "Russia", "San Marino",
            "Serbia", "Slovakia", "Slovenia", "Spain", "Sweden", "Switzerland", "Turkey", "Ukraine", "United Kingdom",
            "Vatican City"
    };*/

    List<String> countries;
   List<Bitmap> countriesflag ;
    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listemiz = (ListView) findViewById(R.id.listView);
        CDataBase cDB = new CDataBase(getApplicationContext());
      /*  for(int i=0;i<textureArrayWin.length;i++)
        {
            Bitmap image = BitmapFactory.decodeResource(getResources(), textureArrayWin[i]);


            ByteArrayOutputStream out = new ByteArrayOutputStream();

            image.compress(Bitmap.CompressFormat.PNG, 100, out);

            cDB.addCountry(countrynames[i],countrynames[i], out.toByteArray(), "falanfilan");


        }*/
        countries=cDB.getCountryName();
        countriesflag=cDB.getCountryFlag();
        OzelAdapter adaptorumuz=new OzelAdapter(this,countries,countriesflag);
        listemiz.setAdapter(adaptorumuz);
        listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Country name=" + listemiz.getItemAtPosition(position), Toast.LENGTH_LONG).show();
            }
        });
        cDB.close();

    }




}
