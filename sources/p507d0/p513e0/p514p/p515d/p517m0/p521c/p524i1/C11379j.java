package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11353h0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11334f0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11360i0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.j */
/* JADX INFO: compiled from: CompositePackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11379j implements InterfaceC11360i0 {

    /* JADX INFO: renamed from: a */
    public final List<InterfaceC11334f0> f22886a;

    /* JADX WARN: Multi-variable type inference failed */
    public C11379j(List<? extends InterfaceC11334f0> list) {
        C12238m.checkNotNullParameter(list, "providers");
        this.f22886a = list;
        list.size();
        C12163u.toSet(list).size();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11360i0
    public void collectPackageFragments(C11713b c11713b, Collection<InterfaceC11331e0> collection) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        C12238m.checkNotNullParameter(collection, "packageFragments");
        Iterator<InterfaceC11334f0> it = this.f22886a.iterator();
        while (it.hasNext()) {
            C11353h0.collectPackageFragmentsOptimizedIfPossible(it.next(), c11713b, collection);
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11334f0
    public List<InterfaceC11331e0> getPackageFragments(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        ArrayList arrayList = new ArrayList();
        Iterator<InterfaceC11334f0> it = this.f22886a.iterator();
        while (it.hasNext()) {
            C11353h0.collectPackageFragmentsOptimizedIfPossible(it.next(), c11713b, arrayList);
        }
        return C12163u.toList(arrayList);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11334f0
    public Collection<C11713b> getSubPackagesOf(C11713b c11713b, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        C12238m.checkNotNullParameter(function1, "nameFilter");
        HashSet hashSet = new HashSet();
        Iterator<InterfaceC11334f0> it = this.f22886a.iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().getSubPackagesOf(c11713b, function1));
        }
        return hashSet;
    }
}
