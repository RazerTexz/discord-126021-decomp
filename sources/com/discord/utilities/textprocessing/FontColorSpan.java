package com.discord.utilities.textprocessing;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.ColorInt;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: FontColorSpan.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FontColorSpan extends MetricAffectingSpan {
    private final int colorInt;

    public FontColorSpan(@ColorInt int i) {
        this.colorInt = i;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (textPaint != null) {
            textPaint.setColor(this.colorInt);
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        Intrinsics3.checkNotNullParameter(textPaint, "textPaint");
        textPaint.setColor(this.colorInt);
    }
}
