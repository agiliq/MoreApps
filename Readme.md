MoreAppsLib
===========
*This is an Android Library Project*
How to use it
-------------
Add this MoreAppsLibrary project as a dependency in the Android Application project you are implementing.  
Add the following code in your `AndroidManifest.xml`:

    <activity android:name="com.agiliq.android.moreappslib.MoreAppsActivity"
              android:label="More Apps">
    </activity>
    
Perform an `Intent` to start the `MoreAppsActivity`

    Intent intent = new Intent(this, MoreAppsActivity.class);
    startActivity(intent);  
