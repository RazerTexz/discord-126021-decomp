package b.i.a.c.x2.c0;

import b.c.a.a0.d;
import b.i.a.c.f3.e0;
import b.i.a.c.j1$b;
import b.i.a.c.x2.h;
import b.i.a.c.x2.i;
import b.i.a.c.x2.j;
import b.i.a.c.x2.s;
import b.i.a.c.x2.t;
import b.i.a.c.x2.t$b;
import b.i.a.c.x2.w;
import com.google.android.exoplayer2.ParserException;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: AmrExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements h {
    public static final int[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1165b;
    public static final byte[] c;
    public static final byte[] d;
    public static final int e;
    public final byte[] f;
    public final int g;
    public boolean h;
    public long i;
    public int j;
    public int k;
    public boolean l;
    public long m;
    public int n;
    public int o;
    public long p;
    public j q;
    public w r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public t f1166s;
    public boolean t;

    static {
        a aVar = a.a;
        a = new int[]{13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f1165b = iArr;
        c = e0.w("#!AMR\n");
        d = e0.w("#!AMR-WB\n");
        e = iArr[8];
    }

    public b(int i) {
        this.g = (i & 2) != 0 ? i | 1 : i;
        this.f = new byte[1];
        this.n = -1;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x003c  */
    public final int a(i iVar) throws IOException {
        iVar.k();
        boolean z2 = false;
        iVar.o(this.f, 0, 1);
        byte b2 = this.f[0];
        if ((b2 & 131) > 0) {
            throw b.d.b.a.a.w0(42, "Invalid padding bits for frame header ", b2, null);
        }
        int i = (b2 >> 3) & 15;
        if (i >= 0 && i <= 15) {
            boolean z3 = this.h;
            if (z3 && (i < 10 || i > 13)) {
                z2 = true;
            } else {
                if (!z3 && (i < 12 || i > 14)) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            return this.h ? f1165b[i] : a[i];
        }
        String str = this.h ? "WB" : "NB";
        StringBuilder sb = new StringBuilder(str.length() + 35);
        sb.append("Illegal AMR ");
        sb.append(str);
        sb.append(" frame type ");
        sb.append(i);
        throw ParserException.a(sb.toString(), null);
    }

    @Override // b.i.a.c.x2.h
    public boolean b(i iVar) throws IOException {
        return c(iVar);
    }

    public final boolean c(i iVar) throws IOException {
        byte[] bArr = c;
        iVar.k();
        byte[] bArr2 = new byte[bArr.length];
        iVar.o(bArr2, 0, bArr.length);
        if (Arrays.equals(bArr2, bArr)) {
            this.h = false;
            iVar.l(bArr.length);
            return true;
        }
        byte[] bArr3 = d;
        iVar.k();
        byte[] bArr4 = new byte[bArr3.length];
        iVar.o(bArr4, 0, bArr3.length);
        if (!Arrays.equals(bArr4, bArr3)) {
            return false;
        }
        this.h = true;
        iVar.l(bArr3.length);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0088  */
    /* JADX WARN: Code duplicated, block: B:32:0x008a  */
    /* JADX WARN: Code duplicated, block: B:35:0x0092  */
    @Override // b.i.a.c.x2.h
    public int e(i iVar, s sVar) throws IOException {
        int i;
        int i2;
        int iB;
        int i3;
        d.H(this.r);
        if (iVar.getPosition() == 0 && !c(iVar)) {
            throw ParserException.a("Could not find AMR header.", null);
        }
        if (!this.t) {
            this.t = true;
            boolean z2 = this.h;
            String str = z2 ? "audio/amr-wb" : "audio/3gpp";
            int i4 = z2 ? 16000 : 8000;
            w wVar = this.r;
            j1$b j1_b = new j1$b();
            j1_b.k = str;
            j1_b.l = e;
            j1_b.f1023x = 1;
            j1_b.f1024y = i4;
            wVar.e(j1_b.a());
        }
        if (this.k == 0) {
            try {
                int iA = a(iVar);
                this.j = iA;
                this.k = iA;
                if (this.n == -1) {
                    this.m = iVar.getPosition();
                    this.n = this.j;
                }
                if (this.n == this.j) {
                    this.o++;
                }
                iB = this.r.b(iVar, this.k, true);
                if (iB == -1) {
                    i = -1;
                } else {
                    i3 = this.k - iB;
                    this.k = i3;
                    if (i3 <= 0) {
                        this.r.d(this.p + this.i, 1, this.j, 0, null);
                        this.i += 20000;
                    }
                    i = 0;
                }
            } catch (EOFException unused) {
            }
        } else {
            iB = this.r.b(iVar, this.k, true);
            if (iB == -1) {
                i = -1;
            } else {
                i3 = this.k - iB;
                this.k = i3;
                if (i3 <= 0) {
                    this.r.d(this.p + this.i, 1, this.j, 0, null);
                    this.i += 20000;
                }
                i = 0;
            }
        }
        long jB = iVar.b();
        if (!this.l) {
            int i5 = this.g;
            if ((i5 & 1) == 0 || jB == -1 || !((i2 = this.n) == -1 || i2 == this.j)) {
                t$b t_b = new t$b(-9223372036854775807L, 0L);
                this.f1166s = t_b;
                this.q.a(t_b);
                this.l = true;
            } else if (this.o >= 20 || i == -1) {
                b.i.a.c.x2.d dVar = new b.i.a.c.x2.d(jB, this.m, (int) ((((long) (i2 * 8)) * 1000000) / 20000), i2, (i5 & 2) != 0);
                this.f1166s = dVar;
                this.q.a(dVar);
                this.l = true;
            }
        }
        return i;
    }

    @Override // b.i.a.c.x2.h
    public void f(j jVar) {
        this.q = jVar;
        this.r = jVar.p(0, 1);
        jVar.j();
    }

    @Override // b.i.a.c.x2.h
    public void g(long j, long j2) {
        this.i = 0L;
        this.j = 0;
        this.k = 0;
        if (j != 0) {
            t tVar = this.f1166s;
            if (tVar instanceof b.i.a.c.x2.d) {
                b.i.a.c.x2.d dVar = (b.i.a.c.x2.d) tVar;
                this.p = b.i.a.c.x2.d.e(j, dVar.f1167b, dVar.e);
                return;
            }
        }
        this.p = 0L;
    }

    @Override // b.i.a.c.x2.h
    public void release() {
    }
}
