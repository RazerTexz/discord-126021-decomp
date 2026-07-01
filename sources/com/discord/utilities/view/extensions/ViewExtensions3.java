package com.discord.utilities.view.extensions;

import android.view.ViewPropertyAnimator;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.view.extensions.FadeAnimation, reason: use source file name */
/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewExtensions3 {
    private final Type type;
    private final ViewPropertyAnimator viewPropertyAnimator;

    /* JADX INFO: renamed from: com.discord.utilities.view.extensions.FadeAnimation$Type */
    /* JADX INFO: compiled from: ViewExtensions.kt */
    public enum Type {
        FADE_IN,
        FADE_OUT
    }

    public ViewExtensions3(ViewPropertyAnimator viewPropertyAnimator, Type type) {
        Intrinsics3.checkNotNullParameter(viewPropertyAnimator, "viewPropertyAnimator");
        Intrinsics3.checkNotNullParameter(type, "type");
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
