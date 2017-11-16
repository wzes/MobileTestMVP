package com.wzes.vmovie.main;

import com.wzes.vmovie.bean.Words;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuantang on 11/16/17.
 */

public class MainTestPresenter implements MainTestContract.Presenter {

    private MainTestContract.View view;

    public MainTestPresenter(MainTestContract.View view) {
        this.view = view;
        start();
    }

    @Override
    public void start() {
        this.showWordsList();
    }

    @Override
    public void showWordsList() {
        List<Words> wordsList = new ArrayList<>();
        wordsList.add(new Words("Android"));
        wordsList.add(new Words("IOS"));
        wordsList.add(new Words("Hadoop"));
        wordsList.add(new Words("Spark"));
        wordsList.add(new Words("HBase"));
        wordsList.add(new Words("Kafka"));
        wordsList.add(new Words("Netty"));
        wordsList.add(new Words("Spring"));
        wordsList.add(new Words("Zookeeper"));
        wordsList.add(new Words("ElasticSearch"));
        wordsList.add(new Words("Spring"));
        wordsList.add(new Words("Zookeeper"));
        wordsList.add(new Words("ElasticSearch"));
        view.showWordsList(wordsList);
    }
}
