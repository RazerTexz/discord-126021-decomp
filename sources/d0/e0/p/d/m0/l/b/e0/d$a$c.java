package d0.e0.p.d.m0.l.b.e0;

import java.util.List;

/* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a$c extends d0.e0.p.d.m0.k.i {
    public final /* synthetic */ List<D> a;

    public d$a$c(List<D> list) {
        this.a = list;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // d0.e0.p.d.m0.k.j
    public void addFakeOverride(d0.e0.p.d.m0.c.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fakeOverride");
        d0.e0.p.d.m0.k.k.resolveUnknownVisibilityForMember(bVar, null);
        this.a.add((D) bVar);
    }

    @Override // d0.e0.p.d.m0.k.i
    public void conflict(d0.e0.p.d.m0.c.b bVar, d0.e0.p.d.m0.c.b bVar2) {
        d0.z.d.m.checkNotNullParameter(bVar, "fromSuper");
        d0.z.d.m.checkNotNullParameter(bVar2, "fromCurrent");
    }
}
