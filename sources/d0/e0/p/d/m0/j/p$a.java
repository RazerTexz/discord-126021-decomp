package d0.e0.p.d.m0.j;

import d0.g0.t;

/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p$a extends p {
    public p$a(String str, int i) {
        super(str, i, null);
    }

    @Override // d0.e0.p.d.m0.j.p
    public String escape(String str) {
        d0.z.d.m.checkNotNullParameter(str, "string");
        return t.replace$default(t.replace$default(str, "<", "&lt;", false, 4, (Object) null), ">", "&gt;", false, 4, (Object) null);
    }
}
