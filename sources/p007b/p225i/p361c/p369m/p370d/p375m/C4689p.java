package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.c.m.d.m.p */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4689p extends AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d {

    /* JADX INFO: renamed from: a */
    public final String f12616a;

    /* JADX INFO: renamed from: b */
    public final int f12617b;

    /* JADX INFO: renamed from: c */
    public final C4696w<AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a> f12618c;

    public C4689p(String str, int i, C4696w c4696w, a aVar) {
        this.f12616a = str;
        this.f12617b = i;
        this.f12618c = c4696w;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d
    @NonNull
    /* JADX INFO: renamed from: a */
    public C4696w<AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a> mo6590a() {
        return this.f12618c;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d
    /* JADX INFO: renamed from: b */
    public int mo6591b() {
        return this.f12617b;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d
    @NonNull
    /* JADX INFO: renamed from: c */
    public String mo6592c() {
        return this.f12616a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d)) {
            return false;
        }
        AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d abstractC13237d = (AbstractC4695v.d.AbstractC13233d.a.b.AbstractC13237d) obj;
        return this.f12616a.equals(abstractC13237d.mo6592c()) && this.f12617b == abstractC13237d.mo6591b() && this.f12618c.equals(abstractC13237d.mo6590a());
    }

    public int hashCode() {
        return ((((this.f12616a.hashCode() ^ 1000003) * 1000003) ^ this.f12617b) * 1000003) ^ this.f12618c.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Thread{name=");
        sbM833U.append(this.f12616a);
        sbM833U.append(", importance=");
        sbM833U.append(this.f12617b);
        sbM833U.append(", frames=");
        sbM833U.append(this.f12618c);
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
