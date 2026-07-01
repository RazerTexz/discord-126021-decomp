package b.i.a.c.x2.k0;

import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.i.a.c.x2.t$b;
import com.discord.api.permission.Permission;
import java.io.IOException;

/* JADX INFO: compiled from: PsExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements b.i.a.c.x2.h {
    public boolean e;
    public boolean f;
    public boolean g;
    public long h;

    @Nullable
    public z i;
    public b.i.a.c.x2.j j;
    public boolean k;
    public final b.i.a.c.f3.d0 a = new b.i.a.c.f3.d0(0);
    public final b.i.a.c.f3.x c = new b.i.a.c.f3.x(4096);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<b0$a> f1243b = new SparseArray<>();
    public final a0 d = new a0();

    static {
        d dVar = d.a;
    }

    @Override // b.i.a.c.x2.h
    public boolean b(b.i.a.c.x2.i iVar) throws IOException {
        byte[] bArr = new byte[14];
        iVar.o(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        iVar.g(bArr[13] & 7);
        iVar.o(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    /* JADX WARN: Code duplicated, block: B:105:0x021d  */
    @Override // b.i.a.c.x2.h
    public int e(b.i.a.c.x2.i iVar, b.i.a.c.x2.s sVar) throws IOException {
        int i;
        o pVar;
        b.c.a.a0.d.H(this.j);
        long jB = iVar.b();
        int i2 = 1;
        long j = -9223372036854775807L;
        if (jB != -1) {
            a0 a0Var = this.d;
            if (!a0Var.c) {
                if (!a0Var.e) {
                    long jB2 = iVar.b();
                    int iMin = (int) Math.min(20000L, jB2);
                    long j2 = jB2 - ((long) iMin);
                    if (iVar.getPosition() != j2) {
                        sVar.a = j2;
                    } else {
                        a0Var.f1242b.A(iMin);
                        iVar.k();
                        iVar.o(a0Var.f1242b.a, 0, iMin);
                        b.i.a.c.f3.x xVar = a0Var.f1242b;
                        int i3 = xVar.f984b;
                        for (int i4 = xVar.c - 4; i4 >= i3; i4--) {
                            if (a0Var.b(xVar.a, i4) == 442) {
                                xVar.E(i4 + 4);
                                long jC = a0.c(xVar);
                                if (jC != -9223372036854775807L) {
                                    j = jC;
                                    break;
                                }
                            }
                        }
                        a0Var.g = j;
                        a0Var.e = true;
                        i2 = 0;
                    }
                } else {
                    if (a0Var.g == -9223372036854775807L) {
                        a0Var.a(iVar);
                        return 0;
                    }
                    if (a0Var.d) {
                        long j3 = a0Var.f;
                        if (j3 == -9223372036854775807L) {
                            a0Var.a(iVar);
                            return 0;
                        }
                        long jB3 = a0Var.a.b(a0Var.g) - a0Var.a.b(j3);
                        a0Var.h = jB3;
                        if (jB3 < 0) {
                            Log.w("PsDurationReader", b.d.b.a.a.i(65, "Invalid duration: ", jB3, ". Using TIME_UNSET instead."));
                            a0Var.h = -9223372036854775807L;
                        }
                        a0Var.a(iVar);
                        return 0;
                    }
                    int iMin2 = (int) Math.min(20000L, iVar.b());
                    long j4 = 0;
                    if (iVar.getPosition() != j4) {
                        sVar.a = j4;
                    } else {
                        a0Var.f1242b.A(iMin2);
                        iVar.k();
                        iVar.o(a0Var.f1242b.a, 0, iMin2);
                        b.i.a.c.f3.x xVar2 = a0Var.f1242b;
                        int i5 = xVar2.c;
                        for (int i6 = xVar2.f984b; i6 < i5 - 3; i6++) {
                            if (a0Var.b(xVar2.a, i6) == 442) {
                                xVar2.E(i6 + 4);
                                long jC2 = a0.c(xVar2);
                                if (jC2 != -9223372036854775807L) {
                                    j = jC2;
                                    break;
                                }
                            }
                        }
                        a0Var.f = j;
                        a0Var.d = true;
                        i2 = 0;
                    }
                }
                return i2;
            }
        }
        if (this.k) {
            i = 442;
        } else {
            this.k = true;
            a0 a0Var2 = this.d;
            long j5 = a0Var2.h;
            if (j5 != -9223372036854775807L) {
                z zVar = new z(a0Var2.a, j5, jB);
                this.i = zVar;
                this.j.a(zVar.a);
                i = 442;
            } else {
                i = 442;
                this.j.a(new t$b(j5, 0L));
            }
        }
        z zVar2 = this.i;
        if (zVar2 != null && zVar2.b()) {
            return this.i.a(iVar, sVar);
        }
        iVar.k();
        long jF = jB != -1 ? jB - iVar.f() : -1L;
        if ((jF != -1 && jF < 4) || !iVar.e(this.c.a, 0, 4, true)) {
            return -1;
        }
        this.c.E(0);
        int iF = this.c.f();
        if (iF == 441) {
            return -1;
        }
        if (iF == i) {
            iVar.o(this.c.a, 0, 10);
            this.c.E(9);
            iVar.l((this.c.t() & 7) + 14);
            return 0;
        }
        if (iF == 443) {
            iVar.o(this.c.a, 0, 2);
            this.c.E(0);
            iVar.l(this.c.y() + 6);
            return 0;
        }
        if (((iF & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
            iVar.l(1);
            return 0;
        }
        int i7 = iF & 255;
        b0$a b0_a = this.f1243b.get(i7);
        if (!this.e) {
            if (b0_a == null) {
                o oVar = null;
                if (i7 == 189) {
                    pVar = new g(null);
                    this.f = true;
                    this.h = iVar.getPosition();
                } else if ((i7 & 224) == 192) {
                    pVar = new v(null);
                    this.f = true;
                    this.h = iVar.getPosition();
                } else if ((i7 & 240) == 224) {
                    pVar = new p(null);
                    this.g = true;
                    this.h = iVar.getPosition();
                } else if (oVar != null) {
                    oVar.e(this.j, new i0$d(Integer.MIN_VALUE, i7, 256));
                    b0_a = new b0$a(oVar, this.a);
                    this.f1243b.put(i7, b0_a);
                }
                oVar = pVar;
                if (oVar != null) {
                    oVar.e(this.j, new i0$d(Integer.MIN_VALUE, i7, 256));
                    b0_a = new b0$a(oVar, this.a);
                    this.f1243b.put(i7, b0_a);
                }
            }
            if (iVar.getPosition() > ((this.f && this.g) ? this.h + Permission.MANAGE_MESSAGES : Permission.CONNECT)) {
                this.e = true;
                this.j.j();
            }
        }
        iVar.o(this.c.a, 0, 2);
        this.c.E(0);
        int iY = this.c.y() + 6;
        if (b0_a == null) {
            iVar.l(iY);
            return 0;
        }
        this.c.A(iY);
        iVar.readFully(this.c.a, 0, iY);
        this.c.E(6);
        b.i.a.c.f3.x xVar3 = this.c;
        xVar3.e(b0_a.c.a, 0, 3);
        b0_a.c.k(0);
        b0_a.c.m(8);
        b0_a.d = b0_a.c.f();
        b0_a.e = b0_a.c.f();
        b0_a.c.m(6);
        int iG = b0_a.c.g(8);
        b0_a.g = iG;
        xVar3.e(b0_a.c.a, 0, iG);
        b0_a.c.k(0);
        b0_a.h = 0L;
        if (b0_a.d) {
            b0_a.c.m(4);
            long jG = ((long) b0_a.c.g(3)) << 30;
            b0_a.c.m(1);
            long jG2 = jG | ((long) (b0_a.c.g(15) << 15));
            b0_a.c.m(1);
            long jG3 = jG2 | ((long) b0_a.c.g(15));
            b0_a.c.m(1);
            if (!b0_a.f && b0_a.e) {
                b0_a.c.m(4);
                long jG4 = ((long) b0_a.c.g(3)) << 30;
                b0_a.c.m(1);
                long jG5 = jG4 | ((long) (b0_a.c.g(15) << 15));
                b0_a.c.m(1);
                long jG6 = ((long) b0_a.c.g(15)) | jG5;
                b0_a.c.m(1);
                b0_a.f1244b.b(jG6);
                b0_a.f = true;
            }
            b0_a.h = b0_a.f1244b.b(jG3);
        }
        b0_a.a.f(b0_a.h, 4);
        b0_a.a.b(xVar3);
        b0_a.a.d();
        b.i.a.c.f3.x xVar4 = this.c;
        xVar4.D(xVar4.a.length);
        return 0;
    }

    @Override // b.i.a.c.x2.h
    public void f(b.i.a.c.x2.j jVar) {
        this.j = jVar;
    }

    @Override // b.i.a.c.x2.h
    public void g(long j, long j2) {
        boolean z2 = this.a.d() == -9223372036854775807L;
        if (!z2) {
            long jC = this.a.c();
            z2 = (jC == -9223372036854775807L || jC == 0 || jC == j2) ? false : true;
        }
        if (z2) {
            this.a.e(j2);
        }
        z zVar = this.i;
        if (zVar != null) {
            zVar.e(j2);
        }
        for (int i = 0; i < this.f1243b.size(); i++) {
            b0$a b0_aValueAt = this.f1243b.valueAt(i);
            b0_aValueAt.f = false;
            b0_aValueAt.a.c();
        }
    }

    @Override // b.i.a.c.x2.h
    public void release() {
    }
}
