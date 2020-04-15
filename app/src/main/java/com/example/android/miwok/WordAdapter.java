package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PALLAVI on 09-04-2020.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    int colorForBackground;
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     */
    public WordAdapter(Activity context, ArrayList<Word> words,int colorId) {
        //we use 0 here because we do not want ArrayAdapter to set anything as resource
        //because we don't want superclass array adapter to inflate or create a view item for us
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        colorForBackground=colorId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */


    @NonNull
    @Override
    //position is the AdapterView's position that is requesting a view.
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView=convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_view,parent,false);
        }

        Word word=getItem(position);

        TextView miwokWord=(TextView)listItemView.findViewById(R.id.miwok_text_view);
        TextView defaultWord=(TextView)listItemView.findViewById(R.id.default_text_view);
        ImageView imageView=(ImageView)listItemView.findViewById(R.id.imageView);
        miwokWord.setText(word.getMiwokTranslation());
        defaultWord.setText(word.getDefaultTranslation());
        if(word.getImageResourceId()!=-1) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(word.getImageResourceId());
        }
        else
            imageView.setVisibility(View.GONE);

        View textContainer=listItemView.findViewById(R.id.linearText);
        int color= ContextCompat.getColor(getContext(),colorForBackground);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }

}
