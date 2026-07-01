package com.discord.utilities.spans;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.Path;
import android.graphics.Path$Direction;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BulletSpan.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BulletSpan implements LeadingMarginSpan {
    public static final BulletSpan$Companion Companion = new BulletSpan$Companion(null);
    public static final int STANDARD_BULLET_RADIUS_PX = 4;
    public static final int STANDARD_GAP_WIDTH_PX = 2;
    public static final float STANDARD_STROKE_WIDTH_PX = 4.0f;
    private static Path sBulletPath;
    private final int mBulletRadius;
    private final int mColor;
    private final int mGapWidth;
    private final float mStrokeWidth;
    private final Paint$Style mStyle;
    private final boolean mWantColor;

    public /* synthetic */ BulletSpan(int i, int i2, float f, Paint$Style paint$Style, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 2 : i, (i3 & 2) != 0 ? 4 : i2, (i3 & 4) != 0 ? 4.0f : f, (i3 & 8) != 0 ? Paint$Style.FILL : paint$Style);
    }

    @Override // android.text.style.LeadingMarginSpan
    @SuppressLint({"NewApi"})
    public void drawLeadingMargin(Canvas c, Paint p, int x2, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout l) {
        m.checkNotNullParameter(c, "c");
        m.checkNotNullParameter(p, "p");
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        m.checkNotNullParameter(l, "l");
        if (((Spanned) text).getSpanStart(this) == start) {
            Paint$Style style = p.getStyle();
            int color = 0;
            if (this.mWantColor) {
                color = p.getColor();
                p.setColor(this.mColor);
            }
            p.setStyle(this.mStyle);
            Paint$Style paint$Style = this.mStyle;
            if (paint$Style == Paint$Style.STROKE || paint$Style == Paint$Style.FILL_AND_STROKE) {
                p.setStrokeWidth(this.mStrokeWidth);
            }
            if (c.isHardwareAccelerated()) {
                if (sBulletPath == null) {
                    Path path = new Path();
                    sBulletPath = path;
                    m.checkNotNull(path);
                    path.addCircle(0.0f, 0.0f, this.mBulletRadius * 1.2f, Path$Direction.CW);
                }
                c.save();
                c.translate((dir * 1.2f * this.mBulletRadius) + x2, (top + bottom) / 2.0f);
                Path path2 = sBulletPath;
                m.checkNotNull(path2);
                c.drawPath(path2, p);
                c.restore();
            } else {
                int i = this.mBulletRadius;
                c.drawCircle((dir * i) + x2, (top + bottom) / 2.0f, i, p);
            }
            if (this.mWantColor) {
                p.setColor(color);
            }
            p.setStyle(style);
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean first) {
        return (this.mBulletRadius * 2) + this.mGapWidth;
    }

    public BulletSpan(int i, int i2, float f, Paint$Style paint$Style) {
        m.checkNotNullParameter(paint$Style, "style");
        this.mGapWidth = i;
        this.mBulletRadius = i2;
        this.mWantColor = false;
        this.mColor = 0;
        this.mStyle = paint$Style;
        this.mStrokeWidth = f;
    }

    public /* synthetic */ BulletSpan(int i, int i2, int i3, float f, Paint$Style paint$Style, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i4 & 4) != 0 ? 4 : i3, (i4 & 8) != 0 ? 4.0f : f, (i4 & 16) != 0 ? Paint$Style.FILL : paint$Style);
    }

    public BulletSpan(int i, int i2, int i3, float f, Paint$Style paint$Style) {
        m.checkNotNullParameter(paint$Style, "style");
        this.mGapWidth = i;
        this.mBulletRadius = i3;
        this.mWantColor = true;
        this.mColor = i2;
        this.mStyle = paint$Style;
        this.mStrokeWidth = f;
    }
}
