package com.discord.utilities.spans;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import d0.z.d.m;

/* JADX INFO: compiled from: TypefaceSpanCompat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypefaceSpanCompat extends MetricAffectingSpan {
    private final Typeface typeface;

    public TypefaceSpanCompat(Typeface typeface) {
        m.checkNotNullParameter(typeface, "typeface");
        this.typeface = typeface;
    }

    private final void apply(Paint paint) {
        Typeface typeface = paint.getTypeface();
        int style = (typeface != null ? typeface.getStyle() : 0) & (~this.typeface.getStyle());
        if ((style & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((style & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(this.typeface);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint drawState) {
        m.checkNotNullParameter(drawState, "drawState");
        apply(drawState);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint paint) {
        m.checkNotNullParameter(paint, "paint");
        apply(paint);
    }
}
