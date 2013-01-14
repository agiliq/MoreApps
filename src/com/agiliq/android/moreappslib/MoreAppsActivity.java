package com.agiliq.android.moreappslib;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class MoreAppsActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mal_activity_more_apps);

        GridItemData[] gridItems = new GridItemData[10];
        for (int i = 0; i < gridItems.length; i++) {
            gridItems[i] = new GridItemData(R.drawable.mal_showcased_application_icon_sample, "Sample Name");
        }

        GridItemAdapter adapter = new GridItemAdapter(this, R.layout.mal_grid_item, gridItems);

        GridView gridView = (GridView) findViewById(R.id.mal_gridView);
        gridView.setAdapter(adapter);
    }
}