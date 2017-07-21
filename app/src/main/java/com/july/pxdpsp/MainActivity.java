package com.july.pxdpsp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;

/**
 * <p>
 *     理解getDimensionPixelSize，getDimension，getDimensionPixelOffset
 * </p>
 * 根据实际情况，看看如果是四舍五入就调用getDimensionPixelSize()，如果是取整就调用getDimensionPixelOffset()。
 * getDimension()返回值是float类型，得到的数值单位都是px
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView mDpTextView;
    private TextView mSpTextView;
    private TextView mPxTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDpTextView = (TextView) findViewById(R.id.tv_title_dp);
        mSpTextView = (TextView) findViewById(R.id.tv_title_sp);
        mPxTextView = (TextView) findViewById(R.id.tv_title_px);

        sameTextSize();

        // 测试手机为OPPO R7 Android 4.4.4
        float density = getResources().getDisplayMetrics().density;
        Log.e(TAG, "density=" + density);

        Log.e("DisplayUtil", "------------------------------------- int");
        Log.e(TAG, "22dp = " + DisplayUtil.dip2px(this, 22));

        // 以下三种方法得到的数值大小，单位都是px
        getDimensionPixelSize();
        getDimension();
        getDimensionPixelOffset();
    }

    /**
     * 实现字体大小为22dp的不同写法
     */
    private void sameTextSize()
    {
        // dp
        mDpTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 22);

        // setTextSize(float size) 等价于setTextSize(TypedValue.COMPLEX_UNIT_SP,size)
        // size的默认单位是TypedValue.COMPLEX_UNIT_SP，实际上调用的就是setTextSize(TypedValue.COMPLEX_UNIT_SP,size);
        mSpTextView.setTextSize(22);

        // px
        mPxTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimensionPixelSize(R.dimen.dp_22));

        // px2
        int px = DisplayUtil.dip2px(this, 22);
        mPxTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, px);
    }

    private void getDimensionPixelSize()
    {
        Log.e("getDimensionPixelSize", "------------------------------------- int");
        Log.e(TAG, "22dp=" + getResources().getDimensionPixelSize(R.dimen.dp_22));
        Log.e(TAG, "22sp=" + getResources().getDimensionPixelSize(R.dimen.sp_22));
        Log.e(TAG, "22px=" + getResources().getDimensionPixelSize(R.dimen.px_22));
    }

    private void getDimension()
    {
        Log.e("getDimension", "------------------------------------- float");
        Log.e(TAG, "22dp=" + getResources().getDimension(R.dimen.dp_22));
        Log.e(TAG, "22sp=" + getResources().getDimension(R.dimen.sp_22));
        Log.e(TAG, "22px=" + getResources().getDimension(R.dimen.px_22));
    }

    private void getDimensionPixelOffset()
    {
        Log.e("getDimensionPixelOffset", "------------------------------------- int");
        Log.e(TAG, "22dp=" + getResources().getDimensionPixelOffset(R.dimen.dp_22));
        Log.e(TAG, "22sp=" + getResources().getDimensionPixelOffset(R.dimen.sp_22));
        Log.e(TAG, "22px=" + getResources().getDimensionPixelOffset(R.dimen.px_22));
    }

//    测试结果
//    07-21 11:22:31.030 3237-3237/com.july.pxdpsp E/MainActivity: density=3.0
//    07-21 11:22:31.030 3237-3237/com.july.pxdpsp E/DisplayUtil: ------------------------------------- int
//    07-21 11:22:31.030 3237-3237/com.july.pxdpsp E/MainActivity: 22dp = 66
//    07-21 11:22:31.030 3237-3237/com.july.pxdpsp E/getDimensionPixelSize: ------------------------------------- int
//    07-21 11:22:31.030 3237-3237/com.july.pxdpsp E/MainActivity: 22dp=66
//    07-21 11:22:31.031 3237-3237/com.july.pxdpsp E/MainActivity: 22sp=66
//    07-21 11:22:31.031 3237-3237/com.july.pxdpsp E/MainActivity: 22px=22
//    07-21 11:22:31.031 3237-3237/com.july.pxdpsp E/getDimension: ------------------------------------- float
//    07-21 11:22:31.031 3237-3237/com.july.pxdpsp E/MainActivity: 22dp=66.0
//    07-21 11:22:31.031 3237-3237/com.july.pxdpsp E/MainActivity: 22sp=66.0
//    07-21 11:22:31.031 3237-3237/com.july.pxdpsp E/MainActivity: 22px=22.0
//    07-21 11:22:31.031 3237-3237/com.july.pxdpsp E/getDimensionPixelOffset: ------------------------------------- int
//    07-21 11:22:31.031 3237-3237/com.july.pxdpsp E/MainActivity: 22dp=66
//    07-21 11:22:31.031 3237-3237/com.july.pxdpsp E/MainActivity: 22sp=66
//    07-21 11:22:31.031 3237-3237/com.july.pxdpsp E/MainActivity: 22px=22
}
