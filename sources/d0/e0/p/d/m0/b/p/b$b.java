package d0.e0.p.d.m0.b.p;

import d0.e0.p.d.m0.b.k;
import d0.e0.p.d.m0.c.g1.g;
import d0.e0.p.d.m0.c.h;
import d0.e0.p.d.m0.c.w;
import d0.e0.p.d.m0.c.x0;
import d0.e0.p.d.m0.c.x0$a;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.y0;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: FunctionClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$b extends d0.e0.p.d.m0.n.b {
    public final /* synthetic */ b c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b$b(b bVar) {
        super(b.access$getStorageManager$p(bVar));
        m.checkNotNullParameter(bVar, "this$0");
        this.c = bVar;
    }

    @Override // d0.e0.p.d.m0.n.g
    public Collection<c0> a() {
        List<d0.e0.p.d.m0.g.a> listListOf;
        int iOrdinal = this.c.getFunctionKind().ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            listListOf = d0.t.m.listOf(b.access$getFunctionClassId$cp());
        } else if (iOrdinal == 2) {
            listListOf = n.listOf((Object[]) new d0.e0.p.d.m0.g.a[]{b.access$getKFunctionClassId$cp(), new d0.e0.p.d.m0.g.a(k.l, c.k.numberedClassName(this.c.getArity()))});
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            listListOf = n.listOf((Object[]) new d0.e0.p.d.m0.g.a[]{b.access$getKFunctionClassId$cp(), new d0.e0.p.d.m0.g.a(k.d, c.l.numberedClassName(this.c.getArity()))});
        }
        d0.e0.p.d.m0.c.c0 containingDeclaration = b.access$getContainingDeclaration$p(this.c).getContainingDeclaration();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listListOf, 10));
        for (d0.e0.p.d.m0.g.a aVar : listListOf) {
            d0.e0.p.d.m0.c.e eVarFindClassAcrossModuleDependencies = w.findClassAcrossModuleDependencies(containingDeclaration, aVar);
            if (eVarFindClassAcrossModuleDependencies == null) {
                throw new IllegalStateException(("Built-in class " + aVar + " not found").toString());
            }
            List listTakeLast = u.takeLast(getParameters(), eVarFindClassAcrossModuleDependencies.getTypeConstructor().getParameters().size());
            ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(listTakeLast, 10));
            Iterator it = listTakeLast.iterator();
            while (it.hasNext()) {
                arrayList2.add(new y0(((z0) it.next()).getDefaultType()));
            }
            d0 d0Var = d0.a;
            arrayList.add(d0.simpleNotNullType(g.f.getEMPTY(), eVarFindClassAcrossModuleDependencies, arrayList2));
        }
        return u.toList(arrayList);
    }

    @Override // d0.e0.p.d.m0.n.g
    public x0 d() {
        return x0$a.a;
    }

    @Override // d0.e0.p.d.m0.n.b, d0.e0.p.d.m0.n.g, d0.e0.p.d.m0.n.u0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.e getDeclarationDescriptor() {
        return getDeclarationDescriptor();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public List<z0> getParameters() {
        return b.access$getParameters$p(this.c);
    }

    @Override // d0.e0.p.d.m0.n.u0
    public boolean isDenotable() {
        return true;
    }

    public String toString() {
        return getDeclarationDescriptor().toString();
    }

    @Override // d0.e0.p.d.m0.n.g, d0.e0.p.d.m0.n.u0
    public /* bridge */ /* synthetic */ h getDeclarationDescriptor() {
        return getDeclarationDescriptor();
    }

    @Override // d0.e0.p.d.m0.n.b, d0.e0.p.d.m0.n.g, d0.e0.p.d.m0.n.u0
    public b getDeclarationDescriptor() {
        return this.c;
    }
}
