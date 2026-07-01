package com.google.android.material.transition.platform;

import android.transition.Transition;
import android.view.Window;
import b.i.a.g.l.l.i;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialContainerTransformSharedElementCallback$c extends i {
    public final /* synthetic */ Window a;

    public MaterialContainerTransformSharedElementCallback$c(MaterialContainerTransformSharedElementCallback materialContainerTransformSharedElementCallback, Window window) {
        this.a = window;
    }

    @Override // b.i.a.g.l.l.i, android.transition.Transition$TransitionListener
    public void onTransitionStart(Transition transition) {
        MaterialContainerTransformSharedElementCallback.access$000(this.a);
    }
}
