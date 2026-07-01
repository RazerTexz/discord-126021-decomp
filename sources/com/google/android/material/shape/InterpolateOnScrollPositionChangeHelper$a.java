package com.google.android.material.shape;

import android.view.ViewTreeObserver$OnScrollChangedListener;

/* JADX INFO: loaded from: classes3.dex */
public class InterpolateOnScrollPositionChangeHelper$a implements ViewTreeObserver$OnScrollChangedListener {
    public final /* synthetic */ InterpolateOnScrollPositionChangeHelper a;

    public InterpolateOnScrollPositionChangeHelper$a(InterpolateOnScrollPositionChangeHelper interpolateOnScrollPositionChangeHelper) {
        this.a = interpolateOnScrollPositionChangeHelper;
    }

    @Override // android.view.ViewTreeObserver$OnScrollChangedListener
    public void onScrollChanged() {
        this.a.updateInterpolationForScreenPosition();
    }
}
