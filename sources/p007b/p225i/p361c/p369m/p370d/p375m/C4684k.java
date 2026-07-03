package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v;

/* JADX INFO: renamed from: b.i.c.m.d.m.k */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4684k extends AbstractC4695v.d.AbstractC13233d.a {

    /* JADX INFO: renamed from: a */
    public final AbstractC4695v.d.AbstractC13233d.a.b f12592a;

    /* JADX INFO: renamed from: b */
    public final C4696w<AbstractC4695v.b> f12593b;

    /* JADX INFO: renamed from: c */
    public final Boolean f12594c;

    /* JADX INFO: renamed from: d */
    public final int f12595d;

    /* JADX INFO: renamed from: b.i.c.m.d.m.k$b */
    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application.java */
    public static final class b extends AbstractC4695v.d.AbstractC13233d.a.AbstractC13234a {

        /* JADX INFO: renamed from: a */
        public AbstractC4695v.d.AbstractC13233d.a.b f12596a;

        /* JADX INFO: renamed from: b */
        public C4696w<AbstractC4695v.b> f12597b;

        /* JADX INFO: renamed from: c */
        public Boolean f12598c;

        /* JADX INFO: renamed from: d */
        public Integer f12599d;

        public b() {
        }

        /* JADX INFO: renamed from: a */
        public AbstractC4695v.d.AbstractC13233d.a m6573a() {
            String strM883w = this.f12596a == null ? " execution" : "";
            if (this.f12599d == null) {
                strM883w = C1643a.m883w(strM883w, " uiOrientation");
            }
            if (strM883w.isEmpty()) {
                return new C4684k(this.f12596a, this.f12597b, this.f12598c, this.f12599d.intValue(), null);
            }
            throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w));
        }

        public b(AbstractC4695v.d.AbstractC13233d.a aVar, a aVar2) {
            C4684k c4684k = (C4684k) aVar;
            this.f12596a = c4684k.f12592a;
            this.f12597b = c4684k.f12593b;
            this.f12598c = c4684k.f12594c;
            this.f12599d = Integer.valueOf(c4684k.f12595d);
        }
    }

    public C4684k(AbstractC4695v.d.AbstractC13233d.a.b bVar, C4696w c4696w, Boolean bool, int i, a aVar) {
        this.f12592a = bVar;
        this.f12593b = c4696w;
        this.f12594c = bool;
        this.f12595d = i;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a
    @Nullable
    /* JADX INFO: renamed from: a */
    public Boolean mo6568a() {
        return this.f12594c;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a
    @Nullable
    /* JADX INFO: renamed from: b */
    public C4696w<AbstractC4695v.b> mo6569b() {
        return this.f12593b;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a
    @NonNull
    /* JADX INFO: renamed from: c */
    public AbstractC4695v.d.AbstractC13233d.a.b mo6570c() {
        return this.f12592a;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a
    /* JADX INFO: renamed from: d */
    public int mo6571d() {
        return this.f12595d;
    }

    /* JADX INFO: renamed from: e */
    public AbstractC4695v.d.AbstractC13233d.a.AbstractC13234a m6572e() {
        return new b(this, null);
    }

    public boolean equals(Object obj) {
        C4696w<AbstractC4695v.b> c4696w;
        Boolean bool;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4695v.d.AbstractC13233d.a)) {
            return false;
        }
        AbstractC4695v.d.AbstractC13233d.a aVar = (AbstractC4695v.d.AbstractC13233d.a) obj;
        return this.f12592a.equals(aVar.mo6570c()) && ((c4696w = this.f12593b) != null ? c4696w.equals(aVar.mo6569b()) : aVar.mo6569b() == null) && ((bool = this.f12594c) != null ? bool.equals(aVar.mo6568a()) : aVar.mo6568a() == null) && this.f12595d == aVar.mo6571d();
    }

    public int hashCode() {
        int iHashCode = (this.f12592a.hashCode() ^ 1000003) * 1000003;
        C4696w<AbstractC4695v.b> c4696w = this.f12593b;
        int iHashCode2 = (iHashCode ^ (c4696w == null ? 0 : c4696w.hashCode())) * 1000003;
        Boolean bool = this.f12594c;
        return ((iHashCode2 ^ (bool != null ? bool.hashCode() : 0)) * 1000003) ^ this.f12595d;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Application{execution=");
        sbM833U.append(this.f12592a);
        sbM833U.append(", customAttributes=");
        sbM833U.append(this.f12593b);
        sbM833U.append(", background=");
        sbM833U.append(this.f12594c);
        sbM833U.append(", uiOrientation=");
        return C1643a.m814B(sbM833U, this.f12595d, "}");
    }
}
