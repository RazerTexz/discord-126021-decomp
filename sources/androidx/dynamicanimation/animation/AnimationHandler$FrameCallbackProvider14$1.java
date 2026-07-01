package androidx.dynamicanimation.animation;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class AnimationHandler$FrameCallbackProvider14$1 implements Runnable {
    public final /* synthetic */ AnimationHandler$FrameCallbackProvider14 this$0;

    public AnimationHandler$FrameCallbackProvider14$1(AnimationHandler$FrameCallbackProvider14 animationHandler$FrameCallbackProvider14) {
        this.this$0 = animationHandler$FrameCallbackProvider14;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.mLastFrameTime = SystemClock.uptimeMillis();
        this.this$0.mDispatcher.dispatchAnimationFrame();
    }
}
