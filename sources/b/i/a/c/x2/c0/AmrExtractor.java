package b.i.a.c.x2.c0;

import android.net.Uri;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.ConstantBitrateSeekMap;
import b.i.a.c.x2.Extractor;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.ExtractorsFactory;
import b.i.a.c.x2.ExtractorsFactory2;
import b.i.a.c.x2.PositionHolder;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.TrackOutput2;
import com.google.android.exoplayer2.ParserException;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: b.i.a.c.x2.c0.b, reason: use source file name */
/* JADX INFO: compiled from: AmrExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AmrExtractor implements Extractor {
    public static final int[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1165b;
    public static final byte[] c;
    public static final byte[] d;
    public static final int e;
    public final byte[] f;
    public final int g;
    public boolean h;
    public long i;
    public int j;
    public int k;
    public boolean l;
    public long m;
    public int n;
    public int o;
    public long p;
    public ExtractorOutput q;
    public TrackOutput2 r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public SeekMap f1166s;
    public boolean t;

    static {
        a aVar = new ExtractorsFactory2() { // from class: b.i.a.c.x2.c0.a
            @Override // b.i.a.c.x2.ExtractorsFactory2
            public final Extractor[] a() {
                return new Extractor[]{new AmrExtractor(0)};
            }

            @Override // b.i.a.c.x2.ExtractorsFactory2
            public /* synthetic */ Extractor[] b(Uri uri, Map map) {
                return ExtractorsFactory.a(this, uri, map);
            }
        };
        a = new int[]{13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f1165b = iArr;
        c = Util2.w("#!AMR\n");
        d = Util2.w("#!AMR-WB\n");
        e = iArr[8];
    }

    public AmrExtractor(int i) {
        this.g = (i & 2) != 0 ? i | 1 : i;
        this.f = new byte[1];
        this.n = -1;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x003c  */
    public final int a(ExtractorInput extractorInput) throws IOException {
        extractorInput.k();
        boolean z2 = false;
        extractorInput.o(this.f, 0, 1);
        byte b2 = this.f[0];
        if ((b2 & 131) > 0) {
            throw outline.w0(42, "Invalid padding bits for frame header ", b2, null);
        }
        int i = (b2 >> 3) & 15;
        if (i >= 0 && i <= 15) {
            boolean z3 = this.h;
            if (z3 && (i < 10 || i > 13)) {
                z2 = true;
            } else {
                if (!z3 && (i < 12 || i > 14)) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            return this.h ? f1165b[i] : a[i];
        }
        String str = this.h ? "WB" : "NB";
        StringBuilder sb = new StringBuilder(str.length() + 35);
        sb.append("Illegal AMR ");
        sb.append(str);
        sb.append(" frame type ");
        sb.append(i);
        throw ParserException.a(sb.toString(), null);
    }

    @Override // b.i.a.c.x2.Extractor
    public boolean b(ExtractorInput extractorInput) throws IOException {
        return c(extractorInput);
    }

    public final boolean c(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = c;
        extractorInput.k();
        byte[] bArr2 = new byte[bArr.length];
        extractorInput.o(bArr2, 0, bArr.length);
        if (Arrays.equals(bArr2, bArr)) {
            this.h = false;
            extractorInput.l(bArr.length);
            return true;
        }
        byte[] bArr3 = d;
        extractorInput.k();
        byte[] bArr4 = new byte[bArr3.length];
        extractorInput.o(bArr4, 0, bArr3.length);
        if (!Arrays.equals(bArr4, bArr3)) {
            return false;
        }
        this.h = true;
        extractorInput.l(bArr3.length);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0088  */
    /* JADX WARN: Code duplicated, block: B:32:0x008a  */
    /* JADX WARN: Code duplicated, block: B:35:0x0092  */
    @Override // b.i.a.c.x2.Extractor
    public int e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i;
        int i2;
        int iB;
        int i3;
        AnimatableValueParser.H(this.r);
        if (extractorInput.getPosition() == 0 && !c(extractorInput)) {
            throw ParserException.a("Could not find AMR header.", null);
        }
        if (!this.t) {
            this.t = true;
            boolean z2 = this.h;
            String str = z2 ? "audio/amr-wb" : "audio/3gpp";
            int i4 = z2 ? 16000 : 8000;
            TrackOutput2 trackOutput2 = this.r;
            Format2.b bVar = new Format2.b();
            bVar.k = str;
            bVar.l = e;
            bVar.f1023x = 1;
            bVar.f1024y = i4;
            trackOutput2.e(bVar.a());
        }
        if (this.k == 0) {
            try {
                int iA = a(extractorInput);
                this.j = iA;
                this.k = iA;
                if (this.n == -1) {
                    this.m = extractorInput.getPosition();
                    this.n = this.j;
                }
                if (this.n == this.j) {
                    this.o++;
                }
                iB = this.r.b(extractorInput, this.k, true);
                if (iB == -1) {
                    i = -1;
                } else {
                    i3 = this.k - iB;
                    this.k = i3;
                    if (i3 <= 0) {
                        this.r.d(this.p + this.i, 1, this.j, 0, null);
                        this.i += 20000;
                    }
                    i = 0;
                }
            } catch (EOFException unused) {
            }
        } else {
            iB = this.r.b(extractorInput, this.k, true);
            if (iB == -1) {
                i = -1;
            } else {
                i3 = this.k - iB;
                this.k = i3;
                if (i3 <= 0) {
                    this.r.d(this.p + this.i, 1, this.j, 0, null);
                    this.i += 20000;
                }
                i = 0;
            }
        }
        long jB = extractorInput.b();
        if (!this.l) {
            int i5 = this.g;
            if ((i5 & 1) == 0 || jB == -1 || !((i2 = this.n) == -1 || i2 == this.j)) {
                SeekMap.b bVar2 = new SeekMap.b(-9223372036854775807L, 0L);
                this.f1166s = bVar2;
                this.q.a(bVar2);
                this.l = true;
            } else if (this.o >= 20 || i == -1) {
                ConstantBitrateSeekMap constantBitrateSeekMap = new ConstantBitrateSeekMap(jB, this.m, (int) ((((long) (i2 * 8)) * 1000000) / 20000), i2, (i5 & 2) != 0);
                this.f1166s = constantBitrateSeekMap;
                this.q.a(constantBitrateSeekMap);
                this.l = true;
            }
        }
        return i;
    }

    @Override // b.i.a.c.x2.Extractor
    public void f(ExtractorOutput extractorOutput) {
        this.q = extractorOutput;
        this.r = extractorOutput.p(0, 1);
        extractorOutput.j();
    }

    @Override // b.i.a.c.x2.Extractor
    public void g(long j, long j2) {
        this.i = 0L;
        this.j = 0;
        this.k = 0;
        if (j != 0) {
            SeekMap seekMap = this.f1166s;
            if (seekMap instanceof ConstantBitrateSeekMap) {
                ConstantBitrateSeekMap constantBitrateSeekMap = (ConstantBitrateSeekMap) seekMap;
                this.p = ConstantBitrateSeekMap.e(j, constantBitrateSeekMap.f1167b, constantBitrateSeekMap.e);
                return;
            }
        }
        this.p = 0L;
    }

    @Override // b.i.a.c.x2.Extractor
    public void release() {
    }
}
