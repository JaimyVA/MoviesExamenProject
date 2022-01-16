package com.example.moviesexamenproject.model;

import android.app.Application;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NewReleasesViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<NewReleases>> newReleases;
    private ExecutorService mExecutorService = Executors.newFixedThreadPool(2);

    public NewReleasesViewModel(@NonNull Application application) {
        super(application);
        newReleases = new MutableLiveData<>();
    }

    public MutableLiveData<ArrayList<NewReleases>> getNewReleases() {
        ArrayList<NewReleases> newreleases = new ArrayList<>();
        mExecutorService.execute(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {
                try {
                    OkHttpClient mClient = new OkHttpClient();

                    Request mRequest = new Request.Builder()
                            .url("https://api.themoviedb.org/3/movie/now_playing?api_key=ff4a7d24d3812ad83bd0eedb3854f450&language=en-US&page=1")
                            .get()
                            .build();

                    Response mResponse = mClient.newCall(mRequest).execute();

                    String responsePlainText = mResponse.body().string();
                    JSONObject newReleaseArray = new JSONObject(responsePlainText);
                    JSONArray movie = newReleaseArray.getJSONArray("results");

                    int i = 0;
                    int nObjects = movie.length();

                    while(i < nObjects){
                        JSONObject currentMovieJSON = movie.getJSONObject(i);

                        NewReleases currentMovieJava = new NewReleases(
                                currentMovieJSON.getBoolean("adult"),
                                currentMovieJSON.getInt("id"),
                                currentMovieJSON.getString("poster_path"),
                                currentMovieJSON.getString("original_title"),
                                currentMovieJSON.getString("overview"),
                                currentMovieJSON.getString("release_date"),
                                currentMovieJSON.getDouble("vote_average")
                        );
                        newreleases.add(currentMovieJava);
                        i++;
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
                newReleases.postValue(newreleases);
            }
        });
        return newReleases;
    }
}
