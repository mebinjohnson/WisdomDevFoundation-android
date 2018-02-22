package com.wisdom;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by praji on 2/22/2018.
 */

public class NewsFeedAdapter extends ArrayAdapter<FeedItem> {

    public NewsFeedAdapter(Context context, int resource, List<FeedItem> objects) {
        super(context,resource,objects);
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        if (view == null) {
            view = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_newsfeed, parent, false);
        }

        TextView mArticleHeading = (TextView) view.findViewById(R.id.text_headline);
        TextView mActualUrl = (TextView) view.findViewById(R.id.text_download_url);
        ImageView mThumb = (ImageView) view.findViewById(R.id.img_thumb);
        final ImageView mShare = (ImageView) view.findViewById(R.id.btn_img_share);

        FeedItem feedItem = getItem(position);
        mArticleHeading.setText(feedItem.getArticleHeading());
        Glide.with(getContext())
                .load(feedItem.getImageUrl())
                .into(mThumb);
        mShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FeedItem clickedItem = new FeedItem();
                clickedItem = getItem(position);

            }
        });
     //   mActualUrl.setText(feedItem.getactualUrl());

        return view;
    }
}
