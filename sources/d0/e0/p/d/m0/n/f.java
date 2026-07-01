package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.n.n1.n$a;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: AbstractTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f implements d0.e0.p.d.m0.n.n1.n {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3523b;
    public ArrayDeque<d0.e0.p.d.m0.n.n1.i> c;
    public Set<d0.e0.p.d.m0.n.n1.i> d;

    public static final /* synthetic */ int access$getArgumentsDepth(f fVar) {
        return fVar.a;
    }

    public static final /* synthetic */ void access$setArgumentsDepth(f fVar, int i) {
        fVar.a = i;
    }

    public static /* synthetic */ Boolean addSubtypeConstraint$default(f fVar, d0.e0.p.d.m0.n.n1.h hVar, d0.e0.p.d.m0.n.n1.h hVar2, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return fVar.addSubtypeConstraint(hVar, hVar2, z2);
    }

    public Boolean addSubtypeConstraint(d0.e0.p.d.m0.n.n1.h hVar, d0.e0.p.d.m0.n.n1.h hVar2, boolean z2) {
        d0.z.d.m.checkNotNullParameter(hVar, "subType");
        d0.z.d.m.checkNotNullParameter(hVar2, "superType");
        return null;
    }

    public final void clear() {
        ArrayDeque<d0.e0.p.d.m0.n.n1.i> arrayDeque = this.c;
        d0.z.d.m.checkNotNull(arrayDeque);
        arrayDeque.clear();
        Set<d0.e0.p.d.m0.n.n1.i> set = this.d;
        d0.z.d.m.checkNotNull(set);
        set.clear();
        this.f3523b = false;
    }

    public boolean customIsSubtypeOf(d0.e0.p.d.m0.n.n1.h hVar, d0.e0.p.d.m0.n.n1.h hVar2) {
        d0.z.d.m.checkNotNullParameter(hVar, "subType");
        d0.z.d.m.checkNotNullParameter(hVar2, "superType");
        return true;
    }

    public List<d0.e0.p.d.m0.n.n1.i> fastCorrespondingSupertypes(d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.l lVar) {
        return n$a.fastCorrespondingSupertypes(this, iVar, lVar);
    }

    public d0.e0.p.d.m0.n.n1.k get(d0.e0.p.d.m0.n.n1.j jVar, int i) {
        return n$a.get(this, jVar, i);
    }

    public d0.e0.p.d.m0.n.n1.k getArgumentOrNull(d0.e0.p.d.m0.n.n1.i iVar, int i) {
        return n$a.getArgumentOrNull(this, iVar, i);
    }

    public f$a getLowerCapturedTypePolicy(d0.e0.p.d.m0.n.n1.i iVar, d0.e0.p.d.m0.n.n1.c cVar) {
        d0.z.d.m.checkNotNullParameter(iVar, "subType");
        d0.z.d.m.checkNotNullParameter(cVar, "superType");
        return f$a.CHECK_SUBTYPE_AND_LOWER;
    }

    public final ArrayDeque<d0.e0.p.d.m0.n.n1.i> getSupertypesDeque() {
        return this.c;
    }

    public final Set<d0.e0.p.d.m0.n.n1.i> getSupertypesSet() {
        return this.d;
    }

    public boolean hasFlexibleNullability(d0.e0.p.d.m0.n.n1.h hVar) {
        return n$a.hasFlexibleNullability(this, hVar);
    }

    public final void initialize() {
        this.f3523b = true;
        if (this.c == null) {
            this.c = new ArrayDeque<>(4);
        }
        if (this.d == null) {
            this.d = d0.e0.p.d.m0.p.j.j.create();
        }
    }

    public boolean isClassType(d0.e0.p.d.m0.n.n1.i iVar) {
        return n$a.isClassType(this, iVar);
    }

    public boolean isDefinitelyNotNullType(d0.e0.p.d.m0.n.n1.h hVar) {
        return n$a.isDefinitelyNotNullType(this, hVar);
    }

    public boolean isDynamic(d0.e0.p.d.m0.n.n1.h hVar) {
        return n$a.isDynamic(this, hVar);
    }

    public abstract boolean isErrorTypeEqualsToAnything();

    public boolean isIntegerLiteralType(d0.e0.p.d.m0.n.n1.i iVar) {
        return n$a.isIntegerLiteralType(this, iVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public boolean isMarkedNullable(d0.e0.p.d.m0.n.n1.h hVar) {
        return n$a.isMarkedNullable(this, hVar);
    }

    public boolean isNothing(d0.e0.p.d.m0.n.n1.h hVar) {
        return n$a.isNothing(this, hVar);
    }

    public abstract boolean isStubTypeEqualsToAnything();

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.i lowerBoundIfFlexible(d0.e0.p.d.m0.n.n1.h hVar) {
        return n$a.lowerBoundIfFlexible(this, hVar);
    }

    public abstract d0.e0.p.d.m0.n.n1.h prepareType(d0.e0.p.d.m0.n.n1.h hVar);

    public abstract d0.e0.p.d.m0.n.n1.h refineType(d0.e0.p.d.m0.n.n1.h hVar);

    public int size(d0.e0.p.d.m0.n.n1.j jVar) {
        return n$a.size(this, jVar);
    }

    public abstract f$b substitutionSupertypePolicy(d0.e0.p.d.m0.n.n1.i iVar);

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.l typeConstructor(d0.e0.p.d.m0.n.n1.h hVar) {
        return n$a.typeConstructor(this, hVar);
    }

    @Override // d0.e0.p.d.m0.n.n1.n
    public d0.e0.p.d.m0.n.n1.i upperBoundIfFlexible(d0.e0.p.d.m0.n.n1.h hVar) {
        return n$a.upperBoundIfFlexible(this, hVar);
    }
}
