package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.ArrayList;
import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.C11949i;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.m0 */
/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11968m0 {
    /* JADX INFO: renamed from: a */
    public static final AbstractC11934j0 m10019a(AbstractC11913c0 abstractC11913c0) {
        C11907a0 alternative;
        InterfaceC12008u0 constructor = abstractC11913c0.getConstructor();
        C11907a0 c11907a0 = constructor instanceof C11907a0 ? (C11907a0) constructor : null;
        if (c11907a0 == null) {
            return null;
        }
        Collection<AbstractC11913c0> supertypes = c11907a0.getSupertypes();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(supertypes, 10));
        boolean z2 = false;
        for (AbstractC11913c0 abstractC11913c0MakeDefinitelyNotNullOrNotNull$default : supertypes) {
            if (C11920e1.isNullableType(abstractC11913c0MakeDefinitelyNotNullOrNotNull$default)) {
                abstractC11913c0MakeDefinitelyNotNullOrNotNull$default = makeDefinitelyNotNullOrNotNull$default(abstractC11913c0MakeDefinitelyNotNullOrNotNull$default.unwrap(), false, 1, null);
                z2 = true;
            }
            arrayList.add(abstractC11913c0MakeDefinitelyNotNullOrNotNull$default);
        }
        if (z2) {
            AbstractC11913c0 alternativeType = c11907a0.getAlternativeType();
            if (alternativeType == null) {
                alternativeType = null;
            } else if (C11920e1.isNullableType(alternativeType)) {
                alternativeType = makeDefinitelyNotNullOrNotNull$default(alternativeType.unwrap(), false, 1, null);
            }
            alternative = new C11907a0(arrayList).setAlternative(alternativeType);
        } else {
            alternative = null;
        }
        if (alternative == null) {
            return null;
        }
        return alternative.createType();
    }

    public static final C11906a getAbbreviatedType(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        AbstractC11932i1 abstractC11932i1Unwrap = abstractC11913c0.unwrap();
        if (abstractC11932i1Unwrap instanceof C11906a) {
            return (C11906a) abstractC11932i1Unwrap;
        }
        return null;
    }

    public static final AbstractC11934j0 getAbbreviation(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        C11906a abbreviatedType = getAbbreviatedType(abstractC11913c0);
        if (abbreviatedType == null) {
            return null;
        }
        return abbreviatedType.getAbbreviation();
    }

    public static final boolean isDefinitelyNotNullType(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        return abstractC11913c0.unwrap() instanceof C11936k;
    }

    public static final AbstractC11932i1 makeDefinitelyNotNullOrNotNull(AbstractC11932i1 abstractC11932i1, boolean z2) {
        C12238m.checkNotNullParameter(abstractC11932i1, "<this>");
        C11936k c11936kMakeDefinitelyNotNull$descriptors = C11936k.f24788k.makeDefinitelyNotNull$descriptors(abstractC11932i1, z2);
        if (c11936kMakeDefinitelyNotNull$descriptors != null) {
            return c11936kMakeDefinitelyNotNull$descriptors;
        }
        AbstractC11934j0 abstractC11934j0M10019a = m10019a(abstractC11932i1);
        return abstractC11934j0M10019a == null ? abstractC11932i1.makeNullableAsSpecified(false) : abstractC11934j0M10019a;
    }

    public static /* synthetic */ AbstractC11932i1 makeDefinitelyNotNullOrNotNull$default(AbstractC11932i1 abstractC11932i1, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return makeDefinitelyNotNullOrNotNull(abstractC11932i1, z2);
    }

    public static final AbstractC11934j0 makeSimpleTypeDefinitelyNotNullOrNotNull(AbstractC11934j0 abstractC11934j0, boolean z2) {
        C12238m.checkNotNullParameter(abstractC11934j0, "<this>");
        C11936k c11936kMakeDefinitelyNotNull$descriptors = C11936k.f24788k.makeDefinitelyNotNull$descriptors(abstractC11934j0, z2);
        if (c11936kMakeDefinitelyNotNull$descriptors != null) {
            return c11936kMakeDefinitelyNotNull$descriptors;
        }
        AbstractC11934j0 abstractC11934j0M10019a = m10019a(abstractC11934j0);
        return abstractC11934j0M10019a == null ? abstractC11934j0.makeNullableAsSpecified(false) : abstractC11934j0M10019a;
    }

    public static /* synthetic */ AbstractC11934j0 makeSimpleTypeDefinitelyNotNullOrNotNull$default(AbstractC11934j0 abstractC11934j0, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return makeSimpleTypeDefinitelyNotNullOrNotNull(abstractC11934j0, z2);
    }

    public static final AbstractC11934j0 withAbbreviation(AbstractC11934j0 abstractC11934j0, AbstractC11934j0 abstractC11934j1) {
        C12238m.checkNotNullParameter(abstractC11934j0, "<this>");
        C12238m.checkNotNullParameter(abstractC11934j1, "abbreviatedType");
        return C11919e0.isError(abstractC11934j0) ? abstractC11934j0 : new C11906a(abstractC11934j0, abstractC11934j1);
    }

    public static final C11949i withNotNullProjection(C11949i c11949i) {
        C12238m.checkNotNullParameter(c11949i, "<this>");
        return new C11949i(c11949i.getCaptureStatus(), c11949i.getConstructor(), c11949i.getLowerType(), c11949i.getAnnotations(), c11949i.isMarkedNullable(), true);
    }
}
