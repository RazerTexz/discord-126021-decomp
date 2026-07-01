package d0.e0.p.d.m0.n.l1;

import d0.z.d.a0;

/* JADX INFO: compiled from: ClassicTypeCheckerContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final String access$errorMessage(Object obj) {
        StringBuilder sbU = b.d.b.a.a.U("ClassicTypeCheckerContext couldn't handle ");
        sbU.append(a0.getOrCreateKotlinClass(obj.getClass()));
        sbU.append(' ');
        sbU.append(obj);
        return sbU.toString();
    }
}
