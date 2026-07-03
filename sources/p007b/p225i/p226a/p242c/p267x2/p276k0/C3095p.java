package p007b.p225i.p226a.p242c.p267x2.p276k0;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2754u;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;
import p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3087i0;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.p */
/* JADX INFO: compiled from: H262Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3095p implements InterfaceC3094o {

    /* JADX INFO: renamed from: a */
    public static final double[] f8740a = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* JADX INFO: renamed from: b */
    public String f8741b;

    /* JADX INFO: renamed from: c */
    public InterfaceC3122w f8742c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public final C3089j0 f8743d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public final C2757x f8744e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public final C3102w f8745f;

    /* JADX INFO: renamed from: g */
    public final boolean[] f8746g = new boolean[4];

    /* JADX INFO: renamed from: h */
    public final a f8747h = new a(128);

    /* JADX INFO: renamed from: i */
    public long f8748i;

    /* JADX INFO: renamed from: j */
    public boolean f8749j;

    /* JADX INFO: renamed from: k */
    public boolean f8750k;

    /* JADX INFO: renamed from: l */
    public long f8751l;

    /* JADX INFO: renamed from: m */
    public long f8752m;

    /* JADX INFO: renamed from: n */
    public long f8753n;

    /* JADX INFO: renamed from: o */
    public long f8754o;

    /* JADX INFO: renamed from: p */
    public boolean f8755p;

    /* JADX INFO: renamed from: q */
    public boolean f8756q;

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.p$a */
    /* JADX INFO: compiled from: H262Reader.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final byte[] f8757a = {0, 0, 1};

        /* JADX INFO: renamed from: b */
        public boolean f8758b;

        /* JADX INFO: renamed from: c */
        public int f8759c;

        /* JADX INFO: renamed from: d */
        public int f8760d;

        /* JADX INFO: renamed from: e */
        public byte[] f8761e;

        public a(int i) {
            this.f8761e = new byte[i];
        }

        /* JADX INFO: renamed from: a */
        public void m3779a(byte[] bArr, int i, int i2) {
            if (this.f8758b) {
                int i3 = i2 - i;
                byte[] bArr2 = this.f8761e;
                int length = bArr2.length;
                int i4 = this.f8759c;
                if (length < i4 + i3) {
                    this.f8761e = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.f8761e, this.f8759c, i3);
                this.f8759c += i3;
            }
        }
    }

    public C3095p(@Nullable C3089j0 c3089j0) {
        this.f8743d = c3089j0;
        if (c3089j0 != null) {
            this.f8745f = new C3102w(Opcodes.GETSTATIC, 128);
            this.f8744e = new C2757x();
        } else {
            this.f8745f = null;
            this.f8744e = null;
        }
        this.f8752m = -9223372036854775807L;
        this.f8754o = -9223372036854775807L;
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
    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: b */
    public void mo3758b(C2757x c2757x) {
        int i;
        long j;
        int i2;
        boolean z2;
        a aVar;
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
        C1460d.m438H(this.f8742c);
        int i10 = c2757x.f6794b;
        int i11 = c2757x.f6795c;
        byte[] bArr = c2757x.f6793a;
        this.f8748i += (long) c2757x.m3081a();
        this.f8742c.mo2524c(c2757x, c2757x.m3081a());
        while (true) {
            int iM3055b = C2754u.m3055b(bArr, i10, i11, this.f8746g);
            if (iM3055b == i11) {
                break;
            }
            int i12 = iM3055b + 3;
            int i13 = c2757x.f6793a[i12] & 255;
            int i14 = iM3055b - i10;
            if (this.f8750k) {
                i13 = i13;
                i12 = i12;
            } else {
                if (i14 > 0) {
                    this.f8747h.m3779a(bArr, i10, iM3055b);
                }
                int i15 = i14 < 0 ? -i14 : 0;
                a aVar2 = this.f8747h;
                if (aVar2.f8758b) {
                    int i16 = aVar2.f8759c - i15;
                    aVar2.f8759c = i16;
                    if (aVar2.f8760d == 0 && i13 == 181) {
                        aVar2.f8760d = i16;
                    } else {
                        aVar2.f8758b = false;
                        z2 = true;
                    }
                    if (z2) {
                        aVar = this.f8747h;
                        String str = this.f8741b;
                        Objects.requireNonNull(str);
                        bArrCopyOf = Arrays.copyOf(aVar.f8761e, aVar.f8759c);
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
                            C2811j1.b bVar = new C2811j1.b();
                            bVar.f7163a = str;
                            bVar.f7173k = "video/mpeg2";
                            bVar.f7178p = i3;
                            bVar.f7179q = i4;
                            bVar.f7182t = f2;
                            bVar.f7175m = Collections.singletonList(bArrCopyOf);
                            C2811j1 c2811j1M3277a = bVar.m3277a();
                            i7 = (bArrCopyOf[7] & 15) - 1;
                            if (i7 >= 0) {
                                dArr = f8740a;
                                if (i7 < dArr.length) {
                                    d = dArr[i7];
                                    int i19 = aVar.f8760d + 9;
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
                            Pair pairCreate = Pair.create(c2811j1M3277a, Long.valueOf(j2));
                            this.f8742c.mo2526e((C2811j1) pairCreate.first);
                            this.f8751l = ((Long) pairCreate.second).longValue();
                            this.f8750k = true;
                        } else {
                            f = i4 * 16;
                            i6 = i3 * 9;
                        }
                        f2 = f / i6;
                        C2811j1.b bVar2 = new C2811j1.b();
                        bVar2.f7163a = str;
                        bVar2.f7173k = "video/mpeg2";
                        bVar2.f7178p = i3;
                        bVar2.f7179q = i4;
                        bVar2.f7182t = f2;
                        bVar2.f7175m = Collections.singletonList(bArrCopyOf);
                        C2811j1 c2811j1M3277a2 = bVar2.m3277a();
                        i7 = (bArrCopyOf[7] & 15) - 1;
                        if (i7 >= 0) {
                            dArr = f8740a;
                            if (i7 < dArr.length) {
                                d = dArr[i7];
                                int i110 = aVar.f8760d + 9;
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
                        Pair pairCreate2 = Pair.create(c2811j1M3277a2, Long.valueOf(j2));
                        this.f8742c.mo2526e((C2811j1) pairCreate2.first);
                        this.f8751l = ((Long) pairCreate2.second).longValue();
                        this.f8750k = true;
                    } else {
                        i13 = i13;
                        i12 = i12;
                    }
                } else if (i13 == 179) {
                    aVar2.f8758b = true;
                }
                byte[] bArr2 = a.f8757a;
                aVar2.m3779a(bArr2, 0, bArr2.length);
                z2 = false;
                if (z2) {
                    aVar = this.f8747h;
                    String str2 = this.f8741b;
                    Objects.requireNonNull(str2);
                    bArrCopyOf = Arrays.copyOf(aVar.f8761e, aVar.f8759c);
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
                        C2811j1.b bVar3 = new C2811j1.b();
                        bVar3.f7163a = str2;
                        bVar3.f7173k = "video/mpeg2";
                        bVar3.f7178p = i3;
                        bVar3.f7179q = i4;
                        bVar3.f7182t = f2;
                        bVar3.f7175m = Collections.singletonList(bArrCopyOf);
                        C2811j1 c2811j1M3277a3 = bVar3.m3277a();
                        i7 = (bArrCopyOf[7] & 15) - 1;
                        if (i7 >= 0) {
                            dArr = f8740a;
                            if (i7 < dArr.length) {
                                d = dArr[i7];
                                int i113 = aVar.f8760d + 9;
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
                        Pair pairCreate3 = Pair.create(c2811j1M3277a3, Long.valueOf(j2));
                        this.f8742c.mo2526e((C2811j1) pairCreate3.first);
                        this.f8751l = ((Long) pairCreate3.second).longValue();
                        this.f8750k = true;
                    } else {
                        f = i4 * 16;
                        i6 = i3 * 9;
                    }
                    f2 = f / i6;
                    C2811j1.b bVar4 = new C2811j1.b();
                    bVar4.f7163a = str2;
                    bVar4.f7173k = "video/mpeg2";
                    bVar4.f7178p = i3;
                    bVar4.f7179q = i4;
                    bVar4.f7182t = f2;
                    bVar4.f7175m = Collections.singletonList(bArrCopyOf);
                    C2811j1 c2811j1M3277a4 = bVar4.m3277a();
                    i7 = (bArrCopyOf[7] & 15) - 1;
                    if (i7 >= 0) {
                        dArr = f8740a;
                        if (i7 < dArr.length) {
                            d = dArr[i7];
                            int i114 = aVar.f8760d + 9;
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
                    Pair pairCreate4 = Pair.create(c2811j1M3277a4, Long.valueOf(j2));
                    this.f8742c.mo2526e((C2811j1) pairCreate4.first);
                    this.f8751l = ((Long) pairCreate4.second).longValue();
                    this.f8750k = true;
                } else {
                    i13 = i13;
                    i12 = i12;
                }
            }
            C3102w c3102w = this.f8745f;
            if (c3102w != null) {
                if (i14 > 0) {
                    c3102w.m3788a(bArr, i10, iM3055b);
                    i2 = 0;
                } else {
                    i2 = -i14;
                }
                if (this.f8745f.m3789b(i2)) {
                    C3102w c3102w2 = this.f8745f;
                    int iM3059f = C2754u.m3059f(c3102w2.f8906d, c3102w2.f8907e);
                    C2757x c2757x2 = this.f8744e;
                    int i20 = C2738e0.f6708a;
                    c2757x2.m3077C(this.f8745f.f8906d, iM3059f);
                    this.f8743d.m3769a(this.f8754o, this.f8744e);
                }
                i = i13;
                if (i == 178 && c2757x.f6793a[iM3055b + 2] == 1) {
                    this.f8745f.m3791d(i);
                }
            } else {
                i = i13;
            }
            if (i == 0 || i == 179) {
                int i21 = i11 - iM3055b;
                if (this.f8756q && this.f8750k) {
                    long j3 = this.f8754o;
                    if (j3 != -9223372036854775807L) {
                        j = -9223372036854775807L;
                        this.f8742c.mo2525d(j3, this.f8755p ? 1 : 0, ((int) (this.f8748i - this.f8753n)) - i21, i21, null);
                    } else {
                        j = -9223372036854775807L;
                    }
                } else {
                    j = -9223372036854775807L;
                }
                if (!this.f8749j || this.f8756q) {
                    this.f8753n = this.f8748i - ((long) i21);
                    long j4 = this.f8752m;
                    if (j4 == j) {
                        long j5 = this.f8754o;
                        j4 = j5 != j ? j5 + this.f8751l : j;
                    }
                    this.f8754o = j4;
                    this.f8755p = false;
                    this.f8752m = j;
                    this.f8749j = true;
                }
                this.f8756q = i == 0;
            } else {
                if (i == 184) {
                    this.f8755p = true;
                }
                i11 = i11;
                bArr = bArr;
            }
            i11 = i11;
            bArr = bArr;
            i10 = i12;
        }
        if (!this.f8750k) {
            this.f8747h.m3779a(bArr, i10, i11);
        }
        C3102w c3102w3 = this.f8745f;
        if (c3102w3 != null) {
            c3102w3.m3788a(bArr, i10, i11);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: c */
    public void mo3759c() {
        C2754u.m3054a(this.f8746g);
        a aVar = this.f8747h;
        aVar.f8758b = false;
        aVar.f8759c = 0;
        aVar.f8760d = 0;
        C3102w c3102w = this.f8745f;
        if (c3102w != null) {
            c3102w.m3790c();
        }
        this.f8748i = 0L;
        this.f8749j = false;
        this.f8752m = -9223372036854775807L;
        this.f8754o = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: d */
    public void mo3760d() {
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: e */
    public void mo3761e(InterfaceC3058j interfaceC3058j, InterfaceC3087i0.d dVar) {
        dVar.m3765a();
        this.f8741b = dVar.m3766b();
        this.f8742c = interfaceC3058j.mo2492p(dVar.m3767c(), 2);
        C3089j0 c3089j0 = this.f8743d;
        if (c3089j0 != null) {
            c3089j0.m3770b(interfaceC3058j, dVar);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.InterfaceC3094o
    /* JADX INFO: renamed from: f */
    public void mo3762f(long j, int i) {
        this.f8752m = j;
    }
}
