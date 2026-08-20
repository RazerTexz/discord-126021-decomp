package p007b.p225i.p226a.p242c.p245b3.p254v;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import p007b.p225i.p226a.p242c.p245b3.AbstractC2582f;
import p007b.p225i.p226a.p242c.p245b3.C2578b;
import p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2757x;

/* JADX INFO: renamed from: b.i.a.c.b3.v.c */
/* JADX INFO: compiled from: Mp4WebvttDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2622c extends AbstractC2582f {

    /* JADX INFO: renamed from: n */
    public final C2757x f6108n;

    public C2622c() {
        super("Mp4WebvttDecoder");
        this.f6108n = new C2757x();
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.AbstractC2582f
    /* JADX INFO: renamed from: j */
    public InterfaceC2583g mo2617j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException {
        C2578b c2578bM2606a;
        C2757x c2757x = this.f6108n;
        c2757x.f6793a = bArr;
        c2757x.f6795c = i;
        c2757x.f6794b = 0;
        ArrayList arrayList = new ArrayList();
        while (this.f6108n.m3081a() > 0) {
            if (this.f6108n.m3081a() < 8) {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int iM3086f = this.f6108n.m3086f();
            if (this.f6108n.m3086f() == 1987343459) {
                C2757x c2757x2 = this.f6108n;
                int i2 = iM3086f - 8;
                CharSequence charSequenceM2715f = null;
                C2578b.b bVarM2718a = null;
                while (i2 > 0) {
                    if (i2 < 8) {
                        throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
                    }
                    int iM3086f2 = c2757x2.m3086f();
                    int iM3086f3 = c2757x2.m3086f();
                    int i3 = iM3086f2 - 8;
                    String strM3005m = C2738e0.m3005m(c2757x2.f6793a, c2757x2.f6794b, i3);
                    c2757x2.m3080F(i3);
                    i2 = (i2 - 8) - i3;
                    if (iM3086f3 == 1937011815) {
                        C2627h.e eVar = new C2627h.e();
                        C2627h.m2714e(strM3005m, eVar);
                        bVarM2718a = eVar.m2718a();
                    } else if (iM3086f3 == 1885436268) {
                        charSequenceM2715f = C2627h.m2715f(null, strM3005m.trim(), Collections.emptyList());
                    }
                }
                if (charSequenceM2715f == null) {
                    charSequenceM2715f = "";
                }
                if (bVarM2718a != null) {
                    bVarM2718a.f5773a = charSequenceM2715f;
                    c2578bM2606a = bVarM2718a.m2606a();
                } else {
                    Pattern pattern = C2627h.f6134a;
                    C2627h.e eVar2 = new C2627h.e();
                    eVar2.f6149c = charSequenceM2715f;
                    c2578bM2606a = eVar2.m2718a().m2606a();
                }
                arrayList.add(c2578bM2606a);
            } else {
                this.f6108n.m3080F(iM3086f - 8);
            }
        }
        return new C2623d(arrayList);
    }
}
