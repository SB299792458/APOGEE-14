package org.dvm.apogee2k14;

import org.dvm.apogee2k14.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class EventImageAdapter extends BaseAdapter {
    private Context mContext2;

    public EventImageAdapter(Context c) {
        mContext2 = c;
    }

    public int getCount() {
        return mThumbIds2.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView2;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView2 = new ImageView(mContext2);
            imageView2.setLayoutParams(new GridView.LayoutParams(115, 115));
            
            imageView2.setPadding(8, 8, 8, 8);
        } else {
            imageView2 = (ImageView) convertView;
        }

        imageView2.setImageResource(mThumbIds2[position]);
        return imageView2;
    }

    // references to our images
    private Integer[] mThumbIds2 = {
            R.drawable.automation , R.drawable.builddesign,
            R.drawable.codesimulate, R.drawable.developdiscover,
            R.drawable.economania, R.drawable.asme, R.drawable.aic,
            R.drawable.miscellaneous, R.drawable.onlineevents,
            R.drawable.papersprojects, R.drawable.quiz,
            R.drawable.workshops
               };
}