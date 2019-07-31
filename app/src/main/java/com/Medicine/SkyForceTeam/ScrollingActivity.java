package com.Medicine.SkyForceTeam;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import java.util.ArrayList;

public class ScrollingActivity extends AppCompatActivity {
    RecyclerView remainders_viewers;
    remainder_data remainder;
    ImageButton add_remainder;    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

 //       remainders_viewers = findViewById(R.id.remainder_recycler);
        remainders_viewers.setLayoutManager(new LinearLayoutManager(this));
        remainders_viewers.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
   //     add_remainder =findViewById(R.id.addremainder_btn);
        remainder =new remainder_data("assprin","2 times",true);
        ArrayList<remainder_data> a=new ArrayList<>();

        a.add(remainder);

        final remaind_adapter adapter=new remaind_adapter(a);

        remainders_viewers.setAdapter(adapter);
        Swipe_to_delete_remainder swipe=new Swipe_to_delete_remainder(this) {
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                final int position = viewHolder.getAdapterPosition();

                adapter.removeItem(position);
            }
        };
        ItemTouchHelper touchHelper=new ItemTouchHelper(swipe);

        touchHelper.attachToRecyclerView(remainders_viewers);

        add_remainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.add_remainder(remainder);
                remainders_viewers.setAdapter(adapter);

            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
