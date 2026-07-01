package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.k.v.IntegerLiteralTypeConstructor;
import d0.e0.p.d.m0.n.IntersectionTypeConstructor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType3;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.SpecialTypes5;
import d0.e0.p.d.m0.n.flexibleTypes2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.v, reason: use source file name */
/* JADX INFO: compiled from: IntersectionType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class IntersectionType2 {
    public static final IntersectionType2 a = new IntersectionType2();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.v$a */
    /* JADX INFO: compiled from: IntersectionType.kt */
    public static final class a {
        public static final a j;
        public static final a k;
        public static final a l;
        public static final a m;
        public static final /* synthetic */ a[] n;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.v$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IntersectionType.kt */
        public static final class C0414a extends a {
            public C0414a(String str, int i) {
                super(str, i, null);
            }

            @Override // d0.e0.p.d.m0.n.l1.IntersectionType2.a
            public a combine(KotlinType3 kotlinType3) {
                Intrinsics3.checkNotNullParameter(kotlinType3, "nextType");
                return f(kotlinType3);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.v$a$b */
        /* JADX INFO: compiled from: IntersectionType.kt */
        public static final class b extends a {
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // d0.e0.p.d.m0.n.l1.IntersectionType2.a
            public b combine(KotlinType3 kotlinType3) {
                Intrinsics3.checkNotNullParameter(kotlinType3, "nextType");
                return this;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.v$a$c */
        /* JADX INFO: compiled from: IntersectionType.kt */
        public static final class c extends a {
            public c(String str, int i) {
                super(str, i, null);
            }

            @Override // d0.e0.p.d.m0.n.l1.IntersectionType2.a
            public a combine(KotlinType3 kotlinType3) {
                Intrinsics3.checkNotNullParameter(kotlinType3, "nextType");
                return f(kotlinType3);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.v$a$d */
        /* JADX INFO: compiled from: IntersectionType.kt */
        public static final class d extends a {
            public d(String str, int i) {
                super(str, i, null);
            }

            @Override // d0.e0.p.d.m0.n.l1.IntersectionType2.a
            public a combine(KotlinType3 kotlinType3) {
                Intrinsics3.checkNotNullParameter(kotlinType3, "nextType");
                a aVarF = f(kotlinType3);
                return aVarF == a.k ? this : aVarF;
            }
        }

        static {
            c cVar = new c("START", 0);
            j = cVar;
            C0414a c0414a = new C0414a("ACCEPT_NULL", 1);
            k = c0414a;
            d dVar = new d("UNKNOWN", 2);
            l = dVar;
            b bVar = new b("NOT_NULL", 3);
            m = bVar;
            n = new a[]{cVar, c0414a, dVar, bVar};
        }

        public a(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            super(str, i);
        }

        public static a valueOf(String str) {
            Intrinsics3.checkNotNullParameter(str, "value");
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            a[] aVarArr = n;
            a[] aVarArr2 = new a[aVarArr.length];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
            return aVarArr2;
        }

        public abstract a combine(KotlinType3 kotlinType3);

        public final a f(KotlinType3 kotlinType3) {
            Intrinsics3.checkNotNullParameter(kotlinType3, "<this>");
            if (kotlinType3.isMarkedNullable()) {
                return k;
            }
            return NewKotlinTypeChecker3.a.isSubtypeOfAny(kotlinType3) ? m : l;
        }
    }

    public static final boolean access$isStrictSupertype(IntersectionType2 intersectionType2, KotlinType kotlinType, KotlinType kotlinType2) {
        Objects.requireNonNull(intersectionType2);
        NewKotlinTypeChecker2 newKotlinTypeChecker2 = NewKotlinTypeChecker.f3529b.getDefault();
        return newKotlinTypeChecker2.isSubtypeOf(kotlinType, kotlinType2) && !newKotlinTypeChecker2.isSubtypeOf(kotlinType2, kotlinType);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004d  */
    public final Collection<KotlinType4> a(Collection<? extends KotlinType4> collection, Function2<? super KotlinType4, ? super KotlinType4, Boolean> function2) {
        boolean z2;
        ArrayList<KotlinType4> arrayList = new ArrayList(collection);
        Iterator it = arrayList.iterator();
        Intrinsics3.checkNotNullExpressionValue(it, "filteredTypes.iterator()");
        while (it.hasNext()) {
            KotlinType4 kotlinType4 = (KotlinType4) it.next();
            boolean z3 = false;
            if (!arrayList.isEmpty()) {
                for (KotlinType4 kotlinType5 : arrayList) {
                    if (kotlinType5 != kotlinType4) {
                        Intrinsics3.checkNotNullExpressionValue(kotlinType5, "lower");
                        Intrinsics3.checkNotNullExpressionValue(kotlinType4, "upper");
                        if (function2.invoke(kotlinType5, kotlinType4).booleanValue()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        z3 = true;
                        break;
                    }
                }
            }
            if (z3) {
                it.remove();
            }
        }
        return arrayList;
    }

    public final KotlinType4 intersectTypes$descriptors(List<? extends KotlinType4> list) {
        Intrinsics3.checkNotNullParameter(list, "types");
        list.size();
        ArrayList<KotlinType4> arrayList = new ArrayList();
        for (KotlinType4 kotlinType4 : list) {
            if (kotlinType4.getConstructor() instanceof IntersectionTypeConstructor) {
                Collection<KotlinType> supertypes = kotlinType4.getConstructor().getSupertypes();
                Intrinsics3.checkNotNullExpressionValue(supertypes, "type.constructor.supertypes");
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(supertypes, 10));
                for (KotlinType kotlinType : supertypes) {
                    Intrinsics3.checkNotNullExpressionValue(kotlinType, "it");
                    KotlinType4 kotlinType4UpperIfFlexible = flexibleTypes2.upperIfFlexible(kotlinType);
                    if (kotlinType4.isMarkedNullable()) {
                        kotlinType4UpperIfFlexible = kotlinType4UpperIfFlexible.makeNullableAsSpecified(true);
                    }
                    arrayList2.add(kotlinType4UpperIfFlexible);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(kotlinType4);
            }
        }
        a aVarCombine = a.j;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aVarCombine = aVarCombine.combine((KotlinType3) it.next());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (KotlinType4 kotlinType4MakeSimpleTypeDefinitelyNotNullOrNotNull$default : arrayList) {
            if (aVarCombine == a.m) {
                if (kotlinType4MakeSimpleTypeDefinitelyNotNullOrNotNull$default instanceof NewCapturedType) {
                    kotlinType4MakeSimpleTypeDefinitelyNotNullOrNotNull$default = SpecialTypes5.withNotNullProjection((NewCapturedType) kotlinType4MakeSimpleTypeDefinitelyNotNullOrNotNull$default);
                }
                kotlinType4MakeSimpleTypeDefinitelyNotNullOrNotNull$default = SpecialTypes5.makeSimpleTypeDefinitelyNotNullOrNotNull$default(kotlinType4MakeSimpleTypeDefinitelyNotNullOrNotNull$default, false, 1, null);
            }
            linkedHashSet.add(kotlinType4MakeSimpleTypeDefinitelyNotNullOrNotNull$default);
        }
        if (linkedHashSet.size() == 1) {
            return (KotlinType4) _Collections.single(linkedHashSet);
        }
        new IntersectionType3(linkedHashSet);
        Collection<KotlinType4> collectionA = a(linkedHashSet, new IntersectionType4(this));
        ((ArrayList) collectionA).isEmpty();
        KotlinType4 kotlinType4FindIntersectionType = IntegerLiteralTypeConstructor.a.findIntersectionType(collectionA);
        if (kotlinType4FindIntersectionType != null) {
            return kotlinType4FindIntersectionType;
        }
        Collection<KotlinType4> collectionA2 = a(collectionA, new IntersectionType5(NewKotlinTypeChecker.f3529b.getDefault()));
        ArrayList arrayList3 = (ArrayList) collectionA2;
        arrayList3.isEmpty();
        return arrayList3.size() < 2 ? (KotlinType4) _Collections.single(collectionA2) : new IntersectionTypeConstructor(linkedHashSet).createType();
    }
}
