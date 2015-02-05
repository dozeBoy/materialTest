package com.alexvasinca.testdoople;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Alex Vasinca on 02/05/2015.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    /*
    * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
    * It means that the viewHolder will represent my icon and the text next to it in the NavDrawer.
    * */


    private LayoutInflater inflater;

    public MyAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //every time a new row is to be displayed
        //the onCreateViewHolder will be called

        //The Layout Inflater converts XML appearance definition into View objects
        //It's a time consuming operation as it's recursively convert all XML children into objects
        inflater.inflate(R.layout.custom_row, viewGroup, false);
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    /*
    *  The viewHolder's purpose is find things once and then cast them
    *  because findById and always creating new objects are expensive operations
    *  that mai affect performance of the device.
    * */
    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
