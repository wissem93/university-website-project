//
// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license.
//
// Microsoft Cognitive Services (formerly Project Oxford): https://www.microsoft.com/cognitive-services
//
// Microsoft Cognitive Services (formerly Project Oxford) GitHub:
// https://github.com/Microsoft/Cognitive-Face-Android
//
// Copyright (c) Microsoft Corporation
// All rights reserved.
//
// MIT License:
// Permission is hereby granted, free of charge, to any person obtaining
// a copy of this software and associated documentation files (the
// "Software"), to deal in the Software without restriction, including
// without limitation the rights to use, copy, modify, merge, publish,
// distribute, sublicense, and/or sell copies of the Software, and to
// permit persons to whom the Software is furnished to do so, subject to
// the following conditions:
//
// The above copyright notice and this permission notice shall be
// included in all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED ""AS IS"", WITHOUT WARRANTY OF ANY KIND,
// EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
// LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
// OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
// WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
//
package com.example.imen.facebookfalseprofile.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imen.facebookfalseprofile.adapter.AndroidImageAdapter;
import com.example.imen.facebookfalseprofile.entity.User;
import com.example.imen.facebookfalseprofile.util.SharedPreference;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.matthewtamlin.sliding_intro_screen_library.indicators.DotIndicator;
import com.microsoft.projectoxford.face.contract.Person;
import com.microsoft.projectoxford.face.samples.R;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private AndroidImageAdapter myViewPagerAdapter;
    private ArrayList<Integer> listOfItems;

    private LinearLayout dotsLayout;
    private int dotsCount;
    private TextView[] dots;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        facebookSDKInitialize();
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1A237E")));
        Firebase.setAndroidContext(this);
        if (getString(R.string.subscription_key).startsWith("Please")) {
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.add_subscription_key_tip_title))
                    .setMessage(getString(R.string.add_subscription_key_tip))
                    .setCancelable(false)
                    .show();
        }
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("public_profile", "email", "user_photos", "user_friends"));

        //     Toast.makeText(getApplicationContext(),AccessToken.getCurrentAccessToken().getUserId(), Toast.LENGTH_SHORT).show();

        getLoginDetails(loginButton);

      /*  ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPageAndroid);
        AndroidImageAdapter adapterView = new AndroidImageAdapter(this);
        dotsCount = adapterView.getCount();
        dots = new TextView[dotsCount];


        mViewPager.setAdapter(adapterView);*/
        initViews();
        setViewPagerItemsWithAdapter();
        setUiPageViewController();

        if (AccessToken.getCurrentAccessToken() != null) {
            startActivity(new Intent(MainActivity.this, SelectImageActivity.class));
            finish();
        }
    }




    /*
     * Register a callback function with LoginButton to respond to the login result.
     */

    protected void getLoginDetails(LoginButton login_button) {

        // Callback registration
        login_button.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            private ProfileTracker mProfileTracker;

            @Override
            public void onSuccess(LoginResult login_result) {

                final AccessToken accessToken = login_result.getAccessToken();

                final User fbUser = new User();
                GraphRequestAsyncTask request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject user, GraphResponse graphResponse) {
                        fbUser.setEmail(user.optString("email"));
                        fbUser.setFullName(user.optString("name"));
                        fbUser.setId(user.optString("id"));

                    }
                }).executeAsync();

                //  Firebase.setAndroidContext(MainActivity.this);
                if (Profile.getCurrentProfile() == null) {
                    mProfileTracker = new ProfileTracker() {
                        @Override
                        protected void onCurrentProfileChanged(Profile profile, Profile profile2) {
                            // profile2 is the new profile

                            Firebase firebase = new Firebase(getResources().getString(R.string.firebase_url));
                            User user = new User();
                            user.setIdFacebook(profile2.getId());
                            user.setFullName(profile2.getName());
                            user.setUrlProfile(profile2.getLinkUri().toString());
                            user.setPhoto(profile2.getProfilePictureUri(200, 200).toString());
                            user.setLocation("gfh");
                            user.setEmail("gg");
                            user.setSexe("gg");
                            user.setId("jhjjj");

                            SharedPreference.save(MainActivity.this, user);
                            addNotexisteUser(user, firebase);
                            mProfileTracker.stopTracking();
                            Intent intent = new Intent(MainActivity.this, SelectImageActivity.class);

                            startActivity(intent);
                        }
                    };
                    // no need to call startTracking() on mProfileTracker
                    // because it is called by its constructor, internally.
                } else {
                    Firebase firebase = new Firebase(getResources().getString(R.string.firebase_url));
                    Profile profile = Profile.getCurrentProfile();
                    User user = new User();
                    user.setIdFacebook(Profile.getCurrentProfile().getId());
                    user.setFullName(profile.getName());
                    user.setUrlProfile(profile.getLinkUri().toString());
                    user.setPhoto(profile.getProfilePictureUri(200, 200).toString());
                    user.setLocation("gfh");
                    user.setEmail("gg");
                    user.setSexe("gg");
                    user.setId("jhjjj");

                    SharedPreference.save(MainActivity.this, user);
                    addNotexisteUser(user, firebase);
                    Intent intent = new Intent(MainActivity.this, SelectImageActivity.class);

                    startActivity(intent);
                }

            }


            @Override
            public void onCancel() {
                // code for cancellation
            }

            @Override
            public void onError(FacebookException exception) {
                //  code to handle error
            }
        });
    }
