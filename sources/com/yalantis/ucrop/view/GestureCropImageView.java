package com.yalantis.ucrop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import b.q.a.k.RotationGestureDetector;
import b.q.a.l.CropImageView;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class GestureCropImageView extends CropImageView {
    public ScaleGestureDetector K;
    public RotationGestureDetector L;
    public GestureDetector M;
    public float N;
    public float O;
    public boolean P;
    public boolean Q;
    public int R;

    public class b extends GestureDetector.SimpleOnGestureListener {
        public b(a aVar) {
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
            CropImageView.b bVar = new CropImageView.b(gestureCropImageView, 200L, currentScale, doubleTapTargetScale - currentScale, x2, y2);
            gestureCropImageView.E = bVar;
            gestureCropImageView.post(bVar);
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            GestureCropImageView.this.g(-f, -f2);
            return true;
        }
    }

    public class c extends RotationGestureDetector.b {
        public c(a aVar) {
        }
    }

    public class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public d(a aVar) {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            GestureCropImageView gestureCropImageView = GestureCropImageView.this;
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            GestureCropImageView gestureCropImageView2 = GestureCropImageView.this;
            gestureCropImageView.f(scaleFactor, gestureCropImageView2.N, gestureCropImageView2.O);
            return true;
        }
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.P = true;
        this.Q = true;
        this.R = 5;
    }

    @Override // b.q.a.l.TransformImageView2
    public void c() {
        setScaleType(ImageView.ScaleType.MATRIX);
        this.M = new GestureDetector(getContext(), new b(null), null, true);
        this.K = new ScaleGestureDetector(getContext(), new d(null));
        this.L = new RotationGestureDetector(new c(null));
    }

    public int getDoubleTapScaleSteps() {
        return this.R;
    }

    public float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow(getMaxScale() / getMinScale(), 1.0f / this.R));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            i();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.N = (motionEvent.getX(1) + motionEvent.getX(0)) / 2.0f;
            this.O = (motionEvent.getY(1) + motionEvent.getY(0)) / 2.0f;
        }
        this.M.onTouchEvent(motionEvent);
        if (this.Q) {
            this.K.onTouchEvent(motionEvent);
        }
        if (this.P) {
            RotationGestureDetector rotationGestureDetector = this.L;
            Objects.requireNonNull(rotationGestureDetector);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                rotationGestureDetector.c = motionEvent.getX();
                rotationGestureDetector.d = motionEvent.getY();
                rotationGestureDetector.e = motionEvent.findPointerIndex(motionEvent.getPointerId(0));
                rotationGestureDetector.g = 0.0f;
                rotationGestureDetector.h = true;
            } else if (actionMasked == 1) {
                rotationGestureDetector.e = -1;
            } else if (actionMasked != 2) {
                if (actionMasked == 5) {
                    rotationGestureDetector.a = motionEvent.getX();
                    rotationGestureDetector.f1986b = motionEvent.getY();
                    rotationGestureDetector.f = motionEvent.findPointerIndex(motionEvent.getPointerId(motionEvent.getActionIndex()));
                    rotationGestureDetector.g = 0.0f;
                    rotationGestureDetector.h = true;
                } else if (actionMasked == 6) {
                    rotationGestureDetector.f = -1;
                }
            } else if (rotationGestureDetector.e != -1 && rotationGestureDetector.f != -1 && motionEvent.getPointerCount() > rotationGestureDetector.f) {
                float x2 = motionEvent.getX(rotationGestureDetector.e);
                float y2 = motionEvent.getY(rotationGestureDetector.e);
                float x3 = motionEvent.getX(rotationGestureDetector.f);
                float y3 = motionEvent.getY(rotationGestureDetector.f);
                if (rotationGestureDetector.h) {
                    rotationGestureDetector.g = 0.0f;
                    rotationGestureDetector.h = false;
                } else {
                    float degrees = (((float) Math.toDegrees((float) Math.atan2(y3 - y2, x3 - x2))) % 360.0f) - (((float) Math.toDegrees((float) Math.atan2(rotationGestureDetector.f1986b - rotationGestureDetector.d, rotationGestureDetector.a - rotationGestureDetector.c))) % 360.0f);
                    rotationGestureDetector.g = degrees;
                    if (degrees < -180.0f) {
                        rotationGestureDetector.g = degrees + 360.0f;
                    } else if (degrees > 180.0f) {
                        rotationGestureDetector.g = degrees - 360.0f;
                    }
                }
                RotationGestureDetector.a aVar = rotationGestureDetector.i;
                if (aVar != null) {
                    GestureCropImageView gestureCropImageView = GestureCropImageView.this;
                    gestureCropImageView.e(rotationGestureDetector.g, gestureCropImageView.N, gestureCropImageView.O);
                }
                rotationGestureDetector.a = x3;
                rotationGestureDetector.f1986b = y3;
                rotationGestureDetector.c = x2;
                rotationGestureDetector.d = y2;
            }
        }
        if ((motionEvent.getAction() & 255) == 1) {
            setImageToWrapCropBounds(true);
        }
        return true;
    }

    public void setDoubleTapScaleSteps(int i) {
        this.R = i;
    }

    public void setRotateEnabled(boolean z2) {
        this.P = z2;
    }

    public void setScaleEnabled(boolean z2) {
        this.Q = z2;
    }
}
