package pl.johu_apps.johucomics.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.List;

import pl.johu_apps.johucomics.R;
import pl.johu_apps.johucomics.adapters.ComicViewAdapter;
import pl.johu_apps.johucomics.adapters.ComicsRecyclerViewAdapter;
import pl.johu_apps.johucomics.specifics.Comic;
import pl.johu_apps.johucomics.utils.HttpHandler;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        ListView myComicsListView = findViewById(R.id.my_comics_list_view);
        RecyclerView moreComicsRecyclerView =  findViewById(R.id.more_comics_recycler_view);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        layout.setOrientation(LinearLayoutManager.HORIZONTAL);
        moreComicsRecyclerView.setLayoutManager(layout);
        new LoadJsonTask(moreComicsRecyclerView).execute();

    }

    private class LoadJsonTask extends AsyncTask<Void, Void, List<Comic>> {

        private final RecyclerView comicsRecyclerView;

        public LoadJsonTask(RecyclerView comicsRecyclerView) {
            this.comicsRecyclerView = comicsRecyclerView;
        }


        @Override
        protected List<Comic> doInBackground(Void... voids) {
            return new HttpHandler().getComiscList();
        }

        protected void onPostExecute(List<Comic> comicsList) {
            comicsRecyclerView.setAdapter(
                    new ComicsRecyclerViewAdapter(comicsList));

        }

    }
}
