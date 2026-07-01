package b.i.a.c.x2.k0;

import android.net.Uri;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.TimestampAdjuster;
import b.i.a.c.x2.Extractor;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.ExtractorsFactory;
import b.i.a.c.x2.ExtractorsFactory2;
import b.i.a.c.x2.PositionHolder;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.k0.TsPayloadReader;
import com.discord.api.permission.Permission;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.b0, reason: use source file name */
/* JADX INFO: compiled from: PsExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class PsExtractor implements Extractor {
    public boolean e;
    public boolean f;
    public boolean g;
    public long h;

    @Nullable
    public PsBinarySearchSeeker i;
    public ExtractorOutput j;
    public boolean k;
    public final TimestampAdjuster a = new TimestampAdjuster(0);
    public final ParsableByteArray c = new ParsableByteArray(4096);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<a> f1243b = new SparseArray<>();
    public final PsDurationReader d = new PsDurationReader();

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.b0$a */
    /* JADX INFO: compiled from: PsExtractor.java */
    public static final class a {
        public final ElementaryStreamReader a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TimestampAdjuster f1244b;
        public final ParsableBitArray c = new ParsableBitArray(new byte[64]);
        public boolean d;
        public boolean e;
        public boolean f;
        public int g;
        public long h;

        public a(ElementaryStreamReader elementaryStreamReader, TimestampAdjuster timestampAdjuster) {
            this.a = elementaryStreamReader;
            this.f1244b = timestampAdjuster;
        }
    }

    static {
        d dVar = new ExtractorsFactory2() { // from class: b.i.a.c.x2.k0.d
            @Override // b.i.a.c.x2.ExtractorsFactory2
            public final Extractor[] a() {
                return new Extractor[]{new PsExtractor()};
            }

            @Override // b.i.a.c.x2.ExtractorsFactory2
            public /* synthetic */ Extractor[] b(Uri uri, Map map) {
                return ExtractorsFactory.a(this, uri, map);
            }
        };
    }

    @Override // b.i.a.c.x2.Extractor
    public boolean b(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = new byte[14];
        extractorInput.o(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        extractorInput.g(bArr[13] & 7);
        extractorInput.o(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    /* JADX WARN: Code duplicated, block: B:105:0x021d  */
    @Override // b.i.a.c.x2.Extractor
    public int e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i;
        ElementaryStreamReader h262Reader;
        AnimatableValueParser.H(this.j);
        long jB = extractorInput.b();
        int i2 = 1;
        long j = -9223372036854775807L;
        if (jB != -1) {
            PsDurationReader psDurationReader = this.d;
            if (!psDurationReader.c) {
                if (!psDurationReader.e) {
                    long jB2 = extractorInput.b();
                    int iMin = (int) Math.min(20000L, jB2);
                    long j2 = jB2 - ((long) iMin);
                    if (extractorInput.getPosition() != j2) {
                        positionHolder.a = j2;
                    } else {
                        psDurationReader.f1242b.A(iMin);
                        extractorInput.k();
                        extractorInput.o(psDurationReader.f1242b.a, 0, iMin);
                        ParsableByteArray parsableByteArray = psDurationReader.f1242b;
                        int i3 = parsableByteArray.f984b;
                        for (int i4 = parsableByteArray.c - 4; i4 >= i3; i4--) {
                            if (psDurationReader.b(parsableByteArray.a, i4) == 442) {
                                parsableByteArray.E(i4 + 4);
                                long jC = PsDurationReader.c(parsableByteArray);
                                if (jC != -9223372036854775807L) {
                                    j = jC;
                                    break;
                                }
                            }
                        }
                        psDurationReader.g = j;
                        psDurationReader.e = true;
                        i2 = 0;
                    }
                } else {
                    if (psDurationReader.g == -9223372036854775807L) {
                        psDurationReader.a(extractorInput);
                        return 0;
                    }
                    if (psDurationReader.d) {
                        long j3 = psDurationReader.f;
                        if (j3 == -9223372036854775807L) {
                            psDurationReader.a(extractorInput);
                            return 0;
                        }
                        long jB3 = psDurationReader.a.b(psDurationReader.g) - psDurationReader.a.b(j3);
                        psDurationReader.h = jB3;
                        if (jB3 < 0) {
                            Log.w("PsDurationReader", outline.i(65, "Invalid duration: ", jB3, ". Using TIME_UNSET instead."));
                            psDurationReader.h = -9223372036854775807L;
                        }
                        psDurationReader.a(extractorInput);
                        return 0;
                    }
                    int iMin2 = (int) Math.min(20000L, extractorInput.b());
                    long j4 = 0;
                    if (extractorInput.getPosition() != j4) {
                        positionHolder.a = j4;
                    } else {
                        psDurationReader.f1242b.A(iMin2);
                        extractorInput.k();
                        extractorInput.o(psDurationReader.f1242b.a, 0, iMin2);
                        ParsableByteArray parsableByteArray2 = psDurationReader.f1242b;
                        int i5 = parsableByteArray2.c;
                        for (int i6 = parsableByteArray2.f984b; i6 < i5 - 3; i6++) {
                            if (psDurationReader.b(parsableByteArray2.a, i6) == 442) {
                                parsableByteArray2.E(i6 + 4);
                                long jC2 = PsDurationReader.c(parsableByteArray2);
                                if (jC2 != -9223372036854775807L) {
                                    j = jC2;
                                    break;
                                }
                            }
                        }
                        psDurationReader.f = j;
                        psDurationReader.d = true;
                        i2 = 0;
                    }
                }
                return i2;
            }
        }
        if (this.k) {
            i = 442;
        } else {
            this.k = true;
            PsDurationReader psDurationReader2 = this.d;
            long j5 = psDurationReader2.h;
            if (j5 != -9223372036854775807L) {
                PsBinarySearchSeeker psBinarySearchSeeker = new PsBinarySearchSeeker(psDurationReader2.a, j5, jB);
                this.i = psBinarySearchSeeker;
                this.j.a(psBinarySearchSeeker.a);
                i = 442;
            } else {
                i = 442;
                this.j.a(new SeekMap.b(j5, 0L));
            }
        }
        PsBinarySearchSeeker psBinarySearchSeeker2 = this.i;
        if (psBinarySearchSeeker2 != null && psBinarySearchSeeker2.b()) {
            return this.i.a(extractorInput, positionHolder);
        }
        extractorInput.k();
        long jF = jB != -1 ? jB - extractorInput.f() : -1L;
        if ((jF != -1 && jF < 4) || !extractorInput.e(this.c.a, 0, 4, true)) {
            return -1;
        }
        this.c.E(0);
        int iF = this.c.f();
        if (iF == 441) {
            return -1;
        }
        if (iF == i) {
            extractorInput.o(this.c.a, 0, 10);
            this.c.E(9);
            extractorInput.l((this.c.t() & 7) + 14);
            return 0;
        }
        if (iF == 443) {
            extractorInput.o(this.c.a, 0, 2);
            this.c.E(0);
            extractorInput.l(this.c.y() + 6);
            return 0;
        }
        if (((iF & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
            extractorInput.l(1);
            return 0;
        }
        int i7 = iF & 255;
        a aVar = this.f1243b.get(i7);
        if (!this.e) {
            if (aVar == null) {
                ElementaryStreamReader elementaryStreamReader = null;
                if (i7 == 189) {
                    h262Reader = new Ac3Reader(null);
                    this.f = true;
                    this.h = extractorInput.getPosition();
                } else if ((i7 & 224) == 192) {
                    h262Reader = new MpegAudioReader(null);
                    this.f = true;
                    this.h = extractorInput.getPosition();
                } else if ((i7 & 240) == 224) {
                    h262Reader = new H262Reader(null);
                    this.g = true;
                    this.h = extractorInput.getPosition();
                } else if (elementaryStreamReader != null) {
                    elementaryStreamReader.e(this.j, new TsPayloadReader.d(Integer.MIN_VALUE, i7, 256));
                    aVar = new a(elementaryStreamReader, this.a);
                    this.f1243b.put(i7, aVar);
                }
                elementaryStreamReader = h262Reader;
                if (elementaryStreamReader != null) {
                    elementaryStreamReader.e(this.j, new TsPayloadReader.d(Integer.MIN_VALUE, i7, 256));
                    aVar = new a(elementaryStreamReader, this.a);
                    this.f1243b.put(i7, aVar);
                }
            }
            if (extractorInput.getPosition() > ((this.f && this.g) ? this.h + Permission.MANAGE_MESSAGES : Permission.CONNECT)) {
                this.e = true;
                this.j.j();
            }
        }
        extractorInput.o(this.c.a, 0, 2);
        this.c.E(0);
        int iY = this.c.y() + 6;
        if (aVar == null) {
            extractorInput.l(iY);
            return 0;
        }
        this.c.A(iY);
        extractorInput.readFully(this.c.a, 0, iY);
        this.c.E(6);
        ParsableByteArray parsableByteArray3 = this.c;
        parsableByteArray3.e(aVar.c.a, 0, 3);
        aVar.c.k(0);
        aVar.c.m(8);
        aVar.d = aVar.c.f();
        aVar.e = aVar.c.f();
        aVar.c.m(6);
        int iG = aVar.c.g(8);
        aVar.g = iG;
        parsableByteArray3.e(aVar.c.a, 0, iG);
        aVar.c.k(0);
        aVar.h = 0L;
        if (aVar.d) {
            aVar.c.m(4);
            long jG = ((long) aVar.c.g(3)) << 30;
            aVar.c.m(1);
            long jG2 = jG | ((long) (aVar.c.g(15) << 15));
            aVar.c.m(1);
            long jG3 = jG2 | ((long) aVar.c.g(15));
            aVar.c.m(1);
            if (!aVar.f && aVar.e) {
                aVar.c.m(4);
                long jG4 = ((long) aVar.c.g(3)) << 30;
                aVar.c.m(1);
                long jG5 = jG4 | ((long) (aVar.c.g(15) << 15));
                aVar.c.m(1);
                long jG6 = ((long) aVar.c.g(15)) | jG5;
                aVar.c.m(1);
                aVar.f1244b.b(jG6);
                aVar.f = true;
            }
            aVar.h = aVar.f1244b.b(jG3);
        }
        aVar.a.f(aVar.h, 4);
        aVar.a.b(parsableByteArray3);
        aVar.a.d();
        ParsableByteArray parsableByteArray4 = this.c;
        parsableByteArray4.D(parsableByteArray4.a.length);
        return 0;
    }

    @Override // b.i.a.c.x2.Extractor
    public void f(ExtractorOutput extractorOutput) {
        this.j = extractorOutput;
    }

    @Override // b.i.a.c.x2.Extractor
    public void g(long j, long j2) {
        boolean z2 = this.a.d() == -9223372036854775807L;
        if (!z2) {
            long jC = this.a.c();
            z2 = (jC == -9223372036854775807L || jC == 0 || jC == j2) ? false : true;
        }
        if (z2) {
            this.a.e(j2);
        }
        PsBinarySearchSeeker psBinarySearchSeeker = this.i;
        if (psBinarySearchSeeker != null) {
            psBinarySearchSeeker.e(j2);
        }
        for (int i = 0; i < this.f1243b.size(); i++) {
            a aVarValueAt = this.f1243b.valueAt(i);
            aVarValueAt.f = false;
            aVarValueAt.a.c();
        }
    }

    @Override // b.i.a.c.x2.Extractor
    public void release() {
    }
}
