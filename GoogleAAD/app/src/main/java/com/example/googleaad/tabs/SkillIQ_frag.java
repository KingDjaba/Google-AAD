package com.example.googleaad.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.googleaad.MyAdapter;
import com.example.googleaad.PageViewModel;
import com.example.googleaad.model.Skill_IQ;
import com.example.googleaad.R;

import java.util.List;
import java.util.Objects;

public class SkillIQ_frag extends Fragment {

    PageViewModel pageViewModel;

    public SkillIQ_frag(){

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_skill, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycleview1);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        pageViewModel.getTopSkill();

        final MyAdapter adapter = new MyAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        pageViewModel.skillMutableData.observe((LifecycleOwner) Objects.requireNonNull(getContext()), adapter::setSkill_iqList);
    }
    }

