package com.wzes.vmovie.detail;

import com.wzes.vmovie.bean.Words;
import com.wzes.vmovie.service.MyRetrofit;
import com.wzes.vmovie.util.MyLog;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by xuantang on 11/16/17.
 */

public class WordsDetailPresenter implements WordsDetailContract.Presenter {

    private WordsDetailContract.View view;

    private static final String PUBLIC_KEY = "513da0e6b07e4113b6b894d88aa8a54e";

    private Words words;

    private String q;
    private String content;

    public WordsDetailPresenter(WordsDetailContract.View view) {
        this.view = view;
        start();
    }

    @Override
    public void start() {
        this.loadData();
    }

    /**
     *
     */
    @Override
    public void loadData() {
        // request data
        MyRetrofit.getInstance().getNormalRetrofit("https://api.cognitive.microsoft.com/")
                .getResults(q, PUBLIC_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            //MyLog.i(responseBody.string());
                            content = responseBody.string();
                            words = new Words(q, content);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        onFail();
                        MyLog.i("onFail");
                    }

                    @Override
                    public void onComplete() {
                        onSuccess();
                        MyLog.i("onSuccess");
                        //view.onSuccess(new Words(q, content));
                    }
                });

    }

    @Override
    public void onFail() {
        view.onFail();
    }

    @Override
    public void onSuccess() {
        // show data
        // Words words = new Words(q, content);
        //MyLog.i(" = " + words.getContent());
        view.onSuccess(new Words(q, content));
    }

    @Override
    public void share() {
        view.share();
    }

    /**
     * Set word for searching
     * @param q
     */
    public void setQ(String q) {
        this.q = q;
    }
}
