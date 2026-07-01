package com.google.android.material.internal;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public interface TextDrawableHelper$TextDrawableDelegate {
    @NonNull
    int[] getState();

    boolean onStateChange(int[] iArr);

    void onTextSizeChange();
}
