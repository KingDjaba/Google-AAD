package com.example.googleaad;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.googleaad.model.Skill_IQ;
import com.example.googleaad.model.TopLearner;
import com.example.googleaad.ui.data.PostClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PageViewModel extends ViewModel {

    public MutableLiveData<List<Skill_IQ>> skillMutableData = new MutableLiveData<>();
    public MutableLiveData<List<TopLearner>> toplearnMutableData = new MutableLiveData<>();

    public void getTopSkill(){
        PostClient.getINSTANCE().getTopSkill().enqueue(new Callback<List<Skill_IQ>>() {
            @Override
            public void onResponse(Call<List<Skill_IQ>> call, Response<List<Skill_IQ>> response) {
                skillMutableData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Skill_IQ>> call, Throwable t) {

            }
        });
    }

    public void getTopLearner() {
        PostClient.getINSTANCE().getTopLearners().enqueue(new Callback<List<TopLearner>>() {
            @Override
            public void onResponse(Call<List<TopLearner>> call, Response<List<TopLearner>> response) {
                toplearnMutableData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<TopLearner>> call, Throwable t) {

            }
        });

    }
}
