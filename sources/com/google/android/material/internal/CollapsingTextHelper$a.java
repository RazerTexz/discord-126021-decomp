package com.google.android.material.internal;

import android.graphics.Typeface;
import com.google.android.material.resources.CancelableFontCallback$ApplyFont;

/* JADX INFO: loaded from: classes3.dex */
public class CollapsingTextHelper$a implements CancelableFontCallback$ApplyFont {
    public final /* synthetic */ CollapsingTextHelper a;

    public CollapsingTextHelper$a(CollapsingTextHelper collapsingTextHelper) {
        this.a = collapsingTextHelper;
    }

    @Override // com.google.android.material.resources.CancelableFontCallback$ApplyFont
    public void apply(Typeface typeface) {
        this.a.setCollapsedTypeface(typeface);
    }
}
