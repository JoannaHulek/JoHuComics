package pl.johu_apps.johucomics.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import pl.johu_apps.johucomics.R;

public class ComicsViewHolder extends RecyclerView.ViewHolder {

    private final ImageView comicLogoImgview;
    private final TextView comicTitle;

    public ComicsViewHolder(View itemView) {
        super(itemView);
         comicLogoImgview = itemView.findViewById(R.id.comic_logo_imgview);
         comicTitle = itemView.findViewById(R.id.comic_title_textview);

    }

    public ImageView getComicLogoImgview() {
        return comicLogoImgview;
    }

    public TextView getComicTitle() {
        return comicTitle;
    }
}

