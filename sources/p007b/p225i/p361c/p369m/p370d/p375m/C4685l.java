package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.c.m.d.m.l */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4685l extends AbstractC4695v.d.AbstractC13233d.a.b {

    /* JADX INFO: renamed from: a */
    public final C4696w<AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d> f12600a;

    /* JADX INFO: renamed from: b */
    public final AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13236b f12601b;

    /* JADX INFO: renamed from: c */
    public final AbstractC4695v.d.AbstractC13233d.a.b.c f12602c;

    /* JADX INFO: renamed from: d */
    public final C4696w<AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13235a> f12603d;

    public C4685l(C4696w c4696w, AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13236b abstractC13236b, AbstractC4695v.d.AbstractC13233d.a.b.c cVar, C4696w c4696w2, a aVar) {
        this.f12600a = c4696w;
        this.f12601b = abstractC13236b;
        this.f12602c = cVar;
        this.f12603d = c4696w2;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a.b
    @NonNull
    /* JADX INFO: renamed from: a */
    public C4696w<AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13235a> mo6574a() {
        return this.f12603d;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a.b
    @NonNull
    /* JADX INFO: renamed from: b */
    public AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13236b mo6575b() {
        return this.f12601b;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a.b
    @NonNull
    /* JADX INFO: renamed from: c */
    public AbstractC4695v.d.AbstractC13233d.a.b.c mo6576c() {
        return this.f12602c;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a.b
    @NonNull
    /* JADX INFO: renamed from: d */
    public C4696w<AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d> mo6577d() {
        return this.f12600a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4695v.d.AbstractC13233d.a.b)) {
            return false;
        }
        AbstractC4695v.d.AbstractC13233d.a.b bVar = (AbstractC4695v.d.AbstractC13233d.a.b) obj;
        return this.f12600a.equals(bVar.mo6577d()) && this.f12601b.equals(bVar.mo6575b()) && this.f12602c.equals(bVar.mo6576c()) && this.f12603d.equals(bVar.mo6574a());
    }

    public int hashCode() {
        return ((((((this.f12600a.hashCode() ^ 1000003) * 1000003) ^ this.f12601b.hashCode()) * 1000003) ^ this.f12602c.hashCode()) * 1000003) ^ this.f12603d.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Execution{threads=");
        sbM833U.append(this.f12600a);
        sbM833U.append(", exception=");
        sbM833U.append(this.f12601b);
        sbM833U.append(", signal=");
        sbM833U.append(this.f12602c);
        sbM833U.append(", binaries=");
        sbM833U.append(this.f12603d);
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
