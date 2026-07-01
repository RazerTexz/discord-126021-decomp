package com.discord.views;

import android.content.Context;
import android.graphics.Path;
import android.graphics.Path$Direction;
import android.graphics.Path$Op;
import android.graphics.RectF;
import b.c.a.a0.d;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: NumericBadgingView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NumericBadgingView$a implements CutoutView$a {
    public final RectF a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f2831b;

    public NumericBadgingView$a(RectF rectF, float f) {
        m.checkNotNullParameter(rectF, "badgeRect");
        this.a = rectF;
        this.f2831b = f;
    }

    @Override // com.discord.views.CutoutView$a
    public Path a(Context context, int i, int i2) {
        m.checkNotNullParameter(context, "context");
        RectF rectF = new RectF(0.0f, 0.0f, this.a.width(), this.a.height());
        if (d.U0(context)) {
            rectF.offset(i - this.a.width(), 0.0f);
        }
        float f = this.f2831b;
        rectF.inset(-f, -f);
        Path path = new Path();
        float fHeight = ((2 * this.f2831b) + this.a.height()) / 2.0f;
        path.addRoundRect(rectF, fHeight, fHeight, Path$Direction.CW);
        Path path2 = new Path();
        path2.addRect(0.0f, 0.0f, i, i2, Path$Direction.CW);
        Path path3 = new Path(path2);
        path3.op(path, Path$Op.DIFFERENCE);
        return path3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NumericBadgingView$a)) {
            return false;
        }
        NumericBadgingView$a numericBadgingView$a = (NumericBadgingView$a) obj;
        return m.areEqual(this.a, numericBadgingView$a.a) && Float.compare(this.f2831b, numericBadgingView$a.f2831b) == 0;
    }

    public int hashCode() {
        RectF rectF = this.a;
        return Float.floatToIntBits(this.f2831b) + ((rectF != null ? rectF.hashCode() : 0) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("BadgeRectStyle(badgeRect=");
        sbU.append(this.a);
        sbU.append(", insetPx=");
        sbU.append(this.f2831b);
        sbU.append(")");
        return sbU.toString();
    }
}
