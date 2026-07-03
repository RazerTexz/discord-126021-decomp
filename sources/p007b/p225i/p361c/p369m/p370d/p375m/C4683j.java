package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v;

/* JADX INFO: renamed from: b.i.c.m.d.m.j */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4683j extends AbstractC4695v.d.AbstractC13233d {

    /* JADX INFO: renamed from: a */
    public final long f12587a;

    /* JADX INFO: renamed from: b */
    public final String f12588b;

    /* JADX INFO: renamed from: c */
    public final AbstractC4695v.d.AbstractC13233d.a f12589c;

    /* JADX INFO: renamed from: d */
    public final AbstractC4695v.d.AbstractC13233d.b f12590d;

    /* JADX INFO: renamed from: e */
    public final AbstractC4695v.d.AbstractC13233d.c f12591e;

    public C4683j(long j, String str, AbstractC4695v.d.AbstractC13233d.a aVar, AbstractC4695v.d.AbstractC13233d.b bVar, AbstractC4695v.d.AbstractC13233d.c cVar, a aVar2) {
        this.f12587a = j;
        this.f12588b = str;
        this.f12589c = aVar;
        this.f12590d = bVar;
        this.f12591e = cVar;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d
    @NonNull
    /* JADX INFO: renamed from: a */
    public AbstractC4695v.d.AbstractC13233d.a mo6563a() {
        return this.f12589c;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d
    @NonNull
    /* JADX INFO: renamed from: b */
    public AbstractC4695v.d.AbstractC13233d.b mo6564b() {
        return this.f12590d;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d
    @Nullable
    /* JADX INFO: renamed from: c */
    public AbstractC4695v.d.AbstractC13233d.c mo6565c() {
        return this.f12591e;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d
    /* JADX INFO: renamed from: d */
    public long mo6566d() {
        return this.f12587a;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d
    @NonNull
    /* JADX INFO: renamed from: e */
    public String mo6567e() {
        return this.f12588b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4695v.d.AbstractC13233d)) {
            return false;
        }
        AbstractC4695v.d.AbstractC13233d abstractC13233d = (AbstractC4695v.d.AbstractC13233d) obj;
        if (this.f12587a == abstractC13233d.mo6566d() && this.f12588b.equals(abstractC13233d.mo6567e()) && this.f12589c.equals(abstractC13233d.mo6563a()) && this.f12590d.equals(abstractC13233d.mo6564b())) {
            AbstractC4695v.d.AbstractC13233d.c cVar = this.f12591e;
            if (cVar == null) {
                if (abstractC13233d.mo6565c() == null) {
                    return true;
                }
            } else if (cVar.equals(abstractC13233d.mo6565c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.f12587a;
        int iHashCode = (((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f12588b.hashCode()) * 1000003) ^ this.f12589c.hashCode()) * 1000003) ^ this.f12590d.hashCode()) * 1000003;
        AbstractC4695v.d.AbstractC13233d.c cVar = this.f12591e;
        return (cVar == null ? 0 : cVar.hashCode()) ^ iHashCode;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Event{timestamp=");
        sbM833U.append(this.f12587a);
        sbM833U.append(", type=");
        sbM833U.append(this.f12588b);
        sbM833U.append(", app=");
        sbM833U.append(this.f12589c);
        sbM833U.append(", device=");
        sbM833U.append(this.f12590d);
        sbM833U.append(", log=");
        sbM833U.append(this.f12591e);
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
