package b.i.a.c.x2.k0;

import android.util.Pair;
import androidx.annotation.Nullable;
import b.i.a.c.j1;
import b.i.a.c.j1$b;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: H262Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p implements o {
    public static final double[] a = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1267b;
    public b.i.a.c.x2.w c;

    @Nullable
    public final j0 d;

    @Nullable
    public final b.i.a.c.f3.x e;

    @Nullable
    public final w f;
    public final boolean[] g = new boolean[4];
    public final p$a h = new p$a(128);
    public long i;
    public boolean j;
    public boolean k;
    public long l;
    public long m;
    public long n;
    public long o;
    public boolean p;
    public boolean q;

    public p(@Nullable j0 j0Var) {
        this.d = j0Var;
        if (j0Var != null) {
            this.f = new w(Opcodes.GETSTATIC, 128);
            this.e = new b.i.a.c.f3.x();
        } else {
            this.f = null;
            this.e = null;
        }
        this.m = -9223372036854775807L;
        this.o = -9223372036854775807L;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0080  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:38:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:48:0x010b  */
    /* JADX WARN: Code duplicated, block: B:49:0x011a  */
    /* JADX WARN: Code duplicated, block: B:51:0x0125  */
    /* JADX WARN: Code duplicated, block: B:53:0x0149  */
    /* JADX WARN: Code duplicated, block: B:83:0x01d5  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // b.i.a.c.x2.k0.o
    public void b(b.i.a.c.f3.x xVar) {
        int i;
        long j;
        int i2;
        boolean z2;
        p$a p_a;
        byte[] bArrCopyOf;
        int i3;
        int i4;
        int i5;
        float f;
        int i6;
        float f2;
        int i7;
        long j2;
        double[] dArr;
        double d;
        int i8;
        int i9;
        b.c.a.a0.d.H(this.c);
        int i10 = xVar.f984b;
        int i11 = xVar.c;
        byte[] bArr = xVar.a;
        this.i += (long) xVar.a();
        this.c.c(xVar, xVar.a());
        while (true) {
            int iB = b.i.a.c.f3.u.b(bArr, i10, i11, this.g);
            if (iB == i11) {
                break;
            }
            int i12 = iB + 3;
            int i13 = xVar.a[i12] & 255;
            int i14 = iB - i10;
            if (this.k) {
                i13 = i13;
                i12 = i12;
            } else {
                if (i14 > 0) {
                    this.h.a(bArr, i10, iB);
                }
                int i15 = i14 < 0 ? -i14 : 0;
                p$a p_a2 = this.h;
                if (p_a2.f1268b) {
                    int i16 = p_a2.c - i15;
                    p_a2.c = i16;
                    if (p_a2.d == 0 && i13 == 181) {
                        p_a2.d = i16;
                    } else {
                        p_a2.f1268b = false;
                        z2 = true;
                    }
                    if (z2) {
                        p_a = this.h;
                        String str = this.f1267b;
                        Objects.requireNonNull(str);
                        bArrCopyOf = Arrays.copyOf(p_a.e, p_a.c);
                        int i17 = bArrCopyOf[4] & 255;
                        int i18 = bArrCopyOf[5] & 255;
                        i3 = (i17 << 4) | (i18 >> 4);
                        i4 = ((i18 & 15) << 8) | (bArrCopyOf[6] & 255);
                        i5 = (bArrCopyOf[7] & 240) >> 4;
                        if (i5 != 2) {
                            f = i4 * 4;
                            i6 = i3 * 3;
                        } else if (i5 != 3) {
                            if (i5 != 4) {
                                f2 = 1.0f;
                            } else {
                                f = i4 * 121;
                                i6 = i3 * 100;
                            }
                            j1$b j1_b = new j1$b();
                            j1_b.a = str;
                            j1_b.k = "video/mpeg2";
                            j1_b.p = i3;
                            j1_b.q = i4;
                            j1_b.t = f2;
                            j1_b.m = Collections.singletonList(bArrCopyOf);
                            j1 j1VarA = j1_b.a();
                            i7 = (bArrCopyOf[7] & 15) - 1;
                            if (i7 >= 0) {
                                dArr = a;
                                if (i7 < dArr.length) {
                                    d = dArr[i7];
                                    int i19 = p_a.d + 9;
                                    i8 = (bArrCopyOf[i19] & 96) >> 5;
                                    i9 = bArrCopyOf[i19] & 31;
                                    if (i8 != i9) {
                                        d *= (((double) i8) + 1.0d) / ((double) (i9 + 1));
                                    }
                                    j2 = (long) (1000000.0d / d);
                                } else {
                                    i13 = i13;
                                    i12 = i12;
                                    j2 = 0;
                                }
                            } else {
                                i13 = i13;
                                i12 = i12;
                                j2 = 0;
                            }
                            Pair pairCreate = Pair.create(j1VarA, Long.valueOf(j2));
                            this.c.e((j1) pairCreate.first);
                            this.l = ((Long) pairCreate.second).longValue();
                            this.k = true;
                        } else {
                            f = i4 * 16;
                            i6 = i3 * 9;
                        }
                        f2 = f / i6;
                        j1$b j1_b2 = new j1$b();
                        j1_b2.a = str;
                        j1_b2.k = "video/mpeg2";
                        j1_b2.p = i3;
                        j1_b2.q = i4;
                        j1_b2.t = f2;
                        j1_b2.m = Collections.singletonList(bArrCopyOf);
                        j1 j1VarA2 = j1_b2.a();
                        i7 = (bArrCopyOf[7] & 15) - 1;
                        if (i7 >= 0) {
                            dArr = a;
                            if (i7 < dArr.length) {
                                d = dArr[i7];
                                int i110 = p_a.d + 9;
                                i8 = (bArrCopyOf[i110] & 96) >> 5;
                                i9 = bArrCopyOf[i110] & 31;
                                if (i8 != i9) {
                                    d *= (((double) i8) + 1.0d) / ((double) (i9 + 1));
                                }
                                j2 = (long) (1000000.0d / d);
                            } else {
                                i13 = i13;
                                i12 = i12;
                                j2 = 0;
                            }
                        } else {
                            i13 = i13;
                            i12 = i12;
                            j2 = 0;
                        }
                        Pair pairCreate2 = Pair.create(j1VarA2, Long.valueOf(j2));
                        this.c.e((j1) pairCreate2.first);
                        this.l = ((Long) pairCreate2.second).longValue();
                        this.k = true;
                    } else {
                        i13 = i13;
                        i12 = i12;
                    }
                } else if (i13 == 179) {
                    p_a2.f1268b = true;
                }
                byte[] bArr2 = p$a.a;
                p_a2.a(bArr2, 0, bArr2.length);
                z2 = false;
                if (z2) {
                    p_a = this.h;
                    String str2 = this.f1267b;
                    Objects.requireNonNull(str2);
                    bArrCopyOf = Arrays.copyOf(p_a.e, p_a.c);
                    int i111 = bArrCopyOf[4] & 255;
                    int i112 = bArrCopyOf[5] & 255;
                    i3 = (i111 << 4) | (i112 >> 4);
                    i4 = ((i112 & 15) << 8) | (bArrCopyOf[6] & 255);
                    i5 = (bArrCopyOf[7] & 240) >> 4;
                    if (i5 != 2) {
                        f = i4 * 4;
                        i6 = i3 * 3;
                    } else if (i5 != 3) {
                        if (i5 != 4) {
                            f2 = 1.0f;
                        } else {
                            f = i4 * 121;
                            i6 = i3 * 100;
                        }
                        j1$b j1_b3 = new j1$b();
                        j1_b3.a = str2;
                        j1_b3.k = "video/mpeg2";
                        j1_b3.p = i3;
                        j1_b3.q = i4;
                        j1_b3.t = f2;
                        j1_b3.m = Collections.singletonList(bArrCopyOf);
                        j1 j1VarA3 = j1_b3.a();
                        i7 = (bArrCopyOf[7] & 15) - 1;
                        if (i7 >= 0) {
                            dArr = a;
                            if (i7 < dArr.length) {
                                d = dArr[i7];
                                int i113 = p_a.d + 9;
                                i8 = (bArrCopyOf[i113] & 96) >> 5;
                                i9 = bArrCopyOf[i113] & 31;
                                if (i8 != i9) {
                                    d *= (((double) i8) + 1.0d) / ((double) (i9 + 1));
                                }
                                j2 = (long) (1000000.0d / d);
                            } else {
                                i13 = i13;
                                i12 = i12;
                                j2 = 0;
                            }
                        } else {
                            i13 = i13;
                            i12 = i12;
                            j2 = 0;
                        }
                        Pair pairCreate3 = Pair.create(j1VarA3, Long.valueOf(j2));
                        this.c.e((j1) pairCreate3.first);
                        this.l = ((Long) pairCreate3.second).longValue();
                        this.k = true;
                    } else {
                        f = i4 * 16;
                        i6 = i3 * 9;
                    }
                    f2 = f / i6;
                    j1$b j1_b4 = new j1$b();
                    j1_b4.a = str2;
                    j1_b4.k = "video/mpeg2";
                    j1_b4.p = i3;
                    j1_b4.q = i4;
                    j1_b4.t = f2;
                    j1_b4.m = Collections.singletonList(bArrCopyOf);
                    j1 j1VarA4 = j1_b4.a();
                    i7 = (bArrCopyOf[7] & 15) - 1;
                    if (i7 >= 0) {
                        dArr = a;
                        if (i7 < dArr.length) {
                            d = dArr[i7];
                            int i114 = p_a.d + 9;
                            i8 = (bArrCopyOf[i114] & 96) >> 5;
                            i9 = bArrCopyOf[i114] & 31;
                            if (i8 != i9) {
                                d *= (((double) i8) + 1.0d) / ((double) (i9 + 1));
                            }
                            j2 = (long) (1000000.0d / d);
                        } else {
                            i13 = i13;
                            i12 = i12;
                            j2 = 0;
                        }
                    } else {
                        i13 = i13;
                        i12 = i12;
                        j2 = 0;
                    }
                    Pair pairCreate4 = Pair.create(j1VarA4, Long.valueOf(j2));
                    this.c.e((j1) pairCreate4.first);
                    this.l = ((Long) pairCreate4.second).longValue();
                    this.k = true;
                } else {
                    i13 = i13;
                    i12 = i12;
                }
            }
            w wVar = this.f;
            if (wVar != null) {
                if (i14 > 0) {
                    wVar.a(bArr, i10, iB);
                    i2 = 0;
                } else {
                    i2 = -i14;
                }
                if (this.f.b(i2)) {
                    w wVar2 = this.f;
                    int iF = b.i.a.c.f3.u.f(wVar2.d, wVar2.e);
                    b.i.a.c.f3.x xVar2 = this.e;
                    int i20 = b.i.a.c.f3.e0.a;
                    xVar2.C(this.f.d, iF);
                    this.d.a(this.o, this.e);
                }
                i = i13;
                if (i == 178 && xVar.a[iB + 2] == 1) {
                    this.f.d(i);
                }
            } else {
                i = i13;
            }
            if (i == 0 || i == 179) {
                int i21 = i11 - iB;
                if (this.q && this.k) {
                    long j3 = this.o;
                    if (j3 != -9223372036854775807L) {
                        j = -9223372036854775807L;
                        this.c.d(j3, this.p ? 1 : 0, ((int) (this.i - this.n)) - i21, i21, null);
                    } else {
                        j = -9223372036854775807L;
                    }
                } else {
                    j = -9223372036854775807L;
                }
                if (!this.j || this.q) {
                    this.n = this.i - ((long) i21);
                    long j4 = this.m;
                    if (j4 == j) {
                        long j5 = this.o;
                        j4 = j5 != j ? j5 + this.l : j;
                    }
                    this.o = j4;
                    this.p = false;
                    this.m = j;
                    this.j = true;
                }
                this.q = i == 0;
            } else {
                if (i == 184) {
                    this.p = true;
                }
                i11 = i11;
                bArr = bArr;
            }
            i11 = i11;
            bArr = bArr;
            i10 = i12;
        }
        if (!this.k) {
            this.h.a(bArr, i10, i11);
        }
        w wVar3 = this.f;
        if (wVar3 != null) {
            wVar3.a(bArr, i10, i11);
        }
    }

    @Override // b.i.a.c.x2.k0.o
    public void c() {
        b.i.a.c.f3.u.a(this.g);
        p$a p_a = this.h;
        p_a.f1268b = false;
        p_a.c = 0;
        p_a.d = 0;
        w wVar = this.f;
        if (wVar != null) {
            wVar.c();
        }
        this.i = 0L;
        this.j = false;
        this.m = -9223372036854775807L;
        this.o = -9223372036854775807L;
    }

    @Override // b.i.a.c.x2.k0.o
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.o
    public void e(b.i.a.c.x2.j jVar, i0$d i0_d) {
        i0_d.a();
        this.f1267b = i0_d.b();
        this.c = jVar.p(i0_d.c(), 2);
        j0 j0Var = this.d;
        if (j0Var != null) {
            j0Var.b(jVar, i0_d);
        }
    }

    @Override // b.i.a.c.x2.k0.o
    public void f(long j, int i) {
        this.m = j;
    }
}
