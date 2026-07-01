package b.g.a.c.i0;

import b.d.b.a.outline;

/* JADX INFO: renamed from: b.g.a.c.i0.m, reason: use source file name */
/* JADX INFO: compiled from: NameTransformer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class NameTransformer3 extends NameTransformer4 {
    public final /* synthetic */ String k;

    public NameTransformer3(String str) {
        this.k = str;
    }

    @Override // b.g.a.c.i0.NameTransformer4
    public String a(String str) {
        StringBuilder sbU = outline.U(str);
        sbU.append(this.k);
        return sbU.toString();
    }

    public String toString() {
        return outline.J(outline.U("[SuffixTransformer('"), this.k, "')]");
    }
}
