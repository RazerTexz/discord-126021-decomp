package p007b.p225i.p226a.p242c.p267x2.p270e0;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2754u;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p260g3.C2776m;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;

/* JADX INFO: renamed from: b.i.a.c.x2.e0.e */
/* JADX INFO: compiled from: VideoTagPayloadReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3016e extends TagPayloadReader {

    /* JADX INFO: renamed from: b */
    public final C2757x f8145b;

    /* JADX INFO: renamed from: c */
    public final C2757x f8146c;

    /* JADX INFO: renamed from: d */
    public int f8147d;

    /* JADX INFO: renamed from: e */
    public boolean f8148e;

    /* JADX INFO: renamed from: f */
    public boolean f8149f;

    /* JADX INFO: renamed from: g */
    public int f8150g;

    public C3016e(InterfaceC3122w interfaceC3122w) {
        super(interfaceC3122w);
        this.f8145b = new C2757x(C2754u.f6753a);
        this.f8146c = new C2757x(4);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    /* JADX INFO: renamed from: b */
    public boolean mo3657b(C2757x c2757x) throws TagPayloadReader.UnsupportedFormatException {
        int iM3100t = c2757x.m3100t();
        int i = (iM3100t >> 4) & 15;
        int i2 = iM3100t & 15;
        if (i2 != 7) {
            throw new TagPayloadReader.UnsupportedFormatException(C1643a.m851g(39, "Video format not supported: ", i2));
        }
        this.f8150g = i;
        return i != 5;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    /* JADX INFO: renamed from: c */
    public boolean mo3658c(C2757x c2757x, long j) throws ParserException {
        int iM3100t = c2757x.m3100t();
        byte[] bArr = c2757x.f6793a;
        int i = c2757x.f6794b;
        int i2 = i + 1;
        c2757x.f6794b = i2;
        int i3 = ((bArr[i] & 255) << 24) >> 8;
        int i4 = i2 + 1;
        c2757x.f6794b = i4;
        int i5 = i3 | ((bArr[i2] & 255) << 8);
        c2757x.f6794b = i4 + 1;
        long j2 = (((long) ((bArr[i4] & 255) | i5)) * 1000) + j;
        if (iM3100t == 0 && !this.f8148e) {
            C2757x c2757x2 = new C2757x(new byte[c2757x.m3081a()]);
            c2757x.m3085e(c2757x2.f6793a, 0, c2757x.m3081a());
            C2776m c2776mM3122b = C2776m.m3122b(c2757x2);
            this.f8147d = c2776mM3122b.f6838b;
            C2811j1.b bVar = new C2811j1.b();
            bVar.f7173k = "video/avc";
            bVar.f7170h = c2776mM3122b.f6842f;
            bVar.f7178p = c2776mM3122b.f6839c;
            bVar.f7179q = c2776mM3122b.f6840d;
            bVar.f7182t = c2776mM3122b.f6841e;
            bVar.f7175m = c2776mM3122b.f6837a;
            this.f19856a.mo2526e(bVar.m3277a());
            this.f8148e = true;
            return false;
        }
        if (iM3100t != 1 || !this.f8148e) {
            return false;
        }
        int i6 = this.f8150g == 1 ? 1 : 0;
        if (!this.f8149f && i6 == 0) {
            return false;
        }
        byte[] bArr2 = this.f8146c.f6793a;
        bArr2[0] = 0;
        bArr2[1] = 0;
        bArr2[2] = 0;
        int i7 = 4 - this.f8147d;
        int i8 = 0;
        while (c2757x.m3081a() > 0) {
            c2757x.m3085e(this.f8146c.f6793a, i7, this.f8147d);
            this.f8146c.m3079E(0);
            int iM3103w = this.f8146c.m3103w();
            this.f8145b.m3079E(0);
            this.f19856a.mo2524c(this.f8145b, 4);
            this.f19856a.mo2524c(c2757x, iM3103w);
            i8 = i8 + 4 + iM3103w;
        }
        this.f19856a.mo2525d(j2, i6, i8, 0, null);
        this.f8149f = true;
        return true;
    }
}
