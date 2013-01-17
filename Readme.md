MoreAppsLib
===========
*This is an Android Library Project*
How to use it
-------------
Add this MoreAppsLibrary project(<b>library</b>) as a dependency in the Android Application project you are implementing.  
Add the following code in your `AndroidManifest.xml`:

    <activity android:name="com.agiliq.android.moreappslib.MoreAppsActivity"
              android:label="More Apps">
    </activity>
    
Perform an `Intent` to start the `MoreAppsActivity`; make sure to `putExtra("package", getPackageName());`, this ensures that if the your app is in the list of apps being showcased then your app won't be shown.

    Intent intent = new Intent(this, MoreAppsActivity.class);
    intent.putExtra("package", getPackageName());
    startActivity(intent);

You can refer the **sample** code for a live example.

Where does the data come from
-----------------------------
The data here is the list of *icons*, the *titles* and the *package names* of the apps.  
All we do is update the `query` field in `GetAppsDetails` class of the **GetAppsDetails** java app and run this app to get the *icons* and a string resource *xml* file.  
This xml file contains the titles and package names.  
*Note: The `query` string would be the same as what you enter in the search box on Google Play Store.*

#### Where is the data stored
After you run the java app the data will be saved in the root of that java project.

#### How to use this data
Move the generated data into the **library**,  
Move all the icons into *res/drawable/* and the xml file into *res/values/*.
