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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_list);

        ArrayList<Word> list=new ArrayList<>();

        list.add(new Word(getString(R.string.Father),"әpә",R.drawable.family_father));
        list.add(new Word(getString(R.string.Mother),"әṭa",R.drawable.family_mother));
        list.add(new Word(getString(R.string.Son),"angsi",R.drawable.family_son));
        list.add(new Word(getString(R.string.Daughter),"tune",R.drawable.family_daughter));
        list.add(new Word(getString(R.string.OlderBrother),"taachi",R.drawable.family_older_brother));
        list.add(new Word(getString(R.string.YoungerBrother),"chalitti",R.drawable.family_younger_brother));
        list.add(new Word(getString(R.string.OlderSister),"teṭe",R.drawable.family_older_sister));
        list.add(new Word(getString(R.string.YoungerSister),"kolliti",R.drawable.family_younger_sister));
        list.add(new Word(getString(R.string.Grandmother),"ama",R.drawable.family_grandmother));
        list.add(new Word(getString(R.string.Grandfather),"paapa",R.drawable.family_grandfather));


        WordAdapter itemsAdapter = new WordAdapter(this,list,R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(itemsAdapter);
    }
}
