package com.discord.utilities.textview;

import android.text.Layout;
import android.text.Spannable;
import android.widget.TextView;
import d0.z.d.m;

/* JADX INFO: compiled from: TextViewFadeHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextViewFadeHelper {
    private Float lineWidth;
    private final TextViewFadeHelper$LinearGradientSpan span;
    private final TextView textView;

    public TextViewFadeHelper(TextView textView) {
        m.checkNotNullParameter(textView, "textView");
        this.textView = textView;
        this.span = new TextViewFadeHelper$LinearGradientSpan(this);
    }

    public static final /* synthetic */ void access$updateFade(TextViewFadeHelper textViewFadeHelper) {
        textViewFadeHelper.updateFade();
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
                        if (spanStart == lineStart && spanEnd == lineEnd && m.areEqual(this.lineWidth, lineWidth)) {
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

    public final TextViewFadeHelper$LinearGradientSpan getSpan() {
        return this.span;
    }

    public final TextView getTextView() {
        return this.textView;
    }

    public final TextView registerFadeHelper() {
        TextView textView = this.textView;
        textView.addOnAttachStateChangeListener(new TextViewFadeHelper$registerFadeHelper$$inlined$apply$lambda$3(textView, new TextViewFadeHelper$registerFadeHelper$$inlined$apply$lambda$1(this), new TextViewFadeHelper$registerFadeHelper$$inlined$apply$lambda$2(this)));
        return textView;
    }

    public final void setLineWidth(Float f) {
        this.lineWidth = f;
    }
}
