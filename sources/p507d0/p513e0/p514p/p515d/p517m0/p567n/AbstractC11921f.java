package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11974c;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11980i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11981j;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11982k;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11983l;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12042j;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.f */
/* JADX INFO: compiled from: AbstractTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11921f implements InterfaceC11985n {

    /* JADX INFO: renamed from: a */
    public int f24758a;

    /* JADX INFO: renamed from: b */
    public boolean f24759b;

    /* JADX INFO: renamed from: c */
    public ArrayDeque<InterfaceC11980i> f24760c;

    /* JADX INFO: renamed from: d */
    public Set<InterfaceC11980i> f24761d;

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
        public static final class C13335b extends b {

            /* JADX INFO: renamed from: a */
            public static final C13335b f24766a = new C13335b();

            public C13335b() {
                super(null);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11921f.b
            public InterfaceC11980i transformType(AbstractC11921f abstractC11921f, InterfaceC11979h interfaceC11979h) {
                C12238m.checkNotNullParameter(abstractC11921f, "context");
                C12238m.checkNotNullParameter(interfaceC11979h, "type");
                return abstractC11921f.lowerBoundIfFlexible(interfaceC11979h);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.f$b$c */
        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        public static final class c extends b {

            /* JADX INFO: renamed from: a */
            public static final c f24767a = new c();

            public c() {
                super(null);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11921f.b
            public /* bridge */ /* synthetic */ InterfaceC11980i transformType(AbstractC11921f abstractC11921f, InterfaceC11979h interfaceC11979h) {
                return (InterfaceC11980i) m11472transformType(abstractC11921f, interfaceC11979h);
            }

            /* JADX INFO: renamed from: transformType, reason: collision with other method in class */
            public Void m11472transformType(AbstractC11921f abstractC11921f, InterfaceC11979h interfaceC11979h) {
                C12238m.checkNotNullParameter(abstractC11921f, "context");
                C12238m.checkNotNullParameter(interfaceC11979h, "type");
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.f$b$d */
        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        public static final class d extends b {

            /* JADX INFO: renamed from: a */
            public static final d f24768a = new d();

            public d() {
                super(null);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11921f.b
            public InterfaceC11980i transformType(AbstractC11921f abstractC11921f, InterfaceC11979h interfaceC11979h) {
                C12238m.checkNotNullParameter(abstractC11921f, "context");
                C12238m.checkNotNullParameter(interfaceC11979h, "type");
                return abstractC11921f.upperBoundIfFlexible(interfaceC11979h);
            }
        }

        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public abstract InterfaceC11980i transformType(AbstractC11921f abstractC11921f, InterfaceC11979h interfaceC11979h);
    }

    public static /* synthetic */ Boolean addSubtypeConstraint$default(AbstractC11921f abstractC11921f, InterfaceC11979h interfaceC11979h, InterfaceC11979h interfaceC11979h2, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return abstractC11921f.addSubtypeConstraint(interfaceC11979h, interfaceC11979h2, z2);
    }

    public Boolean addSubtypeConstraint(InterfaceC11979h interfaceC11979h, InterfaceC11979h interfaceC11979h2, boolean z2) {
        C12238m.checkNotNullParameter(interfaceC11979h, "subType");
        C12238m.checkNotNullParameter(interfaceC11979h2, "superType");
        return null;
    }

    public final void clear() {
        ArrayDeque<InterfaceC11980i> arrayDeque = this.f24760c;
        C12238m.checkNotNull(arrayDeque);
        arrayDeque.clear();
        Set<InterfaceC11980i> set = this.f24761d;
        C12238m.checkNotNull(set);
        set.clear();
        this.f24759b = false;
    }

    public boolean customIsSubtypeOf(InterfaceC11979h interfaceC11979h, InterfaceC11979h interfaceC11979h2) {
        C12238m.checkNotNullParameter(interfaceC11979h, "subType");
        C12238m.checkNotNullParameter(interfaceC11979h2, "superType");
        return true;
    }

    public List<InterfaceC11980i> fastCorrespondingSupertypes(InterfaceC11980i interfaceC11980i, InterfaceC11983l interfaceC11983l) {
        return InterfaceC11985n.a.fastCorrespondingSupertypes(this, interfaceC11980i, interfaceC11983l);
    }

    public InterfaceC11982k get(InterfaceC11981j interfaceC11981j, int i) {
        return InterfaceC11985n.a.get(this, interfaceC11981j, i);
    }

    public InterfaceC11982k getArgumentOrNull(InterfaceC11980i interfaceC11980i, int i) {
        return InterfaceC11985n.a.getArgumentOrNull(this, interfaceC11980i, i);
    }

    public a getLowerCapturedTypePolicy(InterfaceC11980i interfaceC11980i, InterfaceC11974c interfaceC11974c) {
        C12238m.checkNotNullParameter(interfaceC11980i, "subType");
        C12238m.checkNotNullParameter(interfaceC11974c, "superType");
        return a.CHECK_SUBTYPE_AND_LOWER;
    }

    public final ArrayDeque<InterfaceC11980i> getSupertypesDeque() {
        return this.f24760c;
    }

    public final Set<InterfaceC11980i> getSupertypesSet() {
        return this.f24761d;
    }

    public boolean hasFlexibleNullability(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11985n.a.hasFlexibleNullability(this, interfaceC11979h);
    }

    public final void initialize() {
        this.f24759b = true;
        if (this.f24760c == null) {
            this.f24760c = new ArrayDeque<>(4);
        }
        if (this.f24761d == null) {
            this.f24761d = C12042j.f25003j.create();
        }
    }

    public boolean isClassType(InterfaceC11980i interfaceC11980i) {
        return InterfaceC11985n.a.isClassType(this, interfaceC11980i);
    }

    public boolean isDefinitelyNotNullType(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11985n.a.isDefinitelyNotNullType(this, interfaceC11979h);
    }

    public boolean isDynamic(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11985n.a.isDynamic(this, interfaceC11979h);
    }

    public abstract boolean isErrorTypeEqualsToAnything();

    public boolean isIntegerLiteralType(InterfaceC11980i interfaceC11980i) {
        return InterfaceC11985n.a.isIntegerLiteralType(this, interfaceC11980i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public boolean isMarkedNullable(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11985n.a.isMarkedNullable(this, interfaceC11979h);
    }

    public boolean isNothing(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11985n.a.isNothing(this, interfaceC11979h);
    }

    public abstract boolean isStubTypeEqualsToAnything();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11980i lowerBoundIfFlexible(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11985n.a.lowerBoundIfFlexible(this, interfaceC11979h);
    }

    public abstract InterfaceC11979h prepareType(InterfaceC11979h interfaceC11979h);

    public abstract InterfaceC11979h refineType(InterfaceC11979h interfaceC11979h);

    public int size(InterfaceC11981j interfaceC11981j) {
        return InterfaceC11985n.a.size(this, interfaceC11981j);
    }

    public abstract b substitutionSupertypePolicy(InterfaceC11980i interfaceC11980i);

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11983l typeConstructor(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11985n.a.typeConstructor(this, interfaceC11979h);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11985n
    public InterfaceC11980i upperBoundIfFlexible(InterfaceC11979h interfaceC11979h) {
        return InterfaceC11985n.a.upperBoundIfFlexible(this, interfaceC11979h);
    }
}
