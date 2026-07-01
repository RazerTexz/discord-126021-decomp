package androidx.appcompat.graphics.drawable;

import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedStateListDrawableCompat$AnimatedVectorDrawableTransition extends AnimatedStateListDrawableCompat$Transition {
    private final AnimatedVectorDrawableCompat mAvd;

    public AnimatedStateListDrawableCompat$AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        super(null);
        this.mAvd = animatedVectorDrawableCompat;
    }

    @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$Transition
    public void start() {
        this.mAvd.start();
    }

    @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$Transition
    public void stop() {
        this.mAvd.stop();
    }
}
