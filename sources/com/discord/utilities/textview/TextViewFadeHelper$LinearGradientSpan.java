package com.discord.utilities.textview;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader$TileMode;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

/* JADX INFO: compiled from: TextViewFadeHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextViewFadeHelper$LinearGradientSpan extends CharacterStyle implements UpdateAppearance {
    public final /* synthetic */ TextViewFadeHelper this$0;

    public TextViewFadeHelper$LinearGradientSpan(TextViewFadeHelper textViewFadeHelper) {
        this.this$0 = textViewFadeHelper;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint tp) {
        Float lineWidth;
        if (tp == null || (lineWidth = this.this$0.getLineWidth()) == null) {
            return;
        }
        float fFloatValue = lineWidth.floatValue();
        tp.bgColor = 0;
        tp.setShader(new LinearGradient(0.0f, 0.0f, fFloatValue, 0.0f, this.this$0.getTextView().getCurrentTextColor(), Color.parseColor("#00000000"), Shader$TileMode.CLAMP));
    }
}
