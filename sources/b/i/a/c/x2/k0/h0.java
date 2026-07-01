package b.i.a.c.x2.k0;

import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import b.i.a.c.x2.t$b;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: TsExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h0 implements b.i.a.c.x2.h {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1252b;
    public final List<b.i.a.c.f3.d0> c;
    public final b.i.a.c.f3.x d;
    public final SparseIntArray e;
    public final i0$c f;
    public final SparseArray<i0> g;
    public final SparseBooleanArray h;
    public final SparseBooleanArray i;
    public final g0 j;
    public f0 k;
    public b.i.a.c.x2.j l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;

    @Nullable
    public i0 q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1253s;

    static {
        e eVar = e.a;
    }

    public h0(int i, int i2, int i3) {
        b.i.a.c.f3.d0 d0Var = new b.i.a.c.f3.d0(0L);
        l lVar = new l(i2);
        this.f = lVar;
        this.f1252b = i3;
        this.a = i;
        if (i == 1 || i == 2) {
            this.c = Collections.singletonList(d0Var);
        } else {
            ArrayList arrayList = new ArrayList();
            this.c = arrayList;
            arrayList.add(d0Var);
        }
        this.d = new b.i.a.c.f3.x(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.h = sparseBooleanArray;
        this.i = new SparseBooleanArray();
        SparseArray<i0> sparseArray = new SparseArray<>();
        this.g = sparseArray;
        this.e = new SparseIntArray();
        this.j = new g0(i3);
        this.l = b.i.a.c.x2.j.d;
        this.f1253s = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray<i0> sparseArrayB = lVar.b();
        int size = sparseArrayB.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.g.put(sparseArrayB.keyAt(i4), sparseArrayB.valueAt(i4));
        }
        this.g.put(0, new d0(new h0$a(this)));
        this.q = null;
    }

    @Override // b.i.a.c.x2.h
    public boolean b(b.i.a.c.x2.i iVar) throws IOException {
        boolean z2;
        byte[] bArr = this.d.a;
        iVar.o(bArr, 0, 940);
        for (int i = 0; i < 188; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    z2 = true;
                    break;
                }
                if (bArr[(i2 * Opcodes.NEWARRAY) + i] != 71) {
                    z2 = false;
                    break;
                }
                i2++;
            }
            if (z2) {
                iVar.l(i);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // b.i.a.c.x2.h
    public int e(b.i.a.c.x2.i iVar, b.i.a.c.x2.s sVar) throws IOException {
        ?? r0;
        ?? r1;
        boolean z2;
        int i;
        boolean z3;
        boolean z4;
        long jB = iVar.b();
        int i2 = 1;
        if (this.n) {
            long j = -9223372036854775807L;
            if ((jB == -1 || this.a == 2) ? false : true) {
                g0 g0Var = this.j;
                if (!g0Var.d) {
                    int i3 = this.f1253s;
                    if (i3 <= 0) {
                        g0Var.a(iVar);
                        return 0;
                    }
                    if (!g0Var.f) {
                        long jB2 = iVar.b();
                        int iMin = (int) Math.min(g0Var.a, jB2);
                        long j2 = jB2 - ((long) iMin);
                        if (iVar.getPosition() != j2) {
                            sVar.a = j2;
                        } else {
                            g0Var.c.A(iMin);
                            iVar.k();
                            iVar.o(g0Var.c.a, 0, iMin);
                            b.i.a.c.f3.x xVar = g0Var.c;
                            int i4 = xVar.f984b;
                            int i5 = xVar.c;
                            for (int i6 = i5 - 188; i6 >= i4; i6--) {
                                byte[] bArr = xVar.a;
                                int i7 = -4;
                                int i8 = 0;
                                while (true) {
                                    if (i7 > 4) {
                                        z4 = false;
                                        break;
                                    }
                                    int i9 = (i7 * Opcodes.NEWARRAY) + i6;
                                    if (i9 >= i4 && i9 < i5 && bArr[i9] == 71) {
                                        i8++;
                                        if (i8 == 5) {
                                            z4 = true;
                                            break;
                                        }
                                    } else {
                                        i8 = 0;
                                    }
                                    i7++;
                                }
                                if (z4) {
                                    long jK1 = b.c.a.a0.d.K1(xVar, i6, i3);
                                    if (jK1 != -9223372036854775807L) {
                                        j = jK1;
                                        break;
                                    }
                                }
                            }
                            g0Var.h = j;
                            g0Var.f = true;
                            i2 = 0;
                        }
                    } else {
                        if (g0Var.h == -9223372036854775807L) {
                            g0Var.a(iVar);
                            return 0;
                        }
                        if (g0Var.e) {
                            long j3 = g0Var.g;
                            if (j3 == -9223372036854775807L) {
                                g0Var.a(iVar);
                                return 0;
                            }
                            long jB3 = g0Var.f1250b.b(g0Var.h) - g0Var.f1250b.b(j3);
                            g0Var.i = jB3;
                            if (jB3 < 0) {
                                Log.w("TsDurationReader", b.d.b.a.a.i(65, "Invalid duration: ", jB3, ". Using TIME_UNSET instead."));
                                g0Var.i = -9223372036854775807L;
                            }
                            g0Var.a(iVar);
                            return 0;
                        }
                        int iMin2 = (int) Math.min(g0Var.a, iVar.b());
                        long j4 = 0;
                        if (iVar.getPosition() != j4) {
                            sVar.a = j4;
                        } else {
                            g0Var.c.A(iMin2);
                            iVar.k();
                            iVar.o(g0Var.c.a, 0, iMin2);
                            b.i.a.c.f3.x xVar2 = g0Var.c;
                            int i10 = xVar2.c;
                            for (int i11 = xVar2.f984b; i11 < i10; i11++) {
                                if (xVar2.a[i11] == 71) {
                                    long jK2 = b.c.a.a0.d.K1(xVar2, i11, i3);
                                    if (jK2 != -9223372036854775807L) {
                                        j = jK2;
                                        break;
                                    }
                                }
                            }
                            g0Var.g = j;
                            g0Var.e = true;
                            i2 = 0;
                        }
                    }
                    return i2;
                }
            }
            if (!this.o) {
                this.o = true;
                g0 g0Var2 = this.j;
                long j5 = g0Var2.i;
                if (j5 != -9223372036854775807L) {
                    f0 f0Var = new f0(g0Var2.f1250b, j5, jB, this.f1253s, this.f1252b);
                    this.k = f0Var;
                    this.l.a(f0Var.a);
                } else {
                    this.l.a(new t$b(j5, 0L));
                }
            }
            if (this.p) {
                z3 = false;
                this.p = false;
                g(0L, 0L);
                if (iVar.getPosition() != 0) {
                    sVar.a = 0L;
                    return 1;
                }
            } else {
                z3 = false;
            }
            r1 = 1;
            r1 = 1;
            f0 f0Var2 = this.k;
            r0 = z3;
            if (f0Var2 != null && f0Var2.b()) {
                r0 = z3;
                return this.k.a(iVar, sVar);
            }
        } else {
            r0 = 0;
            r1 = 1;
        }
        r0 = z3;
        b.i.a.c.f3.x xVar3 = this.d;
        byte[] bArr2 = xVar3.a;
        if (9400 - xVar3.f984b < 188) {
            int iA = xVar3.a();
            if (iA > 0) {
                System.arraycopy(bArr2, this.d.f984b, bArr2, r0, iA);
            }
            this.d.C(bArr2, iA);
        }
        while (true) {
            if (this.d.a() >= 188) {
                z2 = true;
                break;
            }
            int i12 = this.d.c;
            int i13 = iVar.read(bArr2, i12, 9400 - i12);
            if (i13 == -1) {
                z2 = false;
                break;
            }
            this.d.D(i12 + i13);
        }
        if (!z2) {
            return -1;
        }
        b.i.a.c.f3.x xVar4 = this.d;
        int i14 = xVar4.f984b;
        int i15 = xVar4.c;
        byte[] bArr3 = xVar4.a;
        int i16 = i14;
        while (i16 < i15 && bArr3[i16] != 71) {
            i16++;
        }
        this.d.E(i16);
        int i17 = i16 + Opcodes.NEWARRAY;
        if (i17 > i15) {
            int i18 = (i16 - i14) + this.r;
            this.r = i18;
            i = 2;
            if (this.a == 2 && i18 > 376) {
                throw ParserException.a("Cannot find sync byte. Most likely not a Transport Stream.", null);
            }
        } else {
            i = 2;
            this.r = r0;
        }
        b.i.a.c.f3.x xVar5 = this.d;
        int i19 = xVar5.c;
        if (i17 > i19) {
            return r0;
        }
        int iF = xVar5.f();
        if ((8388608 & iF) != 0) {
            this.d.E(i17);
            return r0;
        }
        int i20 = ((4194304 & iF) != 0 ? 1 : 0) | 0;
        int i21 = (2096896 & iF) >> 8;
        boolean z5 = (iF & 32) != 0;
        i0 i0Var = (iF & 16) != 0 ? this.g.get(i21) : null;
        if (i0Var == null) {
            this.d.E(i17);
            return r0;
        }
        if (this.a != i) {
            int i22 = iF & 15;
            int i23 = this.e.get(i21, i22 - 1);
            this.e.put(i21, i22);
            if (i23 == i22) {
                this.d.E(i17);
                return r0;
            }
            if (i22 != ((i23 + r1) & 15)) {
                i0Var.c();
            }
        }
        if (z5) {
            int iT = this.d.t();
            i20 |= (this.d.t() & 64) != 0 ? 2 : 0;
            this.d.F(iT - r1);
        }
        boolean z6 = this.n;
        if (this.a == i || z6 || !this.i.get(i21, r0)) {
            this.d.D(i17);
            i0Var.b(this.d, i20);
            this.d.D(i19);
        }
        if (this.a != i && !z6 && this.n && jB != -1) {
            this.p = r1;
        }
        this.d.E(i17);
        return r0;
    }

    @Override // b.i.a.c.x2.h
    public void f(b.i.a.c.x2.j jVar) {
        this.l = jVar;
    }

    @Override // b.i.a.c.x2.h
    public void g(long j, long j2) {
        f0 f0Var;
        b.c.a.a0.d.D(this.a != 2);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            b.i.a.c.f3.d0 d0Var = this.c.get(i);
            boolean z2 = d0Var.d() == -9223372036854775807L;
            if (!z2) {
                long jC = d0Var.c();
                z2 = (jC == -9223372036854775807L || jC == 0 || jC == j2) ? false : true;
            }
            if (z2) {
                d0Var.e(j2);
            }
        }
        if (j2 != 0 && (f0Var = this.k) != null) {
            f0Var.e(j2);
        }
        this.d.A(0);
        this.e.clear();
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            this.g.valueAt(i2).c();
        }
        this.r = 0;
    }

    @Override // b.i.a.c.x2.h
    public void release() {
    }
}
