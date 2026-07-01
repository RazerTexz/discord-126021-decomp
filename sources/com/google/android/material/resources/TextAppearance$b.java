package com.google.android.material.resources;

import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class TextAppearance$b extends TextAppearanceFontCallback {
    public final /* synthetic */ TextPaint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextAppearanceFontCallback f3051b;
    public final /* synthetic */ TextAppearance c;

    public TextAppearance$b(TextAppearance textAppearance, TextPaint textPaint, TextAppearanceFontCallback textAppearanceFontCallback) {
        this.c = textAppearance;
        this.a = textPaint;
        this.f3051b = textAppearanceFontCallback;
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrievalFailed(int i) {
        this.f3051b.onFontRetrievalFailed(i);
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrieved(@NonNull Typeface typeface, boolean z2) {
        this.c.updateTextPaintMeasureState(this.a, typeface);
        this.f3051b.onFontRetrieved(typeface, z2);
    }
}
