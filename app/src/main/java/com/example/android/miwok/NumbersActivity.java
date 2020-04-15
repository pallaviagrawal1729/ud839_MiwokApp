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

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_list);
        ArrayList<Word> list=new ArrayList<>();
        list.add(new Word(getString(R.string.One),"lutti",R.drawable.number_one, R.raw.number_one));
        list.add(new Word(getString(R.string.Two),"otiiko",R.drawable.number_two, R.raw.number_two));
        list.add(new Word(getString(R.string.Three),"tolookosu",R.drawable.number_three, R.raw.number_three));
        list.add(new Word(getString(R.string.Four),"oyyisa",R.drawable.number_four, R.raw.number_four));
        list.add(new Word(getString(R.string.Five),"massokka",R.drawable.number_five, R.raw.number_five));
        list.add(new Word(getString(R.string.Six),"temmokka",R.drawable.number_six, R.raw.number_six));
        list.add(new Word(getString(R.string.Seven),"kenekaku",R.drawable.number_seven, R.raw.number_seven));
        list.add(new Word(getString(R.string.Eight),"kawinta",R.drawable.number_eight, R.raw.number_eight));
        list.add(new Word(getString(R.string.Nine),"wo'e",R.drawable.number_nine, R.raw.number_nine));
        list.add(new Word(getString(R.string.Ten),"na'aacha",R.drawable.number_ten, R.raw.number_ten));
//      but this will in current state show error because by default ArrayAdapter works for only one text view and here we have
//      two in our layout, so we create our own  custom adapter
//        ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<>(this, R.layout.list_view, list);
        final WordAdapter itemsAdapter = new WordAdapter(this,list,R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(itemsAdapter);
        final MediaPlayer[] mediaPlayer = new MediaPlayer[1];
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word wordClicked=itemsAdapter.getItem(i);
                mediaPlayer[0] = MediaPlayer.create(NumbersActivity.this,wordClicked.getAudioId());
                mediaPlayer[0].start();
            }
        });
    }
}
