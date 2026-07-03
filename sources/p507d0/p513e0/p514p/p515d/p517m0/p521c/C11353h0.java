package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.h0 */
/* JADX INFO: compiled from: PackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11353h0 {
    public static final void collectPackageFragmentsOptimizedIfPossible(InterfaceC11334f0 interfaceC11334f0, C11713b c11713b, Collection<InterfaceC11331e0> collection) {
        C12238m.checkNotNullParameter(interfaceC11334f0, "<this>");
        C12238m.checkNotNullParameter(c11713b, "fqName");
        C12238m.checkNotNullParameter(collection, "packageFragments");
        if (interfaceC11334f0 instanceof InterfaceC11360i0) {
            ((InterfaceC11360i0) interfaceC11334f0).collectPackageFragments(c11713b, collection);
        } else {
            collection.addAll(interfaceC11334f0.getPackageFragments(c11713b));
        }
    }

    public static final List<InterfaceC11331e0> packageFragments(InterfaceC11334f0 interfaceC11334f0, C11713b c11713b) {
        C12238m.checkNotNullParameter(interfaceC11334f0, "<this>");
        C12238m.checkNotNullParameter(c11713b, "fqName");
        ArrayList arrayList = new ArrayList();
        collectPackageFragmentsOptimizedIfPossible(interfaceC11334f0, c11713b, arrayList);
        return arrayList;
    }
}
