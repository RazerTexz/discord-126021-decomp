package b.g.a.c.i0;

import b.d.b.a.outline;

/* JADX INFO: renamed from: b.g.a.c.i0.k, reason: use source file name */
/* JADX INFO: compiled from: NameTransformer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class NameTransformer extends NameTransformer4 {
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;

    public NameTransformer(String str, String str2) {
        this.k = str;
        this.l = str2;
    }

    @Override // b.g.a.c.i0.NameTransformer4
    public String a(String str) {
        return this.k + str + this.l;
    }

    public String toString() {
        StringBuilder sbU = outline.U("[PreAndSuffixTransformer('");
        sbU.append(this.k);
        sbU.append("','");
        return outline.J(sbU, this.l, "')]");
    }
}
