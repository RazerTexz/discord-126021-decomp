package b.i.a.c.x2.j0;

import b.i.a.c.f3.e0;
import b.i.a.c.f3.x;
import b.i.a.c.j1;
import b.i.a.c.x2.s;
import b.i.a.c.x2.t;
import b.i.a.c.x2.w;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: OggExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements b.i.a.c.x2.h {
    public b.i.a.c.x2.j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f1236b;
    public boolean c;

    static {
        a aVar = a.a;
    }

    @EnsuresNonNullIf(expression = {"streamReader"}, result = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS)
    public final boolean a(b.i.a.c.x2.i iVar) throws IOException {
        boolean zN2;
        boolean zEquals;
        f fVar = new f();
        if (fVar.a(iVar, true) && (fVar.f1238b & 2) == 2) {
            int iMin = Math.min(fVar.f, 8);
            x xVar = new x(iMin);
            iVar.o(xVar.a, 0, iMin);
            xVar.E(0);
            if (xVar.a() >= 5 && xVar.t() == 127 && xVar.u() == 1179402563) {
                this.f1236b = new c();
            } else {
                xVar.E(0);
                try {
                    zN2 = b.c.a.a0.d.n2(1, xVar, true);
                } catch (ParserException unused) {
                    zN2 = false;
                }
                if (zN2) {
                    this.f1236b = new j();
                } else {
                    xVar.E(0);
                    int iA = xVar.a();
                    byte[] bArr = h.n;
                    if (iA < bArr.length) {
                        zEquals = false;
                    } else {
                        byte[] bArr2 = new byte[bArr.length];
                        int length = bArr.length;
                        System.arraycopy(xVar.a, xVar.f984b, bArr2, 0, length);
                        xVar.f984b += length;
                        zEquals = Arrays.equals(bArr2, bArr);
                    }
                    if (zEquals) {
                        this.f1236b = new h();
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // b.i.a.c.x2.h
    public boolean b(b.i.a.c.x2.i iVar) throws IOException {
        try {
            return a(iVar);
        } catch (ParserException unused) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:70:0x0180  */
    /* JADX WARN: Code duplicated, block: B:78:? A[RETURN, SYNTHETIC] */
    @Override // b.i.a.c.x2.h
    public int e(b.i.a.c.x2.i iVar, s sVar) throws IOException {
        boolean z2;
        int i;
        e eVar;
        x xVar;
        byte[] bArr;
        b.c.a.a0.d.H(this.a);
        if (this.f1236b == null) {
            if (!a(iVar)) {
                throw ParserException.a("Failed to determine bitstream type", null);
            }
            iVar.k();
        }
        if (!this.c) {
            w wVarP = this.a.p(0, 1);
            this.a.j();
            i iVar2 = this.f1236b;
            iVar2.c = this.a;
            iVar2.f1239b = wVarP;
            iVar2.e(true);
            this.c = true;
        }
        i iVar3 = this.f1236b;
        b.c.a.a0.d.H(iVar3.f1239b);
        int i2 = e0.a;
        int i3 = iVar3.h;
        int i4 = 3;
        if (i3 == 0) {
            while (true) {
                if (!iVar3.a.b(iVar)) {
                    iVar3.h = i4;
                    z2 = false;
                    break;
                }
                long position = iVar.getPosition();
                long j = iVar3.f;
                iVar3.k = position - j;
                if (!iVar3.d(iVar3.a.f1237b, j, iVar3.j)) {
                    z2 = true;
                    break;
                }
                iVar3.f = iVar.getPosition();
                i4 = 3;
            }
            if (z2) {
                j1 j1Var = iVar3.j.a;
                iVar3.i = j1Var.K;
                if (!iVar3.m) {
                    iVar3.f1239b.e(j1Var);
                    iVar3.m = true;
                }
                g gVar = iVar3.j.f1240b;
                if (gVar == null) {
                    if (iVar.b() == -1) {
                        iVar3.d = new i$c(null);
                    } else {
                        f fVar = iVar3.a.a;
                        i = 2;
                        iVar3.d = new b(iVar3, iVar3.f, iVar.b(), fVar.e + fVar.f, fVar.c, (fVar.f1238b & 4) != 0);
                    }
                    iVar3.h = i;
                    eVar = iVar3.a;
                    xVar = eVar.f1237b;
                    bArr = xVar.a;
                    if (bArr.length == 65025) {
                        return 0;
                    }
                    xVar.C(Arrays.copyOf(bArr, Math.max(65025, xVar.c)), eVar.f1237b.c);
                    return 0;
                }
                iVar3.d = gVar;
                i = 2;
                iVar3.h = i;
                eVar = iVar3.a;
                xVar = eVar.f1237b;
                bArr = xVar.a;
                if (bArr.length == 65025) {
                    return 0;
                }
                xVar.C(Arrays.copyOf(bArr, Math.max(65025, xVar.c)), eVar.f1237b.c);
                return 0;
            }
        } else {
            if (i3 == 1) {
                iVar.l((int) iVar3.f);
                iVar3.h = 2;
                return 0;
            }
            if (i3 == 2) {
                long jB = iVar3.d.b(iVar);
                if (jB >= 0) {
                    sVar.a = jB;
                    return 1;
                }
                if (jB < -1) {
                    iVar3.b(-(jB + 2));
                }
                if (!iVar3.l) {
                    t tVarA = iVar3.d.a();
                    b.c.a.a0.d.H(tVarA);
                    iVar3.c.a(tVarA);
                    iVar3.l = true;
                }
                if (iVar3.k > 0 || iVar3.a.b(iVar)) {
                    iVar3.k = 0L;
                    x xVar2 = iVar3.a.f1237b;
                    long jC = iVar3.c(xVar2);
                    if (jC >= 0) {
                        long j2 = iVar3.g;
                        if (j2 + jC >= iVar3.e) {
                            long j3 = (j2 * 1000000) / ((long) iVar3.i);
                            iVar3.f1239b.c(xVar2, xVar2.c);
                            iVar3.f1239b.d(j3, 1, xVar2.c, 0, null);
                            iVar3.e = -1L;
                        }
                    }
                    iVar3.g += jC;
                    return 0;
                }
                iVar3.h = 3;
            } else if (i3 != 3) {
                throw new IllegalStateException();
            }
        }
        return -1;
    }

    @Override // b.i.a.c.x2.h
    public void f(b.i.a.c.x2.j jVar) {
        this.a = jVar;
    }

    @Override // b.i.a.c.x2.h
    public void g(long j, long j2) {
        i iVar = this.f1236b;
        if (iVar != null) {
            e eVar = iVar.a;
            eVar.a.b();
            eVar.f1237b.A(0);
            eVar.c = -1;
            eVar.e = false;
            if (j == 0) {
                iVar.e(!iVar.l);
                return;
            }
            if (iVar.h != 0) {
                long j3 = (((long) iVar.i) * j2) / 1000000;
                iVar.e = j3;
                g gVar = iVar.d;
                int i = e0.a;
                gVar.c(j3);
                iVar.h = 2;
            }
        }
    }

    @Override // b.i.a.c.x2.h
    public void release() {
    }
}
