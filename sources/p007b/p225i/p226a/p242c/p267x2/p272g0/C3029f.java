package p007b.p225i.p226a.p242c.p267x2.p272g0;

import java.io.IOException;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;

/* JADX INFO: renamed from: b.i.a.c.x2.g0.f */
/* JADX INFO: compiled from: Sniffer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3029f {

    /* JADX INFO: renamed from: a */
    public final C2757x f8300a = new C2757x(8);

    /* JADX INFO: renamed from: b */
    public int f8301b;

    /* JADX INFO: renamed from: a */
    public final long m3684a(InterfaceC3041i interfaceC3041i) throws IOException {
        int i = 0;
        interfaceC3041i.mo3652o(this.f8300a.f6793a, 0, 1);
        int i2 = this.f8300a.f6793a[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (~i3);
        interfaceC3041i.mo3652o(this.f8300a.f6793a, 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.f8300a.f6793a[i] & 255) + (i5 << 8);
        }
        this.f8301b = i4 + 1 + this.f8301b;
        return i5;
    }
}
