package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat$FontCallback;

/* JADX INFO: loaded from: classes3.dex */
public class TextAppearance$a extends ResourcesCompat$FontCallback {
    public final /* synthetic */ TextAppearanceFontCallback a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextAppearance f3050b;

    public TextAppearance$a(TextAppearance textAppearance, TextAppearanceFontCallback textAppearanceFontCallback) {
        this.f3050b = textAppearance;
        this.a = textAppearanceFontCallback;
    }

    @Override // androidx.core.content.res.ResourcesCompat$FontCallback
    public void onFontRetrievalFailed(int i) {
        TextAppearance.access$102(this.f3050b, true);
        this.a.onFontRetrievalFailed(i);
    }

    @Override // androidx.core.content.res.ResourcesCompat$FontCallback
    public void onFontRetrieved(@NonNull Typeface typeface) {
        TextAppearance textAppearance = this.f3050b;
        TextAppearance.access$002(textAppearance, Typeface.create(typeface, textAppearance.textStyle));
        TextAppearance.access$102(this.f3050b, true);
        this.a.onFontRetrieved(TextAppearance.access$000(this.f3050b), false);
    }
}
