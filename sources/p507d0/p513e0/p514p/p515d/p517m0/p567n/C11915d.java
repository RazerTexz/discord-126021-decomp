package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11977f;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11980i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11982k;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.d */
/* JADX INFO: compiled from: AbstractStrictEqualityTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11915d {

    /* JADX INFO: renamed from: a */
    public static final C11915d f24747a = new C11915d();

    /* JADX INFO: renamed from: a */
    public final boolean m10002a(InterfaceC11985n interfaceC11985n, InterfaceC11980i interfaceC11980i, InterfaceC11980i interfaceC11980i2) {
        int iArgumentsCount;
        if (interfaceC11985n.argumentsCount(interfaceC11980i) == interfaceC11985n.argumentsCount(interfaceC11980i2) && interfaceC11985n.isMarkedNullable(interfaceC11980i) == interfaceC11985n.isMarkedNullable(interfaceC11980i2)) {
            if ((interfaceC11985n.asDefinitelyNotNullType(interfaceC11980i) == null) == (interfaceC11985n.asDefinitelyNotNullType(interfaceC11980i2) == null) && interfaceC11985n.areEqualTypeConstructors(interfaceC11985n.typeConstructor(interfaceC11980i), interfaceC11985n.typeConstructor(interfaceC11980i2))) {
                if (!interfaceC11985n.identicalArguments(interfaceC11980i, interfaceC11980i2) && (iArgumentsCount = interfaceC11985n.argumentsCount(interfaceC11980i)) > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        InterfaceC11982k argument = interfaceC11985n.getArgument(interfaceC11980i, i);
                        InterfaceC11982k argument2 = interfaceC11985n.getArgument(interfaceC11980i2, i);
                        if (interfaceC11985n.isStarProjection(argument) != interfaceC11985n.isStarProjection(argument2)) {
                            return false;
                        }
                        if (!interfaceC11985n.isStarProjection(argument) && (interfaceC11985n.getVariance(argument) != interfaceC11985n.getVariance(argument2) || !m10003b(interfaceC11985n, interfaceC11985n.getType(argument), interfaceC11985n.getType(argument2)))) {
                            return false;
                        }
                        if (i2 < iArgumentsCount) {
                            i = i2;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m10003b(InterfaceC11985n interfaceC11985n, InterfaceC11979h interfaceC11979h, InterfaceC11979h interfaceC11979h2) {
        if (interfaceC11979h == interfaceC11979h2) {
            return true;
        }
        InterfaceC11980i interfaceC11980iAsSimpleType = interfaceC11985n.asSimpleType(interfaceC11979h);
        InterfaceC11980i interfaceC11980iAsSimpleType2 = interfaceC11985n.asSimpleType(interfaceC11979h2);
        if (interfaceC11980iAsSimpleType != null && interfaceC11980iAsSimpleType2 != null) {
            return m10002a(interfaceC11985n, interfaceC11980iAsSimpleType, interfaceC11980iAsSimpleType2);
        }
        InterfaceC11977f interfaceC11977fAsFlexibleType = interfaceC11985n.asFlexibleType(interfaceC11979h);
        InterfaceC11977f interfaceC11977fAsFlexibleType2 = interfaceC11985n.asFlexibleType(interfaceC11979h2);
        return interfaceC11977fAsFlexibleType != null && interfaceC11977fAsFlexibleType2 != null && m10002a(interfaceC11985n, interfaceC11985n.lowerBound(interfaceC11977fAsFlexibleType), interfaceC11985n.lowerBound(interfaceC11977fAsFlexibleType2)) && m10002a(interfaceC11985n, interfaceC11985n.upperBound(interfaceC11977fAsFlexibleType), interfaceC11985n.upperBound(interfaceC11977fAsFlexibleType2));
    }

    public final boolean strictEqualTypes(InterfaceC11985n interfaceC11985n, InterfaceC11979h interfaceC11979h, InterfaceC11979h interfaceC11979h2) {
        C12238m.checkNotNullParameter(interfaceC11985n, "context");
        C12238m.checkNotNullParameter(interfaceC11979h, "a");
        C12238m.checkNotNullParameter(interfaceC11979h2, "b");
        return m10003b(interfaceC11985n, interfaceC11979h, interfaceC11979h2);
    }
}
