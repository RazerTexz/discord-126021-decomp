package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v;

/* JADX INFO: renamed from: b.i.c.m.d.m.s */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Log.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4692s extends AbstractC4695v.d.AbstractC13233d.c {

    /* JADX INFO: renamed from: a */
    public final String f12641a;

    public C4692s(String str, a aVar) {
        this.f12641a = str;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.AbstractC13233d.c
    @NonNull
    /* JADX INFO: renamed from: a */
    public String mo6606a() {
        return this.f12641a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC4695v.d.AbstractC13233d.c) {
            return this.f12641a.equals(((AbstractC4695v.d.AbstractC13233d.c) obj).mo6606a());
        }
        return false;
    }

    public int hashCode() {
        return this.f12641a.hashCode() ^ 1000003;
    }

    public String toString() {
        return C1643a.m822J(C1643a.m833U("Log{content="), this.f12641a, "}");
    }
}
