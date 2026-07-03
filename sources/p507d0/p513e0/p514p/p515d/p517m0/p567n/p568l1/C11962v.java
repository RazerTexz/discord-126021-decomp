package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11822n;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11907a0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11968m0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12015y;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.v */
/* JADX INFO: compiled from: IntersectionType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11962v {

    /* JADX INFO: renamed from: a */
    public static final C11962v f24831a = new C11962v();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.v$a */
    /* JADX INFO: compiled from: IntersectionType.kt */
    public static final class a {

        /* JADX INFO: renamed from: j */
        public static final a f24832j;

        /* JADX INFO: renamed from: k */
        public static final a f24833k;

        /* JADX INFO: renamed from: l */
        public static final a f24834l;

        /* JADX INFO: renamed from: m */
        public static final a f24835m;

        /* JADX INFO: renamed from: n */
        public static final /* synthetic */ a[] f24836n;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.v$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IntersectionType.kt */
        public static final class C13338a extends a {
            public C13338a(String str, int i) {
                super(str, i, null);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.C11962v.a
            public a combine(AbstractC11932i1 abstractC11932i1) {
                C12238m.checkNotNullParameter(abstractC11932i1, "nextType");
                return m10016f(abstractC11932i1);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.v$a$b */
        /* JADX INFO: compiled from: IntersectionType.kt */
        public static final class b extends a {
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.C11962v.a
            public b combine(AbstractC11932i1 abstractC11932i1) {
                C12238m.checkNotNullParameter(abstractC11932i1, "nextType");
                return this;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.v$a$c */
        /* JADX INFO: compiled from: IntersectionType.kt */
        public static final class c extends a {
            public c(String str, int i) {
                super(str, i, null);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.C11962v.a
            public a combine(AbstractC11932i1 abstractC11932i1) {
                C12238m.checkNotNullParameter(abstractC11932i1, "nextType");
                return m10016f(abstractC11932i1);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.v$a$d */
        /* JADX INFO: compiled from: IntersectionType.kt */
        public static final class d extends a {
            public d(String str, int i) {
                super(str, i, null);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.C11962v.a
            public a combine(AbstractC11932i1 abstractC11932i1) {
                C12238m.checkNotNullParameter(abstractC11932i1, "nextType");
                a aVarM10016f = m10016f(abstractC11932i1);
                return aVarM10016f == a.f24833k ? this : aVarM10016f;
            }
        }

        static {
            c cVar = new c("START", 0);
            f24832j = cVar;
            C13338a c13338a = new C13338a("ACCEPT_NULL", 1);
            f24833k = c13338a;
            d dVar = new d("UNKNOWN", 2);
            f24834l = dVar;
            b bVar = new b("NOT_NULL", 3);
            f24835m = bVar;
            f24836n = new a[]{cVar, c13338a, dVar, bVar};
        }

        public a(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            super(str, i);
        }

        public static a valueOf(String str) {
            C12238m.checkNotNullParameter(str, "value");
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            a[] aVarArr = f24836n;
            a[] aVarArr2 = new a[aVarArr.length];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
            return aVarArr2;
        }

        public abstract a combine(AbstractC11932i1 abstractC11932i1);

        /* JADX INFO: renamed from: f */
        public final a m10016f(AbstractC11932i1 abstractC11932i1) {
            C12238m.checkNotNullParameter(abstractC11932i1, "<this>");
            if (abstractC11932i1.isMarkedNullable()) {
                return f24833k;
            }
            return C11954n.f24825a.isSubtypeOfAny(abstractC11932i1) ? f24835m : f24834l;
        }
    }

    public static final boolean access$isStrictSupertype(C11962v c11962v, AbstractC11913c0 abstractC11913c0, AbstractC11913c0 abstractC11913c1) {
        Objects.requireNonNull(c11962v);
        C11953m c11953m = InterfaceC11952l.f24820b.getDefault();
        return c11953m.isSubtypeOf(abstractC11913c0, abstractC11913c1) && !c11953m.isSubtypeOf(abstractC11913c1, abstractC11913c0);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004d  */
    /* JADX INFO: renamed from: a */
    public final Collection<AbstractC11934j0> m10015a(Collection<? extends AbstractC11934j0> collection, Function2<? super AbstractC11934j0, ? super AbstractC11934j0, Boolean> function2) {
        boolean z2;
        ArrayList<AbstractC11934j0> arrayList = new ArrayList(collection);
        Iterator it = arrayList.iterator();
        C12238m.checkNotNullExpressionValue(it, "filteredTypes.iterator()");
        while (it.hasNext()) {
            AbstractC11934j0 abstractC11934j0 = (AbstractC11934j0) it.next();
            boolean z3 = false;
            if (!arrayList.isEmpty()) {
                for (AbstractC11934j0 abstractC11934j1 : arrayList) {
                    if (abstractC11934j1 != abstractC11934j0) {
                        C12238m.checkNotNullExpressionValue(abstractC11934j1, "lower");
                        C12238m.checkNotNullExpressionValue(abstractC11934j0, "upper");
                        if (function2.invoke(abstractC11934j1, abstractC11934j0).booleanValue()) {
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

    public final AbstractC11934j0 intersectTypes$descriptors(List<? extends AbstractC11934j0> list) {
        C12238m.checkNotNullParameter(list, "types");
        list.size();
        ArrayList<AbstractC11934j0> arrayList = new ArrayList();
        for (AbstractC11934j0 abstractC11934j0 : list) {
            if (abstractC11934j0.getConstructor() instanceof C11907a0) {
                Collection<AbstractC11913c0> supertypes = abstractC11934j0.getConstructor().getSupertypes();
                C12238m.checkNotNullExpressionValue(supertypes, "type.constructor.supertypes");
                ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(supertypes, 10));
                for (AbstractC11913c0 abstractC11913c0 : supertypes) {
                    C12238m.checkNotNullExpressionValue(abstractC11913c0, "it");
                    AbstractC11934j0 abstractC11934j0UpperIfFlexible = C12015y.upperIfFlexible(abstractC11913c0);
                    if (abstractC11934j0.isMarkedNullable()) {
                        abstractC11934j0UpperIfFlexible = abstractC11934j0UpperIfFlexible.makeNullableAsSpecified(true);
                    }
                    arrayList2.add(abstractC11934j0UpperIfFlexible);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(abstractC11934j0);
            }
        }
        a aVarCombine = a.f24832j;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aVarCombine = aVarCombine.combine((AbstractC11932i1) it.next());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (AbstractC11934j0 abstractC11934j0MakeSimpleTypeDefinitelyNotNullOrNotNull$default : arrayList) {
            if (aVarCombine == a.f24835m) {
                if (abstractC11934j0MakeSimpleTypeDefinitelyNotNullOrNotNull$default instanceof C11949i) {
                    abstractC11934j0MakeSimpleTypeDefinitelyNotNullOrNotNull$default = C11968m0.withNotNullProjection((C11949i) abstractC11934j0MakeSimpleTypeDefinitelyNotNullOrNotNull$default);
                }
                abstractC11934j0MakeSimpleTypeDefinitelyNotNullOrNotNull$default = C11968m0.makeSimpleTypeDefinitelyNotNullOrNotNull$default(abstractC11934j0MakeSimpleTypeDefinitelyNotNullOrNotNull$default, false, 1, null);
            }
            linkedHashSet.add(abstractC11934j0MakeSimpleTypeDefinitelyNotNullOrNotNull$default);
        }
        if (linkedHashSet.size() == 1) {
            return (AbstractC11934j0) C12163u.single(linkedHashSet);
        }
        new C11963w(linkedHashSet);
        Collection<AbstractC11934j0> collectionM10015a = m10015a(linkedHashSet, new C11964x(this));
        ((ArrayList) collectionM10015a).isEmpty();
        AbstractC11934j0 abstractC11934j0FindIntersectionType = C11822n.f24444a.findIntersectionType(collectionM10015a);
        if (abstractC11934j0FindIntersectionType != null) {
            return abstractC11934j0FindIntersectionType;
        }
        Collection<AbstractC11934j0> collectionM10015a2 = m10015a(collectionM10015a, new C11965y(InterfaceC11952l.f24820b.getDefault()));
        ArrayList arrayList3 = (ArrayList) collectionM10015a2;
        arrayList3.isEmpty();
        return arrayList3.size() < 2 ? (AbstractC11934j0) C12163u.single(collectionM10015a2) : new C11907a0(linkedHashSet).createType();
    }
}
