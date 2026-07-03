package p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1;

import java.util.Collection;
import java.util.List;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.n1.n */
/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11985n extends InterfaceC11988q {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.n1.n$a */
    /* JADX INFO: compiled from: TypeSystemContext.kt */
    public static final class a {
        public static List<InterfaceC11980i> fastCorrespondingSupertypes(InterfaceC11985n interfaceC11985n, InterfaceC11980i interfaceC11980i, InterfaceC11983l interfaceC11983l) {
            C12238m.checkNotNullParameter(interfaceC11985n, "this");
            C12238m.checkNotNullParameter(interfaceC11980i, "receiver");
            C12238m.checkNotNullParameter(interfaceC11983l, "constructor");
            return null;
        }

        public static InterfaceC11982k get(InterfaceC11985n interfaceC11985n, InterfaceC11981j interfaceC11981j, int i) {
            C12238m.checkNotNullParameter(interfaceC11985n, "this");
            C12238m.checkNotNullParameter(interfaceC11981j, "receiver");
            if (interfaceC11981j instanceof InterfaceC11980i) {
                return interfaceC11985n.getArgument((InterfaceC11979h) interfaceC11981j, i);
            }
            if (interfaceC11981j instanceof C11972a) {
                InterfaceC11982k interfaceC11982k = ((C11972a) interfaceC11981j).get(i);
                C12238m.checkNotNullExpressionValue(interfaceC11982k, "get(index)");
                return interfaceC11982k;
            }
            throw new IllegalStateException(("unknown type argument list type: " + interfaceC11981j + ", " + C12216a0.getOrCreateKotlinClass(interfaceC11981j.getClass())).toString());
        }

        public static InterfaceC11982k getArgumentOrNull(InterfaceC11985n interfaceC11985n, InterfaceC11980i interfaceC11980i, int i) {
            C12238m.checkNotNullParameter(interfaceC11985n, "this");
            C12238m.checkNotNullParameter(interfaceC11980i, "receiver");
            boolean z2 = false;
            if (i >= 0 && i < interfaceC11985n.argumentsCount(interfaceC11980i)) {
                z2 = true;
            }
            if (z2) {
                return interfaceC11985n.getArgument(interfaceC11980i, i);
            }
            return null;
        }

        public static boolean hasFlexibleNullability(InterfaceC11985n interfaceC11985n, InterfaceC11979h interfaceC11979h) {
            C12238m.checkNotNullParameter(interfaceC11985n, "this");
            C12238m.checkNotNullParameter(interfaceC11979h, "receiver");
            return interfaceC11985n.isMarkedNullable(interfaceC11985n.lowerBoundIfFlexible(interfaceC11979h)) != interfaceC11985n.isMarkedNullable(interfaceC11985n.upperBoundIfFlexible(interfaceC11979h));
        }

        public static boolean isClassType(InterfaceC11985n interfaceC11985n, InterfaceC11980i interfaceC11980i) {
            C12238m.checkNotNullParameter(interfaceC11985n, "this");
            C12238m.checkNotNullParameter(interfaceC11980i, "receiver");
            return interfaceC11985n.isClassTypeConstructor(interfaceC11985n.typeConstructor(interfaceC11980i));
        }

        public static boolean isDefinitelyNotNullType(InterfaceC11985n interfaceC11985n, InterfaceC11979h interfaceC11979h) {
            C12238m.checkNotNullParameter(interfaceC11985n, "this");
            C12238m.checkNotNullParameter(interfaceC11979h, "receiver");
            InterfaceC11980i interfaceC11980iAsSimpleType = interfaceC11985n.asSimpleType(interfaceC11979h);
            return (interfaceC11980iAsSimpleType == null ? null : interfaceC11985n.asDefinitelyNotNullType(interfaceC11980iAsSimpleType)) != null;
        }

        public static boolean isDynamic(InterfaceC11985n interfaceC11985n, InterfaceC11979h interfaceC11979h) {
            C12238m.checkNotNullParameter(interfaceC11985n, "this");
            C12238m.checkNotNullParameter(interfaceC11979h, "receiver");
            InterfaceC11977f interfaceC11977fAsFlexibleType = interfaceC11985n.asFlexibleType(interfaceC11979h);
            return (interfaceC11977fAsFlexibleType == null ? null : interfaceC11985n.asDynamicType(interfaceC11977fAsFlexibleType)) != null;
        }

        public static boolean isIntegerLiteralType(InterfaceC11985n interfaceC11985n, InterfaceC11980i interfaceC11980i) {
            C12238m.checkNotNullParameter(interfaceC11985n, "this");
            C12238m.checkNotNullParameter(interfaceC11980i, "receiver");
            return interfaceC11985n.isIntegerLiteralTypeConstructor(interfaceC11985n.typeConstructor(interfaceC11980i));
        }

        public static boolean isMarkedNullable(InterfaceC11985n interfaceC11985n, InterfaceC11979h interfaceC11979h) {
            C12238m.checkNotNullParameter(interfaceC11985n, "this");
            C12238m.checkNotNullParameter(interfaceC11979h, "receiver");
            return (interfaceC11979h instanceof InterfaceC11980i) && interfaceC11985n.isMarkedNullable((InterfaceC11980i) interfaceC11979h);
        }

        public static boolean isNothing(InterfaceC11985n interfaceC11985n, InterfaceC11979h interfaceC11979h) {
            C12238m.checkNotNullParameter(interfaceC11985n, "this");
            C12238m.checkNotNullParameter(interfaceC11979h, "receiver");
            return interfaceC11985n.isNothingConstructor(interfaceC11985n.typeConstructor(interfaceC11979h)) && !interfaceC11985n.isNullableType(interfaceC11979h);
        }

        public static InterfaceC11980i lowerBoundIfFlexible(InterfaceC11985n interfaceC11985n, InterfaceC11979h interfaceC11979h) {
            C12238m.checkNotNullParameter(interfaceC11985n, "this");
            C12238m.checkNotNullParameter(interfaceC11979h, "receiver");
            InterfaceC11977f interfaceC11977fAsFlexibleType = interfaceC11985n.asFlexibleType(interfaceC11979h);
            if (interfaceC11977fAsFlexibleType != null) {
                return interfaceC11985n.lowerBound(interfaceC11977fAsFlexibleType);
            }
            InterfaceC11980i interfaceC11980iAsSimpleType = interfaceC11985n.asSimpleType(interfaceC11979h);
            C12238m.checkNotNull(interfaceC11980iAsSimpleType);
            return interfaceC11980iAsSimpleType;
        }

        public static int size(InterfaceC11985n interfaceC11985n, InterfaceC11981j interfaceC11981j) {
            C12238m.checkNotNullParameter(interfaceC11985n, "this");
            C12238m.checkNotNullParameter(interfaceC11981j, "receiver");
            if (interfaceC11981j instanceof InterfaceC11980i) {
                return interfaceC11985n.argumentsCount((InterfaceC11979h) interfaceC11981j);
            }
            if (interfaceC11981j instanceof C11972a) {
                return ((C11972a) interfaceC11981j).size();
            }
            throw new IllegalStateException(("unknown type argument list type: " + interfaceC11981j + ", " + C12216a0.getOrCreateKotlinClass(interfaceC11981j.getClass())).toString());
        }

        public static InterfaceC11983l typeConstructor(InterfaceC11985n interfaceC11985n, InterfaceC11979h interfaceC11979h) {
            C12238m.checkNotNullParameter(interfaceC11985n, "this");
            C12238m.checkNotNullParameter(interfaceC11979h, "receiver");
            InterfaceC11980i interfaceC11980iAsSimpleType = interfaceC11985n.asSimpleType(interfaceC11979h);
            if (interfaceC11980iAsSimpleType == null) {
                interfaceC11980iAsSimpleType = interfaceC11985n.lowerBoundIfFlexible(interfaceC11979h);
            }
            return interfaceC11985n.typeConstructor(interfaceC11980iAsSimpleType);
        }

        public static InterfaceC11980i upperBoundIfFlexible(InterfaceC11985n interfaceC11985n, InterfaceC11979h interfaceC11979h) {
            C12238m.checkNotNullParameter(interfaceC11985n, "this");
            C12238m.checkNotNullParameter(interfaceC11979h, "receiver");
            InterfaceC11977f interfaceC11977fAsFlexibleType = interfaceC11985n.asFlexibleType(interfaceC11979h);
            if (interfaceC11977fAsFlexibleType != null) {
                return interfaceC11985n.upperBound(interfaceC11977fAsFlexibleType);
            }
            InterfaceC11980i interfaceC11980iAsSimpleType = interfaceC11985n.asSimpleType(interfaceC11979h);
            C12238m.checkNotNull(interfaceC11980iAsSimpleType);
            return interfaceC11980iAsSimpleType;
        }
    }

    boolean areEqualTypeConstructors(InterfaceC11983l interfaceC11983l, InterfaceC11983l interfaceC11983l2);

    int argumentsCount(InterfaceC11979h interfaceC11979h);

    InterfaceC11981j asArgumentList(InterfaceC11980i interfaceC11980i);

    InterfaceC11974c asCapturedType(InterfaceC11980i interfaceC11980i);

    InterfaceC11975d asDefinitelyNotNullType(InterfaceC11980i interfaceC11980i);

    InterfaceC11976e asDynamicType(InterfaceC11977f interfaceC11977f);

    InterfaceC11977f asFlexibleType(InterfaceC11979h interfaceC11979h);

    InterfaceC11980i asSimpleType(InterfaceC11979h interfaceC11979h);

    InterfaceC11982k asTypeArgument(InterfaceC11979h interfaceC11979h);

    InterfaceC11980i captureFromArguments(InterfaceC11980i interfaceC11980i, EnumC11973b enumC11973b);

    InterfaceC11982k getArgument(InterfaceC11979h interfaceC11979h, int i);

    InterfaceC11984m getParameter(InterfaceC11983l interfaceC11983l, int i);

    InterfaceC11979h getType(InterfaceC11982k interfaceC11982k);

    EnumC11989r getVariance(InterfaceC11982k interfaceC11982k);

    EnumC11989r getVariance(InterfaceC11984m interfaceC11984m);

    InterfaceC11979h intersectTypes(List<? extends InterfaceC11979h> list);

    boolean isAnyConstructor(InterfaceC11983l interfaceC11983l);

    boolean isClassTypeConstructor(InterfaceC11983l interfaceC11983l);

    boolean isCommonFinalClassConstructor(InterfaceC11983l interfaceC11983l);

    boolean isDenotable(InterfaceC11983l interfaceC11983l);

    boolean isError(InterfaceC11979h interfaceC11979h);

    boolean isIntegerLiteralTypeConstructor(InterfaceC11983l interfaceC11983l);

    boolean isIntersection(InterfaceC11983l interfaceC11983l);

    boolean isMarkedNullable(InterfaceC11979h interfaceC11979h);

    boolean isMarkedNullable(InterfaceC11980i interfaceC11980i);

    boolean isNothingConstructor(InterfaceC11983l interfaceC11983l);

    boolean isNullableType(InterfaceC11979h interfaceC11979h);

    boolean isPrimitiveType(InterfaceC11980i interfaceC11980i);

    boolean isProjectionNotNull(InterfaceC11974c interfaceC11974c);

    boolean isStarProjection(InterfaceC11982k interfaceC11982k);

    boolean isStubType(InterfaceC11980i interfaceC11980i);

    InterfaceC11980i lowerBound(InterfaceC11977f interfaceC11977f);

    InterfaceC11980i lowerBoundIfFlexible(InterfaceC11979h interfaceC11979h);

    InterfaceC11979h lowerType(InterfaceC11974c interfaceC11974c);

    InterfaceC11979h makeDefinitelyNotNullOrNotNull(InterfaceC11979h interfaceC11979h);

    InterfaceC11980i original(InterfaceC11975d interfaceC11975d);

    int parametersCount(InterfaceC11983l interfaceC11983l);

    Collection<InterfaceC11979h> possibleIntegerTypes(InterfaceC11980i interfaceC11980i);

    Collection<InterfaceC11979h> supertypes(InterfaceC11983l interfaceC11983l);

    InterfaceC11983l typeConstructor(InterfaceC11979h interfaceC11979h);

    InterfaceC11983l typeConstructor(InterfaceC11980i interfaceC11980i);

    InterfaceC11980i upperBound(InterfaceC11977f interfaceC11977f);

    InterfaceC11980i upperBoundIfFlexible(InterfaceC11979h interfaceC11979h);

    InterfaceC11979h withNullability(InterfaceC11979h interfaceC11979h, boolean z2);

    InterfaceC11980i withNullability(InterfaceC11980i interfaceC11980i, boolean z2);
}
