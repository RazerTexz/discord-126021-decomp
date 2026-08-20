package p007b.p225i.p226a.p242c.p267x2;

import androidx.annotation.Nullable;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.c.x2.x */
/* JADX INFO: compiled from: TrueHdSampleRechunker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3123x {

    /* JADX INFO: renamed from: a */
    public final byte[] f9004a = new byte[10];

    /* JADX INFO: renamed from: b */
    public boolean f9005b;

    /* JADX INFO: renamed from: c */
    public int f9006c;

    /* JADX INFO: renamed from: d */
    public long f9007d;

    /* JADX INFO: renamed from: e */
    public int f9008e;

    /* JADX INFO: renamed from: f */
    public int f9009f;

    /* JADX INFO: renamed from: g */
    public int f9010g;

    /* JADX INFO: renamed from: a */
    public void m3819a(InterfaceC3122w interfaceC3122w, @Nullable InterfaceC3122w.a aVar) {
        if (this.f9006c > 0) {
            interfaceC3122w.mo2525d(this.f9007d, this.f9008e, this.f9009f, this.f9010g, aVar);
            this.f9006c = 0;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3820b(InterfaceC3122w interfaceC3122w, long j, int i, int i2, int i3, @Nullable InterfaceC3122w.a aVar) {
        C1460d.m429E(this.f9010g <= i2 + i3, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.f9005b) {
            int i4 = this.f9006c;
            int i5 = i4 + 1;
            this.f9006c = i5;
            if (i4 == 0) {
                this.f9007d = j;
                this.f9008e = i;
                this.f9009f = 0;
            }
            this.f9009f += i2;
            this.f9010g = i3;
            if (i5 >= 16) {
                m3819a(interfaceC3122w, aVar);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m3821c(InterfaceC3041i interfaceC3041i) throws IOException {
        if (this.f9005b) {
            return;
        }
        int i = 0;
        interfaceC3041i.mo3652o(this.f9004a, 0, 10);
        interfaceC3041i.mo3649k();
        byte[] bArr = this.f9004a;
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
            i = 40 << ((bArr[((bArr[7] & 255) == 187 ? 1 : 0) != 0 ? '\t' : '\b'] >> 4) & 7);
        }
        if (i == 0) {
            return;
        }
        this.f9005b = true;
    }
}
