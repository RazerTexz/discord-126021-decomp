package b.i.a.b.j.t.i;

import java.util.Objects;

/* JADX INFO: compiled from: AutoValue_PersistedEvent.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends h {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.b.j.i f797b;
    public final b.i.a.b.j.f c;

    public b(long j, b.i.a.b.j.i iVar, b.i.a.b.j.f fVar) {
        this.a = j;
        Objects.requireNonNull(iVar, "Null transportContext");
        this.f797b = iVar;
        Objects.requireNonNull(fVar, "Null event");
        this.c = fVar;
    }

    @Override // b.i.a.b.j.t.i.h
    public b.i.a.b.j.f a() {
        return this.c;
    }

    @Override // b.i.a.b.j.t.i.h
    public long b() {
        return this.a;
    }

    @Override // b.i.a.b.j.t.i.h
    public b.i.a.b.j.i c() {
        return this.f797b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.a == hVar.b() && this.f797b.equals(hVar.c()) && this.c.equals(hVar.a());
    }

    public int hashCode() {
        long j = this.a;
        return this.c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f797b.hashCode()) * 1000003);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("PersistedEvent{id=");
        sbU.append(this.a);
        sbU.append(", transportContext=");
        sbU.append(this.f797b);
        sbU.append(", event=");
        sbU.append(this.c);
        sbU.append("}");
        return sbU.toString();
    }
}
