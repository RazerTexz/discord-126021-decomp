package p007b.p225i.p226a.p242c.p267x2.p276k0;

import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.w */
/* JADX INFO: compiled from: NalUnitTargetBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3102w {

    /* JADX INFO: renamed from: a */
    public final int f8903a;

    /* JADX INFO: renamed from: b */
    public boolean f8904b;

    /* JADX INFO: renamed from: c */
    public boolean f8905c;

    /* JADX INFO: renamed from: d */
    public byte[] f8906d;

    /* JADX INFO: renamed from: e */
    public int f8907e;

    public C3102w(int i, int i2) {
        this.f8903a = i;
        byte[] bArr = new byte[i2 + 3];
        this.f8906d = bArr;
        bArr[2] = 1;
    }

    /* JADX INFO: renamed from: a */
    public void m3788a(byte[] bArr, int i, int i2) {
        if (this.f8904b) {
            int i3 = i2 - i;
            byte[] bArr2 = this.f8906d;
            int length = bArr2.length;
            int i4 = this.f8907e;
            if (length < i4 + i3) {
                this.f8906d = Arrays.copyOf(bArr2, (i4 + i3) * 2);
            }
            System.arraycopy(bArr, i, this.f8906d, this.f8907e, i3);
            this.f8907e += i3;
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m3789b(int i) {
        if (!this.f8904b) {
            return false;
        }
        this.f8907e -= i;
        this.f8904b = false;
        this.f8905c = true;
        return true;
    }

    /* JADX INFO: renamed from: c */
    public void m3790c() {
        this.f8904b = false;
        this.f8905c = false;
    }

    /* JADX INFO: renamed from: d */
    public void m3791d(int i) {
        C1460d.m426D(!this.f8904b);
        boolean z2 = i == this.f8903a;
        this.f8904b = z2;
        if (z2) {
            this.f8907e = 3;
            this.f8905c = false;
        }
    }
}
