package b.i.a.c.x2.e0;

import b.i.a.c.f3.x;
import b.i.a.c.j1$b;
import b.i.a.c.t2.l;
import b.i.a.c.t2.l$b;
import b.i.a.c.x2.w;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader$UnsupportedFormatException;
import java.util.Collections;

/* JADX INFO: compiled from: AudioTagPayloadReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends TagPayloadReader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1171b = {5512, 11025, 22050, 44100};
    public boolean c;
    public boolean d;
    public int e;

    public b(w wVar) {
        super(wVar);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(x xVar) throws TagPayloadReader$UnsupportedFormatException {
        if (this.c) {
            xVar.F(1);
        } else {
            int iT = xVar.t();
            int i = (iT >> 4) & 15;
            this.e = i;
            if (i == 2) {
                int i2 = f1171b[(iT >> 2) & 3];
                j1$b j1_b = new j1$b();
                j1_b.k = "audio/mpeg";
                j1_b.f1023x = 1;
                j1_b.f1024y = i2;
                this.a.e(j1_b.a());
                this.d = true;
            } else if (i == 7 || i == 8) {
                String str = i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw";
                j1$b j1_b2 = new j1$b();
                j1_b2.k = str;
                j1_b2.f1023x = 1;
                j1_b2.f1024y = 8000;
                this.a.e(j1_b2.a());
                this.d = true;
            } else if (i != 10) {
                throw new TagPayloadReader$UnsupportedFormatException(b.d.b.a.a.g(39, "Audio format not supported: ", this.e));
            }
            this.c = true;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(x xVar, long j) throws ParserException {
        if (this.e == 2) {
            int iA = xVar.a();
            this.a.c(xVar, iA);
            this.a.d(j, 1, iA, 0, null);
            return true;
        }
        int iT = xVar.t();
        if (iT != 0 || this.d) {
            if (this.e == 10 && iT != 1) {
                return false;
            }
            int iA2 = xVar.a();
            this.a.c(xVar, iA2);
            this.a.d(j, 1, iA2, 0, null);
            return true;
        }
        int iA3 = xVar.a();
        byte[] bArr = new byte[iA3];
        System.arraycopy(xVar.a, xVar.f984b, bArr, 0, iA3);
        xVar.f984b += iA3;
        l$b l_bB = l.b(new b.i.a.c.f3.w(bArr), false);
        j1$b j1_b = new j1$b();
        j1_b.k = "audio/mp4a-latm";
        j1_b.h = l_bB.c;
        j1_b.f1023x = l_bB.f1122b;
        j1_b.f1024y = l_bB.a;
        j1_b.m = Collections.singletonList(bArr);
        this.a.e(j1_b.a());
        this.d = true;
        return false;
    }
}
