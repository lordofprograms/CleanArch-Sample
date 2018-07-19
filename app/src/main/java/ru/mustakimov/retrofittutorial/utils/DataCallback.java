package ru.mustakimov.retrofittutorial.utils;

import java.util.List;

import ru.mustakimov.retrofittutorial.PostModel;

public interface DataCallback {

    void setList(List<PostModel> models);

}
