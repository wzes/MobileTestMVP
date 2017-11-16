package com.wzes.vmovie.main;

import com.wzes.vmovie.base.BasePresenter;
import com.wzes.vmovie.base.BaseView;
import com.wzes.vmovie.bean.Words;

import java.util.List;

/**
 * Created by xuantang on 11/16/17.
 */

public class MainTestContract {

    interface View extends BaseView<Presenter> {
        void showWordsList(List<Words> wordsList);
    }

    interface Presenter extends BasePresenter {
        void showWordsList();
    }

}
