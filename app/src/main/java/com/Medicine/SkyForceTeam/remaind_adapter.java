package com.Medicine.SkyForceTeam;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class remaind_adapter extends RecyclerView.Adapter<remaind_adapter.remained_holder> {

    ArrayList<remainder_data> current_remainders;

    public remaind_adapter(ArrayList<remainder_data> remainders) {
        current_remainders = remainders;
    }

    @NonNull
    @Override
    public remaind_adapter.remained_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        remained_holder holder = new remained_holder(inflater.inflate(R.layout.remaind_item, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(remaind_adapter.remained_holder holder, int position) {
        remainder_data remainder = current_remainders.get(position);
        TextView cure_name = holder.cure_name;
        cure_name.setText(remainder.getCure_name());
        TextView remaind_times = holder.remaind_times;
        remaind_times.setText(remainder.getRemaind_times());


        ImageButton delete = holder.delete;


    }

    public void add_remainder(remainder_data remainder) {
        current_remainders.add(remainder);
    }

    @Override
    public int getItemCount() {
        return current_remainders.size();
    }

    public void removeItem(int position) {
        current_remainders.remove(position);
        notifyItemRemoved(position);
    }


    class remained_holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView cure_name;
        TextView remaind_times;
        Switch remaind_switch;
        ConstraintLayout layout;
        ImageButton Edit;
        ImageButton delete;
        boolean expanded;


        public remained_holder(View itemView) {
            super(itemView);
            cure_name = itemView.findViewById(R.id.cure_name);
            // remaind_switch = itemView.findViewById(R.id.remaind_switch);
            remaind_times = itemView.findViewById(R.id.remaind_times);
            layout = itemView.findViewById(R.id.moving_layout);

            itemView.setOnClickListener(this);


        }
     /*   public void animation(){
            float layout_transtion;
            float edit_transtion;
            float delete_transtion;


            if(expanded) {
                layout_transtion = -275;
                edit_transtion =-350;
                delete_transtion =-450;
                expanded=false;
            }
            else {
                layout_transtion = 20;
                edit_transtion =500;
                delete_transtion =500;

                expanded=true;
            }
            layout.animate().translationX(layout_transtion).setDuration(400);
            Edit.animate().translationX(edit_transtion).setDuration(600).setStartDelay(200).rotation(360);
            delete.animate().translationX(delete_transtion).setDuration(600).setStartDelay(200).rotation(360);


        }*/

        @Override
        public void onClick(View view) {
            // animation();
        }
    }
}