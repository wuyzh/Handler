package com.wuyazhou.learn.handler.HandlerPagerView;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.wuyazhou.learn.handler.R;
import com.wuyazhou.learn.logview.LogShowUtil;

/**
 * @author 吴亚洲
 * @date 2018.7.7
 * @function
 */
public class HandlerPagerView extends FrameLayout implements View.OnClickListener {
    private Context mContext = null;
    private RelativeLayout mLayout;


    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    LogShowUtil.addLog("Handler","1");
                    break;
                case 2:
                    LogShowUtil.addLog("Handler","2");
                    break;
                default:
                    break;
            }
        }
    };

    public HandlerPagerView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public HandlerPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public HandlerPagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    public void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = (RelativeLayout) inflater.inflate(R.layout.pager_handler_layout, null);

        addView(mLayout);

        View modelFirst  = mLayout.findViewById(R.id.model_button_1);
        modelFirst.setOnClickListener(this);
        View modelSecond  = mLayout.findViewById(R.id.model_button_2);
        modelSecond.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.model_button_1:
                mHandler.sendEmptyMessage(1);
                break;
            case R.id.model_button_2:
                mHandler.sendEmptyMessage(2);
                break;
            default:
                break;
        }
    }
}
