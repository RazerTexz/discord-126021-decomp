package b.i.a.c.x2.k0;

import android.util.Log;
import androidx.annotation.Nullable;
import b.i.a.c.j1$b;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: H263Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q implements o {
    public static final float[] a = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final j0 f1269b;
    public q$b g;
    public long h;
    public String i;
    public b.i.a.c.x2.w j;
    public boolean k;
    public final boolean[] d = new boolean[4];
    public final q$a e = new q$a(128);
    public long l = -9223372036854775807L;

    @Nullable
    public final w f = new w(Opcodes.GETSTATIC, 128);

    @Nullable
    public final b.i.a.c.f3.x c = new b.i.a.c.f3.x();

    public q(@Nullable j0 j0Var) {
        this.f1269b = j0Var;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:57:0x0112  */
    /* JADX WARN: Code duplicated, block: B:59:0x011e  */
    /* JADX WARN: Code duplicated, block: B:60:0x0124  */
    /* JADX WARN: Code duplicated, block: B:61:0x012b  */
    /* JADX WARN: Code duplicated, block: B:63:0x0132  */
    /* JADX WARN: Code duplicated, block: B:64:0x0135  */
    /* JADX WARN: Code duplicated, block: B:68:0x0140  */
    /* JADX WARN: Code duplicated, block: B:70:0x014e  */
    /* JADX WARN: Code duplicated, block: B:73:0x017b  */
    /* JADX WARN: Code duplicated, block: B:76:0x0192 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x0194  */
    /* JADX WARN: Code duplicated, block: B:78:0x019a  */
    /* JADX WARN: Code duplicated, block: B:80:0x019f A[LOOP:1: B:79:0x019d->B:80:0x019f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:83:0x01df  */
    /* JADX WARN: Code duplicated, block: B:97:0x022d  */
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
        int i2;
        boolean z2;
        b.i.a.c.f3.w wVar;
        int iG;
        float[] fArr;
        float f;
        int iG2;
        int i3;
        int i4;
        int iG3;
        int iG4;
        b.c.a.a0.d.H(this.g);
        b.c.a.a0.d.H(this.j);
        int i5 = xVar.f984b;
        int i6 = xVar.c;
        byte[] bArr = xVar.a;
        this.h += (long) xVar.a();
        this.j.c(xVar, xVar.a());
        while (true) {
            int iB = b.i.a.c.f3.u.b(bArr, i5, i6, this.d);
            if (iB == i6) {
                if (!this.k) {
                    this.e.a(bArr, i5, i6);
                }
                this.g.a(bArr, i5, i6);
                w wVar2 = this.f;
                if (wVar2 != null) {
                    wVar2.a(bArr, i5, i6);
                    return;
                }
                return;
            }
            int i7 = iB + 3;
            int i8 = xVar.a[i7] & 255;
            int i9 = iB - i5;
            if (this.k) {
                i = i6;
            } else {
                if (i9 > 0) {
                    this.e.a(bArr, i5, iB);
                }
                int i10 = i9 < 0 ? -i9 : 0;
                q$a q_a = this.e;
                int i11 = q_a.c;
                if (i11 != 0) {
                    if (i11 != 1) {
                        if (i11 != 2) {
                            if (i11 != 3) {
                                if (i11 != 4) {
                                    throw new IllegalStateException();
                                }
                                if (i8 == 179 || i8 == 181) {
                                    q_a.d -= i10;
                                    q_a.f1270b = false;
                                    z2 = true;
                                }
                                if (z2) {
                                    b.i.a.c.x2.w wVar3 = this.j;
                                    q$a q_a2 = this.e;
                                    int i12 = q_a2.e;
                                    String str = this.i;
                                    Objects.requireNonNull(str);
                                    byte[] bArrCopyOf = Arrays.copyOf(q_a2.f, q_a2.d);
                                    wVar = new b.i.a.c.f3.w(bArrCopyOf);
                                    wVar.n(i12);
                                    wVar.n(4);
                                    wVar.l();
                                    wVar.m(8);
                                    if (wVar.f()) {
                                        wVar.m(4);
                                        wVar.m(3);
                                    }
                                    iG = wVar.g(4);
                                    if (iG == 15) {
                                        iG3 = wVar.g(8);
                                        iG4 = wVar.g(8);
                                        if (iG4 == 0) {
                                            Log.w("H263Reader", "Invalid aspect ratio");
                                            i = i6;
                                            f = 1.0f;
                                        } else {
                                            f = iG3 / iG4;
                                            i = i6;
                                        }
                                    } else {
                                        fArr = a;
                                        i = i6;
                                        if (iG < fArr.length) {
                                            f = fArr[iG];
                                        } else {
                                            Log.w("H263Reader", "Invalid aspect ratio");
                                            f = 1.0f;
                                        }
                                    }
                                    if (wVar.f()) {
                                        wVar.m(2);
                                        wVar.m(1);
                                        if (wVar.f()) {
                                            wVar.m(15);
                                            wVar.l();
                                            wVar.m(15);
                                            wVar.l();
                                            wVar.m(15);
                                            wVar.l();
                                            wVar.m(3);
                                            wVar.m(11);
                                            wVar.l();
                                            wVar.m(15);
                                            wVar.l();
                                        }
                                    }
                                    if (wVar.g(2) != 0) {
                                        Log.w("H263Reader", "Unhandled video object layer shape");
                                    }
                                    wVar.l();
                                    iG2 = wVar.g(16);
                                    wVar.l();
                                    if (wVar.f()) {
                                        if (iG2 == 0) {
                                            Log.w("H263Reader", "Invalid vop_increment_time_resolution");
                                        } else {
                                            i4 = 0;
                                            for (i3 = iG2 - 1; i3 > 0; i3 >>= 1) {
                                                i4++;
                                            }
                                            wVar.m(i4);
                                        }
                                    }
                                    wVar.l();
                                    int iG5 = wVar.g(13);
                                    wVar.l();
                                    int iG6 = wVar.g(13);
                                    wVar.l();
                                    wVar.l();
                                    j1$b j1_b = new j1$b();
                                    j1_b.a = str;
                                    j1_b.k = "video/mp4v-es";
                                    j1_b.p = iG5;
                                    j1_b.q = iG6;
                                    j1_b.t = f;
                                    j1_b.m = Collections.singletonList(bArrCopyOf);
                                    wVar3.e(j1_b.a());
                                    this.k = true;
                                } else {
                                    i = i6;
                                }
                            } else if ((i8 & 240) != 32) {
                                Log.w("H263Reader", "Unexpected start code value");
                                q_a.b();
                            } else {
                                q_a.e = q_a.d;
                                q_a.c = 4;
                            }
                        } else if (i8 > 31) {
                            Log.w("H263Reader", "Unexpected start code value");
                            q_a.b();
                        } else {
                            q_a.c = 3;
                        }
                    } else if (i8 != 181) {
                        Log.w("H263Reader", "Unexpected start code value");
                        q_a.b();
                    } else {
                        q_a.c = 2;
                    }
                } else if (i8 == 176) {
                    q_a.c = 1;
                    q_a.f1270b = true;
                }
                byte[] bArr2 = q$a.a;
                q_a.a(bArr2, 0, bArr2.length);
                z2 = false;
                if (z2) {
                    b.i.a.c.x2.w wVar4 = this.j;
                    q$a q_a3 = this.e;
                    int i13 = q_a3.e;
                    String str2 = this.i;
                    Objects.requireNonNull(str2);
                    byte[] bArrCopyOf2 = Arrays.copyOf(q_a3.f, q_a3.d);
                    wVar = new b.i.a.c.f3.w(bArrCopyOf2);
                    wVar.n(i13);
                    wVar.n(4);
                    wVar.l();
                    wVar.m(8);
                    if (wVar.f()) {
                        wVar.m(4);
                        wVar.m(3);
                    }
                    iG = wVar.g(4);
                    if (iG == 15) {
                        iG3 = wVar.g(8);
                        iG4 = wVar.g(8);
                        if (iG4 == 0) {
                            Log.w("H263Reader", "Invalid aspect ratio");
                            i = i6;
                            f = 1.0f;
                        } else {
                            f = iG3 / iG4;
                            i = i6;
                        }
                    } else {
                        fArr = a;
                        i = i6;
                        if (iG < fArr.length) {
                            f = fArr[iG];
                        } else {
                            Log.w("H263Reader", "Invalid aspect ratio");
                            f = 1.0f;
                        }
                    }
                    if (wVar.f()) {
                        wVar.m(2);
                        wVar.m(1);
                        if (wVar.f()) {
                            wVar.m(15);
                            wVar.l();
                            wVar.m(15);
                            wVar.l();
                            wVar.m(15);
                            wVar.l();
                            wVar.m(3);
                            wVar.m(11);
                            wVar.l();
                            wVar.m(15);
                            wVar.l();
                        }
                    }
                    if (wVar.g(2) != 0) {
                        Log.w("H263Reader", "Unhandled video object layer shape");
                    }
                    wVar.l();
                    iG2 = wVar.g(16);
                    wVar.l();
                    if (wVar.f()) {
                        if (iG2 == 0) {
                            Log.w("H263Reader", "Invalid vop_increment_time_resolution");
                        } else {
                            i4 = 0;
                            while (i3 > 0) {
                                i4++;
                            }
                            wVar.m(i4);
                        }
                    }
                    wVar.l();
                    int iG7 = wVar.g(13);
                    wVar.l();
                    int iG8 = wVar.g(13);
                    wVar.l();
                    wVar.l();
                    j1$b j1_b2 = new j1$b();
                    j1_b2.a = str2;
                    j1_b2.k = "video/mp4v-es";
                    j1_b2.p = iG7;
                    j1_b2.q = iG8;
                    j1_b2.t = f;
                    j1_b2.m = Collections.singletonList(bArrCopyOf2);
                    wVar4.e(j1_b2.a());
                    this.k = true;
                } else {
                    i = i6;
                }
            }
            this.g.a(bArr, i5, iB);
            w wVar5 = this.f;
            if (wVar5 != null) {
                if (i9 > 0) {
                    wVar5.a(bArr, i5, iB);
                    i2 = 0;
                } else {
                    i2 = -i9;
                }
                if (this.f.b(i2)) {
                    w wVar6 = this.f;
                    int iF = b.i.a.c.f3.u.f(wVar6.d, wVar6.e);
                    b.i.a.c.f3.x xVar2 = this.c;
                    int i14 = b.i.a.c.f3.e0.a;
                    xVar2.C(this.f.d, iF);
                    this.f1269b.a(this.l, this.c);
                }
                if (i8 == 178) {
                    if (xVar.a[iB + 2] == 1) {
                        this.f.d(i8);
                    }
                }
            }
            int i15 = i - iB;
            long j = this.h - ((long) i15);
            q$b q_b = this.g;
            boolean z3 = this.k;
            if (q_b.e == 182 && z3 && q_b.f1271b) {
                long j2 = q_b.h;
                if (j2 != -9223372036854775807L) {
                    q_b.a.d(j2, q_b.d ? 1 : 0, (int) (j - q_b.g), i15, null);
                }
            }
            if (q_b.e != 179) {
                q_b.g = j;
            }
            q$b q_b2 = this.g;
            long j3 = this.l;
            q_b2.e = i8;
            q_b2.d = false;
            q_b2.f1271b = i8 == 182 || i8 == 179;
            q_b2.c = i8 == 182;
            q_b2.f = 0;
            q_b2.h = j3;
            i6 = i;
            i5 = i7;
        }
    }

    @Override // b.i.a.c.x2.k0.o
    public void c() {
        b.i.a.c.f3.u.a(this.d);
        this.e.b();
        q$b q_b = this.g;
        if (q_b != null) {
            q_b.f1271b = false;
            q_b.c = false;
            q_b.d = false;
            q_b.e = -1;
        }
        w wVar = this.f;
        if (wVar != null) {
            wVar.c();
        }
        this.h = 0L;
        this.l = -9223372036854775807L;
    }

    @Override // b.i.a.c.x2.k0.o
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.o
    public void e(b.i.a.c.x2.j jVar, i0$d i0_d) {
        i0_d.a();
        this.i = i0_d.b();
        b.i.a.c.x2.w wVarP = jVar.p(i0_d.c(), 2);
        this.j = wVarP;
        this.g = new q$b(wVarP);
        j0 j0Var = this.f1269b;
        if (j0Var != null) {
            j0Var.b(jVar, i0_d);
        }
    }

    @Override // b.i.a.c.x2.k0.o
    public void f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.l = j;
        }
    }
}
