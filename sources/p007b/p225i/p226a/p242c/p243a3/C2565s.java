package p007b.p225i.p226a.p242c.p243a3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p257e3.C2712n;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2680a0;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;

/* JADX INFO: renamed from: b.i.a.c.a3.s */
/* JADX INFO: compiled from: IcyDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2565s implements InterfaceC2710l {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2710l f5698a;

    /* JADX INFO: renamed from: b */
    public final int f5699b;

    /* JADX INFO: renamed from: c */
    public final a f5700c;

    /* JADX INFO: renamed from: d */
    public final byte[] f5701d;

    /* JADX INFO: renamed from: e */
    public int f5702e;

    /* JADX INFO: renamed from: b.i.a.c.a3.s$a */
    /* JADX INFO: compiled from: IcyDataSource.java */
    public interface a {
    }

    public C2565s(InterfaceC2710l interfaceC2710l, int i, a aVar) {
        C1460d.m531j(i > 0);
        this.f5698a = interfaceC2710l;
        this.f5699b = i;
        this.f5700c = aVar;
        this.f5701d = new byte[1];
        this.f5702e = i;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: a */
    public long mo2586a(C2712n c2712n) {
        throw new UnsupportedOperationException();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: d */
    public void mo2587d(InterfaceC2680a0 interfaceC2680a0) {
        Objects.requireNonNull(interfaceC2680a0);
        this.f5698a.mo2587d(interfaceC2680a0);
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: j */
    public Map<String, List<String>> mo2588j() {
        return this.f5698a.mo2588j();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    @Nullable
    /* JADX INFO: renamed from: n */
    public Uri mo2589n() {
        return this.f5698a.mo2589n();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2706h
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long jMax;
        if (this.f5702e == 0) {
            boolean z2 = true;
            if (this.f5698a.read(this.f5701d, 0, 1) == -1) {
                z2 = false;
                break;
            }
            int i3 = (this.f5701d[0] & 255) << 4;
            if (i3 != 0) {
                byte[] bArr2 = new byte[i3];
                int i4 = i3;
                int i5 = 0;
                while (true) {
                    if (i4 <= 0) {
                        while (i3 > 0) {
                            int i6 = i3 - 1;
                            if (bArr2[i6] != 0) {
                                break;
                            }
                            i3 = i6;
                        }
                        if (i3 <= 0) {
                            break;
                        }
                        a aVar = this.f5700c;
                        C2757x c2757x = new C2757x(bArr2, i3);
                        C2538e0.a aVar2 = (C2538e0.a) aVar;
                        if (aVar2.f5551n) {
                            C2538e0 c2538e0 = C2538e0.this;
                            Map<String, String> map = C2538e0.f5498j;
                            jMax = Math.max(c2538e0.m2498v(), aVar2.f5547j);
                        } else {
                            jMax = aVar2.f5547j;
                        }
                        int iM3081a = c2757x.m3081a();
                        InterfaceC3122w interfaceC3122w = aVar2.f5550m;
                        Objects.requireNonNull(interfaceC3122w);
                        interfaceC3122w.mo2524c(c2757x, iM3081a);
                        interfaceC3122w.mo2525d(jMax, 1, iM3081a, 0, null);
                        aVar2.f5551n = true;
                        break;
                    }
                    int i7 = this.f5698a.read(bArr2, i5, i4);
                    if (i7 == -1) {
                        z2 = false;
                        break;
                    }
                    i5 += i7;
                    i4 -= i7;
                }
            }
            if (!z2) {
                return -1;
            }
            this.f5702e = this.f5699b;
        }
        int i8 = this.f5698a.read(bArr, i, Math.min(this.f5702e, i2));
        if (i8 != -1) {
            this.f5702e -= i8;
        }
        return i8;
    }
}
