package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g0 */
/* JADX INFO: compiled from: PackageFragmentProviderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11337g0 implements InterfaceC11360i0 {

    /* JADX INFO: renamed from: a */
    public final Collection<InterfaceC11331e0> f22714a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g0$a */
    /* JADX INFO: compiled from: PackageFragmentProviderImpl.kt */
    public static final class a extends AbstractC12240o implements Function1<InterfaceC11331e0, C11713b> {

        /* JADX INFO: renamed from: j */
        public static final a f22715j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final C11713b invoke(InterfaceC11331e0 interfaceC11331e0) {
            C12238m.checkNotNullParameter(interfaceC11331e0, "it");
            return interfaceC11331e0.getFqName();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g0$b */
    /* JADX INFO: compiled from: PackageFragmentProviderImpl.kt */
    public static final class b extends AbstractC12240o implements Function1<C11713b, Boolean> {
        public final /* synthetic */ C11713b $fqName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C11713b c11713b) {
            super(1);
            this.$fqName = c11713b;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(C11713b c11713b) {
            return Boolean.valueOf(invoke2(c11713b));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(C11713b c11713b) {
            C12238m.checkNotNullParameter(c11713b, "it");
            return !c11713b.isRoot() && C12238m.areEqual(c11713b.parent(), this.$fqName);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C11337g0(Collection<? extends InterfaceC11331e0> collection) {
        C12238m.checkNotNullParameter(collection, "packageFragments");
        this.f22714a = collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11360i0
    public void collectPackageFragments(C11713b c11713b, Collection<InterfaceC11331e0> collection) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        C12238m.checkNotNullParameter(collection, "packageFragments");
        for (Object obj : this.f22714a) {
            if (C12238m.areEqual(((InterfaceC11331e0) obj).getFqName(), c11713b)) {
                collection.add(obj);
            }
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11334f0
    public List<InterfaceC11331e0> getPackageFragments(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        Collection<InterfaceC11331e0> collection = this.f22714a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (C12238m.areEqual(((InterfaceC11331e0) obj).getFqName(), c11713b)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11334f0
    public Collection<C11713b> getSubPackagesOf(C11713b c11713b, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        C12238m.checkNotNullParameter(function1, "nameFilter");
        return C12078q.toList(C12078q.filter(C12078q.map(C12163u.asSequence(this.f22714a), a.f22715j), new b(c11713b)));
    }
}
