package com.facebook.drawee.span;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class SimpleDraweeSpanTextView extends TextView {

    /* JADX INFO: renamed from: j */
    public DraweeSpanStringBuilder f19521j;

    /* JADX INFO: renamed from: k */
    public boolean f19522k;

    public SimpleDraweeSpanTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19522k = false;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f19522k = true;
        DraweeSpanStringBuilder draweeSpanStringBuilder = this.f19521j;
        if (draweeSpanStringBuilder != null) {
            draweeSpanStringBuilder.m8684a(this);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        this.f19522k = false;
        DraweeSpanStringBuilder draweeSpanStringBuilder = this.f19521j;
        if (draweeSpanStringBuilder != null) {
            draweeSpanStringBuilder.m8685b(this);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f19522k = true;
        DraweeSpanStringBuilder draweeSpanStringBuilder = this.f19521j;
        if (draweeSpanStringBuilder != null) {
            draweeSpanStringBuilder.m8684a(this);
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        this.f19522k = false;
        DraweeSpanStringBuilder draweeSpanStringBuilder = this.f19521j;
        if (draweeSpanStringBuilder != null) {
            draweeSpanStringBuilder.m8685b(this);
        }
        super.onStartTemporaryDetach();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        DraweeSpanStringBuilder draweeSpanStringBuilder = this.f19521j;
        if (draweeSpanStringBuilder != null) {
            draweeSpanStringBuilder.m8685b(this);
        }
        this.f19521j = null;
    }

    public void setDraweeSpanStringBuilder(DraweeSpanStringBuilder draweeSpanStringBuilder) {
        setText(draweeSpanStringBuilder, TextView.BufferType.SPANNABLE);
        this.f19521j = draweeSpanStringBuilder;
        if (draweeSpanStringBuilder == null || !this.f19522k) {
            return;
        }
        draweeSpanStringBuilder.m8684a(this);
    }
}
