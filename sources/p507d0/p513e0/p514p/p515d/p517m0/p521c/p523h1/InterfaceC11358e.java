package p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1;

import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.h1.e */
/* JADX INFO: compiled from: PlatformDependentTypeTransformer.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11358e {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.h1.e$a */
    /* JADX INFO: compiled from: PlatformDependentTypeTransformer.kt */
    public static final class a implements InterfaceC11358e {

        /* JADX INFO: renamed from: a */
        public static final a f22800a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11358e
        public AbstractC11934j0 transformPlatformType(C11712a c11712a, AbstractC11934j0 abstractC11934j0) {
            C12238m.checkNotNullParameter(c11712a, "classId");
            C12238m.checkNotNullParameter(abstractC11934j0, "computedType");
            return abstractC11934j0;
        }
    }

    AbstractC11934j0 transformPlatformType(C11712a c11712a, AbstractC11934j0 abstractC11934j0);
}
