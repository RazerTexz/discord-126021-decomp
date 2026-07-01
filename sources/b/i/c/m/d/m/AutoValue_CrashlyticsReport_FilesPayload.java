package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.c.m.d.m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.m.d, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_FilesPayload.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_FilesPayload extends CrashlyticsReport.c {
    public final ImmutableList3<CrashlyticsReport.c.a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1716b;

    public AutoValue_CrashlyticsReport_FilesPayload(ImmutableList3 immutableList3, String str, a aVar) {
        this.a = immutableList3;
        this.f1716b = str;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.c
    @NonNull
    public ImmutableList3<CrashlyticsReport.c.a> a() {
        return this.a;
    }

    @Override // b.i.c.m.d.m.CrashlyticsReport.c
    @Nullable
    public String b() {
        return this.f1716b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.c)) {
            return false;
        }
        CrashlyticsReport.c cVar = (CrashlyticsReport.c) obj;
        if (this.a.equals(cVar.a())) {
            String str = this.f1716b;
            if (str == null) {
                if (cVar.b() == null) {
                    return true;
                }
            } else if (str.equals(cVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        String str = this.f1716b;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        StringBuilder sbU = outline.U("FilesPayload{files=");
        sbU.append(this.a);
        sbU.append(", orgId=");
        return outline.J(sbU, this.f1716b, "}");
    }
}
