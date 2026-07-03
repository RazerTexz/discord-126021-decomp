package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11663x;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.y */
/* JADX INFO: compiled from: methodSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11664y implements InterfaceC11663x<AbstractC11650k> {

    /* JADX INFO: renamed from: a */
    public static final C11664y f23637a = new C11664y();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11663x
    public AbstractC11913c0 commonSupertype(Collection<? extends AbstractC11913c0> collection) {
        C12238m.checkNotNullParameter(collection, "types");
        throw new AssertionError(C12238m.stringPlus("There should be no intersection type in existing descriptors, but found: ", C12163u.joinToString$default(collection, null, null, null, 0, null, null, 63, null)));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11663x
    public String getPredefinedFullInternalNameForClass(InterfaceC11330e interfaceC11330e) {
        return InterfaceC11663x.a.getPredefinedFullInternalNameForClass(this, interfaceC11330e);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11663x
    public String getPredefinedInternalNameForClass(InterfaceC11330e interfaceC11330e) {
        C12238m.checkNotNullParameter(interfaceC11330e, "classDescriptor");
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11663x
    public AbstractC11650k getPredefinedTypeForClass(InterfaceC11330e interfaceC11330e) {
        C12238m.checkNotNullParameter(interfaceC11330e, "classDescriptor");
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11663x
    public AbstractC11913c0 preprocessType(AbstractC11913c0 abstractC11913c0) {
        return InterfaceC11663x.a.preprocessType(this, abstractC11913c0);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11663x
    public void processErrorType(AbstractC11913c0 abstractC11913c0, InterfaceC11330e interfaceC11330e) {
        C12238m.checkNotNullParameter(abstractC11913c0, "kotlinType");
        C12238m.checkNotNullParameter(interfaceC11330e, "descriptor");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11663x
    public boolean releaseCoroutines() {
        return InterfaceC11663x.a.releaseCoroutines(this);
    }
}
