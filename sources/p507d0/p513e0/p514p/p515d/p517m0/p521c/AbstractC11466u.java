package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.InterfaceC11780d;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.u */
/* JADX INFO: compiled from: DescriptorVisibility.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11466u {
    public final Integer compareTo(AbstractC11466u abstractC11466u) {
        C12238m.checkNotNullParameter(abstractC11466u, "visibility");
        return getDelegate().compareTo(abstractC11466u.getDelegate());
    }

    public abstract AbstractC11335f1 getDelegate();

    public abstract String getInternalDisplayName();

    public final boolean isPublicAPI() {
        return getDelegate().isPublicAPI();
    }

    public abstract boolean isVisible(InterfaceC11780d interfaceC11780d, InterfaceC11458q interfaceC11458q, InterfaceC11450m interfaceC11450m);

    public abstract AbstractC11466u normalize();

    public final String toString() {
        return getDelegate().toString();
    }
}
