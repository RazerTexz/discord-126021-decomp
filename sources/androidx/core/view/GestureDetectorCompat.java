package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector$OnDoubleTapListener;
import android.view.GestureDetector$OnGestureListener;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public final class GestureDetectorCompat {
    private final GestureDetectorCompat$GestureDetectorCompatImpl mImpl;

    public GestureDetectorCompat(Context context, GestureDetector$OnGestureListener gestureDetector$OnGestureListener) {
        this(context, gestureDetector$OnGestureListener, null);
    }

    public boolean isLongpressEnabled() {
        return this.mImpl.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mImpl.onTouchEvent(motionEvent);
    }

    public void setIsLongpressEnabled(boolean z2) {
        this.mImpl.setIsLongpressEnabled(z2);
    }

    public void setOnDoubleTapListener(GestureDetector$OnDoubleTapListener gestureDetector$OnDoubleTapListener) {
        this.mImpl.setOnDoubleTapListener(gestureDetector$OnDoubleTapListener);
    }

    public GestureDetectorCompat(Context context, GestureDetector$OnGestureListener gestureDetector$OnGestureListener, Handler handler) {
        this.mImpl = new GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2(context, gestureDetector$OnGestureListener, handler);
    }
}
