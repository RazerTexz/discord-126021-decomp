package com.discord.utilities.spans;

import android.graphics.Paint$FontMetricsInt;
import android.text.Spanned;
import android.text.style.LineHeightSpan;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import d0.z.d.m;

/* JADX INFO: compiled from: VerticalPaddingSpan.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VerticalPaddingSpan implements LineHeightSpan {
    private boolean initialized;
    private final int paddingBottom;
    private final int paddingTop;
    private int origTop = -1;
    private int origAscent = -1;
    private int origBottom = -1;
    private int origDescent = -1;

    public VerticalPaddingSpan(int i, int i2) {
        this.paddingTop = i;
        this.paddingBottom = i2;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence text, int start, int end, int spanstartv, int v, Paint$FontMetricsInt fontMetrics) {
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        m.checkNotNullParameter(fontMetrics, "fontMetrics");
        if (((Spanned) (!(text instanceof Spanned) ? null : text)) != null) {
            if (!this.initialized) {
                this.origTop = fontMetrics.top;
                this.origAscent = fontMetrics.ascent;
                this.origBottom = fontMetrics.bottom;
                this.origDescent = fontMetrics.descent;
                this.initialized = true;
            }
            Spanned spanned = (Spanned) text;
            if (spanned.getSpanStart(this) == start) {
                int i = fontMetrics.top;
                int i2 = this.paddingTop;
                fontMetrics.top = i - i2;
                fontMetrics.ascent -= i2;
            } else {
                fontMetrics.top = this.origTop;
                fontMetrics.ascent = this.origAscent;
            }
            if (spanned.getSpanEnd(this) != end) {
                fontMetrics.bottom = this.origBottom;
                fontMetrics.descent = this.origDescent;
            } else {
                int i3 = fontMetrics.bottom;
                int i4 = this.paddingBottom;
                fontMetrics.bottom = i3 + i4;
                fontMetrics.descent += i4;
            }
        }
    }

    public final int getPaddingBottom() {
        return this.paddingBottom;
    }
}
