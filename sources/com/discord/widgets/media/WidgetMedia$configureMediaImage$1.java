package com.discord.widgets.media;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.GestureDetector$SimpleOnGestureListener;
import android.view.MotionEvent;
import b.f.l.b.a;
import b.f.l.b.e;
import com.facebook.samples.zoomable.ZoomableDraweeView;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMedia$configureMediaImage$1 extends GestureDetector$SimpleOnGestureListener {
    private boolean mDoubleTapScroll;
    public final /* synthetic */ WidgetMedia this$0;
    private final long DURATION_MS = 300;
    private final long DOUBLE_TAP_SCROLL_THRESHOLD = 20;
    private final PointF mDoubleTapViewPoint = new PointF();
    private final PointF mDoubleTapImagePoint = new PointF();
    private float mDoubleTapScale = 1.0f;

    public WidgetMedia$configureMediaImage$1(WidgetMedia widgetMedia) {
        this.this$0 = widgetMedia;
    }

    private final float calcScale(PointF currentViewPoint) {
        float f = currentViewPoint.y - this.mDoubleTapViewPoint.y;
        float fAbs = (Math.abs(f) * 0.001f) + 1;
        return f < ((float) 0) ? this.mDoubleTapScale / fAbs : this.mDoubleTapScale * fAbs;
    }

    private final boolean shouldStartDoubleTapScroll(PointF viewPoint) {
        float f = viewPoint.x;
        PointF pointF = this.mDoubleTapViewPoint;
        return ((float) Math.hypot((double) (f - pointF.x), (double) (viewPoint.y - pointF.y))) > ((float) this.DOUBLE_TAP_SCROLL_THRESHOLD);
    }

    public final PointF getMDoubleTapImagePoint() {
        return this.mDoubleTapImagePoint;
    }

    public final float getMDoubleTapScale() {
        return this.mDoubleTapScale;
    }

    public final boolean getMDoubleTapScroll() {
        return this.mDoubleTapScroll;
    }

    public final PointF getMDoubleTapViewPoint() {
        return this.mDoubleTapViewPoint;
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener, android.view.GestureDetector$OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent e) {
        m.checkNotNullParameter(e, "e");
        ZoomableDraweeView zoomableDraweeView = WidgetMedia.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(zoomableDraweeView, "binding.mediaImage");
        e zoomableController = zoomableDraweeView.getZoomableController();
        Objects.requireNonNull(zoomableController, "null cannot be cast to non-null type com.facebook.samples.zoomable.AbstractAnimatedZoomableController");
        a aVar = (a) zoomableController;
        PointF pointF = new PointF(e.getX(), e.getY());
        float[] fArr = aVar.j;
        fArr[0] = pointF.x;
        fArr[1] = pointF.y;
        aVar.h.invert(aVar.i);
        aVar.i.mapPoints(fArr, 0, fArr, 0, 1);
        for (int i = 0; i < 1; i++) {
            int i2 = i * 2;
            int i3 = i2 + 0;
            float f = fArr[i3];
            RectF rectF = aVar.e;
            fArr[i3] = (f - rectF.left) / rectF.width();
            int i4 = i2 + 1;
            float f2 = fArr[i4];
            RectF rectF2 = aVar.e;
            fArr[i4] = (f2 - rectF2.top) / rectF2.height();
        }
        PointF pointF2 = new PointF(fArr[0], fArr[1]);
        int actionMasked = e.getActionMasked();
        if (actionMasked == 0) {
            this.mDoubleTapViewPoint.set(pointF);
            this.mDoubleTapImagePoint.set(pointF2);
            this.mDoubleTapScale = aVar.e();
        } else if (actionMasked == 1) {
            if (this.mDoubleTapScroll) {
                aVar.p(calcScale(pointF), this.mDoubleTapImagePoint, this.mDoubleTapViewPoint, 7, 0L, null);
            } else if (aVar.e() < 3.0f / 2) {
                aVar.p(2.0f, pointF2, pointF, 7, this.DURATION_MS, null);
            } else {
                aVar.p(1.0f, pointF2, pointF, 7, this.DURATION_MS, null);
            }
            this.mDoubleTapScroll = false;
        } else if (actionMasked == 2) {
            boolean z2 = this.mDoubleTapScroll || shouldStartDoubleTapScroll(pointF);
            this.mDoubleTapScroll = z2;
            if (z2) {
                aVar.p(calcScale(pointF), this.mDoubleTapImagePoint, this.mDoubleTapViewPoint, 7, 0L, null);
            }
        }
        return true;
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener, android.view.GestureDetector$OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent e) {
        m.checkNotNullParameter(e, "e");
        WidgetMedia.access$onMediaClick(this.this$0);
        return true;
    }

    public final void setMDoubleTapScale(float f) {
        this.mDoubleTapScale = f;
    }

    public final void setMDoubleTapScroll(boolean z2) {
        this.mDoubleTapScroll = z2;
    }
}
