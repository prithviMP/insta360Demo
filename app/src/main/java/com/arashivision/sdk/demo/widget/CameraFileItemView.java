package com.arashivision.sdk.demo.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arashivision.sdk.demo.R;
import com.arashivision.sdk.demo.model.CameraFile;

public class CameraFileItemView {
    private TextView mTvFileName;
    private ImageView mIvFileType;

    public CameraFileItemView(View view) {
        mTvFileName = view.findViewById(R.id.tv_file_name);
        mIvFileType = view.findViewById(R.id.iv_file_type);
    }

    public void bind(CameraFile cameraFile) {
        mTvFileName.setText(cameraFile.getFileName());
        if (cameraFile.isVideo()) {
            mIvFileType.setImageResource(R.drawable.ic_video);
        } else {
            mIvFileType.setImageResource(R.drawable.ic_photo);
        }
    }
}