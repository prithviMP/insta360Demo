package com.arashivision.sdk.demo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.arashivision.sdk.demo.R;
import com.arashivision.sdk.demo.adapter.CameraFileAdapter;
import com.arashivision.sdk.demo.model.CameraFile;

import java.util.ArrayList;
import java.util.List;

public class MediaFilesFragment extends Fragment {

    private ListView mListView;
    private CameraFileAdapter mAdapter;
    private List<CameraFile> mCameraFileList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_media_files, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mListView = view.findViewById(R.id.list_view_files);
        mAdapter = new CameraFileAdapter(requireContext(), mCameraFileList);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener((parent, v, position, id) -> {
            CameraFile file = mCameraFileList.get(position);
            Toast.makeText(getContext(), "Clicked: " + file.getFileName(), Toast.LENGTH_SHORT).show();
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