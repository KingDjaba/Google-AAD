package com.example.googleaad.ui.data;

import com.example.googleaad.model.Skill_IQ;
import com.example.googleaad.model.TopLearner;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    private static final String BASE_URL = " https://gadsapi.herokuapp.com/";
    private PostInterface postInterface;
    private static PostClient INSTANCE;

    public PostClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }

    //Singleton
    public static PostClient getINSTANCE(){
        if (null == INSTANCE){
            INSTANCE =new PostClient();
        }
        return INSTANCE;
    }

    public Call<List<Skill_IQ>> getTopSkill(){
        return postInterface.getTopSkill();
    }

    public Call<List<TopLearner>> getTopLearners(){
        return postInterface.getTopLearners();
    }
}
