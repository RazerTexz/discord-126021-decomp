package androidx.core.view;

import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector$OnDoubleTapListener;

/* JADX INFO: loaded from: classes.dex */
public class GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler extends Handler {
    public final /* synthetic */ GestureDetectorCompat$GestureDetectorCompatImplBase this$0;

    public GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler(GestureDetectorCompat$GestureDetectorCompatImplBase gestureDetectorCompat$GestureDetectorCompatImplBase) {
        this.this$0 = gestureDetectorCompat$GestureDetectorCompatImplBase;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            GestureDetectorCompat$GestureDetectorCompatImplBase gestureDetectorCompat$GestureDetectorCompatImplBase = this.this$0;
            gestureDetectorCompat$GestureDetectorCompatImplBase.mListener.onShowPress(gestureDetectorCompat$GestureDetectorCompatImplBase.mCurrentDownEvent);
            return;
        }
        if (i == 2) {
            this.this$0.dispatchLongPress();
            return;
        }
        if (i != 3) {
            throw new RuntimeException("Unknown message " + message);
        }
        GestureDetectorCompat$GestureDetectorCompatImplBase gestureDetectorCompat$GestureDetectorCompatImplBase2 = this.this$0;
        GestureDetector$OnDoubleTapListener gestureDetector$OnDoubleTapListener = gestureDetectorCompat$GestureDetectorCompatImplBase2.mDoubleTapListener;
        if (gestureDetector$OnDoubleTapListener != null) {
            if (gestureDetectorCompat$GestureDetectorCompatImplBase2.mStillDown) {
                gestureDetectorCompat$GestureDetectorCompatImplBase2.mDeferConfirmSingleTap = true;
            } else {
                gestureDetector$OnDoubleTapListener.onSingleTapConfirmed(gestureDetectorCompat$GestureDetectorCompatImplBase2.mCurrentDownEvent);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler(GestureDetectorCompat$GestureDetectorCompatImplBase gestureDetectorCompat$GestureDetectorCompatImplBase, Handler handler) {
        super(handler.getLooper());
        this.this$0 = gestureDetectorCompat$GestureDetectorCompatImplBase;
    }
}
