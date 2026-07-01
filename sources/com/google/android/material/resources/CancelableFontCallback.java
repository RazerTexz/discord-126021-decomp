package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
public final class CancelableFontCallback extends TextAppearanceFontCallback {
    private final CancelableFontCallback$ApplyFont applyFont;
    private boolean cancelled;
    private final Typeface fallbackFont;

    public CancelableFontCallback(CancelableFontCallback$ApplyFont cancelableFontCallback$ApplyFont, Typeface typeface) {
        this.fallbackFont = typeface;
        this.applyFont = cancelableFontCallback$ApplyFont;
    }

    private void updateIfNotCancelled(Typeface typeface) {
        if (this.cancelled) {
            return;
        }
        this.applyFont.apply(typeface);
    }

    public void cancel() {
        this.cancelled = true;
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrievalFailed(int i) {
        updateIfNotCancelled(this.fallbackFont);
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrieved(Typeface typeface, boolean z2) {
        updateIfNotCancelled(typeface);
    }
}
