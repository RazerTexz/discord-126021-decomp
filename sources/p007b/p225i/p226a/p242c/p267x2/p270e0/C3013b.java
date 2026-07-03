package p007b.p225i.p226a.p242c.p267x2.p270e0;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import java.util.Collections;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2756w;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p263t2.C2928l;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;

/* JADX INFO: renamed from: b.i.a.c.x2.e0.b */
/* JADX INFO: compiled from: AudioTagPayloadReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3013b extends TagPayloadReader {

    /* JADX INFO: renamed from: b */
    public static final int[] f8122b = {5512, 11025, 22050, 44100};

    /* JADX INFO: renamed from: c */
    public boolean f8123c;

    /* JADX INFO: renamed from: d */
    public boolean f8124d;

    /* JADX INFO: renamed from: e */
    public int f8125e;

    public C3013b(InterfaceC3122w interfaceC3122w) {
        super(interfaceC3122w);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    /* JADX INFO: renamed from: b */
    public boolean mo3657b(C2757x c2757x) throws TagPayloadReader.UnsupportedFormatException {
        if (this.f8123c) {
            c2757x.m3080F(1);
        } else {
            int iM3100t = c2757x.m3100t();
            int i = (iM3100t >> 4) & 15;
            this.f8125e = i;
            if (i == 2) {
                int i2 = f8122b[(iM3100t >> 2) & 3];
                C2811j1.b bVar = new C2811j1.b();
                bVar.f7173k = "audio/mpeg";
                bVar.f7186x = 1;
                bVar.f7187y = i2;
                this.f19856a.mo2526e(bVar.m3277a());
                this.f8124d = true;
            } else if (i == 7 || i == 8) {
                String str = i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw";
                C2811j1.b bVar2 = new C2811j1.b();
                bVar2.f7173k = str;
                bVar2.f7186x = 1;
                bVar2.f7187y = 8000;
                this.f19856a.mo2526e(bVar2.m3277a());
                this.f8124d = true;
            } else if (i != 10) {
                throw new TagPayloadReader.UnsupportedFormatException(C1643a.m851g(39, "Audio format not supported: ", this.f8125e));
            }
            this.f8123c = true;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    /* JADX INFO: renamed from: c */
    public boolean mo3658c(C2757x c2757x, long j) throws ParserException {
        if (this.f8125e == 2) {
            int iM3081a = c2757x.m3081a();
            this.f19856a.mo2524c(c2757x, iM3081a);
            this.f19856a.mo2525d(j, 1, iM3081a, 0, null);
            return true;
        }
        int iM3100t = c2757x.m3100t();
        if (iM3100t != 0 || this.f8124d) {
            if (this.f8125e == 10 && iM3100t != 1) {
                return false;
            }
            int iM3081a2 = c2757x.m3081a();
            this.f19856a.mo2524c(c2757x, iM3081a2);
            this.f19856a.mo2525d(j, 1, iM3081a2, 0, null);
            return true;
        }
        int iM3081a3 = c2757x.m3081a();
        byte[] bArr = new byte[iM3081a3];
        System.arraycopy(c2757x.f6793a, c2757x.f6794b, bArr, 0, iM3081a3);
        c2757x.f6794b += iM3081a3;
        C2928l.b bVarM3489b = C2928l.m3489b(new C2756w(bArr), false);
        C2811j1.b bVar = new C2811j1.b();
        bVar.f7173k = "audio/mp4a-latm";
        bVar.f7170h = bVarM3489b.f7768c;
        bVar.f7186x = bVarM3489b.f7767b;
        bVar.f7187y = bVarM3489b.f7766a;
        bVar.f7175m = Collections.singletonList(bArr);
        this.f19856a.mo2526e(bVar.m3277a());
        this.f8124d = true;
        return false;
    }
}
