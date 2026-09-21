package com.example.bai_10;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final TextView txtTitle;
    private final TextView txtContent;
    private final TextView txtView;
    private final ImageView imgCover;

    private final ArticleAdapter adapter;

    public ArticleViewHolder(
            @NonNull View itemView,
            ArticleAdapter adapter
    ) {
        super(itemView);

        this.adapter = adapter;

        txtTitle = itemView.findViewById(R.id.txtTitle);
        txtContent = itemView.findViewById(R.id.txtContent);
        txtView = itemView.findViewById(R.id.txtView);
        imgCover = itemView.findViewById(R.id.imgCover);

        itemView.setOnClickListener(this);
    }

    public void bind(Article article) {
        txtTitle.setText(article.getTitle());
        txtContent.setText(article.getContent());
        imgCover.setImageResource(article.getImgCover());
        txtView.setText("Lượt xem: " + article.getView());
    }

    @Override
    public void onClick(View v) {
        int position = getBindingAdapterPosition();

        if (position == RecyclerView.NO_POSITION) {
            return;
        }

        Article article = adapter.getArticle(position);

        article.increaseView();
        adapter.notifyItemChanged(position);

        Intent intent = new Intent(
                v.getContext(),
                DetailActivity.class
        );

        intent.putExtra("title", article.getTitle());
        intent.putExtra("content", article.getContent());
        intent.putExtra("img_cover", article.getImgCover());
        intent.putExtra("view", article.getView());

        v.getContext().startActivity(intent);
    }
}