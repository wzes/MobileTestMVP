package com.wzes.vmovie.detail;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.wzes.vmovie.R;
import com.wzes.vmovie.bean.Words;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WordsDetailFragment extends Fragment implements WordsDetailContract.View{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    private WordsDetailContract.Presenter presenter;


    @Override
    public void setPresenter(WordsDetailContract.Presenter presenter) {

    }

    @Override
    public void onFail() {

    }

    @Override
    public void onSuccess(Words words) {

    }

    @Override
    public void share() {

    }
}
