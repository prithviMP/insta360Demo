package com.arashivision.sdk.demo.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.arashivision.sdk.demo.R;
import com.arashivision.sdk.demo.adapter.CameraFileAdapter;
import com.arashivision.sdk.demo.model.CameraFile;

import java.util.ArrayList;
import java.util.List;

public class MediaFilesActivity extends BaseActivity {

    private ListView mListView;
    private CameraFileAdapter mAdapter;
    private List<CameraFile> mCameraFileList = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_files);

        mListView = findViewById(R.id.list_view_media_files);
        if (mListView != null) {
            mAdapter = new CameraFileAdapter(this, mCameraFileList);
            mListView.setAdapter(mAdapter);
        } else {
            Log.e("MediaFilesActivity", "ListView with ID 'list_view_media_files' not found");
        }

        mListView.setOnItemClickListener((parent, view, position, id) -> {
            CameraFile file = mCameraFileList.get(position);
            Toast.makeText(MediaFilesActivity.this, "Clicked: " + file.getFileName(), Toast.LENGTH_SHORT).show();
        });

        loadCameraFiles();
    }



    private void loadCameraFiles() {
        mCameraFileList.clear();
        mCameraFileList.add(new CameraFile("Photo_001.jpg", false));
        mCameraFileList.add(new CameraFile("Video_001.mp4", true));
        mCameraFileList.add(new CameraFile("Photo_002.jpg", false));

        mAdapter.notifyDataSetChanged();
    }
}