package p007b.p225i.p226a.p242c.p267x2.p275j0;

import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.C3112m;
import p007b.p225i.p226a.p242c.p267x2.C3113n;
import p007b.p225i.p226a.p242c.p267x2.C3114o;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;

/* JADX INFO: renamed from: b.i.a.c.x2.j0.c */
/* JADX INFO: compiled from: FlacReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3061c extends AbstractC3067i {

    /* JADX INFO: renamed from: n */
    @Nullable
    public C3114o f8516n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public a f8517o;

    /* JADX INFO: renamed from: b.i.a.c.x2.j0.c$a */
    /* JADX INFO: compiled from: FlacReader.java */
    public static final class a implements InterfaceC3065g {

        /* JADX INFO: renamed from: a */
        public C3114o f8518a;

        /* JADX INFO: renamed from: b */
        public C3114o.a f8519b;

        /* JADX INFO: renamed from: c */
        public long f8520c = -1;

        /* JADX INFO: renamed from: d */
        public long f8521d = -1;

        public a(C3114o c3114o, C3114o.a aVar) {
            this.f8518a = c3114o;
            this.f8519b = aVar;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.InterfaceC3065g
        /* JADX INFO: renamed from: a */
        public InterfaceC3119t mo3734a() {
            C1460d.m426D(this.f8520c != -1);
            return new C3113n(this.f8518a, this.f8520c);
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.InterfaceC3065g
        /* JADX INFO: renamed from: b */
        public long mo3735b(InterfaceC3041i interfaceC3041i) {
            long j = this.f8521d;
            if (j < 0) {
                return -1L;
            }
            long j2 = -(j + 2);
            this.f8521d = -1L;
            return j2;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.InterfaceC3065g
        /* JADX INFO: renamed from: c */
        public void mo3736c(long j) {
            long[] jArr = this.f8519b.f8982a;
            this.f8521d = jArr[C2738e0.m2997e(jArr, j, true, true)];
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.AbstractC3067i
    /* JADX INFO: renamed from: c */
    public long mo3737c(C2757x c2757x) {
        byte[] bArr = c2757x.f6793a;
        if (!(bArr[0] == -1)) {
            return -1L;
        }
        int i = (bArr[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            c2757x.m3080F(4);
            c2757x.m3106z();
        }
        int iM3804c = C3112m.m3804c(c2757x, i);
        c2757x.m3079E(0);
        return iM3804c;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.AbstractC3067i
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    /* JADX INFO: renamed from: d */
    public boolean mo3738d(C2757x c2757x, long j, AbstractC3067i.b bVar) {
        byte[] bArr = c2757x.f6793a;
        C3114o c3114o = this.f8516n;
        if (c3114o == null) {
            C3114o c3114o2 = new C3114o(bArr, 17);
            this.f8516n = c3114o2;
            bVar.f8553a = c3114o2.m3811e(Arrays.copyOfRange(bArr, 9, c2757x.f6795c), null);
            return true;
        }
        if ((bArr[0] & 127) == 3) {
            C3114o.a aVarM452L1 = C1460d.m452L1(c2757x);
            C3114o c3114oM3809b = c3114o.m3809b(aVarM452L1);
            this.f8516n = c3114oM3809b;
            this.f8517o = new a(c3114oM3809b, aVarM452L1);
            return true;
        }
        if (!(bArr[0] == -1)) {
            return true;
        }
        a aVar = this.f8517o;
        if (aVar != null) {
            aVar.f8520c = j;
            bVar.f8554b = aVar;
        }
        Objects.requireNonNull(bVar.f8553a);
        return false;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.AbstractC3067i
    /* JADX INFO: renamed from: e */
    public void mo3739e(boolean z2) {
        super.mo3739e(z2);
        if (z2) {
            this.f8516n = null;
            this.f8517o = null;
        }
    }
}
