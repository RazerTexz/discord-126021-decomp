package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p228b.p231j.AbstractC2439f;
import p007b.p225i.p226a.p228b.p231j.AbstractC2442i;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.b */
/* JADX INFO: compiled from: AutoValue_PersistedEvent.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2493b extends AbstractC2499h {

    /* JADX INFO: renamed from: a */
    public final long f5417a;

    /* JADX INFO: renamed from: b */
    public final AbstractC2442i f5418b;

    /* JADX INFO: renamed from: c */
    public final AbstractC2439f f5419c;

    public C2493b(long j, AbstractC2442i abstractC2442i, AbstractC2439f abstractC2439f) {
        this.f5417a = j;
        Objects.requireNonNull(abstractC2442i, "Null transportContext");
        this.f5418b = abstractC2442i;
        Objects.requireNonNull(abstractC2439f, "Null event");
        this.f5419c = abstractC2439f;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.AbstractC2499h
    /* JADX INFO: renamed from: a */
    public AbstractC2439f mo2391a() {
        return this.f5419c;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.AbstractC2499h
    /* JADX INFO: renamed from: b */
    public long mo2392b() {
        return this.f5417a;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p238i.AbstractC2499h
    /* JADX INFO: renamed from: c */
    public AbstractC2442i mo2393c() {
        return this.f5418b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2499h)) {
            return false;
        }
        AbstractC2499h abstractC2499h = (AbstractC2499h) obj;
        return this.f5417a == abstractC2499h.mo2392b() && this.f5418b.equals(abstractC2499h.mo2393c()) && this.f5419c.equals(abstractC2499h.mo2391a());
    }

    public int hashCode() {
        long j = this.f5417a;
        return this.f5419c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f5418b.hashCode()) * 1000003);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("PersistedEvent{id=");
        sbM833U.append(this.f5417a);
        sbM833U.append(", transportContext=");
        sbM833U.append(this.f5418b);
        sbM833U.append(", event=");
        sbM833U.append(this.f5419c);
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
