package androidx.transition;

import android.graphics.PointF;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ChangeBounds$ViewBounds {
    private int mBottom;
    private int mBottomRightCalls;
    private int mLeft;
    private int mRight;
    private int mTop;
    private int mTopLeftCalls;
    private View mView;

    public ChangeBounds$ViewBounds(View view) {
        this.mView = view;
    }

    private void setLeftTopRightBottom() {
        ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
        this.mTopLeftCalls = 0;
        this.mBottomRightCalls = 0;
    }

    public void setBottomRight(PointF pointF) {
        this.mRight = Math.round(pointF.x);
        this.mBottom = Math.round(pointF.y);
        int i = this.mBottomRightCalls + 1;
        this.mBottomRightCalls = i;
        if (this.mTopLeftCalls == i) {
            setLeftTopRightBottom();
        }
    }

    public void setTopLeft(PointF pointF) {
        this.mLeft = Math.round(pointF.x);
        this.mTop = Math.round(pointF.y);
        int i = this.mTopLeftCalls + 1;
        this.mTopLeftCalls = i;
        if (i == this.mBottomRightCalls) {
            setLeftTopRightBottom();
        }
    }
}
