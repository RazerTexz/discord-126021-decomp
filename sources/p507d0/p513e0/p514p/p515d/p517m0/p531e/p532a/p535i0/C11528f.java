package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.C12109h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11360i0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.C11542i;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11588u;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11896f;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11891a;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12033a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.f */
/* JADX INFO: compiled from: LazyJavaPackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11528f implements InterfaceC11360i0 {

    /* JADX INFO: renamed from: a */
    public final C11529g f23308a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC11891a<C11713b, C11542i> f23309b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.f$a */
    /* JADX INFO: compiled from: LazyJavaPackageFragmentProvider.kt */
    public static final class a extends AbstractC12240o implements Function0<C11542i> {
        public final /* synthetic */ InterfaceC11588u $jPackage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC11588u interfaceC11588u) {
            super(0);
            this.$jPackage = interfaceC11588u;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final C11542i invoke() {
            return new C11542i(C11528f.this.f23308a, this.$jPackage);
        }
    }

    public C11528f(C11524b c11524b) {
        C12238m.checkNotNullParameter(c11524b, "components");
        C11529g c11529g = new C11529g(c11524b, InterfaceC11533k.a.f23321a, C12109h.lazyOf(null));
        this.f23308a = c11529g;
        this.f23309b = c11529g.getStorageManager().createCacheWithNotNullValues();
    }

    /* JADX INFO: renamed from: a */
    public final C11542i m9461a(C11713b c11713b) {
        InterfaceC11588u interfaceC11588uFindPackage = this.f23308a.getComponents().getFinder().findPackage(c11713b);
        if (interfaceC11588uFindPackage == null) {
            return null;
        }
        return (C11542i) ((C11896f.d) this.f23309b).computeIfAbsent(c11713b, new a(interfaceC11588uFindPackage));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11360i0
    public void collectPackageFragments(C11713b c11713b, Collection<InterfaceC11331e0> collection) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        C12238m.checkNotNullParameter(collection, "packageFragments");
        C12033a.addIfNotNull(collection, m9461a(c11713b));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11334f0
    public List<C11542i> getPackageFragments(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        return C12147n.listOfNotNull(m9461a(c11713b));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11334f0
    public /* bridge */ /* synthetic */ Collection getSubPackagesOf(C11713b c11713b, Function1 function1) {
        return getSubPackagesOf(c11713b, (Function1<? super C11716e, Boolean>) function1);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11334f0
    public List<C11713b> getSubPackagesOf(C11713b c11713b, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        C12238m.checkNotNullParameter(function1, "nameFilter");
        C11542i c11542iM9461a = m9461a(c11713b);
        List<C11713b> subPackageFqNames$descriptors_jvm = c11542iM9461a == null ? null : c11542iM9461a.getSubPackageFqNames$descriptors_jvm();
        return subPackageFqNames$descriptors_jvm != null ? subPackageFqNames$descriptors_jvm : C12147n.emptyList();
    }
}
