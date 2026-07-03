package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import kotlin.NoWhenBranchMatchedException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.g1 */
/* JADX INFO: compiled from: TypeWithEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11926g1 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final AbstractC11913c0 getEnhancement(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        if (abstractC11913c0 instanceof InterfaceC11923f1) {
            return ((InterfaceC11923f1) abstractC11913c0).getEnhancement();
        }
        return null;
    }

    public static final AbstractC11932i1 inheritEnhancement(AbstractC11932i1 abstractC11932i1, AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11932i1, "<this>");
        C12238m.checkNotNullParameter(abstractC11913c0, "origin");
        return wrapEnhancement(abstractC11932i1, getEnhancement(abstractC11913c0));
    }

    public static final AbstractC11913c0 unwrapEnhancement(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        AbstractC11913c0 enhancement = getEnhancement(abstractC11913c0);
        return enhancement == null ? abstractC11913c0 : enhancement;
    }

    public static final AbstractC11932i1 wrapEnhancement(AbstractC11932i1 abstractC11932i1, AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11932i1, "<this>");
        if (abstractC11913c0 == null) {
            return abstractC11932i1;
        }
        if (abstractC11932i1 instanceof AbstractC11934j0) {
            return new C11940l0((AbstractC11934j0) abstractC11932i1, abstractC11913c0);
        }
        if (abstractC11932i1 instanceof AbstractC12009v) {
            return new C12013x((AbstractC12009v) abstractC11932i1, abstractC11913c0);
        }
        throw new NoWhenBranchMatchedException();
    }
}
