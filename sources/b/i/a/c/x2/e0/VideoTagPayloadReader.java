package b.i.a.c.x2.e0;

import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.f3.NalUnitUtil;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.g3.AvcConfig;
import b.i.a.c.x2.TrackOutput2;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;

/* JADX INFO: renamed from: b.i.a.c.x2.e0.e, reason: use source file name */
/* JADX INFO: compiled from: VideoTagPayloadReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class VideoTagPayloadReader extends TagPayloadReader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f1174b;
    public final ParsableByteArray c;
    public int d;
    public boolean e;
    public boolean f;
    public int g;

    public VideoTagPayloadReader(TrackOutput2 trackOutput2) {
        super(trackOutput2);
        this.f1174b = new ParsableByteArray(NalUnitUtil.a);
        this.c = new ParsableByteArray(4);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        int iT = parsableByteArray.t();
        int i = (iT >> 4) & 15;
        int i2 = iT & 15;
        if (i2 != 7) {
            throw new TagPayloadReader.UnsupportedFormatException(outline.g(39, "Video format not supported: ", i2));
        }
        this.g = i;
        return i != 5;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(ParsableByteArray parsableByteArray, long j) throws ParserException {
        int iT = parsableByteArray.t();
        byte[] bArr = parsableByteArray.a;
        int i = parsableByteArray.f984b;
        int i2 = i + 1;
        parsableByteArray.f984b = i2;
        int i3 = ((bArr[i] & 255) << 24) >> 8;
        int i4 = i2 + 1;
        parsableByteArray.f984b = i4;
        int i5 = i3 | ((bArr[i2] & 255) << 8);
        parsableByteArray.f984b = i4 + 1;
        long j2 = (((long) ((bArr[i4] & 255) | i5)) * 1000) + j;
        if (iT == 0 && !this.e) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray(new byte[parsableByteArray.a()]);
            parsableByteArray.e(parsableByteArray2.a, 0, parsableByteArray.a());
            AvcConfig avcConfigB = AvcConfig.b(parsableByteArray2);
            this.d = avcConfigB.f986b;
            Format2.b bVar = new Format2.b();
            bVar.k = "video/avc";
            bVar.h = avcConfigB.f;
            bVar.p = avcConfigB.c;
            bVar.q = avcConfigB.d;
            bVar.t = avcConfigB.e;
            bVar.m = avcConfigB.a;
            this.a.e(bVar.a());
            this.e = true;
            return false;
        }
        if (iT != 1 || !this.e) {
            return false;
        }
        int i6 = this.g == 1 ? 1 : 0;
        if (!this.f && i6 == 0) {
            return false;
        }
        byte[] bArr2 = this.c.a;
        bArr2[0] = 0;
        bArr2[1] = 0;
        bArr2[2] = 0;
        int i7 = 4 - this.d;
        int i8 = 0;
        while (parsableByteArray.a() > 0) {
            parsableByteArray.e(this.c.a, i7, this.d);
            this.c.E(0);
            int iW = this.c.w();
            this.f1174b.E(0);
            this.a.c(this.f1174b, 4);
            this.a.c(parsableByteArray, iW);
            i8 = i8 + 4 + iW;
        }
        this.a.d(j2, i6, i8, 0, null);
        this.f = true;
        return true;
    }
}
