package b.i.a.c.x2.k0;

import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.f3.CodecSpecificDataUtil;
import b.i.a.c.f3.NalUnitUtil;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.ParsableNalUnitBitArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.k0.TsPayloadReader;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.s, reason: use source file name */
/* JADX INFO: compiled from: H265Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class H265Reader implements ElementaryStreamReader {
    public final SeiReader a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1275b;
    public TrackOutput2 c;
    public a d;
    public boolean e;
    public long l;
    public final boolean[] f = new boolean[3];
    public final NalUnitTargetBuffer g = new NalUnitTargetBuffer(32, 128);
    public final NalUnitTargetBuffer h = new NalUnitTargetBuffer(33, 128);
    public final NalUnitTargetBuffer i = new NalUnitTargetBuffer(34, 128);
    public final NalUnitTargetBuffer j = new NalUnitTargetBuffer(39, 128);
    public final NalUnitTargetBuffer k = new NalUnitTargetBuffer(40, 128);
    public long m = -9223372036854775807L;
    public final ParsableByteArray n = new ParsableByteArray();

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.s$a */
    /* JADX INFO: compiled from: H265Reader.java */
    public static final class a {
        public final TrackOutput2 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f1276b;
        public boolean c;
        public int d;
        public long e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public long k;
        public long l;
        public boolean m;

        public a(TrackOutput2 trackOutput2) {
            this.a = trackOutput2;
        }

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
        public final void a(int i) {
            long j = this.l;
            if (j == -9223372036854775807L) {
                return;
            }
            boolean z2 = this.m;
            this.a.d(j, z2 ? 1 : 0, (int) (this.f1276b - this.k), i, null);
        }
    }

    public H265Reader(SeiReader seiReader) {
        this.a = seiReader;
    }

    @RequiresNonNull({"sampleReader"})
    public final void a(byte[] bArr, int i, int i2) {
        a aVar = this.d;
        if (aVar.f) {
            int i3 = aVar.d;
            int i4 = (i + 2) - i3;
            if (i4 < i2) {
                aVar.g = (bArr[i4] & 128) != 0;
                aVar.f = false;
            } else {
                aVar.d = (i2 - i) + i3;
            }
        }
        if (!this.e) {
            this.g.a(bArr, i, i2);
            this.h.a(bArr, i, i2);
            this.i.a(bArr, i, i2);
        }
        this.j.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:166:0x0347  */
    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void b(ParsableByteArray parsableByteArray) {
        long j;
        long j2;
        AnimatableValueParser.H(this.c);
        int i = Util2.a;
        while (parsableByteArray.a() > 0) {
            int i2 = parsableByteArray.f984b;
            int i3 = parsableByteArray.c;
            byte[] bArr = parsableByteArray.a;
            this.l += (long) parsableByteArray.a();
            this.c.c(parsableByteArray, parsableByteArray.a());
            while (i2 < i3) {
                int iB = NalUnitUtil.b(bArr, i2, i3, this.f);
                if (iB == i3) {
                    a(bArr, i2, i3);
                    return;
                }
                int i4 = iB + 3;
                int i5 = (bArr[i4] & 126) >> 1;
                int i6 = iB - i2;
                if (i6 > 0) {
                    a(bArr, i2, iB);
                }
                int i7 = i3 - iB;
                long j3 = this.l - ((long) i7);
                int i8 = i6 < 0 ? -i6 : 0;
                long j4 = this.m;
                a aVar = this.d;
                boolean z2 = this.e;
                if (aVar.j && aVar.g) {
                    aVar.m = aVar.c;
                    aVar.j = false;
                } else if (aVar.h || aVar.g) {
                    if (z2 && aVar.i) {
                        aVar.a(((int) (j3 - aVar.f1276b)) + i7);
                    }
                    aVar.k = aVar.f1276b;
                    aVar.l = aVar.e;
                    aVar.m = aVar.c;
                    aVar.i = true;
                }
                if (this.e) {
                    j3 = j3;
                    j = j4;
                } else {
                    this.g.b(i8);
                    this.h.b(i8);
                    this.i.b(i8);
                    NalUnitTargetBuffer nalUnitTargetBuffer = this.g;
                    if (nalUnitTargetBuffer.c) {
                        NalUnitTargetBuffer nalUnitTargetBuffer2 = this.h;
                        if (nalUnitTargetBuffer2.c) {
                            NalUnitTargetBuffer nalUnitTargetBuffer3 = this.i;
                            if (nalUnitTargetBuffer3.c) {
                                TrackOutput2 trackOutput2 = this.c;
                                String str = this.f1275b;
                                int i9 = nalUnitTargetBuffer.e;
                                byte[] bArr2 = new byte[nalUnitTargetBuffer2.e + i9 + nalUnitTargetBuffer3.e];
                                System.arraycopy(nalUnitTargetBuffer.d, 0, bArr2, 0, i9);
                                System.arraycopy(nalUnitTargetBuffer2.d, 0, bArr2, nalUnitTargetBuffer.e, nalUnitTargetBuffer2.e);
                                System.arraycopy(nalUnitTargetBuffer3.d, 0, bArr2, nalUnitTargetBuffer.e + nalUnitTargetBuffer2.e, nalUnitTargetBuffer3.e);
                                ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(nalUnitTargetBuffer2.d, 0, nalUnitTargetBuffer2.e);
                                parsableNalUnitBitArray.j(44);
                                int iE = parsableNalUnitBitArray.e(3);
                                parsableNalUnitBitArray.i();
                                int iE2 = parsableNalUnitBitArray.e(2);
                                boolean zD = parsableNalUnitBitArray.d();
                                int iE3 = parsableNalUnitBitArray.e(5);
                                int i10 = 0;
                                int i11 = 0;
                                for (int i12 = 32; i10 < i12; i12 = 32) {
                                    if (parsableNalUnitBitArray.d()) {
                                        i11 |= 1 << i10;
                                    }
                                    i10++;
                                }
                                int[] iArr = new int[6];
                                for (int i13 = 0; i13 < 6; i13++) {
                                    iArr[i13] = parsableNalUnitBitArray.e(8);
                                }
                                int iE4 = parsableNalUnitBitArray.e(8);
                                int i14 = 0;
                                for (int i15 = 0; i15 < iE; i15++) {
                                    if (parsableNalUnitBitArray.d()) {
                                        i14 += 89;
                                    }
                                    if (parsableNalUnitBitArray.d()) {
                                        i14 += 8;
                                    }
                                }
                                parsableNalUnitBitArray.j(i14);
                                if (iE > 0) {
                                    parsableNalUnitBitArray.j((8 - iE) * 2);
                                }
                                parsableNalUnitBitArray.f();
                                int iF = parsableNalUnitBitArray.f();
                                if (iF == 3) {
                                    parsableNalUnitBitArray.i();
                                }
                                int iF2 = parsableNalUnitBitArray.f();
                                int iF3 = parsableNalUnitBitArray.f();
                                if (parsableNalUnitBitArray.d()) {
                                    int iF4 = parsableNalUnitBitArray.f();
                                    int iF5 = parsableNalUnitBitArray.f();
                                    int iF6 = parsableNalUnitBitArray.f();
                                    int iF7 = parsableNalUnitBitArray.f();
                                    iF2 -= (iF4 + iF5) * ((iF == 1 || iF == 2) ? 2 : 1);
                                    iF3 -= (iF6 + iF7) * (iF == 1 ? 2 : 1);
                                }
                                parsableNalUnitBitArray.f();
                                parsableNalUnitBitArray.f();
                                int iF8 = parsableNalUnitBitArray.f();
                                for (int i16 = parsableNalUnitBitArray.d() ? 0 : iE; i16 <= iE; i16++) {
                                    parsableNalUnitBitArray.f();
                                    parsableNalUnitBitArray.f();
                                    parsableNalUnitBitArray.f();
                                }
                                parsableNalUnitBitArray.f();
                                parsableNalUnitBitArray.f();
                                parsableNalUnitBitArray.f();
                                parsableNalUnitBitArray.f();
                                parsableNalUnitBitArray.f();
                                parsableNalUnitBitArray.f();
                                if (parsableNalUnitBitArray.d() && parsableNalUnitBitArray.d()) {
                                    int i17 = 0;
                                    for (int i18 = 4; i17 < i18; i18 = 4) {
                                        int i19 = 0;
                                        while (i19 < 6) {
                                            if (parsableNalUnitBitArray.d()) {
                                                int iMin = Math.min(64, 1 << ((i17 << 1) + 4));
                                                if (i17 > 1) {
                                                    parsableNalUnitBitArray.g();
                                                }
                                                for (int i20 = 0; i20 < iMin; i20++) {
                                                    parsableNalUnitBitArray.g();
                                                }
                                            } else {
                                                parsableNalUnitBitArray.f();
                                            }
                                            i19 += i17 == 3 ? 3 : 1;
                                            j4 = j4;
                                        }
                                        i17++;
                                    }
                                }
                                j = j4;
                                parsableNalUnitBitArray.j(2);
                                if (parsableNalUnitBitArray.d()) {
                                    parsableNalUnitBitArray.j(8);
                                    parsableNalUnitBitArray.f();
                                    parsableNalUnitBitArray.f();
                                    parsableNalUnitBitArray.i();
                                }
                                int i21 = 0;
                                boolean zD2 = false;
                                int i22 = 0;
                                for (int iF9 = parsableNalUnitBitArray.f(); i21 < iF9; iF9 = iF9) {
                                    if (i21 != 0) {
                                        zD2 = parsableNalUnitBitArray.d();
                                    }
                                    if (zD2) {
                                        parsableNalUnitBitArray.i();
                                        parsableNalUnitBitArray.f();
                                        for (int i23 = 0; i23 <= i22; i23++) {
                                            if (parsableNalUnitBitArray.d()) {
                                                parsableNalUnitBitArray.i();
                                            }
                                        }
                                    } else {
                                        int iF10 = parsableNalUnitBitArray.f();
                                        int iF11 = parsableNalUnitBitArray.f();
                                        int i24 = iF10 + iF11;
                                        for (int i25 = 0; i25 < iF10; i25++) {
                                            parsableNalUnitBitArray.f();
                                            parsableNalUnitBitArray.i();
                                        }
                                        for (int i26 = 0; i26 < iF11; i26++) {
                                            parsableNalUnitBitArray.f();
                                            parsableNalUnitBitArray.i();
                                        }
                                        i22 = i24;
                                    }
                                    i21++;
                                }
                                if (parsableNalUnitBitArray.d()) {
                                    for (int i27 = 0; i27 < parsableNalUnitBitArray.f(); i27++) {
                                        parsableNalUnitBitArray.j(iF8 + 4 + 1);
                                    }
                                }
                                parsableNalUnitBitArray.j(2);
                                float f = 1.0f;
                                if (parsableNalUnitBitArray.d()) {
                                    if (parsableNalUnitBitArray.d()) {
                                        int iE5 = parsableNalUnitBitArray.e(8);
                                        if (iE5 == 255) {
                                            int iE6 = parsableNalUnitBitArray.e(16);
                                            int iE7 = parsableNalUnitBitArray.e(16);
                                            if (iE6 != 0 && iE7 != 0) {
                                                f = iE6 / iE7;
                                            }
                                        } else {
                                            float[] fArr = NalUnitUtil.f978b;
                                            if (iE5 < fArr.length) {
                                                f = fArr[iE5];
                                            } else {
                                                outline.g0(46, "Unexpected aspect_ratio_idc value: ", iE5, "H265Reader");
                                            }
                                        }
                                    }
                                    if (parsableNalUnitBitArray.d()) {
                                        parsableNalUnitBitArray.i();
                                    }
                                    if (parsableNalUnitBitArray.d()) {
                                        parsableNalUnitBitArray.j(4);
                                        if (parsableNalUnitBitArray.d()) {
                                            parsableNalUnitBitArray.j(24);
                                        }
                                    }
                                    if (parsableNalUnitBitArray.d()) {
                                        parsableNalUnitBitArray.f();
                                        parsableNalUnitBitArray.f();
                                    }
                                    parsableNalUnitBitArray.i();
                                    if (parsableNalUnitBitArray.d()) {
                                        iF3 *= 2;
                                    }
                                }
                                String strB = CodecSpecificDataUtil.b(iE2, zD, iE3, i11, iArr, iE4);
                                Format2.b bVar = new Format2.b();
                                bVar.a = str;
                                bVar.k = "video/hevc";
                                bVar.h = strB;
                                bVar.p = iF2;
                                bVar.q = iF3;
                                bVar.t = f;
                                bVar.m = Collections.singletonList(bArr2);
                                trackOutput2.e(bVar.a());
                                this.e = true;
                            } else {
                                j3 = j3;
                                j = j4;
                            }
                        } else {
                            j3 = j3;
                            j = j4;
                        }
                    } else {
                        j3 = j3;
                        j = j4;
                    }
                }
                if (this.j.b(i8)) {
                    NalUnitTargetBuffer nalUnitTargetBuffer4 = this.j;
                    this.n.C(this.j.d, NalUnitUtil.f(nalUnitTargetBuffer4.d, nalUnitTargetBuffer4.e));
                    this.n.F(5);
                    j2 = j;
                    AnimatableValueParser.J(j2, this.n, this.a.f1246b);
                } else {
                    j2 = j;
                }
                if (this.k.b(i8)) {
                    NalUnitTargetBuffer nalUnitTargetBuffer5 = this.k;
                    this.n.C(this.k.d, NalUnitUtil.f(nalUnitTargetBuffer5.d, nalUnitTargetBuffer5.e));
                    this.n.F(5);
                    AnimatableValueParser.J(j2, this.n, this.a.f1246b);
                }
                long j5 = this.m;
                a aVar2 = this.d;
                boolean z3 = this.e;
                aVar2.g = false;
                aVar2.h = false;
                aVar2.e = j5;
                aVar2.d = 0;
                aVar2.f1276b = j3;
                if (!(i5 < 32 || i5 == 40)) {
                    if (aVar2.i && !aVar2.j) {
                        if (z3) {
                            aVar2.a(i7);
                        }
                        aVar2.i = false;
                    }
                    if ((32 <= i5 && i5 <= 35) || i5 == 39) {
                        aVar2.h = !aVar2.j;
                        aVar2.j = true;
                    }
                }
                boolean z4 = i5 >= 16 && i5 <= 21;
                aVar2.c = z4;
                aVar2.f = z4 || i5 <= 9;
                if (!this.e) {
                    this.g.d(i5);
                    this.h.d(i5);
                    this.i.d(i5);
                }
                this.j.d(i5);
                this.k.d(i5);
                i3 = i3;
                bArr = bArr;
                i2 = i4;
            }
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void c() {
        this.l = 0L;
        this.m = -9223372036854775807L;
        NalUnitUtil.a(this.f);
        this.g.c();
        this.h.c();
        this.i.c();
        this.j.c();
        this.k.c();
        a aVar = this.d;
        if (aVar != null) {
            aVar.f = false;
            aVar.g = false;
            aVar.h = false;
            aVar.i = false;
            aVar.j = false;
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.a();
        this.f1275b = dVar.b();
        TrackOutput2 trackOutput2P = extractorOutput.p(dVar.c(), 2);
        this.c = trackOutput2P;
        this.d = new a(trackOutput2P);
        this.a.a(extractorOutput, dVar);
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
    }
}
