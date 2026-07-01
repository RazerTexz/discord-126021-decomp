package b.i.a.c.x2.h0;

import android.util.Log;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.x;
import b.i.a.c.j1$b;
import b.i.a.c.t2.a0;
import b.i.a.c.t2.a0$a;
import b.i.a.c.x2.j;
import b.i.a.c.x2.p;
import b.i.a.c.x2.q;
import b.i.a.c.x2.s;
import b.i.a.c.x2.w;
import b.i.a.c.z2.k.b$a;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: Mp3Extractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements b.i.a.c.x2.h {
    public static final b$a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1205b;
    public final long c;
    public final x d;
    public final a0$a e;
    public final p f;
    public final q g;
    public final w h;
    public j i;
    public w j;
    public w k;
    public int l;

    @Nullable
    public Metadata m;
    public long n;
    public long o;
    public long p;
    public int q;
    public g r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1206s;
    public boolean t;
    public long u;

    static {
        a aVar = a.a;
        a = b.a;
    }

    public f() {
        this(0);
    }

    public static long d(@Nullable Metadata metadata) {
        if (metadata == null) {
            return -9223372036854775807L;
        }
        int length = metadata.j.length;
        for (int i = 0; i < length; i++) {
            Metadata$Entry metadata$Entry = metadata.j[i];
            if (metadata$Entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) metadata$Entry;
                if (textInformationFrame.j.equals("TLEN")) {
                    return e0.B(Long.parseLong(textInformationFrame.l));
                }
            }
        }
        return -9223372036854775807L;
    }

    public static boolean h(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    public final long a(long j) {
        return ((j * 1000000) / ((long) this.e.d)) + this.n;
    }

    @Override // b.i.a.c.x2.h
    public boolean b(b.i.a.c.x2.i iVar) throws IOException {
        return j(iVar, true);
    }

    public final g c(b.i.a.c.x2.i iVar, boolean z2) throws IOException {
        iVar.o(this.d.a, 0, 4);
        this.d.E(0);
        this.e.a(this.d.f());
        return new c(iVar.b(), iVar.getPosition(), this.e, z2);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0230  */
    /* JADX WARN: Code duplicated, block: B:103:0x023b  */
    /* JADX WARN: Code duplicated, block: B:10:0x001e  */
    /* JADX WARN: Code duplicated, block: B:110:0x0253  */
    /* JADX WARN: Code duplicated, block: B:112:0x0259  */
    /* JADX WARN: Code duplicated, block: B:116:0x027c A[LOOP:2: B:115:0x027a->B:116:0x027c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:118:0x029f A[LOOP:1: B:111:0x0257->B:118:0x029f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:119:0x02a4 A[EDGE_INSN: B:119:0x02a4->B:120:0x02a5 BREAK  A[LOOP:1: B:111:0x0257->B:118:0x029f]] */
    /* JADX WARN: Code duplicated, block: B:122:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:123:0x02af  */
    /* JADX WARN: Code duplicated, block: B:125:0x02b5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:126:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:128:0x02bd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:129:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:12:0x003b  */
    /* JADX WARN: Code duplicated, block: B:130:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:132:0x02dc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:133:0x02de  */
    /* JADX WARN: Code duplicated, block: B:134:0x02e0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:136:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:142:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:144:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:145:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:149:0x032f  */
    /* JADX WARN: Code duplicated, block: B:14:0x003f  */
    /* JADX WARN: Code duplicated, block: B:150:0x0331  */
    /* JADX WARN: Code duplicated, block: B:152:0x0343  */
    /* JADX WARN: Code duplicated, block: B:154:0x034d  */
    /* JADX WARN: Code duplicated, block: B:156:0x0357  */
    /* JADX WARN: Code duplicated, block: B:159:0x0360  */
    /* JADX WARN: Code duplicated, block: B:15:0x0042  */
    /* JADX WARN: Code duplicated, block: B:162:0x036b  */
    /* JADX WARN: Code duplicated, block: B:184:0x040a  */
    /* JADX WARN: Code duplicated, block: B:187:0x0418  */
    /* JADX WARN: Code duplicated, block: B:18:0x0047  */
    /* JADX WARN: Code duplicated, block: B:190:0x0420  */
    /* JADX WARN: Code duplicated, block: B:208:0x0261 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:209:0x02a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x0058  */
    /* JADX WARN: Code duplicated, block: B:25:0x0064  */
    /* JADX WARN: Code duplicated, block: B:27:0x006a  */
    /* JADX WARN: Code duplicated, block: B:29:0x0073  */
    /* JADX WARN: Code duplicated, block: B:30:0x0077  */
    /* JADX WARN: Code duplicated, block: B:69:0x0160  */
    /* JADX WARN: Code duplicated, block: B:71:0x0179  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016 A[PHI: r1
      0x0016: PHI (r1v3 b.i.a.c.x2.h0.f) = (r1v2 b.i.a.c.x2.h0.f), (r1v6 b.i.a.c.x2.h0.f), (r1v6 b.i.a.c.x2.h0.f) binds: [B:6:0x0014, B:185:0x0414, B:160:0x0367] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:87:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:89:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:91:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:94:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:96:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:98:0x0229 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:99:0x022b  */
    @Override // b.i.a.c.x2.h
    public int e(b.i.a.c.x2.i iVar, s sVar) throws IOException {
        f fVar;
        int i;
        b.i.a.c.x2.i iVar2;
        long position;
        long j;
        int iB;
        int i2;
        int iF;
        x xVar;
        a0$a a0_a;
        int i3;
        int iF2;
        int iF3;
        g gVarC;
        p pVar;
        boolean z2;
        int i4;
        p pVar2;
        int i5;
        int i6;
        int iW;
        i iVar3;
        Metadata metadata;
        long position2;
        e eVar;
        boolean z3;
        long jD;
        long jI;
        long jA;
        Metadata metadata2;
        int length;
        int i7;
        Metadata$Entry metadata$Entry;
        MlltFrame mlltFrame;
        int length2;
        long[] jArr;
        long[] jArr2;
        long j2;
        int i8;
        int iT;
        b.c.a.a0.d.H(this.j);
        int i9 = e0.a;
        if (this.l == 0) {
            try {
                j(iVar, false);
                if (this.r == null) {
                    xVar = new x(this.e.c);
                    iVar.o(xVar.a, 0, this.e.c);
                    a0_a = this.e;
                    i3 = 21;
                    if ((a0_a.a & 1) != 0) {
                        if (a0_a.e != 1) {
                            i3 = 36;
                        }
                    } else if (a0_a.e == 1) {
                        i3 = 13;
                    }
                    if (xVar.c >= i3 + 4) {
                        xVar.E(i3);
                        iF2 = xVar.f();
                        if (iF2 != 1483304551 && iF2 != 1231971951) {
                            if (xVar.c >= 40) {
                                xVar.E(36);
                                if (xVar.f() == 1447187017) {
                                    iF2 = 1447187017;
                                } else {
                                    iF2 = 0;
                                }
                            } else {
                                iF2 = 0;
                            }
                        }
                    } else if (xVar.c >= 40) {
                        xVar.E(36);
                        if (xVar.f() == 1447187017) {
                            iF2 = 1447187017;
                        } else {
                            iF2 = 0;
                        }
                    } else {
                        iF2 = 0;
                    }
                    String str = ", ";
                    if (iF2 != 1483304551 || iF2 == 1231971951) {
                        fVar = this;
                        long jB = iVar.b();
                        long position3 = iVar.getPosition();
                        a0$a a0_a2 = fVar.e;
                        int i10 = a0_a2.g;
                        int i11 = a0_a2.d;
                        iF3 = xVar.f();
                        if ((iF3 & 1) == 1 || (iW = xVar.w()) == 0) {
                            gVarC = null;
                        } else {
                            long jF = e0.F(iW, ((long) i10) * 1000000, i11);
                            if ((iF3 & 6) != 6) {
                                iVar3 = new i(position3, a0_a2.c, jF, -1L, null);
                            } else {
                                long jU = xVar.u();
                                long[] jArr3 = new long[100];
                                for (int i12 = 0; i12 < 100; i12++) {
                                    jArr3[i12] = xVar.t();
                                }
                                if (jB != -1) {
                                    long j3 = position3 + jU;
                                    if (jB != j3) {
                                        StringBuilder sbR = b.d.b.a.a.R(67, "XING data size mismatch: ", jB, ", ");
                                        sbR.append(j3);
                                        Log.w("XingSeeker", sbR.toString());
                                    }
                                }
                                iVar3 = new i(position3, a0_a2.c, jF, jU, jArr3);
                            }
                            gVarC = iVar3;
                        }
                        if (gVarC != null) {
                            pVar = fVar.f;
                            if (pVar.f1294b != -1 || pVar.c == -1) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            if (z2) {
                                iVar2 = iVar;
                            } else {
                                iVar.k();
                                iVar2 = iVar;
                                iVar2.g(i4 + Opcodes.F2D);
                                iVar2.o(fVar.d.a, 0, 3);
                                fVar.d.E(0);
                                pVar2 = fVar.f;
                                int iV = fVar.d.v();
                                Objects.requireNonNull(pVar2);
                                i5 = iV >> 12;
                                i6 = iV & 4095;
                                if (i5 <= 0 || i6 > 0) {
                                    i4 = i3;
                                    pVar2.f1294b = i5;
                                    pVar2.c = i6;
                                }
                            }
                        } else {
                            iVar2 = iVar;
                        }
                        iVar2.l(fVar.e.c);
                        if (gVarC != null && !gVarC.c() && iF2 == 1231971951) {
                            gVarC = fVar.c(iVar2, false);
                        }
                    } else if (iF2 == 1447187017) {
                        long jB2 = iVar.b();
                        long position4 = iVar.getPosition();
                        a0$a a0_a3 = this.e;
                        xVar.F(10);
                        int iF4 = xVar.f();
                        if (iF4 <= 0) {
                            gVarC = null;
                            break;
                        }
                        int i13 = a0_a3.d;
                        long jF2 = e0.F(iF4, ((long) (i13 >= 32000 ? 1152 : 576)) * 1000000, i13);
                        int iY = xVar.y();
                        int iY2 = xVar.y();
                        int iY3 = xVar.y();
                        xVar.F(2);
                        long j4 = ((long) a0_a3.c) + position4;
                        long[] jArr4 = new long[iY];
                        long[] jArr5 = new long[iY];
                        int i14 = 0;
                        long j5 = position4;
                        while (true) {
                            if (i14 >= iY) {
                                String str2 = str;
                                long j6 = jB2;
                                if (j6 != -1 && j6 != j5) {
                                    StringBuilder sbR2 = b.d.b.a.a.R(67, "VBRI data size mismatch: ", j6, str2);
                                    sbR2.append(j5);
                                    Log.w("VbriSeeker", sbR2.toString());
                                }
                                gVarC = new h(jArr4, jArr5, jF2, j5);
                                break;
                            }
                            String str3 = str;
                            long j7 = jB2;
                            jArr4[i14] = (((long) i14) * jF2) / ((long) iY);
                            jArr5[i14] = Math.max(j5, j4);
                            if (iY3 == 1) {
                                iT = xVar.t();
                            } else if (iY3 == 2) {
                                iT = xVar.y();
                            } else if (iY3 == 3) {
                                iT = xVar.v();
                            } else {
                                if (iY3 != 4) {
                                    gVarC = null;
                                    break;
                                }
                                iT = xVar.w();
                            }
                            j5 += (long) (iT * iY2);
                            i14++;
                            str = str3;
                            jB2 = j7;
                        }
                        fVar = this;
                        iVar.l(fVar.e.c);
                        iVar2 = iVar;
                    } else {
                        fVar = this;
                        iVar.k();
                        iVar2 = iVar;
                        gVarC = null;
                    }
                    metadata = fVar.m;
                    position2 = iVar.getPosition();
                    if (metadata != null) {
                        eVar = null;
                        break;
                    }
                    length = metadata.j.length;
                    i7 = 0;
                    while (true) {
                        if (i7 < length) {
                            eVar = null;
                            break;
                        }
                        metadata$Entry = metadata.j[i7];
                        if (metadata$Entry instanceof MlltFrame) {
                            mlltFrame = (MlltFrame) metadata$Entry;
                            long jD2 = d(metadata);
                            length2 = mlltFrame.n.length;
                            int i15 = length2 + 1;
                            jArr = new long[i15];
                            jArr2 = new long[i15];
                            jArr[0] = position2;
                            jArr2[0] = 0;
                            j2 = 0;
                            for (i8 = 1; i8 <= length2; i8++) {
                                int i16 = i8 - 1;
                                position2 += (long) (mlltFrame.l + mlltFrame.n[i16]);
                                j2 += (long) (mlltFrame.m + mlltFrame.o[i16]);
                                jArr[i8] = position2;
                                jArr2[i8] = j2;
                            }
                            eVar = new e(jArr, jArr2, jD2);
                            break;
                        }
                        i7++;
                    }
                    if (fVar.f1206s) {
                        gVarC = new g$a();
                    } else {
                        if ((fVar.f1205b & 4) != 0) {
                            if (eVar != null) {
                                jD = eVar.c;
                            } else {
                                if (gVarC != null) {
                                    jI = gVarC.i();
                                    jA = gVarC.a();
                                } else {
                                    jD = d(fVar.m);
                                }
                                gVarC = new d(jI, iVar.getPosition(), jA);
                            }
                            jI = jD;
                            jA = -1;
                            gVarC = new d(jI, iVar.getPosition(), jA);
                        } else if (eVar != null) {
                            gVarC = eVar;
                        } else if (gVarC == null) {
                            gVarC = null;
                        }
                        if (gVarC != null || (!gVarC.c() && (fVar.f1205b & 1) != 0)) {
                            if ((fVar.f1205b & 2) != 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            gVarC = fVar.c(iVar2, z3);
                        }
                    }
                    fVar.r = gVarC;
                    fVar.i.a(gVarC);
                    w wVar = fVar.k;
                    j1$b j1_b = new j1$b();
                    a0$a a0_a4 = fVar.e;
                    j1_b.k = a0_a4.f1116b;
                    j1_b.l = 4096;
                    j1_b.f1023x = a0_a4.e;
                    j1_b.f1024y = a0_a4.d;
                    p pVar3 = fVar.f;
                    j1_b.A = pVar3.f1294b;
                    j1_b.B = pVar3.c;
                    if ((fVar.f1205b & 8) != 0) {
                        metadata2 = null;
                    } else {
                        metadata2 = fVar.m;
                    }
                    j1_b.i = metadata2;
                    wVar.e(j1_b.a());
                    fVar.p = iVar.getPosition();
                } else {
                    iVar2 = iVar;
                    fVar = this;
                    if (fVar.p != 0) {
                        position = iVar.getPosition();
                        j = fVar.p;
                        if (position < j) {
                            iVar2.l((int) (j - position));
                        }
                    }
                }
                if (fVar.q == 0) {
                    iVar.k();
                    if (i(iVar)) {
                        i = -1;
                    } else {
                        fVar.d.E(0);
                        iF = fVar.d.f();
                        if (h(iF, fVar.l) || a0.a(iF) == -1) {
                            iVar2.l(1);
                            fVar.l = 0;
                        } else {
                            fVar.e.a(iF);
                            if (fVar.n == -9223372036854775807L) {
                                fVar.n = fVar.r.d(iVar.getPosition());
                                if (fVar.c != -9223372036854775807L) {
                                    fVar.n = (fVar.c - fVar.r.d(0L)) + fVar.n;
                                }
                            }
                            a0$a a0_a5 = fVar.e;
                            fVar.q = a0_a5.c;
                            g gVar = fVar.r;
                            if (gVar instanceof d) {
                                d dVar = (d) gVar;
                                long jA2 = fVar.a(fVar.o + ((long) a0_a5.g));
                                long position5 = iVar.getPosition() + ((long) fVar.e.c);
                                if (!dVar.b(jA2)) {
                                    dVar.f1203b.a(jA2);
                                    dVar.c.a(position5);
                                }
                                if (fVar.t && dVar.b(fVar.u)) {
                                    fVar.t = false;
                                    fVar.k = fVar.j;
                                }
                            }
                            iB = fVar.k.b(iVar2, fVar.q, true);
                            if (iB == -1) {
                                i = -1;
                            } else {
                                i2 = fVar.q - iB;
                                fVar.q = i2;
                                if (i2 <= 0) {
                                    fVar.k.d(fVar.a(fVar.o), 1, fVar.e.c, 0, null);
                                    fVar.o += (long) fVar.e.g;
                                    fVar.q = 0;
                                }
                            }
                        }
                        i = 0;
                    }
                } else {
                    iB = fVar.k.b(iVar2, fVar.q, true);
                    if (iB == -1) {
                        i = -1;
                    } else {
                        i2 = fVar.q - iB;
                        fVar.q = i2;
                        if (i2 <= 0) {
                            fVar.k.d(fVar.a(fVar.o), 1, fVar.e.c, 0, null);
                            fVar.o += (long) fVar.e.g;
                            fVar.q = 0;
                        }
                        i = 0;
                    }
                }
            } catch (EOFException unused) {
                fVar = this;
            }
        } else {
            if (this.r == null) {
                xVar = new x(this.e.c);
                iVar.o(xVar.a, 0, this.e.c);
                a0_a = this.e;
                i3 = 21;
                if ((a0_a.a & 1) != 0) {
                    if (a0_a.e != 1) {
                        i3 = 36;
                    }
                } else if (a0_a.e == 1) {
                    i3 = 13;
                }
                if (xVar.c >= i3 + 4) {
                    xVar.E(i3);
                    iF2 = xVar.f();
                    if (iF2 != 1483304551) {
                        if (xVar.c >= 40) {
                            xVar.E(36);
                            if (xVar.f() == 1447187017) {
                                iF2 = 1447187017;
                            } else {
                                iF2 = 0;
                            }
                        } else {
                            iF2 = 0;
                        }
                    }
                } else if (xVar.c >= 40) {
                    xVar.E(36);
                    if (xVar.f() == 1447187017) {
                        iF2 = 1447187017;
                    } else {
                        iF2 = 0;
                    }
                } else {
                    iF2 = 0;
                }
                String str4 = ", ";
                if (iF2 != 1483304551) {
                    fVar = this;
                    long jB3 = iVar.b();
                    long position6 = iVar.getPosition();
                    a0$a a0_a6 = fVar.e;
                    int i17 = a0_a6.g;
                    int i18 = a0_a6.d;
                    iF3 = xVar.f();
                    if ((iF3 & 1) == 1) {
                        gVarC = null;
                    } else {
                        gVarC = null;
                    }
                    if (gVarC != null) {
                        pVar = fVar.f;
                        if (pVar.f1294b != -1) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            iVar.k();
                            iVar2 = iVar;
                            iVar2.g(i4 + Opcodes.F2D);
                            iVar2.o(fVar.d.a, 0, 3);
                            fVar.d.E(0);
                            pVar2 = fVar.f;
                            int iV2 = fVar.d.v();
                            Objects.requireNonNull(pVar2);
                            i5 = iV2 >> 12;
                            i6 = iV2 & 4095;
                            if (i5 <= 0) {
                                i4 = i3;
                                pVar2.f1294b = i5;
                                pVar2.c = i6;
                            } else {
                                i4 = i3;
                                pVar2.f1294b = i5;
                                pVar2.c = i6;
                            }
                        } else {
                            iVar2 = iVar;
                        }
                    } else {
                        iVar2 = iVar;
                    }
                    iVar2.l(fVar.e.c);
                    if (gVarC != null) {
                        gVarC = fVar.c(iVar2, false);
                    }
                } else {
                    fVar = this;
                    long jB4 = iVar.b();
                    long position7 = iVar.getPosition();
                    a0$a a0_a7 = fVar.e;
                    int i19 = a0_a7.g;
                    int i110 = a0_a7.d;
                    iF3 = xVar.f();
                    if ((iF3 & 1) == 1) {
                        gVarC = null;
                    } else {
                        gVarC = null;
                    }
                    if (gVarC != null) {
                        pVar = fVar.f;
                        if (pVar.f1294b != -1) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            iVar.k();
                            iVar2 = iVar;
                            iVar2.g(i4 + Opcodes.F2D);
                            iVar2.o(fVar.d.a, 0, 3);
                            fVar.d.E(0);
                            pVar2 = fVar.f;
                            int iV3 = fVar.d.v();
                            Objects.requireNonNull(pVar2);
                            i5 = iV3 >> 12;
                            i6 = iV3 & 4095;
                            if (i5 <= 0) {
                                i4 = i3;
                                pVar2.f1294b = i5;
                                pVar2.c = i6;
                            } else {
                                i4 = i3;
                                pVar2.f1294b = i5;
                                pVar2.c = i6;
                            }
                        } else {
                            iVar2 = iVar;
                        }
                    } else {
                        iVar2 = iVar;
                    }
                    iVar2.l(fVar.e.c);
                    if (gVarC != null) {
                        gVarC = fVar.c(iVar2, false);
                    }
                }
                metadata = fVar.m;
                position2 = iVar.getPosition();
                if (metadata != null) {
                    eVar = null;
                    break;
                }
                length = metadata.j.length;
                i7 = 0;
                while (true) {
                    if (i7 < length) {
                        eVar = null;
                        break;
                    }
                    metadata$Entry = metadata.j[i7];
                    if (metadata$Entry instanceof MlltFrame) {
                        mlltFrame = (MlltFrame) metadata$Entry;
                        long jD3 = d(metadata);
                        length2 = mlltFrame.n.length;
                        int i111 = length2 + 1;
                        jArr = new long[i111];
                        jArr2 = new long[i111];
                        jArr[0] = position2;
                        jArr2[0] = 0;
                        j2 = 0;
                        while (i8 <= length2) {
                            int i112 = i8 - 1;
                            position2 += (long) (mlltFrame.l + mlltFrame.n[i112]);
                            j2 += (long) (mlltFrame.m + mlltFrame.o[i112]);
                            jArr[i8] = position2;
                            jArr2[i8] = j2;
                        }
                        eVar = new e(jArr, jArr2, jD3);
                        break;
                    }
                    i7++;
                }
                if (fVar.f1206s) {
                    gVarC = new g$a();
                } else {
                    if ((fVar.f1205b & 4) != 0) {
                        if (eVar != null) {
                            jD = eVar.c;
                        } else {
                            if (gVarC != null) {
                                jI = gVarC.i();
                                jA = gVarC.a();
                            } else {
                                jD = d(fVar.m);
                            }
                            gVarC = new d(jI, iVar.getPosition(), jA);
                        }
                        jI = jD;
                        jA = -1;
                        gVarC = new d(jI, iVar.getPosition(), jA);
                    } else if (eVar != null) {
                        gVarC = eVar;
                    } else if (gVarC == null) {
                        gVarC = null;
                    }
                    if (gVarC != null) {
                        if ((fVar.f1205b & 2) != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        gVarC = fVar.c(iVar2, z3);
                    } else {
                        if ((fVar.f1205b & 2) != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        gVarC = fVar.c(iVar2, z3);
                    }
                }
                fVar.r = gVarC;
                fVar.i.a(gVarC);
                w wVar2 = fVar.k;
                j1$b j1_b2 = new j1$b();
                a0$a a0_a8 = fVar.e;
                j1_b2.k = a0_a8.f1116b;
                j1_b2.l = 4096;
                j1_b2.f1023x = a0_a8.e;
                j1_b2.f1024y = a0_a8.d;
                p pVar4 = fVar.f;
                j1_b2.A = pVar4.f1294b;
                j1_b2.B = pVar4.c;
                if ((fVar.f1205b & 8) != 0) {
                    metadata2 = null;
                } else {
                    metadata2 = fVar.m;
                }
                j1_b2.i = metadata2;
                wVar2.e(j1_b2.a());
                fVar.p = iVar.getPosition();
            } else {
                iVar2 = iVar;
                fVar = this;
                if (fVar.p != 0) {
                    position = iVar.getPosition();
                    j = fVar.p;
                    if (position < j) {
                        iVar2.l((int) (j - position));
                    }
                }
            }
            if (fVar.q == 0) {
                iVar.k();
                if (i(iVar)) {
                    i = -1;
                } else {
                    fVar.d.E(0);
                    iF = fVar.d.f();
                    if (h(iF, fVar.l)) {
                    }
                    iVar2.l(1);
                    fVar.l = 0;
                    i = 0;
                }
            } else {
                iB = fVar.k.b(iVar2, fVar.q, true);
                if (iB == -1) {
                    i = -1;
                } else {
                    i2 = fVar.q - iB;
                    fVar.q = i2;
                    if (i2 <= 0) {
                        fVar.k.d(fVar.a(fVar.o), 1, fVar.e.c, 0, null);
                        fVar.o += (long) fVar.e.g;
                        fVar.q = 0;
                    }
                    i = 0;
                }
            }
        }
        if (i == -1 && (fVar.r instanceof d)) {
            long jA3 = fVar.a(fVar.o);
            if (fVar.r.i() != jA3) {
                g gVar2 = fVar.r;
                ((d) gVar2).d = jA3;
                fVar.i.a(gVar2);
            }
        }
        return i;
    }

    @Override // b.i.a.c.x2.h
    public void f(j jVar) {
        this.i = jVar;
        w wVarP = jVar.p(0, 1);
        this.j = wVarP;
        this.k = wVarP;
        this.i.j();
    }

    @Override // b.i.a.c.x2.h
    public void g(long j, long j2) {
        this.l = 0;
        this.n = -9223372036854775807L;
        this.o = 0L;
        this.q = 0;
        this.u = j2;
        g gVar = this.r;
        if (!(gVar instanceof d) || ((d) gVar).b(j2)) {
            return;
        }
        this.t = true;
        this.k = this.h;
    }

    public final boolean i(b.i.a.c.x2.i iVar) throws IOException {
        g gVar = this.r;
        if (gVar != null) {
            long jA = gVar.a();
            if (jA != -1 && iVar.f() > jA - 4) {
                return true;
            }
        }
        try {
            return !iVar.e(this.d.a, 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    public final boolean j(b.i.a.c.x2.i iVar, boolean z2) throws IOException {
        int i;
        int iF;
        int iA;
        int i2 = z2 ? 32768 : 131072;
        iVar.k();
        if (iVar.getPosition() == 0) {
            Metadata metadataA = this.g.a(iVar, (this.f1205b & 8) == 0 ? null : a);
            this.m = metadataA;
            if (metadataA != null) {
                this.f.b(metadataA);
            }
            iF = (int) iVar.f();
            if (!z2) {
                iVar.l(iF);
            }
            i = 0;
        } else {
            i = 0;
            iF = 0;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i(iVar)) {
                if (i3 > 0) {
                    break;
                }
                throw new EOFException();
            }
            this.d.E(0);
            int iF2 = this.d.f();
            if ((i == 0 || h(iF2, i)) && (iA = a0.a(iF2)) != -1) {
                i3++;
                if (i3 != 1) {
                    if (i3 == 4) {
                        break;
                    }
                } else {
                    this.e.a(iF2);
                    i = iF2;
                }
                iVar.g(iA - 4);
            } else {
                int i5 = i4 + 1;
                if (i4 == i2) {
                    if (z2) {
                        return false;
                    }
                    throw ParserException.a("Searched too many bytes.", null);
                }
                if (z2) {
                    iVar.k();
                    iVar.g(iF + i5);
                } else {
                    iVar.l(1);
                }
                i4 = i5;
                i = 0;
                i3 = 0;
            }
        }
        if (z2) {
            iVar.l(iF + i4);
        } else {
            iVar.k();
        }
        this.l = i;
        return true;
    }

    @Override // b.i.a.c.x2.h
    public void release() {
    }

    public f(int i) {
        this.f1205b = (i & 2) != 0 ? i | 1 : i;
        this.c = -9223372036854775807L;
        this.d = new x(10);
        this.e = new a0$a();
        this.f = new p();
        this.n = -9223372036854775807L;
        this.g = new q();
        b.i.a.c.x2.g gVar = new b.i.a.c.x2.g();
        this.h = gVar;
        this.k = gVar;
    }
}
