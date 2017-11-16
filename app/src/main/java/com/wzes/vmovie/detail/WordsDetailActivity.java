package com.wzes.vmovie.detail;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.wzes.vmovie.R;
import com.wzes.vmovie.bean.Words;
import com.wzes.vmovie.util.MyLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WordsDetailActivity extends AppCompatActivity implements WordsDetailContract.View{

    @BindView(R.id.word_detail_back)
    ImageButton wordDetailBack;
    @BindView(R.id.word_detail_more)
    ImageButton wordDetailMore;
    @BindView(R.id.words_detail_content)
    TextView wordsDetailContent;


    private String q;

    private WordsDetailContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words_detail);
        ButterKnife.bind(this);
        // Get word
        q = getIntent().getStringExtra("words");
        WordsDetailPresenter wordsDetailPresenter = new WordsDetailPresenter(this);
        wordsDetailPresenter.setQ(q);
        setPresenter(wordsDetailPresenter);

    }

    @OnClick({R.id.word_detail_back, R.id.word_detail_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.word_detail_back:
                finish();
                break;
            case R.id.word_detail_more:
                presenter.share();
                break;
        }
    }

    @Override
    public void setPresenter(WordsDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void onFail() {
        Toast.makeText(this, "Network is Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(Words words) {
        wordsDetailContent.setText(words.getContent());
    }

    @Override
    public void share() {
        // open dialog
        BottomSheetDialog dialog = new BottomSheetDialog(WordsDetailActivity.this);
        View bottom = LayoutInflater.from(WordsDetailActivity.this).inflate(
                R.layout.share_info_bottom_sheet_dialog, null);
        dialog.setContentView(bottom);
        dialog.show();
        // add click listener
        View view = bottom.findViewById(R.id.text_view_share);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(WordsDetailActivity.this, "分享", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
