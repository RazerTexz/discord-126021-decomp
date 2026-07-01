package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.e.a.k0.c0;
import d0.e0.p.d.m0.e.a.k0.u;
import d0.t.n0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LazyJavaPackageScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends r {
    public final u n;
    public final i o;
    public final d0.e0.p.d.m0.m.k<Set<String>> p;
    public final d0.e0.p.d.m0.m.i<j$a, d0.e0.p.d.m0.c.e> q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(d0.e0.p.d.m0.e.a.i0.g gVar, u uVar, i iVar) {
        super(gVar);
        d0.z.d.m.checkNotNullParameter(gVar, "c");
        d0.z.d.m.checkNotNullParameter(uVar, "jPackage");
        d0.z.d.m.checkNotNullParameter(iVar, "ownerDescriptor");
        this.n = uVar;
        this.o = iVar;
        this.p = gVar.getStorageManager().createNullableLazyValue(new j$d(gVar, this));
        this.q = gVar.getStorageManager().createMemoizedFunctionWithNullableValues(new j$c(this, gVar));
    }

    public static final j$b access$resolveKotlinBinaryClass(j jVar, d0.e0.p.d.m0.e.b.p pVar) {
        Objects.requireNonNull(jVar);
        if (pVar == null) {
            return j$b$b.a;
        }
        if (pVar.getClassHeader().getKind() != d0.e0.p.d.m0.e.b.b0.a$a.CLASS) {
            return j$b$c.a;
        }
        d0.e0.p.d.m0.c.e eVarResolveClass = jVar.c.getComponents().getDeserializedDescriptorResolver().resolveClass(pVar);
        return eVarResolveClass != null ? new j$b$a(eVarResolveClass) : j$b$b.a;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public Set<d0.e0.p.d.m0.g.e> a(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        if (!dVar.acceptsKinds(d0.e0.p.d.m0.k.a0.d.a.getNON_SINGLETON_CLASSIFIERS_MASK())) {
            return n0.emptySet();
        }
        Set<String> setInvoke = this.p.invoke();
        if (setInvoke != null) {
            HashSet hashSet = new HashSet();
            Iterator<T> it = setInvoke.iterator();
            while (it.hasNext()) {
                hashSet.add(d0.e0.p.d.m0.g.e.identifier((String) it.next()));
            }
            return hashSet;
        }
        u uVar = this.n;
        if (function1 == null) {
            function1 = d0.e0.p.d.m0.p.d.alwaysTrue();
        }
        Collection<d0.e0.p.d.m0.e.a.k0.g> classes = uVar.getClasses(function1);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (d0.e0.p.d.m0.e.a.k0.g gVar : classes) {
            d0.e0.p.d.m0.g.e name = gVar.getLightClassOriginKind() == c0.SOURCE ? null : gVar.getName();
            if (name != null) {
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public Set<d0.e0.p.d.m0.g.e> b(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        return n0.emptySet();
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public b d() {
        return b$a.a;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public void f(Collection<t0> collection, d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(collection, "result");
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
    }

    public final d0.e0.p.d.m0.c.e findClassifierByJavaClass$descriptors_jvm(d0.e0.p.d.m0.e.a.k0.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "javaClass");
        return o(gVar.getName(), gVar);
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.h getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        return getContributedClassifier(eVar, bVar);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x005b  */
    @Override // d0.e0.p.d.m0.e.a.i0.l.k, d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public Collection<d0.e0.p.d.m0.c.m> getContributedDescriptors(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        boolean z2;
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        d0.e0.p.d.m0.k.a0.d$a d_a = d0.e0.p.d.m0.k.a0.d.a;
        if (!dVar.acceptsKinds(d_a.getNON_SINGLETON_CLASSIFIERS_MASK() | d_a.getCLASSIFIERS_MASK())) {
            return d0.t.n.emptyList();
        }
        Collection<d0.e0.p.d.m0.c.m> collectionInvoke = this.e.invoke();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionInvoke) {
            d0.e0.p.d.m0.c.m mVar = (d0.e0.p.d.m0.c.m) obj;
            if (mVar instanceof d0.e0.p.d.m0.c.e) {
                d0.e0.p.d.m0.g.e name = ((d0.e0.p.d.m0.c.e) mVar).getName();
                d0.z.d.m.checkNotNullExpressionValue(name, "it.name");
                if (function1.invoke(name).booleanValue()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (z2) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k, d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Collection<d0.e0.p.d.m0.c.n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public Set<d0.e0.p.d.m0.g.e> h(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        return n0.emptySet();
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.k
    public d0.e0.p.d.m0.c.m j() {
        return this.o;
    }

    public final d0.e0.p.d.m0.c.e o(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.e.a.k0.g gVar) {
        if (!d0.e0.p.d.m0.g.g.isSafeIdentifier(eVar)) {
            return null;
        }
        Set<String> setInvoke = this.p.invoke();
        if (gVar != null || setInvoke == null || setInvoke.contains(eVar.asString())) {
            return this.q.invoke(new j$a(eVar, gVar));
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public d0.e0.p.d.m0.c.e getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return o(eVar, null);
    }
}
