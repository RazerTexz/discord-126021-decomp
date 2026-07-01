package b.i.a.c.x2.k0;

import android.util.Log;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.f3.NalUnitUtil;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.k0.TsPayloadReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.q, reason: use source file name */
/* JADX INFO: compiled from: H263Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class H263Reader implements ElementaryStreamReader {
    public static final float[] a = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final UserDataReader f1269b;
    public b g;
    public long h;
    public String i;
    public TrackOutput2 j;
    public boolean k;
    public final boolean[] d = new boolean[4];
    public final a e = new a(128);
    public long l = -9223372036854775807L;

    @Nullable
    public final NalUnitTargetBuffer f = new NalUnitTargetBuffer(Opcodes.GETSTATIC, 128);

    @Nullable
    public final ParsableByteArray c = new ParsableByteArray();

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.q$a */
    /* JADX INFO: compiled from: H263Reader.java */
    public static final class a {
        public static final byte[] a = {0, 0, 1};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1270b;
        public int c;
        public int d;
        public int e;
        public byte[] f;

        public a(int i) {
            this.f = new byte[i];
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.f1270b) {
                int i3 = i2 - i;
                byte[] bArr2 = this.f;
                int length = bArr2.length;
                int i4 = this.d;
                if (length < i4 + i3) {
                    this.f = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.f, this.d, i3);
                this.d += i3;
            }
        }

        public void b() {
            this.f1270b = false;
            this.d = 0;
            this.c = 0;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.q$b */
    /* JADX INFO: compiled from: H263Reader.java */
    public static final class b {
        public final TrackOutput2 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1271b;
        public boolean c;
        public boolean d;
        public int e;
        public int f;
        public long g;
        public long h;

        public b(TrackOutput2 trackOutput2) {
            this.a = trackOutput2;
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.c) {
                int i3 = this.f;
                int i4 = (i + 1) - i3;
                if (i4 >= i2) {
                    this.f = (i2 - i) + i3;
                } else {
                    this.d = ((bArr[i4] & 192) >> 6) == 0;
                    this.c = false;
                }
            }
        }
    }

    public H263Reader(@Nullable UserDataReader userDataReader) {
        this.f1269b = userDataReader;
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
    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void b(ParsableByteArray parsableByteArray) {
        int i;
        int i2;
        boolean z2;
        ParsableBitArray parsableBitArray;
        int iG;
        float[] fArr;
        float f;
        int iG2;
        int i3;
        int i4;
        int iG3;
        int iG4;
        AnimatableValueParser.H(this.g);
        AnimatableValueParser.H(this.j);
        int i5 = parsableByteArray.f984b;
        int i6 = parsableByteArray.c;
        byte[] bArr = parsableByteArray.a;
        this.h += (long) parsableByteArray.a();
        this.j.c(parsableByteArray, parsableByteArray.a());
        while (true) {
            int iB = NalUnitUtil.b(bArr, i5, i6, this.d);
            if (iB == i6) {
                if (!this.k) {
                    this.e.a(bArr, i5, i6);
                }
                this.g.a(bArr, i5, i6);
                NalUnitTargetBuffer nalUnitTargetBuffer = this.f;
                if (nalUnitTargetBuffer != null) {
                    nalUnitTargetBuffer.a(bArr, i5, i6);
                    return;
                }
                return;
            }
            int i7 = iB + 3;
            int i8 = parsableByteArray.a[i7] & 255;
            int i9 = iB - i5;
            if (this.k) {
                i = i6;
            } else {
                if (i9 > 0) {
                    this.e.a(bArr, i5, iB);
                }
                int i10 = i9 < 0 ? -i9 : 0;
                a aVar = this.e;
                int i11 = aVar.c;
                if (i11 != 0) {
                    if (i11 != 1) {
                        if (i11 != 2) {
                            if (i11 != 3) {
                                if (i11 != 4) {
                                    throw new IllegalStateException();
                                }
                                if (i8 == 179 || i8 == 181) {
                                    aVar.d -= i10;
                                    aVar.f1270b = false;
                                    z2 = true;
                                }
                                if (z2) {
                                    TrackOutput2 trackOutput2 = this.j;
                                    a aVar2 = this.e;
                                    int i12 = aVar2.e;
                                    String str = this.i;
                                    Objects.requireNonNull(str);
                                    byte[] bArrCopyOf = Arrays.copyOf(aVar2.f, aVar2.d);
                                    parsableBitArray = new ParsableBitArray(bArrCopyOf);
                                    parsableBitArray.n(i12);
                                    parsableBitArray.n(4);
                                    parsableBitArray.l();
                                    parsableBitArray.m(8);
                                    if (parsableBitArray.f()) {
                                        parsableBitArray.m(4);
                                        parsableBitArray.m(3);
                                    }
                                    iG = parsableBitArray.g(4);
                                    if (iG == 15) {
                                        iG3 = parsableBitArray.g(8);
                                        iG4 = parsableBitArray.g(8);
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
                                    if (parsableBitArray.f()) {
                                        parsableBitArray.m(2);
                                        parsableBitArray.m(1);
                                        if (parsableBitArray.f()) {
                                            parsableBitArray.m(15);
                                            parsableBitArray.l();
                                            parsableBitArray.m(15);
                                            parsableBitArray.l();
                                            parsableBitArray.m(15);
                                            parsableBitArray.l();
                                            parsableBitArray.m(3);
                                            parsableBitArray.m(11);
                                            parsableBitArray.l();
                                            parsableBitArray.m(15);
                                            parsableBitArray.l();
                                        }
                                    }
                                    if (parsableBitArray.g(2) != 0) {
                                        Log.w("H263Reader", "Unhandled video object layer shape");
                                    }
                                    parsableBitArray.l();
                                    iG2 = parsableBitArray.g(16);
                                    parsableBitArray.l();
                                    if (parsableBitArray.f()) {
                                        if (iG2 == 0) {
                                            Log.w("H263Reader", "Invalid vop_increment_time_resolution");
                                        } else {
                                            i4 = 0;
                                            for (i3 = iG2 - 1; i3 > 0; i3 >>= 1) {
                                                i4++;
                                            }
                                            parsableBitArray.m(i4);
                                        }
                                    }
                                    parsableBitArray.l();
                                    int iG5 = parsableBitArray.g(13);
                                    parsableBitArray.l();
                                    int iG6 = parsableBitArray.g(13);
                                    parsableBitArray.l();
                                    parsableBitArray.l();
                                    Format2.b bVar = new Format2.b();
                                    bVar.a = str;
                                    bVar.k = "video/mp4v-es";
                                    bVar.p = iG5;
                                    bVar.q = iG6;
                                    bVar.t = f;
                                    bVar.m = Collections.singletonList(bArrCopyOf);
                                    trackOutput2.e(bVar.a());
                                    this.k = true;
                                } else {
                                    i = i6;
                                }
                            } else if ((i8 & 240) != 32) {
                                Log.w("H263Reader", "Unexpected start code value");
                                aVar.b();
                            } else {
                                aVar.e = aVar.d;
                                aVar.c = 4;
                            }
                        } else if (i8 > 31) {
                            Log.w("H263Reader", "Unexpected start code value");
                            aVar.b();
                        } else {
                            aVar.c = 3;
                        }
                    } else if (i8 != 181) {
                        Log.w("H263Reader", "Unexpected start code value");
                        aVar.b();
                    } else {
                        aVar.c = 2;
                    }
                } else if (i8 == 176) {
                    aVar.c = 1;
                    aVar.f1270b = true;
                }
                byte[] bArr2 = a.a;
                aVar.a(bArr2, 0, bArr2.length);
                z2 = false;
                if (z2) {
                    TrackOutput2 trackOutput3 = this.j;
                    a aVar3 = this.e;
                    int i13 = aVar3.e;
                    String str2 = this.i;
                    Objects.requireNonNull(str2);
                    byte[] bArrCopyOf2 = Arrays.copyOf(aVar3.f, aVar3.d);
                    parsableBitArray = new ParsableBitArray(bArrCopyOf2);
                    parsableBitArray.n(i13);
                    parsableBitArray.n(4);
                    parsableBitArray.l();
                    parsableBitArray.m(8);
                    if (parsableBitArray.f()) {
                        parsableBitArray.m(4);
                        parsableBitArray.m(3);
                    }
                    iG = parsableBitArray.g(4);
                    if (iG == 15) {
                        iG3 = parsableBitArray.g(8);
                        iG4 = parsableBitArray.g(8);
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
                    if (parsableBitArray.f()) {
                        parsableBitArray.m(2);
                        parsableBitArray.m(1);
                        if (parsableBitArray.f()) {
                            parsableBitArray.m(15);
                            parsableBitArray.l();
                            parsableBitArray.m(15);
                            parsableBitArray.l();
                            parsableBitArray.m(15);
                            parsableBitArray.l();
                            parsableBitArray.m(3);
                            parsableBitArray.m(11);
                            parsableBitArray.l();
                            parsableBitArray.m(15);
                            parsableBitArray.l();
                        }
                    }
                    if (parsableBitArray.g(2) != 0) {
                        Log.w("H263Reader", "Unhandled video object layer shape");
                    }
                    parsableBitArray.l();
                    iG2 = parsableBitArray.g(16);
                    parsableBitArray.l();
                    if (parsableBitArray.f()) {
                        if (iG2 == 0) {
                            Log.w("H263Reader", "Invalid vop_increment_time_resolution");
                        } else {
                            i4 = 0;
                            while (i3 > 0) {
                                i4++;
                            }
                            parsableBitArray.m(i4);
                        }
                    }
                    parsableBitArray.l();
                    int iG7 = parsableBitArray.g(13);
                    parsableBitArray.l();
                    int iG8 = parsableBitArray.g(13);
                    parsableBitArray.l();
                    parsableBitArray.l();
                    Format2.b bVar2 = new Format2.b();
                    bVar2.a = str2;
                    bVar2.k = "video/mp4v-es";
                    bVar2.p = iG7;
                    bVar2.q = iG8;
                    bVar2.t = f;
                    bVar2.m = Collections.singletonList(bArrCopyOf2);
                    trackOutput3.e(bVar2.a());
                    this.k = true;
                } else {
                    i = i6;
                }
            }
            this.g.a(bArr, i5, iB);
            NalUnitTargetBuffer nalUnitTargetBuffer2 = this.f;
            if (nalUnitTargetBuffer2 != null) {
                if (i9 > 0) {
                    nalUnitTargetBuffer2.a(bArr, i5, iB);
                    i2 = 0;
                } else {
                    i2 = -i9;
                }
                if (this.f.b(i2)) {
                    NalUnitTargetBuffer nalUnitTargetBuffer3 = this.f;
                    int iF = NalUnitUtil.f(nalUnitTargetBuffer3.d, nalUnitTargetBuffer3.e);
                    ParsableByteArray parsableByteArray2 = this.c;
                    int i14 = Util2.a;
                    parsableByteArray2.C(this.f.d, iF);
                    this.f1269b.a(this.l, this.c);
                }
                if (i8 == 178) {
                    if (parsableByteArray.a[iB + 2] == 1) {
                        this.f.d(i8);
                    }
                }
            }
            int i15 = i - iB;
            long j = this.h - ((long) i15);
            b bVar3 = this.g;
            boolean z3 = this.k;
            if (bVar3.e == 182 && z3 && bVar3.f1271b) {
                long j2 = bVar3.h;
                if (j2 != -9223372036854775807L) {
                    bVar3.a.d(j2, bVar3.d ? 1 : 0, (int) (j - bVar3.g), i15, null);
                }
            }
            if (bVar3.e != 179) {
                bVar3.g = j;
            }
            b bVar4 = this.g;
            long j3 = this.l;
            bVar4.e = i8;
            bVar4.d = false;
            bVar4.f1271b = i8 == 182 || i8 == 179;
            bVar4.c = i8 == 182;
            bVar4.f = 0;
            bVar4.h = j3;
            i6 = i;
            i5 = i7;
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void c() {
        NalUnitUtil.a(this.d);
        this.e.b();
        b bVar = this.g;
        if (bVar != null) {
            bVar.f1271b = false;
            bVar.c = false;
            bVar.d = false;
            bVar.e = -1;
        }
        NalUnitTargetBuffer nalUnitTargetBuffer = this.f;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.c();
        }
        this.h = 0L;
        this.l = -9223372036854775807L;
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
        this.g = new b(trackOutput2P);
        UserDataReader userDataReader = this.f1269b;
        if (userDataReader != null) {
            userDataReader.b(extractorOutput, dVar);
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.l = j;
        }
    }
}
