package com.facebook.drawee.span;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class SimpleDraweeSpanTextView extends TextView {
    public DraweeSpanStringBuilder j;
    public boolean k;

    public SimpleDraweeSpanTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = false;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.k = true;
        DraweeSpanStringBuilder draweeSpanStringBuilder = this.j;
        if (draweeSpanStringBuilder != null) {
            draweeSpanStringBuilder.a(this);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        this.k = false;
        DraweeSpanStringBuilder draweeSpanStringBuilder = this.j;
        if (draweeSpanStringBuilder != null) {
            draweeSpanStringBuilder.b(this);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.k = true;
        DraweeSpanStringBuilder draweeSpanStringBuilder = this.j;
        if (draweeSpanStringBuilder != null) {
            draweeSpanStringBuilder.a(this);
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        this.k = false;
        DraweeSpanStringBuilder draweeSpanStringBuilder = this.j;
        if (draweeSpanStringBuilder != null) {
            draweeSpanStringBuilder.b(this);
        }
        super.onStartTemporaryDetach();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        DraweeSpanStringBuilder draweeSpanStringBuilder = this.j;
        if (draweeSpanStringBuilder != null) {
            draweeSpanStringBuilder.b(this);
        }
        this.j = null;
    }

    public void setDraweeSpanStringBuilder(DraweeSpanStringBuilder draweeSpanStringBuilder) {
        setText(draweeSpanStringBuilder, TextView.BufferType.SPANNABLE);
        this.j = draweeSpanStringBuilder;
        if (draweeSpanStringBuilder == null || !this.k) {
            return;
        }
        draweeSpanStringBuilder.a(this);
    }
}
