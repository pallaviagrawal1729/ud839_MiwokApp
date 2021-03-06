/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_list);

        ArrayList<Word> list=new ArrayList<>();

        list.add(new Word(getString(R.string.Red),"weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
        list.add(new Word(getString(R.string.Green),"chokokki",R.drawable.color_green,R.raw.color_green));
        list.add(new Word(getString(R.string.Brown),"ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
        list.add(new Word(getString(R.string.Gray),"ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
        list.add(new Word(getString(R.string.Black),"kululli",R.drawable.color_black,R.raw.color_black));
        list.add(new Word(getString(R.string.White),"kelelli",R.drawable.color_white,R.raw.color_white));
        list.add(new Word(getString(R.string.DustyYellow),"ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        list.add(new Word(getString(R.string.MustardYellow),"chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        final WordAdapter itemsAdapter = new WordAdapter(this,list,R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(itemsAdapter);
        final MediaPlayer[] mediaPlayer = new MediaPlayer[1];
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word wordClicked=itemsAdapter.getItem(i);
                mediaPlayer[0] = MediaPlayer.create(ColorsActivity.this,wordClicked.getAudioId());
                mediaPlayer[0].start();
            }
        });
    }
}
