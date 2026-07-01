package com.google.android.material.internal;

import android.graphics.Typeface;
import androidx.annotation.NonNull;
import com.google.android.material.resources.TextAppearanceFontCallback;

/* JADX INFO: loaded from: classes3.dex */
public class TextDrawableHelper$a extends TextAppearanceFontCallback {
    public final /* synthetic */ TextDrawableHelper a;

    public TextDrawableHelper$a(TextDrawableHelper textDrawableHelper) {
        this.a = textDrawableHelper;
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrievalFailed(int i) {
        TextDrawableHelper.access$002(this.a, true);
        TextDrawableHelper$TextDrawableDelegate textDrawableHelper$TextDrawableDelegate = (TextDrawableHelper$TextDrawableDelegate) TextDrawableHelper.access$100(this.a).get();
        if (textDrawableHelper$TextDrawableDelegate != null) {
            textDrawableHelper$TextDrawableDelegate.onTextSizeChange();
        }
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrieved(@NonNull Typeface typeface, boolean z2) {
        if (z2) {
            return;
        }
        TextDrawableHelper.access$002(this.a, true);
        TextDrawableHelper$TextDrawableDelegate textDrawableHelper$TextDrawableDelegate = (TextDrawableHelper$TextDrawableDelegate) TextDrawableHelper.access$100(this.a).get();
        if (textDrawableHelper$TextDrawableDelegate != null) {
            textDrawableHelper$TextDrawableDelegate.onTextSizeChange();
        }
    }
}
