package com.example.bai_10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView txtTitle = findViewById(R.id.txtDetailTitle);
        TextView txtContent = findViewById(R.id.txtDetailContent);
        TextView txtView = findViewById(R.id.txtDetailView);
        ImageView imgCover = findViewById(R.id.imgDetailCover);
        Button btnBack = findViewById(R.id.btnBack);

        // Nhận Intent đã mở màn hình này.
        Intent intent = getIntent();

        // Lấy dữ liệu được gửi kèm.
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        int img_cover = intent.getIntExtra("img_cover", 0);
        int view = intent.getIntExtra("view", 0);

        // Hiển thị dữ liệu.
        txtTitle.setText(title);
        txtContent.setText(content);
        txtView.setText("Lượt xem: " + view);
        imgCover.setImageResource(img_cover);

        // Đóng chi tiết để trở về danh sách đang có.
        btnBack.setOnClickListener(v -> finish());
    }
}