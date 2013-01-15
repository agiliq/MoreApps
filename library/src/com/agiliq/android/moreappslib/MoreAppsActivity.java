package com.agiliq.android.moreappslib;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class MoreAppsActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mal_activity_more_apps);

        String drawableNamePrefix = "mal_agiliq_app_icon";
        String stringResourcePrefix = "mal_agiliq_apps_title_a";
        int i;
        for(i=0; ; i++){
            int drawableResourceId = getResources().
                    getIdentifier(drawableNamePrefix + i, "drawable", getPackageName());
            int stringResourceId = getResources().
                    getIdentifier(stringResourcePrefix + i, "string", getPackageName());
            if(drawableResourceId == 0 || stringResourceId == 0){
                System.out.println(i);
                break;
            }
        }

        GridItemData[] gridItems = new GridItemData[i];
        for (i = 0; i < gridItems.length; i++) {
            int drawableResourceId = getResources().
                    getIdentifier(drawableNamePrefix + i, "drawable", getPackageName());
            int stringResourceId = getResources().
                    getIdentifier(stringResourcePrefix + i, "string", getPackageName());

            gridItems[i] = new GridItemData(drawableResourceId,
                    getResources().getString(stringResourceId));
        }

        GridItemAdapter adapter = new GridItemAdapter(this, R.layout.mal_grid_item, gridItems);

        GridView gridView = (GridView) findViewById(R.id.mal_gridView);
        gridView.setAdapter(adapter);
    }
}