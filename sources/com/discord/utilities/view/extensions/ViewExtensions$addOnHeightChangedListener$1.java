package com.discord.utilities.view.extensions;

import android.view.View;
import android.view.View$OnLayoutChangeListener;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewExtensions$addOnHeightChangedListener$1 implements View$OnLayoutChangeListener {
    public final /* synthetic */ Function2 $onHeightChanged;

    public ViewExtensions$addOnHeightChangedListener$1(Function2 function2) {
        this.$onHeightChanged = function2;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i4 - i2;
        int i10 = i8 - i6;
        if (i9 != i10) {
            this.$onHeightChanged.invoke(Integer.valueOf(i9), Integer.valueOf(i10));
        }
    }
}
