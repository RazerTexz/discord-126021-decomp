package p007b.p225i.p226a.p242c.p267x2.p275j0;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2757x;

/* JADX INFO: renamed from: b.i.a.c.x2.j0.h */
/* JADX INFO: compiled from: OpusReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3066h extends AbstractC3067i {

    /* JADX INFO: renamed from: n */
    public static final byte[] f8538n = {79, 112, 117, 115, 72, 101, 97, 100};

    /* JADX INFO: renamed from: o */
    public boolean f8539o;

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.AbstractC3067i
    /* JADX INFO: renamed from: c */
    public long mo3737c(C2757x c2757x) {
        int i;
        byte[] bArr = c2757x.f6793a;
        int i2 = bArr[0] & 255;
        int i3 = i2 & 3;
        int i4 = 2;
        if (i3 == 0) {
            i4 = 1;
        } else if (i3 != 1 && i3 != 2) {
            i4 = bArr[1] & 63;
        }
        int i5 = i2 >> 3;
        int i6 = i5 & 3;
        if (i5 >= 16) {
            i = 2500 << i6;
        } else if (i5 >= 12) {
            i = 10000 << (i6 & 1);
        } else {
            i = i6 == 3 ? 60000 : 10000 << i6;
        }
        return m3746a(((long) i4) * ((long) i));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.AbstractC3067i
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    /* JADX INFO: renamed from: d */
    public boolean mo3738d(C2757x c2757x, long j, AbstractC3067i.b bVar) {
        if (this.f8539o) {
            Objects.requireNonNull(bVar.f8553a);
            boolean z2 = c2757x.m3086f() == 1332770163;
            c2757x.m3079E(0);
            return z2;
        }
        byte[] bArrCopyOf = Arrays.copyOf(c2757x.f6793a, c2757x.f6795c);
        int i = bArrCopyOf[9] & 255;
        List<byte[]> listM519g = C1460d.m519g(bArrCopyOf);
        C2811j1.b bVar2 = new C2811j1.b();
        bVar2.f7173k = "audio/opus";
        bVar2.f7186x = i;
        bVar2.f7187y = 48000;
        bVar2.f7175m = listM519g;
        bVar.f8553a = bVar2.m3277a();
        this.f8539o = true;
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.AbstractC3067i
    /* JADX INFO: renamed from: e */
    public void mo3739e(boolean z2) {
        super.mo3739e(z2);
        if (z2) {
            this.f8539o = false;
        }
    }
}
