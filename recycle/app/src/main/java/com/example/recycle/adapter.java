package com.example.recycle;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.LinkedList;

public class adapter  extends RecyclerView.Adapter<adapter.viewholder> {
    public ArrayList<word> mliste;
    Context mcontext;
    public GradientDrawable mGradientDrawable;

    public adapter(Context context, ArrayList<word> list) {
        this.mcontext=context;
        this.mliste=list;

        mGradientDrawable=new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);
        Drawable drawable= ContextCompat.getDrawable(context,R.drawable.img_badminton);
        if(drawable!=null){mGradientDrawable.setSize(drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());}
    }




    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(mcontext).inflate(R.layout.worditem,parent,false);
        return new viewholder(mcontext,view,mGradientDrawable);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
      word mcarent=mliste.get(position);
      holder.onbind(mcarent);

    }

    @Override
    public int getItemCount() {
        return mliste.size();
    }


    public class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textView1,textView2,textView3;
        ImageView imageView;
        Context mcontextm;
        word mword;
        GradientDrawable mgd;
        public viewholder(@NonNull Context context, View itemView,GradientDrawable gradientDrawable) {
            super(itemView);
            mcontextm = context;
            imageView=( ImageView) itemView.findViewById(R.id.image);
            textView1=(TextView) itemView.findViewById(R.id.word1);
            textView2=(TextView) itemView.findViewById(R.id.word2);
            textView3=(TextView) itemView.findViewById(R.id.word3);

            mGradientDrawable=gradientDrawable;
            itemView.setOnClickListener(this);
        }
        public void onbind(word ilyes){
            textView1.setText(ilyes.getMtitle());
            textView2.setText(ilyes.getMcategory());
            textView3.setText(ilyes.getMtext());
            mword=ilyes;
            Glide.with(mcontext).load(ilyes.getIm()).placeholder(mGradientDrawable).into(imageView);
        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(mcontext,secondactivity.class);
            intent.putExtra("title",textView1.getText());
            intent.putExtra("category",textView2.getText());
            intent.putExtra("text",textView3.getText());
            intent.putExtra("imagekey",mword.getIm());
            mcontext.startActivity(intent);

        }
    }



}
