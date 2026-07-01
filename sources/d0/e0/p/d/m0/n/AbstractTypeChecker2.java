package d0.e0.p.d.m0.n;

import b.d.b.a.outline;
import d0.e0.p.d.m0.n.AbstractTypeChecker3;
import d0.e0.p.d.m0.p.SmartList;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.MutableCollections;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.e, reason: use source file name */
/* JADX INFO: compiled from: AbstractTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AbstractTypeChecker2 {
    public static final AbstractTypeChecker2 a = new AbstractTypeChecker2();

    public static final boolean a(AbstractTypeChecker3 abstractTypeChecker3, AbstractTypeChecker2 abstractTypeChecker2, d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.i iVar2, boolean z2) {
        Collection<d0.e0.p.d.m0.n.n1.h> collectionPossibleIntegerTypes = abstractTypeChecker3.possibleIntegerTypes(iVar);
        if ((collectionPossibleIntegerTypes instanceof Collection) && collectionPossibleIntegerTypes.isEmpty()) {
            return false;
        }
        for (d0.e0.p.d.m0.n.n1.h hVar : collectionPossibleIntegerTypes) {
            if (Intrinsics3.areEqual(abstractTypeChecker3.typeConstructor(hVar), abstractTypeChecker3.typeConstructor(iVar2)) || (z2 && isSubtypeOf$default(abstractTypeChecker2, abstractTypeChecker3, iVar2, hVar, false, 8, null))) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isSubtypeOf$default(AbstractTypeChecker2 abstractTypeChecker2, AbstractTypeChecker3 abstractTypeChecker3, d0.e0.p.d.m0.n.n1.h hVar, d0.e0.p.d.m0.n.n1.h hVar2, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = false;
        }
        return abstractTypeChecker2.isSubtypeOf(abstractTypeChecker3, hVar, hVar2, z2);
    }

    public final List<d0.e0.p.d.m0.n.n1.i> b(AbstractTypeChecker3 abstractTypeChecker3, d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.l lVar) {
        AbstractTypeChecker3.b bVarSubstitutionSupertypePolicy;
        d0.e0.p.d.m0.n.n1.b bVar = d0.e0.p.d.m0.n.n1.b.FOR_SUBTYPING;
        List<d0.e0.p.d.m0.n.n1.i> listFastCorrespondingSupertypes = abstractTypeChecker3.fastCorrespondingSupertypes(iVar, lVar);
        if (listFastCorrespondingSupertypes == null) {
            if (!abstractTypeChecker3.isClassTypeConstructor(lVar) && abstractTypeChecker3.isClassType(iVar)) {
                return Collections2.emptyList();
            }
            if (abstractTypeChecker3.isCommonFinalClassConstructor(lVar)) {
                if (!abstractTypeChecker3.areEqualTypeConstructors(abstractTypeChecker3.typeConstructor(iVar), lVar)) {
                    return Collections2.emptyList();
                }
                d0.e0.p.d.m0.n.n1.i iVarCaptureFromArguments = abstractTypeChecker3.captureFromArguments(iVar, bVar);
                if (iVarCaptureFromArguments != null) {
                    iVar = iVarCaptureFromArguments;
                }
                return CollectionsJVM.listOf(iVar);
            }
            listFastCorrespondingSupertypes = new SmartList<>();
            abstractTypeChecker3.initialize();
            ArrayDeque<d0.e0.p.d.m0.n.n1.i> supertypesDeque = abstractTypeChecker3.getSupertypesDeque();
            Intrinsics3.checkNotNull(supertypesDeque);
            Set<d0.e0.p.d.m0.n.n1.i> supertypesSet = abstractTypeChecker3.getSupertypesSet();
            Intrinsics3.checkNotNull(supertypesSet);
            supertypesDeque.push(iVar);
            while (!supertypesDeque.isEmpty()) {
                if (supertypesSet.size() > 1000) {
                    StringBuilder sbZ = outline.Z("Too many supertypes for type: ", iVar, ". Supertypes = ");
                    sbZ.append(_Collections.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                    throw new IllegalStateException(sbZ.toString().toString());
                }
                d0.e0.p.d.m0.n.n1.i iVarPop = supertypesDeque.pop();
                Intrinsics3.checkNotNullExpressionValue(iVarPop, "current");
                if (supertypesSet.add(iVarPop)) {
                    d0.e0.p.d.m0.n.n1.i iVarCaptureFromArguments2 = abstractTypeChecker3.captureFromArguments(iVarPop, bVar);
                    if (iVarCaptureFromArguments2 == null) {
                        iVarCaptureFromArguments2 = iVarPop;
                    }
                    if (abstractTypeChecker3.areEqualTypeConstructors(abstractTypeChecker3.typeConstructor(iVarCaptureFromArguments2), lVar)) {
                        listFastCorrespondingSupertypes.add(iVarCaptureFromArguments2);
                        bVarSubstitutionSupertypePolicy = AbstractTypeChecker3.b.c.a;
                    } else {
                        bVarSubstitutionSupertypePolicy = abstractTypeChecker3.argumentsCount(iVarCaptureFromArguments2) == 0 ? AbstractTypeChecker3.b.C0411b.a : abstractTypeChecker3.substitutionSupertypePolicy(iVarCaptureFromArguments2);
                    }
                    if (!(!Intrinsics3.areEqual(bVarSubstitutionSupertypePolicy, AbstractTypeChecker3.b.c.a))) {
                        bVarSubstitutionSupertypePolicy = null;
                    }
                    if (bVarSubstitutionSupertypePolicy != null) {
                        Iterator<d0.e0.p.d.m0.n.n1.h> it = abstractTypeChecker3.supertypes(abstractTypeChecker3.typeConstructor(iVarPop)).iterator();
                        while (it.hasNext()) {
                            supertypesDeque.add(bVarSubstitutionSupertypePolicy.transformType(abstractTypeChecker3, it.next()));
                        }
                    }
                }
            }
            abstractTypeChecker3.clear();
        }
        return listFastCorrespondingSupertypes;
    }

    public final List<d0.e0.p.d.m0.n.n1.i> c(AbstractTypeChecker3 abstractTypeChecker3, d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.l lVar) {
        List<d0.e0.p.d.m0.n.n1.i> listB = b(abstractTypeChecker3, iVar, lVar);
        if (listB.size() < 2) {
            return listB;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listB.iterator();
        while (true) {
            boolean z2 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            d0.e0.p.d.m0.n.n1.j jVarAsArgumentList = abstractTypeChecker3.asArgumentList((d0.e0.p.d.m0.n.n1.i) next);
            int size = abstractTypeChecker3.size(jVarAsArgumentList);
            for (int i = 0; i < size; i++) {
                if (!(abstractTypeChecker3.asFlexibleType(abstractTypeChecker3.getType(abstractTypeChecker3.get(jVarAsArgumentList, i))) == null)) {
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        return arrayList.isEmpty() ^ true ? arrayList : listB;
    }

    public final boolean d(AbstractTypeChecker3 abstractTypeChecker3, d0.e0.p.d.m0.n.n1.h hVar) {
        return abstractTypeChecker3.isDenotable(abstractTypeChecker3.typeConstructor(hVar)) && !abstractTypeChecker3.isDynamic(hVar) && !abstractTypeChecker3.isDefinitelyNotNullType(hVar) && Intrinsics3.areEqual(abstractTypeChecker3.typeConstructor(abstractTypeChecker3.lowerBoundIfFlexible(hVar)), abstractTypeChecker3.typeConstructor(abstractTypeChecker3.upperBoundIfFlexible(hVar)));
    }

    public final d0.e0.p.d.m0.n.n1.r effectiveVariance(d0.e0.p.d.m0.n.n1.r rVar, d0.e0.p.d.m0.n.n1.r rVar2) {
        Intrinsics3.checkNotNullParameter(rVar, "declared");
        Intrinsics3.checkNotNullParameter(rVar2, "useSite");
        d0.e0.p.d.m0.n.n1.r rVar3 = d0.e0.p.d.m0.n.n1.r.INV;
        if (rVar == rVar3) {
            return rVar2;
        }
        if (rVar2 == rVar3 || rVar == rVar2) {
            return rVar;
        }
        return null;
    }

    public final boolean equalTypes(AbstractTypeChecker3 abstractTypeChecker3, d0.e0.p.d.m0.n.n1.h hVar, d0.e0.p.d.m0.n.n1.h hVar2) {
        Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "context");
        Intrinsics3.checkNotNullParameter(hVar, "a");
        Intrinsics3.checkNotNullParameter(hVar2, "b");
        if (hVar == hVar2) {
            return true;
        }
        if (d(abstractTypeChecker3, hVar) && d(abstractTypeChecker3, hVar2)) {
            d0.e0.p.d.m0.n.n1.h hVarRefineType = abstractTypeChecker3.refineType(hVar);
            d0.e0.p.d.m0.n.n1.h hVarRefineType2 = abstractTypeChecker3.refineType(hVar2);
            d0.e0.p.d.m0.n.n1.i iVarLowerBoundIfFlexible = abstractTypeChecker3.lowerBoundIfFlexible(hVarRefineType);
            if (!abstractTypeChecker3.areEqualTypeConstructors(abstractTypeChecker3.typeConstructor(hVarRefineType), abstractTypeChecker3.typeConstructor(hVarRefineType2))) {
                return false;
            }
            if (abstractTypeChecker3.argumentsCount(iVarLowerBoundIfFlexible) == 0) {
                return abstractTypeChecker3.hasFlexibleNullability(hVarRefineType) || abstractTypeChecker3.hasFlexibleNullability(hVarRefineType2) || abstractTypeChecker3.isMarkedNullable(iVarLowerBoundIfFlexible) == abstractTypeChecker3.isMarkedNullable(abstractTypeChecker3.lowerBoundIfFlexible(hVarRefineType2));
            }
        }
        return isSubtypeOf$default(this, abstractTypeChecker3, hVar, hVar2, false, 8, null) && isSubtypeOf$default(this, abstractTypeChecker3, hVar2, hVar, false, 8, null);
    }

    public final List<d0.e0.p.d.m0.n.n1.i> findCorrespondingSupertypes(AbstractTypeChecker3 abstractTypeChecker3, d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.l lVar) {
        AbstractTypeChecker3.b bVar;
        Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "<this>");
        Intrinsics3.checkNotNullParameter(iVar, "subType");
        Intrinsics3.checkNotNullParameter(lVar, "superConstructor");
        if (abstractTypeChecker3.isClassType(iVar)) {
            return c(abstractTypeChecker3, iVar, lVar);
        }
        if (!abstractTypeChecker3.isClassTypeConstructor(lVar) && !abstractTypeChecker3.isIntegerLiteralTypeConstructor(lVar)) {
            return b(abstractTypeChecker3, iVar, lVar);
        }
        SmartList<d0.e0.p.d.m0.n.n1.i> smartList = new SmartList();
        abstractTypeChecker3.initialize();
        ArrayDeque<d0.e0.p.d.m0.n.n1.i> supertypesDeque = abstractTypeChecker3.getSupertypesDeque();
        Intrinsics3.checkNotNull(supertypesDeque);
        Set<d0.e0.p.d.m0.n.n1.i> supertypesSet = abstractTypeChecker3.getSupertypesSet();
        Intrinsics3.checkNotNull(supertypesSet);
        supertypesDeque.push(iVar);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() > 1000) {
                StringBuilder sbZ = outline.Z("Too many supertypes for type: ", iVar, ". Supertypes = ");
                sbZ.append(_Collections.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                throw new IllegalStateException(sbZ.toString().toString());
            }
            d0.e0.p.d.m0.n.n1.i iVarPop = supertypesDeque.pop();
            Intrinsics3.checkNotNullExpressionValue(iVarPop, "current");
            if (supertypesSet.add(iVarPop)) {
                if (abstractTypeChecker3.isClassType(iVarPop)) {
                    smartList.add(iVarPop);
                    bVar = AbstractTypeChecker3.b.c.a;
                } else {
                    bVar = AbstractTypeChecker3.b.C0411b.a;
                }
                if (!(!Intrinsics3.areEqual(bVar, AbstractTypeChecker3.b.c.a))) {
                    bVar = null;
                }
                if (bVar != null) {
                    Iterator<d0.e0.p.d.m0.n.n1.h> it = abstractTypeChecker3.supertypes(abstractTypeChecker3.typeConstructor(iVarPop)).iterator();
                    while (it.hasNext()) {
                        supertypesDeque.add(bVar.transformType(abstractTypeChecker3, it.next()));
                    }
                }
            }
        }
        abstractTypeChecker3.clear();
        ArrayList arrayList = new ArrayList();
        for (d0.e0.p.d.m0.n.n1.i iVar2 : smartList) {
            Intrinsics3.checkNotNullExpressionValue(iVar2, "it");
            MutableCollections.addAll(arrayList, c(abstractTypeChecker3, iVar2, lVar));
        }
        return arrayList;
    }

    public final boolean isSubtypeForSameConstructor(AbstractTypeChecker3 abstractTypeChecker3, d0.e0.p.d.m0.n.n1.j jVar, d0.e0.p.d.m0.n.n1.i iVar) {
        boolean zIsSubtypeOf$default;
        Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "<this>");
        Intrinsics3.checkNotNullParameter(jVar, "capturedSubArguments");
        Intrinsics3.checkNotNullParameter(iVar, "superType");
        d0.e0.p.d.m0.n.n1.l lVarTypeConstructor = abstractTypeChecker3.typeConstructor(iVar);
        int iParametersCount = abstractTypeChecker3.parametersCount(lVarTypeConstructor);
        if (iParametersCount > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                d0.e0.p.d.m0.n.n1.k argument = abstractTypeChecker3.getArgument(iVar, i);
                if (!abstractTypeChecker3.isStarProjection(argument)) {
                    d0.e0.p.d.m0.n.n1.h type = abstractTypeChecker3.getType(argument);
                    d0.e0.p.d.m0.n.n1.k kVar = abstractTypeChecker3.get(jVar, i);
                    abstractTypeChecker3.getVariance(kVar);
                    d0.e0.p.d.m0.n.n1.r rVar = d0.e0.p.d.m0.n.n1.r.INV;
                    d0.e0.p.d.m0.n.n1.h type2 = abstractTypeChecker3.getType(kVar);
                    d0.e0.p.d.m0.n.n1.r rVarEffectiveVariance = effectiveVariance(abstractTypeChecker3.getVariance(abstractTypeChecker3.getParameter(lVarTypeConstructor, i)), abstractTypeChecker3.getVariance(argument));
                    if (rVarEffectiveVariance == null) {
                        return abstractTypeChecker3.isErrorTypeEqualsToAnything();
                    }
                    if (abstractTypeChecker3.a > 100) {
                        throw new IllegalStateException(Intrinsics3.stringPlus("Arguments depth is too high. Some related argument: ", type2).toString());
                    }
                    abstractTypeChecker3.a++;
                    int iOrdinal = rVarEffectiveVariance.ordinal();
                    if (iOrdinal == 0) {
                        zIsSubtypeOf$default = isSubtypeOf$default(this, abstractTypeChecker3, type, type2, false, 8, null);
                    } else if (iOrdinal == 1) {
                        zIsSubtypeOf$default = isSubtypeOf$default(this, abstractTypeChecker3, type2, type, false, 8, null);
                    } else {
                        if (iOrdinal != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        zIsSubtypeOf$default = equalTypes(abstractTypeChecker3, type2, type);
                    }
                    abstractTypeChecker3.a--;
                    if (!zIsSubtypeOf$default) {
                        return false;
                    }
                }
                if (i2 < iParametersCount) {
                    i = i2;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:116:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:155:0x0278 A[LOOP:2: B:142:0x024f->B:155:0x0278, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:217:0x0282 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:235:0x00ff A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:236:0x00fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:237:? A[LOOP:6: B:50:0x00e1->B:237:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:44:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:49:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:57:0x0105  */
    public final boolean isSubtypeOf(AbstractTypeChecker3 abstractTypeChecker3, d0.e0.p.d.m0.n.n1.h hVar, d0.e0.p.d.m0.n.n1.h hVar2, boolean z2) {
        Boolean boolValueOf;
        boolean z3;
        Boolean bool;
        boolean z4;
        boolean z5;
        d0.e0.p.d.m0.n.n1.l lVar;
        d0.e0.p.d.m0.n.n1.l lVar2;
        d0.e0.p.d.m0.n.n1.l lVarTypeConstructor;
        Collection<d0.e0.p.d.m0.n.n1.h> collectionSupertypes;
        Iterator<T> it;
        boolean z6;
        Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "context");
        Intrinsics3.checkNotNullParameter(hVar, "subType");
        Intrinsics3.checkNotNullParameter(hVar2, "superType");
        if (hVar == hVar2) {
            return true;
        }
        if (!abstractTypeChecker3.customIsSubtypeOf(hVar, hVar2)) {
            return false;
        }
        d0.e0.p.d.m0.n.n1.h hVarPrepareType = abstractTypeChecker3.prepareType(abstractTypeChecker3.refineType(hVar));
        d0.e0.p.d.m0.n.n1.h hVarPrepareType2 = abstractTypeChecker3.prepareType(abstractTypeChecker3.refineType(hVar2));
        d0.e0.p.d.m0.n.n1.i iVarLowerBoundIfFlexible = abstractTypeChecker3.lowerBoundIfFlexible(hVarPrepareType);
        d0.e0.p.d.m0.n.n1.i iVarUpperBoundIfFlexible = abstractTypeChecker3.upperBoundIfFlexible(hVarPrepareType2);
        if (abstractTypeChecker3.isError(iVarLowerBoundIfFlexible) || abstractTypeChecker3.isError(iVarUpperBoundIfFlexible)) {
            boolValueOf = abstractTypeChecker3.isErrorTypeEqualsToAnything() ? Boolean.TRUE : (!abstractTypeChecker3.isMarkedNullable(iVarLowerBoundIfFlexible) || abstractTypeChecker3.isMarkedNullable(iVarUpperBoundIfFlexible)) ? Boolean.valueOf(AbstractStrictEqualityTypeChecker.a.strictEqualTypes(abstractTypeChecker3, abstractTypeChecker3.withNullability(iVarLowerBoundIfFlexible, false), abstractTypeChecker3.withNullability(iVarUpperBoundIfFlexible, false))) : Boolean.FALSE;
        } else if (abstractTypeChecker3.isStubType(iVarLowerBoundIfFlexible) || abstractTypeChecker3.isStubType(iVarUpperBoundIfFlexible)) {
            boolValueOf = Boolean.valueOf(abstractTypeChecker3.isStubTypeEqualsToAnything());
        } else {
            d0.e0.p.d.m0.n.n1.d dVarAsDefinitelyNotNullType = abstractTypeChecker3.asDefinitelyNotNullType(iVarUpperBoundIfFlexible);
            d0.e0.p.d.m0.n.n1.c cVarAsCapturedType = abstractTypeChecker3.asCapturedType(dVarAsDefinitelyNotNullType == null ? iVarUpperBoundIfFlexible : abstractTypeChecker3.original(dVarAsDefinitelyNotNullType));
            d0.e0.p.d.m0.n.n1.h hVarLowerType = cVarAsCapturedType == null ? null : abstractTypeChecker3.lowerType(cVarAsCapturedType);
            if (cVarAsCapturedType == null || hVarLowerType == null) {
                lVarTypeConstructor = abstractTypeChecker3.typeConstructor(iVarUpperBoundIfFlexible);
                if (abstractTypeChecker3.isIntersection(lVarTypeConstructor)) {
                    abstractTypeChecker3.isMarkedNullable(iVarUpperBoundIfFlexible);
                    collectionSupertypes = abstractTypeChecker3.supertypes(lVarTypeConstructor);
                    if (!(collectionSupertypes instanceof Collection) && collectionSupertypes.isEmpty()) {
                        z6 = true;
                        break;
                    }
                    it = collectionSupertypes.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z6 = true;
                            break;
                        }
                        if (!isSubtypeOf$default(this, abstractTypeChecker3, iVarLowerBoundIfFlexible, (d0.e0.p.d.m0.n.n1.h) it.next(), false, 8, null)) {
                            z6 = false;
                            break;
                        }
                    }
                    boolValueOf = Boolean.valueOf(z6);
                } else {
                    boolValueOf = null;
                }
            } else {
                if (abstractTypeChecker3.isMarkedNullable(iVarUpperBoundIfFlexible)) {
                    hVarLowerType = abstractTypeChecker3.withNullability(hVarLowerType, true);
                } else if (abstractTypeChecker3.isDefinitelyNotNullType(iVarUpperBoundIfFlexible)) {
                    hVarLowerType = abstractTypeChecker3.makeDefinitelyNotNullOrNotNull(hVarLowerType);
                }
                d0.e0.p.d.m0.n.n1.h hVar3 = hVarLowerType;
                int iOrdinal = abstractTypeChecker3.getLowerCapturedTypePolicy(iVarLowerBoundIfFlexible, cVarAsCapturedType).ordinal();
                if (iOrdinal == 0) {
                    boolValueOf = Boolean.valueOf(isSubtypeOf$default(this, abstractTypeChecker3, iVarLowerBoundIfFlexible, hVar3, false, 8, null));
                } else if (iOrdinal == 1 && isSubtypeOf$default(this, abstractTypeChecker3, iVarLowerBoundIfFlexible, hVar3, false, 8, null)) {
                    boolValueOf = Boolean.TRUE;
                } else {
                    lVarTypeConstructor = abstractTypeChecker3.typeConstructor(iVarUpperBoundIfFlexible);
                    if (abstractTypeChecker3.isIntersection(lVarTypeConstructor)) {
                        abstractTypeChecker3.isMarkedNullable(iVarUpperBoundIfFlexible);
                        collectionSupertypes = abstractTypeChecker3.supertypes(lVarTypeConstructor);
                        if (!(collectionSupertypes instanceof Collection)) {
                            it = collectionSupertypes.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z6 = true;
                                    break;
                                }
                                if (!isSubtypeOf$default(this, abstractTypeChecker3, iVarLowerBoundIfFlexible, (d0.e0.p.d.m0.n.n1.h) it.next(), false, 8, null)) {
                                    z6 = false;
                                    break;
                                }
                            }
                        } else {
                            it = collectionSupertypes.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z6 = true;
                                    break;
                                }
                                if (!isSubtypeOf$default(this, abstractTypeChecker3, iVarLowerBoundIfFlexible, (d0.e0.p.d.m0.n.n1.h) it.next(), false, 8, null)) {
                                    z6 = false;
                                    break;
                                }
                            }
                        }
                        boolValueOf = Boolean.valueOf(z6);
                    } else {
                        boolValueOf = null;
                    }
                }
            }
        }
        if (boolValueOf != null) {
            boolean zBooleanValue = boolValueOf.booleanValue();
            abstractTypeChecker3.addSubtypeConstraint(hVarPrepareType, hVarPrepareType2, z2);
            return zBooleanValue;
        }
        Boolean boolAddSubtypeConstraint = abstractTypeChecker3.addSubtypeConstraint(hVarPrepareType, hVarPrepareType2, z2);
        if (boolAddSubtypeConstraint != null) {
            return boolAddSubtypeConstraint.booleanValue();
        }
        d0.e0.p.d.m0.n.n1.i iVarLowerBoundIfFlexible2 = abstractTypeChecker3.lowerBoundIfFlexible(hVarPrepareType);
        d0.e0.p.d.m0.n.n1.i iVarUpperBoundIfFlexible2 = abstractTypeChecker3.upperBoundIfFlexible(hVarPrepareType2);
        if (AbstractTypeChecker.a.isPossibleSubtype(abstractTypeChecker3, iVarLowerBoundIfFlexible2, iVarUpperBoundIfFlexible2)) {
            d0.e0.p.d.m0.n.n1.i iVarLowerBoundIfFlexible3 = abstractTypeChecker3.lowerBoundIfFlexible(iVarLowerBoundIfFlexible2);
            d0.e0.p.d.m0.n.n1.i iVarUpperBoundIfFlexible3 = abstractTypeChecker3.upperBoundIfFlexible(iVarUpperBoundIfFlexible2);
            if (!abstractTypeChecker3.isIntegerLiteralType(iVarLowerBoundIfFlexible3) && !abstractTypeChecker3.isIntegerLiteralType(iVarUpperBoundIfFlexible3)) {
                bool = null;
            } else if (abstractTypeChecker3.isIntegerLiteralType(iVarLowerBoundIfFlexible3) && abstractTypeChecker3.isIntegerLiteralType(iVarUpperBoundIfFlexible3)) {
                bool = Boolean.TRUE;
            } else if (abstractTypeChecker3.isIntegerLiteralType(iVarLowerBoundIfFlexible3)) {
                if (a(abstractTypeChecker3, this, iVarLowerBoundIfFlexible3, iVarUpperBoundIfFlexible3, false)) {
                    bool = Boolean.TRUE;
                } else {
                    bool = null;
                }
            } else if (abstractTypeChecker3.isIntegerLiteralType(iVarUpperBoundIfFlexible3)) {
                d0.e0.p.d.m0.n.n1.l lVarTypeConstructor2 = abstractTypeChecker3.typeConstructor(iVarLowerBoundIfFlexible3);
                if (lVarTypeConstructor2 instanceof d0.e0.p.d.m0.n.n1.g) {
                    Collection<d0.e0.p.d.m0.n.n1.h> collectionSupertypes2 = abstractTypeChecker3.supertypes(lVarTypeConstructor2);
                    if (!(collectionSupertypes2 instanceof Collection) || !collectionSupertypes2.isEmpty()) {
                        Iterator<T> it2 = collectionSupertypes2.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z4 = false;
                                break;
                            }
                            d0.e0.p.d.m0.n.n1.i iVarAsSimpleType = abstractTypeChecker3.asSimpleType((d0.e0.p.d.m0.n.n1.h) it2.next());
                            if (Intrinsics3.areEqual(iVarAsSimpleType == null ? null : Boolean.valueOf(abstractTypeChecker3.isIntegerLiteralType(iVarAsSimpleType)), Boolean.TRUE)) {
                                z4 = true;
                                break;
                            }
                        }
                    } else {
                        z4 = false;
                        break;
                    }
                    if (z4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                } else {
                    z3 = false;
                }
                if (z3 || a(abstractTypeChecker3, this, iVarUpperBoundIfFlexible3, iVarLowerBoundIfFlexible3, true)) {
                    bool = Boolean.TRUE;
                } else {
                    bool = null;
                }
            } else {
                bool = null;
            }
            if (bool != null) {
                boolean zBooleanValue2 = bool.booleanValue();
                AbstractTypeChecker3.addSubtypeConstraint$default(abstractTypeChecker3, iVarLowerBoundIfFlexible2, iVarUpperBoundIfFlexible2, false, 4, null);
                return zBooleanValue2;
            }
            d0.e0.p.d.m0.n.n1.l lVarTypeConstructor3 = abstractTypeChecker3.typeConstructor(iVarUpperBoundIfFlexible2);
            if ((!abstractTypeChecker3.areEqualTypeConstructors(abstractTypeChecker3.typeConstructor(iVarLowerBoundIfFlexible2), lVarTypeConstructor3) || abstractTypeChecker3.parametersCount(lVarTypeConstructor3) != 0) && !abstractTypeChecker3.isAnyConstructor(abstractTypeChecker3.typeConstructor(iVarUpperBoundIfFlexible2))) {
                List<d0.e0.p.d.m0.n.n1.i> listFindCorrespondingSupertypes = findCorrespondingSupertypes(abstractTypeChecker3, iVarLowerBoundIfFlexible2, lVarTypeConstructor3);
                int size = listFindCorrespondingSupertypes.size();
                if (size == 0) {
                    d0.e0.p.d.m0.n.n1.l lVarTypeConstructor4 = abstractTypeChecker3.typeConstructor(iVarLowerBoundIfFlexible2);
                    if (abstractTypeChecker3.isClassTypeConstructor(lVarTypeConstructor4)) {
                        return abstractTypeChecker3.isNothingConstructor(lVarTypeConstructor4);
                    }
                    if (!abstractTypeChecker3.isNothingConstructor(abstractTypeChecker3.typeConstructor(iVarLowerBoundIfFlexible2))) {
                        abstractTypeChecker3.initialize();
                        ArrayDeque<d0.e0.p.d.m0.n.n1.i> supertypesDeque = abstractTypeChecker3.getSupertypesDeque();
                        Intrinsics3.checkNotNull(supertypesDeque);
                        Set<d0.e0.p.d.m0.n.n1.i> supertypesSet = abstractTypeChecker3.getSupertypesSet();
                        Intrinsics3.checkNotNull(supertypesSet);
                        supertypesDeque.push(iVarLowerBoundIfFlexible2);
                        while (!supertypesDeque.isEmpty()) {
                            if (supertypesSet.size() > 1000) {
                                StringBuilder sbZ = outline.Z("Too many supertypes for type: ", iVarLowerBoundIfFlexible2, ". Supertypes = ");
                                sbZ.append(_Collections.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                                throw new IllegalStateException(sbZ.toString().toString());
                            }
                            d0.e0.p.d.m0.n.n1.i iVarPop = supertypesDeque.pop();
                            Intrinsics3.checkNotNullExpressionValue(iVarPop, "current");
                            if (supertypesSet.add(iVarPop)) {
                                AbstractTypeChecker3.b bVar = abstractTypeChecker3.isClassType(iVarPop) ? AbstractTypeChecker3.b.c.a : AbstractTypeChecker3.b.C0411b.a;
                                if (!(!Intrinsics3.areEqual(bVar, AbstractTypeChecker3.b.c.a))) {
                                    bVar = null;
                                }
                                if (bVar == null) {
                                    continue;
                                } else {
                                    Iterator<d0.e0.p.d.m0.n.n1.h> it3 = abstractTypeChecker3.supertypes(abstractTypeChecker3.typeConstructor(iVarPop)).iterator();
                                    while (it3.hasNext()) {
                                        d0.e0.p.d.m0.n.n1.i iVarTransformType = bVar.transformType(abstractTypeChecker3, it3.next());
                                        if (abstractTypeChecker3.isNothingConstructor(abstractTypeChecker3.typeConstructor(iVarTransformType))) {
                                            abstractTypeChecker3.clear();
                                        } else {
                                            supertypesDeque.add(iVarTransformType);
                                        }
                                    }
                                }
                            }
                        }
                        abstractTypeChecker3.clear();
                    }
                } else {
                    if (size == 1) {
                        return isSubtypeForSameConstructor(abstractTypeChecker3, abstractTypeChecker3.asArgumentList((d0.e0.p.d.m0.n.n1.i) _Collections.first((List) listFindCorrespondingSupertypes)), iVarUpperBoundIfFlexible2);
                    }
                    d0.e0.p.d.m0.n.n1.a aVar = new d0.e0.p.d.m0.n.n1.a(abstractTypeChecker3.parametersCount(lVarTypeConstructor3));
                    int iParametersCount = abstractTypeChecker3.parametersCount(lVarTypeConstructor3);
                    if (iParametersCount > 0) {
                        int i = 0;
                        z5 = false;
                        while (true) {
                            int i2 = i + 1;
                            z5 = z5 || abstractTypeChecker3.getVariance(abstractTypeChecker3.getParameter(lVarTypeConstructor3, i)) != d0.e0.p.d.m0.n.n1.r.OUT;
                            if (z5) {
                                lVar = lVarTypeConstructor3;
                            } else {
                                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listFindCorrespondingSupertypes, 10));
                                for (d0.e0.p.d.m0.n.n1.i iVar : listFindCorrespondingSupertypes) {
                                    d0.e0.p.d.m0.n.n1.k argumentOrNull = abstractTypeChecker3.getArgumentOrNull(iVar, i);
                                    if (argumentOrNull == null) {
                                        lVar2 = lVarTypeConstructor3;
                                    } else {
                                        lVar2 = lVarTypeConstructor3;
                                        if (!(abstractTypeChecker3.getVariance(argumentOrNull) == d0.e0.p.d.m0.n.n1.r.INV)) {
                                        }
                                        if (argumentOrNull != null) {
                                            throw new IllegalStateException(("Incorrect type: " + iVar + ", subType: " + iVarLowerBoundIfFlexible2 + ", superType: " + iVarUpperBoundIfFlexible2).toString());
                                        }
                                        arrayList.add(abstractTypeChecker3.getType(argumentOrNull));
                                        lVarTypeConstructor3 = lVar2;
                                    }
                                    argumentOrNull = null;
                                    if (argumentOrNull != null) {
                                        throw new IllegalStateException(("Incorrect type: " + iVar + ", subType: " + iVarLowerBoundIfFlexible2 + ", superType: " + iVarUpperBoundIfFlexible2).toString());
                                    }
                                    arrayList.add(abstractTypeChecker3.getType(argumentOrNull));
                                    lVarTypeConstructor3 = lVar2;
                                }
                                lVar = lVarTypeConstructor3;
                                aVar.add(abstractTypeChecker3.asTypeArgument(abstractTypeChecker3.intersectTypes(arrayList)));
                            }
                            if (i2 >= iParametersCount) {
                                break;
                            }
                            lVarTypeConstructor3 = lVar;
                            i = i2;
                        }
                    } else {
                        z5 = false;
                    }
                    if (z5 || !isSubtypeForSameConstructor(abstractTypeChecker3, aVar, iVarUpperBoundIfFlexible2)) {
                        if (!listFindCorrespondingSupertypes.isEmpty()) {
                            Iterator<T> it4 = listFindCorrespondingSupertypes.iterator();
                            while (it4.hasNext()) {
                                if (isSubtypeForSameConstructor(abstractTypeChecker3, abstractTypeChecker3.asArgumentList((d0.e0.p.d.m0.n.n1.i) it4.next()), iVarUpperBoundIfFlexible2)) {
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
}
