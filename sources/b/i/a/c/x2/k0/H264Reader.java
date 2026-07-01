package b.i.a.c.x2.k0;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.f3.CodecSpecificDataUtil;
import b.i.a.c.f3.NalUnitUtil;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.ParsableNalUnitBitArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.k0.TsPayloadReader;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.r, reason: use source file name */
/* JADX INFO: compiled from: H264Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class H264Reader implements ElementaryStreamReader {
    public final SeiReader a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1272b;
    public final boolean c;
    public long g;
    public String i;
    public TrackOutput2 j;
    public b k;
    public boolean l;
    public boolean n;
    public final boolean[] h = new boolean[3];
    public final NalUnitTargetBuffer d = new NalUnitTargetBuffer(7, 128);
    public final NalUnitTargetBuffer e = new NalUnitTargetBuffer(8, 128);
    public final NalUnitTargetBuffer f = new NalUnitTargetBuffer(6, 128);
    public long m = -9223372036854775807L;
    public final ParsableByteArray o = new ParsableByteArray();

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.r$b */
    /* JADX INFO: compiled from: H264Reader.java */
    public static final class b {
        public final TrackOutput2 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f1273b;
        public final boolean c;
        public final ParsableNalUnitBitArray f;
        public byte[] g;
        public int h;
        public int i;
        public long j;
        public long l;
        public long p;
        public long q;
        public boolean r;
        public final SparseArray<NalUnitUtil.c> d = new SparseArray<>();
        public final SparseArray<NalUnitUtil.b> e = new SparseArray<>();
        public a m = new a(null);
        public a n = new a(null);
        public boolean k = false;
        public boolean o = false;

        /* JADX INFO: renamed from: b.i.a.c.x2.k0.r$b$a */
        /* JADX INFO: compiled from: H264Reader.java */
        public static final class a {
            public boolean a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f1274b;

            @Nullable
            public NalUnitUtil.c c;
            public int d;
            public int e;
            public int f;
            public int g;
            public boolean h;
            public boolean i;
            public boolean j;
            public boolean k;
            public int l;
            public int m;
            public int n;
            public int o;
            public int p;

            public a(a aVar) {
            }
        }

        public b(TrackOutput2 trackOutput2, boolean z2, boolean z3) {
            this.a = trackOutput2;
            this.f1273b = z2;
            this.c = z3;
            byte[] bArr = new byte[128];
            this.g = bArr;
            this.f = new ParsableNalUnitBitArray(bArr, 0, 0);
            a aVar = this.n;
            aVar.f1274b = false;
            aVar.a = false;
        }
    }

    public H264Reader(SeiReader seiReader, boolean z2, boolean z3) {
        this.a = seiReader;
        this.f1272b = z2;
        this.c = z3;
    }

    /* JADX WARN: Code duplicated, block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x0126  */
    /* JADX WARN: Code duplicated, block: B:56:0x0128  */
    /* JADX WARN: Code duplicated, block: B:58:0x012b  */
    /* JADX WARN: Code duplicated, block: B:61:0x0135  */
    /* JADX WARN: Code duplicated, block: B:62:0x013c  */
    /* JADX WARN: Code duplicated, block: B:65:0x0141  */
    /* JADX WARN: Code duplicated, block: B:68:0x014d  */
    /* JADX WARN: Code duplicated, block: B:75:0x016c  */
    /* JADX WARN: Code duplicated, block: B:77:0x0171  */
    /* JADX WARN: Code duplicated, block: B:90:0x01a0  */
    @RequiresNonNull({"sampleReader"})
    public final void a(byte[] bArr, int i, int i2) {
        boolean zD;
        boolean zD2;
        boolean z2;
        boolean z3;
        int iF;
        int i3;
        int iG;
        int i4;
        int iE;
        int iG2;
        int i5;
        int iG3;
        if (!this.l || this.k.c) {
            this.d.a(bArr, i, i2);
            this.e.a(bArr, i, i2);
        }
        this.f.a(bArr, i, i2);
        b bVar = this.k;
        if (bVar.k) {
            int i6 = i2 - i;
            byte[] bArr2 = bVar.g;
            int length = bArr2.length;
            int i7 = bVar.h + i6;
            if (length < i7) {
                bVar.g = Arrays.copyOf(bArr2, i7 * 2);
            }
            System.arraycopy(bArr, i, bVar.g, bVar.h, i6);
            int i8 = bVar.h + i6;
            bVar.h = i8;
            ParsableNalUnitBitArray parsableNalUnitBitArray = bVar.f;
            parsableNalUnitBitArray.a = bVar.g;
            parsableNalUnitBitArray.c = 0;
            parsableNalUnitBitArray.f985b = i8;
            parsableNalUnitBitArray.d = 0;
            parsableNalUnitBitArray.a();
            if (bVar.f.b(8)) {
                bVar.f.i();
                int iE2 = bVar.f.e(2);
                bVar.f.j(5);
                if (bVar.f.c()) {
                    bVar.f.f();
                    if (bVar.f.c()) {
                        int iF2 = bVar.f.f();
                        if (!bVar.c) {
                            bVar.k = false;
                            b.a aVar = bVar.n;
                            aVar.e = iF2;
                            aVar.f1274b = true;
                            return;
                        }
                        if (bVar.f.c()) {
                            int iF3 = bVar.f.f();
                            if (bVar.e.indexOfKey(iF3) < 0) {
                                bVar.k = false;
                                return;
                            }
                            NalUnitUtil.b bVar2 = bVar.e.get(iF3);
                            NalUnitUtil.c cVar = bVar.d.get(bVar2.f980b);
                            if (cVar.h) {
                                if (!bVar.f.b(2)) {
                                    return;
                                } else {
                                    bVar.f.j(2);
                                }
                            }
                            if (bVar.f.b(cVar.j)) {
                                int iE3 = bVar.f.e(cVar.j);
                                if (!cVar.i) {
                                    if (bVar.f.b(1)) {
                                        zD = bVar.f.d();
                                        if (zD) {
                                            if (!bVar.f.b(1)) {
                                                return;
                                            }
                                            zD2 = bVar.f.d();
                                            z2 = true;
                                        }
                                        if (bVar.i == 5) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        if (z3) {
                                            iF = 0;
                                        } else if (!bVar.f.c()) {
                                            return;
                                        } else {
                                            iF = bVar.f.f();
                                        }
                                        i3 = cVar.k;
                                        if (i3 != 0) {
                                            if (i3 == 1 || cVar.m) {
                                                iG = 0;
                                            } else {
                                                if (!bVar.f.c()) {
                                                    return;
                                                }
                                                iG = bVar.f.g();
                                                if (bVar2.c && !zD) {
                                                    if (!bVar.f.c()) {
                                                        return;
                                                    }
                                                    iG2 = bVar.f.g();
                                                    i5 = 0;
                                                    i4 = iG;
                                                    iE = 0;
                                                }
                                            }
                                            i4 = iG;
                                            iE = 0;
                                            iG2 = 0;
                                            i5 = 0;
                                        } else {
                                            if (!bVar.f.b(cVar.l)) {
                                                return;
                                            }
                                            iE = bVar.f.e(cVar.l);
                                            if (bVar2.c || zD) {
                                                iG3 = 0;
                                            } else if (!bVar.f.c()) {
                                                return;
                                            } else {
                                                iG3 = bVar.f.g();
                                            }
                                            i5 = iG3;
                                            iG2 = 0;
                                            i4 = 0;
                                        }
                                        b.a aVar2 = bVar.n;
                                        aVar2.c = cVar;
                                        aVar2.d = iE2;
                                        aVar2.e = iF2;
                                        aVar2.f = iE3;
                                        aVar2.g = iF3;
                                        aVar2.h = zD;
                                        aVar2.i = z2;
                                        aVar2.j = zD2;
                                        aVar2.k = z3;
                                        aVar2.l = iF;
                                        aVar2.m = iE;
                                        aVar2.n = i5;
                                        aVar2.o = i4;
                                        aVar2.p = iG2;
                                        aVar2.a = true;
                                        aVar2.f1274b = true;
                                        bVar.k = false;
                                    }
                                    return;
                                }
                                zD = false;
                                zD2 = false;
                                z2 = false;
                                if (bVar.i == 5) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    iF = 0;
                                } else if (!bVar.f.c()) {
                                    return;
                                } else {
                                    iF = bVar.f.f();
                                }
                                i3 = cVar.k;
                                if (i3 != 0) {
                                    if (!bVar.f.b(cVar.l)) {
                                        return;
                                    }
                                    iE = bVar.f.e(cVar.l);
                                    if (bVar2.c) {
                                        iG3 = 0;
                                    } else {
                                        iG3 = 0;
                                    }
                                    i5 = iG3;
                                    iG2 = 0;
                                    i4 = 0;
                                } else if (i3 == 1) {
                                    iG = 0;
                                    i4 = iG;
                                    iE = 0;
                                    iG2 = 0;
                                    i5 = 0;
                                } else {
                                    iG = 0;
                                    i4 = iG;
                                    iE = 0;
                                    iG2 = 0;
                                    i5 = 0;
                                }
                                b.a aVar3 = bVar.n;
                                aVar3.c = cVar;
                                aVar3.d = iE2;
                                aVar3.e = iF2;
                                aVar3.f = iE3;
                                aVar3.g = iF3;
                                aVar3.h = zD;
                                aVar3.i = z2;
                                aVar3.j = zD2;
                                aVar3.k = z3;
                                aVar3.l = iF;
                                aVar3.m = iE;
                                aVar3.n = i5;
                                aVar3.o = i4;
                                aVar3.p = iG2;
                                aVar3.a = true;
                                aVar3.f1274b = true;
                                bVar.k = false;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:131:0x0292  */
    /* JADX WARN: Code duplicated, block: B:19:0x0055  */
    /* JADX WARN: Code duplicated, block: B:84:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:87:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:93:0x020c  */
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
        byte[] bArr;
        long j;
        int i2;
        long j2;
        int i3;
        int i4;
        boolean z2;
        int i5;
        int i6;
        int i7;
        boolean z3;
        AnimatableValueParser.H(this.j);
        int i8 = Util2.a;
        int i9 = parsableByteArray.f984b;
        int i10 = parsableByteArray.c;
        byte[] bArr2 = parsableByteArray.a;
        this.g += (long) parsableByteArray.a();
        this.j.c(parsableByteArray, parsableByteArray.a());
        while (true) {
            int iB = NalUnitUtil.b(bArr2, i9, i10, this.h);
            if (iB == i10) {
                a(bArr2, i9, i10);
                return;
            }
            int i11 = iB + 3;
            int i12 = bArr2[i11] & 31;
            int i13 = iB - i9;
            if (i13 > 0) {
                a(bArr2, i9, iB);
            }
            int i14 = i10 - iB;
            long j3 = this.g - ((long) i14);
            int i15 = i13 < 0 ? -i13 : 0;
            long j4 = this.m;
            if (!this.l || this.k.c) {
                this.d.b(i15);
                this.e.b(i15);
                if (this.l) {
                    i = i10;
                    bArr = bArr2;
                    NalUnitTargetBuffer nalUnitTargetBuffer = this.d;
                    if (nalUnitTargetBuffer.c) {
                        NalUnitUtil.c cVarE = NalUnitUtil.e(nalUnitTargetBuffer.d, 3, nalUnitTargetBuffer.e);
                        this.k.d.append(cVarE.d, cVarE);
                        this.d.c();
                    } else {
                        NalUnitTargetBuffer nalUnitTargetBuffer2 = this.e;
                        if (nalUnitTargetBuffer2.c) {
                            NalUnitUtil.b bVarD = NalUnitUtil.d(nalUnitTargetBuffer2.d, 3, nalUnitTargetBuffer2.e);
                            this.k.e.append(bVarD.a, bVarD);
                            this.e.c();
                        }
                    }
                } else if (this.d.c && this.e.c) {
                    ArrayList arrayList = new ArrayList();
                    NalUnitTargetBuffer nalUnitTargetBuffer3 = this.d;
                    arrayList.add(Arrays.copyOf(nalUnitTargetBuffer3.d, nalUnitTargetBuffer3.e));
                    NalUnitTargetBuffer nalUnitTargetBuffer4 = this.e;
                    arrayList.add(Arrays.copyOf(nalUnitTargetBuffer4.d, nalUnitTargetBuffer4.e));
                    NalUnitTargetBuffer nalUnitTargetBuffer5 = this.d;
                    NalUnitUtil.c cVarE2 = NalUnitUtil.e(nalUnitTargetBuffer5.d, 3, nalUnitTargetBuffer5.e);
                    NalUnitTargetBuffer nalUnitTargetBuffer6 = this.e;
                    NalUnitUtil.b bVarD2 = NalUnitUtil.d(nalUnitTargetBuffer6.d, 3, nalUnitTargetBuffer6.e);
                    i = i10;
                    String strA = CodecSpecificDataUtil.a(cVarE2.a, cVarE2.f981b, cVarE2.c);
                    TrackOutput2 trackOutput2 = this.j;
                    Format2.b bVar = new Format2.b();
                    bArr = bArr2;
                    bVar.a = this.i;
                    bVar.k = "video/avc";
                    bVar.h = strA;
                    bVar.p = cVarE2.e;
                    bVar.q = cVarE2.f;
                    bVar.t = cVarE2.g;
                    bVar.m = arrayList;
                    trackOutput2.e(bVar.a());
                    this.l = true;
                    this.k.d.append(cVarE2.d, cVarE2);
                    this.k.e.append(bVarD2.a, bVarD2);
                    this.d.c();
                    this.e.c();
                } else {
                    i = i10;
                    bArr = bArr2;
                }
            } else {
                i = i10;
                bArr = bArr2;
            }
            if (this.f.b(i15)) {
                NalUnitTargetBuffer nalUnitTargetBuffer7 = this.f;
                this.o.C(this.f.d, NalUnitUtil.f(nalUnitTargetBuffer7.d, nalUnitTargetBuffer7.e));
                this.o.E(4);
                AnimatableValueParser.J(j4, this.o, this.a.f1246b);
            }
            b bVar2 = this.k;
            boolean z4 = this.l;
            boolean z5 = this.n;
            if (bVar2.i == 9) {
                if (z4 && bVar2.o) {
                    j = bVar2.j;
                    i2 = i14 + ((int) (j3 - j));
                    j2 = bVar2.q;
                    if (j2 != -9223372036854775807L) {
                        bVar2.a.d(j2, bVar2.r ? 1 : 0, (int) (j - bVar2.p), i2, null);
                    }
                }
                bVar2.p = bVar2.j;
                bVar2.q = bVar2.l;
                bVar2.r = false;
                bVar2.o = true;
            } else if (bVar2.c) {
                b.a aVar = bVar2.n;
                b.a aVar2 = bVar2.m;
                if (aVar.a) {
                    if (aVar2.a) {
                        NalUnitUtil.c cVar = aVar.c;
                        AnimatableValueParser.H(cVar);
                        NalUnitUtil.c cVar2 = aVar2.c;
                        AnimatableValueParser.H(cVar2);
                        if (aVar.f == aVar2.f && aVar.g == aVar2.g && aVar.h == aVar2.h && ((!aVar.i || !aVar2.i || aVar.j == aVar2.j) && (((i5 = aVar.d) == (i6 = aVar2.d) || (i5 != 0 && i6 != 0)) && (((i7 = cVar.k) != 0 || cVar2.k != 0 || (aVar.m == aVar2.m && aVar.n == aVar2.n)) && ((i7 != 1 || cVar2.k != 1 || (aVar.o == aVar2.o && aVar.p == aVar2.p)) && (z3 = aVar.k) == aVar2.k && (!z3 || aVar.l == aVar2.l)))))) {
                            z2 = false;
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    if (z4) {
                        j = bVar2.j;
                        i2 = i14 + ((int) (j3 - j));
                        j2 = bVar2.q;
                        if (j2 != -9223372036854775807L) {
                            bVar2.a.d(j2, bVar2.r ? 1 : 0, (int) (j - bVar2.p), i2, null);
                        }
                    }
                    bVar2.p = bVar2.j;
                    bVar2.q = bVar2.l;
                    bVar2.r = false;
                    bVar2.o = true;
                }
            }
            if (bVar2.f1273b) {
                b.a aVar3 = bVar2.n;
                z5 = aVar3.f1274b && ((i4 = aVar3.e) == 7 || i4 == 2);
            }
            boolean z6 = bVar2.r;
            int i16 = bVar2.i;
            boolean z7 = z6 | (i16 == 5 || (z5 && i16 == 1));
            bVar2.r = z7;
            if (z7) {
                this.n = false;
            }
            long j5 = this.m;
            if (!this.l || this.k.c) {
                this.d.d(i12);
                this.e.d(i12);
            }
            this.f.d(i12);
            b bVar3 = this.k;
            bVar3.i = i12;
            bVar3.l = j5;
            bVar3.j = j3;
            if (bVar3.f1273b) {
                i3 = 1;
                if (i12 == 1) {
                    b.a aVar4 = bVar3.m;
                    bVar3.m = bVar3.n;
                    bVar3.n = aVar4;
                    aVar4.f1274b = false;
                    aVar4.a = false;
                    bVar3.h = 0;
                    bVar3.k = true;
                }
                i9 = i11;
                i10 = i;
                bArr2 = bArr;
            } else {
                i3 = 1;
            }
            if (bVar3.c && (i12 == 5 || i12 == i3 || i12 == 2)) {
                b.a aVar5 = bVar3.m;
                bVar3.m = bVar3.n;
                bVar3.n = aVar5;
                aVar5.f1274b = false;
                aVar5.a = false;
                bVar3.h = 0;
                bVar3.k = true;
            }
            i9 = i11;
            i10 = i;
            bArr2 = bArr;
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void c() {
        this.g = 0L;
        this.n = false;
        this.m = -9223372036854775807L;
        NalUnitUtil.a(this.h);
        this.d.c();
        this.e.c();
        this.f.c();
        b bVar = this.k;
        if (bVar != null) {
            bVar.k = false;
            bVar.o = false;
            b.a aVar = bVar.n;
            aVar.f1274b = false;
            aVar.a = false;
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.a();
        this.i = dVar.b();
        TrackOutput2 trackOutput2P = extractorOutput.p(dVar.c(), 2);
        this.j = trackOutput2P;
        this.k = new b(trackOutput2P, this.f1272b, this.c);
        this.a.a(extractorOutput, dVar);
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
        this.n |= (i & 2) != 0;
    }
}
