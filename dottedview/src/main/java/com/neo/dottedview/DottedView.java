package com.neo.dottedview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by iman.
 * iman.neofight@gmail.com
 */
public class DottedView extends View{
    /*private static final byte DV_ORIENTATION_HORIZONTAL = 0;
    private static final byte DV_ORIENTATION_VERTICAL = 1;
    private static final byte DV_ORIENTATION_BOTH = 2;

    @IntDef({DV_ORIENTATION_HORIZONTAL,DV_ORIENTATION_VERTICAL,DV_ORIENTATION_BOTH})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DvOrientation{}

    @DvOrientation
    public int getDvOrientation(int orientation){
        switch (orientation){
            case DV_ORIENTATION_HORIZONTAL : return DV_ORIENTATION_HORIZONTAL;
            case DV_ORIENTATION_VERTICAL : return DV_ORIENTATION_VERTICAL;
            case DV_ORIENTATION_BOTH : return DV_ORIENTATION_BOTH;
            default:return DV_ORIENTATION_BOTH;
        }
    }*/

    Paint mDotPaint;
    Paint mDotStrokePaint;
    Context mContext;

    int mDotSize;
    int mDotColor;
    int mDotHSpace;
    int mDotVSpace;
    int mDotStrokeColor;
    int mDotStrokeWidth;

    /*@DvOrientation
    int mOrientation;*/


    public DottedView(Context context) {
        super(context);
        initAttrs(context,null);
        init(context);
    }

    public DottedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context,attrs);
        init(context);
    }

    public DottedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context,attrs);
        init(context);
    }

    private void initAttrs(Context ctx,AttributeSet attrs) {
        int defaultDotSize = ctx.getResources().getDimensionPixelSize(R.dimen.dv_default_dot_size);
        int defaultDotColor = ContextCompat.getColor(ctx,R.color.dv_default_dot_color);
        int defaultDotHSpace = ctx.getResources().getDimensionPixelSize(R.dimen.dv_default_dot_h_space);
        int defaultDotVSpace = ctx.getResources().getDimensionPixelSize(R.dimen.dv_default_dot_v_space);
        int defaultDotStrokeColor = ContextCompat.getColor(ctx,R.color.dv_default_dot_stroke_color);
        int defaultDotStrokeWidth = ctx.getResources().getDimensionPixelSize(R.dimen.dv_default_dot_stroke_width);
        /*int defaultOrientation = DV_ORIENTATION_BOTH;*/

        if(attrs!=null) {
            TypedArray a = getContext().obtainStyledAttributes(
                    attrs,
                    R.styleable.DottedView);
            try {
                mDotSize = a.getDimensionPixelSize(R.styleable.DottedView_dv_dotSize,defaultDotSize);
            } catch (Exception e) {
                mDotSize = defaultDotSize;
            }

            try {
                mDotColor = a.getColor(R.styleable.DottedView_dv_dotColor,defaultDotColor);
            } catch (Exception e) {
                mDotColor = defaultDotColor;
            }

            try {
                mDotHSpace = a.getDimensionPixelSize(R.styleable.DottedView_dv_dotHSpace,defaultDotHSpace);
            } catch (Exception e) {
                mDotHSpace= defaultDotHSpace;
            }

            try {
                mDotVSpace = a.getDimensionPixelSize(R.styleable.DottedView_dv_dotVSpace,defaultDotVSpace);
            } catch (Exception e) {
                mDotVSpace= defaultDotVSpace;
            }

            try {
                mDotStrokeColor = a.getColor(R.styleable.DottedView_dv_dotStrokeColor,defaultDotStrokeColor);
            } catch (Exception e) {
                mDotStrokeColor = defaultDotStrokeColor;
            }

            try {
                mDotStrokeWidth = a.getDimensionPixelSize(R.styleable.DottedView_dv_dotStrokeWidth,defaultDotStrokeWidth);
            } catch (Exception e) {
                mDotStrokeWidth= defaultDotStrokeWidth;
            }

            /*try {
                mOrientation = getDvOrientation(a.getInt(R.styleable.DottedView_dv_orientation,defaultOrientation));
            } catch (Exception e) {
                mOrientation = defaultOrientation;
            }*/

            //Don't forget this
            a.recycle();
        }else{
            mDotSize = defaultDotSize;
            mDotColor = defaultDotColor;
            mDotHSpace= defaultDotHSpace;
            mDotVSpace= defaultDotVSpace;
            mDotStrokeColor = defaultDotStrokeColor;
            mDotStrokeWidth= defaultDotStrokeWidth;
            /*mOrientation = defaultOrientation;*/
        }
    }

    void init(Context ctx){
        mContext = ctx;

        mDotPaint = new Paint();
        mDotPaint.setColor(mDotColor);
        mDotPaint.setAntiAlias(true);
        mDotPaint.setStyle(Paint.Style.FILL);

        mDotStrokePaint = new Paint();
        mDotStrokePaint.setColor(mDotStrokeColor);
        mDotStrokePaint.setStrokeWidth(mDotStrokeWidth);
        mDotStrokePaint.setStyle(Paint.Style.STROKE);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        int paddLeft = getPaddingLeft();
        int paddRight = getPaddingRight();
        int paddTop = getPaddingTop();
        int paddBot = getPaddingBottom();

        for(int y=(mDotSize/2)+mDotStrokeWidth+paddLeft;y<height-paddBot;y+=mDotSize+mDotVSpace)
            for(int x=(mDotSize/2)+mDotStrokeWidth+paddTop;x<width-paddRight;x+=mDotSize+mDotHSpace){
                canvas.drawCircle(x,y,mDotSize/2,mDotPaint);

                if(mDotStrokeWidth!=0)
                    canvas.drawCircle(x,y,mDotSize/2,mDotStrokePaint);
            }
    }
}
