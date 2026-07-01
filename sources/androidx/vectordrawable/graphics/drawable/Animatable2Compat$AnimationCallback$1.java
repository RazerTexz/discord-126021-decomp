package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable2$AnimationCallback;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class Animatable2Compat$AnimationCallback$1 extends Animatable2$AnimationCallback {
    public final /* synthetic */ Animatable2Compat$AnimationCallback this$0;

    public Animatable2Compat$AnimationCallback$1(Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        this.this$0 = animatable2Compat$AnimationCallback;
    }

    @Override // android.graphics.drawable.Animatable2$AnimationCallback
    public void onAnimationEnd(Drawable drawable) {
        this.this$0.onAnimationEnd(drawable);
    }

    @Override // android.graphics.drawable.Animatable2$AnimationCallback
    public void onAnimationStart(Drawable drawable) {
        this.this$0.onAnimationStart(drawable);
    }
}
