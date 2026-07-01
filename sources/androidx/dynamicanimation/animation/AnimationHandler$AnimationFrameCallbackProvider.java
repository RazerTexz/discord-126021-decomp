package androidx.dynamicanimation.animation;

/* JADX INFO: loaded from: classes.dex */
public abstract class AnimationHandler$AnimationFrameCallbackProvider {
    public final AnimationHandler$AnimationCallbackDispatcher mDispatcher;

    public AnimationHandler$AnimationFrameCallbackProvider(AnimationHandler$AnimationCallbackDispatcher animationHandler$AnimationCallbackDispatcher) {
        this.mDispatcher = animationHandler$AnimationCallbackDispatcher;
    }

    public abstract void postFrameCallback();
}
