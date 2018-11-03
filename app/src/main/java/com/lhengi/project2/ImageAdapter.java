package com.lhengi.project2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter
{

    private Context mContext;
    private static LayoutInflater inflater;
    private Data[] data;

    public ImageAdapter(Context c, Data[] data)
    {
        mContext = c;
        inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
    }

    public int getCount() {
        return data.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view;


        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            view = new View(mContext);
            view = inflater.inflate(R.layout.gridcell,null);
//            TextView textView = (TextView) view.findViewById(R.id.carName);
//            ImageView imageView = (ImageView) view.findViewById(R.id.imageCell);
//
//            textView.setText(data[position].name);
//            imageView.setImageResource(data[position].imgResource);
            //textView.setText(names[position]);
            //imageView.setImageResource(mThumbIds[position]);


        } else {

            view = (View) convertView;
        }

        TextView textView = (TextView) view.findViewById(R.id.carName);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageCell);

        textView.setText(data[position].name);
        imageView.setImageResource(data[position].lowImg); // using low res img for grid cell


        return view;
    }

}
