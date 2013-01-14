package com.agiliq.android.moreappslib;

public class GridItemData {
    private int showcasedAppIconDrawableResource;
    private String showcasedAppName;

    public GridItemData(int showcasedAppIconDrawableResource, String showcasedAppName) {
        this.showcasedAppIconDrawableResource = showcasedAppIconDrawableResource;
        this.showcasedAppName = showcasedAppName;
    }

    public int getShowcasedAppIconDrawableResource() {
        return showcasedAppIconDrawableResource;
    }

    public String getShowcasedAppName() {
        return showcasedAppName;
    }
}
