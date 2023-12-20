package com.example.dbcrud;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<String> {
    Context context;
    List<String> ClubName;
    List<String> ClubAddress;
    List<String> ClubTypes;
    List<String> ClubFee;


    public MyListAdapter(Context context, List<String> ClubName, List<String> ClubAddress, List<String> ClubTypes,
                         List<String> ClubFee) {
        super(context,R.layout.activity_club_list,ClubAddress);
        this.context=context;
        this.ClubAddress=ClubAddress;
        this.ClubName=ClubName;
        this.ClubTypes=ClubTypes;
        this.ClubFee=ClubFee;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v=((Activity)context).getLayoutInflater().inflate(R.layout.activity_card_layout,null);
        TextView tvName= v.findViewById(R.id.tvClubName);
        tvName.setText(ClubName.get(position).toString());

        TextView tvType= v.findViewById(R.id.tvClubType);
        tvType.setText(ClubTypes.get(position).toString());

        TextView tvAddress= v.findViewById(R.id.tvClubAddress);
        tvAddress.setText(ClubAddress.get(position).toString());

        TextView tvFees= v.findViewById(R.id.tvClubFees);
        tvFees.setText(ClubFee.get(position).toString());

        return v;
    }


}

