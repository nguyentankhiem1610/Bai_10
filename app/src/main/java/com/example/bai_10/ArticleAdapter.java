package com.example.bai_10;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ArticleAdapter
        extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private final ArrayList<Article> articles;

    public ArticleAdapter(ArrayList<Article> articles) {
        this.articles = articles;
    }

    // Tạo giao diện cho một ô bài viết.
    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType
    ) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_article, parent, false);

        return new ArticleViewHolder(view);
    }

    // Đưa dữ liệu của bài viết lên giao diện.
    @Override
    public void onBindViewHolder(
            @NonNull ArticleViewHolder holder,
            int position
    ) {
        Article article = articles.get(position);

        holder.txtTitle.setText(article.getTitle());
        holder.txtContent.setText(article.getContent());
        holder.imgCover.setImageResource(article.getImgCover());
        holder.txtView.setText("Lượt xem: " + article.getView());
    }

    // Trả về số bài viết.
    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private final TextView txtTitle;
        private final TextView txtContent;
        private final TextView txtView;
        private final ImageView imgCover;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtContent = itemView.findViewById(R.id.txtContent);
            txtView = itemView.findViewById(R.id.txtView);
            imgCover = itemView.findViewById(R.id.imgCover);

            // Nhấn vào ô bài viết sẽ gọi onClick() bên dưới.
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getBindingAdapterPosition();

            if (position == RecyclerView.NO_POSITION) {
                return;
            }

            Article article = articles.get(position);

            // Tăng lượt xem của đúng bài vừa nhấn.
            article.increaseView();

            // Cập nhật lại ô bài viết trên danh sách.
            notifyItemChanged(position);

            // Truyền dữ liệu sang màn hình chi tiết.
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
}
