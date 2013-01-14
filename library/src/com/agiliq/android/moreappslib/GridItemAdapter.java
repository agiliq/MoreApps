package com.agiliq.android.moreappslib;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridItemAdapter extends ArrayAdapter<GridItemData> {
    private final Context context;
    private final int gridCellLayoutResource;
    private final GridItemData[] gridItems;

    public GridItemAdapter(Context context, int gridCellLayoutResource, GridItemData[] gridItems) {
        super(context, gridCellLayoutResource, gridItems);
        this.context = context;
        this.gridCellLayoutResource = gridCellLayoutResource;
        this.gridItems = gridItems;
    }

    @Override
    public View getView(int position, View gridCell, ViewGroup parent) {
        GridItemHolder holder;

        if (gridCell != null) {
            holder = (GridItemHolder) gridCell.getTag();
        } else {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            gridCell = inflater.inflate(gridCellLayoutResource, parent, false);

            holder = new GridItemHolder();
            holder.imageView = (ImageView) gridCell.findViewById(R.id.mal_imageView);
            holder.textView = (TextView) gridCell.findViewById(R.id.mal_textView);

            gridCell.setTag(holder);
        }

        GridItemData gridItem = gridItems[position];
        holder.imageView.setImageResource(gridItem.getShowcasedAppIconDrawableResource());
        holder.textView.setText(gridItem.getShowcasedAppName());

        return gridCell;
    }

    static class GridItemHolder {
        ImageView imageView;
        TextView textView;
    }
}
