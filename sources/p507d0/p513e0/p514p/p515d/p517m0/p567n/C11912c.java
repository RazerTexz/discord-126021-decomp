package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11921f;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11974c;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11980i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11983l;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.c */
/* JADX INFO: compiled from: AbstractTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11912c {

    /* JADX INFO: renamed from: a */
    public static final C11912c f24743a = new C11912c();

    /* JADX INFO: renamed from: a */
    public final boolean m9997a(AbstractC11921f abstractC11921f, InterfaceC11980i interfaceC11980i, InterfaceC11983l interfaceC11983l) {
        if (abstractC11921f.isNothing(interfaceC11980i)) {
            return true;
        }
        if (abstractC11921f.isMarkedNullable(interfaceC11980i)) {
            return false;
        }
        if (abstractC11921f.isStubTypeEqualsToAnything() && abstractC11921f.isStubType(interfaceC11980i)) {
            return true;
        }
        return abstractC11921f.areEqualTypeConstructors(abstractC11921f.typeConstructor(interfaceC11980i), interfaceC11983l);
    }

    public final boolean hasNotNullSupertype(AbstractC11921f abstractC11921f, InterfaceC11980i interfaceC11980i, AbstractC11921f.b bVar) {
        C12238m.checkNotNullParameter(abstractC11921f, "<this>");
        C12238m.checkNotNullParameter(interfaceC11980i, "type");
        C12238m.checkNotNullParameter(bVar, "supertypesPolicy");
        if (!((abstractC11921f.isClassType(interfaceC11980i) && !abstractC11921f.isMarkedNullable(interfaceC11980i)) || abstractC11921f.isDefinitelyNotNullType(interfaceC11980i))) {
            abstractC11921f.initialize();
            ArrayDeque<InterfaceC11980i> supertypesDeque = abstractC11921f.getSupertypesDeque();
            C12238m.checkNotNull(supertypesDeque);
            Set<InterfaceC11980i> supertypesSet = abstractC11921f.getSupertypesSet();
            C12238m.checkNotNull(supertypesSet);
            supertypesDeque.push(interfaceC11980i);
            while (!supertypesDeque.isEmpty()) {
                if (supertypesSet.size() > 1000) {
                    StringBuilder sbM838Z = C1643a.m838Z("Too many supertypes for type: ", interfaceC11980i, ". Supertypes = ");
                    sbM838Z.append(C12163u.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                    throw new IllegalStateException(sbM838Z.toString().toString());
                }
                InterfaceC11980i interfaceC11980iPop = supertypesDeque.pop();
                C12238m.checkNotNullExpressionValue(interfaceC11980iPop, "current");
                if (supertypesSet.add(interfaceC11980iPop)) {
                    AbstractC11921f.b bVar2 = abstractC11921f.isMarkedNullable(interfaceC11980iPop) ? AbstractC11921f.b.c.f24767a : bVar;
                    if (!(!C12238m.areEqual(bVar2, AbstractC11921f.b.c.f24767a))) {
                        bVar2 = null;
                    }
                    if (bVar2 == null) {
                        continue;
                    } else {
                        Iterator<InterfaceC11979h> it = abstractC11921f.supertypes(abstractC11921f.typeConstructor(interfaceC11980iPop)).iterator();
                        while (it.hasNext()) {
                            InterfaceC11980i interfaceC11980iTransformType = bVar2.transformType(abstractC11921f, it.next());
                            if ((abstractC11921f.isClassType(interfaceC11980iTransformType) && !abstractC11921f.isMarkedNullable(interfaceC11980iTransformType)) || abstractC11921f.isDefinitelyNotNullType(interfaceC11980iTransformType)) {
                                abstractC11921f.clear();
                            } else {
                                supertypesDeque.add(interfaceC11980iTransformType);
                            }
                        }
                    }
                }
            }
            abstractC11921f.clear();
            return false;
        }
        return true;
    }

    public final boolean hasPathByNotMarkedNullableNodes(AbstractC11921f abstractC11921f, InterfaceC11980i interfaceC11980i, InterfaceC11983l interfaceC11983l) {
        C12238m.checkNotNullParameter(abstractC11921f, "<this>");
        C12238m.checkNotNullParameter(interfaceC11980i, "start");
        C12238m.checkNotNullParameter(interfaceC11983l, "end");
        if (m9997a(abstractC11921f, interfaceC11980i, interfaceC11983l)) {
            return true;
        }
        abstractC11921f.initialize();
        ArrayDeque<InterfaceC11980i> supertypesDeque = abstractC11921f.getSupertypesDeque();
        C12238m.checkNotNull(supertypesDeque);
        Set<InterfaceC11980i> supertypesSet = abstractC11921f.getSupertypesSet();
        C12238m.checkNotNull(supertypesSet);
        supertypesDeque.push(interfaceC11980i);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() > 1000) {
                StringBuilder sbM838Z = C1643a.m838Z("Too many supertypes for type: ", interfaceC11980i, ". Supertypes = ");
                sbM838Z.append(C12163u.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                throw new IllegalStateException(sbM838Z.toString().toString());
            }
            InterfaceC11980i interfaceC11980iPop = supertypesDeque.pop();
            C12238m.checkNotNullExpressionValue(interfaceC11980iPop, "current");
            if (supertypesSet.add(interfaceC11980iPop)) {
                AbstractC11921f.b bVar = abstractC11921f.isMarkedNullable(interfaceC11980iPop) ? AbstractC11921f.b.c.f24767a : AbstractC11921f.b.C13335b.f24766a;
                if (!(!C12238m.areEqual(bVar, AbstractC11921f.b.c.f24767a))) {
                    bVar = null;
                }
                if (bVar == null) {
                    continue;
                } else {
                    Iterator<InterfaceC11979h> it = abstractC11921f.supertypes(abstractC11921f.typeConstructor(interfaceC11980iPop)).iterator();
                    while (it.hasNext()) {
                        InterfaceC11980i interfaceC11980iTransformType = bVar.transformType(abstractC11921f, it.next());
                        if (m9997a(abstractC11921f, interfaceC11980iTransformType, interfaceC11983l)) {
                            abstractC11921f.clear();
                            return true;
                        }
                        supertypesDeque.add(interfaceC11980iTransformType);
                    }
                }
            }
        }
        abstractC11921f.clear();
        return false;
    }

    public final boolean isPossibleSubtype(AbstractC11921f abstractC11921f, InterfaceC11980i interfaceC11980i, InterfaceC11980i interfaceC11980i2) {
        C12238m.checkNotNullParameter(abstractC11921f, "context");
        C12238m.checkNotNullParameter(interfaceC11980i, "subType");
        C12238m.checkNotNullParameter(interfaceC11980i2, "superType");
        if (abstractC11921f.isMarkedNullable(interfaceC11980i2) || abstractC11921f.isDefinitelyNotNullType(interfaceC11980i)) {
            return true;
        }
        if (((interfaceC11980i instanceof InterfaceC11974c) && abstractC11921f.isProjectionNotNull((InterfaceC11974c) interfaceC11980i)) || hasNotNullSupertype(abstractC11921f, interfaceC11980i, AbstractC11921f.b.C13335b.f24766a)) {
            return true;
        }
        if (abstractC11921f.isDefinitelyNotNullType(interfaceC11980i2) || hasNotNullSupertype(abstractC11921f, interfaceC11980i2, AbstractC11921f.b.d.f24768a) || abstractC11921f.isClassType(interfaceC11980i)) {
            return false;
        }
        return hasPathByNotMarkedNullableNodes(abstractC11921f, interfaceC11980i, abstractC11921f.typeConstructor(interfaceC11980i2));
    }
}
