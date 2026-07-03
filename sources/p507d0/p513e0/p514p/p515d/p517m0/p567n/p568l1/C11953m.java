package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11793k;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a.C11805c;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11825q;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12009v;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11907a0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11916d0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11918e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11920e1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11926g1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.EnumC11973b;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.m */
/* JADX INFO: compiled from: NewKotlinTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11953m implements InterfaceC11952l {

    /* JADX INFO: renamed from: c */
    public final AbstractC11947g f24823c;

    /* JADX INFO: renamed from: d */
    public final C11793k f24824d;

    public C11953m(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        this.f24823c = abstractC11947g;
        C11793k c11793kCreateWithTypeRefiner = C11793k.createWithTypeRefiner(getKotlinTypeRefiner());
        C12238m.checkNotNullExpressionValue(c11793kCreateWithTypeRefiner, "createWithTypeRefiner(kotlinTypeRefiner)");
        this.f24824d = c11793kCreateWithTypeRefiner;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11946f
    public boolean equalTypes(AbstractC11913c0 abstractC11913c0, AbstractC11913c0 abstractC11913c1) {
        C12238m.checkNotNullParameter(abstractC11913c0, "a");
        C12238m.checkNotNullParameter(abstractC11913c1, "b");
        return equalTypes(new C11941a(false, false, false, getKotlinTypeRefiner(), 6, null), abstractC11913c0.unwrap(), abstractC11913c1.unwrap());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11952l
    public AbstractC11947g getKotlinTypeRefiner() {
        return this.f24823c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11952l
    public C11793k getOverridingUtil() {
        return this.f24824d;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11946f
    public boolean isSubtypeOf(AbstractC11913c0 abstractC11913c0, AbstractC11913c0 abstractC11913c1) {
        C12238m.checkNotNullParameter(abstractC11913c0, "subtype");
        C12238m.checkNotNullParameter(abstractC11913c1, "supertype");
        return isSubtypeOf(new C11941a(true, false, false, getKotlinTypeRefiner(), 6, null), abstractC11913c0.unwrap(), abstractC11913c1.unwrap());
    }

    public final AbstractC11934j0 transformToNewType(AbstractC11934j0 abstractC11934j0) {
        AbstractC11913c0 type;
        C12238m.checkNotNullParameter(abstractC11934j0, "type");
        InterfaceC12008u0 constructor = abstractC11934j0.getConstructor();
        boolean z2 = false;
        C11907a0 alternative = null;
        abstractC11932i1Unwrap = null;
        AbstractC11932i1 abstractC11932i1Unwrap = null;
        if (constructor instanceof C11805c) {
            C11805c c11805c = (C11805c) constructor;
            InterfaceC12012w0 projection = c11805c.getProjection();
            if (!(projection.getProjectionKind() == EnumC11935j1.IN_VARIANCE)) {
                projection = null;
            }
            if (projection != null && (type = projection.getType()) != null) {
                abstractC11932i1Unwrap = type.unwrap();
            }
            AbstractC11932i1 abstractC11932i1 = abstractC11932i1Unwrap;
            if (c11805c.getNewTypeConstructor() == null) {
                InterfaceC12012w0 projection2 = c11805c.getProjection();
                Collection<AbstractC11913c0> supertypes = c11805c.getSupertypes();
                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(supertypes, 10));
                Iterator<T> it = supertypes.iterator();
                while (it.hasNext()) {
                    arrayList.add(((AbstractC11913c0) it.next()).unwrap());
                }
                c11805c.setNewTypeConstructor(new C11950j(projection2, arrayList, null, 4, null));
            }
            EnumC11973b enumC11973b = EnumC11973b.FOR_SUBTYPING;
            C11950j newTypeConstructor = c11805c.getNewTypeConstructor();
            C12238m.checkNotNull(newTypeConstructor);
            return new C11949i(enumC11973b, newTypeConstructor, abstractC11932i1, abstractC11934j0.getAnnotations(), abstractC11934j0.isMarkedNullable(), false, 32, null);
        }
        if (constructor instanceof C11825q) {
            Collection<AbstractC11913c0> supertypes2 = ((C11825q) constructor).getSupertypes();
            ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(supertypes2, 10));
            Iterator<T> it2 = supertypes2.iterator();
            while (it2.hasNext()) {
                AbstractC11913c0 abstractC11913c0MakeNullableAsSpecified = C11920e1.makeNullableAsSpecified((AbstractC11913c0) it2.next(), abstractC11934j0.isMarkedNullable());
                C12238m.checkNotNullExpressionValue(abstractC11913c0MakeNullableAsSpecified, "makeNullableAsSpecified(it, type.isMarkedNullable)");
                arrayList2.add(abstractC11913c0MakeNullableAsSpecified);
            }
            C11907a0 c11907a0 = new C11907a0(arrayList2);
            C11916d0 c11916d0 = C11916d0.f24748a;
            return C11916d0.simpleTypeWithNonTrivialMemberScope(abstractC11934j0.getAnnotations(), c11907a0, C12147n.emptyList(), false, abstractC11934j0.getMemberScope());
        }
        if (!(constructor instanceof C11907a0) || !abstractC11934j0.isMarkedNullable()) {
            return abstractC11934j0;
        }
        C11907a0 c11907a1 = (C11907a0) constructor;
        Collection<AbstractC11913c0> supertypes3 = c11907a1.getSupertypes();
        ArrayList arrayList3 = new ArrayList(C12149o.collectionSizeOrDefault(supertypes3, 10));
        Iterator<T> it3 = supertypes3.iterator();
        while (it3.hasNext()) {
            arrayList3.add(C11992a.makeNullable((AbstractC11913c0) it3.next()));
            z2 = true;
        }
        if (z2) {
            AbstractC11913c0 alternativeType = c11907a1.getAlternativeType();
            alternative = new C11907a0(arrayList3).setAlternative(alternativeType != null ? C11992a.makeNullable(alternativeType) : null);
        }
        if (alternative != null) {
            c11907a1 = alternative;
        }
        return c11907a1.createType();
    }

    public final boolean equalTypes(C11941a c11941a, AbstractC11932i1 abstractC11932i1, AbstractC11932i1 abstractC11932i2) {
        C12238m.checkNotNullParameter(c11941a, "<this>");
        C12238m.checkNotNullParameter(abstractC11932i1, "a");
        C12238m.checkNotNullParameter(abstractC11932i2, "b");
        return C11918e.f24752a.equalTypes(c11941a, abstractC11932i1, abstractC11932i2);
    }

    public final boolean isSubtypeOf(C11941a c11941a, AbstractC11932i1 abstractC11932i1, AbstractC11932i1 abstractC11932i2) {
        C12238m.checkNotNullParameter(c11941a, "<this>");
        C12238m.checkNotNullParameter(abstractC11932i1, "subType");
        C12238m.checkNotNullParameter(abstractC11932i2, "superType");
        return C11918e.isSubtypeOf$default(C11918e.f24752a, c11941a, abstractC11932i1, abstractC11932i2, false, 8, null);
    }

    public AbstractC11932i1 transformToNewType(AbstractC11932i1 abstractC11932i1) {
        AbstractC11932i1 abstractC11932i1FlexibleType;
        C12238m.checkNotNullParameter(abstractC11932i1, "type");
        if (abstractC11932i1 instanceof AbstractC11934j0) {
            abstractC11932i1FlexibleType = transformToNewType((AbstractC11934j0) abstractC11932i1);
        } else if (abstractC11932i1 instanceof AbstractC12009v) {
            AbstractC12009v abstractC12009v = (AbstractC12009v) abstractC11932i1;
            AbstractC11934j0 abstractC11934j0TransformToNewType = transformToNewType(abstractC12009v.getLowerBound());
            AbstractC11934j0 abstractC11934j0TransformToNewType2 = transformToNewType(abstractC12009v.getUpperBound());
            if (abstractC11934j0TransformToNewType == abstractC12009v.getLowerBound() && abstractC11934j0TransformToNewType2 == abstractC12009v.getUpperBound()) {
                abstractC11932i1FlexibleType = abstractC11932i1;
            } else {
                C11916d0 c11916d0 = C11916d0.f24748a;
                abstractC11932i1FlexibleType = C11916d0.flexibleType(abstractC11934j0TransformToNewType, abstractC11934j0TransformToNewType2);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return C11926g1.inheritEnhancement(abstractC11932i1FlexibleType, abstractC11932i1);
    }
}
