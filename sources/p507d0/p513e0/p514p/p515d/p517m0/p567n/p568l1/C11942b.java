package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12216a0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.b */
/* JADX INFO: compiled from: ClassicTypeCheckerContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11942b {
    public static final String access$errorMessage(Object obj) {
        StringBuilder sbM833U = C1643a.m833U("ClassicTypeCheckerContext couldn't handle ");
        sbM833U.append(C12216a0.getOrCreateKotlinClass(obj.getClass()));
        sbM833U.append(' ');
        sbM833U.append(obj);
        return sbM833U.toString();
    }
}
