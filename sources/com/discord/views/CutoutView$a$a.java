package com.discord.views;

import android.content.Context;
import android.graphics.Path;
import android.graphics.Path$Direction;
import android.graphics.Path$Op;
import androidx.annotation.Px;
import b.c.a.a0.d;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: CutoutView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CutoutView$a$a implements CutoutView$a {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2826b;

    public CutoutView$a$a() {
        int i = CutoutView.j;
        int i2 = CutoutView.k;
        this.a = i;
        this.f2826b = i2;
    }

    @Override // com.discord.views.CutoutView$a
    public Path a(Context context, int i, int i2) {
        m.checkNotNullParameter(context, "context");
        Path path = new Path();
        path.addRect(0.0f, 0.0f, i, i2, Path$Direction.CW);
        Path path2 = new Path();
        path2.addCircle(d.U0(context) ? i - this.f2826b : this.f2826b, this.f2826b, this.a, Path$Direction.CW);
        Path path3 = new Path(path);
        path3.op(path2, Path$Op.DIFFERENCE);
        return path3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CutoutView$a$a)) {
            return false;
        }
        CutoutView$a$a cutoutView$a$a = (CutoutView$a$a) obj;
        return this.a == cutoutView$a$a.a && this.f2826b == cutoutView$a$a.f2826b;
    }

    public int hashCode() {
        return (this.a * 31) + this.f2826b;
    }

    public String toString() {
        StringBuilder sbU = a.U("CircularBadge(badgeRadius=");
        sbU.append(this.a);
        sbU.append(", inset=");
        return a.B(sbU, this.f2826b, ")");
    }

    public CutoutView$a$a(int i, int i2, int i3) {
        i = (i3 & 1) != 0 ? CutoutView.j : i;
        i2 = (i3 & 2) != 0 ? CutoutView.k : i2;
        this.a = i;
        this.f2826b = i2;
    }

    public CutoutView$a$a(@Px int i, @Px int i2) {
        this.a = i;
        this.f2826b = i2;
    }
}
