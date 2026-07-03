package p007b.p225i.p226a.p242c.p267x2.p275j0;

import java.io.EOFException;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;

/* JADX INFO: renamed from: b.i.a.c.x2.j0.e */
/* JADX INFO: compiled from: OggPacket.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3063e {

    /* JADX INFO: renamed from: a */
    public final C3064f f8525a = new C3064f();

    /* JADX INFO: renamed from: b */
    public final C2757x f8526b = new C2757x(new byte[65025], 0);

    /* JADX INFO: renamed from: c */
    public int f8527c = -1;

    /* JADX INFO: renamed from: d */
    public int f8528d;

    /* JADX INFO: renamed from: e */
    public boolean f8529e;

    /* JADX INFO: renamed from: a */
    public final int m3741a(int i) {
        int i2;
        int i3 = 0;
        this.f8528d = 0;
        do {
            int i4 = this.f8528d;
            int i5 = i + i4;
            C3064f c3064f = this.f8525a;
            if (i5 >= c3064f.f8533d) {
                break;
            }
            int[] iArr = c3064f.f8536g;
            this.f8528d = i4 + 1;
            i2 = iArr[i4 + i];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    /* JADX INFO: renamed from: b */
    public boolean m3742b(InterfaceC3041i interfaceC3041i) throws IOException {
        boolean z2;
        int i;
        boolean z3;
        C1460d.m426D(interfaceC3041i != null);
        if (this.f8529e) {
            this.f8529e = false;
            this.f8526b.m3075A(0);
        }
        while (!this.f8529e) {
            if (this.f8527c < 0) {
                if (!this.f8525a.m3745c(interfaceC3041i, -1L) || !this.f8525a.m3743a(interfaceC3041i, true)) {
                    return false;
                }
                C3064f c3064f = this.f8525a;
                int iM3741a = c3064f.f8534e;
                if ((c3064f.f8531b & 1) == 1 && this.f8526b.f6795c == 0) {
                    iM3741a += m3741a(0);
                    i = this.f8528d + 0;
                } else {
                    i = 0;
                }
                try {
                    interfaceC3041i.mo3650l(iM3741a);
                    z3 = true;
                } catch (EOFException unused) {
                    z3 = false;
                }
                if (!z3) {
                    return false;
                }
                this.f8527c = i;
            }
            int iM3741a2 = m3741a(this.f8527c);
            int i2 = this.f8527c + this.f8528d;
            if (iM3741a2 > 0) {
                C2757x c2757x = this.f8526b;
                c2757x.m3082b(c2757x.f6795c + iM3741a2);
                C2757x c2757x2 = this.f8526b;
                try {
                    interfaceC3041i.readFully(c2757x2.f6793a, c2757x2.f6795c, iM3741a2);
                    z2 = true;
                } catch (EOFException unused2) {
                    z2 = false;
                }
                if (!z2) {
                    return false;
                }
                C2757x c2757x3 = this.f8526b;
                c2757x3.m3078D(c2757x3.f6795c + iM3741a2);
                this.f8529e = this.f8525a.f8536g[i2 + (-1)] != 255;
            }
            if (i2 == this.f8525a.f8533d) {
                i2 = -1;
            }
            this.f8527c = i2;
        }
        return true;
    }
}
