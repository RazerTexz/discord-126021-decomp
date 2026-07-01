package com.google.android.material.transition.platform;

import android.app.Activity;
import android.transition.Transition;
import android.view.View;
import b.i.a.g.l.l.i;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialContainerTransformSharedElementCallback$b extends i {
    public final /* synthetic */ Activity a;

    public MaterialContainerTransformSharedElementCallback$b(MaterialContainerTransformSharedElementCallback materialContainerTransformSharedElementCallback, Activity activity) {
        this.a = activity;
    }

    @Override // b.i.a.g.l.l.i, android.transition.Transition$TransitionListener
    public void onTransitionEnd(Transition transition) {
        View view;
        if (MaterialContainerTransformSharedElementCallback.access$200() != null && (view = (View) MaterialContainerTransformSharedElementCallback.access$200().get()) != null) {
            view.setAlpha(1.0f);
            MaterialContainerTransformSharedElementCallback.access$202(null);
        }
        this.a.finish();
        this.a.overridePendingTransition(0, 0);
    }
}
