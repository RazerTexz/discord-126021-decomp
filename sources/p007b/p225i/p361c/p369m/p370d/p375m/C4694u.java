package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.c.m.d.m.u */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_User.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4694u extends AbstractC4695v.d.f {

    /* JADX INFO: renamed from: a */
    public final String f12646a;

    public C4694u(String str, a aVar) {
        this.f12646a = str;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.d.f
    @NonNull
    /* JADX INFO: renamed from: a */
    public String mo6611a() {
        return this.f12646a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC4695v.d.f) {
            return this.f12646a.equals(((AbstractC4695v.d.f) obj).mo6611a());
        }
        return false;
    }

    public int hashCode() {
        return this.f12646a.hashCode() ^ 1000003;
    }

    public String toString() {
        return C1643a.m822J(C1643a.m833U("User{identifier="), this.f12646a, "}");
    }
}
