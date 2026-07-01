package com.discord.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Path;
import android.graphics.RectF;
import b.c.a.a0.d;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: CutoutView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CutoutView$a$c implements CutoutView$a {
    public final int a;

    public CutoutView$a$c(int i) {
        this.a = i;
    }

    @Override // com.discord.views.CutoutView$a
    public Path a(Context context, int i, int i2) {
        m.checkNotNullParameter(context, "context");
        float f = this.a;
        Resources resources = context.getResources();
        m.checkNotNullExpressionValue(resources, "context.resources");
        float f2 = f * resources.getDisplayMetrics().density;
        float f3 = i2;
        float f4 = f3 / 2.0f;
        if (d.U0(context)) {
            Path path = new Path();
            float f5 = i + f2;
            path.moveTo(0.0f, 0.0f);
            path.lineTo(f5, 0.0f);
            path.arcTo(new RectF(f5 - f4, 0.0f, f5 + f4, f3), 270.0f, -180.0f);
            path.lineTo(0.0f, f3);
            path.lineTo(0.0f, 0.0f);
            return path;
        }
        Path path2 = new Path();
        float f6 = -f2;
        float f7 = i;
        path2.moveTo(f7, 0.0f);
        path2.lineTo(f6, 0.0f);
        path2.arcTo(new RectF(f6 - f4, 0.0f, f6 + f4, f3), 270.0f, 180.0f);
        path2.lineTo(f7, f3);
        path2.lineTo(f7, 0.0f);
        return path2;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CutoutView$a$c) && this.a == ((CutoutView$a$c) obj).a;
        }
        return true;
    }

    public int hashCode() {
        return this.a;
    }

    public String toString() {
        return a.B(a.U("EndOverlap(offsetDp="), this.a, ")");
    }
}
