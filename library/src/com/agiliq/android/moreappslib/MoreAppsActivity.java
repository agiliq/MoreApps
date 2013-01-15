package com.agiliq.android.moreappslib;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MoreAppsActivity extends Activity {

    String drawableNamePrefix = "mal_agiliq_app_icon";
    int drawableResourceId;
    String stringResourcePrefix_Title = "mal_agiliq_apps_title_a";
    int stringResourceId_Title;
    String stringResourcePrefix_Package = "mal_agiliq_apps_package_a";
    int stringResourceId_Package;
    
    String hostAppPackageName;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mal_activity_more_apps);

        hostAppPackageName = getPackageName();
        
        int i;
        for(i=0; ; i++){
        	initDrawableAndStringResourceIds(i);
            if(drawableResourceId == 0 || stringResourceId_Title == 0){
                System.out.println(i);
                break;
            }
        }

        GridItemData[] gridItems = new GridItemData[i];
        for (i = 0; i < gridItems.length; i++) {
        	initDrawableAndStringResourceIds(i);
            gridItems[i] = new GridItemData(drawableResourceId, getString(stringResourceId_Title));
        }

        GridItemAdapter adapter = new GridItemAdapter(this, R.layout.mal_grid_item, gridItems);

        GridView gridView = (GridView) findViewById(R.id.mal_gridView);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
            	updateStringResourceId_Package(position);
                String packageName = getString(stringResourceId_Package);
                
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=" + packageName));
                startActivity(intent);
            }
        });
    }
    
    private void initDrawableAndStringResourceIds(int i){
    	updateDrawableResourceId(i);
        updateStringResourceId_Title(i);
        updateStringResourceId_Package(i);
    }

	private void updateDrawableResourceId(int i) {
		drawableResourceId = getResources().
                getIdentifier(drawableNamePrefix + i, "drawable", hostAppPackageName);
	}

	private void updateStringResourceId_Title(int i) {
		stringResourceId_Title = getResources().
                getIdentifier(stringResourcePrefix_Title + i, "string", hostAppPackageName);
	}

	private void updateStringResourceId_Package(int i) {
		stringResourceId_Package = getResources().
                getIdentifier(stringResourcePrefix_Package + i, "string", hostAppPackageName);
	}
}