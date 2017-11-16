package com.wzes.vmovie.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.wzes.vmovie.R;
import com.wzes.vmovie.adapter.WordsAdapter;
import com.wzes.vmovie.bean.Words;
import com.wzes.vmovie.detail.WordsDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainTestActivity extends AppCompatActivity implements MainTestContract.View{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    private WordsAdapter wordsAdapter;

    private MainTestContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);
        ButterKnife.bind(this);
        setPresenter(new MainTestPresenter(this));
    }



    @Override
    public void setPresenter(MainTestContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showWordsList(final List<Words> wordsList) {
        // set adapter
        wordsAdapter = new WordsAdapter(R.layout.words_item, wordsList);
        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(wordsAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
        recyclerView.setAdapter(wordsAdapter);

        wordsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                // go to detail view
                Intent intent = new Intent(MainTestActivity.this, WordsDetailActivity.class);
                intent.putExtra("words", wordsList.get(position).getTitle());
                startActivity(intent);
                //Toast.makeText(MainTestActivity.this, wordsList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
