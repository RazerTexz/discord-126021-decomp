package com.discord.widgets.user.search;

import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: WidgetGlobalSearch.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearch$setSearchPrefix$1$1 implements Runnable {
    public final /* synthetic */ TextInputLayout $this_apply;

    public WidgetGlobalSearch$setSearchPrefix$1$1(TextInputLayout textInputLayout) {
        this.$this_apply = textInputLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewExtensions.setSelectionEnd(this.$this_apply);
    }
}
