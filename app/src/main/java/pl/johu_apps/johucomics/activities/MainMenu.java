package pl.johu_apps.johucomics.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import pl.johu_apps.johucomics.R;
import pl.johu_apps.johucomics.adapters.ComicViewAdapter;
import pl.johu_apps.johucomics.specifics.Comic;
import pl.johu_apps.johucomics.utils.HttpHandler;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        ListView myComicsListView = (ListView) findViewById(R.id.my_comics_list_view);
        ListView moreComicsListView = (ListView) findViewById(R.id.more_comics_list_view);

        new LoadJsonTask(moreComicsListView).execute();

    }

    private class LoadJsonTask extends AsyncTask<Void, Void, List<Comic>> {

        private final ListView comicsListView;

        public LoadJsonTask(ListView comicsListView) {
            this.comicsListView = comicsListView;
        }


        @Override
        protected List<Comic> doInBackground(Void... voids) {
            return new HttpHandler().getComiscList();
        }

        protected void onPostExecute(List<Comic> comicsList) {
            comicsListView.setAdapter(
                    new ComicViewAdapter(MainMenu.this, comicsList));

        }

    }
}
