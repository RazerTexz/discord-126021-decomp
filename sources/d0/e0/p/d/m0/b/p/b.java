package d0.e0.p.d.m0.b.p;

import d0.e0.p.d.m0.b.k;
import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.c.f;
import d0.e0.p.d.m0.c.g1.g;
import d0.e0.p.d.m0.c.i1.k0;
import d0.e0.p.d.m0.c.t;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.z;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.k.a0.i;
import d0.e0.p.d.m0.k.a0.i$b;
import d0.e0.p.d.m0.m.o;
import d0.e0.p.d.m0.n.j1;
import d0.t.c0;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: FunctionClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends d0.e0.p.d.m0.c.i1.a {
    public static final d0.e0.p.d.m0.g.a o;
    public static final d0.e0.p.d.m0.g.a p;
    public final o q;
    public final e0 r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final c f3234s;
    public final int t;
    public final b$b u;
    public final d v;
    public final List<z0> w;

    static {
        new b$a(null);
        o = new d0.e0.p.d.m0.g.a(k.l, d0.e0.p.d.m0.g.e.identifier("Function"));
        p = new d0.e0.p.d.m0.g.a(k.i, d0.e0.p.d.m0.g.e.identifier("KFunction"));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(o oVar, e0 e0Var, c cVar, int i) {
        super(oVar, cVar.numberedClassName(i));
        m.checkNotNullParameter(oVar, "storageManager");
        m.checkNotNullParameter(e0Var, "containingDeclaration");
        m.checkNotNullParameter(cVar, "functionKind");
        this.q = oVar;
        this.r = e0Var;
        this.f3234s = cVar;
        this.t = i;
        this.u = new b$b(this);
        this.v = new d(oVar, this);
        ArrayList arrayList = new ArrayList();
        IntRange intRange = new IntRange(1, i);
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            b(arrayList, this, j1.IN_VARIANCE, m.stringPlus("P", Integer.valueOf(((c0) it).nextInt())));
            arrayList2.add(Unit.a);
        }
        b(arrayList, this, j1.OUT_VARIANCE, "R");
        this.w = u.toList(arrayList);
    }

    public static final /* synthetic */ e0 access$getContainingDeclaration$p(b bVar) {
        return bVar.r;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.g.a access$getFunctionClassId$cp() {
        return o;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.g.a access$getKFunctionClassId$cp() {
        return p;
    }

    public static final /* synthetic */ List access$getParameters$p(b bVar) {
        return bVar.w;
    }

    public static final /* synthetic */ o access$getStorageManager$p(b bVar) {
        return bVar.q;
    }

    public static final void b(ArrayList<z0> arrayList, b bVar, j1 j1Var, String str) {
        arrayList.add(k0.createWithDefaultBound(bVar, g.f.getEMPTY(), false, j1Var, d0.e0.p.d.m0.g.e.identifier(str), arrayList.size(), bVar.q));
    }

    @Override // d0.e0.p.d.m0.c.g1.a
    public g getAnnotations() {
        return g.f.getEMPTY();
    }

    public final int getArity() {
        return this.t;
    }

    @Override // d0.e0.p.d.m0.c.e
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.e getCompanionObjectDescriptor() {
        return (d0.e0.p.d.m0.c.e) m82getCompanionObjectDescriptor();
    }

    /* JADX INFO: renamed from: getCompanionObjectDescriptor, reason: collision with other method in class */
    public Void m82getCompanionObjectDescriptor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.e
    public /* bridge */ /* synthetic */ Collection getConstructors() {
        return getConstructors();
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.n, d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.i
    public List<z0> getDeclaredTypeParameters() {
        return this.w;
    }

    public final c getFunctionKind() {
        return this.f3234s;
    }

    @Override // d0.e0.p.d.m0.c.e
    public f getKind() {
        return f.INTERFACE;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.y
    public z getModality() {
        return z.ABSTRACT;
    }

    @Override // d0.e0.p.d.m0.c.e
    public /* bridge */ /* synthetic */ Collection getSealedSubclasses() {
        return getSealedSubclasses();
    }

    @Override // d0.e0.p.d.m0.c.p
    public u0 getSource() {
        u0 u0Var = u0.a;
        m.checkNotNullExpressionValue(u0Var, "NO_SOURCE");
        return u0Var;
    }

    @Override // d0.e0.p.d.m0.c.e
    public /* bridge */ /* synthetic */ i getStaticScope() {
        return getStaticScope();
    }

    @Override // d0.e0.p.d.m0.c.h
    public d0.e0.p.d.m0.n.u0 getTypeConstructor() {
        return this.u;
    }

    @Override // d0.e0.p.d.m0.c.i1.u
    public i getUnsubstitutedMemberScope(d0.e0.p.d.m0.n.l1.g gVar) {
        m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return this.v;
    }

    @Override // d0.e0.p.d.m0.c.e
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.d getUnsubstitutedPrimaryConstructor() {
        return (d0.e0.p.d.m0.c.d) m83getUnsubstitutedPrimaryConstructor();
    }

    /* JADX INFO: renamed from: getUnsubstitutedPrimaryConstructor, reason: collision with other method in class */
    public Void m83getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.q, d0.e0.p.d.m0.c.y
    public d0.e0.p.d.m0.c.u getVisibility() {
        d0.e0.p.d.m0.c.u uVar = t.e;
        m.checkNotNullExpressionValue(uVar, "PUBLIC");
        return uVar;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isActual() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isCompanionObject() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isData() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isExpect() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isExternal() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isFun() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isInline() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i
    public boolean isInner() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isValue() {
        return false;
    }

    public String toString() {
        String strAsString = getName().asString();
        m.checkNotNullExpressionValue(strAsString, "name.asString()");
        return strAsString;
    }

    @Override // d0.e0.p.d.m0.c.e
    public List<d0.e0.p.d.m0.c.d> getConstructors() {
        return n.emptyList();
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.n, d0.e0.p.d.m0.c.m
    public e0 getContainingDeclaration() {
        return this.r;
    }

    @Override // d0.e0.p.d.m0.c.e
    public List<d0.e0.p.d.m0.c.e> getSealedSubclasses() {
        return n.emptyList();
    }

    @Override // d0.e0.p.d.m0.c.e
    public i$b getStaticScope() {
        return i$b.f3461b;
    }
}
