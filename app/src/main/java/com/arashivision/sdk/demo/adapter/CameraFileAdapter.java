package com.arashivision.sdk.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.arashivision.insta360.basemedia.model.CameraFile;
import com.arashivision.sdk.demo.R;
import com.arashivision.sdk.demo.widget.CameraFileItemView;

import java.util.List;

public class CameraFileAdapter extends BaseAdapter {

    private List<CameraFile> mFileList;
    private LayoutInflater mInflater;

    public CameraFileAdapter(Context context, List<CameraFile> fileList) {
        mFileList = fileList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mFileList.size();
    }

    @Override
    public Object getItem(int position) {
        return mFileList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CameraFileItemView itemView;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_camera_file, parent, false);
            itemView = new CameraFileItemView(convertView);
            convertView.setTag(itemView);
        } else {
            itemView = (CameraFileItemView) convertView.getTag();
        }

        CameraFile file = mFileList.get(position);
        itemView.bind(file);

        return convertView;
    }
}