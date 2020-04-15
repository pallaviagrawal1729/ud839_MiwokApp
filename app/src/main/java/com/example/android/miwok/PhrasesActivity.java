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

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_list);

        ArrayList<Word> list=new ArrayList<>();

        list.add(new Word(getString(R.string.Where_are_you_going),"minto wuksus", R.raw.phrase_where_are_you_going));
        list.add(new Word(getString(R.string.What_is_your_name),"tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        list.add(new Word(getString(R.string.My_name_is),"oyaaset...", R.raw.phrase_my_name_is));
        list.add(new Word(getString(R.string.How_are_you_feeling),"michәksәs?", R.raw.phrase_how_are_you_feeling));
        list.add(new Word(getString(R.string.I_am_feeling_good),"kuchi achit", R.raw.phrase_im_feeling_good));
        list.add(new Word(getString(R.string.Are_you_coming),"әәnәs'aa?", R.raw.phrase_are_you_coming));
        list.add(new Word(getString(R.string.Yes_I_am_coming),"hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        list.add(new Word(getString(R.string.I_am_coming),"әәnәm", R.raw.phrase_im_coming));
        list.add(new Word(getString(R.string.Let_us_go),"yoowutis", R.raw.phrase_lets_go));
        list.add(new Word(getString(R.string.Come_here),"әnni'nem", R.raw.phrase_come_here));
        final WordAdapter itemsAdapter = new WordAdapter(this,list,R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(itemsAdapter);
        final MediaPlayer[] mediaPlayer = new MediaPlayer[1];
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word wordClicked=itemsAdapter.getItem(i);
                mediaPlayer[0] = MediaPlayer.create(PhrasesActivity.this,wordClicked.getAudioId());
                mediaPlayer[0].start();
            }
        });
    }
}
