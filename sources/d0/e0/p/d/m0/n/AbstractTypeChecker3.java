package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.n.n1.n;
import d0.e0.p.d.m0.p.SmartSet;
import d0.z.d.Intrinsics3;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.f, reason: use source file name */
/* JADX INFO: compiled from: AbstractTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractTypeChecker3 implements d0.e0.p.d.m0.n.n1.n {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3523b;
    public ArrayDeque<d0.e0.p.d.m0.n.n1.i> c;
    public Set<d0.e0.p.d.m0.n.n1.i> d;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.f$a */
    /* JADX INFO: compiled from: AbstractTypeChecker.kt */
    public enum a {
        CHECK_ONLY_LOWER,
        CHECK_SUBTYPE_AND_LOWER,
        SKIP_LOWER;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            a[] aVarArr = new a[aVarArrValuesCustom.length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, aVarArrValuesCustom.length);
            return aVarArr;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.f$b */
    /* JADX INFO: compiled from: AbstractTypeChecker.kt */
    public static abstract class b {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.f$b$a */
        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        public static abstract class a extends b {
            public a() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.f$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        public static final class C0411b extends b {
            public static final C0411b a = new C0411b();

            public C0411b() {
                super(null);
            }

            @Override // d0.e0.p.d.m0.n.AbstractTypeChecker3.b
            public d0.e0.p.d.m0.n.n1.i transformType(AbstractTypeChecker3 abstractTypeChecker3, d0.e0.p.d.m0.n.n1.h hVar) {
                Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "context");
                Intrinsics3.checkNotNullParameter(hVar, "type");
                return abstractTypeChecker3.lowerBoundIfFlexible(hVar);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.f$b$c */
        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        public static final class c extends b {
            public static final c a = new c();

            public c() {
                super(null);
            }

            @Override // d0.e0.p.d.m0.n.AbstractTypeChecker3.b
            public /* bridge */ /* synthetic */ d0.e0.p.d.m0.n.n1.i transformType(AbstractTypeChecker3 abstractTypeChecker3, d0.e0.p.d.m0.n.n1.h hVar) {
                return (d0.e0.p.d.m0.n.n1.i) m95transformType(abstractTypeChecker3, hVar);
            }

            /* JADX INFO: renamed from: transformType, reason: collision with other method in class */
            public Void m95transformType(AbstractTypeChecker3 abstractTypeChecker3, d0.e0.p.d.m0.n.n1.h hVar) {
                Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "context");
                Intrinsics3.checkNotNullParameter(hVar, "type");
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.f$b$d */
        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        public static final class d extends b {
            public static final d a = new d();

            public d() {
                super(null);
            }

            @Override // d0.e0.p.d.m0.n.AbstractTypeChecker3.b
            public d0.e0.p.d.m0.n.n1.i transformType(AbstractTypeChecker3 abstractTypeChecker3, d0.e0.p.d.m0.n.n1.h hVar) {
                Intrinsics3.checkNotNullParameter(abstractTypeChecker3, "context");
                Intrinsics3.checkNotNullParameter(hVar, "type");
                return abstractTypeChecker3.upperBoundIfFlexible(hVar);
            }
        }

        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public abstract d0.e0.p.d.m0.n.n1.i transformType(AbstractTypeChecker3 abstractTypeChecker3, d0.e0.p.d.m0.n.n1.h hVar);
    }

    public static /* synthetic */ Boolean addSubtypeConstraint$default(AbstractTypeChecker3 abstractTypeChecker3, d0.e0.p.d.m0.n.n1.h hVar, d0.e0.p.d.m0.n.n1.h hVar2, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return abstractTypeChecker3.addSubtypeConstraint(hVar, hVar2, z2);
    }

    public Boolean addSubtypeConstraint(d0.e0.p.d.m0.n.n1.h hVar, d0.e0.p.d.m0.n.n1.h hVar2, boolean z2) {
        Intrinsics3.checkNotNullParameter(hVar, "subType");
        Intrinsics3.checkNotNullParameter(hVar2, "superType");
        return null;
    }

    public final void clear() {
        ArrayDeque<d0.e0.p.d.m0.n.n1.i> arrayDeque = this.c;
        Intrinsics3.checkNotNull(arrayDeque);
        arrayDeque.clear();
        Set<d0.e0.p.d.m0.n.n1.i> set = this.d;
        Intrinsics3.checkNotNull(set);
        set.clear();
        this.f3523b = false;
    }

    public boolean customIsSubtypeOf(d0.e0.p.d.m0.n.n1.h hVar, d0.e0.p.d.m0.n.n1.h hVar2) {
        Intrinsics3.checkNotNullParameter(hVar, "subType");
        Intrinsics3.checkNotNullParameter(hVar2, "superType");
        return true;
    }

    public List<d0.e0.p.d.m0.n.n1.i> fastCorrespondingSupertypes(d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.l lVar) {
        return n.a.fastCorrespondingSupertypes(this, iVar, lVar);
    }

    public d0.e0.p.d.m0.n.n1.k get(d0.e0.p.d.m0.n.n1.j jVar, int i) {
        return n.a.get(this, jVar, i);
    }

    public d0.e0.p.d.m0.n.n1.k getArgumentOrNull(d0.e0.p.d.m0.n.n1.i iVar, int i) {
        return n.a.getArgumentOrNull(this, iVar, i);
    }

    public a getLowerCapturedTypePolicy(d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.c cVar) {
        Intrinsics3.checkNotNullParameter(iVar, "subType");
        Intrinsics3.checkNotNullParameter(cVar, "superType");
        return a.CHECK_SUBTYPE_AND_LOWER;
    }

    public final ArrayDeque<d0.e0.p.d.m0.n.n1.i> getSupertypesDeque() {
        return this.c;
    }

    public final Set<d0.e0.p.d.m0.n.n1.i> getSupertypesSet() {
        return this.d;
    }

    public boolean hasFlexibleNullability(d0.e0.p.d.m0.n.n1.h hVar) {
        return n.a.hasFlexibleNullability(this, hVar);
    }

    public final void initialize() {
        this.f3523b = true;
        if (this.c == null) {
            this.c = new ArrayDeque<>(4);
        }
        if (this.d == null) {
            this.d = SmartSet.j.create();
        }
    }

    public boolean isClassType(d0.e0.p.d.m0.n.n1.i iVar) {
        return n.a.isClassType(this, iVar);
    }

    public boolean isDefinitelyNotNullType(d0.e0.p.d.m0.n.n1.h hVar) {
        return n.a.isDefinitelyNotNullType(this, hVar);
    }

    public boolean isDynamic(d0.e0.p.d.m0.n.n1.h hVar) {
        return n.a.isDynamic(this, hVar);
    }

    public abstract boolean isErrorTypeEqualsToAnything();

    public boolean isIntegerLiteralType(d0.e0.p.d.m0.n.n1.i iVar) {
        return n.a.isIntegerLiteralType(this, iVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isMarkedNullable(d0.e0.p.d.m0.n.n1.h hVar) {
        return n.a.isMarkedNullable(this, hVar);
    }

    public boolean isNothing(d0.e0.p.d.m0.n.n1.h hVar) {
        return n.a.isNothing(this, hVar);
    }

    public abstract boolean isStubTypeEqualsToAnything();

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.i lowerBoundIfFlexible(d0.e0.p.d.m0.n.n1.h hVar) {
        return n.a.lowerBoundIfFlexible(this, hVar);
    }

    public abstract d0.e0.p.d.m0.n.n1.h prepareType(d0.e0.p.d.m0.n.n1.h hVar);

    public abstract d0.e0.p.d.m0.n.n1.h refineType(d0.e0.p.d.m0.n.n1.h hVar);

    public int size(d0.e0.p.d.m0.n.n1.j jVar) {
        return n.a.size(this, jVar);
    }

    public abstract b substitutionSupertypePolicy(d0.e0.p.d.m0.n.n1.i iVar);

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.l typeConstructor(d0.e0.p.d.m0.n.n1.h hVar) {
        return n.a.typeConstructor(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.i upperBoundIfFlexible(d0.e0.p.d.m0.n.n1.h hVar) {
        return n.a.upperBoundIfFlexible(this, hVar);
    }
}
