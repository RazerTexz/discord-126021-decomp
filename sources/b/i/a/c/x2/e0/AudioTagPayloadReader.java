package b.i.a.c.x2.e0;

import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.t2.AacUtil;
import b.i.a.c.x2.TrackOutput2;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import java.util.Collections;

/* JADX INFO: renamed from: b.i.a.c.x2.e0.b, reason: use source file name */
/* JADX INFO: compiled from: AudioTagPayloadReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AudioTagPayloadReader extends TagPayloadReader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1171b = {5512, 11025, 22050, 44100};
    public boolean c;
    public boolean d;
    public int e;

    public AudioTagPayloadReader(TrackOutput2 trackOutput2) {
        super(trackOutput2);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(ParsableByteArray parsableByteArray) throws TagPayloadReader.UnsupportedFormatException {
        if (this.c) {
            parsableByteArray.F(1);
        } else {
            int iT = parsableByteArray.t();
            int i = (iT >> 4) & 15;
            this.e = i;
            if (i == 2) {
                int i2 = f1171b[(iT >> 2) & 3];
                Format2.b bVar = new Format2.b();
                bVar.k = "audio/mpeg";
                bVar.f1023x = 1;
                bVar.f1024y = i2;
                this.a.e(bVar.a());
                this.d = true;
            } else if (i == 7 || i == 8) {
                String str = i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw";
                Format2.b bVar2 = new Format2.b();
                bVar2.k = str;
                bVar2.f1023x = 1;
                bVar2.f1024y = 8000;
                this.a.e(bVar2.a());
                this.d = true;
            } else if (i != 10) {
                throw new TagPayloadReader.UnsupportedFormatException(outline.g(39, "Audio format not supported: ", this.e));
            }
            this.c = true;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(ParsableByteArray parsableByteArray, long j) throws ParserException {
        if (this.e == 2) {
            int iA = parsableByteArray.a();
            this.a.c(parsableByteArray, iA);
            this.a.d(j, 1, iA, 0, null);
            return true;
        }
        int iT = parsableByteArray.t();
        if (iT != 0 || this.d) {
            if (this.e == 10 && iT != 1) {
                return false;
            }
            int iA2 = parsableByteArray.a();
            this.a.c(parsableByteArray, iA2);
            this.a.d(j, 1, iA2, 0, null);
            return true;
        }
        int iA3 = parsableByteArray.a();
        byte[] bArr = new byte[iA3];
        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr, 0, iA3);
        parsableByteArray.f984b += iA3;
        AacUtil.b bVarB = AacUtil.b(new ParsableBitArray(bArr), false);
        Format2.b bVar = new Format2.b();
        bVar.k = "audio/mp4a-latm";
        bVar.h = bVarB.c;
        bVar.f1023x = bVarB.f1122b;
        bVar.f1024y = bVarB.a;
        bVar.m = Collections.singletonList(bArr);
        this.a.e(bVar.a());
        this.d = true;
        return false;
    }
}
