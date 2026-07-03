package p007b.p225i.p226a.p242c.p257e3;

import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.e3.o */
/* JADX INFO: compiled from: DefaultAllocator.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2713o {

    /* JADX INFO: renamed from: a */
    public final boolean f6562a;

    /* JADX INFO: renamed from: b */
    public final int f6563b;

    /* JADX INFO: renamed from: c */
    public final C2703e[] f6564c;

    /* JADX INFO: renamed from: d */
    public int f6565d;

    /* JADX INFO: renamed from: e */
    public int f6566e;

    /* JADX INFO: renamed from: f */
    public int f6567f;

    /* JADX INFO: renamed from: g */
    public C2703e[] f6568g;

    public C2713o(boolean z2, int i) {
        C1460d.m531j(i > 0);
        C1460d.m531j(true);
        this.f6562a = z2;
        this.f6563b = i;
        this.f6567f = 0;
        this.f6568g = new C2703e[100];
        this.f6564c = new C2703e[1];
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m2858a(C2703e[] c2703eArr) {
        int i = this.f6567f;
        int length = c2703eArr.length + i;
        C2703e[] c2703eArr2 = this.f6568g;
        if (length >= c2703eArr2.length) {
            this.f6568g = (C2703e[]) Arrays.copyOf(c2703eArr2, Math.max(c2703eArr2.length * 2, i + c2703eArr.length));
        }
        for (C2703e c2703e : c2703eArr) {
            C2703e[] c2703eArr3 = this.f6568g;
            int i2 = this.f6567f;
            this.f6567f = i2 + 1;
            c2703eArr3[i2] = c2703e;
        }
        this.f6566e -= c2703eArr.length;
        notifyAll();
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m2859b(int i) {
        boolean z2 = i < this.f6565d;
        this.f6565d = i;
        if (z2) {
            m2860c();
        }
    }

    /* JADX INFO: renamed from: c */
    public synchronized void m2860c() {
        int iMax = Math.max(0, C2738e0.m2998f(this.f6565d, this.f6563b) - this.f6566e);
        int i = this.f6567f;
        if (iMax >= i) {
            return;
        }
        Arrays.fill(this.f6568g, iMax, i, (Object) null);
        this.f6567f = iMax;
    }
}
