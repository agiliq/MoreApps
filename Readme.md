MoreAppsLib
===========
*This is an Android Library Project*
How to use it
-------------
Add this MoreAppsLibrary project(**library**) as a dependency in the Android Application project you are implementing.  
Add the following code in your `AndroidManifest.xml`:

    <activity android:name="com.agiliq.android.moreappslib.MoreAppsActivity"
              android:label="More Apps">
    </activity>
    
Perform an `Intent` to start the `MoreAppsActivity`

    Intent intent = new Intent(this, MoreAppsActivity.class);
    startActivity(intent);

You can refer the **sample** code for a live example.

Where does the data come from
-----------------------------
The data here is the list of *icons*, the *titles* and the *package names* of the apps.  
All we do is run the **GetAppsDetails** java app and get the *icons* and a string resource *xml* file.  
This xml file contains the titles and package names.

#### Where is the data stored
After you run the java app the data will be saved in the root of that java project.

#### How to use this data
Move the generated data into the **library**,  
Move all the icons into *res/drawable/* and the xml file into *res/values/*.
