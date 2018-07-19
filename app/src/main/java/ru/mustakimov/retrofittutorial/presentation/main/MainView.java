package ru.mustakimov.retrofittutorial.presentation.main;

import java.util.List;

import ru.mustakimov.retrofittutorial.PostModel;

public interface MainView {

    void setList(List<PostModel> models);
    void showErrorMessage(String errorMessage);
}
