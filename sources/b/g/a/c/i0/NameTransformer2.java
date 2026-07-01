package b.g.a.c.i0;

import b.d.b.a.outline;

/* JADX INFO: renamed from: b.g.a.c.i0.l, reason: use source file name */
/* JADX INFO: compiled from: NameTransformer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class NameTransformer2 extends NameTransformer4 {
    public final /* synthetic */ String k;

    public NameTransformer2(String str) {
        this.k = str;
    }

    @Override // b.g.a.c.i0.NameTransformer4
    public String a(String str) {
        return outline.J(new StringBuilder(), this.k, str);
    }

    public String toString() {
        return outline.J(outline.U("[PrefixTransformer('"), this.k, "')]");
    }
}
