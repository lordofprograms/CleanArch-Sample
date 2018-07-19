package ru.mustakimov.retrofittutorial.presentation.main;

import java.util.List;

import ru.mustakimov.retrofittutorial.PostModel;
import ru.mustakimov.retrofittutorial.model.interactor.MainInteractor;
import ru.mustakimov.retrofittutorial.utils.DataCallback;
import ru.mustakimov.retrofittutorial.utils.FailureCallback;

public class MainPresenter {

    private MainView view;
    private MainInteractor interactor;

    public MainPresenter(MainView view, MainInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    public void setData(){
        interactor.getBashData(50, new DataCallback() {
            @Override
            public void setList(List<PostModel> models) {
                view.setList(models);
            }
        }, new FailureCallback() {
            @Override
            public void setError(Throwable throwable) {
                view.showErrorMessage(throwable.getMessage());
            }
        });
    }

}
