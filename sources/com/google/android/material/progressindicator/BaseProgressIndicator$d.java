package com.google.android.material.progressindicator;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;

/* JADX INFO: loaded from: classes3.dex */
public class BaseProgressIndicator$d extends Animatable2Compat$AnimationCallback {
    public final /* synthetic */ BaseProgressIndicator a;

    public BaseProgressIndicator$d(BaseProgressIndicator baseProgressIndicator) {
        this.a = baseProgressIndicator;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback
    public void onAnimationEnd(Drawable drawable) {
        super.onAnimationEnd(drawable);
        if (BaseProgressIndicator.access$500(this.a)) {
            return;
        }
        BaseProgressIndicator baseProgressIndicator = this.a;
        baseProgressIndicator.setVisibility(BaseProgressIndicator.access$600(baseProgressIndicator));
    }
}