/*
    private class FriendsListLoader extends AsyncTaskLoader<List<User>> {
        String access_token;

        public FriendsListLoader(Context context, String accessToken) {
            super(context);

            this.access_token = accessToken;
        }

        @Override
        public List<User> loadInBackground() {

            String result = null;
            try {

                // Create http cliient object to send request to server
                HttpClient Client = new DefaultHttpClient();

                // Create URL string
                String URL = "https://graph.facebook.com/me/friends?" + "access_token=" + access_token;

                try {
                    // Create Request to server and get response
                    HttpGet httpget = new HttpGet(URL);
                    ResponseHandler<String> responseHandler = new BasicResponseHandler();
                    result = Client.execute(httpget, responseHandler);
                } catch (Exception ex) {
                    Log.e("Friend", "HttpGetError: " + ex);
                }

                if (result != null && result.length() > 0) ;
                return friendsFromJSON(new JSONObject(result), "data");
            } catch (Exception e) {
                Log.e("FFL", "HttpClientError: " + e);
            }
            return null;
        }

    }


    public ArrayList<User> friendsFromJSON(final JSONObject jo, final String nodeName) throws JSONException {
        final ArrayList<User> friends = new ArrayList<User>();

        if (jo.has(nodeName)) {
            final JSONArray appArray = jo.getJSONArray("data");
            final int rlen = appArray.length();
            Log.i("friends",appArray.toString());
            for (int i = 0; i < rlen; i++) {
                User friend = new User();
                final JSONObject obj = appArray.getJSONObject(i);
                if (obj.has("name")) friend.setFullName(obj.getString("name"));
                if (obj.has("id")) friend.setId(obj.getString("id"));
                friends.add(friend);
            }
        }
        Toast.makeText(this,friends.size(),
                Toast.LENGTH_SHORT).show();
        return friends;
    }

*/

    private void addNotexisteUser(final User user, final Firebase ref) {

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    User u = postSnapshot.getValue(User.class);
                    if (u.getIdFacebook().toString().equals(user.getIdFacebook().toString())) {
                        ref.child(postSnapshot.getKey().toString()).child("id").setValue(postSnapshot.getKey().toString());
                        return;
                    }
                }
                ref.push().setValue(user);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    protected void facebookSDKInitialize() {

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }


    private void setUiPageViewController() {
        dotsLayout = (LinearLayout)findViewById(R.id.viewPagerCountDots);
        dotsCount = myViewPagerAdapter.getCount();
        dots = new TextView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(30);
            dots[i].setTextColor(getResources().getColor(android.R.color.darker_gray));
            dotsLayout.addView(dots[i]);
        }

        dots[0].setTextColor(getResources().getColor(R.color.com_facebook_button_background_color_pressed));
    }

    private void setViewPagerItemsWithAdapter() {
        myViewPagerAdapter = new AndroidImageAdapter(this,listOfItems);
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(viewPagerPageChangeListener);
    }

    //	page change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            for (int i = 0; i < dotsCount; i++) {
                dots[i].setTextColor(getResources().getColor(android.R.color.darker_gray));
            }
            dots[position].setTextColor(getResources().getColor(R.color.com_facebook_button_background_color_pressed));
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    private void initViews() {


        viewPager = (ViewPager)findViewById(R.id.viewPager);

        listOfItems = new ArrayList<Integer>();
        listOfItems.add(1);
        listOfItems.add(2);
        listOfItems.add(3);

    }

    //	adapter


}
