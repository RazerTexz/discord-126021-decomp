package com.google.android.material.snackbar;

import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
public interface BaseTransientBottomBar$OnAttachStateChangeListener {
    void onViewAttachedToWindow(View view);

    void onViewDetachedFromWindow(View view);
}
