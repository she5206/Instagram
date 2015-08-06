package com.example.mchsieh.instagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by mchsieh on 8/2/15.
 */
public class PopularPhotosAdapter extends ArrayAdapter<PopularPhotos> {

    public PopularPhotosAdapter(Context context, List<PopularPhotos> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PopularPhotos photo = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
        }
        TextView tvCaption = (TextView)convertView.findViewById(R.id.tvCaption);
        ImageView ivPhoto = (ImageView)convertView.findViewById(R.id.ivPhoto);
        tvCaption.setText(photo.caption);
        ivPhoto.setImageResource(0); // clear img every time!!!
        Picasso.with(getContext()).load(photo.img_url).into(ivPhoto);
        return convertView;
    }
}
