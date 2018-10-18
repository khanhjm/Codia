package com.example.myteam.codia.data.source.remote.auth;

import android.net.Uri;
;
import com.example.myteam.codia.screen.authentication.confirm.CreateUserCallback;
import com.example.myteam.codia.screen.authentication.register.EmailExistsCallback;
import com.google.firebase.auth.FirebaseUser;

public class AuthenicationRepository implements AuthenicationDataSource.RemoteDataSource {
    private AuthenicationDataSource.RemoteDataSource mRemoteDataSource;

    public AuthenicationRepository(AuthenicationDataSource.RemoteDataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    @Override
    public void checkEmailIsUsed(String email, EmailExistsCallback callback) {
        mRemoteDataSource.checkEmailIsUsed(email, callback);
    }

    @Override
    public void sendConfirmCode(String email, DataCallback<String> callBack) {
        mRemoteDataSource.sendConfirmCode(email, callBack);
    }

    @Override
    public void register(String email, String password, DataCallback<FirebaseUser> callBack) {
        mRemoteDataSource.register(email, password, callBack);
    }

    @Override
    public void registerUser(String email, String displayName, FirebaseUser user, CreateUserCallback callback) {
        mRemoteDataSource.registerUser(email, displayName, user, callback);
    }

    public void signIn(String email, String password, DataCallback<FirebaseUser> callback) {
        mRemoteDataSource.signIn(email, password, callback);
    }

    @Override
    public void signOut(DataCallback<FirebaseUser> callback) {

    }

    @Override
    public void resetPassword(String email, DataCallback callback) {

    }

    @Override
    public void updateProfile(String userName, Uri photo, DataCallback callback) {

    }

    @Override
    public void changePassword(FirebaseUser firebaseUser, String newPassword, ChangePasswordCallBack callback) {

    }

    @Override
    public void deleteUserFireBase(String uid) {
        mRemoteDataSource.deleteUserFireBase(uid);
    }

    public void getCurrentUser(DataCallback<FirebaseUser> callback) {
        mRemoteDataSource.getCurrentUser(callback);
    }
}
