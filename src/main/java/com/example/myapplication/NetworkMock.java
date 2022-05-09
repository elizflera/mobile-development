package com.example.myapplication;

import android.os.Handler;
import android.os.Message;

import com.example.myapplication.models.Competition;
import com.example.myapplication.models.User;

import java.util.ArrayList;
import java.util.List;

public class NetworkMock implements API{
    private final List<User> users;
    private final List<Competition> data;

    public NetworkMock() {

        users = new ArrayList<>();

        users.add(new User(
                "flera",
                "elizaveta",
                "fea@mail.ru",
                "12345"
        ));
        users.add(new User(
                "tultsova",
                "nastya",
                "tultsova@mail.ru",
                "67890"
        ));

        data = new ArrayList<>();

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
    }

    @Override
    public void insertUser(User user, Handler handler) {
        new Thread(() -> {
            Message message = new Message();
            users.add(user);
            handler.sendMessage(message);
        }).start();
    }

    @Override
    public void insertCompetition(Competition competition, Handler handler) {
        new Thread(() -> {
            Message message = new Message();
            data.add(competition);
            handler.sendMessage(message);
        }).start();
    }

    @Override
    public void getAllCompetitions(Handler handler) {
        new Thread(() -> {
            Message message = new Message();
            message.obj = data;
            handler.sendMessage(message);
        }).start();
    }

    @Override
    public void getAllCompetitionsInfo(Handler handler) {

    }


}
