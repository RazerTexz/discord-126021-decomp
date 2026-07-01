package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: LazyJavaPackageScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$a {
    public final d0.e0.p.d.m0.g.e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.e.a.k0.g f3334b;

    public j$a(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.e.a.k0.g gVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.a = eVar;
        this.f3334b = gVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof j$a) && d0.z.d.m.areEqual(this.a, ((j$a) obj).a);
    }

    public final d0.e0.p.d.m0.e.a.k0.g getJavaClass() {
        return this.f3334b;
    }

    public final d0.e0.p.d.m0.g.e getName() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
