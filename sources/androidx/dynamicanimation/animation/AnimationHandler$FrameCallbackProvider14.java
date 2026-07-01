package androidx.dynamicanimation.animation;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class AnimationHandler$FrameCallbackProvider14 extends AnimationHandler$AnimationFrameCallbackProvider {
    private final Handler mHandler;
    public long mLastFrameTime;
    private final Runnable mRunnable;

    public AnimationHandler$FrameCallbackProvider14(AnimationHandler$AnimationCallbackDispatcher animationHandler$AnimationCallbackDispatcher) {
        super(animationHandler$AnimationCallbackDispatcher);
        this.mLastFrameTime = -1L;
        this.mRunnable = new AnimationHandler$FrameCallbackProvider14$1(this);
        this.mHandler = new Handler(Looper.myLooper());
    }

    @Override // androidx.dynamicanimation.animation.AnimationHandler$AnimationFrameCallbackProvider
    public void postFrameCallback() {
        this.mHandler.postDelayed(this.mRunnable, Math.max(10 - (SystemClock.uptimeMillis() - this.mLastFrameTime), 0L));
    }
}
