package b.i.a.c.b3.t;

import android.text.Layout;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.a.c.b3.t.f, reason: use source file name */
/* JADX INFO: compiled from: TtmlStyle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TtmlStyle {

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
    public Layout.Alignment o;

    @Nullable
    public Layout.Alignment p;

    @Nullable
    public TextEmphasis r;
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

    public TtmlStyle a(@Nullable TtmlStyle ttmlStyle) {
        int i;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (ttmlStyle != null) {
            if (!this.c && ttmlStyle.c) {
                this.f885b = ttmlStyle.f885b;
                this.c = true;
            }
            if (this.h == -1) {
                this.h = ttmlStyle.h;
            }
            if (this.i == -1) {
                this.i = ttmlStyle.i;
            }
            if (this.a == null && (str = ttmlStyle.a) != null) {
                this.a = str;
            }
            if (this.f == -1) {
                this.f = ttmlStyle.f;
            }
            if (this.g == -1) {
                this.g = ttmlStyle.g;
            }
            if (this.n == -1) {
                this.n = ttmlStyle.n;
            }
            if (this.o == null && (alignment2 = ttmlStyle.o) != null) {
                this.o = alignment2;
            }
            if (this.p == null && (alignment = ttmlStyle.p) != null) {
                this.p = alignment;
            }
            if (this.q == -1) {
                this.q = ttmlStyle.q;
            }
            if (this.j == -1) {
                this.j = ttmlStyle.j;
                this.k = ttmlStyle.k;
            }
            if (this.r == null) {
                this.r = ttmlStyle.r;
            }
            if (this.f886s == Float.MAX_VALUE) {
                this.f886s = ttmlStyle.f886s;
            }
            if (!this.e && ttmlStyle.e) {
                this.d = ttmlStyle.d;
                this.e = true;
            }
            if (this.m == -1 && (i = ttmlStyle.m) != -1) {
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
