package com.discord.views;

import android.content.Context;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.IntRange;
import b.c.a.a0.d;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: CutoutView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CutoutView$a$b implements CutoutView$a {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2827b;

    public CutoutView$a$b(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        this.a = i;
        this.f2827b = i2;
    }

    @Override // com.discord.views.CutoutView$a
    public Path a(Context context, int i, int i2) {
        m.checkNotNullParameter(context, "context");
        float f = i;
        int i3 = this.a;
        float f2 = i3 - (f / 2.0f);
        float f3 = i3 * 2.0f;
        float f4 = -f2;
        float f5 = i2 + f2;
        if (d.U0(context)) {
            float f6 = f - this.f2827b;
            RectF rectF = new RectF(f6, f4, f3 + f6, f5);
            Path path = new Path();
            path.moveTo(f4, f4);
            path.arcTo(rectF, 270.0f, -180.0f);
            path.lineTo(f4, f5);
            path.close();
            return path;
        }
        float f7 = this.f2827b;
        RectF rectF2 = new RectF(f7 - f3, f4, f7, f5);
        Path path2 = new Path();
        float f8 = f + f2;
        path2.moveTo(f8, f4);
        path2.arcTo(rectF2, 270.0f, 180.0f);
        path2.lineTo(f8, f5);
        path2.close();
        return path2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CutoutView$a$b)) {
            return false;
        }
        CutoutView$a$b cutoutView$a$b = (CutoutView$a$b) obj;
        return this.a == cutoutView$a$b.a && this.f2827b == cutoutView$a$b.f2827b;
    }

    public int hashCode() {
        return (this.a * 31) + this.f2827b;
    }

    public String toString() {
        StringBuilder sbU = a.U("End(cutCurveRadiusPx=");
        sbU.append(this.a);
        sbU.append(", cutDistanceInwardFromEdgePx=");
        return a.B(sbU, this.f2827b, ")");
    }
}
