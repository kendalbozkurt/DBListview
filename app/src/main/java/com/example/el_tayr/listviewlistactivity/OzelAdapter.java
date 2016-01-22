package com.example.el_tayr.listviewlistactivity;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by El-tayr on 19.12.2015.
 */
public class OzelAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    List<String> countries;
    List<Bitmap> countriesflag ;
    public OzelAdapter(Activity activity,List<String> countries,List<Bitmap> bm) {
        //XML'i alip View'a cevirecek inflater'i örnekleyelim
        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        //gosterilecek listeyi de alalim
        this.countries=countries;
        this.countriesflag=bm;

    }


    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public Object getItem(int position) {
        return countries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View satirView;

        satirView = mInflater.inflate(R.layout.list_view_item, null);
        TextView textView =
                (TextView) satirView.findViewById(R.id.countryname);

       ImageView imageView =
                (ImageView) satirView.findViewById(R.id.flag);

        textView.setText(countries.get(position));


        imageView.setImageBitmap(countriesflag.get(position));


        return satirView;
    }



}
