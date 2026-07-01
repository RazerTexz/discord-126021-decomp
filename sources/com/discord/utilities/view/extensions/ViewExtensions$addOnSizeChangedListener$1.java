package com.discord.utilities.view.extensions;

import android.view.View;
import android.view.View$OnLayoutChangeListener;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewExtensions$addOnSizeChangedListener$1 implements View$OnLayoutChangeListener {
    public final /* synthetic */ Function4 $onSizeChanged;

    public ViewExtensions$addOnSizeChangedListener$1(Function4 function4) {
        this.$onSizeChanged = function4;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i3 - i;
        int i10 = i4 - i2;
        int i11 = i7 - i5;
        int i12 = i8 - i6;
        if (i9 == i11 && i10 == i12) {
            return;
        }
        this.$onSizeChanged.invoke(Integer.valueOf(i9), Integer.valueOf(i11), Integer.valueOf(i10), Integer.valueOf(i12));
    }
}
