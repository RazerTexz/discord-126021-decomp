package b.i.a.c.x2.k0;

import android.net.Uri;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.TimestampAdjuster;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.Extractor;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.ExtractorsFactory;
import b.i.a.c.x2.ExtractorsFactory2;
import b.i.a.c.x2.PositionHolder;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.k0.TsPayloadReader;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.h0, reason: use source file name */
/* JADX INFO: compiled from: TsExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TsExtractor implements Extractor {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1252b;
    public final List<TimestampAdjuster> c;
    public final ParsableByteArray d;
    public final SparseIntArray e;
    public final TsPayloadReader.c f;
    public final SparseArray<TsPayloadReader> g;
    public final SparseBooleanArray h;
    public final SparseBooleanArray i;
    public final TsDurationReader j;
    public TsBinarySearchSeeker k;
    public ExtractorOutput l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;

    @Nullable
    public TsPayloadReader q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1253s;

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.h0$a */
    /* JADX INFO: compiled from: TsExtractor.java */
    public class a implements SectionPayloadReader {
        public final ParsableBitArray a = new ParsableBitArray(new byte[4]);

        public a() {
        }

        @Override // b.i.a.c.x2.k0.SectionPayloadReader
        public void a(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        }

        @Override // b.i.a.c.x2.k0.SectionPayloadReader
        public void b(ParsableByteArray parsableByteArray) {
            if (parsableByteArray.t() == 0 && (parsableByteArray.t() & 128) != 0) {
                parsableByteArray.F(6);
                int iA = parsableByteArray.a() / 4;
                for (int i = 0; i < iA; i++) {
                    parsableByteArray.d(this.a, 4);
                    int iG = this.a.g(16);
                    this.a.m(3);
                    if (iG == 0) {
                        this.a.m(13);
                    } else {
                        int iG2 = this.a.g(13);
                        if (TsExtractor.this.g.get(iG2) == null) {
                            TsExtractor tsExtractor = TsExtractor.this;
                            tsExtractor.g.put(iG2, new SectionReader(tsExtractor.new b(iG2)));
                            TsExtractor.this.m++;
                        }
                    }
                }
                TsExtractor tsExtractor2 = TsExtractor.this;
                if (tsExtractor2.a != 2) {
                    tsExtractor2.g.remove(0);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.h0$b */
    /* JADX INFO: compiled from: TsExtractor.java */
    public class b implements SectionPayloadReader {
        public final ParsableBitArray a = new ParsableBitArray(new byte[5]);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SparseArray<TsPayloadReader> f1255b = new SparseArray<>();
        public final SparseIntArray c = new SparseIntArray();
        public final int d;

        public b(int i) {
            this.d = i;
        }

        @Override // b.i.a.c.x2.k0.SectionPayloadReader
        public void a(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        }

        /* JADX WARN: Code duplicated, block: B:47:0x012c  */
        /* JADX WARN: Code duplicated, block: B:51:0x0134  */
        /* JADX WARN: Code duplicated, block: B:56:0x0141  */
        @Override // b.i.a.c.x2.k0.SectionPayloadReader
        public void b(ParsableByteArray parsableByteArray) {
            TimestampAdjuster timestampAdjuster;
            TimestampAdjuster timestampAdjuster2;
            int i;
            int i2;
            int i3;
            TimestampAdjuster timestampAdjuster3;
            int i4;
            if (parsableByteArray.t() != 2) {
                return;
            }
            TsExtractor tsExtractor = TsExtractor.this;
            int i5 = tsExtractor.a;
            if (i5 == 1 || i5 == 2 || tsExtractor.m == 1) {
                timestampAdjuster = tsExtractor.c.get(0);
            } else {
                timestampAdjuster = new TimestampAdjuster(tsExtractor.c.get(0).c());
                TsExtractor.this.c.add(timestampAdjuster);
            }
            if ((parsableByteArray.t() & 128) == 0) {
                return;
            }
            parsableByteArray.F(1);
            int iY = parsableByteArray.y();
            int i6 = 3;
            parsableByteArray.F(3);
            parsableByteArray.d(this.a, 2);
            this.a.m(3);
            int i7 = 13;
            TsExtractor.this.f1253s = this.a.g(13);
            parsableByteArray.d(this.a, 2);
            int i8 = 4;
            this.a.m(4);
            int i9 = 12;
            parsableByteArray.F(this.a.g(12));
            TsExtractor tsExtractor2 = TsExtractor.this;
            int i10 = 21;
            if (tsExtractor2.a == 2 && tsExtractor2.q == null) {
                TsPayloadReader.b bVar = new TsPayloadReader.b(21, null, null, Util2.f);
                TsExtractor tsExtractor3 = TsExtractor.this;
                tsExtractor3.q = tsExtractor3.f.a(21, bVar);
                TsExtractor tsExtractor4 = TsExtractor.this;
                TsPayloadReader tsPayloadReader = tsExtractor4.q;
                if (tsPayloadReader != null) {
                    tsPayloadReader.a(timestampAdjuster, tsExtractor4.l, new TsPayloadReader.d(iY, 21, 8192));
                }
            }
            this.f1255b.clear();
            this.c.clear();
            int iA = parsableByteArray.a();
            while (iA > 0) {
                int i11 = 5;
                parsableByteArray.d(this.a, 5);
                int iG = this.a.g(8);
                this.a.m(i6);
                int iG2 = this.a.g(i7);
                this.a.m(i8);
                int iG3 = this.a.g(i9);
                int i12 = parsableByteArray.f984b;
                int i13 = iG3 + i12;
                int i14 = -1;
                String strTrim = null;
                ArrayList arrayList = null;
                while (parsableByteArray.f984b < i13) {
                    int iT = parsableByteArray.t();
                    int iT2 = parsableByteArray.f984b + parsableByteArray.t();
                    if (iT2 > i13) {
                        break;
                    }
                    if (iT == i11) {
                        long jU = parsableByteArray.u();
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
                        timestampAdjuster3 = timestampAdjuster;
                        i4 = iG2;
                    } else {
                        if (iT == 106) {
                            i14 = Opcodes.LOR;
                        } else if (iT == 122) {
                            i14 = Opcodes.I2D;
                        } else if (iT == 127) {
                            if (parsableByteArray.t() == i10) {
                                i14 = Opcodes.IRETURN;
                            }
                        } else if (iT == 123) {
                            i14 = Opcodes.L2D;
                        } else if (iT == 10) {
                            strTrim = parsableByteArray.q(3).trim();
                            i3 = iY;
                            timestampAdjuster3 = timestampAdjuster;
                            i4 = iG2;
                        } else {
                            int i15 = 3;
                            if (iT == 89) {
                                ArrayList arrayList2 = new ArrayList();
                                while (parsableByteArray.f984b < iT2) {
                                    String strTrim2 = parsableByteArray.q(i15).trim();
                                    int iT3 = parsableByteArray.t();
                                    byte[] bArr = new byte[4];
                                    System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr, 0, 4);
                                    parsableByteArray.f984b += 4;
                                    arrayList2.add(new TsPayloadReader.a(strTrim2, iT3, bArr));
                                    timestampAdjuster = timestampAdjuster;
                                    iY = iY;
                                    iG2 = iG2;
                                    i15 = 3;
                                }
                                i3 = iY;
                                timestampAdjuster3 = timestampAdjuster;
                                i4 = iG2;
                                arrayList = arrayList2;
                                i14 = 89;
                            } else {
                                i3 = iY;
                                timestampAdjuster3 = timestampAdjuster;
                                i4 = iG2;
                                if (iT == 111) {
                                    i14 = 257;
                                }
                            }
                        }
                        i3 = iY;
                        timestampAdjuster3 = timestampAdjuster;
                        i4 = iG2;
                    }
                    parsableByteArray.F(iT2 - parsableByteArray.f984b);
                    timestampAdjuster = timestampAdjuster3;
                    iY = i3;
                    iG2 = i4;
                    i11 = 5;
                    i10 = 21;
                }
                int i16 = iY;
                TimestampAdjuster timestampAdjuster4 = timestampAdjuster;
                int i17 = iG2;
                parsableByteArray.E(i13);
                TsPayloadReader.b bVar2 = new TsPayloadReader.b(i14, strTrim, arrayList, Arrays.copyOfRange(parsableByteArray.a, i12, i13));
                if (iG == 6 || iG == 5) {
                    iG = i14;
                }
                iA -= iG3 + 5;
                TsExtractor tsExtractor5 = TsExtractor.this;
                int i18 = tsExtractor5.a == 2 ? iG : i17;
                if (!tsExtractor5.h.get(i18)) {
                    TsExtractor tsExtractor6 = TsExtractor.this;
                    TsPayloadReader tsPayloadReaderA = (tsExtractor6.a == 2 && iG == 21) ? tsExtractor6.q : tsExtractor6.f.a(iG, bVar2);
                    if (TsExtractor.this.a == 2) {
                        i2 = i17;
                        if (i2 < this.c.get(i18, 8192)) {
                        }
                    } else {
                        i2 = i17;
                    }
                    this.c.put(i18, i2);
                    this.f1255b.put(i18, tsPayloadReaderA);
                }
                timestampAdjuster = timestampAdjuster4;
                iY = i16;
                i6 = 3;
                i8 = 4;
                i7 = 13;
                i9 = 12;
                i10 = 21;
            }
            int i19 = iY;
            TimestampAdjuster timestampAdjuster5 = timestampAdjuster;
            int size = this.c.size();
            int i20 = 0;
            while (i20 < size) {
                int iKeyAt = this.c.keyAt(i20);
                int iValueAt = this.c.valueAt(i20);
                TsExtractor.this.h.put(iKeyAt, true);
                TsExtractor.this.i.put(iValueAt, true);
                TsPayloadReader tsPayloadReaderValueAt = this.f1255b.valueAt(i20);
                if (tsPayloadReaderValueAt != null) {
                    TsExtractor tsExtractor7 = TsExtractor.this;
                    if (tsPayloadReaderValueAt != tsExtractor7.q) {
                        ExtractorOutput extractorOutput = tsExtractor7.l;
                        i = i19;
                        TsPayloadReader.d dVar = new TsPayloadReader.d(i, iKeyAt, 8192);
                        timestampAdjuster2 = timestampAdjuster5;
                        tsPayloadReaderValueAt.a(timestampAdjuster2, extractorOutput, dVar);
                    } else {
                        timestampAdjuster2 = timestampAdjuster5;
                        i = i19;
                    }
                    TsExtractor.this.g.put(iValueAt, tsPayloadReaderValueAt);
                } else {
                    timestampAdjuster2 = timestampAdjuster5;
                    i = i19;
                }
                i20++;
                timestampAdjuster5 = timestampAdjuster2;
                i19 = i;
            }
            TsExtractor tsExtractor8 = TsExtractor.this;
            if (tsExtractor8.a == 2) {
                if (tsExtractor8.n) {
                    return;
                }
                tsExtractor8.l.j();
                TsExtractor tsExtractor9 = TsExtractor.this;
                tsExtractor9.m = 0;
                tsExtractor9.n = true;
                return;
            }
            tsExtractor8.g.remove(this.d);
            TsExtractor tsExtractor10 = TsExtractor.this;
            int i21 = tsExtractor10.a == 1 ? 0 : tsExtractor10.m - 1;
            tsExtractor10.m = i21;
            if (i21 == 0) {
                tsExtractor10.l.j();
                TsExtractor.this.n = true;
            }
        }
    }

    static {
        e eVar = new ExtractorsFactory2() { // from class: b.i.a.c.x2.k0.e
            @Override // b.i.a.c.x2.ExtractorsFactory2
            public final Extractor[] a() {
                return new Extractor[]{new TsExtractor(1, 0, 112800)};
            }

            @Override // b.i.a.c.x2.ExtractorsFactory2
            public /* synthetic */ Extractor[] b(Uri uri, Map map) {
                return ExtractorsFactory.a(this, uri, map);
            }
        };
    }

    public TsExtractor(int i, int i2, int i3) {
        TimestampAdjuster timestampAdjuster = new TimestampAdjuster(0L);
        DefaultTsPayloadReaderFactory defaultTsPayloadReaderFactory = new DefaultTsPayloadReaderFactory(i2);
        this.f = defaultTsPayloadReaderFactory;
        this.f1252b = i3;
        this.a = i;
        if (i == 1 || i == 2) {
            this.c = Collections.singletonList(timestampAdjuster);
        } else {
            ArrayList arrayList = new ArrayList();
            this.c = arrayList;
            arrayList.add(timestampAdjuster);
        }
        this.d = new ParsableByteArray(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.h = sparseBooleanArray;
        this.i = new SparseBooleanArray();
        SparseArray<TsPayloadReader> sparseArray = new SparseArray<>();
        this.g = sparseArray;
        this.e = new SparseIntArray();
        this.j = new TsDurationReader(i3);
        this.l = ExtractorOutput.d;
        this.f1253s = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray<TsPayloadReader> sparseArrayB = defaultTsPayloadReaderFactory.b();
        int size = sparseArrayB.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.g.put(sparseArrayB.keyAt(i4), sparseArrayB.valueAt(i4));
        }
        this.g.put(0, new SectionReader(new a()));
        this.q = null;
    }

    @Override // b.i.a.c.x2.Extractor
    public boolean b(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        byte[] bArr = this.d.a;
        extractorInput.o(bArr, 0, 940);
        for (int i = 0; i < 188; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    z2 = true;
                    break;
                }
                if (bArr[(i2 * Opcodes.NEWARRAY) + i] != 71) {
                    z2 = false;
                    break;
                }
                i2++;
            }
            if (z2) {
                extractorInput.l(i);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // b.i.a.c.x2.Extractor
    public int e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        ?? r0;
        ?? r1;
        boolean z2;
        int i;
        boolean z3;
        boolean z4;
        long jB = extractorInput.b();
        int i2 = 1;
        if (this.n) {
            long j = -9223372036854775807L;
            if ((jB == -1 || this.a == 2) ? false : true) {
                TsDurationReader tsDurationReader = this.j;
                if (!tsDurationReader.d) {
                    int i3 = this.f1253s;
                    if (i3 <= 0) {
                        tsDurationReader.a(extractorInput);
                        return 0;
                    }
                    if (!tsDurationReader.f) {
                        long jB2 = extractorInput.b();
                        int iMin = (int) Math.min(tsDurationReader.a, jB2);
                        long j2 = jB2 - ((long) iMin);
                        if (extractorInput.getPosition() != j2) {
                            positionHolder.a = j2;
                        } else {
                            tsDurationReader.c.A(iMin);
                            extractorInput.k();
                            extractorInput.o(tsDurationReader.c.a, 0, iMin);
                            ParsableByteArray parsableByteArray = tsDurationReader.c;
                            int i4 = parsableByteArray.f984b;
                            int i5 = parsableByteArray.c;
                            for (int i6 = i5 - 188; i6 >= i4; i6--) {
                                byte[] bArr = parsableByteArray.a;
                                int i7 = -4;
                                int i8 = 0;
                                while (true) {
                                    if (i7 > 4) {
                                        z4 = false;
                                        break;
                                    }
                                    int i9 = (i7 * Opcodes.NEWARRAY) + i6;
                                    if (i9 >= i4 && i9 < i5 && bArr[i9] == 71) {
                                        i8++;
                                        if (i8 == 5) {
                                            z4 = true;
                                            break;
                                        }
                                    } else {
                                        i8 = 0;
                                    }
                                    i7++;
                                }
                                if (z4) {
                                    long jK1 = AnimatableValueParser.K1(parsableByteArray, i6, i3);
                                    if (jK1 != -9223372036854775807L) {
                                        j = jK1;
                                        break;
                                    }
                                }
                            }
                            tsDurationReader.h = j;
                            tsDurationReader.f = true;
                            i2 = 0;
                        }
                    } else {
                        if (tsDurationReader.h == -9223372036854775807L) {
                            tsDurationReader.a(extractorInput);
                            return 0;
                        }
                        if (tsDurationReader.e) {
                            long j3 = tsDurationReader.g;
                            if (j3 == -9223372036854775807L) {
                                tsDurationReader.a(extractorInput);
                                return 0;
                            }
                            long jB3 = tsDurationReader.f1250b.b(tsDurationReader.h) - tsDurationReader.f1250b.b(j3);
                            tsDurationReader.i = jB3;
                            if (jB3 < 0) {
                                Log.w("TsDurationReader", outline.i(65, "Invalid duration: ", jB3, ". Using TIME_UNSET instead."));
                                tsDurationReader.i = -9223372036854775807L;
                            }
                            tsDurationReader.a(extractorInput);
                            return 0;
                        }
                        int iMin2 = (int) Math.min(tsDurationReader.a, extractorInput.b());
                        long j4 = 0;
                        if (extractorInput.getPosition() != j4) {
                            positionHolder.a = j4;
                        } else {
                            tsDurationReader.c.A(iMin2);
                            extractorInput.k();
                            extractorInput.o(tsDurationReader.c.a, 0, iMin2);
                            ParsableByteArray parsableByteArray2 = tsDurationReader.c;
                            int i10 = parsableByteArray2.c;
                            for (int i11 = parsableByteArray2.f984b; i11 < i10; i11++) {
                                if (parsableByteArray2.a[i11] == 71) {
                                    long jK2 = AnimatableValueParser.K1(parsableByteArray2, i11, i3);
                                    if (jK2 != -9223372036854775807L) {
                                        j = jK2;
                                        break;
                                    }
                                }
                            }
                            tsDurationReader.g = j;
                            tsDurationReader.e = true;
                            i2 = 0;
                        }
                    }
                    return i2;
                }
            }
            if (!this.o) {
                this.o = true;
                TsDurationReader tsDurationReader2 = this.j;
                long j5 = tsDurationReader2.i;
                if (j5 != -9223372036854775807L) {
                    TsBinarySearchSeeker tsBinarySearchSeeker = new TsBinarySearchSeeker(tsDurationReader2.f1250b, j5, jB, this.f1253s, this.f1252b);
                    this.k = tsBinarySearchSeeker;
                    this.l.a(tsBinarySearchSeeker.a);
                } else {
                    this.l.a(new SeekMap.b(j5, 0L));
                }
            }
            if (this.p) {
                z3 = false;
                this.p = false;
                g(0L, 0L);
                if (extractorInput.getPosition() != 0) {
                    positionHolder.a = 0L;
                    return 1;
                }
            } else {
                z3 = false;
            }
            r1 = 1;
            r1 = 1;
            TsBinarySearchSeeker tsBinarySearchSeeker2 = this.k;
            r0 = z3;
            if (tsBinarySearchSeeker2 != null && tsBinarySearchSeeker2.b()) {
                r0 = z3;
                return this.k.a(extractorInput, positionHolder);
            }
        } else {
            r0 = 0;
            r1 = 1;
        }
        r0 = z3;
        ParsableByteArray parsableByteArray3 = this.d;
        byte[] bArr2 = parsableByteArray3.a;
        if (9400 - parsableByteArray3.f984b < 188) {
            int iA = parsableByteArray3.a();
            if (iA > 0) {
                System.arraycopy(bArr2, this.d.f984b, bArr2, r0, iA);
            }
            this.d.C(bArr2, iA);
        }
        while (true) {
            if (this.d.a() >= 188) {
                z2 = true;
                break;
            }
            int i12 = this.d.c;
            int i13 = extractorInput.read(bArr2, i12, 9400 - i12);
            if (i13 == -1) {
                z2 = false;
                break;
            }
            this.d.D(i12 + i13);
        }
        if (!z2) {
            return -1;
        }
        ParsableByteArray parsableByteArray4 = this.d;
        int i14 = parsableByteArray4.f984b;
        int i15 = parsableByteArray4.c;
        byte[] bArr3 = parsableByteArray4.a;
        int i16 = i14;
        while (i16 < i15 && bArr3[i16] != 71) {
            i16++;
        }
        this.d.E(i16);
        int i17 = i16 + Opcodes.NEWARRAY;
        if (i17 > i15) {
            int i18 = (i16 - i14) + this.r;
            this.r = i18;
            i = 2;
            if (this.a == 2 && i18 > 376) {
                throw ParserException.a("Cannot find sync byte. Most likely not a Transport Stream.", null);
            }
        } else {
            i = 2;
            this.r = r0;
        }
        ParsableByteArray parsableByteArray5 = this.d;
        int i19 = parsableByteArray5.c;
        if (i17 > i19) {
            return r0;
        }
        int iF = parsableByteArray5.f();
        if ((8388608 & iF) != 0) {
            this.d.E(i17);
            return r0;
        }
        int i20 = ((4194304 & iF) != 0 ? 1 : 0) | 0;
        int i21 = (2096896 & iF) >> 8;
        boolean z5 = (iF & 32) != 0;
        TsPayloadReader tsPayloadReader = (iF & 16) != 0 ? this.g.get(i21) : null;
        if (tsPayloadReader == null) {
            this.d.E(i17);
            return r0;
        }
        if (this.a != i) {
            int i22 = iF & 15;
            int i23 = this.e.get(i21, i22 - 1);
            this.e.put(i21, i22);
            if (i23 == i22) {
                this.d.E(i17);
                return r0;
            }
            if (i22 != ((i23 + r1) & 15)) {
                tsPayloadReader.c();
            }
        }
        if (z5) {
            int iT = this.d.t();
            i20 |= (this.d.t() & 64) != 0 ? 2 : 0;
            this.d.F(iT - r1);
        }
        boolean z6 = this.n;
        if (this.a == i || z6 || !this.i.get(i21, r0)) {
            this.d.D(i17);
            tsPayloadReader.b(this.d, i20);
            this.d.D(i19);
        }
        if (this.a != i && !z6 && this.n && jB != -1) {
            this.p = r1;
        }
        this.d.E(i17);
        return r0;
    }

    @Override // b.i.a.c.x2.Extractor
    public void f(ExtractorOutput extractorOutput) {
        this.l = extractorOutput;
    }

    @Override // b.i.a.c.x2.Extractor
    public void g(long j, long j2) {
        TsBinarySearchSeeker tsBinarySearchSeeker;
        AnimatableValueParser.D(this.a != 2);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            TimestampAdjuster timestampAdjuster = this.c.get(i);
            boolean z2 = timestampAdjuster.d() == -9223372036854775807L;
            if (!z2) {
                long jC = timestampAdjuster.c();
                z2 = (jC == -9223372036854775807L || jC == 0 || jC == j2) ? false : true;
            }
            if (z2) {
                timestampAdjuster.e(j2);
            }
        }
        if (j2 != 0 && (tsBinarySearchSeeker = this.k) != null) {
            tsBinarySearchSeeker.e(j2);
        }
        this.d.A(0);
        this.e.clear();
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            this.g.valueAt(i2).c();
        }
        this.r = 0;
    }

    @Override // b.i.a.c.x2.Extractor
    public void release() {
    }
}
