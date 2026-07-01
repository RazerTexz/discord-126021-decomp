package d0.e0.p.d.m0.k;

import java.util.Collection;

/* JADX INFO: compiled from: OverridingStrategy.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j {
    public abstract void addFakeOverride(d0.e0.p.d.m0.c.b bVar);

    public abstract void inheritanceConflict(d0.e0.p.d.m0.c.b bVar, d0.e0.p.d.m0.c.b bVar2);

    public abstract void overrideConflict(d0.e0.p.d.m0.c.b bVar, d0.e0.p.d.m0.c.b bVar2);

    public void setOverriddenDescriptors(d0.e0.p.d.m0.c.b bVar, Collection<? extends d0.e0.p.d.m0.c.b> collection) {
        d0.z.d.m.checkNotNullParameter(bVar, "member");
        d0.z.d.m.checkNotNullParameter(collection, "overridden");
        bVar.setOverriddenDescriptors(collection);
    }
}
