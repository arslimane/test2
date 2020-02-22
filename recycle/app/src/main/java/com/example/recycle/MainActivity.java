package com.example.recycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
   public ArrayList<word> linkedList ;
    adapter ada;
    int fromm,tom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("ilyes","yesyesyesyesyesyesyesyes 00000000");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ilyes","yesyesyesyesyesyesyesyes0000001");

        final ArrayList<word> linkedList = new ArrayList<word>();
        String[] title =getResources().getStringArray(R.array.title);
        String[] text=getResources().getStringArray(R.array.text);
        String[] category=getResources().getStringArray(R.array.category);
        TypedArray image =getResources().obtainTypedArray(R.array.sports_images);

        int counter;
         RecyclerView mreclview;

        Log.d("ilyes","yesyesyesyesyesyesyesyes1");
        for (counter=0;counter<=4;counter++) {
            linkedList.add(new word(title[counter],category[counter],text[counter],image.getResourceId(counter,0)));
        }
        mreclview=(RecyclerView) findViewById(R.id.rycview);
        Log.d("ilyes","yesyesyesyesyesyesyesyes2");

        ada=new adapter(this,linkedList);
        Log.d("ilyes","yesyesyesyesyesyesyesyes3");
        mreclview.setAdapter(ada);
        Log.d("ilyes","yesyesyesyesyesyesyesyes4");
        mreclview.setLayoutManager(new GridLayoutManager(this,2));
        Log.d("ilyes","yesyesyesyesyesyesyesyes5");
        ItemTouchHelper helper=new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT|ItemTouchHelper.DOWN|ItemTouchHelper.UP,0) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from =viewHolder.getAdapterPosition();
                fromm=from;
                int to=target.getAdapterPosition();
                tom=to;
                Collections.swap(linkedList,from,to);
                ada.notifyItemMoved(from,to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                linkedList.remove(viewHolder.getAdapterPosition());
              ada.notifyItemRemoved(viewHolder.getAdapterPosition());

            }

        });
        helper.attachToRecyclerView(mreclview);
    }
}
