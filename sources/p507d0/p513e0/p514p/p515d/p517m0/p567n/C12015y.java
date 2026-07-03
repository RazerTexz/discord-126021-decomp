package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import kotlin.NoWhenBranchMatchedException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.y */
/* JADX INFO: compiled from: flexibleTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12015y {
    public static final AbstractC12009v asFlexibleType(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        return (AbstractC12009v) abstractC11913c0.unwrap();
    }

    public static final boolean isFlexible(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        return abstractC11913c0.unwrap() instanceof AbstractC12009v;
    }

    public static final AbstractC11934j0 lowerIfFlexible(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        AbstractC11932i1 abstractC11932i1Unwrap = abstractC11913c0.unwrap();
        if (abstractC11932i1Unwrap instanceof AbstractC12009v) {
            return ((AbstractC12009v) abstractC11932i1Unwrap).getLowerBound();
        }
        if (abstractC11932i1Unwrap instanceof AbstractC11934j0) {
            return (AbstractC11934j0) abstractC11932i1Unwrap;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final AbstractC11934j0 upperIfFlexible(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        AbstractC11932i1 abstractC11932i1Unwrap = abstractC11913c0.unwrap();
        if (abstractC11932i1Unwrap instanceof AbstractC12009v) {
            return ((AbstractC12009v) abstractC11932i1Unwrap).getUpperBound();
        }
        if (abstractC11932i1Unwrap instanceof AbstractC11934j0) {
            return (AbstractC11934j0) abstractC11932i1Unwrap;
        }
        throw new NoWhenBranchMatchedException();
    }
}
