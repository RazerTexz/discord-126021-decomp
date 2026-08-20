package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.C11972a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.EnumC11973b;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.EnumC11989r;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11974c;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11975d;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11978g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11980i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11981j;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11982k;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11983l;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12041i;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12160r;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.e */
/* JADX INFO: compiled from: AbstractTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11918e {

    /* JADX INFO: renamed from: a */
    public static final C11918e f24752a = new C11918e();

    /* JADX INFO: renamed from: a */
    public static final boolean m10004a(AbstractC11921f abstractC11921f, C11918e c11918e, InterfaceC11980i interfaceC11980i, InterfaceC11980i interfaceC11980i2, boolean z2) {
        Collection<InterfaceC11979h> collectionPossibleIntegerTypes = abstractC11921f.possibleIntegerTypes(interfaceC11980i);
        if ((collectionPossibleIntegerTypes instanceof Collection) && collectionPossibleIntegerTypes.isEmpty()) {
            return false;
        }
        for (InterfaceC11979h interfaceC11979h : collectionPossibleIntegerTypes) {
            if (C12238m.areEqual(abstractC11921f.typeConstructor(interfaceC11979h), abstractC11921f.typeConstructor(interfaceC11980i2)) || (z2 && isSubtypeOf$default(c11918e, abstractC11921f, interfaceC11980i2, interfaceC11979h, false, 8, null))) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isSubtypeOf$default(C11918e c11918e, AbstractC11921f abstractC11921f, InterfaceC11979h interfaceC11979h, InterfaceC11979h interfaceC11979h2, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = false;
        }
        return c11918e.isSubtypeOf(abstractC11921f, interfaceC11979h, interfaceC11979h2, z2);
    }

    /* JADX INFO: renamed from: b */
    public final List<InterfaceC11980i> m10005b(AbstractC11921f abstractC11921f, InterfaceC11980i interfaceC11980i, InterfaceC11983l interfaceC11983l) {
        AbstractC11921f.b bVarSubstitutionSupertypePolicy;
        EnumC11973b enumC11973b = EnumC11973b.FOR_SUBTYPING;
        List<InterfaceC11980i> listFastCorrespondingSupertypes = abstractC11921f.fastCorrespondingSupertypes(interfaceC11980i, interfaceC11983l);
        if (listFastCorrespondingSupertypes == null) {
            if (!abstractC11921f.isClassTypeConstructor(interfaceC11983l) && abstractC11921f.isClassType(interfaceC11980i)) {
                return C12147n.emptyList();
            }
            if (abstractC11921f.isCommonFinalClassConstructor(interfaceC11983l)) {
                if (!abstractC11921f.areEqualTypeConstructors(abstractC11921f.typeConstructor(interfaceC11980i), interfaceC11983l)) {
                    return C12147n.emptyList();
                }
                InterfaceC11980i interfaceC11980iCaptureFromArguments = abstractC11921f.captureFromArguments(interfaceC11980i, enumC11973b);
                if (interfaceC11980iCaptureFromArguments != null) {
                    interfaceC11980i = interfaceC11980iCaptureFromArguments;
                }
                return C12145m.listOf(interfaceC11980i);
            }
            listFastCorrespondingSupertypes = new C12041i<>();
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
                    InterfaceC11980i interfaceC11980iCaptureFromArguments2 = abstractC11921f.captureFromArguments(interfaceC11980iPop, enumC11973b);
                    if (interfaceC11980iCaptureFromArguments2 == null) {
                        interfaceC11980iCaptureFromArguments2 = interfaceC11980iPop;
                    }
                    if (abstractC11921f.areEqualTypeConstructors(abstractC11921f.typeConstructor(interfaceC11980iCaptureFromArguments2), interfaceC11983l)) {
                        listFastCorrespondingSupertypes.add(interfaceC11980iCaptureFromArguments2);
                        bVarSubstitutionSupertypePolicy = AbstractC11921f.b.c.f24767a;
                    } else {
                        bVarSubstitutionSupertypePolicy = abstractC11921f.argumentsCount(interfaceC11980iCaptureFromArguments2) == 0 ? AbstractC11921f.b.C13335b.f24766a : abstractC11921f.substitutionSupertypePolicy(interfaceC11980iCaptureFromArguments2);
                    }
                    if (!(!C12238m.areEqual(bVarSubstitutionSupertypePolicy, AbstractC11921f.b.c.f24767a))) {
                        bVarSubstitutionSupertypePolicy = null;
                    }
                    if (bVarSubstitutionSupertypePolicy != null) {
                        Iterator<InterfaceC11979h> it = abstractC11921f.supertypes(abstractC11921f.typeConstructor(interfaceC11980iPop)).iterator();
                        while (it.hasNext()) {
                            supertypesDeque.add(bVarSubstitutionSupertypePolicy.transformType(abstractC11921f, it.next()));
                        }
                    }
                }
            }
            abstractC11921f.clear();
        }
        return listFastCorrespondingSupertypes;
    }

    /* JADX INFO: renamed from: c */
    public final List<InterfaceC11980i> m10006c(AbstractC11921f abstractC11921f, InterfaceC11980i interfaceC11980i, InterfaceC11983l interfaceC11983l) {
        List<InterfaceC11980i> listM10005b = m10005b(abstractC11921f, interfaceC11980i, interfaceC11983l);
        if (listM10005b.size() < 2) {
            return listM10005b;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listM10005b.iterator();
        while (true) {
            boolean z2 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            InterfaceC11981j interfaceC11981jAsArgumentList = abstractC11921f.asArgumentList((InterfaceC11980i) next);
            int size = abstractC11921f.size(interfaceC11981jAsArgumentList);
            for (int i = 0; i < size; i++) {
                if (!(abstractC11921f.asFlexibleType(abstractC11921f.getType(abstractC11921f.get(interfaceC11981jAsArgumentList, i))) == null)) {
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        return arrayList.isEmpty() ^ true ? arrayList : listM10005b;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m10007d(AbstractC11921f abstractC11921f, InterfaceC11979h interfaceC11979h) {
        return abstractC11921f.isDenotable(abstractC11921f.typeConstructor(interfaceC11979h)) && !abstractC11921f.isDynamic(interfaceC11979h) && !abstractC11921f.isDefinitelyNotNullType(interfaceC11979h) && C12238m.areEqual(abstractC11921f.typeConstructor(abstractC11921f.lowerBoundIfFlexible(interfaceC11979h)), abstractC11921f.typeConstructor(abstractC11921f.upperBoundIfFlexible(interfaceC11979h)));
    }

    public final EnumC11989r effectiveVariance(EnumC11989r enumC11989r, EnumC11989r enumC11989r2) {
        C12238m.checkNotNullParameter(enumC11989r, "declared");
        C12238m.checkNotNullParameter(enumC11989r2, "useSite");
        EnumC11989r enumC11989r3 = EnumC11989r.INV;
        if (enumC11989r == enumC11989r3) {
            return enumC11989r2;
        }
        if (enumC11989r2 == enumC11989r3 || enumC11989r == enumC11989r2) {
            return enumC11989r;
        }
        return null;
    }

    public final boolean equalTypes(AbstractC11921f abstractC11921f, InterfaceC11979h interfaceC11979h, InterfaceC11979h interfaceC11979h2) {
        C12238m.checkNotNullParameter(abstractC11921f, "context");
        C12238m.checkNotNullParameter(interfaceC11979h, "a");
        C12238m.checkNotNullParameter(interfaceC11979h2, "b");
        if (interfaceC11979h == interfaceC11979h2) {
            return true;
        }
        if (m10007d(abstractC11921f, interfaceC11979h) && m10007d(abstractC11921f, interfaceC11979h2)) {
            InterfaceC11979h interfaceC11979hRefineType = abstractC11921f.refineType(interfaceC11979h);
            InterfaceC11979h interfaceC11979hRefineType2 = abstractC11921f.refineType(interfaceC11979h2);
            InterfaceC11980i interfaceC11980iLowerBoundIfFlexible = abstractC11921f.lowerBoundIfFlexible(interfaceC11979hRefineType);
            if (!abstractC11921f.areEqualTypeConstructors(abstractC11921f.typeConstructor(interfaceC11979hRefineType), abstractC11921f.typeConstructor(interfaceC11979hRefineType2))) {
                return false;
            }
            if (abstractC11921f.argumentsCount(interfaceC11980iLowerBoundIfFlexible) == 0) {
                return abstractC11921f.hasFlexibleNullability(interfaceC11979hRefineType) || abstractC11921f.hasFlexibleNullability(interfaceC11979hRefineType2) || abstractC11921f.isMarkedNullable(interfaceC11980iLowerBoundIfFlexible) == abstractC11921f.isMarkedNullable(abstractC11921f.lowerBoundIfFlexible(interfaceC11979hRefineType2));
            }
        }
        return isSubtypeOf$default(this, abstractC11921f, interfaceC11979h, interfaceC11979h2, false, 8, null) && isSubtypeOf$default(this, abstractC11921f, interfaceC11979h2, interfaceC11979h, false, 8, null);
    }

    public final List<InterfaceC11980i> findCorrespondingSupertypes(AbstractC11921f abstractC11921f, InterfaceC11980i interfaceC11980i, InterfaceC11983l interfaceC11983l) {
        AbstractC11921f.b bVar;
        C12238m.checkNotNullParameter(abstractC11921f, "<this>");
        C12238m.checkNotNullParameter(interfaceC11980i, "subType");
        C12238m.checkNotNullParameter(interfaceC11983l, "superConstructor");
        if (abstractC11921f.isClassType(interfaceC11980i)) {
            return m10006c(abstractC11921f, interfaceC11980i, interfaceC11983l);
        }
        if (!abstractC11921f.isClassTypeConstructor(interfaceC11983l) && !abstractC11921f.isIntegerLiteralTypeConstructor(interfaceC11983l)) {
            return m10005b(abstractC11921f, interfaceC11980i, interfaceC11983l);
        }
        C12041i<InterfaceC11980i> c12041i = new C12041i();
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
                if (abstractC11921f.isClassType(interfaceC11980iPop)) {
                    c12041i.add(interfaceC11980iPop);
                    bVar = AbstractC11921f.b.c.f24767a;
                } else {
                    bVar = AbstractC11921f.b.C13335b.f24766a;
                }
                if (!(!C12238m.areEqual(bVar, AbstractC11921f.b.c.f24767a))) {
                    bVar = null;
                }
                if (bVar != null) {
                    Iterator<InterfaceC11979h> it = abstractC11921f.supertypes(abstractC11921f.typeConstructor(interfaceC11980iPop)).iterator();
                    while (it.hasNext()) {
                        supertypesDeque.add(bVar.transformType(abstractC11921f, it.next()));
                    }
                }
            }
        }
        abstractC11921f.clear();
        ArrayList arrayList = new ArrayList();
        for (InterfaceC11980i interfaceC11980i2 : c12041i) {
            C12238m.checkNotNullExpressionValue(interfaceC11980i2, "it");
            C12160r.addAll(arrayList, m10006c(abstractC11921f, interfaceC11980i2, interfaceC11983l));
        }
        return arrayList;
    }

    public final boolean isSubtypeForSameConstructor(AbstractC11921f abstractC11921f, InterfaceC11981j interfaceC11981j, InterfaceC11980i interfaceC11980i) {
        boolean zIsSubtypeOf$default;
        C12238m.checkNotNullParameter(abstractC11921f, "<this>");
        C12238m.checkNotNullParameter(interfaceC11981j, "capturedSubArguments");
        C12238m.checkNotNullParameter(interfaceC11980i, "superType");
        InterfaceC11983l interfaceC11983lTypeConstructor = abstractC11921f.typeConstructor(interfaceC11980i);
        int iParametersCount = abstractC11921f.parametersCount(interfaceC11983lTypeConstructor);
        if (iParametersCount > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                InterfaceC11982k argument = abstractC11921f.getArgument(interfaceC11980i, i);
                if (!abstractC11921f.isStarProjection(argument)) {
                    InterfaceC11979h type = abstractC11921f.getType(argument);
                    InterfaceC11982k interfaceC11982k = abstractC11921f.get(interfaceC11981j, i);
                    abstractC11921f.getVariance(interfaceC11982k);
                    EnumC11989r enumC11989r = EnumC11989r.INV;
                    InterfaceC11979h type2 = abstractC11921f.getType(interfaceC11982k);
                    EnumC11989r enumC11989rEffectiveVariance = effectiveVariance(abstractC11921f.getVariance(abstractC11921f.getParameter(interfaceC11983lTypeConstructor, i)), abstractC11921f.getVariance(argument));
                    if (enumC11989rEffectiveVariance == null) {
                        return abstractC11921f.isErrorTypeEqualsToAnything();
                    }
                    if (abstractC11921f.f24758a > 100) {
                        throw new IllegalStateException(C12238m.stringPlus("Arguments depth is too high. Some related argument: ", type2).toString());
                    }
                    abstractC11921f.f24758a++;
                    int iOrdinal = enumC11989rEffectiveVariance.ordinal();
                    if (iOrdinal == 0) {
                        zIsSubtypeOf$default = isSubtypeOf$default(this, abstractC11921f, type, type2, false, 8, null);
                    } else if (iOrdinal == 1) {
                        zIsSubtypeOf$default = isSubtypeOf$default(this, abstractC11921f, type2, type, false, 8, null);
                    } else {
                        if (iOrdinal != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        zIsSubtypeOf$default = equalTypes(abstractC11921f, type2, type);
                    }
                    abstractC11921f.f24758a--;
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
    public final boolean isSubtypeOf(AbstractC11921f abstractC11921f, InterfaceC11979h interfaceC11979h, InterfaceC11979h interfaceC11979h2, boolean z2) {
        Boolean boolValueOf;
        boolean z3;
        Boolean bool;
        boolean z4;
        boolean z5;
        InterfaceC11983l interfaceC11983l;
        InterfaceC11983l interfaceC11983l2;
        InterfaceC11983l interfaceC11983lTypeConstructor;
        Collection<InterfaceC11979h> collectionSupertypes;
        Iterator<T> it;
        boolean z6;
        C12238m.checkNotNullParameter(abstractC11921f, "context");
        C12238m.checkNotNullParameter(interfaceC11979h, "subType");
        C12238m.checkNotNullParameter(interfaceC11979h2, "superType");
        if (interfaceC11979h == interfaceC11979h2) {
            return true;
        }
        if (!abstractC11921f.customIsSubtypeOf(interfaceC11979h, interfaceC11979h2)) {
            return false;
        }
        InterfaceC11979h interfaceC11979hPrepareType = abstractC11921f.prepareType(abstractC11921f.refineType(interfaceC11979h));
        InterfaceC11979h interfaceC11979hPrepareType2 = abstractC11921f.prepareType(abstractC11921f.refineType(interfaceC11979h2));
        InterfaceC11980i interfaceC11980iLowerBoundIfFlexible = abstractC11921f.lowerBoundIfFlexible(interfaceC11979hPrepareType);
        InterfaceC11980i interfaceC11980iUpperBoundIfFlexible = abstractC11921f.upperBoundIfFlexible(interfaceC11979hPrepareType2);
        if (abstractC11921f.isError(interfaceC11980iLowerBoundIfFlexible) || abstractC11921f.isError(interfaceC11980iUpperBoundIfFlexible)) {
            boolValueOf = abstractC11921f.isErrorTypeEqualsToAnything() ? Boolean.TRUE : (!abstractC11921f.isMarkedNullable(interfaceC11980iLowerBoundIfFlexible) || abstractC11921f.isMarkedNullable(interfaceC11980iUpperBoundIfFlexible)) ? Boolean.valueOf(C11915d.f24747a.strictEqualTypes(abstractC11921f, abstractC11921f.withNullability(interfaceC11980iLowerBoundIfFlexible, false), abstractC11921f.withNullability(interfaceC11980iUpperBoundIfFlexible, false))) : Boolean.FALSE;
        } else if (abstractC11921f.isStubType(interfaceC11980iLowerBoundIfFlexible) || abstractC11921f.isStubType(interfaceC11980iUpperBoundIfFlexible)) {
            boolValueOf = Boolean.valueOf(abstractC11921f.isStubTypeEqualsToAnything());
        } else {
            InterfaceC11975d interfaceC11975dAsDefinitelyNotNullType = abstractC11921f.asDefinitelyNotNullType(interfaceC11980iUpperBoundIfFlexible);
            InterfaceC11974c interfaceC11974cAsCapturedType = abstractC11921f.asCapturedType(interfaceC11975dAsDefinitelyNotNullType == null ? interfaceC11980iUpperBoundIfFlexible : abstractC11921f.original(interfaceC11975dAsDefinitelyNotNullType));
            InterfaceC11979h interfaceC11979hLowerType = interfaceC11974cAsCapturedType == null ? null : abstractC11921f.lowerType(interfaceC11974cAsCapturedType);
            if (interfaceC11974cAsCapturedType == null || interfaceC11979hLowerType == null) {
                interfaceC11983lTypeConstructor = abstractC11921f.typeConstructor(interfaceC11980iUpperBoundIfFlexible);
                if (abstractC11921f.isIntersection(interfaceC11983lTypeConstructor)) {
                    abstractC11921f.isMarkedNullable(interfaceC11980iUpperBoundIfFlexible);
                    collectionSupertypes = abstractC11921f.supertypes(interfaceC11983lTypeConstructor);
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
                        if (!isSubtypeOf$default(this, abstractC11921f, interfaceC11980iLowerBoundIfFlexible, (InterfaceC11979h) it.next(), false, 8, null)) {
                            z6 = false;
                            break;
                        }
                    }
                    boolValueOf = Boolean.valueOf(z6);
                } else {
                    boolValueOf = null;
                }
            } else {
                if (abstractC11921f.isMarkedNullable(interfaceC11980iUpperBoundIfFlexible)) {
                    interfaceC11979hLowerType = abstractC11921f.withNullability(interfaceC11979hLowerType, true);
                } else if (abstractC11921f.isDefinitelyNotNullType(interfaceC11980iUpperBoundIfFlexible)) {
                    interfaceC11979hLowerType = abstractC11921f.makeDefinitelyNotNullOrNotNull(interfaceC11979hLowerType);
                }
                InterfaceC11979h interfaceC11979h3 = interfaceC11979hLowerType;
                int iOrdinal = abstractC11921f.getLowerCapturedTypePolicy(interfaceC11980iLowerBoundIfFlexible, interfaceC11974cAsCapturedType).ordinal();
                if (iOrdinal == 0) {
                    boolValueOf = Boolean.valueOf(isSubtypeOf$default(this, abstractC11921f, interfaceC11980iLowerBoundIfFlexible, interfaceC11979h3, false, 8, null));
                } else if (iOrdinal == 1 && isSubtypeOf$default(this, abstractC11921f, interfaceC11980iLowerBoundIfFlexible, interfaceC11979h3, false, 8, null)) {
                    boolValueOf = Boolean.TRUE;
                } else {
                    interfaceC11983lTypeConstructor = abstractC11921f.typeConstructor(interfaceC11980iUpperBoundIfFlexible);
                    if (abstractC11921f.isIntersection(interfaceC11983lTypeConstructor)) {
                        abstractC11921f.isMarkedNullable(interfaceC11980iUpperBoundIfFlexible);
                        collectionSupertypes = abstractC11921f.supertypes(interfaceC11983lTypeConstructor);
                        if (!(collectionSupertypes instanceof Collection)) {
                            it = collectionSupertypes.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z6 = true;
                                    break;
                                }
                                if (!isSubtypeOf$default(this, abstractC11921f, interfaceC11980iLowerBoundIfFlexible, (InterfaceC11979h) it.next(), false, 8, null)) {
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
                                if (!isSubtypeOf$default(this, abstractC11921f, interfaceC11980iLowerBoundIfFlexible, (InterfaceC11979h) it.next(), false, 8, null)) {
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
            abstractC11921f.addSubtypeConstraint(interfaceC11979hPrepareType, interfaceC11979hPrepareType2, z2);
            return zBooleanValue;
        }
        Boolean boolAddSubtypeConstraint = abstractC11921f.addSubtypeConstraint(interfaceC11979hPrepareType, interfaceC11979hPrepareType2, z2);
        if (boolAddSubtypeConstraint != null) {
            return boolAddSubtypeConstraint.booleanValue();
        }
        InterfaceC11980i interfaceC11980iLowerBoundIfFlexible2 = abstractC11921f.lowerBoundIfFlexible(interfaceC11979hPrepareType);
        InterfaceC11980i interfaceC11980iUpperBoundIfFlexible2 = abstractC11921f.upperBoundIfFlexible(interfaceC11979hPrepareType2);
        if (C11912c.f24743a.isPossibleSubtype(abstractC11921f, interfaceC11980iLowerBoundIfFlexible2, interfaceC11980iUpperBoundIfFlexible2)) {
            InterfaceC11980i interfaceC11980iLowerBoundIfFlexible3 = abstractC11921f.lowerBoundIfFlexible(interfaceC11980iLowerBoundIfFlexible2);
            InterfaceC11980i interfaceC11980iUpperBoundIfFlexible3 = abstractC11921f.upperBoundIfFlexible(interfaceC11980iUpperBoundIfFlexible2);
            if (!abstractC11921f.isIntegerLiteralType(interfaceC11980iLowerBoundIfFlexible3) && !abstractC11921f.isIntegerLiteralType(interfaceC11980iUpperBoundIfFlexible3)) {
                bool = null;
            } else if (abstractC11921f.isIntegerLiteralType(interfaceC11980iLowerBoundIfFlexible3) && abstractC11921f.isIntegerLiteralType(interfaceC11980iUpperBoundIfFlexible3)) {
                bool = Boolean.TRUE;
            } else if (abstractC11921f.isIntegerLiteralType(interfaceC11980iLowerBoundIfFlexible3)) {
                if (m10004a(abstractC11921f, this, interfaceC11980iLowerBoundIfFlexible3, interfaceC11980iUpperBoundIfFlexible3, false)) {
                    bool = Boolean.TRUE;
                } else {
                    bool = null;
                }
            } else if (abstractC11921f.isIntegerLiteralType(interfaceC11980iUpperBoundIfFlexible3)) {
                InterfaceC11983l interfaceC11983lTypeConstructor2 = abstractC11921f.typeConstructor(interfaceC11980iLowerBoundIfFlexible3);
                if (interfaceC11983lTypeConstructor2 instanceof InterfaceC11978g) {
                    Collection<InterfaceC11979h> collectionSupertypes2 = abstractC11921f.supertypes(interfaceC11983lTypeConstructor2);
                    if (!(collectionSupertypes2 instanceof Collection) || !collectionSupertypes2.isEmpty()) {
                        Iterator<T> it2 = collectionSupertypes2.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z4 = false;
                                break;
                            }
                            InterfaceC11980i interfaceC11980iAsSimpleType = abstractC11921f.asSimpleType((InterfaceC11979h) it2.next());
                            if (C12238m.areEqual(interfaceC11980iAsSimpleType == null ? null : Boolean.valueOf(abstractC11921f.isIntegerLiteralType(interfaceC11980iAsSimpleType)), Boolean.TRUE)) {
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
                if (z3 || m10004a(abstractC11921f, this, interfaceC11980iUpperBoundIfFlexible3, interfaceC11980iLowerBoundIfFlexible3, true)) {
                    bool = Boolean.TRUE;
                } else {
                    bool = null;
                }
            } else {
                bool = null;
            }
            if (bool != null) {
                boolean zBooleanValue2 = bool.booleanValue();
                AbstractC11921f.addSubtypeConstraint$default(abstractC11921f, interfaceC11980iLowerBoundIfFlexible2, interfaceC11980iUpperBoundIfFlexible2, false, 4, null);
                return zBooleanValue2;
            }
            InterfaceC11983l interfaceC11983lTypeConstructor3 = abstractC11921f.typeConstructor(interfaceC11980iUpperBoundIfFlexible2);
            if ((!abstractC11921f.areEqualTypeConstructors(abstractC11921f.typeConstructor(interfaceC11980iLowerBoundIfFlexible2), interfaceC11983lTypeConstructor3) || abstractC11921f.parametersCount(interfaceC11983lTypeConstructor3) != 0) && !abstractC11921f.isAnyConstructor(abstractC11921f.typeConstructor(interfaceC11980iUpperBoundIfFlexible2))) {
                List<InterfaceC11980i> listFindCorrespondingSupertypes = findCorrespondingSupertypes(abstractC11921f, interfaceC11980iLowerBoundIfFlexible2, interfaceC11983lTypeConstructor3);
                int size = listFindCorrespondingSupertypes.size();
                if (size == 0) {
                    InterfaceC11983l interfaceC11983lTypeConstructor4 = abstractC11921f.typeConstructor(interfaceC11980iLowerBoundIfFlexible2);
                    if (abstractC11921f.isClassTypeConstructor(interfaceC11983lTypeConstructor4)) {
                        return abstractC11921f.isNothingConstructor(interfaceC11983lTypeConstructor4);
                    }
                    if (!abstractC11921f.isNothingConstructor(abstractC11921f.typeConstructor(interfaceC11980iLowerBoundIfFlexible2))) {
                        abstractC11921f.initialize();
                        ArrayDeque<InterfaceC11980i> supertypesDeque = abstractC11921f.getSupertypesDeque();
                        C12238m.checkNotNull(supertypesDeque);
                        Set<InterfaceC11980i> supertypesSet = abstractC11921f.getSupertypesSet();
                        C12238m.checkNotNull(supertypesSet);
                        supertypesDeque.push(interfaceC11980iLowerBoundIfFlexible2);
                        while (!supertypesDeque.isEmpty()) {
                            if (supertypesSet.size() > 1000) {
                                StringBuilder sbM838Z = C1643a.m838Z("Too many supertypes for type: ", interfaceC11980iLowerBoundIfFlexible2, ". Supertypes = ");
                                sbM838Z.append(C12163u.joinToString$default(supertypesSet, null, null, null, 0, null, null, 63, null));
                                throw new IllegalStateException(sbM838Z.toString().toString());
                            }
                            InterfaceC11980i interfaceC11980iPop = supertypesDeque.pop();
                            C12238m.checkNotNullExpressionValue(interfaceC11980iPop, "current");
                            if (supertypesSet.add(interfaceC11980iPop)) {
                                AbstractC11921f.b bVar = abstractC11921f.isClassType(interfaceC11980iPop) ? AbstractC11921f.b.c.f24767a : AbstractC11921f.b.C13335b.f24766a;
                                if (!(!C12238m.areEqual(bVar, AbstractC11921f.b.c.f24767a))) {
                                    bVar = null;
                                }
                                if (bVar == null) {
                                    continue;
                                } else {
                                    Iterator<InterfaceC11979h> it3 = abstractC11921f.supertypes(abstractC11921f.typeConstructor(interfaceC11980iPop)).iterator();
                                    while (it3.hasNext()) {
                                        InterfaceC11980i interfaceC11980iTransformType = bVar.transformType(abstractC11921f, it3.next());
                                        if (abstractC11921f.isNothingConstructor(abstractC11921f.typeConstructor(interfaceC11980iTransformType))) {
                                            abstractC11921f.clear();
                                        } else {
                                            supertypesDeque.add(interfaceC11980iTransformType);
                                        }
                                    }
                                }
                            }
                        }
                        abstractC11921f.clear();
                    }
                } else {
                    if (size == 1) {
                        return isSubtypeForSameConstructor(abstractC11921f, abstractC11921f.asArgumentList((InterfaceC11980i) C12163u.first((List) listFindCorrespondingSupertypes)), interfaceC11980iUpperBoundIfFlexible2);
                    }
                    C11972a c11972a = new C11972a(abstractC11921f.parametersCount(interfaceC11983lTypeConstructor3));
                    int iParametersCount = abstractC11921f.parametersCount(interfaceC11983lTypeConstructor3);
                    if (iParametersCount > 0) {
                        int i = 0;
                        z5 = false;
                        while (true) {
                            int i2 = i + 1;
                            z5 = z5 || abstractC11921f.getVariance(abstractC11921f.getParameter(interfaceC11983lTypeConstructor3, i)) != EnumC11989r.OUT;
                            if (z5) {
                                interfaceC11983l = interfaceC11983lTypeConstructor3;
                            } else {
                                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listFindCorrespondingSupertypes, 10));
                                for (InterfaceC11980i interfaceC11980i : listFindCorrespondingSupertypes) {
                                    InterfaceC11982k argumentOrNull = abstractC11921f.getArgumentOrNull(interfaceC11980i, i);
                                    if (argumentOrNull == null) {
                                        interfaceC11983l2 = interfaceC11983lTypeConstructor3;
                                    } else {
                                        interfaceC11983l2 = interfaceC11983lTypeConstructor3;
                                        if (!(abstractC11921f.getVariance(argumentOrNull) == EnumC11989r.INV)) {
                                        }
                                        if (argumentOrNull != null) {
                                            throw new IllegalStateException(("Incorrect type: " + interfaceC11980i + ", subType: " + interfaceC11980iLowerBoundIfFlexible2 + ", superType: " + interfaceC11980iUpperBoundIfFlexible2).toString());
                                        }
                                        arrayList.add(abstractC11921f.getType(argumentOrNull));
                                        interfaceC11983lTypeConstructor3 = interfaceC11983l2;
                                    }
                                    argumentOrNull = null;
                                    if (argumentOrNull != null) {
                                        throw new IllegalStateException(("Incorrect type: " + interfaceC11980i + ", subType: " + interfaceC11980iLowerBoundIfFlexible2 + ", superType: " + interfaceC11980iUpperBoundIfFlexible2).toString());
                                    }
                                    arrayList.add(abstractC11921f.getType(argumentOrNull));
                                    interfaceC11983lTypeConstructor3 = interfaceC11983l2;
                                }
                                interfaceC11983l = interfaceC11983lTypeConstructor3;
                                c11972a.add(abstractC11921f.asTypeArgument(abstractC11921f.intersectTypes(arrayList)));
                            }
                            if (i2 >= iParametersCount) {
                                break;
                            }
                            interfaceC11983lTypeConstructor3 = interfaceC11983l;
                            i = i2;
                        }
                    } else {
                        z5 = false;
                    }
                    if (z5 || !isSubtypeForSameConstructor(abstractC11921f, c11972a, interfaceC11980iUpperBoundIfFlexible2)) {
                        if (!listFindCorrespondingSupertypes.isEmpty()) {
                            Iterator<T> it4 = listFindCorrespondingSupertypes.iterator();
                            while (it4.hasNext()) {
                                if (isSubtypeForSameConstructor(abstractC11921f, abstractC11921f.asArgumentList((InterfaceC11980i) it4.next()), interfaceC11980iUpperBoundIfFlexible2)) {
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
