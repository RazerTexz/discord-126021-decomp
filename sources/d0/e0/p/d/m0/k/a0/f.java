package d0.e0.p.d.m0.k.a0;

import java.util.ArrayList;

/* JADX INFO: compiled from: GivenFunctionsMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends d0.e0.p.d.m0.k.i {
    public final /* synthetic */ ArrayList<d0.e0.p.d.m0.c.m> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f3457b;

    public f(ArrayList<d0.e0.p.d.m0.c.m> arrayList, e eVar) {
        this.a = arrayList;
        this.f3457b = eVar;
    }

    @Override // d0.e0.p.d.m0.k.j
    public void addFakeOverride(d0.e0.p.d.m0.c.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fakeOverride");
        d0.e0.p.d.m0.k.k.resolveUnknownVisibilityForMember(bVar, null);
        this.a.add(bVar);
    }

    @Override // d0.e0.p.d.m0.k.i
    public void conflict(d0.e0.p.d.m0.c.b bVar, d0.e0.p.d.m0.c.b bVar2) {
        d0.z.d.m.checkNotNullParameter(bVar, "fromSuper");
        d0.z.d.m.checkNotNullParameter(bVar2, "fromCurrent");
        throw new IllegalStateException(("Conflict in scope of " + this.f3457b.c + ": " + bVar + " vs " + bVar2).toString());
    }
}
