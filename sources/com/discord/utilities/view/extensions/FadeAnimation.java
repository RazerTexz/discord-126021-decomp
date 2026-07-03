package com.discord.utilities.view.extensions;

import android.view.ViewPropertyAnimator;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FadeAnimation {
    private final Type type;
    private final ViewPropertyAnimator viewPropertyAnimator;

    /* JADX INFO: compiled from: ViewExtensions.kt */
    public enum Type {
        FADE_IN,
        FADE_OUT
    }

    public FadeAnimation(ViewPropertyAnimator viewPropertyAnimator, Type type) {
        C12238m.checkNotNullParameter(viewPropertyAnimator, "viewPropertyAnimator");
        C12238m.checkNotNullParameter(type, "type");
        this.viewPropertyAnimator = viewPropertyAnimator;
        this.type = type;
    }

    public final Type getType() {
        return this.type;
    }

    public final ViewPropertyAnimator getViewPropertyAnimator() {
        return this.viewPropertyAnimator;
    }
}
