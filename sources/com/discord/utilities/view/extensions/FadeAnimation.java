package com.discord.utilities.view.extensions;

import android.view.ViewPropertyAnimator;
import d0.z.d.m;

/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FadeAnimation {
    private final FadeAnimation$Type type;
    private final ViewPropertyAnimator viewPropertyAnimator;

    public FadeAnimation(ViewPropertyAnimator viewPropertyAnimator, FadeAnimation$Type fadeAnimation$Type) {
        m.checkNotNullParameter(viewPropertyAnimator, "viewPropertyAnimator");
        m.checkNotNullParameter(fadeAnimation$Type, "type");
        this.viewPropertyAnimator = viewPropertyAnimator;
        this.type = fadeAnimation$Type;
    }

    public final FadeAnimation$Type getType() {
        return this.type;
    }

    public final ViewPropertyAnimator getViewPropertyAnimator() {
        return this.viewPropertyAnimator;
    }
}
