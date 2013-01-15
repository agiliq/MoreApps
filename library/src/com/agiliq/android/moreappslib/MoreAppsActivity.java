package com.agiliq.android.moreappslib;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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
    
    String moreAppsLibPackageName;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mal_activity_more_apps);

        moreAppsLibPackageName = getPackageName();
        
        String hostAppPackagename = getIntent().getStringExtra("package");
        Log.d("", hostAppPackagename+"");
        
        boolean isHostAppPresentInList = false;
        int i;
        for(i=0;; i++){
        	initDrawableAndStringResourceIds(i);
            if(drawableResourceId == 0 || stringResourceId_Title == 0){
                System.out.println(i);
                break;
            } else {
				if (getString(stringResourceId_Package).equals(hostAppPackagename))
					isHostAppPresentInList = true;
				Log.d("",isHostAppPresentInList+"");
			}
        }
        
        final int totalApps = i;
        
        GridItemData[] gridItems;
        if(!isHostAppPresentInList){
        	gridItems = new GridItemData[totalApps];
        	for (i = 0; i < gridItems.length; i++) {
            	initDrawableAndStringResourceIds(i);
                gridItems[i] = new GridItemData(drawableResourceId, getString(stringResourceId_Title));
            }
        } else{
        	gridItems = new GridItemData[totalApps-1];
        	int j;
        	for (i = 0, j=0; i < gridItems.length && j < totalApps; j++) {
            	initDrawableAndStringResourceIds(j);
            	if (getString(stringResourceId_Package).equals(hostAppPackagename)){
            		continue;
            	}	
                gridItems[i] = new GridItemData(drawableResourceId, getString(stringResourceId_Title));
                i++;
            }
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
                getIdentifier(drawableNamePrefix + i, "drawable", moreAppsLibPackageName);
	}

	private void updateStringResourceId_Title(int i) {
		stringResourceId_Title = getResources().
                getIdentifier(stringResourcePrefix_Title + i, "string", moreAppsLibPackageName);
	}

	private void updateStringResourceId_Package(int i) {
		stringResourceId_Package = getResources().
                getIdentifier(stringResourcePrefix_Package + i, "string", moreAppsLibPackageName);
	}
}