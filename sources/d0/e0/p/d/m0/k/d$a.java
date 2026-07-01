package d0.e0.p.d.m0.k;

import d0.e0.p.d.m0.c.u0;
import java.util.Collections;

/* JADX INFO: compiled from: DescriptorFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$a extends d0.e0.p.d.m0.c.i1.g {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$a(d0.e0.p.d.m0.c.e eVar, u0 u0Var, boolean z2) {
        super(eVar, null, d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), true, d0.e0.p.d.m0.c.b$a.DECLARATION, u0Var);
        if (eVar == null) {
            a(0);
            throw null;
        }
        if (u0Var == null) {
            a(1);
            throw null;
        }
        initialize(Collections.emptyList(), e.getDefaultConstructorVisibility(eVar, z2));
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i != 1) {
            objArr[0] = "containingClass";
        } else {
            objArr[0] = "source";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }
}
