package ru.mustakimov.retrofittutorial.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import ru.mustakimov.retrofittutorial.App;
import ru.mustakimov.retrofittutorial.PostModel;
import ru.mustakimov.retrofittutorial.R;
import ru.mustakimov.retrofittutorial.model.interactor.MainInteractor;
import ru.mustakimov.retrofittutorial.model.repository.main.MainRepository;
import ru.mustakimov.retrofittutorial.presentation.main.MainPresenter;
import ru.mustakimov.retrofittutorial.presentation.main.MainView;
import ru.mustakimov.retrofittutorial.ui.main.adapter.PostsAdapter;

public class MainFragment extends Fragment implements MainView {

    View view;
    RecyclerView recyclerView;
    PostsAdapter adapter;
    LinearLayoutManager layoutManager;

    MainPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        if (presenter == null) {
            presenter = new MainPresenter(this, new MainInteractor(new MainRepository(App.getApi())));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.posts_recycle_view);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PostsAdapter();
        recyclerView.setSaveEnabled(true);
        recyclerView.setAdapter(adapter);

        presenter.setData();

    }

    @Override
    public void setList(final List<PostModel> models) {
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                adapter.setPosts(models);
            }
        });
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(getActivity(), "Error: " + errorMessage, Toast.LENGTH_SHORT).show();
    }

}
