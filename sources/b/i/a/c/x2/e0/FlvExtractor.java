package b.i.a.c.x2.e0;

import android.net.Uri;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.Extractor;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.ExtractorsFactory;
import b.i.a.c.x2.ExtractorsFactory2;
import b.i.a.c.x2.IndexSeekMap;
import b.i.a.c.x2.PositionHolder;
import b.i.a.c.x2.SeekMap;
import java.io.IOException;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: b.i.a.c.x2.e0.c, reason: use source file name */
/* JADX INFO: compiled from: FlvExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FlvExtractor implements Extractor {
    public ExtractorOutput f;
    public boolean h;
    public long i;
    public int j;
    public int k;
    public int l;
    public long m;
    public boolean n;
    public AudioTagPayloadReader o;
    public VideoTagPayloadReader p;
    public final ParsableByteArray a = new ParsableByteArray(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f1172b = new ParsableByteArray(9);
    public final ParsableByteArray c = new ParsableByteArray(11);
    public final ParsableByteArray d = new ParsableByteArray();
    public final ScriptTagPayloadReader e = new ScriptTagPayloadReader();
    public int g = 1;

    static {
        a aVar = new ExtractorsFactory2() { // from class: b.i.a.c.x2.e0.a
            @Override // b.i.a.c.x2.ExtractorsFactory2
            public final Extractor[] a() {
                return new Extractor[]{new FlvExtractor()};
            }

            @Override // b.i.a.c.x2.ExtractorsFactory2
            public /* synthetic */ Extractor[] b(Uri uri, Map map) {
                return ExtractorsFactory.a(this, uri, map);
            }
        };
    }

    @RequiresNonNull({"extractorOutput"})
    public final void a() {
        if (this.n) {
            return;
        }
        this.f.a(new SeekMap.b(-9223372036854775807L, 0L));
        this.n = true;
    }

    @Override // b.i.a.c.x2.Extractor
    public boolean b(ExtractorInput extractorInput) throws IOException {
        extractorInput.o(this.a.a, 0, 3);
        this.a.E(0);
        if (this.a.v() != 4607062) {
            return false;
        }
        extractorInput.o(this.a.a, 0, 2);
        this.a.E(0);
        if ((this.a.y() & 250) != 0) {
            return false;
        }
        extractorInput.o(this.a.a, 0, 4);
        this.a.E(0);
        int iF = this.a.f();
        extractorInput.k();
        extractorInput.g(iF);
        extractorInput.o(this.a.a, 0, 4);
        this.a.E(0);
        return this.a.f() == 0;
    }

    public final ParsableByteArray c(ExtractorInput extractorInput) throws IOException {
        int i = this.l;
        ParsableByteArray parsableByteArray = this.d;
        byte[] bArr = parsableByteArray.a;
        if (i > bArr.length) {
            parsableByteArray.a = new byte[Math.max(bArr.length * 2, i)];
            parsableByteArray.c = 0;
            parsableByteArray.f984b = 0;
        } else {
            parsableByteArray.E(0);
        }
        this.d.D(this.l);
        extractorInput.readFully(this.d.a, 0, this.l);
        return this.d;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:40:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:79:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0009 A[SYNTHETIC] */
    @Override // b.i.a.c.x2.Extractor
    public int e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        long j;
        boolean zA;
        boolean z2;
        long j2;
        AnimatableValueParser.H(this.f);
        while (true) {
            int i = this.g;
            boolean z3 = false;
            if (i == 1) {
                if (extractorInput.c(this.f1172b.a, 0, 9, true)) {
                    this.f1172b.E(0);
                    this.f1172b.F(4);
                    int iT = this.f1172b.t();
                    boolean z4 = (iT & 4) != 0;
                    z3 = (iT & 1) != 0;
                    if (z4 && this.o == null) {
                        this.o = new AudioTagPayloadReader(this.f.p(8, 1));
                    }
                    if (z3 && this.p == null) {
                        this.p = new VideoTagPayloadReader(this.f.p(9, 2));
                    }
                    this.f.j();
                    this.j = (this.f1172b.f() - 9) + 4;
                    this.g = 2;
                    z3 = true;
                }
                if (!z3) {
                    return -1;
                }
            } else if (i == 2) {
                extractorInput.l(this.j);
                this.j = 0;
                this.g = 3;
            } else if (i == 3) {
                if (extractorInput.c(this.c.a, 0, 11, true)) {
                    this.c.E(0);
                    this.k = this.c.t();
                    this.l = this.c.v();
                    this.m = this.c.v();
                    this.m = (((long) (this.c.t() << 24)) | this.m) * 1000;
                    this.c.F(3);
                    this.g = 4;
                    z3 = true;
                }
                if (!z3) {
                    return -1;
                }
            } else {
                if (i != 4) {
                    throw new IllegalStateException();
                }
                if (this.h) {
                    j = this.i + this.m;
                } else {
                    j = this.e.f1173b == -9223372036854775807L ? 0L : this.m;
                }
                int i2 = this.k;
                if (i2 == 8 && this.o != null) {
                    a();
                    zA = this.o.a(c(extractorInput), j);
                } else if (i2 != 9 || this.p == null) {
                    if (i2 != 18 || this.n) {
                        extractorInput.l(this.l);
                        zA = false;
                        z2 = false;
                    } else {
                        zA = this.e.a(c(extractorInput), j);
                        ScriptTagPayloadReader scriptTagPayloadReader = this.e;
                        long j3 = scriptTagPayloadReader.f1173b;
                        if (j3 != -9223372036854775807L) {
                            this.f.a(new IndexSeekMap(scriptTagPayloadReader.d, scriptTagPayloadReader.c, j3));
                            this.n = true;
                        }
                    }
                    if (!this.h && zA) {
                        this.h = true;
                        if (this.e.f1173b == -9223372036854775807L) {
                            j2 = -this.m;
                        } else {
                            j2 = 0;
                        }
                        this.i = j2;
                    }
                    this.j = 4;
                    this.g = 2;
                    if (z2) {
                        return 0;
                    }
                } else {
                    a();
                    zA = this.p.a(c(extractorInput), j);
                }
                z2 = true;
                if (!this.h) {
                    this.h = true;
                    if (this.e.f1173b == -9223372036854775807L) {
                        j2 = -this.m;
                    } else {
                        j2 = 0;
                    }
                    this.i = j2;
                }
                this.j = 4;
                this.g = 2;
                if (z2) {
                    return 0;
                }
            }
        }
    }

    @Override // b.i.a.c.x2.Extractor
    public void f(ExtractorOutput extractorOutput) {
        this.f = extractorOutput;
    }

    @Override // b.i.a.c.x2.Extractor
    public void g(long j, long j2) {
        if (j == 0) {
            this.g = 1;
            this.h = false;
        } else {
            this.g = 3;
        }
        this.j = 0;
    }

    @Override // b.i.a.c.x2.Extractor
    public void release() {
    }
}
