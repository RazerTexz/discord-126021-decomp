package p007b.p225i.p226a.p242c.p267x2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import p007b.p225i.p226a.p242c.C2807i1;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2706h;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.x2.e */
/* JADX INFO: compiled from: DefaultExtractorInput.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3011e implements InterfaceC3041i {

    /* JADX INFO: renamed from: b */
    public final InterfaceC2706h f8115b;

    /* JADX INFO: renamed from: c */
    public final long f8116c;

    /* JADX INFO: renamed from: d */
    public long f8117d;

    /* JADX INFO: renamed from: f */
    public int f8119f;

    /* JADX INFO: renamed from: g */
    public int f8120g;

    /* JADX INFO: renamed from: e */
    public byte[] f8118e = new byte[65536];

    /* JADX INFO: renamed from: a */
    public final byte[] f8114a = new byte[4096];

    static {
        C2807i1.m3272a("goog.exo.extractor");
    }

    public C3011e(InterfaceC2706h interfaceC2706h, long j, long j2) {
        this.f8115b = interfaceC2706h;
        this.f8117d = j;
        this.f8116c = j2;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i
    /* JADX INFO: renamed from: b */
    public long mo3642b() {
        return this.f8116c;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i
    /* JADX INFO: renamed from: c */
    public boolean mo3643c(byte[] bArr, int i, int i2, boolean z2) throws IOException {
        int iMin;
        int i3 = this.f8120g;
        if (i3 == 0) {
            iMin = 0;
        } else {
            iMin = Math.min(i3, i2);
            System.arraycopy(this.f8118e, 0, bArr, i, iMin);
            m3656s(iMin);
        }
        int iM3655r = iMin;
        while (iM3655r < i2 && iM3655r != -1) {
            iM3655r = m3655r(bArr, i, i2, iM3655r, z2);
        }
        m3653p(iM3655r);
        return iM3655r != -1;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i
    /* JADX INFO: renamed from: e */
    public boolean mo3644e(byte[] bArr, int i, int i2, boolean z2) throws IOException {
        if (!mo3651m(i2, z2)) {
            return false;
        }
        System.arraycopy(this.f8118e, this.f8119f - i2, bArr, i, i2);
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i
    /* JADX INFO: renamed from: f */
    public long mo3645f() {
        return this.f8117d + ((long) this.f8119f);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i
    /* JADX INFO: renamed from: g */
    public void mo3646g(int i) throws IOException {
        mo3651m(i, false);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i
    public long getPosition() {
        return this.f8117d;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i
    /* JADX INFO: renamed from: h */
    public int mo3647h(int i) throws IOException {
        int iMin = Math.min(this.f8120g, i);
        m3656s(iMin);
        if (iMin == 0) {
            byte[] bArr = this.f8114a;
            iMin = m3655r(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        m3653p(iMin);
        return iMin;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i
    /* JADX INFO: renamed from: i */
    public int mo3648i(byte[] bArr, int i, int i2) throws IOException {
        int iMin;
        m3654q(i2);
        int i3 = this.f8120g;
        int i4 = this.f8119f;
        int i5 = i3 - i4;
        if (i5 == 0) {
            iMin = m3655r(this.f8118e, i4, i2, 0, true);
            if (iMin == -1) {
                return -1;
            }
            this.f8120g += iMin;
        } else {
            iMin = Math.min(i2, i5);
        }
        System.arraycopy(this.f8118e, this.f8119f, bArr, i, iMin);
        this.f8119f += iMin;
        return iMin;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i
    /* JADX INFO: renamed from: k */
    public void mo3649k() {
        this.f8119f = 0;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i
    /* JADX INFO: renamed from: l */
    public void mo3650l(int i) throws IOException {
        int iMin = Math.min(this.f8120g, i);
        m3656s(iMin);
        int iM3655r = iMin;
        while (iM3655r < i && iM3655r != -1) {
            iM3655r = m3655r(this.f8114a, -iM3655r, Math.min(i, this.f8114a.length + iM3655r), iM3655r, false);
        }
        m3653p(iM3655r);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i
    /* JADX INFO: renamed from: m */
    public boolean mo3651m(int i, boolean z2) throws IOException {
        m3654q(i);
        int iM3655r = this.f8120g - this.f8119f;
        while (iM3655r < i) {
            iM3655r = m3655r(this.f8118e, this.f8119f, i, iM3655r, z2);
            if (iM3655r == -1) {
                return false;
            }
            this.f8120g = this.f8119f + iM3655r;
        }
        this.f8119f += i;
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i
    /* JADX INFO: renamed from: o */
    public void mo3652o(byte[] bArr, int i, int i2) throws IOException {
        mo3644e(bArr, i, i2, false);
    }

    /* JADX INFO: renamed from: p */
    public final void m3653p(int i) {
        if (i != -1) {
            this.f8117d += (long) i;
        }
    }

    /* JADX INFO: renamed from: q */
    public final void m3654q(int i) {
        int i2 = this.f8119f + i;
        byte[] bArr = this.f8118e;
        if (i2 > bArr.length) {
            this.f8118e = Arrays.copyOf(this.f8118e, C2738e0.m3000h(bArr.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    /* JADX INFO: renamed from: r */
    public final int m3655r(byte[] bArr, int i, int i2, int i3, boolean z2) throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int i4 = this.f8115b.read(bArr, i + i3, i2 - i3);
        if (i4 != -1) {
            return i3 + i4;
        }
        if (i3 == 0 && z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i, p007b.p225i.p226a.p242c.p257e3.InterfaceC2706h
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f8120g;
        int iM3655r = 0;
        if (i3 != 0) {
            int iMin = Math.min(i3, i2);
            System.arraycopy(this.f8118e, 0, bArr, i, iMin);
            m3656s(iMin);
            iM3655r = iMin;
        }
        if (iM3655r == 0) {
            iM3655r = m3655r(bArr, i, i2, 0, true);
        }
        m3653p(iM3655r);
        return iM3655r;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        mo3643c(bArr, i, i2, false);
    }

    /* JADX INFO: renamed from: s */
    public final void m3656s(int i) {
        int i2 = this.f8120g - i;
        this.f8120g = i2;
        this.f8119f = 0;
        byte[] bArr = this.f8118e;
        byte[] bArr2 = i2 < bArr.length - 524288 ? new byte[65536 + i2] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.f8118e = bArr2;
    }
}
