package com.discord.utilities.view.extensions;

import android.view.View;

/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewExtensions$hintWithRipple$1 implements Runnable {
    public final /* synthetic */ View $this_hintWithRipple;

    public ViewExtensions$hintWithRipple$1(View view) {
        this.$this_hintWithRipple = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$this_hintWithRipple.setPressed(true);
        this.$this_hintWithRipple.setPressed(false);
    }
}
