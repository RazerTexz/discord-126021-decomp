package b.i.a.c.b3.t;

import android.text.Layout$Alignment;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: TtmlStyle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    @Nullable
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f885b;
    public boolean c;
    public int d;
    public boolean e;
    public float k;

    @Nullable
    public String l;

    @Nullable
    public Layout$Alignment o;

    @Nullable
    public Layout$Alignment p;

    @Nullable
    public b r;
    public int f = -1;
    public int g = -1;
    public int h = -1;
    public int i = -1;
    public int j = -1;
    public int m = -1;
    public int n = -1;
    public int q = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f886s = Float.MAX_VALUE;

    public f a(@Nullable f fVar) {
        int i;
        Layout$Alignment layout$Alignment;
        Layout$Alignment layout$Alignment2;
        String str;
        if (fVar != null) {
            if (!this.c && fVar.c) {
                this.f885b = fVar.f885b;
                this.c = true;
            }
            if (this.h == -1) {
                this.h = fVar.h;
            }
            if (this.i == -1) {
                this.i = fVar.i;
            }
            if (this.a == null && (str = fVar.a) != null) {
                this.a = str;
            }
            if (this.f == -1) {
                this.f = fVar.f;
            }
            if (this.g == -1) {
                this.g = fVar.g;
            }
            if (this.n == -1) {
                this.n = fVar.n;
            }
            if (this.o == null && (layout$Alignment2 = fVar.o) != null) {
                this.o = layout$Alignment2;
            }
            if (this.p == null && (layout$Alignment = fVar.p) != null) {
                this.p = layout$Alignment;
            }
            if (this.q == -1) {
                this.q = fVar.q;
            }
            if (this.j == -1) {
                this.j = fVar.j;
                this.k = fVar.k;
            }
            if (this.r == null) {
                this.r = fVar.r;
            }
            if (this.f886s == Float.MAX_VALUE) {
                this.f886s = fVar.f886s;
            }
            if (!this.e && fVar.e) {
                this.d = fVar.d;
                this.e = true;
            }
            if (this.m == -1 && (i = fVar.m) != -1) {
                this.m = i;
            }
        }
        return this;
    }

    public int b() {
        int i = this.h;
        if (i == -1 && this.i == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.i == 1 ? 2 : 0);
    }
}
