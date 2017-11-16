package com.wzes.vmovie.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wzes.vmovie.R;
import com.wzes.vmovie.bean.Words;

import java.util.List;

/**
 * Created by xuantang on 11/2/17.
 */

public class WordsAdapter extends BaseItemDraggableAdapter<Words, BaseViewHolder> {

    public WordsAdapter(List<Words> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Words item) {
        helper.setText(R.id.words_item_name, item.getTitle());
    }

    public WordsAdapter(int layoutResId, List<Words> data) {
        super(layoutResId, data);
    }
}
