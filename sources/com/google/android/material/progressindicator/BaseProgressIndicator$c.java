package com.google.android.material.progressindicator;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;

/* JADX INFO: loaded from: classes3.dex */
public class BaseProgressIndicator$c extends Animatable2Compat$AnimationCallback {
    public final /* synthetic */ BaseProgressIndicator a;

    public BaseProgressIndicator$c(BaseProgressIndicator baseProgressIndicator) {
        this.a = baseProgressIndicator;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback
    public void onAnimationEnd(Drawable drawable) {
        this.a.setIndeterminate(false);
        this.a.setProgressCompat(0, false);
        BaseProgressIndicator baseProgressIndicator = this.a;
        baseProgressIndicator.setProgressCompat(BaseProgressIndicator.access$300(baseProgressIndicator), BaseProgressIndicator.access$400(this.a));
    }
}
