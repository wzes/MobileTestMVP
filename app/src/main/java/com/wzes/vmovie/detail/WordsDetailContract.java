package com.wzes.vmovie.detail;

import com.wzes.vmovie.base.BasePresenter;
import com.wzes.vmovie.base.BaseView;
import com.wzes.vmovie.bean.Words;

/**
 * Created by xuantang on 11/16/17.
 */

public class WordsDetailContract {

    interface View extends BaseView<Presenter> {
        void onFail();
        void onSuccess(Words words);
        void share();
    }

    interface Presenter extends BasePresenter {
        void loadData();
        void onFail();
        void onSuccess();
        void share();
    }

}
