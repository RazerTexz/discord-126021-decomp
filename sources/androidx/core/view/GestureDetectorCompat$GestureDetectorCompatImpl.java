package androidx.core.view;

import android.view.GestureDetector$OnDoubleTapListener;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public interface GestureDetectorCompat$GestureDetectorCompatImpl {
    boolean isLongpressEnabled();

    boolean onTouchEvent(MotionEvent motionEvent);

    void setIsLongpressEnabled(boolean z2);

    void setOnDoubleTapListener(GestureDetector$OnDoubleTapListener gestureDetector$OnDoubleTapListener);
}
