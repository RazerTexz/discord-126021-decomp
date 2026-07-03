package p007b.p225i.p226a.p242c.p245b3.p252t;

import android.text.Layout;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.a.c.b3.t.f */
/* JADX INFO: compiled from: TtmlStyle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2616f {

    /* JADX INFO: renamed from: a */
    @Nullable
    public String f6073a;

    /* JADX INFO: renamed from: b */
    public int f6074b;

    /* JADX INFO: renamed from: c */
    public boolean f6075c;

    /* JADX INFO: renamed from: d */
    public int f6076d;

    /* JADX INFO: renamed from: e */
    public boolean f6077e;

    /* JADX INFO: renamed from: k */
    public float f6083k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public String f6084l;

    /* JADX INFO: renamed from: o */
    @Nullable
    public Layout.Alignment f6087o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public Layout.Alignment f6088p;

    /* JADX INFO: renamed from: r */
    @Nullable
    public C2612b f6090r;

    /* JADX INFO: renamed from: f */
    public int f6078f = -1;

    /* JADX INFO: renamed from: g */
    public int f6079g = -1;

    /* JADX INFO: renamed from: h */
    public int f6080h = -1;

    /* JADX INFO: renamed from: i */
    public int f6081i = -1;

    /* JADX INFO: renamed from: j */
    public int f6082j = -1;

    /* JADX INFO: renamed from: m */
    public int f6085m = -1;

    /* JADX INFO: renamed from: n */
    public int f6086n = -1;

    /* JADX INFO: renamed from: q */
    public int f6089q = -1;

    /* JADX INFO: renamed from: s */
    public float f6091s = Float.MAX_VALUE;

    /* JADX INFO: renamed from: a */
    public C2616f m2701a(@Nullable C2616f c2616f) {
        int i;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (c2616f != null) {
            if (!this.f6075c && c2616f.f6075c) {
                this.f6074b = c2616f.f6074b;
                this.f6075c = true;
            }
            if (this.f6080h == -1) {
                this.f6080h = c2616f.f6080h;
            }
            if (this.f6081i == -1) {
                this.f6081i = c2616f.f6081i;
            }
            if (this.f6073a == null && (str = c2616f.f6073a) != null) {
                this.f6073a = str;
            }
            if (this.f6078f == -1) {
                this.f6078f = c2616f.f6078f;
            }
            if (this.f6079g == -1) {
                this.f6079g = c2616f.f6079g;
            }
            if (this.f6086n == -1) {
                this.f6086n = c2616f.f6086n;
            }
            if (this.f6087o == null && (alignment2 = c2616f.f6087o) != null) {
                this.f6087o = alignment2;
            }
            if (this.f6088p == null && (alignment = c2616f.f6088p) != null) {
                this.f6088p = alignment;
            }
            if (this.f6089q == -1) {
                this.f6089q = c2616f.f6089q;
            }
            if (this.f6082j == -1) {
                this.f6082j = c2616f.f6082j;
                this.f6083k = c2616f.f6083k;
            }
            if (this.f6090r == null) {
                this.f6090r = c2616f.f6090r;
            }
            if (this.f6091s == Float.MAX_VALUE) {
                this.f6091s = c2616f.f6091s;
            }
            if (!this.f6077e && c2616f.f6077e) {
                this.f6076d = c2616f.f6076d;
                this.f6077e = true;
            }
            if (this.f6085m == -1 && (i = c2616f.f6085m) != -1) {
                this.f6085m = i;
            }
        }
        return this;
    }

    /* JADX INFO: renamed from: b */
    public int m2702b() {
        int i = this.f6080h;
        if (i == -1 && this.f6081i == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.f6081i == 1 ? 2 : 0);
    }
}
