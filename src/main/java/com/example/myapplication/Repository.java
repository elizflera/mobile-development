package com.example.myapplication;
import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.models.Competition;
import com.example.myapplication.models.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Repository {

    private final LocalDataBase dataBase;

    @Inject
    public Repository(Application application) {

        dataBase = LocalDataBase.init(application);

        List<Competition> data = new ArrayList<>();
        data.add(new Competition(
                1L,
                "Межрегиональные соревнования по художественной и эстетической гимнастике «ИДЕЛЬ»",
                "01.03.2022 - 03.03.2022"));
        data.add(new Competition(
                2L,
                "IV открытые межрегиональные соревнования по художественной гимнастике «ВЕРА В ПОБЕДУ»",
                "03.03.2022 - 06.03.2022"));
        data.add(new Competition(
                3L,
                "Первенство России в групповых упражнениях по художественной гимнастике",
                "03.03.2022 - 07.03.2021"));
        data.add(new Competition(
                4L,
                "Кубок Республики Мордовия по художественной гимнастике",
                "04.03.2022 - 06.03.2022"));
        data.add(new Competition(
                5L,
                "Межрегиональные соревнования по художественной гимнастике «Кижанка-2022»",
                "04.03.2022 - 06.03.2022"));
        data.add(new Competition(
                6L,
                "Турнир по художественной гимнастике «Olympico Cup UFA» на призы Олимпийской чемпионки Юлии Барсуковой",
                "04.03.2022 - 06.03.2022"));
        data.add(new Competition(
                7L,
                "Республиканский турнир по художественной гимнастике «Сияние Севера»",
                "04.03.2022 - 06.03.2022"));
        data.add(new Competition(
                8L,
                "Открытый турнир по художественной гимнастике «Legenda Spring Cup»",
                "05.03.2022"));
        data.add(new Competition(
                9L,
                "Открытые межрегиональные соревнования по художественной гимнастике Муниципального образования «Выборгский район» Ленинградской области",
                "05.03.2022"));
        data.add(new Competition(
                10L,
                "Открытое Первенство «Школы Гимнастики AVANTI» «МАМИНА ГОРДОСТЬ»",
                "05.03.2022"));

        dataBase.insertAllCompetitions(data);
    }

    public void insertUser(User user){
        dataBase.insertUser(user);
    }
    public LiveData<List<Competition>> getAllCompetitions() {
        return dataBase.getAllCompetitions();
    }
}


