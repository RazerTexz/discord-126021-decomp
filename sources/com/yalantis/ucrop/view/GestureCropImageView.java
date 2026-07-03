package com.yalantis.ucrop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import java.util.Objects;
import p007b.p485q.p486a.p490k.C5303c;
import p007b.p485q.p486a.p491l.C5305a;

/* JADX INFO: loaded from: classes3.dex */
public class GestureCropImageView extends C5305a {

    /* JADX INFO: renamed from: K */
    public ScaleGestureDetector f22203K;

    /* JADX INFO: renamed from: L */
    public C5303c f22204L;

    /* JADX INFO: renamed from: M */
    public GestureDetector f22205M;

    /* JADX INFO: renamed from: N */
    public float f22206N;

    /* JADX INFO: renamed from: O */
    public float f22207O;

    /* JADX INFO: renamed from: P */
    public boolean f22208P;

    /* JADX INFO: renamed from: Q */
    public boolean f22209Q;

    /* JADX INFO: renamed from: R */
    public int f22210R;

    /* JADX INFO: renamed from: com.yalantis.ucrop.view.GestureCropImageView$b */
    public class C11204b extends GestureDetector.SimpleOnGestureListener {
        public C11204b(C11203a c11203a) {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            GestureCropImageView gestureCropImageView = GestureCropImageView.this;
            float doubleTapTargetScale = gestureCropImageView.getDoubleTapTargetScale();
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (doubleTapTargetScale > gestureCropImageView.getMaxScale()) {
                doubleTapTargetScale = gestureCropImageView.getMaxScale();
            }
            float currentScale = gestureCropImageView.getCurrentScale();
            C5305a.b bVar = new C5305a.b(gestureCropImageView, 200L, currentScale, doubleTapTargetScale - currentScale, x2, y2);
            gestureCropImageView.f14458E = bVar;
            gestureCropImageView.post(bVar);
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            GestureCropImageView.this.m7488g(-f, -f2);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.yalantis.ucrop.view.GestureCropImageView$c */
    public class C11205c extends C5303c.b {
        public C11205c(C11203a c11203a) {
        }
    }

    /* JADX INFO: renamed from: com.yalantis.ucrop.view.GestureCropImageView$d */
    public class C11206d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public C11206d(C11203a c11203a) {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            GestureCropImageView gestureCropImageView = GestureCropImageView.this;
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            GestureCropImageView gestureCropImageView2 = GestureCropImageView.this;
            gestureCropImageView.mo7478f(scaleFactor, gestureCropImageView2.f22206N, gestureCropImageView2.f22207O);
            return true;
        }
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f22208P = true;
        this.f22209Q = true;
        this.f22210R = 5;
    }

    @Override // p007b.p485q.p486a.p491l.C5307c
    /* JADX INFO: renamed from: c */
    public void mo7486c() {
        setScaleType(ImageView.ScaleType.MATRIX);
        this.f22205M = new GestureDetector(getContext(), new C11204b(null), null, true);
        this.f22203K = new ScaleGestureDetector(getContext(), new C11206d(null));
        this.f22204L = new C5303c(new C11205c(null));
    }

    public int getDoubleTapScaleSteps() {
        return this.f22210R;
    }

    public float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow(getMaxScale() / getMinScale(), 1.0f / this.f22210R));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            m7480i();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.f22206N = (motionEvent.getX(1) + motionEvent.getX(0)) / 2.0f;
            this.f22207O = (motionEvent.getY(1) + motionEvent.getY(0)) / 2.0f;
        }
        this.f22205M.onTouchEvent(motionEvent);
        if (this.f22209Q) {
            this.f22203K.onTouchEvent(motionEvent);
        }
        if (this.f22208P) {
            C5303c c5303c = this.f22204L;
            Objects.requireNonNull(c5303c);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                c5303c.f14446c = motionEvent.getX();
                c5303c.f14447d = motionEvent.getY();
                c5303c.f14448e = motionEvent.findPointerIndex(motionEvent.getPointerId(0));
                c5303c.f14450g = 0.0f;
                c5303c.f14451h = true;
            } else if (actionMasked == 1) {
                c5303c.f14448e = -1;
            } else if (actionMasked != 2) {
                if (actionMasked == 5) {
                    c5303c.f14444a = motionEvent.getX();
                    c5303c.f14445b = motionEvent.getY();
                    c5303c.f14449f = motionEvent.findPointerIndex(motionEvent.getPointerId(motionEvent.getActionIndex()));
                    c5303c.f14450g = 0.0f;
                    c5303c.f14451h = true;
                } else if (actionMasked == 6) {
                    c5303c.f14449f = -1;
                }
            } else if (c5303c.f14448e != -1 && c5303c.f14449f != -1 && motionEvent.getPointerCount() > c5303c.f14449f) {
                float x2 = motionEvent.getX(c5303c.f14448e);
                float y2 = motionEvent.getY(c5303c.f14448e);
                float x3 = motionEvent.getX(c5303c.f14449f);
                float y3 = motionEvent.getY(c5303c.f14449f);
                if (c5303c.f14451h) {
                    c5303c.f14450g = 0.0f;
                    c5303c.f14451h = false;
                } else {
                    float degrees = (((float) Math.toDegrees((float) Math.atan2(y3 - y2, x3 - x2))) % 360.0f) - (((float) Math.toDegrees((float) Math.atan2(c5303c.f14445b - c5303c.f14447d, c5303c.f14444a - c5303c.f14446c))) % 360.0f);
                    c5303c.f14450g = degrees;
                    if (degrees < -180.0f) {
                        c5303c.f14450g = degrees + 360.0f;
                    } else if (degrees > 180.0f) {
                        c5303c.f14450g = degrees - 360.0f;
                    }
                }
                C5303c.a aVar = c5303c.f14452i;
                if (aVar != null) {
                    GestureCropImageView gestureCropImageView = GestureCropImageView.this;
                    gestureCropImageView.m7487e(c5303c.f14450g, gestureCropImageView.f22206N, gestureCropImageView.f22207O);
                }
                c5303c.f14444a = x3;
                c5303c.f14445b = y3;
                c5303c.f14446c = x2;
                c5303c.f14447d = y2;
            }
        }
        if ((motionEvent.getAction() & 255) == 1) {
            setImageToWrapCropBounds(true);
        }
        return true;
    }

    public void setDoubleTapScaleSteps(int i) {
        this.f22210R = i;
    }

    public void setRotateEnabled(boolean z2) {
        this.f22208P = z2;
    }

    public void setScaleEnabled(boolean z2) {
        this.f22209Q = z2;
    }
}
