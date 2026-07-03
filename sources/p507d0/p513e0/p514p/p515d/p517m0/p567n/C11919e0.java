package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.e0 */
/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11919e0 {
    public static final boolean isError(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        AbstractC11932i1 abstractC11932i1Unwrap = abstractC11913c0.unwrap();
        return (abstractC11932i1Unwrap instanceof C12003s) || ((abstractC11932i1Unwrap instanceof AbstractC12009v) && (((AbstractC12009v) abstractC11932i1Unwrap).getDelegate() instanceof C12003s));
    }

    public static final boolean isNullable(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        return C11920e1.isNullableType(abstractC11913c0);
    }
}
