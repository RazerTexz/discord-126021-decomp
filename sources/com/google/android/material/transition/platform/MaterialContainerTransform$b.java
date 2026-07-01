package com.google.android.material.transition.platform;

import android.transition.Transition;
import android.view.View;
import androidx.annotation.NonNull;
import b.i.a.g.l.l.i;
import com.google.android.material.internal.ViewUtils;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialContainerTransform$b extends i {
    public final /* synthetic */ View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialContainerTransform$d f3099b;
    public final /* synthetic */ View c;
    public final /* synthetic */ View d;
    public final /* synthetic */ MaterialContainerTransform e;

    public MaterialContainerTransform$b(MaterialContainerTransform materialContainerTransform, View view, MaterialContainerTransform$d materialContainerTransform$d, View view2, View view3) {
        this.e = materialContainerTransform;
        this.a = view;
        this.f3099b = materialContainerTransform$d;
        this.c = view2;
        this.d = view3;
    }

    @Override // b.i.a.g.l.l.i, android.transition.Transition$TransitionListener
    public void onTransitionEnd(@NonNull Transition transition) {
        this.e.removeListener(this);
        if (MaterialContainerTransform.access$300(this.e)) {
            return;
        }
        this.c.setAlpha(1.0f);
        this.d.setAlpha(1.0f);
        ViewUtils.getOverlay(this.a).remove(this.f3099b);
    }

    @Override // b.i.a.g.l.l.i, android.transition.Transition$TransitionListener
    public void onTransitionStart(@NonNull Transition transition) {
        ViewUtils.getOverlay(this.a).add(this.f3099b);
        this.c.setAlpha(0.0f);
        this.d.setAlpha(0.0f);
    }
}
