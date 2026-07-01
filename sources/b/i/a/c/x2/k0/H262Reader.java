package b.i.a.c.x2.k0;

import android.util.Pair;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.f3.NalUnitUtil;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.k0.TsPayloadReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.p, reason: use source file name */
/* JADX INFO: compiled from: H262Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class H262Reader implements ElementaryStreamReader {
    public static final double[] a = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1267b;
    public TrackOutput2 c;

    @Nullable
    public final UserDataReader d;

    @Nullable
    public final ParsableByteArray e;

    @Nullable
    public final NalUnitTargetBuffer f;
    public final boolean[] g = new boolean[4];
    public final a h = new a(128);
    public long i;
    public boolean j;
    public boolean k;
    public long l;
    public long m;
    public long n;
    public long o;
    public boolean p;
    public boolean q;

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.p$a */
    /* JADX INFO: compiled from: H262Reader.java */
    public static final class a {
        public static final byte[] a = {0, 0, 1};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1268b;
        public int c;
        public int d;
        public byte[] e;

        public a(int i) {
            this.e = new byte[i];
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.f1268b) {
                int i3 = i2 - i;
                byte[] bArr2 = this.e;
                int length = bArr2.length;
                int i4 = this.c;
                if (length < i4 + i3) {
                    this.e = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.e, this.c, i3);
                this.c += i3;
            }
        }
    }

    public H262Reader(@Nullable UserDataReader userDataReader) {
        this.d = userDataReader;
        if (userDataReader != null) {
            this.f = new NalUnitTargetBuffer(Opcodes.GETSTATIC, 128);
            this.e = new ParsableByteArray();
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
    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void b(ParsableByteArray parsableByteArray) {
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
        AnimatableValueParser.H(this.c);
        int i10 = parsableByteArray.f984b;
        int i11 = parsableByteArray.c;
        byte[] bArr = parsableByteArray.a;
        this.i += (long) parsableByteArray.a();
        this.c.c(parsableByteArray, parsableByteArray.a());
        while (true) {
            int iB = NalUnitUtil.b(bArr, i10, i11, this.g);
            if (iB == i11) {
                break;
            }
            int i12 = iB + 3;
            int i13 = parsableByteArray.a[i12] & 255;
            int i14 = iB - i10;
            if (this.k) {
                i13 = i13;
                i12 = i12;
            } else {
                if (i14 > 0) {
                    this.h.a(bArr, i10, iB);
                }
                int i15 = i14 < 0 ? -i14 : 0;
                a aVar2 = this.h;
                if (aVar2.f1268b) {
                    int i16 = aVar2.c - i15;
                    aVar2.c = i16;
                    if (aVar2.d == 0 && i13 == 181) {
                        aVar2.d = i16;
                    } else {
                        aVar2.f1268b = false;
                        z2 = true;
                    }
                    if (z2) {
                        aVar = this.h;
                        String str = this.f1267b;
                        Objects.requireNonNull(str);
                        bArrCopyOf = Arrays.copyOf(aVar.e, aVar.c);
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
                            Format2.b bVar = new Format2.b();
                            bVar.a = str;
                            bVar.k = "video/mpeg2";
                            bVar.p = i3;
                            bVar.q = i4;
                            bVar.t = f2;
                            bVar.m = Collections.singletonList(bArrCopyOf);
                            Format2 format2A = bVar.a();
                            i7 = (bArrCopyOf[7] & 15) - 1;
                            if (i7 >= 0) {
                                dArr = a;
                                if (i7 < dArr.length) {
                                    d = dArr[i7];
                                    int i19 = aVar.d + 9;
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
                            Pair pairCreate = Pair.create(format2A, Long.valueOf(j2));
                            this.c.e((Format2) pairCreate.first);
                            this.l = ((Long) pairCreate.second).longValue();
                            this.k = true;
                        } else {
                            f = i4 * 16;
                            i6 = i3 * 9;
                        }
                        f2 = f / i6;
                        Format2.b bVar2 = new Format2.b();
                        bVar2.a = str;
                        bVar2.k = "video/mpeg2";
                        bVar2.p = i3;
                        bVar2.q = i4;
                        bVar2.t = f2;
                        bVar2.m = Collections.singletonList(bArrCopyOf);
                        Format2 format2A2 = bVar2.a();
                        i7 = (bArrCopyOf[7] & 15) - 1;
                        if (i7 >= 0) {
                            dArr = a;
                            if (i7 < dArr.length) {
                                d = dArr[i7];
                                int i110 = aVar.d + 9;
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
                        Pair pairCreate2 = Pair.create(format2A2, Long.valueOf(j2));
                        this.c.e((Format2) pairCreate2.first);
                        this.l = ((Long) pairCreate2.second).longValue();
                        this.k = true;
                    } else {
                        i13 = i13;
                        i12 = i12;
                    }
                } else if (i13 == 179) {
                    aVar2.f1268b = true;
                }
                byte[] bArr2 = a.a;
                aVar2.a(bArr2, 0, bArr2.length);
                z2 = false;
                if (z2) {
                    aVar = this.h;
                    String str2 = this.f1267b;
                    Objects.requireNonNull(str2);
                    bArrCopyOf = Arrays.copyOf(aVar.e, aVar.c);
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
                        Format2.b bVar3 = new Format2.b();
                        bVar3.a = str2;
                        bVar3.k = "video/mpeg2";
                        bVar3.p = i3;
                        bVar3.q = i4;
                        bVar3.t = f2;
                        bVar3.m = Collections.singletonList(bArrCopyOf);
                        Format2 format2A3 = bVar3.a();
                        i7 = (bArrCopyOf[7] & 15) - 1;
                        if (i7 >= 0) {
                            dArr = a;
                            if (i7 < dArr.length) {
                                d = dArr[i7];
                                int i113 = aVar.d + 9;
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
                        Pair pairCreate3 = Pair.create(format2A3, Long.valueOf(j2));
                        this.c.e((Format2) pairCreate3.first);
                        this.l = ((Long) pairCreate3.second).longValue();
                        this.k = true;
                    } else {
                        f = i4 * 16;
                        i6 = i3 * 9;
                    }
                    f2 = f / i6;
                    Format2.b bVar4 = new Format2.b();
                    bVar4.a = str2;
                    bVar4.k = "video/mpeg2";
                    bVar4.p = i3;
                    bVar4.q = i4;
                    bVar4.t = f2;
                    bVar4.m = Collections.singletonList(bArrCopyOf);
                    Format2 format2A4 = bVar4.a();
                    i7 = (bArrCopyOf[7] & 15) - 1;
                    if (i7 >= 0) {
                        dArr = a;
                        if (i7 < dArr.length) {
                            d = dArr[i7];
                            int i114 = aVar.d + 9;
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
                    Pair pairCreate4 = Pair.create(format2A4, Long.valueOf(j2));
                    this.c.e((Format2) pairCreate4.first);
                    this.l = ((Long) pairCreate4.second).longValue();
                    this.k = true;
                } else {
                    i13 = i13;
                    i12 = i12;
                }
            }
            NalUnitTargetBuffer nalUnitTargetBuffer = this.f;
            if (nalUnitTargetBuffer != null) {
                if (i14 > 0) {
                    nalUnitTargetBuffer.a(bArr, i10, iB);
                    i2 = 0;
                } else {
                    i2 = -i14;
                }
                if (this.f.b(i2)) {
                    NalUnitTargetBuffer nalUnitTargetBuffer2 = this.f;
                    int iF = NalUnitUtil.f(nalUnitTargetBuffer2.d, nalUnitTargetBuffer2.e);
                    ParsableByteArray parsableByteArray2 = this.e;
                    int i20 = Util2.a;
                    parsableByteArray2.C(this.f.d, iF);
                    this.d.a(this.o, this.e);
                }
                i = i13;
                if (i == 178 && parsableByteArray.a[iB + 2] == 1) {
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
        NalUnitTargetBuffer nalUnitTargetBuffer3 = this.f;
        if (nalUnitTargetBuffer3 != null) {
            nalUnitTargetBuffer3.a(bArr, i10, i11);
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void c() {
        NalUnitUtil.a(this.g);
        a aVar = this.h;
        aVar.f1268b = false;
        aVar.c = 0;
        aVar.d = 0;
        NalUnitTargetBuffer nalUnitTargetBuffer = this.f;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.c();
        }
        this.i = 0L;
        this.j = false;
        this.m = -9223372036854775807L;
        this.o = -9223372036854775807L;
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.a();
        this.f1267b = dVar.b();
        this.c = extractorOutput.p(dVar.c(), 2);
        UserDataReader userDataReader = this.d;
        if (userDataReader != null) {
            userDataReader.b(extractorOutput, dVar);
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void f(long j, int i) {
        this.m = j;
    }
}
