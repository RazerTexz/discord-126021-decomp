package androidx.dynamicanimation.animation;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class AnimationHandler$AnimationCallbackDispatcher {
    public final /* synthetic */ AnimationHandler this$0;

    public AnimationHandler$AnimationCallbackDispatcher(AnimationHandler animationHandler) {
        this.this$0 = animationHandler;
    }

    public void dispatchAnimationFrame() {
        this.this$0.mCurrentFrameTime = SystemClock.uptimeMillis();
        AnimationHandler animationHandler = this.this$0;
        animationHandler.doAnimationFrame(animationHandler.mCurrentFrameTime);
        if (this.this$0.mAnimationCallbacks.size() > 0) {
            this.this$0.getProvider().postFrameCallback();
        }
    }
}
