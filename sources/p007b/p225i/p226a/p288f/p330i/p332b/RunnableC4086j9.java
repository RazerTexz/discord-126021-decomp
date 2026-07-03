package p007b.p225i.p226a.p288f.p330i.p332b;

import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;

/* JADX INFO: renamed from: b.i.a.f.i.b.j9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4086j9 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C4174r9 f10864j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4097k9 f10865k;

    public RunnableC4086j9(C4097k9 c4097k9, C4174r9 c4174r9) {
        this.f10865k = c4097k9;
        this.f10864j = c4174r9;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        C4097k9 c4097k9 = this.f10865k;
        c4097k9.f10906k.mo5725f().mo5848b();
        C4040g c4040g = new C4040g(c4097k9);
        c4040g.m5685o();
        c4097k9.f10899d = c4040g;
        c4097k9.f10906k.f11260h.f10580c = c4097k9.f10897b;
        C4162q8 c4162q8 = new C4162q8(c4097k9);
        c4162q8.m5685o();
        c4097k9.f10905j = c4162q8;
        C3991ba c3991ba = new C3991ba(c4097k9);
        c3991ba.m5685o();
        c4097k9.f10902g = c3991ba;
        C4048g7 c4048g7 = new C4048g7(c4097k9);
        c4048g7.m5685o();
        c4097k9.f10904i = c4048g7;
        C4062h9 c4062h9 = new C4062h9(c4097k9);
        c4062h9.m5685o();
        c4097k9.f10901f = c4062h9;
        c4097k9.f10900e = new C3985b4(c4097k9);
        if (c4097k9.f10911p != c4097k9.f10912q) {
            c4097k9.f10906k.mo5726g().f11141f.m5862c("Not all upload components initialized", Integer.valueOf(c4097k9.f10911p), Integer.valueOf(c4097k9.f10912q));
        }
        c4097k9.f10907l = true;
        C4097k9 c4097k10 = this.f10865k;
        c4097k10.f10906k.mo5725f().mo5848b();
        c4097k10.m5710K().m5637i0();
        if (c4097k10.f10906k.m5946o().f10636f.m5648a() == 0) {
            C4057h4 c4057h4 = c4097k10.f10906k.m5946o().f10636f;
            Objects.requireNonNull((C3401c) c4097k10.f10906k.f11267o);
            c4057h4.m5649b(System.currentTimeMillis());
        }
        c4097k10.m5742w();
    }
}
