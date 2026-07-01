package com.discord.utilities.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.RectF;
import android.text.Spanned;
import android.text.style.LineBackgroundSpan;
import androidx.annotation.ColorInt;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import d0.z.d.m;

/* JADX INFO: compiled from: BlockBackgroundSpan.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BlockBackgroundSpan implements LineBackgroundSpan {
    private final Paint fillPaint;
    private final int leftMargin;
    private final float radius;
    private final RectF rect;
    private final Paint strokePaint;

    public BlockBackgroundSpan(@ColorInt int i, @ColorInt int i2, int i3, int i4, int i5) {
        this.leftMargin = i5;
        Paint paint = new Paint();
        paint.setStyle(Paint$Style.FILL);
        paint.setColor(i);
        this.fillPaint = paint;
        Paint paint2 = new Paint();
        paint2.setStyle(Paint$Style.STROKE);
        paint2.setColor(i2);
        paint2.setStrokeWidth(i3);
        paint2.setAntiAlias(true);
        this.strokePaint = paint2;
        this.rect = new RectF();
        this.radius = i4;
    }

    public final void draw(Canvas canvas) {
        m.checkNotNullParameter(canvas, "canvas");
        RectF rectF = this.rect;
        float f = this.radius;
        canvas.drawRoundRect(rectF, f, f, this.fillPaint);
        RectF rectF2 = this.rect;
        float f2 = this.radius;
        canvas.drawRoundRect(rectF2, f2, f2, this.strokePaint);
    }

    @Override // android.text.style.LineBackgroundSpan
    public void drawBackground(Canvas canvas, Paint paint, int left, int right, int top, int baseline, int bottom, CharSequence text, int start, int end, int lnum) {
        m.checkNotNullParameter(canvas, "canvas");
        m.checkNotNullParameter(paint, "paint");
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        if (((Spanned) (!(text instanceof Spanned) ? null : text)) != null) {
            Spanned spanned = (Spanned) text;
            if (spanned.getSpanStart(this) == start) {
                RectF rectF = this.rect;
                rectF.left = left + this.leftMargin;
                rectF.top = top;
            }
            if (spanned.getSpanEnd(this) == end) {
                RectF rectF2 = this.rect;
                rectF2.right = right;
                rectF2.bottom = bottom;
                draw(canvas);
            }
        }
    }

    public final int getLeftMargin() {
        return this.leftMargin;
    }
}
