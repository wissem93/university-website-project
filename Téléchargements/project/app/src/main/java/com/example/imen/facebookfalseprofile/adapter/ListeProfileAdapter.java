package com.example.imen.facebookfalseprofile.adapter;

/**
 * Created by imen on 16/09/2016.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.imen.facebookfalseprofile.entity.User;
import com.microsoft.projectoxford.face.samples.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListeProfileAdapter extends ArrayAdapter<User> {

    private Context activity;
    private List<User> profileList;

    public ListeProfileAdapter(Context context, int resource, List<User> objects) {
        super(context,resource,objects);
        this.activity = context;
        this.profileList = objects;
    }

    @Override
    public int getCount() {
        return profileList.size();
    }

    @Override
    public User getItem(int position) {
        return profileList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        // If holder not exist then locate all view from UI file.
        if (convertView == null) {
            // inflate UI from XML file
            convertView = inflater.inflate(R.layout.item_profile, parent, false);
            // get all UI view
            holder = new ViewHolder(convertView);
            // set tag for holder
            convertView.setTag(holder);
        } else {
            // if holder created, get tag from view
            holder = (ViewHolder) convertView.getTag();
        }

        holder.friendName.setText(getItem(position).getFullName());


        Picasso.with(getContext()).load(profileList.get(position).getPhoto()).into(holder.imageView);

        return convertView;
    }

    private class ViewHolder {
        private ImageView imageView;
        private TextView friendName;

        public ViewHolder(View v) {
            imageView = (ImageView) v.findViewById(R.id.profile_photo);
            friendName = (TextView) v.findViewById(R.id.name_porfile);
        }
    }
}