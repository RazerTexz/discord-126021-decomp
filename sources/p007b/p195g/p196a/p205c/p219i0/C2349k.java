package p007b.p195g.p196a.p205c.p219i0;

import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.g.a.c.i0.k */
/* JADX INFO: compiled from: NameTransformer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2349k extends AbstractC2352n {

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f4957k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ String f4958l;

    public C2349k(String str, String str2) {
        this.f4957k = str;
        this.f4958l = str2;
    }

    @Override // p007b.p195g.p196a.p205c.p219i0.AbstractC2352n
    /* JADX INFO: renamed from: a */
    public String mo2202a(String str) {
        return this.f4957k + str + this.f4958l;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("[PreAndSuffixTransformer('");
        sbM833U.append(this.f4957k);
        sbM833U.append("','");
        return C1643a.m822J(sbM833U, this.f4958l, "')]");
    }
}
