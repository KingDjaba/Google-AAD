package com.example.googleaad.ui.data;

import com.example.googleaad.model.Skill_IQ;
import com.example.googleaad.model.TopLearner;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("api/skilliq")
    Call<List<Skill_IQ>> getTopSkill();

    @GET("api/hours")
    Call<List<TopLearner>> getTopLearners();
}
