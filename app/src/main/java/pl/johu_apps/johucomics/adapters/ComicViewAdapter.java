package pl.johu_apps.johucomics.adapters;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import pl.johu_apps.johucomics.R;
import pl.johu_apps.johucomics.specifics.Comic;

public class ComicViewAdapter extends ArrayAdapter<Comic> {


    public ComicViewAdapter(@NonNull Context context, @NonNull List<Comic> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Comic comic = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.comics_list_item, parent, false);
        }

        ImageView comicLogoImgview = convertView.findViewById(R.id.comic_logo_imgview);
        TextView comicTitle = convertView.findViewById(R.id.comic_title_textview);
        URL url = null;
        try {
            url = new URL(comic.getComicLogoURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            comicLogoImgview.setImageBitmap(BitmapFactory.decodeStream(url.openConnection().getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        comicTitle.setText(comic.getTitle());

        return convertView;
    }
}