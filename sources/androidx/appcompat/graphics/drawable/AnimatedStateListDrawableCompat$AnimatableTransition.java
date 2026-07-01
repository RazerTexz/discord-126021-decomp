package androidx.appcompat.graphics.drawable;

import android.graphics.drawable.Animatable;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedStateListDrawableCompat$AnimatableTransition extends AnimatedStateListDrawableCompat$Transition {
    private final Animatable mA;

    public AnimatedStateListDrawableCompat$AnimatableTransition(Animatable animatable) {
        super(null);
        this.mA = animatable;
    }

    @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$Transition
    public void start() {
        this.mA.start();
    }

    @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$Transition
    public void stop() {
        this.mA.stop();
    }
}
