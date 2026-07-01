package com.discord.utilities.textview;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import android.view.View;
import android.widget.TextView;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TextViewFadeHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextViewFadeHelper {
    private Float lineWidth;
    private final LinearGradientSpan span;
    private final TextView textView;

    /* JADX INFO: compiled from: TextViewFadeHelper.kt */
    public final class LinearGradientSpan extends CharacterStyle implements UpdateAppearance {
        public LinearGradientSpan() {
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint tp) {
            Float lineWidth;
            if (tp == null || (lineWidth = TextViewFadeHelper.this.getLineWidth()) == null) {
                return;
            }
            float fFloatValue = lineWidth.floatValue();
            tp.bgColor = 0;
            tp.setShader(new LinearGradient(0.0f, 0.0f, fFloatValue, 0.0f, TextViewFadeHelper.this.getTextView().getCurrentTextColor(), Color.parseColor("#00000000"), Shader.TileMode.CLAMP));
        }
    }

    public TextViewFadeHelper(TextView textView) {
        Intrinsics3.checkNotNullParameter(textView, "textView");
        this.textView = textView;
        this.span = new LinearGradientSpan();
    }

    private final void updateFade() {
        Layout layout = this.textView.getLayout();
        if (layout != null) {
            CharSequence text = this.textView.getText();
            if (!(text instanceof Spannable)) {
                text = null;
            }
            Spannable spannable = (Spannable) text;
            if (spannable != null) {
                int lineCount = this.textView.getLineCount();
                int maxLines = this.textView.getMaxLines();
                int spanStart = spannable.getSpanStart(this.span);
                int spanEnd = spannable.getSpanEnd(this.span);
                boolean z2 = (spanStart == -1 || spanEnd == -1) ? false : true;
                if (lineCount <= maxLines && z2) {
                    spannable.removeSpan(this.span);
                } else {
                    if (lineCount <= maxLines) {
                        return;
                    }
                    int i = maxLines - 1;
                    int lineStart = layout.getLineStart(i);
                    int lineEnd = layout.getLineEnd(i);
                    float lineWidth = layout.getLineWidth(i);
                    if (z2) {
                        if (spanStart == lineStart && spanEnd == lineEnd && Intrinsics3.areEqual(this.lineWidth, lineWidth)) {
                            return;
                        } else {
                            spannable.removeSpan(this.span);
                        }
                    }
                    this.lineWidth = Float.valueOf(lineWidth);
                    spannable.setSpan(this.span, lineStart, lineEnd, 0);
                }
                this.textView.setText(spannable);
            }
        }
    }

    public final Float getLineWidth() {
        return this.lineWidth;
    }

    public final LinearGradientSpan getSpan() {
        return this.span;
    }

    public final TextView getTextView() {
        return this.textView;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.discord.utilities.textview.TextViewFadeHelper$registerFadeHelper$$inlined$apply$lambda$2] */
    public final TextView registerFadeHelper() {
        final TextView textView = this.textView;
        final View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.discord.utilities.textview.TextViewFadeHelper$registerFadeHelper$$inlined$apply$lambda$1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.this$0.updateFade();
            }
        };
        final ?? r2 = new TextWatcher() { // from class: com.discord.utilities.textview.TextViewFadeHelper$registerFadeHelper$$inlined$apply$lambda$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s2) {
                this.this$0.updateFade();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s2, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s2, int start, int before, int count) {
            }
        };
        textView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.discord.utilities.textview.TextViewFadeHelper$registerFadeHelper$$inlined$apply$lambda$3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                textView.addOnLayoutChangeListener(onLayoutChangeListener);
                textView.addTextChangedListener(r2);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                textView.removeOnLayoutChangeListener(onLayoutChangeListener);
                textView.removeTextChangedListener(r2);
            }
        });
        return textView;
    }

    public final void setLineWidth(Float f) {
        this.lineWidth = f;
    }
}
