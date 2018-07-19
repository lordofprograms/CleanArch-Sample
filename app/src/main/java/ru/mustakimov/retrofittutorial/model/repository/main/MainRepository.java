package ru.mustakimov.retrofittutorial.model.repository.main;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.mustakimov.retrofittutorial.PostModel;
import ru.mustakimov.retrofittutorial.model.data.api.UmoriliApi;
import ru.mustakimov.retrofittutorial.utils.DataCallback;
import ru.mustakimov.retrofittutorial.utils.FailureCallback;

public class MainRepository {

    private UmoriliApi api;

    public MainRepository(UmoriliApi api) {
        this.api = api;
    }

    public void getData(String name, int count, final DataCallback callback, final FailureCallback failureCallback){

        api.getData(name, count).enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                callback.setList(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable throwable) {
                failureCallback.setError(throwable);
            }
        });

    }

}
