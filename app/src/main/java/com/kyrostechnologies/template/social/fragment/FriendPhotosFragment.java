package com.kyrostechnologies.template.social.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kyrostechnologies.template.social.R;
import com.kyrostechnologies.template.social.adapter.AlbumGridAdapter;
import com.kyrostechnologies.template.social.data.Constant;
import com.kyrostechnologies.template.social.data.Tools;

public class FriendPhotosFragment extends Fragment {
    private RecyclerView recyclerView;
    public AlbumGridAdapter mAdapter;
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_friend_photos, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), Tools.getGridSpanCount(getActivity()));
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //set data and list adapter
        mAdapter = new AlbumGridAdapter(getActivity(), Constant.getFriendsAlbumData(getActivity()));
        recyclerView.setAdapter(mAdapter);
        return view;
    }

}
