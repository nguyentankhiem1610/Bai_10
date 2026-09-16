package com.example.bai_10;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private final ArrayList<Article> articles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerArticles =
                findViewById(R.id.recyclerArticles);

        createArticles();

        // Hiển thị danh sách theo chiều dọc.
        recyclerArticles.setLayoutManager(
                new LinearLayoutManager(this)
        );

        // Gắn dữ liệu vào RecyclerView thông qua Adapter.
        ArticleAdapter adapter = new ArticleAdapter(articles);
        recyclerArticles.setAdapter(adapter);
    }

    private void createArticles() {
        articles.add(new Article(
                "Chí Phèo",
                "Tác giả: Nam Cao.\n\n"
                        + "Chí Phèo là truyện ngắn kể về số phận của "
                        + "một người nông dân nghèo ở làng Vũ Đại.\n\n"
                        + "Từ một người hiền lành, Chí bị đẩy vào tù. "
                        + "Sau khi trở về, Chí trở nên tha hóa, thường xuyên "
                        + "say rượu và bị Bá Kiến lợi dụng.\n\n"
                        + "Cuộc gặp gỡ với Thị Nở cùng bát cháo hành "
                        + "đã đánh thức khát vọng sống lương thiện trong Chí. "
                        + "Nhưng sự từ chối của Thị Nở khiến Chí rơi vào "
                        + "bi kịch bị cự tuyệt quyền làm người.\n\n"
                        + "Tác phẩm tố cáo xã hội bất công và thể hiện "
                        + "niềm thương cảm sâu sắc đối với người nông dân.",
                R.drawable.chipheo
        ));

        articles.add(new Article(
                "Lão Hạc",
                "Tác giả: Nam Cao.\n\n"
                        + "Lão Hạc là truyện ngắn kể về một người nông dân "
                        + "nghèo, sống cô độc và hết lòng thương con.\n\n"
                        + "Vợ mất, con trai đi làm đồn điền cao su, "
                        + "lão chỉ còn con chó gọi là cậu Vàng làm bạn. "
                        + "Vì hoàn cảnh túng quẫn, lão buộc phải bán cậu Vàng "
                        + "và vô cùng đau khổ, day dứt.\n\n"
                        + "Lão gửi ông giáo tiền lo ma chay và nhờ giữ "
                        + "mảnh vườn cho con, sau đó chọn cái chết "
                        + "bằng bả chó.\n\n"
                        + "Tác phẩm thể hiện số phận đau thương cùng "
                        + "lòng tự trọng và tình thương con sâu sắc "
                        + "của người nông dân nghèo.",
                R.drawable.laohac
        ));

        articles.add(new Article(
                "Tắt đèn",
                "Tác giả: Ngô Tất Tố.\n\n"
                        + "Tắt đèn là tiểu thuyết viết về cuộc sống "
                        + "khốn cùng của người nông dân dưới "
                        + "ách sưu thuế trong xã hội thực dân phong kiến.\n\n"
                        + "Nhân vật chính là chị Dậu, một người phụ nữ "
                        + "nghèo, thương chồng và thương con. "
                        + "Để có tiền nộp sưu cho chồng, chị phải "
                        + "bán con, bán chó nhưng vẫn không thoát "
                        + "khỏi cảnh bị áp bức.\n\n"
                        + "Khi cai lệ và người nhà lý trưởng đến "
                        + "hành hạ chồng, chị Dậu đã vùng lên chống trả "
                        + "để bảo vệ gia đình.\n\n"
                        + "Tác phẩm tố cáo chế độ sưu thuế tàn nhẫn, "
                        + "đồng thời làm nổi bật tình yêu thương "
                        + "và sức phản kháng của người nông dân.",
                R.drawable.tatden
        ));
    }
}