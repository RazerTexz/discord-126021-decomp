package com.discord.utilities.textview;

import android.view.View;
import android.view.View$OnLayoutChangeListener;

/* JADX INFO: compiled from: TextViewFadeHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextViewFadeHelper$registerFadeHelper$$inlined$apply$lambda$1 implements View$OnLayoutChangeListener {
    public final /* synthetic */ TextViewFadeHelper this$0;

    public TextViewFadeHelper$registerFadeHelper$$inlined$apply$lambda$1(TextViewFadeHelper textViewFadeHelper) {
        this.this$0 = textViewFadeHelper;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        TextViewFadeHelper.access$updateFade(this.this$0);
    }
}
