package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector$OnDoubleTapListener;
import android.view.GestureDetector$OnGestureListener;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public class GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompat$GestureDetectorCompatImpl {
    private final GestureDetector mDetector;

    public GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2(Context context, GestureDetector$OnGestureListener gestureDetector$OnGestureListener, Handler handler) {
        this.mDetector = new GestureDetector(context, gestureDetector$OnGestureListener, handler);
    }

    @Override // androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImpl
    public boolean isLongpressEnabled() {
        return this.mDetector.isLongpressEnabled();
    }

    @Override // androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImpl
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mDetector.onTouchEvent(motionEvent);
    }

    @Override // androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImpl
    public void setIsLongpressEnabled(boolean z2) {
        this.mDetector.setIsLongpressEnabled(z2);
    }

    @Override // androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImpl
    public void setOnDoubleTapListener(GestureDetector$OnDoubleTapListener gestureDetector$OnDoubleTapListener) {
        this.mDetector.setOnDoubleTapListener(gestureDetector$OnDoubleTapListener);
    }
}
