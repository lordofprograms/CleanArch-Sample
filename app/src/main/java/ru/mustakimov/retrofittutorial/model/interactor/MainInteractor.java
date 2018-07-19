package ru.mustakimov.retrofittutorial.model.interactor;

import ru.mustakimov.retrofittutorial.model.repository.main.MainRepository;
import ru.mustakimov.retrofittutorial.utils.DataCallback;
import ru.mustakimov.retrofittutorial.utils.FailureCallback;

public class MainInteractor {

    private MainRepository repository;

    private String BASH = "bash";

    public MainInteractor(MainRepository repository) {
        this.repository = repository;
    }

    public void getBashData(int count, final DataCallback callback, final FailureCallback failureCallback){
        repository.getData(BASH, count, callback, failureCallback);
    }

}
