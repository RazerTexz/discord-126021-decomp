package p007b.p225i.p226a.p242c.p267x2.p276k0;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2754u;
import p007b.p225i.p226a.p242c.p259f3.C2756w;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.q */
/* JADX INFO: compiled from: H263Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3096q implements InterfaceC3094o {

    /* JADX INFO: renamed from: a */
    public static final float[] f8762a = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* JADX INFO: renamed from: b */
    @Nullable
    public final C3089j0 f8763b;

    /* JADX INFO: renamed from: g */
    public b f8768g;

    /* JADX INFO: renamed from: h */
    public long f8769h;

    /* JADX INFO: renamed from: i */
    public String f8770i;

    /* JADX INFO: renamed from: j */
    public InterfaceC3122w f8771j;

    /* JADX INFO: renamed from: k */
    public boolean f8772k;

    /* JADX INFO: renamed from: d */
    public final boolean[] f8765d = new boolean[4];

    /* JADX INFO: renamed from: e */
    public final a f8766e = new a(128);

    /* JADX INFO: renamed from: l */
    public long f8773l = -9223372036854775807L;

    /* JADX INFO: renamed from: f */
    @Nullable
    public final C3102w f8767f = new C3102w(Opcodes.GETSTATIC, 128);

    /* JADX INFO: renamed from: c */
    @Nullable
    public final C2757x f8764c = new C2757x();

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.q$a */
    /* JADX INFO: compiled from: H263Reader.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final byte[] f8774a = {0, 0, 1};

        /* JADX INFO: renamed from: b */
        public boolean f8775b;

        /* JADX INFO: renamed from: c */
        public int f8776c;

        /* JADX INFO: renamed from: d */
        public int f8777d;

        /* JADX INFO: renamed from: e */
        public int f8778e;

        /* JADX INFO: renamed from: f */
        public byte[] f8779f;

        public a(int i) {
            this.f8779f = new byte[i];
        }

        /* JADX INFO: renamed from: a */
        public void m3780a(byte[] bArr, int i, int i2) {
            if (this.f8775b) {
                int i3 = i2 - i;
                byte[] bArr2 = this.f8779f;
                int length = bArr2.length;
                int i4 = this.f8777d;
                if (length < i4 + i3) {
                    this.f8779f = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.f8779f, this.f8777d, i3);
                this.f8777d += i3;
            }
        }

        /* JADX INFO: renamed from: b */
        public void m3781b() {
            this.f8775b = false;
            this.f8777d = 0;
            this.f8776c = 0;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.q$b */
    /* JADX INFO: compiled from: H263Reader.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final InterfaceC3122w f8780a;

        /* JADX INFO: renamed from: b */
        public boolean f8781b;

        /* JADX INFO: renamed from: c */
        public boolean f8782c;

        /* JADX INFO: renamed from: d */
        public boolean f8783d;

        /* JADX INFO: renamed from: e */
        public int f8784e;

        /* JADX INFO: renamed from: f */
        public int f8785f;

        /* JADX INFO: renamed from: g */
        public long f8786g;

        /* JADX INFO: renamed from: h */
        public long f8787h;

        public b(InterfaceC3122w interfaceC3122w) {
            this.f8780a = interfaceC3122w;
        }

        /* JADX INFO: renamed from: a */
        public void m3782a(byte[] bArr, int i, int i2) {
            if (this.f8782c) {
                int i3 = this.f8785f;
                int i4 = (i + 1) - i3;
                if (i4 >= i2) {
                    this.f8785f = (i2 - i) + i3;
                } else {
                    this.f8783d = ((bArr[i4] & 192) >> 6) == 0;
                    this.f8782c = false;
                }
            }
        }
    }

    public C3096q(@Nullable C3089j0 c3089j0) {
        this.f8763b = c3089j0;
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
    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: b */
    public void mo3758b(C2757x c2757x) {
        int i;
        int i2;
        boolean z2;
        C2756w c2756w;
        int iM3067g;
        float[] fArr;
        float f;
        int iM3067g2;
        int i3;
        int i4;
        int iM3067g3;
        int iM3067g4;
        C1460d.m438H(this.f8768g);
        C1460d.m438H(this.f8771j);
        int i5 = c2757x.f6794b;
        int i6 = c2757x.f6795c;
        byte[] bArr = c2757x.f6793a;
        this.f8769h += (long) c2757x.m3081a();
        this.f8771j.mo2524c(c2757x, c2757x.m3081a());
        while (true) {
            int iM3055b = C2754u.m3055b(bArr, i5, i6, this.f8765d);
            if (iM3055b == i6) {
                if (!this.f8772k) {
                    this.f8766e.m3780a(bArr, i5, i6);
                }
                this.f8768g.m3782a(bArr, i5, i6);
                C3102w c3102w = this.f8767f;
                if (c3102w != null) {
                    c3102w.m3788a(bArr, i5, i6);
                    return;
                }
                return;
            }
            int i7 = iM3055b + 3;
            int i8 = c2757x.f6793a[i7] & 255;
            int i9 = iM3055b - i5;
            if (this.f8772k) {
                i = i6;
            } else {
                if (i9 > 0) {
                    this.f8766e.m3780a(bArr, i5, iM3055b);
                }
                int i10 = i9 < 0 ? -i9 : 0;
                a aVar = this.f8766e;
                int i11 = aVar.f8776c;
                if (i11 != 0) {
                    if (i11 != 1) {
                        if (i11 != 2) {
                            if (i11 != 3) {
                                if (i11 != 4) {
                                    throw new IllegalStateException();
                                }
                                if (i8 == 179 || i8 == 181) {
                                    aVar.f8777d -= i10;
                                    aVar.f8775b = false;
                                    z2 = true;
                                }
                                if (z2) {
                                    InterfaceC3122w interfaceC3122w = this.f8771j;
                                    a aVar2 = this.f8766e;
                                    int i12 = aVar2.f8778e;
                                    String str = this.f8770i;
                                    Objects.requireNonNull(str);
                                    byte[] bArrCopyOf = Arrays.copyOf(aVar2.f8779f, aVar2.f8777d);
                                    c2756w = new C2756w(bArrCopyOf);
                                    c2756w.m3074n(i12);
                                    c2756w.m3074n(4);
                                    c2756w.m3072l();
                                    c2756w.m3073m(8);
                                    if (c2756w.m3066f()) {
                                        c2756w.m3073m(4);
                                        c2756w.m3073m(3);
                                    }
                                    iM3067g = c2756w.m3067g(4);
                                    if (iM3067g == 15) {
                                        iM3067g3 = c2756w.m3067g(8);
                                        iM3067g4 = c2756w.m3067g(8);
                                        if (iM3067g4 == 0) {
                                            Log.w("H263Reader", "Invalid aspect ratio");
                                            i = i6;
                                            f = 1.0f;
                                        } else {
                                            f = iM3067g3 / iM3067g4;
                                            i = i6;
                                        }
                                    } else {
                                        fArr = f8762a;
                                        i = i6;
                                        if (iM3067g < fArr.length) {
                                            f = fArr[iM3067g];
                                        } else {
                                            Log.w("H263Reader", "Invalid aspect ratio");
                                            f = 1.0f;
                                        }
                                    }
                                    if (c2756w.m3066f()) {
                                        c2756w.m3073m(2);
                                        c2756w.m3073m(1);
                                        if (c2756w.m3066f()) {
                                            c2756w.m3073m(15);
                                            c2756w.m3072l();
                                            c2756w.m3073m(15);
                                            c2756w.m3072l();
                                            c2756w.m3073m(15);
                                            c2756w.m3072l();
                                            c2756w.m3073m(3);
                                            c2756w.m3073m(11);
                                            c2756w.m3072l();
                                            c2756w.m3073m(15);
                                            c2756w.m3072l();
                                        }
                                    }
                                    if (c2756w.m3067g(2) != 0) {
                                        Log.w("H263Reader", "Unhandled video object layer shape");
                                    }
                                    c2756w.m3072l();
                                    iM3067g2 = c2756w.m3067g(16);
                                    c2756w.m3072l();
                                    if (c2756w.m3066f()) {
                                        if (iM3067g2 == 0) {
                                            Log.w("H263Reader", "Invalid vop_increment_time_resolution");
                                        } else {
                                            i4 = 0;
                                            for (i3 = iM3067g2 - 1; i3 > 0; i3 >>= 1) {
                                                i4++;
                                            }
                                            c2756w.m3073m(i4);
                                        }
                                    }
                                    c2756w.m3072l();
                                    int iM3067g5 = c2756w.m3067g(13);
                                    c2756w.m3072l();
                                    int iM3067g6 = c2756w.m3067g(13);
                                    c2756w.m3072l();
                                    c2756w.m3072l();
                                    C2811j1.b bVar = new C2811j1.b();
                                    bVar.f7163a = str;
                                    bVar.f7173k = "video/mp4v-es";
                                    bVar.f7178p = iM3067g5;
                                    bVar.f7179q = iM3067g6;
                                    bVar.f7182t = f;
                                    bVar.f7175m = Collections.singletonList(bArrCopyOf);
                                    interfaceC3122w.mo2526e(bVar.m3277a());
                                    this.f8772k = true;
                                } else {
                                    i = i6;
                                }
                            } else if ((i8 & 240) != 32) {
                                Log.w("H263Reader", "Unexpected start code value");
                                aVar.m3781b();
                            } else {
                                aVar.f8778e = aVar.f8777d;
                                aVar.f8776c = 4;
                            }
                        } else if (i8 > 31) {
                            Log.w("H263Reader", "Unexpected start code value");
                            aVar.m3781b();
                        } else {
                            aVar.f8776c = 3;
                        }
                    } else if (i8 != 181) {
                        Log.w("H263Reader", "Unexpected start code value");
                        aVar.m3781b();
                    } else {
                        aVar.f8776c = 2;
                    }
                } else if (i8 == 176) {
                    aVar.f8776c = 1;
                    aVar.f8775b = true;
                }
                byte[] bArr2 = a.f8774a;
                aVar.m3780a(bArr2, 0, bArr2.length);
                z2 = false;
                if (z2) {
                    InterfaceC3122w interfaceC3122w2 = this.f8771j;
                    a aVar3 = this.f8766e;
                    int i13 = aVar3.f8778e;
                    String str2 = this.f8770i;
                    Objects.requireNonNull(str2);
                    byte[] bArrCopyOf2 = Arrays.copyOf(aVar3.f8779f, aVar3.f8777d);
                    c2756w = new C2756w(bArrCopyOf2);
                    c2756w.m3074n(i13);
                    c2756w.m3074n(4);
                    c2756w.m3072l();
                    c2756w.m3073m(8);
                    if (c2756w.m3066f()) {
                        c2756w.m3073m(4);
                        c2756w.m3073m(3);
                    }
                    iM3067g = c2756w.m3067g(4);
                    if (iM3067g == 15) {
                        iM3067g3 = c2756w.m3067g(8);
                        iM3067g4 = c2756w.m3067g(8);
                        if (iM3067g4 == 0) {
                            Log.w("H263Reader", "Invalid aspect ratio");
                            i = i6;
                            f = 1.0f;
                        } else {
                            f = iM3067g3 / iM3067g4;
                            i = i6;
                        }
                    } else {
                        fArr = f8762a;
                        i = i6;
                        if (iM3067g < fArr.length) {
                            f = fArr[iM3067g];
                        } else {
                            Log.w("H263Reader", "Invalid aspect ratio");
                            f = 1.0f;
                        }
                    }
                    if (c2756w.m3066f()) {
                        c2756w.m3073m(2);
                        c2756w.m3073m(1);
                        if (c2756w.m3066f()) {
                            c2756w.m3073m(15);
                            c2756w.m3072l();
                            c2756w.m3073m(15);
                            c2756w.m3072l();
                            c2756w.m3073m(15);
                            c2756w.m3072l();
                            c2756w.m3073m(3);
                            c2756w.m3073m(11);
                            c2756w.m3072l();
                            c2756w.m3073m(15);
                            c2756w.m3072l();
                        }
                    }
                    if (c2756w.m3067g(2) != 0) {
                        Log.w("H263Reader", "Unhandled video object layer shape");
                    }
                    c2756w.m3072l();
                    iM3067g2 = c2756w.m3067g(16);
                    c2756w.m3072l();
                    if (c2756w.m3066f()) {
                        if (iM3067g2 == 0) {
                            Log.w("H263Reader", "Invalid vop_increment_time_resolution");
                        } else {
                            i4 = 0;
                            while (i3 > 0) {
                                i4++;
                            }
                            c2756w.m3073m(i4);
                        }
                    }
                    c2756w.m3072l();
                    int iM3067g7 = c2756w.m3067g(13);
                    c2756w.m3072l();
                    int iM3067g8 = c2756w.m3067g(13);
                    c2756w.m3072l();
                    c2756w.m3072l();
                    C2811j1.b bVar2 = new C2811j1.b();
                    bVar2.f7163a = str2;
                    bVar2.f7173k = "video/mp4v-es";
                    bVar2.f7178p = iM3067g7;
                    bVar2.f7179q = iM3067g8;
                    bVar2.f7182t = f;
                    bVar2.f7175m = Collections.singletonList(bArrCopyOf2);
                    interfaceC3122w2.mo2526e(bVar2.m3277a());
                    this.f8772k = true;
                } else {
                    i = i6;
                }
            }
            this.f8768g.m3782a(bArr, i5, iM3055b);
            C3102w c3102w2 = this.f8767f;
            if (c3102w2 != null) {
                if (i9 > 0) {
                    c3102w2.m3788a(bArr, i5, iM3055b);
                    i2 = 0;
                } else {
                    i2 = -i9;
                }
                if (this.f8767f.m3789b(i2)) {
                    C3102w c3102w3 = this.f8767f;
                    int iM3059f = C2754u.m3059f(c3102w3.f8906d, c3102w3.f8907e);
                    C2757x c2757x2 = this.f8764c;
                    int i14 = C2738e0.f6708a;
                    c2757x2.m3077C(this.f8767f.f8906d, iM3059f);
                    this.f8763b.m3769a(this.f8773l, this.f8764c);
                }
                if (i8 == 178) {
                    if (c2757x.f6793a[iM3055b + 2] == 1) {
                        this.f8767f.m3791d(i8);
                    }
                }
            }
            int i15 = i - iM3055b;
            long j = this.f8769h - ((long) i15);
            b bVar3 = this.f8768g;
            boolean z3 = this.f8772k;
            if (bVar3.f8784e == 182 && z3 && bVar3.f8781b) {
                long j2 = bVar3.f8787h;
                if (j2 != -9223372036854775807L) {
                    bVar3.f8780a.mo2525d(j2, bVar3.f8783d ? 1 : 0, (int) (j - bVar3.f8786g), i15, null);
                }
            }
            if (bVar3.f8784e != 179) {
                bVar3.f8786g = j;
            }
            b bVar4 = this.f8768g;
            long j3 = this.f8773l;
            bVar4.f8784e = i8;
            bVar4.f8783d = false;
            bVar4.f8781b = i8 == 182 || i8 == 179;
            bVar4.f8782c = i8 == 182;
            bVar4.f8785f = 0;
            bVar4.f8787h = j3;
            i6 = i;
            i5 = i7;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: c */
    public void mo3759c() {
        C2754u.m3054a(this.f8765d);
        this.f8766e.m3781b();
        b bVar = this.f8768g;
        if (bVar != null) {
            bVar.f8781b = false;
            bVar.f8782c = false;
            bVar.f8783d = false;
            bVar.f8784e = -1;
        }
        C3102w c3102w = this.f8767f;
        if (c3102w != null) {
            c3102w.m3790c();
        }
        this.f8769h = 0L;
        this.f8773l = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: d */
    public void mo3760d() {
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: e */
    public void mo3761e(InterfaceC3058j interfaceC3058j, InterfaceC3087i0.d dVar) {
        dVar.m3765a();
        this.f8770i = dVar.m3766b();
        InterfaceC3122w interfaceC3122wMo2492p = interfaceC3058j.mo2492p(dVar.m3767c(), 2);
        this.f8771j = interfaceC3122wMo2492p;
        this.f8768g = new b(interfaceC3122wMo2492p);
        C3089j0 c3089j0 = this.f8763b;
        if (c3089j0 != null) {
            c3089j0.m3770b(interfaceC3058j, dVar);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: f */
    public void mo3762f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.f8773l = j;
        }
    }
}
