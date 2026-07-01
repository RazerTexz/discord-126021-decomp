package d0.e0.p.d.m0.k.x;

import d0.e0.p.d.m0.c.b;
import d0.e0.p.d.m0.p.b$c;
import d0.t.n;
import java.util.Collection;

/* JADX INFO: compiled from: DescriptorUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$c implements b$c<b> {
    public final /* synthetic */ boolean a;

    public a$c(boolean z2) {
        this.a = z2;
    }

    @Override // d0.e0.p.d.m0.p.b$c
    public /* bridge */ /* synthetic */ Iterable<? extends b> getNeighbors(b bVar) {
        return getNeighbors2(bVar);
    }

    /* JADX INFO: renamed from: getNeighbors, reason: avoid collision after fix types in other method */
    public final Iterable<b> getNeighbors2(b bVar) {
        if (this.a) {
            bVar = bVar == null ? null : bVar.getOriginal();
        }
        Collection<? extends b> overriddenDescriptors = bVar != null ? bVar.getOverriddenDescriptors() : null;
        return overriddenDescriptors == null ? n.emptyList() : overriddenDescriptors;
    }
}
