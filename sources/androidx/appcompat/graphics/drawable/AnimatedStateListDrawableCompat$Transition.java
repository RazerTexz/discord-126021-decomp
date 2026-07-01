package androidx.appcompat.graphics.drawable;

/* JADX INFO: loaded from: classes.dex */
public abstract class AnimatedStateListDrawableCompat$Transition {
    private AnimatedStateListDrawableCompat$Transition() {
    }

    public boolean canReverse() {
        return false;
    }

    public void reverse() {
    }

    public abstract void start();

    public abstract void stop();

    public /* synthetic */ AnimatedStateListDrawableCompat$Transition(AnimatedStateListDrawableCompat$1 animatedStateListDrawableCompat$1) {
        this();
    }
}
