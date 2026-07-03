package com.discord.utilities.view.text;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.facebook.drawee.span.DraweeSpanStringBuilder;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleDraweeSpanTextView extends AppCompatTextView {
    private DraweeSpanStringBuilder mDraweeStringBuilder;
    private boolean mIsAttached;

    public SimpleDraweeSpanTextView(Context context) {
        super(context);
        this.mIsAttached = false;
    }

    public void detachCurrentDraweeSpanStringBuilder() {
        DraweeSpanStringBuilder draweeSpanStringBuilder = this.mDraweeStringBuilder;
        if (draweeSpanStringBuilder != null) {
            draweeSpanStringBuilder.m8685b(this);
        }
        this.mDraweeStringBuilder = null;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttached = true;
        DraweeSpanStringBuilder draweeSpanStringBuilder = this.mDraweeStringBuilder;
        if (draweeSpanStringBuilder != null) {
            draweeSpanStringBuilder.m8684a(this);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        this.mIsAttached = false;
        DraweeSpanStringBuilder draweeSpanStringBuilder = this.mDraweeStringBuilder;
        if (draweeSpanStringBuilder != null) {
            draweeSpanStringBuilder.m8685b(this);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.mIsAttached = true;
        DraweeSpanStringBuilder draweeSpanStringBuilder = this.mDraweeStringBuilder;
        if (draweeSpanStringBuilder != null) {
            draweeSpanStringBuilder.m8684a(this);
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        this.mIsAttached = false;
        DraweeSpanStringBuilder draweeSpanStringBuilder = this.mDraweeStringBuilder;
        if (draweeSpanStringBuilder != null) {
            draweeSpanStringBuilder.m8685b(this);
        }
        super.onStartTemporaryDetach();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        detachCurrentDraweeSpanStringBuilder();
    }

    public void setDraweeSpanStringBuilder(DraweeSpanStringBuilder draweeSpanStringBuilder) {
        setText(draweeSpanStringBuilder, TextView.BufferType.SPANNABLE);
        this.mDraweeStringBuilder = draweeSpanStringBuilder;
        if (draweeSpanStringBuilder == null || !this.mIsAttached) {
            return;
        }
        draweeSpanStringBuilder.m8684a(this);
    }

    public SimpleDraweeSpanTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsAttached = false;
    }

    public SimpleDraweeSpanTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsAttached = false;
    }
}
