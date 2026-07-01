package d0.e0.p.d.m0.n;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: AbstractTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final e a = new e();

    public static final boolean a(f fVar, e eVar, d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.i iVar2, boolean z2) {
        Collection<d0.e0.p.d.m0.n.n1.h> collectionPossibleIntegerTypes = fVar.possibleIntegerTypes(iVar);
        if ((collectionPossibleIntegerTypes instanceof Collection) && collectionPossibleIntegerTypes.isEmpty()) {
            return false;
        }
        for (d0.e0.p.d.m0.n.n1.h hVar : collectionPossibleIntegerTypes) {
            if (d0.z.d.m.areEqual(fVar.typeConstructor(hVar), fVar.typeConstructor(iVar2)) || (z2 && isSubtypeOf$default(eVar, fVar, iVar2, hVar, false, 8, null))) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isSubtypeOf$default(e eVar, f fVar, d0.e0.p.d.m0.n.n1.h hVar, d0.e0.p.d.m0.n.n1.h hVar2, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = false;
        }
        return eVar.isSubtypeOf(fVar, hVar, hVar2, z2);
    }

    public final List<d0.e0.p.d.m0.n.n1.i> b(f fVar, d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.l lVar) {
        f$b f_bSubstitutionSupertypePolicy;
        d0.e0.p.d.m0.n.n1.b bVar = d0.e0.p.d.m0.n.n1.b.FOR_SUBTYPING;
        List<d0.e0.p.d.m0.n.n1.i> listFastCorrespondingSupertypes = fVar.fastCorrespondingSupertypes(iVar, lVar);
        if (listFastCorrespondingSupertypes == null) {
            if (!fVar.isClassTypeConstructor(lVar) && fVar.isClassType(iVar)) {
                return d0.t.n.emptyList();
            }
            if (fVar.isCommonFinalClassConstructor(lVar)) {
                if (!fVar.areEqualTypeConstructors(fVar.typeConstructor(iVar), lVar)) {
                    return d0.t.n.emptyList();
                }
                d0.e0.p.d.m0.n.n1.i iVarCaptureFromArguments = fVar.captureFromArguments(iVar, bVar);
                if (iVarCaptureFromArguments != null) {
                    iVar = iVarCaptureFromArguments;
                }
                return d0.t.m.listOf(iVar);
            }
            listFastCorrespondingSupertypes = new d0.e0.p.d.m0.p.i<>();
            fVar.initialize();
            ArrayDeque<d0.e0.p.d.m0.n.n1.i> supertypesDeque = fVar.getSupertypesDeque();
            d0.z.d.m.checkNotNull(supertypesDeque);
            Set<d0.e0.p.d.m0.n.n1.i> supertypesSet = fVar.getSupertypesSet();
            d0.z.d.m.checkNotNull(supertypesSet);
            supertypesDeque.push(iVar);
            while (!supertypesDeque.isEmpty()) {
                if (supertypesSet.size() > 1000) {
                    StringBuilder sbZ = b.d.b.a.a.Z("Too many supertypes for type: ", iVar, ". Supertypes = ");
                    sbZ.append(d0.t.u.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                    throw new IllegalStateException(sbZ.toString().toString());
                }
                d0.e0.p.d.m0.n.n1.i iVarPop = supertypesDeque.pop();
                d0.z.d.m.checkNotNullExpressionValue(iVarPop, "current");
                if (supertypesSet.add(iVarPop)) {
                    d0.e0.p.d.m0.n.n1.i iVarCaptureFromArguments2 = fVar.captureFromArguments(iVarPop, bVar);
                    if (iVarCaptureFromArguments2 == null) {
                        iVarCaptureFromArguments2 = iVarPop;
                    }
                    if (fVar.areEqualTypeConstructors(fVar.typeConstructor(iVarCaptureFromArguments2), lVar)) {
                        listFastCorrespondingSupertypes.add(iVarCaptureFromArguments2);
                        f_bSubstitutionSupertypePolicy = f$b$c.a;
                    } else {
                        f_bSubstitutionSupertypePolicy = fVar.argumentsCount(iVarCaptureFromArguments2) == 0 ? f$b$b.a : fVar.substitutionSupertypePolicy(iVarCaptureFromArguments2);
                    }
                    if (!(!d0.z.d.m.areEqual(f_bSubstitutionSupertypePolicy, f$b$c.a))) {
                        f_bSubstitutionSupertypePolicy = null;
                    }
                    if (f_bSubstitutionSupertypePolicy != null) {
                        Iterator<d0.e0.p.d.m0.n.n1.h> it = fVar.supertypes(fVar.typeConstructor(iVarPop)).iterator();
                        while (it.hasNext()) {
                            supertypesDeque.add(f_bSubstitutionSupertypePolicy.transformType(fVar, it.next()));
                        }
                    }
                }
            }
            fVar.clear();
        }
        return listFastCorrespondingSupertypes;
    }

    public final List<d0.e0.p.d.m0.n.n1.i> c(f fVar, d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.l lVar) {
        List<d0.e0.p.d.m0.n.n1.i> listB = b(fVar, iVar, lVar);
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
            d0.e0.p.d.m0.n.n1.j jVarAsArgumentList = fVar.asArgumentList((d0.e0.p.d.m0.n.n1.i) next);
            int size = fVar.size(jVarAsArgumentList);
            for (int i = 0; i < size; i++) {
                if (!(fVar.asFlexibleType(fVar.getType(fVar.get(jVarAsArgumentList, i))) == null)) {
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

    public final boolean d(f fVar, d0.e0.p.d.m0.n.n1.h hVar) {
        return fVar.isDenotable(fVar.typeConstructor(hVar)) && !fVar.isDynamic(hVar) && !fVar.isDefinitelyNotNullType(hVar) && d0.z.d.m.areEqual(fVar.typeConstructor(fVar.lowerBoundIfFlexible(hVar)), fVar.typeConstructor(fVar.upperBoundIfFlexible(hVar)));
    }

    public final d0.e0.p.d.m0.n.n1.r effectiveVariance(d0.e0.p.d.m0.n.n1.r rVar, d0.e0.p.d.m0.n.n1.r rVar2) {
        d0.z.d.m.checkNotNullParameter(rVar, "declared");
        d0.z.d.m.checkNotNullParameter(rVar2, "useSite");
        d0.e0.p.d.m0.n.n1.r rVar3 = d0.e0.p.d.m0.n.n1.r.INV;
        if (rVar == rVar3) {
            return rVar2;
        }
        if (rVar2 == rVar3 || rVar == rVar2) {
            return rVar;
        }
        return null;
    }

    public final boolean equalTypes(f fVar, d0.e0.p.d.m0.n.n1.h hVar, d0.e0.p.d.m0.n.n1.h hVar2) {
        d0.z.d.m.checkNotNullParameter(fVar, "context");
        d0.z.d.m.checkNotNullParameter(hVar, "a");
        d0.z.d.m.checkNotNullParameter(hVar2, "b");
        if (hVar == hVar2) {
            return true;
        }
        if (d(fVar, hVar) && d(fVar, hVar2)) {
            d0.e0.p.d.m0.n.n1.h hVarRefineType = fVar.refineType(hVar);
            d0.e0.p.d.m0.n.n1.h hVarRefineType2 = fVar.refineType(hVar2);
            d0.e0.p.d.m0.n.n1.i iVarLowerBoundIfFlexible = fVar.lowerBoundIfFlexible(hVarRefineType);
            if (!fVar.areEqualTypeConstructors(fVar.typeConstructor(hVarRefineType), fVar.typeConstructor(hVarRefineType2))) {
                return false;
            }
            if (fVar.argumentsCount(iVarLowerBoundIfFlexible) == 0) {
                return fVar.hasFlexibleNullability(hVarRefineType) || fVar.hasFlexibleNullability(hVarRefineType2) || fVar.isMarkedNullable(iVarLowerBoundIfFlexible) == fVar.isMarkedNullable(fVar.lowerBoundIfFlexible(hVarRefineType2));
            }
        }
        return isSubtypeOf$default(this, fVar, hVar, hVar2, false, 8, null) && isSubtypeOf$default(this, fVar, hVar2, hVar, false, 8, null);
    }

    public final List<d0.e0.p.d.m0.n.n1.i> findCorrespondingSupertypes(f fVar, d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.l lVar) {
        f$b f_b;
        d0.z.d.m.checkNotNullParameter(fVar, "<this>");
        d0.z.d.m.checkNotNullParameter(iVar, "subType");
        d0.z.d.m.checkNotNullParameter(lVar, "superConstructor");
        if (fVar.isClassType(iVar)) {
            return c(fVar, iVar, lVar);
        }
        if (!fVar.isClassTypeConstructor(lVar) && !fVar.isIntegerLiteralTypeConstructor(lVar)) {
            return b(fVar, iVar, lVar);
        }
        d0.e0.p.d.m0.p.i<d0.e0.p.d.m0.n.n1.i> iVar2 = new d0.e0.p.d.m0.p.i();
        fVar.initialize();
        ArrayDeque<d0.e0.p.d.m0.n.n1.i> supertypesDeque = fVar.getSupertypesDeque();
        d0.z.d.m.checkNotNull(supertypesDeque);
        Set<d0.e0.p.d.m0.n.n1.i> supertypesSet = fVar.getSupertypesSet();
        d0.z.d.m.checkNotNull(supertypesSet);
        supertypesDeque.push(iVar);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() > 1000) {
                StringBuilder sbZ = b.d.b.a.a.Z("Too many supertypes for type: ", iVar, ". Supertypes = ");
                sbZ.append(d0.t.u.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                throw new IllegalStateException(sbZ.toString().toString());
            }
            d0.e0.p.d.m0.n.n1.i iVarPop = supertypesDeque.pop();
            d0.z.d.m.checkNotNullExpressionValue(iVarPop, "current");
            if (supertypesSet.add(iVarPop)) {
                if (fVar.isClassType(iVarPop)) {
                    iVar2.add(iVarPop);
                    f_b = f$b$c.a;
                } else {
                    f_b = f$b$b.a;
                }
                if (!(!d0.z.d.m.areEqual(f_b, f$b$c.a))) {
                    f_b = null;
                }
                if (f_b != null) {
                    Iterator<d0.e0.p.d.m0.n.n1.h> it = fVar.supertypes(fVar.typeConstructor(iVarPop)).iterator();
                    while (it.hasNext()) {
                        supertypesDeque.add(f_b.transformType(fVar, it.next()));
                    }
                }
            }
        }
        fVar.clear();
        ArrayList arrayList = new ArrayList();
        for (d0.e0.p.d.m0.n.n1.i iVar3 : iVar2) {
            d0.z.d.m.checkNotNullExpressionValue(iVar3, "it");
            d0.t.r.addAll(arrayList, c(fVar, iVar3, lVar));
        }
        return arrayList;
    }

    public final boolean isSubtypeForSameConstructor(f fVar, d0.e0.p.d.m0.n.n1.j jVar, d0.e0.p.d.m0.n.n1.i iVar) {
        boolean zIsSubtypeOf$default;
        d0.z.d.m.checkNotNullParameter(fVar, "<this>");
        d0.z.d.m.checkNotNullParameter(jVar, "capturedSubArguments");
        d0.z.d.m.checkNotNullParameter(iVar, "superType");
        d0.e0.p.d.m0.n.n1.l lVarTypeConstructor = fVar.typeConstructor(iVar);
        int iParametersCount = fVar.parametersCount(lVarTypeConstructor);
        if (iParametersCount > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                d0.e0.p.d.m0.n.n1.k argument = fVar.getArgument(iVar, i);
                if (!fVar.isStarProjection(argument)) {
                    d0.e0.p.d.m0.n.n1.h type = fVar.getType(argument);
                    d0.e0.p.d.m0.n.n1.k kVar = fVar.get(jVar, i);
                    fVar.getVariance(kVar);
                    d0.e0.p.d.m0.n.n1.r rVar = d0.e0.p.d.m0.n.n1.r.INV;
                    d0.e0.p.d.m0.n.n1.h type2 = fVar.getType(kVar);
                    d0.e0.p.d.m0.n.n1.r rVarEffectiveVariance = effectiveVariance(fVar.getVariance(fVar.getParameter(lVarTypeConstructor, i)), fVar.getVariance(argument));
                    if (rVarEffectiveVariance == null) {
                        return fVar.isErrorTypeEqualsToAnything();
                    }
                    if (f.access$getArgumentsDepth(fVar) > 100) {
                        throw new IllegalStateException(d0.z.d.m.stringPlus("Arguments depth is too high. Some related argument: ", type2).toString());
                    }
                    f.access$setArgumentsDepth(fVar, f.access$getArgumentsDepth(fVar) + 1);
                    int iOrdinal = rVarEffectiveVariance.ordinal();
                    if (iOrdinal == 0) {
                        zIsSubtypeOf$default = isSubtypeOf$default(this, fVar, type, type2, false, 8, null);
                    } else if (iOrdinal == 1) {
                        zIsSubtypeOf$default = isSubtypeOf$default(this, fVar, type2, type, false, 8, null);
                    } else {
                        if (iOrdinal != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        zIsSubtypeOf$default = equalTypes(fVar, type2, type);
                    }
                    f.access$setArgumentsDepth(fVar, f.access$getArgumentsDepth(fVar) - 1);
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
    public final boolean isSubtypeOf(f fVar, d0.e0.p.d.m0.n.n1.h hVar, d0.e0.p.d.m0.n.n1.h hVar2, boolean z2) {
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
        d0.z.d.m.checkNotNullParameter(fVar, "context");
        d0.z.d.m.checkNotNullParameter(hVar, "subType");
        d0.z.d.m.checkNotNullParameter(hVar2, "superType");
        if (hVar == hVar2) {
            return true;
        }
        if (!fVar.customIsSubtypeOf(hVar, hVar2)) {
            return false;
        }
        d0.e0.p.d.m0.n.n1.h hVarPrepareType = fVar.prepareType(fVar.refineType(hVar));
        d0.e0.p.d.m0.n.n1.h hVarPrepareType2 = fVar.prepareType(fVar.refineType(hVar2));
        d0.e0.p.d.m0.n.n1.i iVarLowerBoundIfFlexible = fVar.lowerBoundIfFlexible(hVarPrepareType);
        d0.e0.p.d.m0.n.n1.i iVarUpperBoundIfFlexible = fVar.upperBoundIfFlexible(hVarPrepareType2);
        if (fVar.isError(iVarLowerBoundIfFlexible) || fVar.isError(iVarUpperBoundIfFlexible)) {
            boolValueOf = fVar.isErrorTypeEqualsToAnything() ? Boolean.TRUE : (!fVar.isMarkedNullable(iVarLowerBoundIfFlexible) || fVar.isMarkedNullable(iVarUpperBoundIfFlexible)) ? Boolean.valueOf(d.a.strictEqualTypes(fVar, fVar.withNullability(iVarLowerBoundIfFlexible, false), fVar.withNullability(iVarUpperBoundIfFlexible, false))) : Boolean.FALSE;
        } else if (fVar.isStubType(iVarLowerBoundIfFlexible) || fVar.isStubType(iVarUpperBoundIfFlexible)) {
            boolValueOf = Boolean.valueOf(fVar.isStubTypeEqualsToAnything());
        } else {
            d0.e0.p.d.m0.n.n1.d dVarAsDefinitelyNotNullType = fVar.asDefinitelyNotNullType(iVarUpperBoundIfFlexible);
            d0.e0.p.d.m0.n.n1.c cVarAsCapturedType = fVar.asCapturedType(dVarAsDefinitelyNotNullType == null ? iVarUpperBoundIfFlexible : fVar.original(dVarAsDefinitelyNotNullType));
            d0.e0.p.d.m0.n.n1.h hVarLowerType = cVarAsCapturedType == null ? null : fVar.lowerType(cVarAsCapturedType);
            if (cVarAsCapturedType == null || hVarLowerType == null) {
                lVarTypeConstructor = fVar.typeConstructor(iVarUpperBoundIfFlexible);
                if (fVar.isIntersection(lVarTypeConstructor)) {
                    fVar.isMarkedNullable(iVarUpperBoundIfFlexible);
                    collectionSupertypes = fVar.supertypes(lVarTypeConstructor);
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
                        if (!isSubtypeOf$default(this, fVar, iVarLowerBoundIfFlexible, (d0.e0.p.d.m0.n.n1.h) it.next(), false, 8, null)) {
                            z6 = false;
                            break;
                        }
                    }
                    boolValueOf = Boolean.valueOf(z6);
                } else {
                    boolValueOf = null;
                }
            } else {
                if (fVar.isMarkedNullable(iVarUpperBoundIfFlexible)) {
                    hVarLowerType = fVar.withNullability(hVarLowerType, true);
                } else if (fVar.isDefinitelyNotNullType(iVarUpperBoundIfFlexible)) {
                    hVarLowerType = fVar.makeDefinitelyNotNullOrNotNull(hVarLowerType);
                }
                d0.e0.p.d.m0.n.n1.h hVar3 = hVarLowerType;
                int iOrdinal = fVar.getLowerCapturedTypePolicy(iVarLowerBoundIfFlexible, cVarAsCapturedType).ordinal();
                if (iOrdinal == 0) {
                    boolValueOf = Boolean.valueOf(isSubtypeOf$default(this, fVar, iVarLowerBoundIfFlexible, hVar3, false, 8, null));
                } else if (iOrdinal == 1 && isSubtypeOf$default(this, fVar, iVarLowerBoundIfFlexible, hVar3, false, 8, null)) {
                    boolValueOf = Boolean.TRUE;
                } else {
                    lVarTypeConstructor = fVar.typeConstructor(iVarUpperBoundIfFlexible);
                    if (fVar.isIntersection(lVarTypeConstructor)) {
                        fVar.isMarkedNullable(iVarUpperBoundIfFlexible);
                        collectionSupertypes = fVar.supertypes(lVarTypeConstructor);
                        if (!(collectionSupertypes instanceof Collection)) {
                            it = collectionSupertypes.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z6 = true;
                                    break;
                                }
                                if (!isSubtypeOf$default(this, fVar, iVarLowerBoundIfFlexible, (d0.e0.p.d.m0.n.n1.h) it.next(), false, 8, null)) {
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
                                if (!isSubtypeOf$default(this, fVar, iVarLowerBoundIfFlexible, (d0.e0.p.d.m0.n.n1.h) it.next(), false, 8, null)) {
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
            fVar.addSubtypeConstraint(hVarPrepareType, hVarPrepareType2, z2);
            return zBooleanValue;
        }
        Boolean boolAddSubtypeConstraint = fVar.addSubtypeConstraint(hVarPrepareType, hVarPrepareType2, z2);
        if (boolAddSubtypeConstraint != null) {
            return boolAddSubtypeConstraint.booleanValue();
        }
        d0.e0.p.d.m0.n.n1.i iVarLowerBoundIfFlexible2 = fVar.lowerBoundIfFlexible(hVarPrepareType);
        d0.e0.p.d.m0.n.n1.i iVarUpperBoundIfFlexible2 = fVar.upperBoundIfFlexible(hVarPrepareType2);
        if (c.a.isPossibleSubtype(fVar, iVarLowerBoundIfFlexible2, iVarUpperBoundIfFlexible2)) {
            d0.e0.p.d.m0.n.n1.i iVarLowerBoundIfFlexible3 = fVar.lowerBoundIfFlexible(iVarLowerBoundIfFlexible2);
            d0.e0.p.d.m0.n.n1.i iVarUpperBoundIfFlexible3 = fVar.upperBoundIfFlexible(iVarUpperBoundIfFlexible2);
            if (!fVar.isIntegerLiteralType(iVarLowerBoundIfFlexible3) && !fVar.isIntegerLiteralType(iVarUpperBoundIfFlexible3)) {
                bool = null;
            } else if (fVar.isIntegerLiteralType(iVarLowerBoundIfFlexible3) && fVar.isIntegerLiteralType(iVarUpperBoundIfFlexible3)) {
                bool = Boolean.TRUE;
            } else if (fVar.isIntegerLiteralType(iVarLowerBoundIfFlexible3)) {
                if (a(fVar, this, iVarLowerBoundIfFlexible3, iVarUpperBoundIfFlexible3, false)) {
                    bool = Boolean.TRUE;
                } else {
                    bool = null;
                }
            } else if (fVar.isIntegerLiteralType(iVarUpperBoundIfFlexible3)) {
                d0.e0.p.d.m0.n.n1.l lVarTypeConstructor2 = fVar.typeConstructor(iVarLowerBoundIfFlexible3);
                if (lVarTypeConstructor2 instanceof d0.e0.p.d.m0.n.n1.g) {
                    Collection<d0.e0.p.d.m0.n.n1.h> collectionSupertypes2 = fVar.supertypes(lVarTypeConstructor2);
                    if (!(collectionSupertypes2 instanceof Collection) || !collectionSupertypes2.isEmpty()) {
                        Iterator<T> it2 = collectionSupertypes2.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z4 = false;
                                break;
                            }
                            d0.e0.p.d.m0.n.n1.i iVarAsSimpleType = fVar.asSimpleType((d0.e0.p.d.m0.n.n1.h) it2.next());
                            if (d0.z.d.m.areEqual(iVarAsSimpleType == null ? null : Boolean.valueOf(fVar.isIntegerLiteralType(iVarAsSimpleType)), Boolean.TRUE)) {
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
                if (z3 || a(fVar, this, iVarUpperBoundIfFlexible3, iVarLowerBoundIfFlexible3, true)) {
                    bool = Boolean.TRUE;
                } else {
                    bool = null;
                }
            } else {
                bool = null;
            }
            if (bool != null) {
                boolean zBooleanValue2 = bool.booleanValue();
                f.addSubtypeConstraint$default(fVar, iVarLowerBoundIfFlexible2, iVarUpperBoundIfFlexible2, false, 4, null);
                return zBooleanValue2;
            }
            d0.e0.p.d.m0.n.n1.l lVarTypeConstructor3 = fVar.typeConstructor(iVarUpperBoundIfFlexible2);
            if ((!fVar.areEqualTypeConstructors(fVar.typeConstructor(iVarLowerBoundIfFlexible2), lVarTypeConstructor3) || fVar.parametersCount(lVarTypeConstructor3) != 0) && !fVar.isAnyConstructor(fVar.typeConstructor(iVarUpperBoundIfFlexible2))) {
                List<d0.e0.p.d.m0.n.n1.i> listFindCorrespondingSupertypes = findCorrespondingSupertypes(fVar, iVarLowerBoundIfFlexible2, lVarTypeConstructor3);
                int size = listFindCorrespondingSupertypes.size();
                if (size == 0) {
                    d0.e0.p.d.m0.n.n1.l lVarTypeConstructor4 = fVar.typeConstructor(iVarLowerBoundIfFlexible2);
                    if (fVar.isClassTypeConstructor(lVarTypeConstructor4)) {
                        return fVar.isNothingConstructor(lVarTypeConstructor4);
                    }
                    if (!fVar.isNothingConstructor(fVar.typeConstructor(iVarLowerBoundIfFlexible2))) {
                        fVar.initialize();
                        ArrayDeque<d0.e0.p.d.m0.n.n1.i> supertypesDeque = fVar.getSupertypesDeque();
                        d0.z.d.m.checkNotNull(supertypesDeque);
                        Set<d0.e0.p.d.m0.n.n1.i> supertypesSet = fVar.getSupertypesSet();
                        d0.z.d.m.checkNotNull(supertypesSet);
                        supertypesDeque.push(iVarLowerBoundIfFlexible2);
                        while (!supertypesDeque.isEmpty()) {
                            if (supertypesSet.size() > 1000) {
                                StringBuilder sbZ = b.d.b.a.a.Z("Too many supertypes for type: ", iVarLowerBoundIfFlexible2, ". Supertypes = ");
                                sbZ.append(d0.t.u.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                                throw new IllegalStateException(sbZ.toString().toString());
                            }
                            d0.e0.p.d.m0.n.n1.i iVarPop = supertypesDeque.pop();
                            d0.z.d.m.checkNotNullExpressionValue(iVarPop, "current");
                            if (supertypesSet.add(iVarPop)) {
                                f$b f_b = fVar.isClassType(iVarPop) ? f$b$c.a : f$b$b.a;
                                if (!(!d0.z.d.m.areEqual(f_b, f$b$c.a))) {
                                    f_b = null;
                                }
                                if (f_b == null) {
                                    continue;
                                } else {
                                    Iterator<d0.e0.p.d.m0.n.n1.h> it3 = fVar.supertypes(fVar.typeConstructor(iVarPop)).iterator();
                                    while (it3.hasNext()) {
                                        d0.e0.p.d.m0.n.n1.i iVarTransformType = f_b.transformType(fVar, it3.next());
                                        if (fVar.isNothingConstructor(fVar.typeConstructor(iVarTransformType))) {
                                            fVar.clear();
                                        } else {
                                            supertypesDeque.add(iVarTransformType);
                                        }
                                    }
                                }
                            }
                        }
                        fVar.clear();
                    }
                } else {
                    if (size == 1) {
                        return isSubtypeForSameConstructor(fVar, fVar.asArgumentList((d0.e0.p.d.m0.n.n1.i) d0.t.u.first((List) listFindCorrespondingSupertypes)), iVarUpperBoundIfFlexible2);
                    }
                    d0.e0.p.d.m0.n.n1.a aVar = new d0.e0.p.d.m0.n.n1.a(fVar.parametersCount(lVarTypeConstructor3));
                    int iParametersCount = fVar.parametersCount(lVarTypeConstructor3);
                    if (iParametersCount > 0) {
                        int i = 0;
                        z5 = false;
                        while (true) {
                            int i2 = i + 1;
                            z5 = z5 || fVar.getVariance(fVar.getParameter(lVarTypeConstructor3, i)) != d0.e0.p.d.m0.n.n1.r.OUT;
                            if (z5) {
                                lVar = lVarTypeConstructor3;
                            } else {
                                ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listFindCorrespondingSupertypes, 10));
                                for (d0.e0.p.d.m0.n.n1.i iVar : listFindCorrespondingSupertypes) {
                                    d0.e0.p.d.m0.n.n1.k argumentOrNull = fVar.getArgumentOrNull(iVar, i);
                                    if (argumentOrNull == null) {
                                        lVar2 = lVarTypeConstructor3;
                                    } else {
                                        lVar2 = lVarTypeConstructor3;
                                        if (!(fVar.getVariance(argumentOrNull) == d0.e0.p.d.m0.n.n1.r.INV)) {
                                        }
                                        if (argumentOrNull != null) {
                                            throw new IllegalStateException(("Incorrect type: " + iVar + ", subType: " + iVarLowerBoundIfFlexible2 + ", superType: " + iVarUpperBoundIfFlexible2).toString());
                                        }
                                        arrayList.add(fVar.getType(argumentOrNull));
                                        lVarTypeConstructor3 = lVar2;
                                    }
                                    argumentOrNull = null;
                                    if (argumentOrNull != null) {
                                        throw new IllegalStateException(("Incorrect type: " + iVar + ", subType: " + iVarLowerBoundIfFlexible2 + ", superType: " + iVarUpperBoundIfFlexible2).toString());
                                    }
                                    arrayList.add(fVar.getType(argumentOrNull));
                                    lVarTypeConstructor3 = lVar2;
                                }
                                lVar = lVarTypeConstructor3;
                                aVar.add(fVar.asTypeArgument(fVar.intersectTypes(arrayList)));
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
                    if (z5 || !isSubtypeForSameConstructor(fVar, aVar, iVarUpperBoundIfFlexible2)) {
                        if (!listFindCorrespondingSupertypes.isEmpty()) {
                            Iterator<T> it4 = listFindCorrespondingSupertypes.iterator();
                            while (it4.hasNext()) {
                                if (isSubtypeForSameConstructor(fVar, fVar.asArgumentList((d0.e0.p.d.m0.n.n1.i) it4.next()), iVarUpperBoundIfFlexible2)) {
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
