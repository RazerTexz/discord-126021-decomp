package com.discord.utilities.spans;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.text.style.TypefaceSpan;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TypefaceSpanCompat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypefaceSpanCompat extends MetricAffectingSpan {
    private final Typeface typeface;

    /* JADX INFO: compiled from: TypefaceSpanCompat.kt */
    public static final class Monospace extends TypefaceSpan {
        public Monospace() {
            super("monospace");
        }
    }

    public TypefaceSpanCompat(Typeface typeface) {
        Intrinsics3.checkNotNullParameter(typeface, "typeface");
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
        Intrinsics3.checkNotNullParameter(drawState, "drawState");
        apply(drawState);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint paint) {
        Intrinsics3.checkNotNullParameter(paint, "paint");
        apply(paint);
    }
}
