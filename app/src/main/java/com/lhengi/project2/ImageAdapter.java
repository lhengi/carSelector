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
        return mThumbIds.length;
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
            TextView textView = (TextView) view.findViewById(R.id.carName);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageCell);

            textView.setText(data[position].name);
            imageView.setImageResource(data[position].imgResource);
            //textView.setText(names[position]);
            //imageView.setImageResource(mThumbIds[position]);


        } else {

            view = (View) convertView;
        }



        return view;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.tesla3,
            R.drawable.tesla_x,
            R.drawable.bmw_i8,
            R.drawable.cadillac_escalade,
            R.drawable.honda_piolt,
            R.drawable.jeep_wrangler,
            R.drawable.mercedes_s,
            R.drawable.subrau_sscent,
            R.drawable.toyota_camry,
            R.drawable.vw_toureg
    };

    private String[] names = {
            "Tesla Model 3",
            "Tesla Model X",
            "BMW i8",
            "Cadillac Escalade",
            "Honda Piolt",
            "Jeep Wrangler",
            "Mercedes-Benz S",
            "Subrau Ascent",
            "Toyota Camry",
            "VW Toureg"
    };
}
