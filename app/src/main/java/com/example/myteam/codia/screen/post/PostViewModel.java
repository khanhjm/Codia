package com.example.myteam.codia.screen.post;

import android.app.ProgressDialog;
import android.content.Context;

import com.example.myteam.codia.R;
import com.example.myteam.codia.data.model.Post;
import com.example.myteam.codia.data.source.remote.timeline.TimelineRemoteDataSource;
import com.example.myteam.codia.data.source.remote.timeline.TimelineRepository;
import com.example.myteam.codia.utils.navigator.Navigator;

public class PostViewModel implements PostContract.ViewModel {

    private Context mContext;
    private Navigator mNavigator;
    private ProgressDialog mDialog;
    private PostActivity mPostActivity;
    private TimelineRepository mRepository;

    public PostViewModel(Context context, Navigator navigator) {
        mContext = context;
        mPostActivity = (PostActivity) context;
        mNavigator = navigator;
        mDialog = new ProgressDialog(context);
        mDialog.setMessage(context.getString(R.string.msg_loading));
        mRepository = new TimelineRepository(new TimelineRemoteDataSource());
    }

    @Override
    public void showDialog() {
        if (mDialog != null && !mDialog.isShowing()) {
            mDialog.show();
        }
    }

    @Override
    public void dismissDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    @Override
    public void onPrivacyClick() {
        //show bottom sheet privacy dialog
        PrivacyBottomSheetFragment bottomSheetDialog = new PrivacyBottomSheetFragment();
        bottomSheetDialog.show(mPostActivity.getSupportFragmentManager(), bottomSheetDialog.getClass().getSimpleName());

    }

    @Override
    public void onPostClick(Post post, CreatePostCallBack callBack) {
        //push post to DB by ID
        mRepository.pushPost(post, callBack);
    }

    @Override
    public void onBackClick() {
        mNavigator.finishActivity();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void setPresenter(PostContract.Presenter presenter) {

    }
}
