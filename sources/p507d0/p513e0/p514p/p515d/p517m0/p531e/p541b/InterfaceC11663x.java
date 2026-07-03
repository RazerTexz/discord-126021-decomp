package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.x */
/* JADX INFO: compiled from: descriptorBasedTypeSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11663x<T> {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.x$a */
    /* JADX INFO: compiled from: descriptorBasedTypeSignatureMapping.kt */
    public static final class a {
        public static <T> String getPredefinedFullInternalNameForClass(InterfaceC11663x<? extends T> interfaceC11663x, InterfaceC11330e interfaceC11330e) {
            C12238m.checkNotNullParameter(interfaceC11663x, "this");
            C12238m.checkNotNullParameter(interfaceC11330e, "classDescriptor");
            return null;
        }

        public static <T> AbstractC11913c0 preprocessType(InterfaceC11663x<? extends T> interfaceC11663x, AbstractC11913c0 abstractC11913c0) {
            C12238m.checkNotNullParameter(interfaceC11663x, "this");
            C12238m.checkNotNullParameter(abstractC11913c0, "kotlinType");
            return null;
        }

        public static <T> boolean releaseCoroutines(InterfaceC11663x<? extends T> interfaceC11663x) {
            C12238m.checkNotNullParameter(interfaceC11663x, "this");
            return true;
        }
    }

    AbstractC11913c0 commonSupertype(Collection<AbstractC11913c0> collection);

    String getPredefinedFullInternalNameForClass(InterfaceC11330e interfaceC11330e);

    String getPredefinedInternalNameForClass(InterfaceC11330e interfaceC11330e);

    T getPredefinedTypeForClass(InterfaceC11330e interfaceC11330e);

    AbstractC11913c0 preprocessType(AbstractC11913c0 abstractC11913c0);

    void processErrorType(AbstractC11913c0 abstractC11913c0, InterfaceC11330e interfaceC11330e);

    boolean releaseCoroutines();
}
