package pl.johu_apps.johucomics.adapters;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import pl.johu_apps.johucomics.R;
import pl.johu_apps.johucomics.specifics.Comic;

public class ComicsRecyclerViewAdapter extends RecyclerView.Adapter<ComicsViewHolder> {

    private final List<Comic> comicList;

    public ComicsRecyclerViewAdapter(List<Comic> comicList) {
        this.comicList = comicList;
    }

    @Override
    public ComicsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comics_list_item, parent, false);

        return new ComicsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ComicsViewHolder holder, int position) {
        Comic item = comicList.get(position);
        holder.getComicLogoImgview().setImageURI(Uri.parse(item.getComicLogoURL()));
        holder.getComicTitle().setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return comicList.size();
    }
}
