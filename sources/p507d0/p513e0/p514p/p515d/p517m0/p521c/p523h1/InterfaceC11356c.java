package p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.h1.c */
/* JADX INFO: compiled from: PlatformDependentDeclarationFilter.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11356c {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.h1.c$a */
    /* JADX INFO: compiled from: PlatformDependentDeclarationFilter.kt */
    public static final class a implements InterfaceC11356c {

        /* JADX INFO: renamed from: a */
        public static final a f22797a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11356c
        public boolean isFunctionAvailable(InterfaceC11330e interfaceC11330e, InterfaceC11465t0 interfaceC11465t0) {
            C12238m.checkNotNullParameter(interfaceC11330e, "classDescriptor");
            C12238m.checkNotNullParameter(interfaceC11465t0, "functionDescriptor");
            return true;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.h1.c$b */
    /* JADX INFO: compiled from: PlatformDependentDeclarationFilter.kt */
    public static final class b implements InterfaceC11356c {

        /* JADX INFO: renamed from: a */
        public static final b f22798a = new b();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11356c
        public boolean isFunctionAvailable(InterfaceC11330e interfaceC11330e, InterfaceC11465t0 interfaceC11465t0) {
            C12238m.checkNotNullParameter(interfaceC11330e, "classDescriptor");
            C12238m.checkNotNullParameter(interfaceC11465t0, "functionDescriptor");
            return !interfaceC11465t0.getAnnotations().hasAnnotation(C11357d.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME());
        }
    }

    boolean isFunctionAvailable(InterfaceC11330e interfaceC11330e, InterfaceC11465t0 interfaceC11465t0);
}
