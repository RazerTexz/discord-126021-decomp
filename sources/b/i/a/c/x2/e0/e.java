package b.i.a.c.x2.e0;

import b.i.a.c.f3.u;
import b.i.a.c.f3.x;
import b.i.a.c.g3.m;
import b.i.a.c.j1$b;
import b.i.a.c.x2.w;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader$UnsupportedFormatException;

/* JADX INFO: compiled from: VideoTagPayloadReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends TagPayloadReader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f1174b;
    public final x c;
    public int d;
    public boolean e;
    public boolean f;
    public int g;

    public e(w wVar) {
        super(wVar);
        this.f1174b = new x(u.a);
        this.c = new x(4);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(x xVar) throws TagPayloadReader$UnsupportedFormatException {
        int iT = xVar.t();
        int i = (iT >> 4) & 15;
        int i2 = iT & 15;
        if (i2 != 7) {
            throw new TagPayloadReader$UnsupportedFormatException(b.d.b.a.a.g(39, "Video format not supported: ", i2));
        }
        this.g = i;
        return i != 5;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(x xVar, long j) throws ParserException {
        int iT = xVar.t();
        byte[] bArr = xVar.a;
        int i = xVar.f984b;
        int i2 = i + 1;
        xVar.f984b = i2;
        int i3 = ((bArr[i] & 255) << 24) >> 8;
        int i4 = i2 + 1;
        xVar.f984b = i4;
        int i5 = i3 | ((bArr[i2] & 255) << 8);
        xVar.f984b = i4 + 1;
        long j2 = (((long) ((bArr[i4] & 255) | i5)) * 1000) + j;
        if (iT == 0 && !this.e) {
            x xVar2 = new x(new byte[xVar.a()]);
            xVar.e(xVar2.a, 0, xVar.a());
            m mVarB = m.b(xVar2);
            this.d = mVarB.f986b;
            j1$b j1_b = new j1$b();
            j1_b.k = "video/avc";
            j1_b.h = mVarB.f;
            j1_b.p = mVarB.c;
            j1_b.q = mVarB.d;
            j1_b.t = mVarB.e;
            j1_b.m = mVarB.a;
            this.a.e(j1_b.a());
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
        while (xVar.a() > 0) {
            xVar.e(this.c.a, i7, this.d);
            this.c.E(0);
            int iW = this.c.w();
            this.f1174b.E(0);
            this.a.c(this.f1174b, 4);
            this.a.c(xVar, iW);
            i8 = i8 + 4 + iW;
        }
        this.a.d(j2, i6, i8, 0, null);
        this.f = true;
        return true;
    }
}
