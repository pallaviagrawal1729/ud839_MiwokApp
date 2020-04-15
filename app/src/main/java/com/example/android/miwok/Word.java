package com.example.android.miwok;

import android.media.Image;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by PALLAVI on 08-04-2020.
 */

public class Word {
    private String miwokWord, defaultWord;
    private int imgResourceId;
    Word(String defau, String miwo, int id){
        miwokWord=miwo;
        defaultWord=defau;
        imgResourceId=id;
    }
    Word(String defau, String miwo){
        miwokWord=miwo;
        defaultWord=defau;
        imgResourceId=-1;
    }
    public String getDefaultTranslation(){
        return defaultWord;
    }
    public String getMiwokTranslation(){
        return miwokWord;
    }
    public int getImageResourceId(){
        return imgResourceId;
    }
}
