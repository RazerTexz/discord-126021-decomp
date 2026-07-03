package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v;

/* JADX INFO: renamed from: b.i.c.m.d.m.d */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_FilesPayload.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4677d extends AbstractC4695v.c {

    /* JADX INFO: renamed from: a */
    public final C4696w<AbstractC4695v.c.a> f12536a;

    /* JADX INFO: renamed from: b */
    public final String f12537b;

    public C4677d(C4696w c4696w, String str, a aVar) {
        this.f12536a = c4696w;
        this.f12537b = str;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.c
    @NonNull
    /* JADX INFO: renamed from: a */
    public C4696w<AbstractC4695v.c.a> mo6527a() {
        return this.f12536a;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.c
    @Nullable
    /* JADX INFO: renamed from: b */
    public String mo6528b() {
        return this.f12537b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4695v.c)) {
            return false;
        }
        AbstractC4695v.c cVar = (AbstractC4695v.c) obj;
        if (this.f12536a.equals(cVar.mo6527a())) {
            String str = this.f12537b;
            if (str == null) {
                if (cVar.mo6528b() == null) {
                    return true;
                }
            } else if (str.equals(cVar.mo6528b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f12536a.hashCode() ^ 1000003) * 1000003;
        String str = this.f12537b;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("FilesPayload{files=");
        sbM833U.append(this.f12536a);
        sbM833U.append(", orgId=");
        return C1643a.m822J(sbM833U, this.f12537b, "}");
    }
}
