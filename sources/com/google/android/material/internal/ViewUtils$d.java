package com.google.android.material.internal;

import android.view.View;
import android.view.View$OnAttachStateChangeListener;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes3.dex */
public class ViewUtils$d implements View$OnAttachStateChangeListener {
    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NonNull View view) {
        view.removeOnAttachStateChangeListener(this);
        ViewCompat.requestApplyInsets(view);
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }
}
