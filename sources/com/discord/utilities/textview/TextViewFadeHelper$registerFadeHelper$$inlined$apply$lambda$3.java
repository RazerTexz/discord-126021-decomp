package com.discord.utilities.textview;

import android.view.View;
import android.view.View$OnAttachStateChangeListener;
import android.view.View$OnLayoutChangeListener;
import android.widget.TextView;

/* JADX INFO: compiled from: TextViewFadeHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextViewFadeHelper$registerFadeHelper$$inlined$apply$lambda$3 implements View$OnAttachStateChangeListener {
    public final /* synthetic */ View$OnLayoutChangeListener $layoutListener;
    public final /* synthetic */ TextViewFadeHelper$registerFadeHelper$$inlined$apply$lambda$2 $textChangedListener;
    public final /* synthetic */ TextView $this_apply;

    public TextViewFadeHelper$registerFadeHelper$$inlined$apply$lambda$3(TextView textView, View$OnLayoutChangeListener view$OnLayoutChangeListener, TextViewFadeHelper$registerFadeHelper$$inlined$apply$lambda$2 textViewFadeHelper$registerFadeHelper$$inlined$apply$lambda$2) {
        this.$this_apply = textView;
        this.$layoutListener = view$OnLayoutChangeListener;
        this.$textChangedListener = textViewFadeHelper$registerFadeHelper$$inlined$apply$lambda$2;
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v) {
        this.$this_apply.addOnLayoutChangeListener(this.$layoutListener);
        this.$this_apply.addTextChangedListener(this.$textChangedListener);
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v) {
        this.$this_apply.removeOnLayoutChangeListener(this.$layoutListener);
        this.$this_apply.removeTextChangedListener(this.$textChangedListener);
    }
}
