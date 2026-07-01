package b.i.a.c.x2.k0;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Arrays;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: TsExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public class h0$b implements c0 {
    public final b.i.a.c.f3.w a = new b.i.a.c.f3.w(new byte[5]);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<i0> f1255b = new SparseArray<>();
    public final SparseIntArray c = new SparseIntArray();
    public final int d;
    public final /* synthetic */ h0 e;

    public h0$b(h0 h0Var, int i) {
        this.e = h0Var;
        this.d = i;
    }

    @Override // b.i.a.c.x2.k0.c0
    public void a(b.i.a.c.f3.d0 d0Var, b.i.a.c.x2.j jVar, i0$d i0_d) {
    }

    /* JADX WARN: Code duplicated, block: B:47:0x012c  */
    /* JADX WARN: Code duplicated, block: B:51:0x0134  */
    /* JADX WARN: Code duplicated, block: B:56:0x0141  */
    @Override // b.i.a.c.x2.k0.c0
    public void b(b.i.a.c.f3.x xVar) {
        b.i.a.c.f3.d0 d0Var;
        b.i.a.c.f3.d0 d0Var2;
        int i;
        int i2;
        int i3;
        b.i.a.c.f3.d0 d0Var3;
        int i4;
        if (xVar.t() != 2) {
            return;
        }
        h0 h0Var = this.e;
        int i5 = h0Var.a;
        if (i5 == 1 || i5 == 2 || h0Var.m == 1) {
            d0Var = h0Var.c.get(0);
        } else {
            d0Var = new b.i.a.c.f3.d0(h0Var.c.get(0).c());
            this.e.c.add(d0Var);
        }
        if ((xVar.t() & 128) == 0) {
            return;
        }
        xVar.F(1);
        int iY = xVar.y();
        int i6 = 3;
        xVar.F(3);
        xVar.d(this.a, 2);
        this.a.m(3);
        int i7 = 13;
        this.e.f1253s = this.a.g(13);
        xVar.d(this.a, 2);
        int i8 = 4;
        this.a.m(4);
        int i9 = 12;
        xVar.F(this.a.g(12));
        h0 h0Var2 = this.e;
        int i10 = 21;
        if (h0Var2.a == 2 && h0Var2.q == null) {
            i0$b i0_b = new i0$b(21, null, null, b.i.a.c.f3.e0.f);
            h0 h0Var3 = this.e;
            h0Var3.q = h0Var3.f.a(21, i0_b);
            h0 h0Var4 = this.e;
            i0 i0Var = h0Var4.q;
            if (i0Var != null) {
                i0Var.a(d0Var, h0Var4.l, new i0$d(iY, 21, 8192));
            }
        }
        this.f1255b.clear();
        this.c.clear();
        int iA = xVar.a();
        while (iA > 0) {
            int i11 = 5;
            xVar.d(this.a, 5);
            int iG = this.a.g(8);
            this.a.m(i6);
            int iG2 = this.a.g(i7);
            this.a.m(i8);
            int iG3 = this.a.g(i9);
            int i12 = xVar.f984b;
            int i13 = iG3 + i12;
            int i14 = -1;
            String strTrim = null;
            ArrayList arrayList = null;
            while (xVar.f984b < i13) {
                int iT = xVar.t();
                int iT2 = xVar.f984b + xVar.t();
                if (iT2 > i13) {
                    break;
                }
                if (iT == i11) {
                    long jU = xVar.u();
                    if (jU == 1094921523) {
                        i14 = Opcodes.LOR;
                    } else if (jU == 1161904947) {
                        i14 = Opcodes.I2D;
                    } else if (jU == 1094921524) {
                        i14 = Opcodes.IRETURN;
                    } else if (jU == 1212503619) {
                        i14 = 36;
                    }
                    i3 = iY;
                    d0Var3 = d0Var;
                    i4 = iG2;
                } else {
                    if (iT == 106) {
                        i14 = Opcodes.LOR;
                    } else if (iT == 122) {
                        i14 = Opcodes.I2D;
                    } else if (iT == 127) {
                        if (xVar.t() == i10) {
                            i14 = Opcodes.IRETURN;
                        }
                    } else if (iT == 123) {
                        i14 = Opcodes.L2D;
                    } else if (iT == 10) {
                        strTrim = xVar.q(3).trim();
                        i3 = iY;
                        d0Var3 = d0Var;
                        i4 = iG2;
                    } else {
                        int i15 = 3;
                        if (iT == 89) {
                            ArrayList arrayList2 = new ArrayList();
                            while (xVar.f984b < iT2) {
                                String strTrim2 = xVar.q(i15).trim();
                                int iT3 = xVar.t();
                                byte[] bArr = new byte[4];
                                System.arraycopy(xVar.a, xVar.f984b, bArr, 0, 4);
                                xVar.f984b += 4;
                                arrayList2.add(new i0$a(strTrim2, iT3, bArr));
                                d0Var = d0Var;
                                iY = iY;
                                iG2 = iG2;
                                i15 = 3;
                            }
                            i3 = iY;
                            d0Var3 = d0Var;
                            i4 = iG2;
                            arrayList = arrayList2;
                            i14 = 89;
                        } else {
                            i3 = iY;
                            d0Var3 = d0Var;
                            i4 = iG2;
                            if (iT == 111) {
                                i14 = 257;
                            }
                        }
                    }
                    i3 = iY;
                    d0Var3 = d0Var;
                    i4 = iG2;
                }
                xVar.F(iT2 - xVar.f984b);
                d0Var = d0Var3;
                iY = i3;
                iG2 = i4;
                i11 = 5;
                i10 = 21;
            }
            int i16 = iY;
            b.i.a.c.f3.d0 d0Var4 = d0Var;
            int i17 = iG2;
            xVar.E(i13);
            i0$b i0_b2 = new i0$b(i14, strTrim, arrayList, Arrays.copyOfRange(xVar.a, i12, i13));
            if (iG == 6 || iG == 5) {
                iG = i14;
            }
            iA -= iG3 + 5;
            h0 h0Var5 = this.e;
            int i18 = h0Var5.a == 2 ? iG : i17;
            if (!h0Var5.h.get(i18)) {
                h0 h0Var6 = this.e;
                i0 i0VarA = (h0Var6.a == 2 && iG == 21) ? h0Var6.q : h0Var6.f.a(iG, i0_b2);
                if (this.e.a == 2) {
                    i2 = i17;
                    if (i2 < this.c.get(i18, 8192)) {
                    }
                } else {
                    i2 = i17;
                }
                this.c.put(i18, i2);
                this.f1255b.put(i18, i0VarA);
            }
            d0Var = d0Var4;
            iY = i16;
            i6 = 3;
            i8 = 4;
            i7 = 13;
            i9 = 12;
            i10 = 21;
        }
        int i19 = iY;
        b.i.a.c.f3.d0 d0Var5 = d0Var;
        int size = this.c.size();
        int i20 = 0;
        while (i20 < size) {
            int iKeyAt = this.c.keyAt(i20);
            int iValueAt = this.c.valueAt(i20);
            this.e.h.put(iKeyAt, true);
            this.e.i.put(iValueAt, true);
            i0 i0VarValueAt = this.f1255b.valueAt(i20);
            if (i0VarValueAt != null) {
                h0 h0Var7 = this.e;
                if (i0VarValueAt != h0Var7.q) {
                    b.i.a.c.x2.j jVar = h0Var7.l;
                    i = i19;
                    i0$d i0_d = new i0$d(i, iKeyAt, 8192);
                    d0Var2 = d0Var5;
                    i0VarValueAt.a(d0Var2, jVar, i0_d);
                } else {
                    d0Var2 = d0Var5;
                    i = i19;
                }
                this.e.g.put(iValueAt, i0VarValueAt);
            } else {
                d0Var2 = d0Var5;
                i = i19;
            }
            i20++;
            d0Var5 = d0Var2;
            i19 = i;
        }
        h0 h0Var8 = this.e;
        if (h0Var8.a == 2) {
            if (h0Var8.n) {
                return;
            }
            h0Var8.l.j();
            h0 h0Var9 = this.e;
            h0Var9.m = 0;
            h0Var9.n = true;
            return;
        }
        h0Var8.g.remove(this.d);
        h0 h0Var10 = this.e;
        int i21 = h0Var10.a == 1 ? 0 : h0Var10.m - 1;
        h0Var10.m = i21;
        if (i21 == 0) {
            h0Var10.l.j();
            this.e.n = true;
        }
    }
}
